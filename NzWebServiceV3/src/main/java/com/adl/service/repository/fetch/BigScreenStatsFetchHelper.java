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

    public Function<WarRecordRankRequest, Single<List<WarRecordRankData>>> createGetWarRecordRankFunc() {
        return (request) -> bigScreenStatsService.getWarRecordRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<PersonRankRequest, Single<PersonRankData>> createGetPersonRankFunc() {
        return (request) -> bigScreenStatsService.getPersonRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<MorePeopleVictoryRankRequest, Single<List<MorePeopleVictoryRankData>>> createGetMorePeopleVictoryRankFunc() {
        return (request) -> bigScreenStatsService.getMorePeopleVictoryRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<MorePeopleRecordRankRequest, Single<List<MorePeopleRecordRankData>>> createGetMorePeopleRecordRankFunc() {
        return (request) -> bigScreenStatsService.getMorePeopleRecordRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<OverviewRequest, Single<OverviewData>> createGetOverviewFunc() {
        return (request) -> bigScreenStatsService.getOverview(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<CompetitionRankRequest, Single<CompetitionRankData>> createGetCompetitionRankFunc() {
        return (request) -> bigScreenStatsService.getCompetitionRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<SumScoreRankRequest, Single<List<SumScoreRankData>>> createSumScoreRankFunc() {
        return (request) -> bigScreenStatsService.sumScoreRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<SportRankRequest, Single<List<SportSkuRankData>>> createGetSportSkuRankFunc() {
        return (request) -> bigScreenStatsService.getSportSkuRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<SportRankRequest, Single<List<SportRankKingData>>> createGetSportRankKingFunc() {
        return (request) -> bigScreenStatsService.getSportRankKing(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<SportRankRequest, Single<List<SportRankKingData>>> createGetPhysicalTrainingRankFunc() {
        return (request) -> bigScreenStatsService.getPhysicalTrainingRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<SportRankRequest, Single<List<SportRankKingData>>> createGetExerciseSumTimeRankFunc() {
        return (request) -> bigScreenStatsService.getExerciseSumTimeRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<BestRankTopRequest, Single<List<BestRankTopData>>> createGetBestRankTopFunc() {
        return (request) -> bigScreenStatsService.getBestRankTop(request).map(BaseFetchUtil::scheduleResponse);
    }
}
