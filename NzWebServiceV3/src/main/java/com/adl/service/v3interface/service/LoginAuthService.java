package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.response.LoginData;
import com.example.rxsdk.v3interface.response.LogoutData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.POST;

/**
 * Name : LoginAuthService
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 提供Retrofit接口调用能力
 */
public interface LoginAuthService {
    /** 设备登录 */
    @POST("sso/login")
    Single<BaseResponse<LoginData>> getLogin();

    /** 退出登录 */
    @POST("sso/logout")
    Single<BaseResponse<LogoutData>> getLogout();
}
