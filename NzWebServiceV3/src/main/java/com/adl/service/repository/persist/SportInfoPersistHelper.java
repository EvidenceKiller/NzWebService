package com.adl.service.repository.persist;

public final class SportInfoPersistHelper {

    private static volatile SportInfoPersistHelper instance;

    private SportInfoPersistHelper() {
    }

    public static SportInfoPersistHelper getInstance() {
        if (instance == null) {
            synchronized (SportInfoPersistHelper.class) {
                if (instance == null) {
                    instance = new SportInfoPersistHelper();
                }
            }
        }
        return instance;
    }

}
