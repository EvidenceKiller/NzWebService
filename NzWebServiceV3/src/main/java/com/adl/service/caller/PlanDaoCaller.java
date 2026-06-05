package com.adl.service.caller;

import com.adl.service.exception.NzBaseException;

/**
 * PlanDaoCaller。
 */
public interface PlanDaoCaller {

    void clearStandardConfigData();

    void clearPlanStudentData();

    void clearPlanData();
}
