package com.adl.service.web;

import com.adl.service.http.request.LoginRequest;
import com.adl.service.http.request.LogoutRequest;
import com.adl.service.data.BaseResponse;
import com.adl.service.data.LoginData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface LoginAuthService {
    /**
     * 设备登录
     */
    @POST("v3/gateway/api/sso/login")
    Single<BaseResponse<LoginData>> login(@Body LoginRequest request);

    /**
     * 退出登录
     */
    @POST("v3/gateway/api/sso/logout")
    Single<BaseResponse<String>> logout(@Body LogoutRequest request);
}
