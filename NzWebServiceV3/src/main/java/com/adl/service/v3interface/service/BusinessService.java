package com.adl.service.v3interface.service;

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
import com.example.rxsdk.response.BaseResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface BusinessService {
    /**
     * 保存分组信息
     */
    @POST("tis/device/busi/org/class/group/save/group")
    Single<BaseResponse<Boolean>> saveGroup(@Body SaveGroupRequest request);

    /**
     * 获取分组信息
     */
    @POST("tis/device/busi/org/class/group/get/group")
    Single<BaseResponse<GroupData>> getGroup(@Body GetGroupRequest request);

    /**
     * 训练计划一天的项目
     */
    @POST("tis/device/busi/train/plan/getTrainPlanOneDayProjectList")
    Single<BaseResponse<List<TrainPlanOneDayProjectData>>> getTrainPlanOneDayProjectList(@Body TrainPlanOneDayProjectListRequest request);

    /**
     * 训练计划列表
     */
    @POST("tis/device/busi/train/plan/getTrainPlanInfoList")
    Single<BaseResponse<TrainPlanInfoPageData>> getTrainPlanInfoPage(@Body TrainPlanInfoPageRequest request);

    /**
     * 参与竞技排名赛事
     */
    @POST("tis/device/busi/org/competition/online/joinCompetitionRank")
    Single<BaseResponse<Boolean>> joinCompetitionRank(@Body JoinCompetitionRankRequest request);

    /**
     * 获取赛事竞技排名赛详情
     */
    @POST("tis/device/busi/org/competition/online/getCompetitionRankDetail")
    Single<BaseResponse<CompetitionRankDetailData>> getCompetitionRankDetail(@Body CompetitionRankDetailRequest request);

    /**
     * 赛事列表
     */
    @POST("tis/device/busi/org/competition/online/getCompetitionList")
    Single<BaseResponse<CompetitionPageData>> getCompetitionPage(@Body CompetitionPageRequest request);

    /**
     * 获取运动会列表
     */
    @POST("tis/device/busi/org/meet/getSportMeetList")
    Single<BaseResponse<SportMeetPageData>> getSportMeetPage(@Body SportMeetPageRequest request);

    /**
     * 拉取编排数据
     */
    @POST("tis/device/busi/org/meet/downloadGroupTeam")
    Single<BaseResponse<List<GroupTeamData>>> downloadGroupTeamPage(@Body DownloadGroupTeamPageRequest request);

    /**
     * 拉取编排详情数据
     */
    @POST("tis/device/busi/org/meet/downloadGroupTeamDetail")
    Single<BaseResponse<List<GroupTeamDetailData>>> downloadGroupTeamDetailPage(@Body DownloadGroupTeamDetailPageRequest request);

    /**
     * 获取资源分类列表
     */
    @POST("tis/device/org/res/getResTypeList")
    Single<BaseResponse<List<ResTypeData>>> getResTypeList(@Body ResTypeListRequest request);

    /**
     * 获取资源列表
     */
    @POST("tis/device/org/res/getResList")
    Single<BaseResponse<ResPageData>> getResPage(@Body ResPageRequest request);

    /**
     * 获取资源详情
     */
    @POST("tis/device/org/res/getResInfo")
    Single<BaseResponse<ResInfoData>> getResInfo(@Body ResInfoRequest request);

}
