package com.adl.service.caller;

import com.adl.service.callback.FileUploadCallback;
import com.adl.service.callback.UploadFileTask;
import com.adl.service.data.FileUploadInfoData;
import com.adl.service.exception.NzBaseException;

import java.io.File;
import java.util.List;

/**
 * UploadQiNiuYunCaller。
 */
public interface UploadQiNiuYunCaller {

    /**
     * 添加上传任务
     * <p>异步调用。</p>
     */
    void uploadTaskAsync(List<UploadFileTask> list);

    String uploadFileSync(File file, String remoteFileName);

    boolean uploadFileDataSync(FileUploadInfoData data);

    void addCallback(FileUploadCallback callback);

    void removeCallback(FileUploadCallback callback);

    void release();
}
