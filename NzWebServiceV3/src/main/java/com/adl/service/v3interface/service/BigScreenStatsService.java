package com.adl.service.v3interface.service;

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
import com.example.rxsdk.response.BaseResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface BigScreenStatsService {
    /**
     * 双人对战排行榜
     */
    @POST("tis/device/statistics/account/sport/warRecordRank")
    Single<BaseResponse<List<WarRecordRankData>>> getWarRecordRank(@Body WarRecordRankRequest request);

    /**
     * 个人运动排名
     */
    @POST("tis/device/statistics/account/sport/personRank")
    Single<BaseResponse<PersonRankData>> getPersonRank(@Body PersonRankRequest request);

    /**
     * 多人对战胜利榜
     */
    @POST("tis/device/statistics/account/sport/morePeopleVictoryRank")
    Single<BaseResponse<List<MorePeopleVictoryRankData>>> getMorePeopleVictoryRank(@Body MorePeopleVictoryRankRequest request);

    /**
     * 多人对战排行榜
     */
    @POST("tis/device/statistics/account/sport/morePeopleRecordRank")
    Single<BaseResponse<List<MorePeopleRecordRankData>>> getMorePeopleRecordRank(@Body MorePeopleRecordRankRequest request);

    /**
     * 总览数据
     */
    @POST("tis/device/statistics/home/sport/overview")
    Single<BaseResponse<OverviewData>> getOverview(@Body OverviewRequest request);

    /**
     * 赛事排行榜
     */
    @POST("tis/device/statistics/pco/sport/competitionRank")
    Single<BaseResponse<CompetitionRankData>> getCompetitionRank(@Body CompetitionRankRequest request);

    /**
     * 项目结果求和排名
     */
    @POST("tis/device/statistics/exercise/sport/sumScoreRank")
    Single<BaseResponse<List<SumScoreRankData>>> sumScoreRank(@Body SumScoreRankRequest request);

    /**
     * 项目热度排行
     */
    @POST("tis/device/statistics/exercise/sport/sportSkuRank")
    Single<BaseResponse<List<SportSkuRankData>>> getSportSkuRank(@Body SportRankRequest request);

    /**
     * 霸榜之王
     */
    @POST("tis/device/statistics/exercise/sport/sportRankKing")
    Single<BaseResponse<List<SportRankKingData>>> getSportRankKing(@Body SportRankRequest request);

    /**
     * 锻炼排行榜、历史最佳
     */
    @POST("tis/device/statistics/exercise/sport/physicalTrainingRank")
    Single<BaseResponse<List<PhysicalTrainingRankData>>> getPhysicalTrainingRank(@Body SportRankRequest request);

    /**
     * 锻炼之星
     */
    @POST("tis/device/statistics/exercise/sport/exerciseSumTimeRank")
    Single<BaseResponse<List<ExerciseSumTimeRankData>>> getExerciseSumTimeRank(@Body SportRankRequest request);

    /**
     * 最佳榜单
     */
    @POST("tis/device/statistics/exercise/sport/bestRankTop")
    Single<BaseResponse<List<BestRankTopData>>> getBestRankTop(@Body BestRankTopRequest request);
}
