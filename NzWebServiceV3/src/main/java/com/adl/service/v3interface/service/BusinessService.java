package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.request.DownloadGroupTeamDetailRequest;
import com.example.rxsdk.v3interface.request.DownloadGroupTeamRequest;
import com.example.rxsdk.v3interface.request.GetCompetitionListRequest;
import com.example.rxsdk.v3interface.request.GetCompetitionRankDetailRequest;
import com.example.rxsdk.v3interface.request.GetResListRequest;
import com.example.rxsdk.v3interface.request.GetSportMeetListRequest;
import com.example.rxsdk.v3interface.request.GetTrainPlanInfoListRequest;
import com.example.rxsdk.v3interface.request.GetTrainPlanOneDayProjectListRequest;
import com.example.rxsdk.v3interface.request.GroupRequest;
import com.example.rxsdk.v3interface.request.JoinCompetitionRankRequest;
import com.example.rxsdk.v3interface.response.DownloadGroupTeamData;
import com.example.rxsdk.v3interface.response.DownloadGroupTeamDetailData;
import com.example.rxsdk.v3interface.response.GetCompetitionListData;
import com.example.rxsdk.v3interface.response.GetCompetitionRankDetailData;
import com.example.rxsdk.v3interface.response.GetResInfoData;
import com.example.rxsdk.v3interface.response.GetResListData;
import com.example.rxsdk.v3interface.response.GetResTypeListData;
import com.example.rxsdk.v3interface.response.GetSportMeetListData;
import com.example.rxsdk.v3interface.response.GetTrainPlanInfoListData;
import com.example.rxsdk.v3interface.response.GetTrainPlanOneDayProjectListData;
import com.example.rxsdk.v3interface.response.GroupData;
import com.example.rxsdk.v3interface.response.JoinCompetitionRankData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/** Auto-generated from v3interface HTML. */
public interface BusinessService {
    /** 保存分组信息 — 来源:dev */
    @POST("tis/device/busi/org/class/group/save/group")
    Single<BaseResponse<GroupData>> getGroup(@Body GroupRequest request);

    /** 获取分组信息 — 来源:dev */
    @POST("tis/device/busi/org/class/group/get/group")
    Single<BaseResponse<GroupData>> getGroup(@Body GroupRequest request);

    /**
     * 获取资源分类列表 — 来源:dev
     * Path resType: 资源类型 1-备课助手 2-校本资源
     */
    @POST("tis/device/busi/org/res/getResTypeList/{resType}")
    Single<BaseResponse<List<GetResTypeListData>>> getGetResTypeList(@Path("resType") String resType);

    /** 获取资源列表 — 来源:dev */
    @POST("tis/device/busi/org/res/getResList")
    Single<BaseResponse<GetResListData>> getGetResList(@Body GetResListRequest request);

    /**
     * 获取资源详情 — 来源:dev
     * Path id: 资源id
     */
    @POST("tis/device/busi/org/res/getResInfo/{id}")
    Single<BaseResponse<GetResInfoData>> getGetResInfo(@Path("id") String id);

    /** 训练计划一天的项目 — 来源:dev */
    @POST("tis/device/busi/train/plan/getTrainPlanOneDayProjectList")
    Single<BaseResponse<List<GetTrainPlanOneDayProjectListData>>> getGetTrainPlanOneDayProjectList(@Body GetTrainPlanOneDayProjectListRequest request);

    /** 训练计划列表 — 来源:dev */
    @POST("tis/device/busi/train/plan/getTrainPlanInfoList")
    Single<BaseResponse<GetTrainPlanInfoListData>> getGetTrainPlanInfoList(@Body GetTrainPlanInfoListRequest request);

    /** 参与竞技排名赛事 — 来源:dev */
    @POST("tis/device/busi/org/competition/online/joinCompetitionRank")
    Single<BaseResponse<JoinCompetitionRankData>> getJoinCompetitionRank(@Body JoinCompetitionRankRequest request);

    /** 获取赛事竞技排名赛详情 — 来源:dev */
    @POST("tis/device/busi/org/competition/online/getCompetitionRankDetail")
    Single<BaseResponse<GetCompetitionRankDetailData>> getGetCompetitionRankDetail(@Body GetCompetitionRankDetailRequest request);

    /** 赛事列表 — 来源:dev */
    @POST("tis/device/busi/org/competition/online/getCompetitionList")
    Single<BaseResponse<GetCompetitionListData>> getGetCompetitionList(@Body GetCompetitionListRequest request);

    /** 获取运动会列表 — 来源:dev */
    @POST("tis/device/busi/org/meet/getSportMeetList")
    Single<BaseResponse<GetSportMeetListData>> getGetSportMeetList(@Body GetSportMeetListRequest request);

    /** 拉取编排数据 — 来源:dev */
    @POST("tis/device/busi/org/meet/downloadGroupTeam")
    Single<BaseResponse<List<DownloadGroupTeamData>>> getDownloadGroupTeam(@Body DownloadGroupTeamRequest request);

    /** 拉取编排详情数据 — 来源:dev */
    @POST("tis/device/busi/org/meet/downloadGroupTeamDetail")
    Single<BaseResponse<List<DownloadGroupTeamDetailData>>> getDownloadGroupTeamDetail(@Body DownloadGroupTeamDetailRequest request);
}
