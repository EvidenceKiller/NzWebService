package com.adl.service.repository.fetch;

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

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<StandardConfigData>>> createGetStandardConfigPagesAllFunc(StandardConfigPageRequest request) {
        return (page) -> {
            StandardConfigPageRequest pageReq = StandardConfigPageRequest.builder(request.getStandardType())
                    .current(page)
                    .pageSize(request.getPageSize())
                    .standardId(request.getStandardId())
                    .sportProjectCode(request.getSportProjectCode())
                    .build();
            return BaseFetchUtil.scheduleResponse(orgTestService.getStandardConfigPage(pageReq), (Class<List<StandardConfigData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<StandardConfigPageRequest, Single<List<StandardConfigData>>> createGetStandardConfigPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(orgTestService.getStandardConfigPage(request), (Class<List<StandardConfigData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<PlanStudentData>>> createGetPlanStudentPagesAllFunc(PlanStudentPageRequest request) {
        return (page) -> {
            PlanStudentPageRequest pageReq = PlanStudentPageRequest.builder(request.getPlanId())
                    .current(page)
                    .pageSize(request.getPageSize())
                    .orgId(request.getOrgId())
                    .classId(request.getClassId())
                    .keyword(request.getKeyword())
                    .build();
            return BaseFetchUtil.schedulePageResponse(orgTestService.getPlanStudentPage(pageReq), (Class<List<PlanStudentData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<PlanStudentPageRequest, Single<List<PlanStudentData>>> createGetPlanStudentPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(orgTestService.getPlanStudentPage(request), (Class<List<PlanStudentData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<PlanData>>> createGetPlanPagesAllFunc(PlanPageRequest request) {
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
            return BaseFetchUtil.schedulePageResponse(orgTestService.getPlanPage(pageReq), (Class<List<PlanData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<PlanPageRequest, Single<List<PlanData>>> createGetPlanPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(orgTestService.getPlanPage(request), (Class<List<PlanData>>) (Class<?>) List.class);
    }

    public Function<PlanInfoRequest, Single<PlanInfoData>> createGetPlanInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(orgTestService.getPlanInfo(request), PlanInfoData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<PlanClassListRequest, Single<List<PlanClassData>>> createGetPlanClassListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(orgTestService.getPlanClassList(request), (Class<List<PlanClassData>>) (Class<?>) List.class);
    }

    public Function<CheckStudentInPlanRequest, Single<Boolean>> createCheckStudentInPlanFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(orgTestService.checkStudentInPlan(request), Boolean.class);
    }
}
