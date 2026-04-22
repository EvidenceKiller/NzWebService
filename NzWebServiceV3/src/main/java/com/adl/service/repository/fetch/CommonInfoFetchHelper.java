package com.adl.service.repository.fetch;

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
import com.adl.service.http.request.ClassListRequest;
import com.adl.service.http.request.DeviceActiveRequest;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherListRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.CommonInfoService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoFetchHelper {

    private final CommonInfoService commonInfoService;

    public CommonInfoFetchHelper() {
        this.commonInfoService = RetrofitManager.getInstance().create(CommonInfoService.class);
    }

    @SuppressWarnings("unchecked")
    public Function<EmptyRequest, Single<List<GradeTreeData>>> createGetGradeTreeFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getGradeTree(), (Class<List<GradeTreeData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<EmptyRequest, Single<List<GradeChineseNameData>>> createGetGradeChineseNameListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getGradeChineseNameList(), (Class<List<GradeChineseNameData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<ClassListRequest, Single<List<ClassData>>> createGetClassListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getClassList(request), (Class<List<ClassData>>) (Class<?>) List.class);
    }

    public Function<ClassInfoRequest, Single<ClassInfoData>> createGetClassInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getClassInfo(request), ClassInfoData.class);
    }

    public Function<EmptyRequest, Single<LoginInfoData>> createGetLoginInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getLoginInfo(), LoginInfoData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<EmptyRequest, Single<List<AcayearData>>> createGetAcayearListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getAcayearList(), (Class<List<AcayearData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<TeacherData>>> createGetTeacherPagesAllFunc(TeacherListRequest request) {
        return (page) -> {
            TeacherListRequest pageReq = TeacherListRequest.builder()
                    .current(page)
                    .pageSize(request.getPageSize())
                    .orgId(request.getOrgId())
                    .accountType(request.getAccountType())
                    .lastUpdateTime(request.getLastUpdateTime())
                    .acayearSem(request.getAcayearSem())
                    .acayearSemCode(request.getAcayearSemCode())
                    .faceType(request.getFaceType())
                    .delFlag(request.getDelFlag())
                    .build();
            return BaseFetchUtil.scheduleResponse(commonInfoService.getTeacherList(pageReq), (Class<List<TeacherData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<TeacherListRequest, Single<List<TeacherData>>> createGetTeacherPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getTeacherList(request), (Class<List<TeacherData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<StudentData>>> createGetStudentPagesAllFunc(StudentPageRequest request) {
        return (page) -> {
            StudentPageRequest pageReq = StudentPageRequest.builder()
                    .current(page)
                    .pageSize(request.getPageSize())
                    .orgId(request.getOrgId())
                    .accountType(request.getAccountType())
                    .lastUpdateTime(request.getLastUpdateTime())
                    .acayearSem(request.getAcayearSem())
                    .acayearSemCode(request.getAcayearSemCode())
                    .faceType(request.getFaceType())
                    .delFlag(request.getDelFlag())
                    .build();
            return BaseFetchUtil.schedulePageResponse(commonInfoService.getStudentPage(pageReq), (Class<List<StudentData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<StudentPageRequest, Single<List<StudentData>>> createGetStudentPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(commonInfoService.getStudentPage(request), (Class<List<StudentData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DictRequest, Single<List<DictData>>> createGetDictListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.getDictList(request), (Class<List<DictData>>) (Class<?>) List.class);
    }

    public Function<DeviceActiveRequest, Single<Boolean>> createGetDeviceActiveFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(commonInfoService.deviceActive(request), Boolean.class);
    }
}
