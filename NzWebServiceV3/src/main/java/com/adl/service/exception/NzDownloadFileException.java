package com.adl.service.exception;

/**
 * 通用异常
 */
public class NzDownloadFileException extends NzBaseException {

    private static final String TAG = "NZ_DOWNLOAD_FILE_EXCEPTION";

    private int code;

    public NzDownloadFileException(int code, String message) {
        super(TAG, message);
        this.code = code;
    }

    public NzDownloadFileException(int code, String message, Throwable cause) {
        super(TAG, message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

