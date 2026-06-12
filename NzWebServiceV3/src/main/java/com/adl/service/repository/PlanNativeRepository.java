package com.adl.service.repository;

import com.adl.service.repository.persist.PlanNativePersistHelper;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class PlanNativeRepository {
    private final PlanNativePersistHelper persistHelper = new PlanNativePersistHelper();

    private static volatile PlanNativeRepository instance;

    private PlanNativeRepository() {
    }

    public static PlanNativeRepository getInstance() {
        if (instance == null) {
            synchronized (PlanNativeRepository.class) {
                if (instance == null) {
                    instance = new PlanNativeRepository();
                }
            }
        }
        return instance;
    }

    public Single<Boolean> clearStandardConfigData() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createPrepareStandardConfigDataFunc());
    }

    public Single<Boolean> clearPlanStudentData() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearPlanStudentPagesAllFunc());
    }

    public Single<Boolean> clearPlanData() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearPlanPagesAllFunc());
    }
}
