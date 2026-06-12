package com.adl.service.repository.prepare;

import android.text.TextUtils;

import com.adl.service.callback.RequestUserCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.IDefine;
import com.adl.service.common.InnerPreferences;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.DictData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.PageSummaryData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.DictEntity;
import com.adl.service.db.entity.LoginInfoEntity;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.internal.CallerManager;
import com.adl.service.log.NzLog;
import com.adl.service.repository.cache.CacheTag;
import com.adl.service.repository.cache.MemoryCacheManager;
import com.adl.service.utils.CommonUtil;
import com.adl.service.utils.InnerUtil;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoPrepareHelper {

    private boolean forceUpdateLoginInfo = false;

    public CommonInfoPrepareHelper() {
    }

    public Function<EmptyRequest, Single<ResponseResult<Boolean>>> createLoadCommonInfoFunc(boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback) {
        return (v) -> {
            NzLog.i("开始全量同步 : forceUpdate : " + forceUpdate + ", faceType : " + faceType + ", pageSize : " + pageSize);
            InnerPreferences pf = InnerPreferences.instance();
            if (forceUpdate) {
                pf.putLong(IDefine.LAST_STUDENT_UPDATE_TIME, IDefine.INVALID_TIME);
                pf.putLong(IDefine.LAST_TEACHER_UPDATE_TIME, IDefine.INVALID_TIME);
                pf.putLong(IDefine.LAST_CITIZEN_UPDATE_TIME, IDefine.INVALID_TIME);
            }

            ////////////// 1.同步机构信息 ////////////
            NzLog.i("同步机构信息");
            callback.nextStatus(IDefine.SYNC_ORG_STATUS, "正在同步机构信息");
            //启动时，请求一次机构信息，如果机构变更，清除数据标识
            LoginInfoData loginInfo = CallerManager.getInstance().getCommonNativeCaller().getLoginInfoSync();
            boolean needUpdate = forceUpdate ? true : forceUpdateLoginInfo;
            forceUpdateLoginInfo = false;
            ResponseResult<LoginInfoData> responseResult = CallerManager.getInstance().getCommonInfoCaller().getLoginInfoSync(EmptyRequest.builder().forceUpdate(needUpdate).build());
            if (!responseResult.isSuccessWithData()) {
                NzLog.w("无法拉取机构信息 : " + responseResult.getMsg());
            }
            String oldOrgId = loginInfo == null ? null : loginInfo.getOrgId();
            String newOrgId = responseResult.getData() == null ? null : responseResult.getData().getOrgId();
            if (!TextUtils.isEmpty(newOrgId) && !TextUtils.equals(newOrgId, oldOrgId)) {
                NzLog.w("清除本地学生数据");
                DaoManagerProxy.getInstance().getStudentDao().clearAll();
                NzLog.w("清除本地老师数据");
                DaoManagerProxy.getInstance().getTeacherDao().clearAll();
                CallerManager.getInstance().getDownloadFileCaller().clearAllFace();
                pf.putLong(IDefine.LAST_STUDENT_UPDATE_TIME, IDefine.INVALID_TIME);
                pf.putLong(IDefine.LAST_TEACHER_UPDATE_TIME, IDefine.INVALID_TIME);
                pf.putLong(IDefine.LAST_CITIZEN_UPDATE_TIME, IDefine.INVALID_TIME);
                callback.orgChange(newOrgId, oldOrgId);
            }

            ////////////// 2.同步学生基本信息 ////////////
            NzLog.i("同步学生信息");
            ResponseResult<Long> serverTimeResult = CallerManager.getInstance().getCommonInfoCaller().getServerTimeSync();
            long serverTime = 0L;
            if (serverTimeResult.getCode() == NzResponseCode.NZ_SUCCESS && serverTimeResult.getData() != null) {
                serverTime = serverTimeResult.getData();
            }
            callback.nextStatus(IDefine.SYNC_STUDENT_STATUS, "正在初始化学生信息");
            int size = CallerManager.getInstance().getUserNativeCaller().queryAllStudentCountSync();
            long lastTime = pf.readLong(IDefine.LAST_STUDENT_UPDATE_TIME);
            long recentUpdateTime = CallerManager.getInstance().getUserNativeCaller().queryStudentRecentUpdateTimeSync();
            NzLog.d("同步学生信息 : 本地学生个数 : " + size + "; forceUpdate : " + forceUpdate + "; 服务端时间 : " + serverTime + "; 上次学生更新时间 : " + lastTime + "; 最近学生更新时间 : " + recentUpdateTime);
            // 数据会空，或者时间间隔2分钟
            if (size == 0 || forceUpdate || serverTime - lastTime > IDefine.UPDATE_INTERVAL_TIME) {
                // 是否强制更新数据
                boolean needForceUpdate = forceUpdate ? true : lastTime == IDefine.INVALID_TIME ? true : false;
                String lastUpdateTime = needForceUpdate ? null : InnerUtil.formatByTimeCode(recentUpdateTime);

                StudentPageRequest studentPageRequest = StudentPageRequest.builder()
                        .forceUpdate(needForceUpdate)
                        .current(1L)
                        .pageSize(pageSize)
                        .faceType(faceType)
                        .lastUpdateTime(lastUpdateTime)
                        .build();
                ResponseResult<PageSummaryData> studentResult = CallerManager.getInstance().getCommonInfoCaller().getStudentPagesAllSync(studentPageRequest, callback);
                if (studentResult.getCode() == NzResponseCode.NZ_SUCCESS && studentResult.getData() != null) {
                    NzLog.i("学生入库完成，共入库：" + studentResult.getData().getPersistedCount());
                    pf.putLong(IDefine.LAST_STUDENT_UPDATE_TIME, serverTime);
                } else {
                    NzLog.e("无法拉取全量学生");
                }
            } else {
                NzLog.i("无需拉取全量学生");
            }

            ////////////// 3.同步老师基本信息 ////////////
            NzLog.i("同步老师信息");
            callback.nextStatus(IDefine.SYNC_TEACHER_STATUS, "正在初始化老师信息");
            size = DaoManagerProxy.getInstance().getTeacherDao().countSize();
            lastTime = pf.readLong(IDefine.LAST_TEACHER_UPDATE_TIME);
            NzLog.d("同步老师信息 : 本地老师个数 : " + size + "; forceUpdate : " + forceUpdate + "; 服务端时间 : " + serverTime + "; 上次老师更新时间 : " + lastTime);

            // 数据会空，或者时间间隔2分钟
            if (size == 0 || forceUpdate || serverTime - lastTime > IDefine.UPDATE_INTERVAL_TIME) {
                // 是否强制更新数据
                boolean needForceUpdate = forceUpdate ? true : lastTime == IDefine.INVALID_TIME ? true : false;
                String lastUpdateTime = needForceUpdate ? null : InnerUtil.formatByTimeCode(lastTime);

                TeacherPageRequest teacherPageRequest = TeacherPageRequest.builder()
                        .forceUpdate(needForceUpdate)
                        .current(1L)
                        .pageSize(pageSize)
                        .lastUpdateTime(lastUpdateTime)
                        .build();
                ResponseResult<PageSummaryData> teacherResult = CallerManager.getInstance().getCommonInfoCaller().getTeacherPagesAllSync(teacherPageRequest, callback);
                if (teacherResult.getCode() == NzResponseCode.NZ_SUCCESS && teacherResult.getData() != null) {
                    NzLog.i("老师入库完成，共入库：" + teacherResult.getData().getPersistedCount());
                    pf.putLong(IDefine.LAST_TEACHER_UPDATE_TIME, serverTime);
                } else {
                    NzLog.e("无法拉取全量老师");
                }
            } else {
                NzLog.i("无需拉取全量老师");
            }
            NzLog.i("结束全量同步");
            callback.nextStatus(IDefine.SYNC_COMPLETE_STATUS, "执行完成");
            return Single.just(CommonUtil.createSuccessResponseResult(Boolean.TRUE));
        };
    }

    public Function<TeacherPageRequest, Single<ResponseResult<List<TeacherData>>>> createPrepareTeacherPagesAllFunc() {
        return (request) -> {
            if (request.getForceUpdate()) {
                NzLog.w("清除本地老师数据");
                DaoManagerProxy.getInstance().getTeacherDao().clearAll();
            }
            return null;
        };
    }

    public Function<StudentPageRequest, Single<ResponseResult<List<StudentData>>>> createPrepareStudentPagesAllFunc() {
        return (request) -> {
            if (request.getForceUpdate()) {
                NzLog.w("清除本地学生数据");
                DaoManagerProxy.getInstance().getStudentDao().clearAll();
            }
            return null;
        };
    }

    public Function<EmptyRequest, Single<ResponseResult<LoginInfoData>>> createPrepareLoginInfoFunc() {
        return (request) -> {
            if (request == null) {
                return null;
            }
            if (request.getForceUpdate()) {
                return null;
            }
            LoginInfoData data = (LoginInfoData) MemoryCacheManager.getInstance().get(CacheTag.CACHE_TAG_LOGIN_INFO + InnerUtil.toJson(request));
            if (data != null) {
                return Single.just(CommonUtil.createSuccessResponseResult(data));
            }
            LoginInfoEntity entity = DaoManagerProxy.getInstance().getLoginInfoDao().getLoginInfo();
            if (entity == null) {
                return null;
            }
            if (entity.getExpiredTime() <= System.currentTimeMillis()) {
                return null;
            }
            data = LoginInfoEntity.convertToData(entity);
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_LOGIN_INFO + InnerUtil.toJson(request), data, entity.getExpiredTime() - System.currentTimeMillis());
            return Single.just(CommonUtil.createSuccessResponseResult(data));
        };
    }

    public Function<DictRequest, Single<ResponseResult<List<DictData>>>> createPrepareDictListFunc() {
        return (request) -> {
            List<DictData> data = (List<DictData>) MemoryCacheManager.getInstance().get(CacheTag.CACHE_TAG_DICT_LIST + InnerUtil.toJson(request));
            if (data != null) {
                return Single.just(CommonUtil.createSuccessResponseResult(data));
            }
            List<DictEntity> entities = DaoManagerProxy.getInstance().getDictDao().queryDictByDictCode(request.getDictId());
            if (entities == null || entities.isEmpty()) {
                return null;
            }
            long expiredTime = entities.get(0).getExpiredTime();
            if (expiredTime < System.currentTimeMillis()) {
                return null;
            }
            data = entities.stream()
                    .map(DictEntity::convertToData)
                    .collect(Collectors.toList());
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_DICT_LIST + InnerUtil.toJson(request), data, expiredTime - System.currentTimeMillis());

            return Single.just(CommonUtil.createSuccessResponseResult(data));
        };
    }
}
