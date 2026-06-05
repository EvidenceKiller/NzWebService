package com.adl.service.caller;

import com.adl.service.data.LoginInfoData;
import com.adl.service.exception.NzBaseException;

/**
 * CommonDaoCaller。
 */
public interface CommonDaoCaller {
    String queryDictLabel(String dictCode, String dictValue);

    LoginInfoData getLoginInfo();
}
