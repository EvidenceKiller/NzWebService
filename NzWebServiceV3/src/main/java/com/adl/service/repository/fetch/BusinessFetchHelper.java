package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.BasePageData;
import com.adl.service.data.CompetitionData;
import com.adl.service.data.CompetitionRankDetailData;
import com.adl.service.data.GroupData;
import com.adl.service.data.GroupTeamData;
import com.adl.service.data.GroupTeamDetailData;
import com.adl.service.data.ResData;
import com.adl.service.data.ResInfoData;
import com.adl.service.data.ResTabData;
import com.adl.service.data.ResTypeData;
import com.adl.service.data.SportMeetData;
import com.adl.service.data.TrainPlanInfoData;
import com.adl.service.data.TrainPlanOneDayProjectData;
import com.adl.service.http.request.CompetitionPageRequest;
import com.adl.service.http.request.CompetitionRankDetailRequest;
import com.adl.service.http.request.DownloadGroupTeamDetailPageRequest;
import com.adl.service.http.request.DownloadGroupTeamPageRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.GetGroupRequest;
import com.adl.service.http.request.JoinCompetitionRankRequest;
import com.adl.service.http.request.ResInfoRequest;
import com.adl.service.http.request.ResPageRequest;
import com.adl.service.http.request.ResTypeListRequest;
import com.adl.service.http.request.SaveGroupRequest;
import com.adl.service.http.request.SportMeetPageRequest;
import com.adl.service.http.request.TrainPlanInfoPageRequest;
import com.adl.service.http.request.TrainPlanOneDayProjectListRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.BigScreenStatsService;
import com.adl.service.web.BusinessService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class BusinessFetchHelper {

    private volatile BusinessService businessService;
    private volatile String baseUrl;

    public BusinessFetchHelper() {
    }

    private synchronized BusinessService getService() {
        if (businessService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            businessService = RetrofitManager.getInstance().create(BusinessService.class);
        }
        return businessService;
    }

    public Function<SaveGroupRequest, Single<ResponseResult<Boolean>>> createSaveGroupFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().saveGroup(request));
    }

    public Function<GetGroupRequest, Single<ResponseResult<GroupData>>> createGetGroupFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getGroup(request));
    }

    public Function<TrainPlanOneDayProjectListRequest, Single<ResponseResult<List<TrainPlanOneDayProjectData>>>> createGetTrainPlanOneDayProjectListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTrainPlanOneDayProjectList(request));
    }

    public Function<TrainPlanInfoPageRequest, Single<ResponseResult<BasePageData<TrainPlanInfoData>>>> createGetTrainPlanInfoPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTrainPlanInfoPage(request));
    }

    public Function<JoinCompetitionRankRequest, Single<ResponseResult<Boolean>>> createJoinCompetitionRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().joinCompetitionRank(request));
    }

    public Function<CompetitionRankDetailRequest, Single<ResponseResult<CompetitionRankDetailData>>> createGetCompetitionRankDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getCompetitionRankDetail(request));
    }

    public Function<Long, Single<ResponseResult<BasePageData<CompetitionData>>>> createGetCompetitionPagesAllFunc(CompetitionPageRequest request) {
        return (page) -> {
            CompetitionPageRequest pageReq = CompetitionPageRequest.builder()
                    .current(page)
                    .pageSize(request.getPageSize())
                    .onlineType(request.getOnlineType())
                    .orgId(request.getOrgId())
                    .competitionLevel(request.getCompetitionLevel())
                    .appCode(request.getAppCode())
                    .startTime(request.getStartTime())
                    .endTime(request.getEndTime())
                    .competitionEnabled(request.getCompetitionEnabled())
                    .keyword(request.getKeyword())
                    .acayearSemCode(request.getAcayearSemCode())
                    .orgType(request.getOrgType())
                    .terminalFlag(request.getTerminalFlag())
                    .accountId(request.getAccountId())
                    .sortField(request.getSortField())
                    .build();
            return BaseFetchUtil.scheduleResponse(getService().getCompetitionPage(pageReq));
        };
    }

    public Function<CompetitionPageRequest, Single<ResponseResult<BasePageData<CompetitionData>>>> createGetCompetitionPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getCompetitionPage(request));
    }

    public Function<Long, Single<ResponseResult<BasePageData<SportMeetData>>>> createGetSportMeetPagesAllFunc(SportMeetPageRequest request) {
        return (page) -> {
            SportMeetPageRequest pageReq = SportMeetPageRequest.builder()
                    .current(page)
                    .pageSize(request.getPageSize())
                    .appCode(request.getAppCode())
                    .classIds(request.getClassIds())
                    .orgId(request.getOrgId())
                    .state(request.getState())
                    .keyword(request.getKeyword())
                    .id(request.getId())
                    .showGroup(request.getShowGroup())
                    .checkTime(request.getCheckTime())
                    .orderByField(request.getOrderByField())
                    .lastUpdateTime(request.getLastUpdateTime())
                    .build();
            return BaseFetchUtil.scheduleResponse(getService().getSportMeetPage(pageReq));
        };
    }

    public Function<SportMeetPageRequest, Single<ResponseResult<BasePageData<SportMeetData>>>> createGetSportMeetPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportMeetPage(request));
    }

    public Function<DownloadGroupTeamPageRequest, Single<ResponseResult<List<GroupTeamData>>>> createDownloadGroupTeamPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().downloadGroupTeamPage(request));
    }

    public Function<DownloadGroupTeamDetailPageRequest, Single<ResponseResult<List<GroupTeamDetailData>>>> createDownloadGroupTeamDetailPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().downloadGroupTeamDetailPage(request));
    }

    public Function<EmptyRequest, Single<ResponseResult<List<ResTabData>>>> createGetResTabListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResTabList());
    }

    public Function<ResTypeListRequest, Single<ResponseResult<List<ResTypeData>>>> createGetResTypeListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResTypeList(request));
    }

    public Function<ResPageRequest, Single<ResponseResult<BasePageData<ResData>>>> createGetResPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResPage(request));
    }

    public Function<ResInfoRequest, Single<ResponseResult<ResInfoData>>> createGetResInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResInfo(request));
    }
}
