package com.adl.service.http.interceptor;

import android.text.TextUtils;

import com.adl.service.common.IDefine;
import com.adl.service.common.InnerPreferences;
import com.adl.service.log.NzLog;
import com.adl.service.utils.CommonUtil;

import java.io.IOException;
import java.util.UUID;

import androidx.annotation.NonNull;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        NzLog.d("执行请求: " + request);

        String token = InnerPreferences.instance().readString(IDefine.SpToken);

        if (!TextUtils.isEmpty(token)) {
            // 设置Token
            Request.Builder reqBuilder = request.newBuilder();
            // temp test token
            reqBuilder.addHeader("Platform", "TERMINAL");
            reqBuilder.addHeader("RequestId", UUID.randomUUID().toString());
            reqBuilder.addHeader("Timestamp", String.valueOf(System.currentTimeMillis()));
            reqBuilder.addHeader("Authorization", "Bearer " + token);
            reqBuilder.addHeader("Accept-Language", CommonUtil.getLocaleLanguage());
            // next
            return chain.proceed(reqBuilder.build());
        } else {
            return chain.proceed(request);
        }
    }
}
