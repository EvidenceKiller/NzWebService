package com.adl.service.exception;

/**
 * SDK 异常基类（简单框架：用于统一分类网络/服务端/分页/未知错误）。
 */
public abstract class NzBaseException extends Exception {

    private final String errorTag;

    protected NzBaseException(String errorTag, String message) {
        super(message);
        this.errorTag = errorTag;
    }

    protected NzBaseException(String errorTag, String message, Throwable cause) {
        super(message, cause);
        this.errorTag = errorTag;
    }

    @Override
    public String getMessage() {
        return "[" + errorTag + "] " + super.getMessage();
    }
}

