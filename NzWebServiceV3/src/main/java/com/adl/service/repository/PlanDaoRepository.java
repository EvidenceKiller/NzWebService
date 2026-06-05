package com.adl.service.repository;

import com.adl.service.repository.persist.PlanDaoPersistHelper;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class PlanDaoRepository {
    private final PlanDaoPersistHelper persistHelper = new PlanDaoPersistHelper();

    private static volatile PlanDaoRepository instance;

    private PlanDaoRepository() {
    }

    public static PlanDaoRepository getInstance() {
        if (instance == null) {
            synchronized (PlanDaoRepository.class) {
                if (instance == null) {
                    instance = new PlanDaoRepository();
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
