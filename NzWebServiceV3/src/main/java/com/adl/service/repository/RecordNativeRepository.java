package com.adl.service.repository;

import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.SportRecordResData;
import com.adl.service.repository.persist.RecordNativePersistHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class RecordNativeRepository {
    private final RecordNativePersistHelper persistHelper = new RecordNativePersistHelper();

    private static volatile RecordNativeRepository instance;

    private RecordNativeRepository() {
    }

    public static RecordNativeRepository getInstance() {
        if (instance == null) {
            synchronized (RecordNativeRepository.class) {
                if (instance == null) {
                    instance = new RecordNativeRepository();
                }
            }
        }
        return instance;
    }

    public Single<Boolean> insertRecord(ReportSportStudentAllData data) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createInsertRecordFunc(data));
    }

    public Single<Boolean> clearRecordById(String id) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearRecordByIdFunc(id));
    }

    public Single<Boolean> insertRecordRes(SportRecordResData data) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createInsertRecordResFunc(data));
    }

    public Single<List<SportRecordResData>> queryNotUploadRecordRes() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createQueryNotUploadRecordResFunc());
    }

    public Single<Boolean> clearRecordRes(SportRecordResData data) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearRecordResFunc(data));
    }

    public Single<List<ReportSportStudentAllData>> queryRecordAll() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createQueryRecordAllFunc());
    }
}
