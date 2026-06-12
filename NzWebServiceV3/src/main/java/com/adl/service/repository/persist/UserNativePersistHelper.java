package com.adl.service.repository.persist;

import android.text.TextUtils;

import com.adl.service.common.IDefine;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.LoginInfoEntity;
import com.adl.service.db.entity.StudentEntity;
import com.adl.service.db.entity.TeacherEntity;
import com.adl.service.exception.NzCommonException;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class UserNativePersistHelper {

    public UserNativePersistHelper() {
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

    public Function<Void, Single<TeacherData>> createPrepareTeacherByAccountIdFunc(String accountId) {
        return (v) -> {
            if (TextUtils.isEmpty(accountId)) {
                throw new NzCommonException("accountId is empty when queryTeacher");
            }
            TeacherEntity entity = DaoManagerProxy.getInstance().getTeacherDao().queryTeacherByAccountId(accountId);
            if (entity == null) {
                return Single.error(new NzCommonException("teacher data is null when queryTeacher"));
            } else {
                return Single.just(TeacherEntity.convertToData(entity));
            }
        };
    }

    public Function<Void, Single<List<TeacherData>>> createPrepareTeacherListByAccountIdsFunc(List<String> accountIds) {
        return (v) -> {
            if (accountIds == null || accountIds.isEmpty()) {
                throw new NzCommonException("accountIds is null when queryTeacherList");
            }
            return Single.just(DaoManagerProxy.getInstance().getTeacherDao().queryTeacherByAccountIds(accountIds).stream()
                    .map(data -> TeacherEntity.convertToData(data))
                    .collect(Collectors.toList()));
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

    public Function<Void, Single<StudentData>> createPrepareStudentByAccountIdFunc(String accountId) {
        return (v) -> {
            StudentEntity entity = DaoManagerProxy.getInstance().getStudentDao().queryStudentByAccountId(accountId);
            if (entity == null) {
                return Single.error(new NzCommonException("student data is null when queryStudent"));
            } else {
                return Single.just(StudentEntity.convertToData(entity));
            }
        };
    }

    public Function<Void, Single<List<StudentData>>> createPrepareStudentByAccountIdsFunc(List<String> accountIds) {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentByAccountIds(accountIds).stream()
                .map(data -> StudentEntity.convertToData(data))
                .collect(Collectors.toList()));
    }

    public Function<Void, Single<List<StudentData>>> createPrepareStudentByClassIdsFunc(List<String> classIds) {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentByClassIds(classIds).stream()
                .map(data -> StudentEntity.convertToData(data))
                .collect(Collectors.toList()));
    }

    public Function<Void, Single<List<StudentData>>> createPrepareStudentByKeyWordFunc(String keyWord) {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentByKeyWord(keyWord).stream()
                .map(data -> StudentEntity.convertToData(data))
                .collect(Collectors.toList()));
    }

    public Function<Void, Single<List<StudentData>>> createPrepareStudentByCardNumFunc(String cardNum) {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getStudentDao().queryStudentWithCardNum(cardNum).stream()
                .map(data -> StudentEntity.convertToData(data))
                .collect(Collectors.toList()));
    }

    public Function<Void, Single<Long>> createPrepareStudentRecentUpdateTimeFunc() {
        return (v) -> {
            Long time = DaoManagerProxy.getInstance().getStudentDao().getLastStudentUpdateTime();
            if (time == null) {
                return Single.just(IDefine.INVALID_TIME);
            } else {
                return Single.just(time);
            }
        };
    }
}
