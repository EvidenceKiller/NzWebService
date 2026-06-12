package com.adl.service.exception;

/**
 * 通用异常
 */
public class NzCommonException extends NzBaseException {

    private static final String TAG = "NZ_COMMON_EXCEPTION";

    public NzCommonException(String message) {
        super(TAG, message);
    }

    public NzCommonException(String message, Throwable cause) {
        super(TAG, message, cause);
    }
}

