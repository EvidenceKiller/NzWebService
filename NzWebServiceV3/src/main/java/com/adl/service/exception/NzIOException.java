package com.adl.service.exception;

/**
 * 网络/IO 类异常（例如超时、断网等）。
 */
public final class NzIOException extends NzBaseException {

    private static final String TAG = "NZ_IO_EXCEPTION";

    public NzIOException(String message) {
        super(TAG, message);
    }

    public NzIOException(String message, Throwable cause) {
        super(TAG, message, cause);
    }
}

