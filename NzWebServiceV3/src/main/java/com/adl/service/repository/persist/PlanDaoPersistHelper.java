package com.adl.service.repository.persist;

import com.adl.service.db.DaoManagerProxy;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class PlanDaoPersistHelper {

    public PlanDaoPersistHelper() {
    }

    public Function<Void, Single<Boolean>> createPrepareStandardConfigDataFunc() {
        return (v) -> {
            DaoManagerProxy.getInstance().getStandardConfigDao().clearAll();
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<Boolean>> createClearPlanStudentPagesAllFunc() {
        return (v) -> {
            DaoManagerProxy.getInstance().getPlanStudentDao().clearAll();
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<Boolean>> createClearPlanPagesAllFunc() {
        return (v) -> {
            DaoManagerProxy.getInstance().getPlanDao().clearAll();
            return Single.just(Boolean.TRUE);
        };
    }
}
