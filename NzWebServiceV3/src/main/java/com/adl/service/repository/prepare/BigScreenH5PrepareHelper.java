package com.adl.service.repository.prepare;

public final class BigScreenH5PrepareHelper {

    private static volatile BigScreenH5PrepareHelper instance;

    private BigScreenH5PrepareHelper() {
    }

    public static BigScreenH5PrepareHelper getInstance() {
        if (instance == null) {
            synchronized (BigScreenH5PrepareHelper.class) {
                if (instance == null) {
                    instance = new BigScreenH5PrepareHelper();
                }
            }
        }
        return instance;
    }
}
