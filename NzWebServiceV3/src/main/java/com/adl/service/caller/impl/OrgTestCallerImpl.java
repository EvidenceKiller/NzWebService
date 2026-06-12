package com.adl.service.caller.impl;

import android.text.TextUtils;
import android.util.Pair;

import com.adl.service.AdlService;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.PageSummaryData;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.OrgTestCaller;
import com.adl.service.common.IDefine;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.PlanEntity;
import com.adl.service.db.entity.SportProjectEntity;
import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassPageRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.StandardConfigPageRequest;
import com.adl.service.internal.CallerManager;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.log.NzLog;
import com.adl.service.repository.OrgTestRepository;
import com.adl.service.utils.InnerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * OrgTestCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class OrgTestCallerImpl implements OrgTestCaller {

    private final OrgTestRepository orgTestRepository;

    public OrgTestCallerImpl() {
        this.orgTestRepository = OrgTestRepository.getInstance();
    }

    @Override
    public void reLoadAllOrgTestDataSync(boolean syncStandard) {
        ResponseResult<Long> serverTimeResult = CallerManager.getInstance().getCommonInfoCaller().getServerTimeSync();
        long serverTime = 0L;
        if (serverTimeResult.getCode() == NzResponseCode.NZ_SUCCESS && serverTimeResult.getData() != null) {
            serverTime = serverTimeResult.getData();
        }
        NzLog.d("服务器时间: " + InnerUtil.formatByTimeCode(serverTime));
        List<Integer> statusList = Arrays.asList(IDefine.SportPlanStatusNew, IDefine.SportPlanStatusDoing);

        ////////////// 1.同步全部运动计划 ////////////
        CallerManager.getInstance().getPlanNativeCaller().clearPlanDataSync();
        PageSummaryData planSyncResult = new PageSummaryData();
        for (Integer status : statusList) {
            PlanPageRequest planPageRequest = PlanPageRequest.builder()
                    .standardType(IDefine.standardTypeALL)
                    .status(String.valueOf(status))
                    .build();
            ResponseResult<PageSummaryData> respResult = getPlanPagesAllSync(planPageRequest);
            if (respResult.getCode() == NzResponseCode.NZ_SUCCESS && respResult.getData() != null) {
                planSyncResult.setSuccessedPages(planSyncResult.getSuccessedPages() + respResult.getData().getSuccessedPages());
                planSyncResult.setFetchedCount(planSyncResult.getFetchedCount() + respResult.getData().getFetchedCount());
                planSyncResult.setPersistedCount(planSyncResult.getPersistedCount() + respResult.getData().getPersistedCount());
                planSyncResult.setTotalPages(planSyncResult.getTotalPages() + respResult.getData().getTotalPages());
            }
        }
        planSyncResult.setSuccess(true);
        List<PlanEntity> planDataList = DaoManagerProxy.getInstance().getPlanDao().getAll();
        NzLog.d("reGetAllOrgTestDataSync merged plan count: " + planDataList.size() + ", request result: " + planSyncResult);

        ////////////// 2.同步运动计划下学生 ////////////
        CallerManager.getInstance().getPlanNativeCaller().clearPlanStudentDataSync();
        for (PlanEntity plan : planDataList) {
            if (TextUtils.isEmpty(plan.getEndTime()) || serverTime > Long.parseLong(plan.getEndTime())) {
                continue;
            }
            PlanStudentPageRequest request = PlanStudentPageRequest.builder(plan.getPlanId())
                    .build();
            getPlanStudentPagesAllSync(request);
        }

        ////////////// 3.同步运动标准 ////////////
        if (syncStandard) {
            CallerManager.getInstance().getPlanNativeCaller().clearStandardConfigDataSync();
            ArrayList<Pair<String, String>> standardList = new ArrayList<>();

            for (PlanEntity plan : planDataList) {
                if (plan.getSportProjects() == null) {
                    continue;
                }

                if (TextUtils.isEmpty(plan.getEndTime()) || serverTime > Long.parseLong(plan.getEndTime())) {
                    continue;
                }

                for (SportProjectEntity project : plan.getSportProjects()) {
                    Pair<String, String> newPair = Pair.create(plan.getStandardId(), project.getSportSkuId());
                    //  不包含添加
                    if (standardList.stream().noneMatch(standard -> standard.equals(newPair))) {
                        standardList.add(newPair);
                    }
                }
            }

            for (Pair<String, String> param : standardList) {
                StandardConfigPageRequest request = StandardConfigPageRequest.builder("")
                        .standardId(param.first)
                        .sportProjectCode(param.second)
                        .build();
                getStandardConfigPagesAllSync(request);
            }
        }
    }

    @Override
    public long getStandardConfigPagesAllAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<PageSummaryData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getStandardConfigPagesAll(request), callback);
    }

    @Override
    public ResponseResult<PageSummaryData> getStandardConfigPagesAllSync(StandardConfigPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getStandardConfigPagesAll(request));
    }

    @Override
    public long getStandardConfigPageAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getStandardConfigPage(request), callback);
    }

    @Override
    public ResponseResult<List<StandardConfigData>> getStandardConfigPageSync(StandardConfigPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getStandardConfigPage(request));
    }

    @Override
    public long getPlanStudentPagesAllAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<PageSummaryData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getPlanStudentPagesAll(request), callback);
    }

    @Override
    public ResponseResult<PageSummaryData> getPlanStudentPagesAllSync(PlanStudentPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getPlanStudentPagesAll(request));
    }

    @Override
    public long getPlanStudentPageAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<List<PlanStudentData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getPlanStudentPage(request), callback);
    }

    @Override
    public ResponseResult<List<PlanStudentData>> getPlanStudentPageSync(PlanStudentPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getPlanStudentPage(request));
    }

    @Override
    public long getPlanPagesAllAsync(RequestScope scope, PlanPageRequest request, RequestCallback<PageSummaryData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getPlanPagesAll(request), callback);
    }

    @Override
    public ResponseResult<PageSummaryData> getPlanPagesAllSync(PlanPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getPlanPagesAll(request));
    }

    @Override
    public long getPlanPageAsync(RequestScope scope, PlanPageRequest request, RequestCallback<List<PlanData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getPlanPage(request), callback);
    }

    @Override
    public ResponseResult<List<PlanData>> getPlanPageSync(PlanPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getPlanPage(request));
    }

    @Override
    public long getPlanInfoAsync(RequestScope scope, PlanInfoRequest request, RequestCallback<PlanInfoData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getPlanInfo(request), callback);
    }

    @Override
    public ResponseResult<PlanInfoData> getPlanInfoSync(PlanInfoRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getPlanInfo(request));
    }

    @Override
    public long getPlanClassPageAsync(RequestScope scope, PlanClassPageRequest request, RequestCallback<List<PlanClassData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.getPlanClassPage(request), callback);
    }

    @Override
    public ResponseResult<List<PlanClassData>> getPlanClassPageSync(PlanClassPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.getPlanClassPage(request));
    }

    @Override
    public long checkStudentInPlanAsync(RequestScope scope, CheckStudentInPlanRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, orgTestRepository.checkStudentInPlan(request), callback);
    }

    @Override
    public ResponseResult<Boolean> checkStudentInPlanSync(CheckStudentInPlanRequest request) {
        return RxCallbackScheduler.scheduleResultSync(orgTestRepository.checkStudentInPlan(request));
    }
}
