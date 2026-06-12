package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
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

    public Function<ReportSportStudentAllData, Single<ResponseResult<Boolean>>> createUpdateStudentSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().updateStudentSport(request));
    }

    public Function<ReportSportTeacherData, Single<ResponseResult<Boolean>>> createReportTeacherSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportTeacherSport(request));
    }

    public Function<ReportSportStudentTrainData, Single<ResponseResult<Boolean>>> createReportStudentTrainFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentTrain(request));
    }

    public Function<ReportSportStudentData, Single<ResponseResult<Boolean>>> createReportStudentSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentSport(request));
    }

    public Function<ReportSportStudentPlanData, Single<ResponseResult<Boolean>>> createReportStudentPlanFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentPlan(request));
    }

    public Function<ReportSportStudentMeetData, Single<ResponseResult<Boolean>>> createReportStudentMeetFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentMeet(request));
    }

    public Function<ReportSportStudentCompetitionData, Single<ResponseResult<Boolean>>> createReportStudentCompetitionFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentCompetition(request));
    }

    public Function<ReportSportStudentAllData, Single<ResponseResult<Boolean>>> createReportStudentAllSportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().reportStudentAllSport(request));
    }

    public Function<OrgRecordPageRequest, Single<ResponseResult<BasePageData<OrgRecordData>>>> createGetOrgRecordPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getOrgRecordPage(request));
    }

    public Function<AccountRecordPageRequest, Single<ResponseResult<BasePageData<AccountRecordData>>>> createGetAccountRecordPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getAccountRecordPage(request));
    }
}
