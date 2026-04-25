package com.adl.service.repository.prepare;

public final class LoginAuthPrepareHelper {

    private static volatile LoginAuthPrepareHelper instance;

    private LoginAuthPrepareHelper() {
    }

    public static LoginAuthPrepareHelper getInstance() {
        if (instance == null) {
            synchronized (LoginAuthPrepareHelper.class) {
                if (instance == null) {
                    instance = new LoginAuthPrepareHelper();
                }
            }
        }
        return instance;
    }
}
