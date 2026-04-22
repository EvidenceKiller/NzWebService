package com.adl.service.repository.fetch;

import com.adl.service.data.BestRankTopData;
import com.adl.service.data.CompetitionRankData;
import com.adl.service.data.MorePeopleRecordRankData;
import com.adl.service.data.MorePeopleVictoryRankData;
import com.adl.service.data.OverviewData;
import com.adl.service.data.PersonRankData;
import com.adl.service.data.SportRankKingData;
import com.adl.service.data.SportSkuRankData;
import com.adl.service.data.SumScoreRankData;
import com.adl.service.data.WarRecordRankData;
import com.adl.service.http.request.BestRankTopRequest;
import com.adl.service.http.request.CompetitionRankRequest;
import com.adl.service.http.request.MorePeopleRecordRankRequest;
import com.adl.service.http.request.MorePeopleVictoryRankRequest;
import com.adl.service.http.request.OverviewRequest;
import com.adl.service.http.request.PersonRankRequest;
import com.adl.service.http.request.SportRankRequest;
import com.adl.service.http.request.SumScoreRankRequest;
import com.adl.service.http.request.WarRecordRankRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.BigScreenStatsService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class BigScreenStatsFetchHelper {

    private final BigScreenStatsService bigScreenStatsService;

    public BigScreenStatsFetchHelper() {
        this.bigScreenStatsService = RetrofitManager.getInstance().create(BigScreenStatsService.class);
    }

    @SuppressWarnings("unchecked")
    public Function<WarRecordRankRequest, Single<List<WarRecordRankData>>> createGetWarRecordRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getWarRecordRank(request), (Class<List<WarRecordRankData>>) (Class<?>) List.class);
    }

    public Function<PersonRankRequest, Single<PersonRankData>> createGetPersonRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getPersonRank(request), PersonRankData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<MorePeopleVictoryRankRequest, Single<List<MorePeopleVictoryRankData>>> createGetMorePeopleVictoryRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getMorePeopleVictoryRank(request), (Class<List<MorePeopleVictoryRankData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<MorePeopleRecordRankRequest, Single<List<MorePeopleRecordRankData>>> createGetMorePeopleRecordRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getMorePeopleRecordRank(request), (Class<List<MorePeopleRecordRankData>>) (Class<?>) List.class);
    }

    public Function<OverviewRequest, Single<OverviewData>> createGetOverviewFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getOverview(request), OverviewData.class);
    }

    public Function<CompetitionRankRequest, Single<CompetitionRankData>> createGetCompetitionRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getCompetitionRank(request), CompetitionRankData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SumScoreRankRequest, Single<List<SumScoreRankData>>> createSumScoreRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.sumScoreRank(request), (Class<List<SumScoreRankData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SportRankRequest, Single<List<SportSkuRankData>>> createGetSportSkuRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getSportSkuRank(request), (Class<List<SportSkuRankData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SportRankRequest, Single<List<SportRankKingData>>> createGetSportRankKingFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getSportRankKing(request), (Class<List<SportRankKingData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SportRankRequest, Single<List<SportRankKingData>>> createGetPhysicalTrainingRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getPhysicalTrainingRank(request), (Class<List<SportRankKingData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SportRankRequest, Single<List<SportRankKingData>>> createGetExerciseSumTimeRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getExerciseSumTimeRank(request), (Class<List<SportRankKingData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<BestRankTopRequest, Single<List<BestRankTopData>>> createGetBestRankTopFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenStatsService.getBestRankTop(request), (Class<List<BestRankTopData>>) (Class<?>) List.class);
    }
}
