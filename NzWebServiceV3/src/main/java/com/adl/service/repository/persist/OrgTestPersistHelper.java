package com.adl.service.repository.persist;

import com.adl.service.data.PlanData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.PlanEntity;
import com.adl.service.db.entity.PlanStudentEntity;
import com.adl.service.db.entity.StandardConfigEntity;
import com.adl.service.exception.NzCommonException;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OrgTestPersistHelper {

    public OrgTestPersistHelper() {
    }

    public Function<List<PlanStudentData>, Single<List<PlanStudentData>>> createPersistPlanStudentPageFunc(PlanStudentPageRequest request) {
        return (pageData) -> {
            if (pageData == null || pageData.isEmpty()) {
                return Single.error(new NzCommonException("plan student data list is null"));
            }
            List<PlanStudentEntity> entityList = pageData.stream()
                    .map(data -> PlanStudentEntity.convertToEntity(data))
                    .collect(Collectors.toList());
            entityList.forEach(plan -> plan.setPlanId(request.getPlanId()));
            DaoManagerProxy.getInstance().getPlanStudentDao().insertAll(entityList);
            return Single.just(pageData);
        };
    }

    public Function<List<PlanData>, Single<List<PlanData>>> createPersistPlanPageFunc(PlanPageRequest request) {
        return (pageData) -> {
            if (pageData == null || pageData.isEmpty()) {
                return Single.error(new NzCommonException("plan data list is null"));
            }
            // 将 PlanData 转换为 PlanEntity
            List<PlanEntity> entityList = pageData.stream()
                    .map(data -> PlanEntity.convertToEntity(data))
                    .collect(Collectors.toList());

            DaoManagerProxy.getInstance().getPlanDao().insertPlanList(entityList);
            return Single.just(pageData);
        };
    }

    public Function<List<StandardConfigData>, Single<List<StandardConfigData>>> createPersistStandardConfigPageFunc() {
        return (dataList) -> {
            if (dataList == null || dataList.isEmpty()) {
                return Single.error(new NzCommonException("student config data list is null"));
            }
            List<StandardConfigEntity> entityList = dataList.stream()
                    .map(data -> StandardConfigEntity.convertToEntity(data))
                    .collect(Collectors.toList());
            DaoManagerProxy.getInstance().getStandardConfigDao().insertAll(entityList);
            return Single.just(dataList);
        };
    }
}
