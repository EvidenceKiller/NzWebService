package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
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

    public Function<EmptyRequest, Single<ResponseResult<List<GradeTreeData>>>> createGetGradeTreeFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getGradeTree());
    }

    public Function<EmptyRequest, Single<ResponseResult<List<GradeChineseNameData>>>> createGetGradeChineseNameListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getGradeChineseNameList());
    }

    public Function<ClassPageRequest, Single<ResponseResult<List<ClassData>>>> createGetClassPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getClassPage(request));
    }

    public Function<ClassInfoRequest, Single<ResponseResult<ClassInfoData>>> createGetClassInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getClassInfo(request));
    }

    public Function<EmptyRequest, Single<ResponseResult<LoginInfoData>>> createGetLoginInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getLoginInfo());
    }

    public Function<EmptyRequest, Single<ResponseResult<List<AcayearData>>>> createGetAcayearListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getAcayearList());
    }

    public Function<Long, Single<ResponseResult<List<TeacherData>>>> createGetTeacherPagesAllFunc(TeacherPageRequest request) {
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
            return BaseFetchUtil.scheduleResponse(getService().getTeacherPage(pageReq));
        };
    }

    public Function<TeacherPageRequest, Single<ResponseResult<List<TeacherData>>>> createGetTeacherPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTeacherPage(request));
    }

    public Function<Long, Single<ResponseResult<BasePageData<StudentData>>>> createGetStudentPagesAllFunc(StudentPageRequest request) {
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
            return BaseFetchUtil.scheduleResponse(getService().getStudentPage(pageReq));
        };
    }

    public Function<StudentPageRequest, Single<ResponseResult<BasePageData<StudentData>>>> createGetStudentPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getStudentPage(request));
    }

    public Function<DictRequest, Single<ResponseResult<List<DictData>>>> createGetDictListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDictList(request));
    }

    public Function<DeviceActiveRequest, Single<ResponseResult<Boolean>>> createGetDeviceActiveFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().deviceActive(request));
    }

    public Function<EmptyRequest, Single<ResponseResult<Long>>> createGetServerTimeFunc() {
        return (request) -> {
            Single<ResponseResult<TimeStamp>> timeStamp = BaseFetchUtil.schedule(getService().getServerTime(InnerUtil.getIpHost() + "/time"));
            return timeStamp.flatMap(result -> {
                ResponseResult<Long> responseResult = new ResponseResult<>();
                if (result.getCode() == NzResponseCode.NZ_SUCCESS && result.getData() != null && result.getData().getTimestamp() != null) {
                    responseResult.setCode(result.getCode());
                    responseResult.setMsg(result.getMsg());
                    responseResult.setData((long) (result.getData().getTimestamp() * 1000L));
                } else {
                    responseResult.setCode(result.getCode());
                    responseResult.setMsg(result.getMsg());
                    responseResult.setData(0L);
                }
                return Single.just(responseResult);
            });
        };
    }
}
