package com.adl.service.repository;

import com.adl.service.callback.GetPageResult;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;
import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassPageRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.StandardConfigPageRequest;
import com.adl.service.repository.fetch.OrgTestFetchHelper;
import com.adl.service.repository.persist.OrgTestPersistHelper;
import com.adl.service.repository.prepare.OrgTestPrepareHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class OrgTestRepository {
    private final OrgTestPrepareHelper prepareHelper = new OrgTestPrepareHelper();
    private final OrgTestFetchHelper fetchHelper = new OrgTestFetchHelper();
    private final OrgTestPersistHelper persistHelper = new OrgTestPersistHelper();

    private static volatile OrgTestRepository instance;

    private OrgTestRepository() {
    }

    public static OrgTestRepository getInstance() {
        if (instance == null) {
            synchronized (OrgTestRepository.class) {
                if (instance == null) {
                    instance = new OrgTestRepository();
                }
            }
        }
        return instance;
    }

    public Single<GetPageResult> getStandardConfigPagesAll(StandardConfigPageRequest request) {
        return BaseRepositoryUtil.repositoryListsAsSingle(request,
                fetchHelper.createGetStandardConfigPagesAllFunc(request),
                persistHelper.createPersistStandardConfigPageFunc());
    }

    public Single<List<StandardConfigData>> getStandardConfigPage(StandardConfigPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                fetchHelper.createGetStandardConfigPageFunc(),
                persistHelper.createPersistStandardConfigPageFunc());
    }

    public Single<GetPageResult> getPlanStudentPagesAll(PlanStudentPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createPreparePlanStudentPagesAllFunc(),
                fetchHelper.createGetPlanStudentPagesAllFunc(request),
                persistHelper.createPersistPlanStudentPageFunc(request));
    }

    public Single<List<PlanStudentData>> getPlanStudentPage(PlanStudentPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetPlanStudentPageFunc(),
                persistHelper.createPersistPlanStudentPageFunc(request));
    }

    public Single<GetPageResult> getPlanPagesAll(PlanPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                fetchHelper.createGetPlanPagesAllFunc(request),
                persistHelper.createPersistPlanPageFunc(request));
    }

    public Single<List<PlanData>> getPlanPage(PlanPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetPlanPageFunc(),
                persistHelper.createPersistPlanPageFunc(request));
    }

    public Single<PlanInfoData> getPlanInfo(PlanInfoRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetPlanInfoFunc());
    }

    public Single<List<PlanClassData>> getPlanClassPage(PlanClassPageRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetPlanClassPageFunc());
    }

    public Single<Boolean> checkStudentInPlan(CheckStudentInPlanRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createCheckStudentInPlanFunc());
    }
}
