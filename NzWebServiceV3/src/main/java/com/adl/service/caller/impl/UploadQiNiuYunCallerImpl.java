package com.adl.service.caller.impl;

import android.text.TextUtils;

import com.adl.service.AdlService;
import com.adl.service.callback.ResponseResult;
import com.adl.service.caller.UploadQiNiuYunCaller;
import com.adl.service.common.AdlConfig;
import com.adl.service.common.AdlConfigService;
import com.adl.service.common.IDefine;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.FileUploadInfoData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.FileUploadDao;
import com.adl.service.db.entity.FileUploadInfoEntity;
import com.adl.service.http.request.QiNiuYunTokenRequest;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.log.NzLog;
import com.adl.service.repository.UploadQiNiuYunRepository;
import com.adl.service.callback.FileUploadCallback;
import com.adl.service.callback.UploadFileTask;
import com.adl.service.utils.CommonUtil;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SportInfoCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class UploadQiNiuYunCallerImpl implements UploadQiNiuYunCaller {

    private ExecutorService mExecutors;

    private final Object mLock = new Object();
    private UploadManager uploadManager;
    private FileUploadDao uploadDao;
    private boolean mStart;
    private List<FileUploadCallback> mCallbacks = new ArrayList<>();

    private final UploadQiNiuYunRepository uploadQiNiuYunRepository;

    public UploadQiNiuYunCallerImpl() {
        this.uploadQiNiuYunRepository = UploadQiNiuYunRepository.getInstance();

        mExecutors = Executors.newFixedThreadPool(2);

        Configuration config = new Configuration.Builder()
                .connectTimeout(90)                 // 链接超时。默认90秒
                .useHttps(false)                    // 是否使用https上传域名
                .useConcurrentResumeUpload(true)    // 使用并发上传，使用并发上传时，除最后一块大小不定外，其余每个块大小固定为4M，
                .concurrentTaskCount(3)             // 并发上传线程数量为3
                .responseTimeout(90)                // 服务器响应超时。默认90秒
                .zone(FixedZone.zone2)              // 设置区域，不指定会自动选择。指定不同区域的上传域名、备用域名、备用IP。
                .build();

        // 重用uploadManager，一般地，只需要创建一个uploadManager对象
        uploadManager = new UploadManager(config);

        // dao
        uploadDao = DaoManagerProxy.getInstance().getFileUploadDao();

        // 启动任务
        mStart = true;
        new Thread(() -> {

            while (mStart) {

                AdlConfig adlConfig = AdlConfigService.getAdlConfig();
                if (adlConfig == null || TextUtils.isEmpty(adlConfig.getQiNiuHost())) {
                    CommonUtil.waitSleep(100);
                    continue;
                }

                try {

                    FileUploadInfoEntity entity = queryUpdateTask();
                    if (entity == null) {
                        CommonUtil.waitSleep(100);
                        continue;
                    }

                    File file = new File(entity.getLocalPath());
                    if (file.exists()) {
                        NzLog.d("正在上传: " + entity.getLocalPath());
                        startCallback(file);
                        String remoteFileName = entity.getRemoteFileName();
                        String bucket = entity.getRemoteBucket();
                        if (TextUtils.isEmpty(bucket)) bucket = adlConfig.getQiNiuBucket();
                        if (TextUtils.isEmpty(bucket)) bucket = IDefine.QiNiuPublicBucket;
                        String token = getQiNiuYunTokenSync(QiNiuYunTokenRequest.builder(bucket).build());
                        String url = syncUploadFileToQiNiuYun(file, remoteFileName, token, null);
                        if (url != null) {
                            entity.setRemoteUrl(url);
                            entity.setUploadStatus(IDefine.FileUploadStatusDone);
                            entity.setRemark("上传完成");
                            NzLog.d("文件上传成功: " + url);
                        } else {
                            entity.setUploadStatus(IDefine.FileUploadStatusNew);
                            entity.setRemark("上传失败，等待下次上传");
                        }
                        completeCallback(file, url);
                    } else {
                        entity.setUploadStatus(IDefine.FileUploadStatusError);
                        entity.setRemark("文件路径不存在");
                    }

                    uploadDao.update(entity);
                    CommonUtil.waitSleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void uploadTaskAsync(List<UploadFileTask> list) {
        if (list == null || list.isEmpty()) return;
        mExecutors.submit(() -> {
            synchronized (mLock) {
                for (UploadFileTask task : list) {
                    FileUploadInfoEntity entity = new FileUploadInfoEntity();
                    entity.setOrgId(task.orgId);
                    entity.setLocalPath(task.file.getAbsolutePath());
                    entity.setRemoteFileName(task.remoteFileName);
                    entity.setUploadStatus(IDefine.FileUploadStatusNew);
                    entity.setCreateTime(System.currentTimeMillis());
                    entity.setRemoteBucket(task.bucket);
                    uploadDao.insert(entity);
                }
            }
        });
    }

    @Override
    public String uploadFileSync(File file, String remoteFileName) {
        AdlConfig adlConfig = AdlConfigService.getAdlConfig();
        if (adlConfig == null || TextUtils.isEmpty(adlConfig.getQiNiuHost())) {
            NzLog.i("UploadQiNiuYunCaller::uploadFileSync : 上传配置错误");
            return null;
        }
        if (file == null || !file.exists()) {
            NzLog.i("UploadQiNiuYunCaller::uploadFileSync : 文件路径不存在");
            return null;
        }
        if (TextUtils.isEmpty(remoteFileName)) {
            NzLog.i("UploadQiNiuYunCaller::uploadFileSync : 远端文件名为空");
            return null;
        }

        String token = getQiNiuYunTokenSync(QiNiuYunTokenRequest.builder(IDefine.QiNiuPublicBucket).build());
        String url = syncUploadFileToQiNiuYun(file, remoteFileName, token, new UploadOptions(null, null, true, null, null));
        if (url == null || TextUtils.isEmpty(url)) {
            NzLog.i("UploadQiNiuYunCaller::uploadFileSync : 上传失败");
            return null;
        }
        return url;
    }

    @Override
    public boolean uploadFileDataSync(FileUploadInfoData data) {
        File file = new File(data.getLocalPath());
        boolean isSuccess;
        if (file.exists()) {
            String remoteFileName = data.getRemoteFileName();
            String bucket = !TextUtils.isEmpty(data.getRemoteBucket()) ? data.getRemoteBucket() : IDefine.QiNiuPublicBucket;

            String token = getQiNiuYunTokenSync(QiNiuYunTokenRequest.builder(bucket).build());
            String url = syncUploadFileToQiNiuYun(file, remoteFileName, token, null);
            if (url != null) {
                data.setRemoteUrl(url);
                data.setUploadStatus(IDefine.FileUploadStatusDone);
                data.setRemark("上传完成");
                NzLog.d("文件上传成功 QiNiuYun: " + url);
                isSuccess = true;
            } else {
                data.setUploadStatus(IDefine.FileUploadStatusNew);
                data.setRemark("上传失败，等待下次上传");
                isSuccess = false;
            }
        } else {
            data.setUploadStatus(IDefine.FileUploadStatusError);
            data.setRemark("文件路径不存在");
            isSuccess = true;
        }

        uploadDao.insert(FileUploadInfoEntity.convertToEntity(data));
        return isSuccess;
    }

    @Override
    public void addCallback(FileUploadCallback callback) {
        if (callback != null && !mCallbacks.contains(callback)) {
            mCallbacks.add(callback);
        }
    }

    @Override
    public void removeCallback(FileUploadCallback callback) {
        if (callback != null) {
            mCallbacks.remove(callback);
        }
    }

    @Override
    public void release() {
        mStart = false;
        if (mExecutors != null && !mExecutors.isShutdown()) {
            mExecutors.shutdown();
        }
        // 中断可能正在等待的线程，加速退出
        synchronized (mLock) {
            mCallbacks.clear();
        }
    }

    // 从数据库中查询需要上传的任务
    private FileUploadInfoEntity queryUpdateTask() {
        synchronized (mLock) {
            FileUploadInfoEntity entity = uploadDao.queryOneFileStatus(IDefine.FileUploadStatusNew);
            if (entity != null) {
                entity.setUploadStatus(IDefine.FileUploadStatusDoing);
                return entity;
            }
        }
        return null;
    }

    private String getQiNiuYunTokenSync(QiNiuYunTokenRequest request) {
        ResponseResult<String> tokenResult = RxCallbackScheduler.scheduleResultSync(uploadQiNiuYunRepository.getQiNiuYunToken(request));
        String token = "";
        if (tokenResult.getCode() == NzResponseCode.NZ_SUCCESS && tokenResult.getData() != null) {
            token = tokenResult.getData();
        }
        return token;
    }

    private String syncUploadFileToQiNiuYun(File file, String name, String token, UploadOptions options) {
        try {
            ResponseInfo info = uploadManager.syncPut(file, name, token, options);
            if (info.isOK()) {
                String facePrefix = AdlConfigService.getAdlConfig().getFacePrefix();
                return facePrefix + info.response.getString("key");
            } else {
                NzLog.e("七牛上传: token: " + token + ", code: " + info.statusCode + ", error: " + info.error);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void startCallback(File file) {
        for (FileUploadCallback callback : mCallbacks) {
            callback.onStart(file);
        }
    }

    private void completeCallback(File file, String url) {
        for (FileUploadCallback callback : mCallbacks) {
            callback.onComplete(file, url);
        }
    }
}
