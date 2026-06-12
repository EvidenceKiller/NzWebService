package com.adl.service.repository.persist;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.IDefine;
import com.adl.service.common.InnerPreferences;
import com.adl.service.common.NzResponseCode;
import com.adl.service.exception.NzCommonException;
import com.adl.service.exception.NzPersistException;
import com.adl.service.http.request.QiNiuYunTokenRequest;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class UploadQiNiuYunPersistHelper {

    public UploadQiNiuYunPersistHelper() {
    }

    public Function<ResponseResult<String>, Single<ResponseResult<String>>> createPersistQiNiuYunTokenFunc(QiNiuYunTokenRequest request) {
        return (result) -> {
            if (result == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            String token = result.getData();
            if (token == null || token.isEmpty()) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "token is null"));
            }
            String keyTime = request.getBucket() + IDefine.LastQiNiuTime;
            String keyToken = request.getBucket() + IDefine.LastQiNiuToken;
            //  去除双引号
            token = token.replaceAll("\"", "");
            InnerPreferences.instance().putString(keyToken, token);
            InnerPreferences.instance().putLong(keyTime, System.currentTimeMillis());
            return Single.just(result);
        };
    }
}
