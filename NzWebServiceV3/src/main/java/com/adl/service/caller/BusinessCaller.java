package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.CompetitionPageRequest;
import com.adl.service.web.request.CompetitionRankDetailRequest;
import com.adl.service.web.request.DownloadGroupTeamDetailPageRequest;
import com.adl.service.web.request.DownloadGroupTeamPageRequest;
import com.adl.service.web.request.GetGroupRequest;
import com.adl.service.web.request.JoinCompetitionRankRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.ResInfoRequest;
import com.adl.service.web.request.ResPageRequest;
import com.adl.service.web.request.ResTypeListRequest;
import com.adl.service.web.request.SaveGroupRequest;
import com.adl.service.web.request.SportMeetPageRequest;
import com.adl.service.web.request.TrainPlanInfoPageRequest;
import com.adl.service.web.request.TrainPlanOneDayProjectListRequest;
import com.adl.service.web.response.CompetitionPageData;
import com.adl.service.web.response.CompetitionRankDetailData;
import com.adl.service.web.response.GroupData;
import com.adl.service.web.response.GroupTeamData;
import com.adl.service.web.response.GroupTeamDetailData;
import com.adl.service.web.response.ResInfoData;
import com.adl.service.web.response.ResPageData;
import com.adl.service.web.response.ResTypeData;
import com.adl.service.web.response.SportMeetPageData;
import com.adl.service.web.response.TrainPlanInfoPageData;
import com.adl.service.web.response.TrainPlanOneDayProjectData;

import java.util.List;

/**
 * BusinessCaller。
 */
public interface BusinessCaller {

    long saveGroupAsync(RequestScope scope, SaveGroupRequest request, RequestCallback<Boolean> callback);

    Boolean saveGroupSync(SaveGroupRequest request) throws NzBaseException;

    long getGroupAsync(RequestScope scope, GetGroupRequest request, RequestCallback<GroupData> callback);

    GroupData getGroupSync(GetGroupRequest request) throws NzBaseException;

    long getTrainPlanOneDayProjectListAsync(RequestScope scope, TrainPlanOneDayProjectListRequest request, RequestCallback<List<TrainPlanOneDayProjectData>> callback);

    List<TrainPlanOneDayProjectData> getTrainPlanOneDayProjectListSync(TrainPlanOneDayProjectListRequest request) throws NzBaseException;

    long getTrainPlanInfoPageAsync(RequestScope scope, TrainPlanInfoPageRequest request, RequestCallback<TrainPlanInfoPageData> callback);

    TrainPlanInfoPageData getTrainPlanInfoPageSync(TrainPlanInfoPageRequest request) throws NzBaseException;

    long joinCompetitionRankAsync(RequestScope scope, JoinCompetitionRankRequest request, RequestCallback<Boolean> callback);

    Boolean joinCompetitionRankSync(JoinCompetitionRankRequest request) throws NzBaseException;

    long getCompetitionRankDetailAsync(RequestScope scope, CompetitionRankDetailRequest request, RequestCallback<CompetitionRankDetailData> callback);

    CompetitionRankDetailData getCompetitionRankDetailSync(CompetitionRankDetailRequest request) throws NzBaseException;

    long getCompetitionPageAsync(RequestScope scope, CompetitionPageRequest request, RequestCallback<CompetitionPageData> callback);

    CompetitionPageData getCompetitionPageSync(CompetitionPageRequest request) throws NzBaseException;

    long getSportMeetPageAsync(RequestScope scope, SportMeetPageRequest request, RequestCallback<SportMeetPageData> callback);

    SportMeetPageData getSportMeetPageSync(SportMeetPageRequest request) throws NzBaseException;

    long downloadGroupTeamPageAsync(RequestScope scope, DownloadGroupTeamPageRequest request, RequestCallback<List<GroupTeamData>> callback);

    List<GroupTeamData> downloadGroupTeamPageSync(DownloadGroupTeamPageRequest request) throws NzBaseException;

    long downloadGroupTeamDetailPageAsync(RequestScope scope, DownloadGroupTeamDetailPageRequest request, RequestCallback<List<GroupTeamDetailData>> callback);

    List<GroupTeamDetailData> downloadGroupTeamDetailPageSync(DownloadGroupTeamDetailPageRequest request) throws NzBaseException;

    long getResTypeListAsync(RequestScope scope, ResTypeListRequest request, RequestCallback<List<ResTypeData>> callback);

    List<ResTypeData> getResTypeListSync(ResTypeListRequest request) throws NzBaseException;

    long getResPageAsync(RequestScope scope, ResPageRequest request, RequestCallback<ResPageData> callback);

    ResPageData getResPageSync(ResPageRequest request) throws NzBaseException;

    long getResInfoAsync(RequestScope scope, ResInfoRequest request, RequestCallback<ResInfoData> callback);

    ResInfoData getResInfoSync(ResInfoRequest request) throws NzBaseException;

}
