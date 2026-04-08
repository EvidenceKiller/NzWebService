package com.adl.service.v3interface.out.impl;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.api.RxSdk;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.exception.NzBaseException;
import com.adl.service.v3interface.internal.RxCallbackScheduler;
import com.adl.service.v3interface.internal.SubscriptionManager;
import com.adl.service.v3interface.out.LoginAuthCaller;
import com.adl.service.v3interface.request.LoginRequest;
import com.adl.service.v3interface.request.LogoutRequest;
import com.adl.service.v3interface.response.LoginData;
import com.adl.service.v3interface.service.LoginAuthService;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * LoginAuthCaller 实现（SDK 内部使用，通过 {@link RxSdk} 暴露）。
 */
public final class LoginAuthCallerImpl implements LoginAuthCaller {

    private final LoginAuthService loginAuthService;

    public LoginAuthCallerImpl(LoginAuthService loginAuthService) {
        this.loginAuthService = loginAuthService;
    }

    @Override
    public long loginAsync(RequestScope scope, LoginRequest request, RequestCallback<LoginData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(loginAuthService.login(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public LoginData loginSync(LoginRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(loginAuthService.login(request));
    }

    @Override
    public long logoutAsync(RequestScope scope, LogoutRequest request, RequestCallback<String> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(loginAuthService.logout(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public String logoutSync(LogoutRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(loginAuthService.logout(request));
    }
}
