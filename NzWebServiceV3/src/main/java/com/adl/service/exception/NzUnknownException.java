package com.adl.service.exception;

/**
 * 未知异常兜底。
 */
public final class NzUnknownException extends NzBaseException {

    private static final String TAG = "NZ_UNKNOWN_EXCEPTION";

    public NzUnknownException(String message) {
        super(TAG, message);
    }

    public NzUnknownException(String message, Throwable cause) {
        super(TAG, message, cause);
    }
}

