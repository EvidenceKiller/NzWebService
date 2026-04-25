package com.adl.service.repository.prepare;

public final class SportInfoPrepareHelper {

    private static volatile SportInfoPrepareHelper instance;

    private SportInfoPrepareHelper() {
    }

    public static SportInfoPrepareHelper getInstance() {
        if (instance == null) {
            synchronized (SportInfoPrepareHelper.class) {
                if (instance == null) {
                    instance = new SportInfoPrepareHelper();
                }
            }
        }
        return instance;
    }
}
