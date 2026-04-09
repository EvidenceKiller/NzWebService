package com.adl.service.exception;

/**
 * 未知异常兜底。
 */
public final class NzUnknownException extends NzBaseException {

    public static final String CODE = "UNKNOWN_ERROR";

    public NzUnknownException(String message) {
        super(CODE, message);
    }

    public NzUnknownException(String message, Throwable cause) {
        super(CODE, message, cause);
    }
}

