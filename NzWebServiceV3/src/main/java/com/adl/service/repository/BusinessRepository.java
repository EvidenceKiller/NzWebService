package com.adl.service.repository;

import com.adl.service.data.PageSummaryData;
import com.adl.service.callback.ResponseResult;
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
import com.adl.service.repository.fetch.BusinessFetchHelper;
import com.adl.service.repository.persist.BusinessPersistHelper;
import com.adl.service.repository.prepare.BusinessPrepareHelper;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public final class BusinessRepository {
    private final BusinessPrepareHelper prepareHelper = new BusinessPrepareHelper();
    private final BusinessFetchHelper fetchHelper = new BusinessFetchHelper();
    private final BusinessPersistHelper persistHelper = new BusinessPersistHelper();

    private static volatile BusinessRepository instance;

    private BusinessRepository() {
    }

    public static BusinessRepository getInstance() {
        if (instance == null) {
            synchronized (BusinessRepository.class) {
                if (instance == null) {
                    instance = new BusinessRepository();
                }
            }
        }
        return instance;
    }

    public Single<ResponseResult<Boolean>> saveGroup(SaveGroupRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createSaveGroupFunc());
    }

    public Single<ResponseResult<GroupData>> getGroup(GetGroupRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetGroupFunc());
    }

    public Single<ResponseResult<List<TrainPlanOneDayProjectData>>> getTrainPlanOneDayProjectList(TrainPlanOneDayProjectListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetTrainPlanOneDayProjectListFunc());
    }

    public Single<ResponseResult<List<TrainPlanInfoData>>> getTrainPlanInfoPage(TrainPlanInfoPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetTrainPlanInfoPageFunc());
    }

    public Single<ResponseResult<Boolean>> joinCompetitionRank(JoinCompetitionRankRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createJoinCompetitionRankFunc());
    }

    public Single<ResponseResult<CompetitionRankDetailData>> getCompetitionRankDetail(CompetitionRankDetailRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetCompetitionRankDetailFunc());
    }

    public Single<ResponseResult<PageSummaryData>> getCompetitionPagesAll(CompetitionPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createPrepareCompetitionPageFunc(),
                fetchHelper.createGetCompetitionPagesAllFunc(request),
                persistHelper.createPersistCompetitionPageFunc());
    }

    public Single<ResponseResult<List<CompetitionData>>> getCompetitionPage(CompetitionPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetCompetitionPageFunc(),
                persistHelper.createPersistCompetitionPageFunc());
    }

    public Single<ResponseResult<PageSummaryData>> getSportMeetPagesAll(SportMeetPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createPrepareSportMeetPageFunc(),
                fetchHelper.createGetSportMeetPagesAllFunc(request),
                persistHelper.createPersistSportMeetPageFunc(request));
    }

    public Single<ResponseResult<List<SportMeetData>>> getSportMeetPage(SportMeetPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetSportMeetPageFunc(),
                persistHelper.createPersistSportMeetPageFunc(request));
    }

    public Single<ResponseResult<List<GroupTeamData>>> downloadGroupTeamPage(DownloadGroupTeamPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createDownloadGroupTeamPageFunc());
    }

    public Single<ResponseResult<List<GroupTeamDetailData>>> downloadGroupTeamDetailPage(DownloadGroupTeamDetailPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createDownloadGroupTeamDetailPageFunc());
    }

    public Single<ResponseResult<List<ResTabData>>> getResTabList(EmptyRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetResTabListFunc());
    }

    public Single<ResponseResult<List<ResTypeData>>> getResTypeList(ResTypeListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetResTypeListFunc());
    }

    public Single<ResponseResult<List<ResData>>> getResPage(ResPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetResPageFunc());
    }

    public Single<ResponseResult<ResInfoData>> getResInfo(ResInfoRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetResInfoFunc());
    }
}
