package com.adl.service.repository;

import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.SportRecordResData;
import com.adl.service.db.entity.SportRecordEntity;
import com.adl.service.db.entity.SportRecordResEntity;
import com.adl.service.repository.persist.RecordDaoPersistHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class RecordDaoRepository {
    private final RecordDaoPersistHelper persistHelper = new RecordDaoPersistHelper();

    private static volatile RecordDaoRepository instance;

    private RecordDaoRepository() {
    }

    public static RecordDaoRepository getInstance() {
        if (instance == null) {
            synchronized (RecordDaoRepository.class) {
                if (instance == null) {
                    instance = new RecordDaoRepository();
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
