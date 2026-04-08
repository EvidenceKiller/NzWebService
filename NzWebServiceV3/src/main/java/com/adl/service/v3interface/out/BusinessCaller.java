package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
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

import java.util.List;

/**
 * BusinessCaller。
 */
public interface BusinessCaller {

    long saveGroupAsync(RequestScope scope, SaveGroupRequest request, RequestCallback<Boolean> callback);

    Boolean saveGroupSync(SaveGroupRequest request);

    long getGroupAsync(RequestScope scope, GetGroupRequest request, RequestCallback<GroupData> callback);

    GroupData getGroupSync(GetGroupRequest request);

    long getTrainPlanOneDayProjectListAsync(RequestScope scope, TrainPlanOneDayProjectListRequest request, RequestCallback<List<TrainPlanOneDayProjectData>> callback);

    List<TrainPlanOneDayProjectData> getTrainPlanOneDayProjectListSync(TrainPlanOneDayProjectListRequest request);

    long getTrainPlanInfoPageAsync(RequestScope scope, TrainPlanInfoPageRequest request, RequestCallback<TrainPlanInfoPageData> callback);

    TrainPlanInfoPageData getTrainPlanInfoPageSync(TrainPlanInfoPageRequest request);

    long joinCompetitionRankAsync(RequestScope scope, JoinCompetitionRankRequest request, RequestCallback<Boolean> callback);

    Boolean joinCompetitionRankSync(JoinCompetitionRankRequest request);

    long getCompetitionRankDetailAsync(RequestScope scope, CompetitionRankDetailRequest request, RequestCallback<CompetitionRankDetailData> callback);

    CompetitionRankDetailData getCompetitionRankDetailSync(CompetitionRankDetailRequest request);

    long getCompetitionPageAsync(RequestScope scope, CompetitionPageRequest request, RequestCallback<CompetitionPageData> callback);

    CompetitionPageData getCompetitionPageSync(CompetitionPageRequest request);

    long getSportMeetPageAsync(RequestScope scope, SportMeetPageRequest request, RequestCallback<SportMeetPageData> callback);

    SportMeetPageData getSportMeetPageSync(SportMeetPageRequest request);

    long downloadGroupTeamPageAsync(RequestScope scope, DownloadGroupTeamPageRequest request, RequestCallback<List<GroupTeamData>> callback);

    List<GroupTeamData> downloadGroupTeamPageSync(DownloadGroupTeamPageRequest request);

    long downloadGroupTeamDetailPageAsync(RequestScope scope, DownloadGroupTeamDetailPageRequest request, RequestCallback<List<GroupTeamDetailData>> callback);

    List<GroupTeamDetailData> downloadGroupTeamDetailPageSync(DownloadGroupTeamDetailPageRequest request);

    long getResTypeListAsync(RequestScope scope, ResTypeListRequest request, RequestCallback<List<ResTypeData>> callback);

    List<ResTypeData> getResTypeListSync(ResTypeListRequest request);

    long getResPageAsync(RequestScope scope, ResPageRequest request, RequestCallback<ResPageData> callback);

    ResPageData getResPageSync(ResPageRequest request);

    long getResInfoAsync(RequestScope scope, ResInfoRequest request, RequestCallback<ResInfoData> callback);

    ResInfoData getResInfoSync(ResInfoRequest request);

}
