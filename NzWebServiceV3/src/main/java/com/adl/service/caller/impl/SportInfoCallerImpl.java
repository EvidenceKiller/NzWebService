package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
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
import com.adl.service.exception.NzBaseException;
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
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.updateStudentSport(request), callback);
    }

    @Override
    public Boolean updateStudentSportSync(ReportSportStudentAllData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.updateStudentSport(request), Boolean.class);
    }

    @Override
    public long reportTeacherSportAsync(RequestScope scope, ReportSportTeacherData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.reportTeacherSport(request), callback);
    }

    @Override
    public Boolean reportTeacherSportSync(ReportSportTeacherData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.reportTeacherSport(request), Boolean.class);
    }

    @Override
    public long reportStudentTrainAsync(RequestScope scope, ReportSportStudentTrainData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.reportStudentTrain(request), callback);
    }

    @Override
    public Boolean reportStudentTrainSync(ReportSportStudentTrainData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.reportStudentTrain(request), Boolean.class);
    }

    @Override
    public long reportStudentSportAsync(RequestScope scope, ReportSportStudentData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.reportStudentSport(request), callback);
    }

    @Override
    public Boolean reportStudentSportSync(ReportSportStudentData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.reportStudentSport(request), Boolean.class);
    }

    @Override
    public long reportStudentPlanAsync(RequestScope scope, ReportSportStudentPlanData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.reportStudentPlan(request), callback);
    }

    @Override
    public Boolean reportStudentPlanSync(ReportSportStudentPlanData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.reportStudentPlan(request), Boolean.class);
    }

    @Override
    public long reportStudentMeetAsync(RequestScope scope, ReportSportStudentMeetData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.reportStudentMeet(request), callback);
    }

    @Override
    public Boolean reportStudentMeetSync(ReportSportStudentMeetData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.reportStudentMeet(request), Boolean.class);
    }

    @Override
    public long reportStudentCompetitionAsync(RequestScope scope, ReportSportStudentCompetitionData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.reportStudentCompetition(request), callback);
    }

    @Override
    public Boolean reportStudentCompetitionSync(ReportSportStudentCompetitionData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.reportStudentCompetition(request), Boolean.class);
    }

    @Override
    public long reportStudentAllSportAsync(RequestScope scope, ReportSportStudentAllData request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.reportStudentAllSport(request), callback);
    }

    @Override
    public Boolean reportStudentAllSportSync(ReportSportStudentAllData request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.reportStudentAllSport(request), Boolean.class);
    }

    @Override
    public long getOrgRecordPageAsync(RequestScope scope, OrgRecordPageRequest request, RequestCallback<List<OrgRecordData>> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.getOrgRecordPage(request), callback);
    }

    @Override
    public List<OrgRecordData> getOrgRecordPageSync(OrgRecordPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.getOrgRecordPage(request));
    }

    @Override
    public long getAccountRecordPageAsync(RequestScope scope, AccountRecordPageRequest request, RequestCallback<List<AccountRecordData>> callback) {
        return RxCallbackScheduler.schedule(scope, sportInfoRepository.getAccountRecordPage(request), callback);
    }

    @Override
    public List<AccountRecordData> getAccountRecordPageSync(AccountRecordPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(sportInfoRepository.getAccountRecordPage(request));
    }
}
