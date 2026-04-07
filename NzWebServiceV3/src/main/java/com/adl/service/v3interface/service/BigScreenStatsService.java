package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.request.BestRankTopRequest;
import com.example.rxsdk.v3interface.request.CompetitionRankRequest;
import com.example.rxsdk.v3interface.request.ExerciseSumTimeRankRequest;
import com.example.rxsdk.v3interface.request.MorePeopleRecordRankRequest;
import com.example.rxsdk.v3interface.request.MorePeopleVictoryRankRequest;
import com.example.rxsdk.v3interface.request.OverviewRequest;
import com.example.rxsdk.v3interface.request.PersonRankRequest;
import com.example.rxsdk.v3interface.request.PhysicalTrainingRankRequest;
import com.example.rxsdk.v3interface.request.SportRankKingRequest;
import com.example.rxsdk.v3interface.request.SportSkuRankRequest;
import com.example.rxsdk.v3interface.request.SumScoreRankRequest;
import com.example.rxsdk.v3interface.request.WarRecordRankRequest;
import com.example.rxsdk.v3interface.response.BestRankTopData;
import com.example.rxsdk.v3interface.response.CompetitionRankData;
import com.example.rxsdk.v3interface.response.ExerciseSumTimeRankData;
import com.example.rxsdk.v3interface.response.MorePeopleRecordRankData;
import com.example.rxsdk.v3interface.response.MorePeopleVictoryRankData;
import com.example.rxsdk.v3interface.response.OverviewData;
import com.example.rxsdk.v3interface.response.PersonRankData;
import com.example.rxsdk.v3interface.response.PhysicalTrainingRankData;
import com.example.rxsdk.v3interface.response.SportRankKingData;
import com.example.rxsdk.v3interface.response.SportSkuRankData;
import com.example.rxsdk.v3interface.response.SumScoreRankData;
import com.example.rxsdk.v3interface.response.WarRecordRankData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/** Auto-generated from v3interface HTML. */
public interface BigScreenStatsService {
    /** 双人对战排行榜 — 来源:test1 */
    @POST("tis/device/statistics/account/sport/warRecordRank")
    Single<BaseResponse<List<WarRecordRankData>>> getWarRecordRank(@Body WarRecordRankRequest request);

    /** 个人运动排名 — 来源:test1 */
    @POST("tis/device/statistics/account/sport/personRank")
    Single<BaseResponse<PersonRankData>> getPersonRank(@Body PersonRankRequest request);

    /** 多人对战胜利榜 — 来源:test1 */
    @POST("tis/device/statistics/account/sport/morePeopleVictoryRank")
    Single<BaseResponse<List<MorePeopleVictoryRankData>>> getMorePeopleVictoryRank(@Body MorePeopleVictoryRankRequest request);

    /** 多人对战排行榜 — 来源:test1 */
    @POST("tis/device/statistics/account/sport/morePeopleRecordRank")
    Single<BaseResponse<List<MorePeopleRecordRankData>>> getMorePeopleRecordRank(@Body MorePeopleRecordRankRequest request);

    /** 总览数据 — 来源:test1 */
    @POST("tis/device/statistics/home/sport/overview")
    Single<BaseResponse<OverviewData>> getOverview(@Body OverviewRequest request);

    /** 赛事排行榜 — 来源:test1 */
    @POST("tis/device/statistics/pco/sport/competitionRank")
    Single<BaseResponse<CompetitionRankData>> getCompetitionRank(@Body CompetitionRankRequest request);

    /** 项目结果求和排名 — 来源:test1 */
    @POST("tis/device/statistics/exercise/sport/sumScoreRank")
    Single<BaseResponse<List<SumScoreRankData>>> getSumScoreRank(@Body SumScoreRankRequest request);

    /** 项目热度排行 — 来源:test1 */
    @POST("tis/device/statistics/exercise/sport/sportSkuRank")
    Single<BaseResponse<List<SportSkuRankData>>> getSportSkuRank(@Body SportSkuRankRequest request);

    /** 霸榜之王 — 来源:test1 */
    @POST("tis/device/statistics/exercise/sport/sportRankKing")
    Single<BaseResponse<List<SportRankKingData>>> getSportRankKing(@Body SportRankKingRequest request);

    /** 锻炼排行榜、历史最佳 — 来源:test1 */
    @POST("tis/device/statistics/exercise/sport/physicalTrainingRank")
    Single<BaseResponse<List<PhysicalTrainingRankData>>> getPhysicalTrainingRank(@Body PhysicalTrainingRankRequest request);

    /** 锻炼之星 — 来源:test1 */
    @POST("tis/device/statistics/exercise/sport/exerciseSumTimeRank")
    Single<BaseResponse<List<ExerciseSumTimeRankData>>> getExerciseSumTimeRank(@Body ExerciseSumTimeRankRequest request);

    /** 最佳榜单 — 来源:test1 */
    @POST("tis/device/statistics/exercise/sport/bestRankTop")
    Single<BaseResponse<List<BestRankTopData>>> getBestRankTop(@Body BestRankTopRequest request);
}
