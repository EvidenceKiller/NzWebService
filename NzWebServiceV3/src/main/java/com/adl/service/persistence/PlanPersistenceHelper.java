package com.adl.service.persistence;

import com.adl.service.db.DaoManagerProxy;
import com.adl.service.web.request.PlanPageRequest;
import com.adl.service.web.response.BasePageData;
import com.adl.service.web.response.BaseResponse;
import com.adl.service.web.response.PlanData;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class PlanPersistenceHelper {

    private PlanPersistenceHelper() {
    }

    /**
     * 为 Plan 分页请求构建通用的 PageRequester
     */
    public static Function<Long, Single<BaseResponse<BasePageData<PlanData>>>> createPlanPageRequester(
            PlanPageRequest request, Function<PlanPageRequest, Single<BaseResponse<BasePageData<PlanData>>>> function) {
        return (page) -> {
            PlanPageRequest pageReq = PlanPageRequest.builder()
                    .orgId(request.getOrgId())
                    .standardType(request.getStandardType())
                    .acayearCode(request.getAcayearCode())
                    .status(request.getStatus())
                    .showStatistic(request.getShowStatistic())
                    .planId(request.getPlanId())
                    .pageSize(request.getPageSize())
                    .current(page)
                    .build();
            return function.apply(pageReq);
        };
    }

    /**
     * 为 Plan 数据构建通用的 Persister
     */
    public static Function<List<PlanData>, Completable> createPlanPagePersister() {
        return (records) -> {
            if (records == null || records.isEmpty()) {
                return Completable.complete();
            }
            return DaoManagerProxy.getInstance().getPlanDao().insertPlanList(records);
        };
    }
}
