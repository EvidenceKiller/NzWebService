package com.adl.service.caller.impl;

import android.text.TextUtils;
import android.util.Pair;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.OrgTestCaller;
import com.adl.service.common.IDefine;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.exception.NzBaseException;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.internal.SubscriptionManager;
import com.adl.service.log.NzLog;
import com.adl.service.persistence.BasePagePersistence;
import com.adl.service.persistence.BasePersistence;
import com.adl.service.persistence.OrgTestPersistenceHelper;
import com.adl.service.utils.InnerUtil;
import com.adl.service.web.request.CheckStudentInPlanRequest;
import com.adl.service.web.request.PlanClassListRequest;
import com.adl.service.web.request.PlanInfoRequest;
import com.adl.service.web.request.PlanPageRequest;
import com.adl.service.web.request.PlanStudentPageRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.StandardConfigPageRequest;
import com.adl.service.web.response.BasePageData;
import com.adl.service.web.response.PlanClassData;
import com.adl.service.web.response.PlanData;
import com.adl.service.web.response.PlanInfoData;
import com.adl.service.web.response.PlanStudentData;
import com.adl.service.web.response.SportProjectData;
import com.adl.service.web.response.StandardConfigData;
import com.adl.service.web.service.OrgTestService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * OrgTestCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class OrgTestCallerImpl implements OrgTestCaller {

    private final OrgTestService orgTestService;

    public OrgTestCallerImpl(OrgTestService orgTestService) {
        this.orgTestService = orgTestService;
    }

    @Override
    public void reLoadAllOrgTestDataSync(boolean syncStandard) throws NzBaseException {
        long serverTime = InnerUtil.getServerTime();
        NzLog.d("服务器时间: " + InnerUtil.formatByTimeCode(serverTime));
        List<Integer> statusList = Arrays.asList(IDefine.SportPlanStatusNew, IDefine.SportPlanStatusDoing);

        ////////////// 1.同步全部运动计划 ////////////
        clearPlanDataSync();
        List<PlanData> planDataList = new ArrayList<>();
        for (Integer status : statusList) {
            PlanPageRequest planPageRequest = PlanPageRequest.builder()
                    .standardType(IDefine.standardTypeALL)
                    .status(String.valueOf(status))
                    .build();
            planDataList.addAll(getPlanPagesAllSync(planPageRequest));
        }
        NzLog.d("reGetAllOrgTestDataSync merged plan count: " + planDataList.size());

        ////////////// 2.同步运动计划下学生 ////////////
        clearPlanStudentDataSync();
        for (PlanData plan : planDataList) {
            if (TextUtils.isEmpty(plan.getEndTime()) || serverTime > Long.parseLong(plan.getEndTime())) {
                continue;
            }
            PlanStudentPageRequest request = PlanStudentPageRequest.builder(plan.getPlanId())
                    .build();
            getPlanStudentPagesAllSync(request);
        }

        ////////////// 3.同步运动标准 ////////////
        if (syncStandard) {
            clearStandardConfigDataSync();
            ArrayList<Pair<String, String>> standardList = new ArrayList<>();

            for (PlanData plan : planDataList) {
                if (plan.getSportProjects() == null) {
                    continue;
                }

                if (TextUtils.isEmpty(plan.getEndTime()) || serverTime > Long.parseLong(plan.getEndTime())) {
                    continue;
                }

                for (SportProjectData project : plan.getSportProjects()) {
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
    public void clearStandardConfigDataSync() {
        DaoManagerProxy.getInstance().getStandardConfigDao().clearAll();
    }

    @Override
    public long getStandardConfigPagesAllAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigData>> callback) {
        CallerUtil.assertCurrent(request);
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.schedule(BasePagePersistence.persistAllListsAsSingle(
                OrgTestPersistenceHelper.createStandardConfigPageRequester(request, req -> orgTestService.getStandardConfigPage(req)),
                OrgTestPersistenceHelper.createStandardConfigPagePersister()), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<StandardConfigData> getStandardConfigPagesAllSync(StandardConfigPageRequest request) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        return RxCallbackScheduler.blockingGet(BasePagePersistence.persistAllListsAsSingle(
                OrgTestPersistenceHelper.createStandardConfigPageRequester(request, req -> orgTestService.getStandardConfigPage(req)),
                OrgTestPersistenceHelper.createStandardConfigPagePersister()));
    }

    @Override
    public long getStandardConfigPageAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigData>> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(orgTestService.getStandardConfigPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<StandardConfigData> getStandardConfigPageSync(StandardConfigPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(orgTestService.getStandardConfigPage(request));
    }

    @Override
    public void clearPlanStudentDataSync() {
        DaoManagerProxy.getInstance().getPlanStudentDao().clearAll();
    }

    @Override
    public long getPlanStudentPagesAllASync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<List<PlanStudentData>> callback) {
        CallerUtil.assertCurrent(request);
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.schedule(BasePagePersistence.persistAllPagesAsSingle(
                OrgTestPersistenceHelper.createPlanStudentPagePreparer(request.getPlanId()),
                OrgTestPersistenceHelper.createPlanStudentPageRequester(request, req -> orgTestService.getPlanStudentPage(req)),
                OrgTestPersistenceHelper.createPlanStudentPagePersister(request.getPlanId())), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<PlanStudentData> getPlanStudentPagesAllSync(PlanStudentPageRequest request) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        return RxCallbackScheduler.blockingGet(BasePagePersistence.persistAllPagesAsSingle(
                OrgTestPersistenceHelper.createPlanStudentPagePreparer(request.getPlanId()),
                OrgTestPersistenceHelper.createPlanStudentPageRequester(request, req -> orgTestService.getPlanStudentPage(req)),
                OrgTestPersistenceHelper.createPlanStudentPagePersister(request.getPlanId())));
    }

    @Override
    public long getPlanStudentPageAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<BasePageData<PlanStudentData>> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(orgTestService.getPlanStudentPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public BasePageData<PlanStudentData> getPlanStudentPageSync(PlanStudentPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(orgTestService.getPlanStudentPage(request));
    }

    @Override
    public void clearPlanDataSync() {
        DaoManagerProxy.getInstance().getPlanDao().clearAll();
    }

    @Override
    public long getPlanPagesAllAsync(RequestScope scope, PlanPageRequest request, RequestCallback<List<PlanData>> callback) {
        CallerUtil.assertCurrent(request);
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.schedule(BasePagePersistence.persistAllPagesAsSingle(
                OrgTestPersistenceHelper.createPlanPageRequester(request, req -> orgTestService.getPlanPage(req)),
                OrgTestPersistenceHelper.createPlanPagePersister()), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<PlanData> getPlanPagesAllSync(PlanPageRequest request) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        return RxCallbackScheduler.blockingGet(BasePagePersistence.persistAllPagesAsSingle(
                OrgTestPersistenceHelper.createPlanPageRequester(request, req -> orgTestService.getPlanPage(req)),
                OrgTestPersistenceHelper.createPlanPagePersister()));
    }

    @Override
    public long getPlanPageAsync(RequestScope scope, PlanPageRequest request, RequestCallback<BasePageData<PlanData>> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(BasePagePersistence.persistOnePageAsSingle(
                BasePersistence.createBaseRequester(request, req -> orgTestService.getPlanPage(req)),
                OrgTestPersistenceHelper.createPlanPagePersister()), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public BasePageData<PlanData> getPlanPageSync(PlanPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(BasePagePersistence.persistOnePageAsSingle(
                BasePersistence.createBaseRequester(request, req -> orgTestService.getPlanPage(req)),
                OrgTestPersistenceHelper.createPlanPagePersister()));
    }

    @Override
    public long getPlanInfoAsync(RequestScope scope, PlanInfoRequest request, RequestCallback<PlanInfoData> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(orgTestService.getPlanInfo(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public PlanInfoData getPlanInfoSync(PlanInfoRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(orgTestService.getPlanInfo(request));
    }

    @Override
    public long getPlanClassListAsync(RequestScope scope, PlanClassListRequest request, RequestCallback<List<PlanClassData>> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(orgTestService.getPlanClassList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<PlanClassData> getPlanClassListSync(PlanClassListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(orgTestService.getPlanClassList(request));
    }

    @Override
    public long checkStudentInPlanAsync(RequestScope scope, CheckStudentInPlanRequest request, RequestCallback<Boolean> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(orgTestService.checkStudentInPlan(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Boolean checkStudentInPlanSync(CheckStudentInPlanRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(orgTestService.checkStudentInPlan(request));
    }
}
