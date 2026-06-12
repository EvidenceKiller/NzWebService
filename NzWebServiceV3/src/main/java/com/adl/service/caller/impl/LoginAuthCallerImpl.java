package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.caller.LoginAuthCaller;
import com.adl.service.data.LoginData;
import com.adl.service.http.request.LoginRequest;
import com.adl.service.http.request.LogoutRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.LoginAuthRepository;

/**
 * LoginAuthCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class LoginAuthCallerImpl implements LoginAuthCaller {

    private final LoginAuthRepository loginAuthRepository;

    public LoginAuthCallerImpl() {
        this.loginAuthRepository = LoginAuthRepository.getInstance();
    }

    @Override
    public long loginAsync(RequestScope scope, LoginRequest request, RequestCallback<LoginData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, loginAuthRepository.login(request), callback);
    }

    @Override
    public ResponseResult<LoginData> loginSync(LoginRequest request) {
        return RxCallbackScheduler.scheduleResultSync(loginAuthRepository.login(request));
    }

    @Override
    public long logoutAsync(RequestScope scope, LogoutRequest request, RequestCallback<String> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, loginAuthRepository.logout(request), callback);
    }

    @Override
    public ResponseResult<String> logoutSync(LogoutRequest request) {
        return RxCallbackScheduler.scheduleResultSync(loginAuthRepository.logout(request));
    }
}
