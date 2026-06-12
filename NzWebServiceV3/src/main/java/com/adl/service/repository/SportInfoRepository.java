package com.adl.service.repository;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.AccountRecordData;
import com.adl.service.data.OrgRecordData;
import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.ReportSportStudentCompetitionData;
import com.adl.service.data.ReportSportStudentData;
import com.adl.service.data.ReportSportStudentMeetData;
import com.adl.service.data.ReportSportStudentPlanData;
import com.adl.service.data.ReportSportStudentTrainData;
import com.adl.service.data.ReportSportTeacherData;
import com.adl.service.http.request.AccountRecordPageRequest;
import com.adl.service.http.request.OrgRecordPageRequest;
import com.adl.service.repository.fetch.SportInfoFetchHelper;
import com.adl.service.repository.persist.SportInfoPersistHelper;
import com.adl.service.repository.prepare.SportInfoPrepareHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class SportInfoRepository {
    private final SportInfoPrepareHelper prepareHelper = new SportInfoPrepareHelper();
    private final SportInfoFetchHelper fetchHelper = new SportInfoFetchHelper();
    private final SportInfoPersistHelper persistHelper = new SportInfoPersistHelper();

    private static volatile SportInfoRepository instance;

    private SportInfoRepository() {
    }

    public static SportInfoRepository getInstance() {
        if (instance == null) {
            synchronized (SportInfoRepository.class) {
                if (instance == null) {
                    instance = new SportInfoRepository();
                }
            }
        }
        return instance;
    }

    public Single<ResponseResult<Boolean>> updateStudentSport(ReportSportStudentAllData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createUpdateStudentSportFunc());
    }

    public Single<ResponseResult<Boolean>> reportTeacherSport(ReportSportTeacherData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createReportTeacherSportFunc());
    }

    public Single<ResponseResult<Boolean>> reportStudentTrain(ReportSportStudentTrainData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createReportStudentTrainFunc());
    }

    public Single<ResponseResult<Boolean>> reportStudentSport(ReportSportStudentData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createReportStudentSportFunc());
    }

    public Single<ResponseResult<Boolean>> reportStudentPlan(ReportSportStudentPlanData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createReportStudentPlanFunc());
    }

    public Single<ResponseResult<Boolean>> reportStudentMeet(ReportSportStudentMeetData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createReportStudentMeetFunc());
    }

    public Single<ResponseResult<Boolean>> reportStudentCompetition(ReportSportStudentCompetitionData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createReportStudentCompetitionFunc());
    }

    public Single<ResponseResult<Boolean>> reportStudentAllSport(ReportSportStudentAllData request) {
        return BaseRepositoryUtil.repositoryCommonAsSingle(request, fetchHelper.createReportStudentAllSportFunc());
    }

    public Single<ResponseResult<List<OrgRecordData>>> getOrgRecordPage(OrgRecordPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetOrgRecordPageFunc());
    }

    public Single<ResponseResult<List<AccountRecordData>>> getAccountRecordPage(AccountRecordPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetAccountRecordPageFunc());
    }
}
