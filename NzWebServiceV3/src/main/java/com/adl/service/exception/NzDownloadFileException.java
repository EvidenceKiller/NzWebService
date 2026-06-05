package com.adl.service.exception;

/**
 * 通用异常
 */
public class NzDownloadFileException extends NzBaseException {

    private static final String CODE = "NZ_DOWNLOAD_FILE_EXCEPTION";

    private String content;

    public NzDownloadFileException(String content, String message) {
        super(CODE, message);
        this.content = content;
    }

    public NzDownloadFileException(String content, String message, Throwable cause) {
        super(CODE, message, cause);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

