package com.adl.service.repository.fetch;

import com.adl.service.data.AcayearData;
import com.adl.service.data.BasePageData;
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

    public Function<EmptyRequest, Single<List<GradeTreeData>>> createGetGradeTreeFunc() {
        return (request) -> commonInfoService.getGradeTree().map(BaseFetchUtil::scheduleResponse);
    }

    public Function<EmptyRequest, Single<List<GradeChineseNameData>>> createGetGradeChineseNameListFunc() {
        return (request) -> commonInfoService.getGradeChineseNameList().map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ClassListRequest, Single<List<ClassData>>> createGetClassListFunc() {
        return (request) -> commonInfoService.getClassList(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ClassInfoRequest, Single<ClassInfoData>> createGetClassInfoFunc() {
        return (request) -> commonInfoService.getClassInfo(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<EmptyRequest, Single<LoginInfoData>> createGetLoginInfoFunc() {
        return (request) -> commonInfoService.getLoginInfo().map(BaseFetchUtil::scheduleResponse);
    }

    public Function<EmptyRequest, Single<List<AcayearData>>> createGetAcayearListFunc() {
        return (request) -> commonInfoService.getAcayearList().map(BaseFetchUtil::scheduleResponse);
    }

    public Function<Long, Single<List<TeacherData>>> createGetTeacherListsAllFunc(TeacherListRequest request) {
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
            return commonInfoService.getTeacherList(pageReq).map(BaseFetchUtil::scheduleResponse);
        };
    }

    public Function<TeacherListRequest, Single<List<TeacherData>>> createGetTeacherListFunc() {
        return (request) -> commonInfoService.getTeacherList(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<Long, Single<BasePageData<StudentData>>> createGetStudentPagesAllFunc(StudentPageRequest request) {
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
            return commonInfoService.getStudentPage(pageReq).map(BaseFetchUtil::scheduleResponse);
        };
    }

    public Function<StudentPageRequest, Single<BasePageData<StudentData>>> createGetStudentPageFunc() {
        return (request) -> commonInfoService.getStudentPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<DictRequest, Single<List<DictData>>> createGetDictListFunc() {
        return (request) -> commonInfoService.getDictList(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<DeviceActiveRequest, Single<Boolean>> createGetDeviceActiveFunc() {
        return (request) -> commonInfoService.deviceActive(request).map(BaseFetchUtil::scheduleResponse);
    }
}
