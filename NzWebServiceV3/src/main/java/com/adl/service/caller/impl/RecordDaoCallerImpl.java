package com.adl.service.caller.impl;

import com.adl.service.caller.RecordDaoCaller;
import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.SportRecordResData;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.RecordDaoRepository;

import java.util.List;

/**
 * RecordDaoCallerImpl。
 */
public class RecordDaoCallerImpl implements RecordDaoCaller {

    private final RecordDaoRepository recordDaoRepository;

    public RecordDaoCallerImpl() {
        recordDaoRepository = RecordDaoRepository.getInstance();
    }

    @Override
    public void insertRecordSync(ReportSportStudentAllData data) {
        RxCallbackScheduler.blockingGetNoThrow(recordDaoRepository.insertRecord(data));
    }

    @Override
    public List<ReportSportStudentAllData> queryRecordAllSync() {
        return RxCallbackScheduler.blockingGetNoThrow(recordDaoRepository.queryRecordAll());
    }

    @Override
    public void clearRecordByIdSync(String id) {
        RxCallbackScheduler.blockingGetNoThrow(recordDaoRepository.clearRecordById(id));
    }

    @Override
    public void insertRecordResSync(SportRecordResData data) {
        RxCallbackScheduler.blockingGetNoThrow(recordDaoRepository.insertRecordRes(data));
    }

    @Override
    public List<SportRecordResData> queryNotUploadRecordResSync() {
        return RxCallbackScheduler.blockingGetNoThrow(recordDaoRepository.queryNotUploadRecordRes());
    }

    @Override
    public void clearRecordResSync(SportRecordResData data) {
        RxCallbackScheduler.blockingGetNoThrow(recordDaoRepository.clearRecordRes(data));
    }
}
