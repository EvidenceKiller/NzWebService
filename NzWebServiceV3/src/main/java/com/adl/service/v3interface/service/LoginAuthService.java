package com.adl.service.v3interface.service;

import com.adl.service.v3interface.request.LoginRequest;
import com.adl.service.v3interface.request.LogoutRequest;
import com.adl.service.v3interface.response.LoginData;
import com.example.rxsdk.response.BaseResponse;

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
    @POST("sso/login")
    Single<BaseResponse<LoginData>> login(@Body LoginRequest request);

    /**
     * 退出登录
     */
    @POST("sso/logout")
    Single<BaseResponse<String>> logout(@Body LogoutRequest request);
}
