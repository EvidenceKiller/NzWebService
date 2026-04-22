package com.adl.service.repository.fetch;

import com.adl.service.data.CompetitionData;
import com.adl.service.data.CompetitionRankDetailData;
import com.adl.service.data.GroupData;
import com.adl.service.data.GroupTeamData;
import com.adl.service.data.GroupTeamDetailData;
import com.adl.service.data.ResData;
import com.adl.service.data.ResTypeData;
import com.adl.service.data.SportMeetData;
import com.adl.service.data.TrainPlanInfoData;
import com.adl.service.data.TrainPlanOneDayProjectData;
import com.adl.service.http.request.CompetitionPageRequest;
import com.adl.service.http.request.CompetitionRankDetailRequest;
import com.adl.service.http.request.DownloadGroupTeamDetailPageRequest;
import com.adl.service.http.request.DownloadGroupTeamPageRequest;
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
import com.adl.service.web.BusinessService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class BusinessFetchHelper {

    private final BusinessService businessService;

    public BusinessFetchHelper() {
        this.businessService = RetrofitManager.getInstance().create(BusinessService.class);
    }

    public Function<SaveGroupRequest, Single<Boolean>> createSaveGroupFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.saveGroup(request), Boolean.class);
    }

    public Function<GetGroupRequest, Single<GroupData>> createGetGroupFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.getGroup(request), GroupData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<TrainPlanOneDayProjectListRequest, Single<List<TrainPlanOneDayProjectData>>> createGetTrainPlanOneDayProjectListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.getTrainPlanOneDayProjectList(request), (Class<List<TrainPlanOneDayProjectData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<TrainPlanInfoPageRequest, Single<List<TrainPlanInfoData>>> createGetTrainPlanInfoPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(businessService.getTrainPlanInfoPage(request), (Class<List<TrainPlanInfoData>>) (Class<?>) List.class);
    }

    public Function<JoinCompetitionRankRequest, Single<Boolean>> createJoinCompetitionRankFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.joinCompetitionRank(request), Boolean.class);
    }

    public Function<CompetitionRankDetailRequest, Single<CompetitionRankDetailData>> createGetCompetitionRankDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.getCompetitionRankDetail(request), CompetitionRankDetailData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<CompetitionData>>> createGetCompetitionPagesAllFunc(CompetitionPageRequest request) {
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
            return BaseFetchUtil.schedulePageResponse(businessService.getCompetitionPage(pageReq), (Class<List<CompetitionData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<CompetitionPageRequest, Single<List<CompetitionData>>> createGetCompetitionPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(businessService.getCompetitionPage(request), (Class<List<CompetitionData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<SportMeetData>>> createGetSportMeetPagesAllFunc(SportMeetPageRequest request) {
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
            return BaseFetchUtil.schedulePageResponse(businessService.getSportMeetPage(pageReq), (Class<List<SportMeetData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<SportMeetPageRequest, Single<List<SportMeetData>>> createGetSportMeetPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(businessService.getSportMeetPage(request), (Class<List<SportMeetData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DownloadGroupTeamPageRequest, Single<List<GroupTeamData>>> createDownloadGroupTeamPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.downloadGroupTeamPage(request), (Class<List<GroupTeamData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DownloadGroupTeamDetailPageRequest, Single<List<GroupTeamDetailData>>> createDownloadGroupTeamDetailPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.downloadGroupTeamDetailPage(request), (Class<List<GroupTeamDetailData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<ResTypeListRequest, Single<List<ResTypeData>>> createGetResTypeListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.getResTypeList(request), (Class<List<ResTypeData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<ResPageRequest, Single<List<ResData>>> createGetResPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(businessService.getResPage(request), (Class<List<ResData>>) (Class<?>) List.class);
    }

    public Function<ResInfoRequest, Single<ResData>> createGetResInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(businessService.getResInfo(request), ResData.class);
    }
}
