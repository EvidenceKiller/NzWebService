package com.adl.service.repository.prepare;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.IDefine;
import com.adl.service.common.InnerPreferences;
import com.adl.service.http.request.QiNiuYunTokenRequest;
import com.adl.service.utils.CommonUtil;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class UploadQiNiuYunPrepareHelper {

    public UploadQiNiuYunPrepareHelper() {
    }

    public Function<QiNiuYunTokenRequest, Single<ResponseResult<String>>> createPrepareQiNiuYunTokenFunc() {
        return (request) -> {
            String keyTime = request.getBucket() + IDefine.LastQiNiuTime;
            String keyToken = request.getBucket() + IDefine.LastQiNiuToken;
            long lastTime = InnerPreferences.instance().readLong(keyTime);
            String token = InnerPreferences.instance().readString(keyToken);
            // 30 分钟过期
            if (System.currentTimeMillis() - lastTime < 5 * IDefine.Minute) {
                if (!TextUtils.isEmpty(token)) {
                    return Single.just(CommonUtil.createSuccessResponseResult(token));
                }
            }
            return null;
        };
    }
}
