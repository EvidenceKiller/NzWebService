package com.adl.service.callback;

import java.io.File;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/8
 * Describe   : 类描述
 */
public class DownloadFileTask {
    public int type;
    // 需要下载的文件内容
    public String url;
    public String suffix;

    public String fileName;
    public File localFile;
    public long contentLength;

    public String userId;


    public DownloadFileTask(int type, String url, String suffix) {
        this.type = type;
        this.url = url;
        this.suffix = suffix;
    }

    public DownloadFileTask(int type, String url, String suffix, String userId) {
        this.type = type;
        this.url = url;
        this.suffix = suffix;
        this.userId = userId;
    }
}
