package com.adl.service.repository.prepare;

public final class BigScreenStatsPrepareHelper {

    private static volatile BigScreenStatsPrepareHelper instance;

    private BigScreenStatsPrepareHelper() {
    }

    public static BigScreenStatsPrepareHelper getInstance() {
        if (instance == null) {
            synchronized (BigScreenStatsPrepareHelper.class) {
                if (instance == null) {
                    instance = new BigScreenStatsPrepareHelper();
                }
            }
        }
        return instance;
    }
}
