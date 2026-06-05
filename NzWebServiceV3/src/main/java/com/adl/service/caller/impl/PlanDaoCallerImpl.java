package com.adl.service.caller.impl;

import com.adl.service.caller.PlanDaoCaller;
import com.adl.service.exception.NzBaseException;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.PlanDaoRepository;

/**
 * PlanDaoCallerImpl
 */
public final class PlanDaoCallerImpl implements PlanDaoCaller {

    private final PlanDaoRepository planDaoRepository;

    public PlanDaoCallerImpl() {
        planDaoRepository = PlanDaoRepository.getInstance();
    }

    @Override
    public void clearStandardConfigData() {
        RxCallbackScheduler.blockingGetNoThrow(planDaoRepository.clearStandardConfigData());
    }

    @Override
    public void clearPlanStudentData() {
        RxCallbackScheduler.blockingGetNoThrow(planDaoRepository.clearPlanStudentData());
    }

    @Override
    public void clearPlanData() {
        RxCallbackScheduler.blockingGetNoThrow(planDaoRepository.clearPlanData());
    }
}
