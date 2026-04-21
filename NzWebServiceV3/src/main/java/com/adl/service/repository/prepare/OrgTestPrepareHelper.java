package com.adl.service.repository.prepare;

import com.adl.service.data.PlanStudentData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.http.request.PlanStudentPageRequest;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OrgTestPrepareHelper {

    public OrgTestPrepareHelper() {
    }

    public Function<Void, Single<Void>> createPrepareStandardConfigDataFunc() {
        return (v) -> {
            DaoManagerProxy.getInstance().getStandardConfigDao().clearAll();
            return null;
        };
    }

    public Function<Void, Single<Void>> createClearPlanStudentPagesAllFunc() {
        return (v) -> {
            DaoManagerProxy.getInstance().getPlanStudentDao().clearAll();
            return null;
        };
    }


    public Function<PlanStudentPageRequest, Single<List<PlanStudentData>>> createPreparePlanStudentPagesAllFunc() {
        return (request) -> {
            DaoManagerProxy.getInstance().getPlanStudentDao().clearByPlanId(request.getPlanId());
            return null;
        };
    }

    public Function<Void, Single<Void>> createClearPlanPagesAllFunc() {
        return (v) -> {
            DaoManagerProxy.getInstance().getPlanStudentDao().clearAll();
            return null;
        };
    }
}
