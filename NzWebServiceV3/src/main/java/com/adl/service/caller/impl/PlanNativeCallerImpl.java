package com.adl.service.caller.impl;

import com.adl.service.caller.PlanNativeCaller;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.PlanNativeRepository;

/**
 * PlanDaoCallerImpl
 */
public final class PlanNativeCallerImpl implements PlanNativeCaller {

    private final PlanNativeRepository planNativeRepository;

    public PlanNativeCallerImpl() {
        planNativeRepository = PlanNativeRepository.getInstance();
    }

    @Override
    public void clearStandardConfigDataSync() {
        RxCallbackScheduler.scheduleSync(planNativeRepository.clearStandardConfigData());
    }

    @Override
    public void clearPlanStudentDataSync() {
        RxCallbackScheduler.scheduleSync(planNativeRepository.clearPlanStudentData());
    }

    @Override
    public void clearPlanDataSync() {
        RxCallbackScheduler.scheduleSync(planNativeRepository.clearPlanData());
    }
}
