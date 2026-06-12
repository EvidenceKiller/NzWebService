package com.adl.service.exception;

/**
 * 业务失败异常（BaseResponse.isSuccess()==false）。
 */
public final class NzHttpException extends NzBaseException {

    private static final String TAG = "NZ_HTTP_EXCEPTION";

    private final int httpCode;

    public NzHttpException(int httpCode, String message) {
        super(TAG, message);
        this.httpCode = httpCode;
    }

    public NzHttpException(int httpCode, String message, Throwable cause) {
        super(TAG, message, cause);
        this.httpCode = httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }
}

