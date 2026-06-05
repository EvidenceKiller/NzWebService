package com.adl.service.caller.impl;

import com.adl.service.caller.CommonDaoCaller;
import com.adl.service.data.LoginInfoData;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.CommonDaoRepository;

public class CommonDaoCallerImpl implements CommonDaoCaller {

    private final CommonDaoRepository commonDaoRepository;

    public CommonDaoCallerImpl() {
        this.commonDaoRepository = CommonDaoRepository.getInstance();
    }

    @Override
    public String queryDictLabel(String dictCode, String dictValue) {
        return RxCallbackScheduler.blockingGetNoThrow(commonDaoRepository.queryDictLabel(dictCode, dictValue), String.class);
    }

    @Override
    public LoginInfoData getLoginInfo() {
        return RxCallbackScheduler.blockingGetNoThrow(commonDaoRepository.getLoginInfo());
    }
}
