package com.adl.service.caller.impl;

import com.adl.service.caller.RecordNativeCaller;
import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.SportRecordResData;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.RecordNativeRepository;

import java.util.List;

/**
 * RecordDaoCallerImpl。
 */
public class RecordNativeCallerImpl implements RecordNativeCaller {

    private final RecordNativeRepository recordNativeRepository;

    public RecordNativeCallerImpl() {
        recordNativeRepository = RecordNativeRepository.getInstance();
    }

    @Override
    public void insertRecordSync(ReportSportStudentAllData data) {
        RxCallbackScheduler.scheduleSync(recordNativeRepository.insertRecord(data));
    }

    @Override
    public List<ReportSportStudentAllData> queryRecordAllSync() {
        return RxCallbackScheduler.scheduleSync(recordNativeRepository.queryRecordAll());
    }

    @Override
    public void clearRecordByIdSync(String id) {
        RxCallbackScheduler.scheduleSync(recordNativeRepository.clearRecordById(id));
    }

    @Override
    public void insertRecordResSync(SportRecordResData data) {
        RxCallbackScheduler.scheduleSync(recordNativeRepository.insertRecordRes(data));
    }

    @Override
    public List<SportRecordResData> queryNotUploadRecordResSync() {
        return RxCallbackScheduler.scheduleSync(recordNativeRepository.queryNotUploadRecordRes());
    }

    @Override
    public void clearRecordResSync(SportRecordResData data) {
        RxCallbackScheduler.scheduleSync(recordNativeRepository.clearRecordRes(data));
    }
}
