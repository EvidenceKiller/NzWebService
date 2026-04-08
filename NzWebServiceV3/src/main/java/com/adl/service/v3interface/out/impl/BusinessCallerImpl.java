package com.adl.service.v3interface.out.impl;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.api.RxSdk;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.exception.NzBaseException;
import com.adl.service.v3interface.internal.RxCallbackScheduler;
import com.adl.service.v3interface.internal.SubscriptionManager;
import com.adl.service.v3interface.out.BusinessCaller;
import com.adl.service.v3interface.request.CompetitionPageRequest;
import com.adl.service.v3interface.request.CompetitionRankDetailRequest;
import com.adl.service.v3interface.request.DownloadGroupTeamDetailPageRequest;
import com.adl.service.v3interface.request.DownloadGroupTeamPageRequest;
import com.adl.service.v3interface.request.GetGroupRequest;
import com.adl.service.v3interface.request.JoinCompetitionRankRequest;
import com.adl.service.v3interface.request.ResInfoRequest;
import com.adl.service.v3interface.request.ResPageRequest;
import com.adl.service.v3interface.request.ResTypeListRequest;
import com.adl.service.v3interface.request.SaveGroupRequest;
import com.adl.service.v3interface.request.SportMeetPageRequest;
import com.adl.service.v3interface.request.TrainPlanInfoPageRequest;
import com.adl.service.v3interface.request.TrainPlanOneDayProjectListRequest;
import com.adl.service.v3interface.response.CompetitionPageData;
import com.adl.service.v3interface.response.CompetitionRankDetailData;
import com.adl.service.v3interface.response.GroupData;
import com.adl.service.v3interface.response.GroupTeamData;
import com.adl.service.v3interface.response.GroupTeamDetailData;
import com.adl.service.v3interface.response.ResInfoData;
import com.adl.service.v3interface.response.ResPageData;
import com.adl.service.v3interface.response.ResTypeData;
import com.adl.service.v3interface.response.SportMeetPageData;
import com.adl.service.v3interface.response.TrainPlanInfoPageData;
import com.adl.service.v3interface.response.TrainPlanOneDayProjectData;
import com.adl.service.v3interface.service.BusinessService;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * BusinessCaller 实现（SDK 内部使用，通过 {@link RxSdk} 暴露）。
 */
public final class BusinessCallerImpl implements BusinessCaller {

    private final BusinessService businessService;

    public BusinessCallerImpl(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Override
    public long saveGroupAsync(RequestScope scope, SaveGroupRequest request, RequestCallback<Boolean> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.saveGroup(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Boolean saveGroupSync(SaveGroupRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.saveGroup(request));
    }

    @Override
    public long getGroupAsync(RequestScope scope, GetGroupRequest request, RequestCallback<GroupData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getGroup(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public GroupData getGroupSync(GetGroupRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getGroup(request));
    }

    @Override
    public long getTrainPlanOneDayProjectListAsync(RequestScope scope, TrainPlanOneDayProjectListRequest request, RequestCallback<List<TrainPlanOneDayProjectData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getTrainPlanOneDayProjectList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<TrainPlanOneDayProjectData> getTrainPlanOneDayProjectListSync(TrainPlanOneDayProjectListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getTrainPlanOneDayProjectList(request));
    }

    @Override
    public long getTrainPlanInfoPageAsync(RequestScope scope, TrainPlanInfoPageRequest request, RequestCallback<TrainPlanInfoPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getTrainPlanInfoPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public TrainPlanInfoPageData getTrainPlanInfoPageSync(TrainPlanInfoPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getTrainPlanInfoPage(request));
    }

    @Override
    public long joinCompetitionRankAsync(RequestScope scope, JoinCompetitionRankRequest request, RequestCallback<Boolean> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.joinCompetitionRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Boolean joinCompetitionRankSync(JoinCompetitionRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.joinCompetitionRank(request));
    }

    @Override
    public long getCompetitionRankDetailAsync(RequestScope scope, CompetitionRankDetailRequest request, RequestCallback<CompetitionRankDetailData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getCompetitionRankDetail(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public CompetitionRankDetailData getCompetitionRankDetailSync(CompetitionRankDetailRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getCompetitionRankDetail(request));
    }

    @Override
    public long getCompetitionPageAsync(RequestScope scope, CompetitionPageRequest request, RequestCallback<CompetitionPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getCompetitionPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public CompetitionPageData getCompetitionPageSync(CompetitionPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getCompetitionPage(request));
    }

    @Override
    public long getSportMeetPageAsync(RequestScope scope, SportMeetPageRequest request, RequestCallback<SportMeetPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getSportMeetPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public SportMeetPageData getSportMeetPageSync(SportMeetPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getSportMeetPage(request));
    }

    @Override
    public long downloadGroupTeamPageAsync(RequestScope scope, DownloadGroupTeamPageRequest request, RequestCallback<List<GroupTeamData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.downloadGroupTeamPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<GroupTeamData> downloadGroupTeamPageSync(DownloadGroupTeamPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.downloadGroupTeamPage(request));
    }

    @Override
    public long downloadGroupTeamDetailPageAsync(RequestScope scope, DownloadGroupTeamDetailPageRequest request, RequestCallback<List<GroupTeamDetailData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.downloadGroupTeamDetailPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<GroupTeamDetailData> downloadGroupTeamDetailPageSync(DownloadGroupTeamDetailPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.downloadGroupTeamDetailPage(request));
    }

    @Override
    public long getResTypeListAsync(RequestScope scope, ResTypeListRequest request, RequestCallback<List<ResTypeData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getResTypeList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<ResTypeData> getResTypeListSync(ResTypeListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getResTypeList(request));
    }

    @Override
    public long getResPageAsync(RequestScope scope, ResPageRequest request, RequestCallback<ResPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getResPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public ResPageData getResPageSync(ResPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getResPage(request));
    }

    @Override
    public long getResInfoAsync(RequestScope scope, ResInfoRequest request, RequestCallback<ResInfoData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(businessService.getResInfo(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public ResInfoData getResInfoSync(ResInfoRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(businessService.getResInfo(request));
    }
}
