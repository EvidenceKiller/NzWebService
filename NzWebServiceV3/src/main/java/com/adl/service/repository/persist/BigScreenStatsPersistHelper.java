package com.adl.service.repository.persist;

public final class BigScreenStatsPersistHelper {

    private static volatile BigScreenStatsPersistHelper instance;

    private BigScreenStatsPersistHelper() {
    }

    public static BigScreenStatsPersistHelper getInstance() {
        if (instance == null) {
            synchronized (BigScreenStatsPersistHelper.class) {
                if (instance == null) {
                    instance = new BigScreenStatsPersistHelper();
                }
            }
        }
        return instance;
    }

}
