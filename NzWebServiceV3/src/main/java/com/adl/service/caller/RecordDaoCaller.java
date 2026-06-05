package com.adl.service.caller;

import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.SportRecordResData;

import java.util.List;

/**
 * RecordDaoCaller。
 */
public interface RecordDaoCaller {

    void insertRecordSync(ReportSportStudentAllData data);

    List<ReportSportStudentAllData> queryRecordAllSync();

    void clearRecordByIdSync(String id);

    void insertRecordResSync(SportRecordResData data);

    List<SportRecordResData> queryNotUploadRecordResSync();

    void clearRecordResSync(SportRecordResData data);
}
