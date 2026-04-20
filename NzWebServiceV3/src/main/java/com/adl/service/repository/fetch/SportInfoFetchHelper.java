package com.adl.service.repository.fetch;

import com.adl.service.data.AccountRecordData;
import com.adl.service.data.BasePageData;
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

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class SportInfoFetchHelper {

    private final SportInfoService sportInfoService;

    public SportInfoFetchHelper() {
        this.sportInfoService = RetrofitManager.getInstance().create(SportInfoService.class);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createUpdateStudentSportFunc() {
        return (request) -> sportInfoService.updateStudentSport(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ReportTeacherSportRequest, Single<Boolean>> createReportTeacherSportFunc() {
        return (request) -> sportInfoService.reportTeacherSport(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createReportStudentTrainFunc() {
        return (request) -> sportInfoService.reportStudentTrain(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createReportStudentSportFunc() {
        return (request) -> sportInfoService.reportStudentSport(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ReportStudentPlanRequest, Single<Boolean>> createReportStudentPlanFunc() {
        return (request) -> sportInfoService.reportStudentPlan(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ReportStudentMeetRequest, Single<Boolean>> createReportStudentMeetFunc() {
        return (request) -> sportInfoService.reportStudentMeet(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ReportStudentCompetitionRequest, Single<Boolean>> createReportStudentCompetitionFunc() {
        return (request) -> sportInfoService.reportStudentCompetition(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<ReportStudentSportRequest, Single<Boolean>> createReportStudentAllSportFunc() {
        return (request) -> sportInfoService.reportStudentAllSport(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<OrgRecordPageRequest, Single<BasePageData<OrgRecordData>>> createGetOrgRecordPageFunc() {
        return (request) -> sportInfoService.getOrgRecordPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<AccountRecordPageRequest, Single<BasePageData<AccountRecordData>>> createGetAccountRecordPageFunc() {
        return (request) -> sportInfoService.getAccountRecordPage(request).map(BaseFetchUtil::scheduleResponse);
    }
}
