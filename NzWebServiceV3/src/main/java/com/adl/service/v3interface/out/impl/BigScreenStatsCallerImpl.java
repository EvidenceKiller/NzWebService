package com.adl.service.v3interface.out.impl;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.api.RxSdk;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.exception.NzBaseException;
import com.adl.service.v3interface.internal.RxCallbackScheduler;
import com.adl.service.v3interface.internal.SubscriptionManager;
import com.adl.service.v3interface.out.BigScreenStatsCaller;
import com.adl.service.v3interface.request.BestRankTopRequest;
import com.adl.service.v3interface.request.CompetitionRankRequest;
import com.adl.service.v3interface.request.MorePeopleRecordRankRequest;
import com.adl.service.v3interface.request.MorePeopleVictoryRankRequest;
import com.adl.service.v3interface.request.OverviewRequest;
import com.adl.service.v3interface.request.PersonRankRequest;
import com.adl.service.v3interface.request.SportRankRequest;
import com.adl.service.v3interface.request.SumScoreRankRequest;
import com.adl.service.v3interface.request.WarRecordRankRequest;
import com.adl.service.v3interface.response.BestRankTopData;
import com.adl.service.v3interface.response.CompetitionRankData;
import com.adl.service.v3interface.response.ExerciseSumTimeRankData;
import com.adl.service.v3interface.response.MorePeopleRecordRankData;
import com.adl.service.v3interface.response.MorePeopleVictoryRankData;
import com.adl.service.v3interface.response.OverviewData;
import com.adl.service.v3interface.response.PersonRankData;
import com.adl.service.v3interface.response.PhysicalTrainingRankData;
import com.adl.service.v3interface.response.SportRankKingData;
import com.adl.service.v3interface.response.SportSkuRankData;
import com.adl.service.v3interface.response.SumScoreRankData;
import com.adl.service.v3interface.response.WarRecordRankData;
import com.adl.service.v3interface.service.BigScreenStatsService;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * BigScreenStatsCaller 实现（SDK 内部使用，通过 {@link RxSdk} 暴露）。
 */
public final class BigScreenStatsCallerImpl implements BigScreenStatsCaller {

    private final BigScreenStatsService bigScreenStatsService;

    public BigScreenStatsCallerImpl(BigScreenStatsService bigScreenStatsService) {
        this.bigScreenStatsService = bigScreenStatsService;
    }

    @Override
    public long getWarRecordRankAsync(RequestScope scope, WarRecordRankRequest request, RequestCallback<List<WarRecordRankData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getWarRecordRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<WarRecordRankData> getWarRecordRankSync(WarRecordRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getWarRecordRank(request));
    }

    @Override
    public long getPersonRankAsync(RequestScope scope, PersonRankRequest request, RequestCallback<PersonRankData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getPersonRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public PersonRankData getPersonRankSync(PersonRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getPersonRank(request));
    }

    @Override
    public long getMorePeopleVictoryRankAsync(RequestScope scope, MorePeopleVictoryRankRequest request, RequestCallback<List<MorePeopleVictoryRankData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getMorePeopleVictoryRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<MorePeopleVictoryRankData> getMorePeopleVictoryRankSync(MorePeopleVictoryRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getMorePeopleVictoryRank(request));
    }

    @Override
    public long getMorePeopleRecordRankAsync(RequestScope scope, MorePeopleRecordRankRequest request, RequestCallback<List<MorePeopleRecordRankData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getMorePeopleRecordRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<MorePeopleRecordRankData> getMorePeopleRecordRankSync(MorePeopleRecordRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getMorePeopleRecordRank(request));
    }

    @Override
    public long getOverviewAsync(RequestScope scope, OverviewRequest request, RequestCallback<OverviewData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getOverview(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public OverviewData getOverviewSync(OverviewRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getOverview(request));
    }

    @Override
    public long getCompetitionRankAsync(RequestScope scope, CompetitionRankRequest request, RequestCallback<CompetitionRankData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getCompetitionRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public CompetitionRankData getCompetitionRankSync(CompetitionRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getCompetitionRank(request));
    }

    @Override
    public long sumScoreRankAsync(RequestScope scope, SumScoreRankRequest request, RequestCallback<List<SumScoreRankData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.sumScoreRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<SumScoreRankData> sumScoreRankSync(SumScoreRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.sumScoreRank(request));
    }

    @Override
    public long getSportSkuRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<SportSkuRankData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getSportSkuRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<SportSkuRankData> getSportSkuRankSync(SportRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getSportSkuRank(request));
    }

    @Override
    public long getSportRankKingAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<SportRankKingData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getSportRankKing(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<SportRankKingData> getSportRankKingSync(SportRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getSportRankKing(request));
    }

    @Override
    public long getPhysicalTrainingRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<PhysicalTrainingRankData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getPhysicalTrainingRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<PhysicalTrainingRankData> getPhysicalTrainingRankSync(SportRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getPhysicalTrainingRank(request));
    }

    @Override
    public long getExerciseSumTimeRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<ExerciseSumTimeRankData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getExerciseSumTimeRank(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<ExerciseSumTimeRankData> getExerciseSumTimeRankSync(SportRankRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getExerciseSumTimeRank(request));
    }

    @Override
    public long getBestRankTopAsync(RequestScope scope, BestRankTopRequest request, RequestCallback<List<BestRankTopData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenStatsService.getBestRankTop(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<BestRankTopData> getBestRankTopSync(BestRankTopRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenStatsService.getBestRankTop(request));
    }
}
