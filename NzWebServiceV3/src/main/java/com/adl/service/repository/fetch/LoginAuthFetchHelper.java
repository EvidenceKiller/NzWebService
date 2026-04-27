package com.adl.service.repository.fetch;

import com.adl.service.data.LoginData;
import com.adl.service.http.request.LoginRequest;
import com.adl.service.http.request.LogoutRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.LoginAuthService;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class LoginAuthFetchHelper {

    private static volatile LoginAuthFetchHelper instance;

    private final LoginAuthService loginAuthService;

    public LoginAuthFetchHelper() {
        this.loginAuthService = RetrofitManager.getInstance().create(LoginAuthService.class);
    }

    public Function<LoginRequest, Single<LoginData>> createLoginFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(loginAuthService.login(request), LoginData.class);
    }

    public Function<LogoutRequest, Single<String>> createLogoutFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(loginAuthService.logout(request), String.class);
    }
}
