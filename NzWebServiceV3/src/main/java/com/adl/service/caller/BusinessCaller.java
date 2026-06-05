package com.adl.service.caller;

import com.adl.service.callback.GetPageResult;
import com.adl.service.callback.RequestCallback;
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

import java.util.List;

/**
 * BusinessCaller。
 */
public interface BusinessCaller {

    /**
     * 保存分组信息
     * <p>异步调用。</p>
     */
    long saveGroupAsync(RequestScope scope, SaveGroupRequest request, RequestCallback<Boolean> callback);

    /**
     * 保存分组信息
     * <p>同步调用。</p>
     */
    Boolean saveGroupSync(SaveGroupRequest request);

    /**
     * 获取分组信息
     * <p>异步调用。</p>
     */
    long getGroupAsync(RequestScope scope, GetGroupRequest request, RequestCallback<GroupData> callback);

    /**
     * 获取分组信息
     * <p>同步调用。</p>
     */
    GroupData getGroupSync(GetGroupRequest request);

    /**
     * 训练计划一天的项目
     * <p>异步调用。</p>
     */
    long getTrainPlanOneDayProjectListAsync(RequestScope scope, TrainPlanOneDayProjectListRequest request, RequestCallback<List<TrainPlanOneDayProjectData>> callback);

    /**
     * 训练计划一天的项目
     * <p>同步调用。</p>
     */
    List<TrainPlanOneDayProjectData> getTrainPlanOneDayProjectListSync(TrainPlanOneDayProjectListRequest request);

    /**
     * 训练计划列表
     * <p>异步调用。</p>
     */
    long getTrainPlanInfoPageAsync(RequestScope scope, TrainPlanInfoPageRequest request, RequestCallback<List<TrainPlanInfoData>> callback);

    /**
     * 训练计划列表
     * <p>同步调用。</p>
     */
    List<TrainPlanInfoData> getTrainPlanInfoPageSync(TrainPlanInfoPageRequest request);

    /**
     * 参与竞技排名赛事
     * <p>异步调用。</p>
     */
    long joinCompetitionRankAsync(RequestScope scope, JoinCompetitionRankRequest request, RequestCallback<Boolean> callback);

    /**
     * 参与竞技排名赛事
     * <p>同步调用。</p>
     */
    Boolean joinCompetitionRankSync(JoinCompetitionRankRequest request);

    /**
     * 获取赛事竞技排名赛详情
     * <p>异步调用。</p>
     */
    long getCompetitionRankDetailAsync(RequestScope scope, CompetitionRankDetailRequest request, RequestCallback<CompetitionRankDetailData> callback);

    /**
     * 获取赛事竞技排名赛详情
     * <p>同步调用。</p>
     */
    CompetitionRankDetailData getCompetitionRankDetailSync(CompetitionRankDetailRequest request);

    long getCompetitionPagesAllAsync(RequestScope scope, CompetitionPageRequest request, RequestCallback<GetPageResult> callback);

    GetPageResult getCompetitionPagesAllSync(CompetitionPageRequest request);

    /**
     * 赛事列表
     * <p>异步调用。</p>
     */
    long getCompetitionPageAsync(RequestScope scope, CompetitionPageRequest request, RequestCallback<List<CompetitionData>> callback);

    /**
     * 赛事列表
     * <p>同步调用。</p>
     */
    List<CompetitionData> getCompetitionPageSync(CompetitionPageRequest request);

    long getSportMeetPagesAllAsync(RequestScope scope, SportMeetPageRequest request, RequestCallback<GetPageResult> callback);

    /**
     * 获取所有运动会列表
     * <p>同步调用。</p>
     */
    GetPageResult getSportMeetPagesAllSync(SportMeetPageRequest request);

    /**
     * 分页获取运动会列表
     * <p>异步调用。</p>
     */
    long getSportMeetPageAsync(RequestScope scope, SportMeetPageRequest request, RequestCallback<List<SportMeetData>> callback);

    /**
     * 分页获取运动会列表
     * <p>同步调用。</p>
     */
    List<SportMeetData> getSportMeetPageSync(SportMeetPageRequest request);

    /**
     * 拉取编排数据
     * <p>异步调用。</p>
     */
    long downloadGroupTeamPageAsync(RequestScope scope, DownloadGroupTeamPageRequest request, RequestCallback<List<GroupTeamData>> callback);

    /**
     * 拉取编排数据
     * <p>同步调用。</p>
     */
    List<GroupTeamData> downloadGroupTeamPageSync(DownloadGroupTeamPageRequest request);

    /**
     * 拉取编排详情数据
     * <p>异步调用。</p>
     */
    long downloadGroupTeamDetailPageAsync(RequestScope scope, DownloadGroupTeamDetailPageRequest request, RequestCallback<List<GroupTeamDetailData>> callback);

    /**
     * 拉取编排详情数据
     * <p>同步调用。</p>
     */
    List<GroupTeamDetailData> downloadGroupTeamDetailPageSync(DownloadGroupTeamDetailPageRequest request);

    /**
     * 获取资源标签列表
     * <p>异步调用。</p>
     */
    long getResTabListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<ResTabData>> callback);

    /**
     * 获取资源标签列表
     * <p>同步调用。</p>
     */
    List<ResTabData> getResTabListSync(EmptyRequest request);

    /**
     * 获取资源分类列表
     * <p>异步调用。</p>
     */
    long getResTypeListAsync(RequestScope scope, ResTypeListRequest request, RequestCallback<List<ResTypeData>> callback);

    /**
     * 获取资源分类列表
     * <p>同步调用。</p>
     */
    List<ResTypeData> getResTypeListSync(ResTypeListRequest request);

    /**
     * 获取资源列表
     * <p>异步调用。</p>
     */
    long getResPageAsync(RequestScope scope, ResPageRequest request, RequestCallback<List<ResData>> callback);

    /**
     * 获取资源列表
     * <p>同步调用。</p>
     */
    List<ResData> getResPageSync(ResPageRequest request);

    /**
     * 获取资源详情
     * <p>异步调用。</p>
     */
    long getResInfoAsync(RequestScope scope, ResInfoRequest request, RequestCallback<ResInfoData> callback);

    /**
     * 获取资源详情
     * <p>同步调用。</p>
     */
    ResInfoData getResInfoSync(ResInfoRequest request);

}
