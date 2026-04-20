package com.adl.service.repository.fetch;

import com.adl.service.data.BasePageData;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;
import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassListRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.StandardConfigPageRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.OrgTestService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OrgTestFetchHelper {

    private final OrgTestService orgTestService;

    public OrgTestFetchHelper() {
        this.orgTestService = RetrofitManager.getInstance().create(OrgTestService.class);
    }

    public Function<Long, Single<List<StandardConfigData>>> createGetStandardConfigPagesAllFunc(StandardConfigPageRequest request) {
        return (page) -> {
            StandardConfigPageRequest pageReq = StandardConfigPageRequest.builder(request.getStandardType())
                    .current(page)
                    .pageSize(request.getPageSize())
                    .standardId(request.getStandardId())
                    .sportProjectCode(request.getSportProjectCode())
                    .build();
            return orgTestService.getStandardConfigPage(pageReq).map(BaseFetchUtil::scheduleResponse);
        };
    }

    public Function<StandardConfigPageRequest, Single<List<StandardConfigData>>> createGetStandardConfigPageFunc() {
        return (request) -> orgTestService.getStandardConfigPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<Long, Single<BasePageData<PlanStudentData>>> createGetPlanStudentPagesAllFunc(PlanStudentPageRequest request) {
        return (page) -> {
            PlanStudentPageRequest pageReq = PlanStudentPageRequest.builder(request.getPlanId())
                    .current(page)
                    .pageSize(request.getPageSize())
                    .orgId(request.getOrgId())
                    .classId(request.getClassId())
                    .keyword(request.getKeyword())
                    .build();
            return orgTestService.getPlanStudentPage(pageReq).map(BaseFetchUtil::scheduleResponse);
        };
    }

    public Function<PlanStudentPageRequest, Single<BasePageData<PlanStudentData>>> createGetPlanStudentPageFunc() {
        return (request) -> orgTestService.getPlanStudentPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<Long, Single<BasePageData<PlanData>>> createGetPlanPagesAllFunc(PlanPageRequest request) {
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
            return orgTestService.getPlanPage(pageReq).map(BaseFetchUtil::scheduleResponse);
        };
    }

    public Function<PlanPageRequest, Single<BasePageData<PlanData>>> createGetPlanPageFunc() {
        return (request) -> orgTestService.getPlanPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<PlanInfoRequest, Single<PlanInfoData>> createGetPlanInfoFunc() {
        return (request) -> orgTestService.getPlanInfo(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<PlanClassListRequest, Single<List<PlanClassData>>> createGetPlanClassListFunc() {
        return (request) -> orgTestService.getPlanClassList(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<CheckStudentInPlanRequest, Single<Boolean>> createCheckStudentInPlanFunc() {
        return (request) -> orgTestService.checkStudentInPlan(request).map(BaseFetchUtil::scheduleResponse);
    }
}
