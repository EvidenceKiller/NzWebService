package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
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
import com.adl.service.web.BigScreenH5Service;
import com.adl.service.web.BigScreenStatsService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class BigScreenStatsFetchHelper {

    private volatile BigScreenStatsService bigScreenStatsService;
    private volatile String baseUrl;

    public BigScreenStatsFetchHelper() {
    }

    private synchronized BigScreenStatsService getService() {
        if (bigScreenStatsService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            bigScreenStatsService = RetrofitManager.getInstance().create(BigScreenStatsService.class);
        }
        return bigScreenStatsService;
    }

    public Function<WarRecordRankRequest, Single<ResponseResult<List<WarRecordRankData>>>> createGetWarRecordRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getWarRecordRank(request));
    }

    public Function<PersonRankRequest, Single<ResponseResult<PersonRankData>>> createGetPersonRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPersonRank(request));
    }

    public Function<MorePeopleVictoryRankRequest, Single<ResponseResult<List<MorePeopleVictoryRankData>>>> createGetMorePeopleVictoryRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getMorePeopleVictoryRank(request));
    }

    public Function<MorePeopleRecordRankRequest, Single<ResponseResult<List<MorePeopleRecordRankData>>>> createGetMorePeopleRecordRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getMorePeopleRecordRank(request));
    }

    public Function<OverviewRequest, Single<ResponseResult<OverviewData>>> createGetOverviewFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getOverview(request));
    }

    public Function<CompetitionRankRequest, Single<ResponseResult<CompetitionRankData>>> createGetCompetitionRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getCompetitionRank(request));
    }

    public Function<SumScoreRankRequest, Single<ResponseResult<List<SumScoreRankData>>>> createSumScoreRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().sumScoreRank(request));
    }

    public Function<SportRankRequest, Single<ResponseResult<List<SportSkuRankData>>>> createGetSportSkuRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportSkuRank(request));
    }

    public Function<SportRankRequest, Single<ResponseResult<List<SportRankKingData>>>> createGetSportRankKingFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportRankKing(request));
    }

    public Function<SportRankRequest, Single<ResponseResult<List<SportRankKingData>>>> createGetPhysicalTrainingRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPhysicalTrainingRank(request));
    }

    public Function<SportRankRequest, Single<ResponseResult<List<SportRankKingData>>>> createGetExerciseSumTimeRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getExerciseSumTimeRank(request));
    }

    public Function<BestRankTopRequest, Single<ResponseResult<List<BestRankTopData>>>> createGetBestRankTopFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getBestRankTop(request));
    }
}
