package com.adl.service.repository.persist;

import android.text.TextUtils;

import com.adl.service.callback.GetPageResult;
import com.adl.service.callback.RequestUserCallback;
import com.adl.service.common.IDefine;
import com.adl.service.common.InnerPreferences;
import com.adl.service.data.DictData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.DictEntity;
import com.adl.service.db.entity.LoginInfoEntity;
import com.adl.service.db.entity.StudentEntity;
import com.adl.service.db.entity.TeacherEntity;
import com.adl.service.exception.NzCommonException;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.internal.CallerManager;
import com.adl.service.log.NzLog;
import com.adl.service.repository.cache.CacheTag;
import com.adl.service.repository.cache.MemoryCacheManager;
import com.adl.service.utils.InnerUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoPersistHelper {

    private boolean forceUpdateLoginInfo = false;

    public CommonInfoPersistHelper() {
    }

    public Function<Void, Single<Boolean>> createLoadCommonInfoFunc(boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback) {
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
            LoginInfoData loginInfo = CallerManager.getInstance().getUserDaoCaller().queryLoginInfo();
            boolean needUpdate = forceUpdate ? true : forceUpdateLoginInfo;
            forceUpdateLoginInfo = false;
            LoginInfoData newLoginInfo = CallerManager.getInstance().getCommonInfoCaller().getLoginInfoSync(EmptyRequest.builder().forceUpdate(needUpdate).build());
            if (newLoginInfo == null) {
                NzLog.i("无法拉取机构信息");
            }
            if (newLoginInfo != null && !TextUtils.isEmpty(newLoginInfo.getOrgId()) && !newLoginInfo.getOrgId().equals(loginInfo.getOrgId())) {
                NzLog.w("清除本地学生数据");
                DaoManagerProxy.getInstance().getStudentDao().clearAll();
                NzLog.w("清除本地老师数据");
                DaoManagerProxy.getInstance().getTeacherDao().clearAll();
                CallerManager.getInstance().getDownloadFileDaoCaller().clearAllFace();
                pf.putLong(IDefine.LAST_STUDENT_UPDATE_TIME, IDefine.INVALID_TIME);
                pf.putLong(IDefine.LAST_TEACHER_UPDATE_TIME, IDefine.INVALID_TIME);
                pf.putLong(IDefine.LAST_CITIZEN_UPDATE_TIME, IDefine.INVALID_TIME);
                callback.orgChange(newLoginInfo.getOrgId(), loginInfo.getOrgId());
            }


            ////////////// 2.同步学生基本信息 ////////////
            NzLog.i("同步学生信息");
            long serverTime = CallerManager.getInstance().getCommonInfoCaller().getServerTimeSync();
            callback.nextStatus(IDefine.SYNC_STUDENT_STATUS, "正在初始化学生信息");
            int size = CallerManager.getInstance().getUserDaoCaller().queryAllStudentCount();
            long lastTime = pf.readLong(IDefine.LAST_STUDENT_UPDATE_TIME);
            long recentUpdateTime = CallerManager.getInstance().getUserDaoCaller().queryStudentRecentUpdateTime();
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
                GetPageResult studentResult = CallerManager.getInstance().getCommonInfoCaller().getStudentPagesAllSync(studentPageRequest, callback);
                if (studentResult != null && studentResult.isSuccess()) {
                    NzLog.i("学生入库完成，共入库：" + studentResult.getPersistedCount());
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
                GetPageResult teacherResult = CallerManager.getInstance().getCommonInfoCaller().getTeacherPagesAllSync(teacherPageRequest, callback);
                if (teacherResult != null && teacherResult.isSuccess()) {
                    NzLog.i("老师入库完成，共入库：" + teacherResult.getPersistedCount());
                    pf.putLong(IDefine.LAST_TEACHER_UPDATE_TIME, serverTime);
                } else {
                    NzLog.e("无法拉取全量老师");
                }
            } else {
                NzLog.i("无需拉取全量老师");
            }
            NzLog.i("结束全量同步");
            callback.nextStatus(IDefine.SYNC_COMPLETE_STATUS, "执行完成");
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<LoginInfoData, Single<LoginInfoData>> createPersistLoginInfoFunc(EmptyRequest request) {
        return (data) -> {
            if (data == null) {
                return Single.error(new NzCommonException("login info data is null"));
            }
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_LOGIN_INFO + InnerUtil.toJson(request), data, LoginInfoEntity.EXPIRED_TIME);
            DaoManagerProxy.getInstance().getLoginInfoDao().saveLoginInfoWithClear(LoginInfoEntity.convertToEntity(data));
            return Single.just(data);
        };
    }

    public Function<List<TeacherData>, Single<List<TeacherData>>> createPersistTeacherPageFunc(RequestUserCallback callback) {
        return (dataList) -> {
            if (dataList == null || dataList.isEmpty()) {
                return Single.error(new NzCommonException("teacher data list is null"));
            }
            Map<Boolean, List<TeacherData>> partitioned = dataList.stream()
                    .collect(Collectors.partitioningBy(data -> !data.getDelFlag()));
            List<TeacherData> updateTeacherData = partitioned.get(true);
            List<TeacherData> deleteTeacherData = partitioned.get(false);
            List<TeacherEntity> updateTeacherEntity = updateTeacherData.stream().map(data -> TeacherEntity.convertToEntity(data)).collect(Collectors.toList());
            List<TeacherEntity> deleteTeacherEntity = deleteTeacherData.stream().map(data -> TeacherEntity.convertToEntity(data)).collect(Collectors.toList());
            DaoManagerProxy.getInstance().getTeacherDao().insertAll(updateTeacherEntity);
            DaoManagerProxy.getInstance().getTeacherDao().clear(deleteTeacherEntity);
            if (callback != null) {
                callback.updateTeacher(updateTeacherData, deleteTeacherData);
            }
            return Single.just(dataList);
        };
    }

    public Function<List<StudentData>, Single<List<StudentData>>> createPersistStudentPageFunc(RequestUserCallback callback) {
        return (pageData) -> {
            if (pageData == null || pageData.isEmpty()) {
                return Single.error(new NzCommonException("student data list is null"));
            }
            Map<Boolean, List<StudentData>> partitioned = pageData.stream()
                    .collect(Collectors.partitioningBy(data -> "0".equals(data.getDelFlag())));
            List<StudentData> updateStudentData = partitioned.get(true);
            List<StudentData> deleteStudentData = partitioned.get(false);
            List<StudentEntity> updateStudentEntity = updateStudentData.stream().map(data -> StudentEntity.convertToEntity(data)).collect(Collectors.toList());
            List<StudentEntity> deleteStudentEntity = deleteStudentData.stream().map(data -> StudentEntity.convertToEntity(data)).collect(Collectors.toList());
            DaoManagerProxy.getInstance().getStudentDao().insertAll(updateStudentEntity);
            DaoManagerProxy.getInstance().getStudentDao().clear(deleteStudentEntity);
            CallerManager.getInstance().getDownloadFileDaoCaller().clearByUrls(deleteStudentEntity.stream().map(StudentEntity::getUserFaceImgUrl).collect(Collectors.toList()));
            CallerManager.getInstance().getDownloadFileDaoCaller().clearByUrls(deleteStudentEntity.stream().map(StudentEntity::getThumbnailUserFaceImgUrl).collect(Collectors.toList()));
            if (callback != null) {
                callback.updateStudent(updateStudentData, deleteStudentData);
            }
            return Single.just(pageData);
        };
    }

    public Function<List<DictData>, Single<List<DictData>>> createPersistDictListFunc(DictRequest request) {
        return (dataList) -> {
            if (dataList == null || dataList.isEmpty()) {
                return Single.just(dataList);
            }
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_DICT_LIST + InnerUtil.toJson(request), dataList, DictEntity.EXPIRED_TIME);
            DaoManagerProxy.getInstance().getDictDao().clearByDictCode(dataList.get(0).getDictCode());
            List<DictEntity> entityList = dataList.stream()
                    .map(data -> DictEntity.convertToEntity(data))
                    .collect(Collectors.toList());
            DaoManagerProxy.getInstance().getDictDao().insertAll(entityList);
            return Single.just(dataList);
        };
    }

}
