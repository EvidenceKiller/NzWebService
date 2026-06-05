package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.data.AccountRecordData;
import com.adl.service.data.BasePageData;
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
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.OrgTestService;
import com.adl.service.web.SportInfoService;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class SportInfoFetchHelper {

    private volatile SportInfoService sportInfoService;
    private volatile String baseUrl;

    public SportInfoFetchHelper() {
    }

    private synchronized SportInfoService getService() {
        if (sportInfoService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            sportInfoService = RetrofitManager.getInstance().create(SportInfoService.class);
        }
        return sportInfoService;
    }

    public Function<ReportSportStudentAllData, Single<Boolean>> createUpdateStudentSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().updateStudentSport(request), Boolean.class);
    }

    public Function<ReportSportTeacherData, Single<Boolean>> createReportTeacherSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportTeacherSport(request), Boolean.class);
    }

    public Function<ReportSportStudentTrainData, Single<Boolean>> createReportStudentTrainFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentTrain(request), Boolean.class);
    }

    public Function<ReportSportStudentData, Single<Boolean>> createReportStudentSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentSport(request), Boolean.class);
    }

    public Function<ReportSportStudentPlanData, Single<Boolean>> createReportStudentPlanFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentPlan(request), Boolean.class);
    }

    public Function<ReportSportStudentMeetData, Single<Boolean>> createReportStudentMeetFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentMeet(request), Boolean.class);
    }

    public Function<ReportSportStudentCompetitionData, Single<Boolean>> createReportStudentCompetitionFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentCompetition(request), Boolean.class);
    }

    public Function<ReportSportStudentAllData, Single<Boolean>> createReportStudentAllSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentAllSport(request), Boolean.class);
    }

    @SuppressWarnings("unchecked")
    public Function<OrgRecordPageRequest, Single<BasePageData<OrgRecordData>>> createGetOrgRecordPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getOrgRecordPage(request), (Class<BasePageData<OrgRecordData>>) (Class<?>) BasePageData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<AccountRecordPageRequest, Single<BasePageData<AccountRecordData>>> createGetAccountRecordPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getAccountRecordPage(request), (Class<BasePageData<AccountRecordData>>) (Class<?>) BasePageData.class);
    }
}
