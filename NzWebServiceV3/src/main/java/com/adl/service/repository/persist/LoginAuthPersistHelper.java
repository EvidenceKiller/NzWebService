package com.adl.service.repository.persist;

public final class LoginAuthPersistHelper {

    private static volatile LoginAuthPersistHelper instance;

    private LoginAuthPersistHelper() {
    }

    public static LoginAuthPersistHelper getInstance() {
        if (instance == null) {
            synchronized (LoginAuthPersistHelper.class) {
                if (instance == null) {
                    instance = new LoginAuthPersistHelper();
                }
            }
        }
        return instance;
    }

}
