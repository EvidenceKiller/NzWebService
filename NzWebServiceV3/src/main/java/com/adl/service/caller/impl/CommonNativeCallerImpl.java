package com.adl.service.caller.impl;

import com.adl.service.caller.CommonNativeCaller;
import com.adl.service.data.LoginInfoData;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.CommonNativeRepository;

public class CommonNativeCallerImpl implements CommonNativeCaller {

    private final CommonNativeRepository commonNativeRepository;

    public CommonNativeCallerImpl() {
        this.commonNativeRepository = CommonNativeRepository.getInstance();
    }

    @Override
    public String queryDictLabelSync(String dictCode, String dictValue) {
        return RxCallbackScheduler.scheduleSync(commonNativeRepository.queryDictLabel(dictCode, dictValue));
    }

    @Override
    public LoginInfoData getLoginInfoSync() {
        return RxCallbackScheduler.scheduleSync(commonNativeRepository.getLoginInfo());
    }
}
