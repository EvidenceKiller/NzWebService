package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.GetPageResult;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.BusinessCaller;
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
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.CompetitionPageRequest;
import com.adl.service.http.request.CompetitionRankDetailRequest;
import com.adl.service.http.request.DownloadGroupTeamDetailPageRequest;
import com.adl.service.http.request.DownloadGroupTeamPageRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.GetGroupRequest;
import com.adl.service.http.request.JoinCompetitionRankRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.ResInfoRequest;
import com.adl.service.http.request.ResPageRequest;
import com.adl.service.http.request.ResTypeListRequest;
import com.adl.service.http.request.SaveGroupRequest;
import com.adl.service.http.request.SportMeetPageRequest;
import com.adl.service.http.request.TrainPlanInfoPageRequest;
import com.adl.service.http.request.TrainPlanOneDayProjectListRequest;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.BusinessRepository;

import java.util.List;

/**
 * BusinessCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class BusinessCallerImpl implements BusinessCaller {

    private final BusinessRepository businessRepository;

    public BusinessCallerImpl() {
        this.businessRepository = BusinessRepository.getInstance();
    }

    @Override
    public long saveGroupAsync(RequestScope scope, SaveGroupRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.saveGroup(request), callback);
    }

    @Override
    public Boolean saveGroupSync(SaveGroupRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.saveGroup(request), Boolean.class);
    }

    @Override
    public long getGroupAsync(RequestScope scope, GetGroupRequest request, RequestCallback<GroupData> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getGroup(request), callback);
    }

    @Override
    public GroupData getGroupSync(GetGroupRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getGroup(request));
    }

    @Override
    public long getTrainPlanOneDayProjectListAsync(RequestScope scope, TrainPlanOneDayProjectListRequest request, RequestCallback<List<TrainPlanOneDayProjectData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getTrainPlanOneDayProjectList(request), callback);
    }

    @Override
    public List<TrainPlanOneDayProjectData> getTrainPlanOneDayProjectListSync(TrainPlanOneDayProjectListRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getTrainPlanOneDayProjectList(request));
    }

    @Override
    public long getTrainPlanInfoPageAsync(RequestScope scope, TrainPlanInfoPageRequest request, RequestCallback<List<TrainPlanInfoData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getTrainPlanInfoPage(request), callback);
    }

    @Override
    public List<TrainPlanInfoData> getTrainPlanInfoPageSync(TrainPlanInfoPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getTrainPlanInfoPage(request));
    }

    @Override
    public long joinCompetitionRankAsync(RequestScope scope, JoinCompetitionRankRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.joinCompetitionRank(request), callback);
    }

    @Override
    public Boolean joinCompetitionRankSync(JoinCompetitionRankRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.joinCompetitionRank(request));
    }

    @Override
    public long getCompetitionRankDetailAsync(RequestScope scope, CompetitionRankDetailRequest request, RequestCallback<CompetitionRankDetailData> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getCompetitionRankDetail(request), callback);
    }

    @Override
    public CompetitionRankDetailData getCompetitionRankDetailSync(CompetitionRankDetailRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getCompetitionRankDetail(request));
    }

    @Override
    public long getCompetitionPagesAllAsync(RequestScope scope, CompetitionPageRequest request, RequestCallback<GetPageResult> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getCompetitionPagesAll(request), callback);
    }

    @Override
    public GetPageResult getCompetitionPagesAllSync(CompetitionPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getCompetitionPagesAll(request));
    }

    @Override
    public long getCompetitionPageAsync(RequestScope scope, CompetitionPageRequest request, RequestCallback<List<CompetitionData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getCompetitionPage(request), callback);
    }

    @Override
    public List<CompetitionData> getCompetitionPageSync(CompetitionPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getCompetitionPage(request));
    }

    @Override
    public long getSportMeetPagesAllAsync(RequestScope scope, SportMeetPageRequest request, RequestCallback<GetPageResult> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getSportMeetPagesAll(request), callback);
    }

    @Override
    public GetPageResult getSportMeetPagesAllSync(SportMeetPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getSportMeetPagesAll(request));
    }

    @Override
    public long getSportMeetPageAsync(RequestScope scope, SportMeetPageRequest request, RequestCallback<List<SportMeetData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getSportMeetPage(request), callback);
    }

    @Override
    public List<SportMeetData> getSportMeetPageSync(SportMeetPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getSportMeetPage(request));
    }

    @Override
    public long downloadGroupTeamPageAsync(RequestScope scope, DownloadGroupTeamPageRequest request, RequestCallback<List<GroupTeamData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.downloadGroupTeamPage(request), callback);
    }

    @Override
    public List<GroupTeamData> downloadGroupTeamPageSync(DownloadGroupTeamPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.downloadGroupTeamPage(request));
    }

    @Override
    public long downloadGroupTeamDetailPageAsync(RequestScope scope, DownloadGroupTeamDetailPageRequest request, RequestCallback<List<GroupTeamDetailData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.downloadGroupTeamDetailPage(request), callback);
    }

    @Override
    public List<GroupTeamDetailData> downloadGroupTeamDetailPageSync(DownloadGroupTeamDetailPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.downloadGroupTeamDetailPage(request));
    }

    @Override
    public long getResTabListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<ResTabData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getResTabList(request), callback);
    }

    @Override
    public List<ResTabData> getResTabListSync(EmptyRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getResTabList(request));
    }

    @Override
    public long getResTypeListAsync(RequestScope scope, ResTypeListRequest request, RequestCallback<List<ResTypeData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getResTypeList(request), callback);
    }

    @Override
    public List<ResTypeData> getResTypeListSync(ResTypeListRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getResTypeList(request));
    }

    @Override
    public long getResPageAsync(RequestScope scope, ResPageRequest request, RequestCallback<List<ResData>> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getResPage(request), callback);
    }

    @Override
    public List<ResData> getResPageSync(ResPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getResPage(request));
    }

    @Override
    public long getResInfoAsync(RequestScope scope, ResInfoRequest request, RequestCallback<ResInfoData> callback) {
        return RxCallbackScheduler.schedule(scope, businessRepository.getResInfo(request), callback);
    }

    @Override
    public ResInfoData getResInfoSync(ResInfoRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(businessRepository.getResInfo(request));
    }
}
