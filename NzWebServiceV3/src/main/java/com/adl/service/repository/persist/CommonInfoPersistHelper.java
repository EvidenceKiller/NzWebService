package com.adl.service.repository.persist;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.PageSummaryData;
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
import com.adl.service.exception.NzHttpException;
import com.adl.service.exception.NzPersistException;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.internal.CallerManager;
import com.adl.service.log.NzLog;
import com.adl.service.repository.cache.CacheTag;
import com.adl.service.repository.cache.MemoryCacheManager;
import com.adl.service.utils.InnerUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoPersistHelper {



    public CommonInfoPersistHelper() {
    }

    public Function<ResponseResult<LoginInfoData>, Single<ResponseResult<LoginInfoData>>> createPersistLoginInfoFunc(EmptyRequest request) {
        return (result) -> {
            if (result == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            LoginInfoData data = result.getData();
            if (data == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "login info data is null"));
            }
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_LOGIN_INFO + InnerUtil.toJson(request), data, LoginInfoEntity.EXPIRED_TIME);
            DaoManagerProxy.getInstance().getLoginInfoDao().saveLoginInfoWithClear(LoginInfoEntity.convertToEntity(data));
            return Single.just(result);
        };
    }

    public Function<ResponseResult<List<TeacherData>>, Single<ResponseResult<List<TeacherData>>>> createPersistTeacherPageFunc(RequestUserCallback callback) {
        return (result) -> {
            if (result == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            List<TeacherData> dataList = result.getData();
            if (dataList == null || dataList.isEmpty()) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "teacher data list is null"));
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
            return Single.just(result);
        };
    }

    public Function<ResponseResult<List<StudentData>>, Single<ResponseResult<List<StudentData>>>> createPersistStudentPageFunc(RequestUserCallback callback) {
        return (result) -> {
            if (result == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            List<StudentData> pageData = result.getData();
            if (pageData == null || pageData.isEmpty()) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "student data list is null"));
            }
            Map<Boolean, List<StudentData>> partitioned = pageData.stream()
                    .collect(Collectors.partitioningBy(data -> "0".equals(data.getDelFlag())));
            List<StudentData> updateStudentData = partitioned.get(true);
            List<StudentData> deleteStudentData = partitioned.get(false);
            List<StudentEntity> updateStudentEntity = updateStudentData.stream().map(data -> StudentEntity.convertToEntity(data)).collect(Collectors.toList());
            List<StudentEntity> deleteStudentEntity = deleteStudentData.stream().map(data -> StudentEntity.convertToEntity(data)).collect(Collectors.toList());
            DaoManagerProxy.getInstance().getStudentDao().insertAll(updateStudentEntity);
            DaoManagerProxy.getInstance().getStudentDao().clear(deleteStudentEntity);
            CallerManager.getInstance().getDownloadFileCaller().clearByUrls(deleteStudentEntity.stream().map(StudentEntity::getUserFaceImgUrl).collect(Collectors.toList()));
            CallerManager.getInstance().getDownloadFileCaller().clearByUrls(deleteStudentEntity.stream().map(StudentEntity::getThumbnailUserFaceImgUrl).collect(Collectors.toList()));
            if (callback != null) {
                callback.updateStudent(updateStudentData, deleteStudentData);
            }
            return Single.just(result);
        };
    }

    public Function<ResponseResult<List<DictData>>, Single<ResponseResult<List<DictData>>>> createPersistDictListFunc(DictRequest request) {
        return (result) -> {
            if (result == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            List<DictData> dataList = result.getData();
            if (dataList == null || dataList.isEmpty()) {
                MemoryCacheManager.getInstance().remove(CacheTag.CACHE_TAG_DICT_LIST + InnerUtil.toJson(request));
                DaoManagerProxy.getInstance().getDictDao().clearAll();
                return Single.just(result);
            }
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_DICT_LIST + InnerUtil.toJson(request), dataList, DictEntity.EXPIRED_TIME);
            DaoManagerProxy.getInstance().getDictDao().clearByDictCode(dataList.get(0).getDictCode());
            List<DictEntity> entityList = dataList.stream()
                    .map(data -> DictEntity.convertToEntity(data))
                    .collect(Collectors.toList());
            DaoManagerProxy.getInstance().getDictDao().insertAll(entityList);
            return Single.just(result);
        };
    }

}
