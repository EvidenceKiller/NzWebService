package com.adl.service.repository.fetch;

import android.text.TextUtils;

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
import com.adl.service.data.TimeStamp;
import com.adl.service.http.request.ClassInfoRequest;
import com.adl.service.http.request.ClassPageRequest;
import com.adl.service.http.request.DeviceActiveRequest;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.utils.InnerUtil;
import com.adl.service.web.BusinessService;
import com.adl.service.web.CommonInfoService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoFetchHelper {

    private volatile CommonInfoService commonInfoService;
    private volatile String baseUrl;

    public CommonInfoFetchHelper() {
    }

    private synchronized CommonInfoService getService() {
        if (commonInfoService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            commonInfoService = RetrofitManager.getInstance().create(CommonInfoService.class);
        }
        return commonInfoService;
    }

    @SuppressWarnings("unchecked")
    public Function<EmptyRequest, Single<List<GradeTreeData>>> createGetGradeTreeFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getGradeTree(), (Class<List<GradeTreeData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<EmptyRequest, Single<List<GradeChineseNameData>>> createGetGradeChineseNameListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getGradeChineseNameList(), (Class<List<GradeChineseNameData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<ClassPageRequest, Single<List<ClassData>>> createGetClassPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getClassPage(request), (Class<List<ClassData>>) (Class<?>) List.class);
    }

    public Function<ClassInfoRequest, Single<ClassInfoData>> createGetClassInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getClassInfo(request), ClassInfoData.class);
    }

    public Function<EmptyRequest, Single<LoginInfoData>> createGetLoginInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getLoginInfo(), LoginInfoData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<EmptyRequest, Single<List<AcayearData>>> createGetAcayearListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getAcayearList(), (Class<List<AcayearData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<TeacherData>>> createGetTeacherPagesAllFunc(TeacherPageRequest request) {
        return (page) -> {
            TeacherPageRequest pageReq = TeacherPageRequest.builder()
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
            return BaseFetchUtil.scheduleResponse(getService().getTeacherPage(pageReq), (Class<List<TeacherData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<TeacherPageRequest, Single<List<TeacherData>>> createGetTeacherPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTeacherPage(request), (Class<List<TeacherData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
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
            return BaseFetchUtil.scheduleResponse(getService().getStudentPage(pageReq), (Class<BasePageData<StudentData>>) (Class<?>) BasePageData.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<StudentPageRequest, Single<BasePageData<StudentData>>> createGetStudentPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getStudentPage(request), (Class<BasePageData<StudentData>>) (Class<?>) BasePageData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DictRequest, Single<List<DictData>>> createGetDictListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDictList(request), (Class<List<DictData>>) (Class<?>) List.class);
    }

    public Function<DeviceActiveRequest, Single<Boolean>> createGetDeviceActiveFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().deviceActive(request), Boolean.class);
    }

    public Function<Void, Single<Long>> createGetServerTimeFunc() {
        return (request) -> {
            Single<TimeStamp> timeStamp = BaseFetchUtil.schedule(getService().getServerTime(InnerUtil.getIpHost() + "/time"), TimeStamp.class);
            return timeStamp.flatMap((stamp) -> Single.just((long) (stamp.getTimestamp() * 1000L)));
        };
    }
}
