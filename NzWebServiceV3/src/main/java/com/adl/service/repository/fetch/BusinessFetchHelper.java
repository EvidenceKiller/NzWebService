package com.adl.service.repository.fetch;

import android.text.TextUtils;

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

    public Function<SaveGroupRequest, Single<Boolean>> createSaveGroupFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().saveGroup(request), Boolean.class);
    }

    public Function<GetGroupRequest, Single<GroupData>> createGetGroupFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getGroup(request), GroupData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<TrainPlanOneDayProjectListRequest, Single<List<TrainPlanOneDayProjectData>>> createGetTrainPlanOneDayProjectListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTrainPlanOneDayProjectList(request), (Class<List<TrainPlanOneDayProjectData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<TrainPlanInfoPageRequest, Single<BasePageData<TrainPlanInfoData>>> createGetTrainPlanInfoPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTrainPlanInfoPage(request), (Class<BasePageData<TrainPlanInfoData>>) (Class<?>) BasePageData.class);
    }

    public Function<JoinCompetitionRankRequest, Single<Boolean>> createJoinCompetitionRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().joinCompetitionRank(request), Boolean.class);
    }

    public Function<CompetitionRankDetailRequest, Single<CompetitionRankDetailData>> createGetCompetitionRankDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getCompetitionRankDetail(request), CompetitionRankDetailData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<BasePageData<CompetitionData>>> createGetCompetitionPagesAllFunc(CompetitionPageRequest request) {
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
            return BaseFetchUtil.scheduleResponse(getService().getCompetitionPage(pageReq), (Class<BasePageData<CompetitionData>>) (Class<?>) BasePageData.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<CompetitionPageRequest, Single<BasePageData<CompetitionData>>> createGetCompetitionPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getCompetitionPage(request), (Class<BasePageData<CompetitionData>>) (Class<?>) BasePageData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<BasePageData<SportMeetData>>> createGetSportMeetPagesAllFunc(SportMeetPageRequest request) {
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
            return BaseFetchUtil.scheduleResponse(getService().getSportMeetPage(pageReq), (Class<BasePageData<SportMeetData>>) (Class<?>) BasePageData.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<SportMeetPageRequest, Single<BasePageData<SportMeetData>>> createGetSportMeetPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportMeetPage(request), (Class<BasePageData<SportMeetData>>) (Class<?>) BasePageData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DownloadGroupTeamPageRequest, Single<List<GroupTeamData>>> createDownloadGroupTeamPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().downloadGroupTeamPage(request), (Class<List<GroupTeamData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DownloadGroupTeamDetailPageRequest, Single<List<GroupTeamDetailData>>> createDownloadGroupTeamDetailPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().downloadGroupTeamDetailPage(request), (Class<List<GroupTeamDetailData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<EmptyRequest, Single<List<ResTabData>>> createGetResTabListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResTabList(), (Class<List<ResTabData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<ResTypeListRequest, Single<List<ResTypeData>>> createGetResTypeListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResTypeList(request), (Class<List<ResTypeData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<ResPageRequest, Single<BasePageData<ResData>>> createGetResPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResPage(request), (Class<BasePageData<ResData>>) (Class<?>) BasePageData.class);
    }

    public Function<ResInfoRequest, Single<ResInfoData>> createGetResInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getResInfo(request), ResInfoData.class);
    }
}
