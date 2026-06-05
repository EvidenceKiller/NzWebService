package com.adl.service.callback;

import java.io.File;

public interface FileDownCallback {

    void onProgress(long total, long read);

    void onEnd(File file);

    void onError(String error);
}
