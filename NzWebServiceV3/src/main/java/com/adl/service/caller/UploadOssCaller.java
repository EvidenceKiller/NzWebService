package com.adl.service.caller;

import com.adl.service.common.OssType;
import com.adl.service.data.FileUploadInfoData;
import com.ssp.oss.sdk.callback.OssSwitchCallback;
import com.ssp.oss.sdk.callback.UploadCallback;
import com.ssp.oss.sdk.model.OssConfigList;
import com.ssp.oss.sdk.model.SyncUploadResult;

/**
 * UploadOssCaller。
 */
public interface UploadOssCaller {
    void init();

    void release();

    String getPrefix();

    String uploadFile(String localFilePath, String uploadFilePrefix, String uploadFileName, UploadCallback callback);

    SyncUploadResult uploadFileSync(String localFilePath, String uploadFilePrefix, String uploadFileName);

    boolean uploadFileDataSync(FileUploadInfoData data);

    void cancelUpload(String requestId);

    OssConfigList getOssConfigList();

    String getCurrentOssType();

    void switchOssSync(OssType ossType);

    void switchOssAsync(OssType ossType, OssSwitchCallback callback);

}
