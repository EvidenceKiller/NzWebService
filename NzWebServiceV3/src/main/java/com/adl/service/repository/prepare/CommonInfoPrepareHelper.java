package com.adl.service.repository.prepare;

import com.adl.service.data.DictData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.DictEntity;
import com.adl.service.db.entity.LoginInfoEntity;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.log.NzLog;
import com.adl.service.repository.cache.CacheTag;
import com.adl.service.repository.cache.MemoryCacheManager;
import com.adl.service.utils.InnerUtil;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoPrepareHelper {

    public CommonInfoPrepareHelper() {
    }

    public Function<TeacherPageRequest, Single<List<TeacherData>>> createPrepareTeacherPagesAllFunc() {
        return (request) -> {
            if (request.getForceUpdate()) {
                NzLog.w("清除本地老师数据");
                DaoManagerProxy.getInstance().getTeacherDao().clearAll();
            }
            return null;
        };
    }

    public Function<StudentPageRequest, Single<List<StudentData>>> createPrepareStudentPagesAllFunc() {
        return (request) -> {
            if (request.getForceUpdate()) {
                NzLog.w("清除本地学生数据");
                DaoManagerProxy.getInstance().getStudentDao().clearAll();
            }
            return null;
        };
    }

    public Function<EmptyRequest, Single<LoginInfoData>> createPrepareLoginInfoFunc() {
        return (request) -> {
            if (request == null) {
                return null;
            }
            if (request.getForceUpdate()) {
                return null;
            }
            LoginInfoData data = (LoginInfoData) MemoryCacheManager.getInstance().get(CacheTag.CACHE_TAG_LOGIN_INFO + InnerUtil.toJson(request));
            if (data != null) {
                return Single.just(data);
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
            return Single.just(data);
        };
    }

    public Function<DictRequest, Single<List<DictData>>> createPrepareDictListFunc() {
        return (request) -> {
            List<DictData> data = (List<DictData>) MemoryCacheManager.getInstance().get(CacheTag.CACHE_TAG_DICT_LIST + InnerUtil.toJson(request));
            if (data != null) {
                return Single.just(data);
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

            return Single.just(data);
        };
    }
}
