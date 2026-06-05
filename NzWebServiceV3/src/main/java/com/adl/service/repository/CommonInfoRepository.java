package com.adl.service.repository;

import com.adl.service.callback.GetPageResult;
import com.adl.service.callback.RequestUserCallback;
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

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
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

    public Single<Boolean> loadCommonInfo(boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createLoadCommonInfoFunc(forceUpdate, faceType, pageSize, callback));
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

    public Single<LoginInfoData> getLoginInfo(EmptyRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                prepareHelper.createPrepareLoginInfoFunc(),
                fetchHelper.createGetLoginInfoFunc(),
                persistHelper.createPersistLoginInfoFunc(request));
    }

    public Single<List<AcayearData>> getAcayearList(EmptyRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetAcayearListFunc());
    }

    public Single<GetPageResult> getTeacherPagesAll(TeacherPageRequest request, RequestUserCallback callback) {
        return BaseRepositoryUtil.repositoryListsAsSingle(request,
                prepareHelper.createPrepareTeacherPagesAllFunc(),
                fetchHelper.createGetTeacherPagesAllFunc(request),
                persistHelper.createPersistTeacherPageFunc(callback));
    }

    public Single<List<TeacherData>> getTeacherPage(TeacherPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                fetchHelper.createGetTeacherPageFunc(),
                persistHelper.createPersistTeacherPageFunc(null));
    }

    public Single<GetPageResult> getStudentPagesAll(StudentPageRequest request, RequestUserCallback callback) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createPrepareStudentPagesAllFunc(),
                fetchHelper.createGetStudentPagesAllFunc(request),
                persistHelper.createPersistStudentPageFunc(callback)
        );
    }

    public Single<List<StudentData>> getStudentPage(StudentPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetStudentPageFunc(),
                persistHelper.createPersistStudentPageFunc(null));
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
