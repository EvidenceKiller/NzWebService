package com.adl.service.repository.fetch;

import com.adl.service.data.LoginData;
import com.adl.service.http.request.LoginRequest;
import com.adl.service.http.request.LogoutRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.LoginAuthService;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class LoginAuthFetchHelper {

    private final LoginAuthService loginAuthService;

    public LoginAuthFetchHelper() {
        this.loginAuthService = RetrofitManager.getInstance().create(LoginAuthService.class);
    }

    public Function<LoginRequest, Single<LoginData>> createLoginFunc() {
        return (request) -> loginAuthService.login(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<LogoutRequest, Single<String>> createLogoutFunc() {
        return (request) -> loginAuthService.logout(request).map(BaseFetchUtil::scheduleResponse);
    }
}
