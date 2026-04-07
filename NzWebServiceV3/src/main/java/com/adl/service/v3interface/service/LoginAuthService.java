package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.response.LoginData;
import com.example.rxsdk.v3interface.response.LogoutData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.POST;

/** Auto-generated from v3interface HTML. */
public interface LoginAuthService {
    /** 设备登录 — 来源:dev */
    @POST("sso/login")
    Single<BaseResponse<LoginData>> getLogin();

    /** 退出登录 — 来源:dev */
    @POST("sso/logout")
    Single<BaseResponse<LogoutData>> getLogout();
}
