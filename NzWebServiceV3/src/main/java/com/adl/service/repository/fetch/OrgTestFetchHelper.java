package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.BasePageData;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;
import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassPageRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.StandardConfigPageRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.OpsMaintService;
import com.adl.service.web.OrgTestService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OrgTestFetchHelper {

    private volatile OrgTestService orgTestService;
    private volatile String baseUrl;

    public OrgTestFetchHelper() {
    }

    private synchronized OrgTestService getService() {
        if (orgTestService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            orgTestService = RetrofitManager.getInstance().create(OrgTestService.class);
        }
        return orgTestService;
    }

    public Function<Long, Single<ResponseResult<List<StandardConfigData>>>> createGetStandardConfigPagesAllFunc(StandardConfigPageRequest request) {
        return (page) -> {
            StandardConfigPageRequest pageReq = StandardConfigPageRequest.builder(request.getStandardType())
                    .current(page)
                    .pageSize(request.getPageSize())
                    .standardId(request.getStandardId())
                    .sportProjectCode(request.getSportProjectCode())
                    .build();
            return BaseFetchUtil.scheduleResponse(getService().getStandardConfigPage(pageReq));
        };
    }

    public Function<StandardConfigPageRequest, Single<ResponseResult<List<StandardConfigData>>>> createGetStandardConfigPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getStandardConfigPage(request));
    }

    public Function<Long, Single<ResponseResult<BasePageData<PlanStudentData>>>> createGetPlanStudentPagesAllFunc(PlanStudentPageRequest request) {
        return (page) -> {
            PlanStudentPageRequest pageReq = PlanStudentPageRequest.builder(request.getPlanId())
                    .current(page)
                    .pageSize(request.getPageSize())
                    .orgId(request.getOrgId())
                    .classId(request.getClassId())
                    .keyword(request.getKeyword())
                    .build();
            return BaseFetchUtil.scheduleResponse(getService().getPlanStudentPage(pageReq));
        };
    }

    public Function<PlanStudentPageRequest, Single<ResponseResult<BasePageData<PlanStudentData>>>> createGetPlanStudentPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPlanStudentPage(request));
    }

    public Function<Long, Single<ResponseResult<BasePageData<PlanData>>>> createGetPlanPagesAllFunc(PlanPageRequest request) {
        return (page) -> {
            PlanPageRequest pageReq = PlanPageRequest.builder()
                    .current(page)
                    .pageSize(request.getPageSize())
                    .orgId(request.getOrgId())
                    .standardType(request.getStandardType())
                    .acayearCode(request.getAcayearCode())
                    .status(request.getStatus())
                    .showStatistic(request.getShowStatistic())
                    .planId(request.getPlanId())
                    .build();
            return BaseFetchUtil.scheduleResponse(getService().getPlanPage(pageReq));
        };
    }

    public Function<PlanPageRequest, Single<ResponseResult<BasePageData<PlanData>>>> createGetPlanPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPlanPage(request));
    }

    public Function<PlanInfoRequest, Single<ResponseResult<PlanInfoData>>> createGetPlanInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPlanInfo(request));
    }

    public Function<PlanClassPageRequest, Single<ResponseResult<List<PlanClassData>>>> createGetPlanClassPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPlanClassPage(request));
    }

    public Function<CheckStudentInPlanRequest, Single<ResponseResult<Boolean>>> createCheckStudentInPlanFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().checkStudentInPlan(request));
    }
}
