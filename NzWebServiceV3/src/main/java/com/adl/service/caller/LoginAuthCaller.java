package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.LoginRequest;
import com.adl.service.web.request.LogoutRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.response.LoginData;

/**
 * LoginAuthCaller。
 */
public interface LoginAuthCaller {

    long loginAsync(RequestScope scope, LoginRequest request, RequestCallback<LoginData> callback);

    LoginData loginSync(LoginRequest request) throws NzBaseException;

    long logoutAsync(RequestScope scope, LogoutRequest request, RequestCallback<String> callback);

    String logoutSync(LogoutRequest request) throws NzBaseException;

}
