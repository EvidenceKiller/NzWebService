package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.LoginData;
import com.adl.service.http.request.LoginRequest;
import com.adl.service.http.request.LogoutRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.CommonInfoService;
import com.adl.service.web.LoginAuthService;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class LoginAuthFetchHelper {

    private volatile LoginAuthService loginAuthService;
    private volatile String baseUrl;

    public LoginAuthFetchHelper() {
    }

    private synchronized LoginAuthService getService() {
        if (loginAuthService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            loginAuthService = RetrofitManager.getInstance().create(LoginAuthService.class);
        }
        return loginAuthService;
    }

    public Function<LoginRequest, Single<ResponseResult<LoginData>>> createLoginFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().login(request));
    }

    public Function<LogoutRequest, Single<ResponseResult<String>>> createLogoutFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().logout(request));
    }
}
