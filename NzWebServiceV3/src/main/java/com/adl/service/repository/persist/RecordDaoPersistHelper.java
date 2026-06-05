package com.adl.service.repository.persist;

import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.SportRecordResData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.SportRecordEntity;
import com.adl.service.db.entity.SportRecordResEntity;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class RecordDaoPersistHelper {

    public RecordDaoPersistHelper() {
    }

    public Function<Void, Single<Boolean>> createInsertRecordFunc(ReportSportStudentAllData data) {
        return (v) -> {
            DaoManagerProxy.getInstance().getRecordUploadDao().insert(SportRecordEntity.convertToEntity(data));
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<Boolean>> createInsertRecordResFunc(SportRecordResData data) {
        return (v) -> {
            DaoManagerProxy.getInstance().getRecordResDao().insert(SportRecordResEntity.convertToEntity(data));
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<Boolean>> createClearRecordByIdFunc(String id) {
        return (v) -> {
            DaoManagerProxy.getInstance().getRecordUploadDao().clearById(id);
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<List<SportRecordResData>>> createQueryNotUploadRecordResFunc() {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getRecordResDao().queryNotUploadRecordRes()
                .stream()
                .map(entity -> SportRecordResEntity.convertToData(entity))
                .collect(Collectors.toList()));
    }

    public Function<Void, Single<Boolean>> createClearRecordResFunc(SportRecordResData data) {
        return (v) -> {
            DaoManagerProxy.getInstance().getRecordResDao().clear(SportRecordResEntity.convertToEntity(data));
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<List<ReportSportStudentAllData>>> createQueryRecordAllFunc() {
        return (v) -> Single.just(DaoManagerProxy.getInstance().getRecordUploadDao().queryAll()
                .stream()
                .map(entity -> SportRecordEntity.convertToData(entity))
                .collect(Collectors.toList()));
    }
}
