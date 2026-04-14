package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.OrgTestCaller;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.exception.NzBaseException;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.internal.SubscriptionManager;
import com.adl.service.persistence.BasePagePersistence;
import com.adl.service.persistence.OrgTestPersistenceHelper;
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
import com.adl.service.web.response.StandardConfigPageData;
import com.adl.service.web.service.OrgTestService;

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
    public long getStandardConfigPagesAllAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigPageData>> callback) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        CallerUtil.assertScope(scope);
        DaoManagerProxy.getInstance().getPlanDao().clearAll();
        Disposable disposable = RxCallbackScheduler.schedule(BasePagePersistence.persistAllPageListAsSingle(
                OrgTestPersistenceHelper.createStandardConfigPageRequester(request, req -> orgTestService.getStandardConfigPage(req)),
                OrgTestPersistenceHelper.createStandardConfigPagePersister()), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<StandardConfigPageData> getStandardConfigPagesAllSync(StandardConfigPageRequest request) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        DaoManagerProxy.getInstance().getPlanDao().clearAll();
        return RxCallbackScheduler.blockingGet(BasePagePersistence.persistAllPageListAsSingle(
                OrgTestPersistenceHelper.createStandardConfigPageRequester(request, req -> orgTestService.getStandardConfigPage(req)),
                OrgTestPersistenceHelper.createStandardConfigPagePersister()));
    }

    @Override
    public long getStandardConfigPageAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigPageData>> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(orgTestService.getStandardConfigPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<StandardConfigPageData> getStandardConfigPageSync(StandardConfigPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(orgTestService.getStandardConfigPage(request));
    }

    @Override
    public void clearPlanStudentDataSync() {
        DaoManagerProxy.getInstance().getPlanStudentDao().clearAll();
    }

    @Override
    public List<PlanStudentData> getPlanStudentPagesAllSync(PlanStudentPageRequest request) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        DaoManagerProxy.getInstance().getPlanStudentDao().clearByPlanId(request.getPlanId());
        return RxCallbackScheduler.blockingGet(BasePagePersistence.persistAllPagesAsSingle(
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

    public long getPlanPagesAllAsync(RequestScope scope, PlanPageRequest request, RequestCallback<List<PlanData>> callback) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        CallerUtil.assertScope(scope);
        DaoManagerProxy.getInstance().getPlanDao().clearAll();
        Disposable disposable = RxCallbackScheduler.schedule(BasePagePersistence.persistAllPagesAsSingle(
                OrgTestPersistenceHelper.createPlanPageRequester(request, req -> orgTestService.getPlanPage(req)),
                OrgTestPersistenceHelper.createPlanPagePersister()), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<PlanData> getPlanPagesAllSync(PlanPageRequest request) throws NzBaseException {
        CallerUtil.assertCurrent(request);
        DaoManagerProxy.getInstance().getPlanDao().clearAll();
        return RxCallbackScheduler.blockingGet(BasePagePersistence.persistAllPagesAsSingle(
                OrgTestPersistenceHelper.createPlanPageRequester(request, req -> orgTestService.getPlanPage(req)),
                OrgTestPersistenceHelper.createPlanPagePersister()));
    }

    @Override
    public long getPlanPageAsync(RequestScope scope, PlanPageRequest request, RequestCallback<BasePageData<PlanData>> callback) {
        CallerUtil.assertScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(BasePagePersistence.persistAfterFetch(
                orgTestService.getPlanPage(request), OrgTestPersistenceHelper.createPlanPagePersister()), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public BasePageData<PlanData> getPlanPageSync(PlanPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(BasePagePersistence.persistAfterFetch(
                orgTestService.getPlanPage(request), OrgTestPersistenceHelper.createPlanPagePersister()));
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
