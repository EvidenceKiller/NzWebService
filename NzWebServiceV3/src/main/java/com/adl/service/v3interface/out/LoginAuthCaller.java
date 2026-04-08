package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.request.LoginRequest;
import com.adl.service.v3interface.request.LogoutRequest;
import com.adl.service.v3interface.response.LoginData;

/**
 * LoginAuthCaller。
 */
public interface LoginAuthCaller {

    long loginAsync(RequestScope scope, LoginRequest request, RequestCallback<LoginData> callback);

    LoginData loginSync(LoginRequest request);

    long logoutAsync(RequestScope scope, LogoutRequest request, RequestCallback<String> callback);

    String logoutSync(LogoutRequest request);

}
