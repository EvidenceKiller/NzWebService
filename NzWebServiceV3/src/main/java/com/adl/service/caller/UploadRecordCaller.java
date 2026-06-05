package com.adl.service.caller;

import com.adl.service.callback.FileUploadCallback;

/**
 * UploadQiNiuYunCaller。
 */
public interface UploadRecordCaller {

    void setAppCode(String appCode);

    void start(String belongId, String appCode);

    void setPauseFlag(boolean mPauseUploadFlag);

    void addCallback(FileUploadCallback callback);

    void removeCallback(FileUploadCallback callback);

    void stop();
}
