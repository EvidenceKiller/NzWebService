package com.adl.service.repository;

import android.text.TextUtils;
import android.util.Pair;

import com.adl.service.callback.GetPageResult;
import com.adl.service.common.IDefine;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;
import com.adl.service.data.TimeStamp;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.PlanEntity;
import com.adl.service.db.entity.SportProjectEntity;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassPageRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.StandardConfigPageRequest;
import com.adl.service.log.NzLog;
import com.adl.service.repository.fetch.CommonInfoFetchHelper;
import com.adl.service.repository.fetch.OrgTestFetchHelper;
import com.adl.service.repository.persist.OrgTestPersistHelper;
import com.adl.service.repository.prepare.OrgTestPrepareHelper;
import com.adl.service.utils.InnerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public final class OrgTestRepository {
    private final OrgTestPrepareHelper prepareHelper = OrgTestPrepareHelper.getInstance();
    private final OrgTestFetchHelper fetchHelper = OrgTestFetchHelper.getInstance();
    private final OrgTestPersistHelper persistHelper = OrgTestPersistHelper.getInstance();

    public OrgTestRepository() {
    }

    public void reLoadAllOrgTestDataSync(boolean syncStandard) {
        TimeStamp timeStamp = BaseRepositoryUtil.repositoryAsSingle(CommonInfoFetchHelper.getInstance().createGetServerTimeFunc()).blockingGet();
        NzLog.d("服务器时间: " + timeStamp.getCurrentTime());
        long serverTime = timeStamp.getTimestamp() * 1000L;
        List<Integer> statusList = Arrays.asList(IDefine.SportPlanStatusNew, IDefine.SportPlanStatusDoing);

        ////////////// 1.同步全部运动计划 ////////////
        clearPlanData().blockingGet();
        GetPageResult planSyncResult = new GetPageResult();
        for (Integer status : statusList) {
            PlanPageRequest planPageRequest = PlanPageRequest.builder()
                    .standardType(IDefine.standardTypeALL)
                    .status(String.valueOf(status))
                    .build();
            GetPageResult singleResult = getPlanPagesAll(planPageRequest).blockingGet();
            planSyncResult.setSuccessedPages(planSyncResult.getSuccessedPages() + singleResult.getSuccessedPages());
            planSyncResult.setFetchedCount(planSyncResult.getFetchedCount() + singleResult.getFetchedCount());
            planSyncResult.setPersistedCount(planSyncResult.getPersistedCount() + singleResult.getPersistedCount());
            planSyncResult.setTotalPages(planSyncResult.getTotalPages() + singleResult.getTotalPages());
        }
        planSyncResult.setSuccess(true);
        List<PlanEntity> planDataList = DaoManagerProxy.getInstance().getPlanDao().getAll();
        NzLog.d("reGetAllOrgTestDataSync merged plan count: " + planDataList.size() + ", request result: " + planSyncResult);

        ////////////// 2.同步运动计划下学生 ////////////
        clearPlanStudentData().blockingGet();
        for (PlanEntity plan : planDataList) {
            if (TextUtils.isEmpty(plan.getEndTime()) || serverTime > Long.parseLong(plan.getEndTime())) {
                continue;
            }
            PlanStudentPageRequest request = PlanStudentPageRequest.builder(plan.getPlanId())
                    .build();
            getPlanStudentPagesAll(request).blockingGet();
        }

        ////////////// 3.同步运动标准 ////////////
        if (syncStandard) {
            clearStandardConfigData().blockingGet();
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
                getStandardConfigPagesAll(request).blockingGet();
            }
        }
    }

    public Single<Void> clearStandardConfigData() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createPrepareStandardConfigDataFunc());
    }

    public Single<GetPageResult> getStandardConfigPagesAll(StandardConfigPageRequest request) {
        return BaseRepositoryUtil.repositoryListsAsSingle(request,
                fetchHelper.createGetStandardConfigPagesAllFunc(request),
                persistHelper.createPersistStandardConfigPageFunc());
    }

    public Single<List<StandardConfigData>> getStandardConfigPage(StandardConfigPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                fetchHelper.createGetStandardConfigPageFunc(),
                persistHelper.createPersistStandardConfigPageFunc());
    }

    public Single<Void> clearPlanStudentData() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createClearPlanStudentPagesAllFunc());
    }

    public Single<GetPageResult> getPlanStudentPagesAll(PlanStudentPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createPreparePlanStudentPagesAllFunc(),
                fetchHelper.createGetPlanStudentPagesAllFunc(request),
                persistHelper.createPersistPlanStudentPageFunc(request));
    }

    public Single<List<PlanStudentData>> getPlanStudentPage(PlanStudentPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetPlanStudentPageFunc(),
                persistHelper.createPersistPlanStudentPageFunc(request));
    }

    public Single<Void> clearPlanData() {
        return BaseRepositoryUtil.repositoryAsSingle(prepareHelper.createClearPlanPagesAllFunc());
    }

    public Single<GetPageResult> getPlanPagesAll(PlanPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                fetchHelper.createGetPlanPagesAllFunc(request),
                persistHelper.createPersistPlanPageFunc(request));
    }

    public Single<List<PlanData>> getPlanPage(PlanPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetPlanPageFunc(),
                persistHelper.createPersistPlanPageFunc(request));
    }

    public Single<PlanInfoData> getPlanInfo(PlanInfoRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetPlanInfoFunc());
    }

    public Single<List<PlanClassData>> getPlanClassPage(PlanClassPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetPlanClassPageFunc());
    }

    public Single<Boolean> checkStudentInPlan(CheckStudentInPlanRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createCheckStudentInPlanFunc());
    }
}
