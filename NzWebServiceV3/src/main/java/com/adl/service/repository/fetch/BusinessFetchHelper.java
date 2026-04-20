package com.adl.service.repository.fetch;

import com.adl.service.data.BasePageData;
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
        return (request) -> businessService.saveGroup(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<GetGroupRequest, Single<GroupData>> createGetGroupFunc() {
        return (request) -> businessService.getGroup(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<TrainPlanOneDayProjectListRequest, Single<List<TrainPlanOneDayProjectData>>> createGetTrainPlanOneDayProjectListFunc() {
        return (request) -> businessService.getTrainPlanOneDayProjectList(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<TrainPlanInfoPageRequest, Single<BasePageData<TrainPlanInfoData>>> createGetTrainPlanInfoPageFunc() {
        return (request) -> businessService.getTrainPlanInfoPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<JoinCompetitionRankRequest, Single<Boolean>> createJoinCompetitionRankFunc() {
        return (request) -> businessService.joinCompetitionRank(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<CompetitionRankDetailRequest, Single<CompetitionRankDetailData>> createGetCompetitionRankDetailFunc() {
        return (request) -> businessService.getCompetitionRankDetail(request).map(BaseFetchUtil::scheduleResponse);
    }

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
            return businessService.getCompetitionPage(pageReq).map(BaseFetchUtil::scheduleResponse);
        };
    }

    public Function<CompetitionPageRequest, Single<BasePageData<CompetitionData>>> createGetCompetitionPageFunc() {
        return (request) -> businessService.getCompetitionPage(request).map(BaseFetchUtil::scheduleResponse);
    }

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
            return businessService.getSportMeetPage(pageReq).map(BaseFetchUtil::scheduleResponse);
        };
    }

    public Function<SportMeetPageRequest, Single<BasePageData<SportMeetData>>> createGetSportMeetPageFunc() {
        return (request) -> businessService.getSportMeetPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<DownloadGroupTeamPageRequest, Single<List<GroupTeamData>>> createDownloadGroupTeamPageFunc() {
        return (request) -> businessService.downloadGroupTeamPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<DownloadGroupTeamDetailPageRequest, Single<List<GroupTeamDetailData>>> createDownloadGroupTeamDetailPageFunc() {
        return (request) -> businessService.downloadGroupTeamDetailPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ResTypeListRequest, Single<List<ResTypeData>>> createGetResTypeListFunc() {
        return (request) -> businessService.getResTypeList(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ResPageRequest, Single<BasePageData<ResData>>> createGetResPageFunc() {
        return (request) -> businessService.getResPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ResInfoRequest, Single<ResData>> createGetResInfoFunc() {
        return (request) -> businessService.getResInfo(request).map(BaseFetchUtil::scheduleResponse);
    }
}
