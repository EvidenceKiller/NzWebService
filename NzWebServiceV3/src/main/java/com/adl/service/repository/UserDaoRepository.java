package com.adl.service.repository;

import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.repository.persist.UserDaoPersistHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class UserDaoRepository {
    private final UserDaoPersistHelper persistHelper = new UserDaoPersistHelper();

    private static volatile UserDaoRepository instance;

    private UserDaoRepository() {
    }

    public static UserDaoRepository getInstance() {
        if (instance == null) {
            synchronized (UserDaoRepository.class) {
                if (instance == null) {
                    instance = new UserDaoRepository();
                }
            }
        }
        return instance;
    }

    public Single<LoginInfoData> queryLoginInfo() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareLoginInfoFunc());
    }

    public Single<List<TeacherData>> queryAllTeacherList() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareTeacherListFunc());
    }

    public Single<List<TeacherData>> queryAllTeacherListWithFaceData() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareTeacherListWithFaceDataFunc());
    }

    public Single<Integer> queryAllTeacherCount() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareTeacherCountFunc());
    }

    public Single<TeacherData> queryTeacherByAccountId(String accountId) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareTeacherByAccountIdFunc(accountId));
    }

    public Single<List<TeacherData>> queryTeacherListByAccountIds(List<String> accountIds) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareTeacherListByAccountIdsFunc(accountIds));
    }

    public Single<List<StudentData>> queryAllStudent() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentFunc());
    }

    public Single<List<StudentData>> queryAllStudentWithFaceData() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentWithFaceDataFunc());
    }

    public Single<Integer> queryAllStudentCount() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentCountFunc());
    }

    public Single<StudentData> queryStudentByAccountId(String accountId) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentByAccountIdFunc(accountId));
    }

    public Single<List<StudentData>> queryStudentByAccountIds(List<String> accountIds) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentByAccountIdsFunc(accountIds));
    }

    public Single<List<StudentData>> queryStudentByClassIds(List<String> classIds) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentByClassIdsFunc(classIds));
    }

    public Single<List<StudentData>> queryStudentByKeyWord(String keyWord) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentByKeyWordFunc(keyWord));
    }

    public Single<List<StudentData>> queryStudentByCardNum(String cardNum) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentByCardNumFunc(cardNum));
    }

    public Single<Long> queryStudentRecentUpdateTime() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStudentRecentUpdateTimeFunc());
    }

}
