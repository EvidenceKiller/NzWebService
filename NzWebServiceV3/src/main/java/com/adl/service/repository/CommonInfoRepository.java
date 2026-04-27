package com.adl.service.repository;

import com.adl.service.callback.GetPageResult;
import com.adl.service.data.AcayearData;
import com.adl.service.data.ClassData;
import com.adl.service.data.ClassInfoData;
import com.adl.service.data.DictData;
import com.adl.service.data.GradeChineseNameData;
import com.adl.service.data.GradeTreeData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.http.request.ClassInfoRequest;
import com.adl.service.http.request.ClassPageRequest;
import com.adl.service.http.request.DeviceActiveRequest;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.repository.fetch.CommonInfoFetchHelper;
import com.adl.service.repository.persist.CommonInfoPersistHelper;
import com.adl.service.repository.prepare.CommonInfoPrepareHelper;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public final class CommonInfoRepository {
    private final CommonInfoPrepareHelper prepareHelper = new CommonInfoPrepareHelper();
    private final CommonInfoFetchHelper fetchHelper = new CommonInfoFetchHelper();
    private final CommonInfoPersistHelper persistHelper = new CommonInfoPersistHelper();

    private static volatile CommonInfoRepository instance;

    private CommonInfoRepository() {
    }

    public static CommonInfoRepository getInstance() {
        if (instance == null) {
            synchronized (CommonInfoRepository.class) {
                if (instance == null) {
                    instance = new CommonInfoRepository();
                }
            }
        }
        return instance;
    }

    public Single<List<GradeTreeData>> getGradeTree(EmptyRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetGradeTreeFunc());
    }

    public Single<List<GradeChineseNameData>> getGradeChineseNameList(EmptyRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetGradeChineseNameListFunc());
    }

    public Single<List<ClassData>> getClassPage(ClassPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetClassPageFunc());
    }

    public Single<ClassInfoData> getClassInfo(ClassInfoRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetClassInfoFunc());
    }

    public Single<LoginInfoData> queryLoginInfo() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareLoginInfoFunc());
    }

    public Single<LoginInfoData> getLoginInfo(EmptyRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                fetchHelper.createGetLoginInfoFunc(),
                persistHelper.createPersistLoginInfoFunc());
    }

    public Single<List<AcayearData>> getAcayearList(EmptyRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetAcayearListFunc());
    }

    public Single<List<TeacherData>> queryAllTeacherList() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareTeacherListFunc());
    }

    public Single<List<TeacherData>> queryAllTeacherListWithFaceData() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareTeacherListWithFaceDataFunc());
    }

    public Single<Integer> queryAllTeacherCount() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareTeacherCountFunc());
    }

    public Single<TeacherData> queryTeacherByAccountId(String accountId) {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareTeacherByAccountIdFunc(accountId));
    }

    public Single<List<TeacherData>> queryTeacherListByAccountIds(List<String> accountIds) {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareTeacherListByAccountIdsFunc(accountIds));
    }

    public Single<GetPageResult> getTeacherPagesAll(TeacherPageRequest request) {
        return BaseRepositoryUtil.repositoryListsAsSingle(request,
                prepareHelper.createPrepareTeacherPagesAllFunc(),
                fetchHelper.createGetTeacherPagesAllFunc(request),
                persistHelper.createPersistTeacherPageFunc());
    }

    public Single<List<TeacherData>> getTeacherPage(TeacherPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                fetchHelper.createGetTeacherPageFunc(),
                persistHelper.createPersistTeacherPageFunc());
    }

    public Single<List<StudentData>> queryAllStudent() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentFunc());
    }

    public Single<List<StudentData>> queryAllStudentWithFaceData() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentWithFaceDataFunc());
    }

    public Single<Integer> queryAllStudentCount() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentCountFunc());
    }

    public Single<StudentData> queryStudentByAccountId(String accountId) {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentByAccountIdFunc(accountId));
    }

    public Single<List<StudentData>> queryStudentByAccountIds(List<String> accountIds) {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentByAccountIdsFunc(accountIds));
    }

    public Single<List<StudentData>> queryStudentByClassIds(List<String> classIds) {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentByClassIdsFunc(classIds));
    }

    public Single<List<StudentData>> queryStudentByCardNum(String cardNum) {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentByCardNumFunc(cardNum));
    }

    public Single<Long> queryStudentRecentUpdateTime() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStudentRecentUpdateTimeFunc());
    }

    public Single<GetPageResult> getStudentPagesAll(StudentPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createPrepareStudentPagesAllFunc(),
                fetchHelper.createGetStudentPagesAllFunc(request),
                persistHelper.createPersistStudentPageFunc()
        );
    }

    public Single<List<StudentData>> getStudentPage(StudentPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetStudentPageFunc(),
                persistHelper.createPersistStudentPageFunc());
    }

    public Single<List<DictData>> getDictList(DictRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                prepareHelper.createPrepareDictListFunc(),
                fetchHelper.createGetDictListFunc(),
                persistHelper.createPersistDictListFunc(request));
    }

    public Single<Boolean> deviceActive(DeviceActiveRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetDeviceActiveFunc());
    }

    public Single<Long> getServerTime() {
        return BaseRepositoryUtil.repositoryAsSingle(fetchHelper.createGetServerTimeFunc());
    }
}
