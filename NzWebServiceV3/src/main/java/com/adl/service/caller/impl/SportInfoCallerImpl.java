package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.caller.SportInfoCaller;
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
import com.adl.service.http.request.RequestScope;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.SportInfoRepository;

import java.util.List;

/**
 * SportInfoCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class SportInfoCallerImpl implements SportInfoCaller {

    private final SportInfoRepository sportInfoRepository;

    public SportInfoCallerImpl() {
        this.sportInfoRepository = SportInfoRepository.getInstance();
    }

    @Override
    public long updateStudentSportAsync(RequestScope scope, ReportSportStudentAllData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.updateStudentSport(request), callback);
    }

    @Override
    public ResponseResult<Boolean> updateStudentSportSync(ReportSportStudentAllData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.updateStudentSport(request));
    }

    @Override
    public long reportTeacherSportAsync(RequestScope scope, ReportSportTeacherData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.reportTeacherSport(request), callback);
    }

    @Override
    public ResponseResult<Boolean> reportTeacherSportSync(ReportSportTeacherData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.reportTeacherSport(request));
    }

    @Override
    public long reportStudentTrainAsync(RequestScope scope, ReportSportStudentTrainData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.reportStudentTrain(request), callback);
    }

    @Override
    public ResponseResult<Boolean> reportStudentTrainSync(ReportSportStudentTrainData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.reportStudentTrain(request));
    }

    @Override
    public long reportStudentSportAsync(RequestScope scope, ReportSportStudentData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.reportStudentSport(request), callback);
    }

    @Override
    public ResponseResult<Boolean> reportStudentSportSync(ReportSportStudentData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.reportStudentSport(request));
    }

    @Override
    public long reportStudentPlanAsync(RequestScope scope, ReportSportStudentPlanData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.reportStudentPlan(request), callback);
    }

    @Override
    public ResponseResult<Boolean> reportStudentPlanSync(ReportSportStudentPlanData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.reportStudentPlan(request));
    }

    @Override
    public long reportStudentMeetAsync(RequestScope scope, ReportSportStudentMeetData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.reportStudentMeet(request), callback);
    }

    @Override
    public ResponseResult<Boolean> reportStudentMeetSync(ReportSportStudentMeetData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.reportStudentMeet(request));
    }

    @Override
    public long reportStudentCompetitionAsync(RequestScope scope, ReportSportStudentCompetitionData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.reportStudentCompetition(request), callback);
    }

    @Override
    public ResponseResult<Boolean> reportStudentCompetitionSync(ReportSportStudentCompetitionData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.reportStudentCompetition(request));
    }

    @Override
    public long reportStudentAllSportAsync(RequestScope scope, ReportSportStudentAllData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.reportStudentAllSport(request), callback);
    }

    @Override
    public ResponseResult<Boolean> reportStudentAllSportSync(ReportSportStudentAllData request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.reportStudentAllSport(request));
    }

    @Override
    public long getOrgRecordPageAsync(RequestScope scope, OrgRecordPageRequest request, RequestCallback<List<OrgRecordData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.getOrgRecordPage(request), callback);
    }

    @Override
    public ResponseResult<List<OrgRecordData>> getOrgRecordPageSync(OrgRecordPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.getOrgRecordPage(request));
    }

    @Override
    public long getAccountRecordPageAsync(RequestScope scope, AccountRecordPageRequest request, RequestCallback<List<AccountRecordData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, sportInfoRepository.getAccountRecordPage(request), callback);
    }

    @Override
    public ResponseResult<List<AccountRecordData>> getAccountRecordPageSync(AccountRecordPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(sportInfoRepository.getAccountRecordPage(request));
    }
}
