package com.adl.service.repository.fetch;

import com.adl.service.data.AccountRecordData;
import com.adl.service.data.OrgRecordData;
import com.adl.service.http.request.AccountRecordPageRequest;
import com.adl.service.http.request.OrgRecordPageRequest;
import com.adl.service.http.request.ReportStudentCompetitionRequest;
import com.adl.service.http.request.ReportStudentMeetRequest;
import com.adl.service.http.request.ReportStudentPlanRequest;
import com.adl.service.http.request.ReportStudentSportRequest;
import com.adl.service.http.request.ReportTeacherSportRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.SportInfoService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class SportInfoFetchHelper {

    private final SportInfoService sportInfoService;

    public SportInfoFetchHelper() {
        this.sportInfoService = RetrofitManager.getInstance().create(SportInfoService.class);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createUpdateStudentSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.updateStudentSport(request), Boolean.class);
    }

    public Function<ReportTeacherSportRequest, Single<Boolean>> createReportTeacherSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.reportTeacherSport(request), Boolean.class);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createReportStudentTrainFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.reportStudentTrain(request), Boolean.class);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createReportStudentSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.reportStudentSport(request), Boolean.class);
    }

    public Function<ReportStudentPlanRequest, Single<Boolean>> createReportStudentPlanFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.reportStudentPlan(request), Boolean.class);
    }

    public Function<ReportStudentMeetRequest, Single<Boolean>> createReportStudentMeetFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.reportStudentMeet(request), Boolean.class);
    }

    public Function<ReportStudentCompetitionRequest, Single<Boolean>> createReportStudentCompetitionFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.reportStudentCompetition(request), Boolean.class);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createReportStudentAllSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(sportInfoService.reportStudentAllSport(request), Boolean.class);
    }

    @SuppressWarnings("unchecked")
    public Function<OrgRecordPageRequest, Single<List<OrgRecordData>>> createGetOrgRecordPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(sportInfoService.getOrgRecordPage(request), (Class<List<OrgRecordData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<AccountRecordPageRequest, Single<List<AccountRecordData>>> createGetAccountRecordPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(sportInfoService.getAccountRecordPage(request), (Class<List<AccountRecordData>>) (Class<?>) List.class);
    }
}
