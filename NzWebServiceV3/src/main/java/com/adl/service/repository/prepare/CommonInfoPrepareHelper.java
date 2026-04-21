package com.adl.service.repository.prepare;

import android.text.TextUtils;

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
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherListRequest;
import com.adl.service.utils.InnerUtil;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoPrepareHelper {

    public CommonInfoPrepareHelper() {
    }

    public Function<Void, Single<LoginInfoData>> createPrepareLoginInfoFunc() {
        return (v) -> Single.just(LoginInfoEntity.convertToData(DaoManagerProxy.getInstance().getLoginInfoDao().getLoginInfo()));
    }

    public Function<Void, Single<List<TeacherData>>> createPrepareTeacherListFunc() {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getTeacherDao().getAll().stream()
                .map(data -> TeacherEntity.convertToData(data))
                .collect(Collectors.toList()));
    }

    public Function<Void, Single<List<TeacherData>>> createPrepareTeacherListWithFaceDataFunc() {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getTeacherDao().queryTeacherWithFaceData().stream()
                .map(data -> TeacherEntity.convertToData(data))
                .collect(Collectors.toList()));
    }

    public Function<Void, Single<Integer>> createPrepareTeacherCountFunc() {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().countSize());
    }

    public Function<String, Single<TeacherData>> createPrepareTeacherByAccountIdFunc() {
        return (accountId) -> {
            if (accountId == null) {
                throw new NzCommonException("accountIds is null when queryTeacher");
            }
            return Single.just(TeacherEntity.convertToData(DaoManagerProxy.getInstance().getTeacherDao().queryTeacherByAccountId(accountId)));
        };
    }

    public Function<List<String>, Single<List<TeacherData>>> createPrepareTeacherListByAccountIdsFunc() {
        return (accountIds) -> {
            if (accountIds == null) {
                throw new NzCommonException("accountIds is null when queryTeacherList");
            }
            return Single.just(DaoManagerProxy.getInstance().getTeacherDao().queryTeacherByAccountIds(accountIds).stream()
                    .map(data -> TeacherEntity.convertToData(data))
                    .collect(Collectors.toList()));
        };
    }

    public Function<TeacherListRequest, Single<List<TeacherData>>> createPrepareTeacherListsAllFunc() {
        return (request) -> {
            if (request == null) {
                throw new NzCommonException("request is null when getStudentPagesAll");
            }
            if (request.getForceUpdate()) {
                // TODO 强制更新
                return null;
            }
            DaoManagerProxy.getInstance().getTeacherDao().clearAll();
            return null;
        };
    }

    public Function<Void, Single<List<StudentData>>> createPrepareStudentFunc() {
        return (accountIds) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().getAll().stream()
                    .map(data -> StudentEntity.convertToData(data))
                    .collect(Collectors.toList()));
    }

    public Function<Void, Single<List<StudentData>>> createPrepareStudentWithFaceDataFunc() {
        return (accountIds) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentWithFaceData().stream()
                    .map(data -> StudentEntity.convertToData(data))
                    .collect(Collectors.toList()));
    }

    public Function<Void, Single<Integer>> createPrepareStudentCountFunc() {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().countSize());
    }

    public Function<String, Single<StudentData>> createPrepareStudentByAccountIdFunc() {
        return (accountId) -> Single.just(StudentEntity.convertToData(DaoManagerProxy.getInstance().getStudentDao().queryStudentByAccountId(accountId)));
    }

    public Function<List<String>, Single<List<StudentData>>> createPrepareStudentByAccountIdsFunc() {
        return (accountIds) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentByAccountIds(accountIds).stream()
                    .map(data -> StudentEntity.convertToData(data))
                    .collect(Collectors.toList()));
    }

    public Function<List<String>, Single<List<StudentData>>> createPrepareStudentByClassIdsFunc() {
        return (classIds) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentByClassIds(classIds).stream()
                    .map(data -> StudentEntity.convertToData(data))
                    .collect(Collectors.toList()));
    }

    public Function<String, Single<List<StudentData>>> createPrepareStudentByCardNumFunc() {
        return (cardNum) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentWithCardNum(cardNum).stream()
                    .map(data -> StudentEntity.convertToData(data))
                    .collect(Collectors.toList()));
    }

    public Function<StudentPageRequest, Single<List<StudentData>>> createPrepareStudentPagesAllFunc() {
        return (request) -> {
            if (request == null) {
                throw new NzCommonException("request is null when getStudentPagesAll");
            }
            if (request.getForceUpdate()) {
                // TODO 强制更新
                return null;
            }
            DaoManagerProxy.getInstance().getStudentDao().clearAll();
            return null;
        };
    }


    public Function<DictRequest, Single<List<DictData>>> createPrepareDictListFunc() {
        return (request) -> {
            if (request == null) {
                throw new NzCommonException("request is null when getDictList");
            }
            if (request.getForceUpdate()) {
                // TODO 强制更新
                return Single.just(null);
            }
            if (TextUtils.isEmpty(request.getDictId())) {
                // 服务器逻辑dictId为空，返回空列表，缓存逻辑与服务器保持一致
                // TODO 这里返回空列表会触发网络请求，这里需要重新考虑
                return Single.just(null);
            }
            List<DictData> data = (List<DictData>) MemoryCacheManager.getInstance().get(CacheTag.CACHE_TAG_DICT_LIST + InnerUtil.toJson(request));
            if (data != null) {
                return Single.just(data);
            }
            List<DictEntity> entities = DaoManagerProxy.getInstance().getDictDao().queryDictByDictCode(request.getDictId());
            if (entities == null || entities.isEmpty()) {
                return null;
            }
            if (entities.get(0).getRecordTime() + DictEntity.EXPIRED_TIME < System.currentTimeMillis()) {
                return null;
            }

            return Single.just(entities.stream()
                    .map(DictEntity::convertToData)
                    .collect(Collectors.toList()));
        };
    }
}
