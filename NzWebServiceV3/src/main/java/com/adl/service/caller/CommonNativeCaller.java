package com.adl.service.caller;

import com.adl.service.data.LoginInfoData;

/**
 * CommonDaoCaller。
 */
public interface CommonNativeCaller {
    String queryDictLabelSync(String dictCode, String dictValue);

    LoginInfoData getLoginInfoSync();
}
