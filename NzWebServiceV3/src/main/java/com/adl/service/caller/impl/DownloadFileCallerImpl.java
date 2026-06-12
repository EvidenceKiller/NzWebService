package com.adl.service.caller.impl;

import android.text.TextUtils;

import com.adl.service.AdlService;
import com.adl.service.callback.DownloadFileTask;
import com.adl.service.callback.FileDownCallback;
import com.adl.service.callback.FileDownSampleCallback;
import com.adl.service.callback.FileListDownCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.caller.DownloadFileCaller;
import com.adl.service.common.IDefine;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.FileDownDao;
import com.adl.service.db.entity.FileDownInfoEntity;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.log.NzLog;
import com.adl.service.repository.DownloadFileRepository;
import com.adl.service.utils.FileUtil;
import com.adl.service.utils.InnerUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 文件下载管理
 * 1. 学生人脸图片下载
 * 2. 视频下载
 * 3. 图片下载
 */
public final class DownloadFileCallerImpl implements DownloadFileCaller {

    public static final String STUDENT_FACE_DIR_NAME = "studentFace";
    public static final String TEACHER_FACE_DIR_NAME = "teacherFace";

    private ExecutorService mExecutors;

    private final DownloadFileRepository downloadFileRepository;

    public DownloadFileCallerImpl() {
        mExecutors = Executors.newFixedThreadPool(2);
        downloadFileRepository = DownloadFileRepository.getInstance();
    }

    @Override
    public void setMultiThread(int threadNum) {
        mExecutors = Executors.newFixedThreadPool(threadNum);
    }

    // 下载视频
    @Override
    public void downVideo(List<String> list, FileListDownCallback callback) {
        List<DownloadFileTask> downTasks = new ArrayList<>();
        for (String url : list) {
            downTasks.add(new DownloadFileTask(IDefine.FileDownloadTypeVideo, url, ".mp4"));
        }
        downloadTask(FileUtil.createLocalVideo(), downTasks, callback);
    }

    // 下载图片
    @Override
    public void downImage(List<String> list, FileListDownCallback callback) {
        List<DownloadFileTask> downTasks = new ArrayList<>();
        for (String url : list) {
            downTasks.add(new DownloadFileTask(IDefine.FileDownloadTypeImage, url, ".jpg"));
        }
        downloadTask(FileUtil.createLocalImage(), downTasks, callback);
    }

    // 下载文件
    @Override
    public void downFile(List<String> list, String suffix, FileListDownCallback callback) {
        List<DownloadFileTask> downTasks = new ArrayList<>();
        for (String url : list) {
            downTasks.add(new DownloadFileTask(IDefine.FileDownloadTypeFile, url, suffix));
        }
        downloadTask(FileUtil.createLocalFile(), downTasks, callback);
    }

    // 下载学生人脸信息
    @Override
    public void downStudentFaceImage(List<StudentData> list, FileListDownCallback callback) {
        File dataDir = AdlService.getService().getContext().getDataDir();
        File faceDir = new File(dataDir, STUDENT_FACE_DIR_NAME);
        if (!faceDir.exists()) {
            faceDir.mkdirs();
        }

        List<DownloadFileTask> downTasks = new ArrayList<>();
        for (StudentData stu : list) {
            String userFaceImgUrl = stu.getUserFaceImgUrl();
            if (!TextUtils.isEmpty(userFaceImgUrl)) {
                String url = InnerUtil.formatFaceUrl(userFaceImgUrl);
                downTasks.add(new DownloadFileTask(IDefine.FileDownloadTypeStudentHead, url, FileUtil.getFileSuffix(url), stu.getAccountId()));
            } else {
                downTasks.add(null);
            }
        }

        downloadTask(faceDir, downTasks, callback);
    }

    // 下载教师人脸信息
    @Override
    public void downTeacherFaceImage(List<TeacherData> list, FileListDownCallback callback) {
        File dataDir = AdlService.getService().getContext().getDataDir();
        File faceDir = new File(dataDir, TEACHER_FACE_DIR_NAME);
        if (!faceDir.exists()) {
            faceDir.mkdirs();
        }

        List<DownloadFileTask> downTasks = new ArrayList<>();
        for (TeacherData teacher : list) {
            String accountAvatar = teacher.getAccountAvatar();
            if (!TextUtils.isEmpty(accountAvatar)) {
                String url = InnerUtil.formatFaceUrl(accountAvatar);
                downTasks.add(new DownloadFileTask(IDefine.FileDownloadTypeTeacherHead, url, FileUtil.getFileSuffix(url)));
            } else {
                downTasks.add(null);
            }
        }

        downloadTask(faceDir, downTasks, callback);
    }

    // 下载学生人脸信息
    @Override
    public void downStudentThumbnailFaceImage(Boolean useThumbnail, List<StudentData> list,
                                              FileListDownCallback callback) {

        File dataDir = AdlService.getService().getContext().getDataDir();
        File faceDir = new File(dataDir, STUDENT_FACE_DIR_NAME);
        if (!faceDir.exists()) {
            faceDir.mkdirs();
        }

        List<DownloadFileTask> downTasks = new ArrayList<>();
        for (StudentData stu : list) {
            String userFaceImgUrl = useThumbnail ? stu.getThumbnailUserFaceImgUrl() : stu.getUserFaceImgUrl();
            if (!TextUtils.isEmpty(userFaceImgUrl)) {
                String url = InnerUtil.formatFaceUrl(userFaceImgUrl);
                downTasks.add(new DownloadFileTask(IDefine.FileDownloadTypeStudentHead, url, FileUtil.getFileSuffix(url), stu.getAccountId()));
            }
        }

        downloadTask(faceDir, downTasks, callback);
    }

    private void downloadTask(File dir, List<DownloadFileTask> list, FileListDownCallback listCallback) {
        if (list == null || list.isEmpty() || dir == null) {
            if (listCallback != null) {
                listCallback.onComplete();
            }
            return;
        }

        mExecutors.submit(() -> {
            int total = list.size();
            int downSuccess = 0;
            int downFail = 0;

            if (listCallback != null) {
                listCallback.onStart();
            }

            FileDownDao fileDao = DaoManagerProxy.getInstance().getFileDownDao();

            FileDownSampleCallback callback = new FileDownSampleCallback() {
                @Override
                public void onEnd(File file) {

                }
            };

            for (DownloadFileTask task : list) {

                if (task == null || TextUtils.isEmpty(task.url)) {
                    downSuccess++;
                    if (listCallback != null) {
                        listCallback.onProgress(total, downSuccess, downFail);
                    }
                    continue;
                }

                String fileName = InnerUtil.md5(task.url);
                String suffix = TextUtils.isEmpty(task.suffix) ? FileUtil.getFileSuffix(task.url) : task.suffix;

                File file = new File(dir, fileName + suffix);
                task.fileName = fileName;
                task.localFile = file;

                FileDownInfoEntity entity = DaoManagerProxy.getInstance().getFileDownDao().queryInfoByFileName(fileName);
                if (entity != null && file.exists() && file.length() == entity.getContentLength()) {
                    NzLog.d("文件已经存在: " + file.getAbsolutePath());

                    downSuccess++;
                    if (listCallback != null) {
                        listCallback.onProgress(total, downSuccess, downFail);
                    }
                    if (listCallback != null) {
                        listCallback.onDownSuccess(task);
                    }
                    continue;
                }

                ResponseResult<Boolean> result = downloadFileSync(task, callback);
                if (result.getCode() == NzResponseCode.NZ_SUCCESS && result.getData() == Boolean.TRUE) {
                    // 入库
                    if (entity != null) {
                        entity.setContentLength(task.contentLength);
                        fileDao.update(entity);
                    } else {
                        entity = new FileDownInfoEntity();
                        entity.setType(task.type);
                        entity.setFileName(fileName);
                        entity.setUrl(task.url);
                        entity.setContentLength(task.contentLength);
                        entity.setLocalPath(file.getAbsolutePath());
                        fileDao.insert(entity);
                    }
                    // 通知成功
                    if (listCallback != null) {
                        listCallback.onDownSuccess(task);
                    }
                    downSuccess++;
                } else {
                    downFail++;
                }

                if (listCallback != null) {
                    listCallback.onProgress(total, downSuccess, downFail);
                }
            }

            if (listCallback != null) {
                listCallback.onComplete();
            }
        });
    }

    private ResponseResult<Boolean> downloadFileSync(DownloadFileTask task, FileDownCallback callback) {
        return RxCallbackScheduler.scheduleResultSync(downloadFileRepository.downloadFile(task, callback));
    }

    // 根据Url删除
    @Override
    public void clearByUrls(List<String> urls) {
        RxCallbackScheduler.scheduleSync(downloadFileRepository.clearByUrls(urls));
    }

    // 清空保存的人脸文件
    @Override
    public void clearAllFace() {
        //  清空学生人脸
        clearStudentFace();
        //  清空教师人脸
        clearTeacherFace();
    }

    //  清空学生人脸
    @Override
    public void clearStudentFace() {
        RxCallbackScheduler.scheduleSync(downloadFileRepository.clearStudentFace());
    }

    //  清空教师人脸
    @Override
    public void clearTeacherFace() {
        RxCallbackScheduler.scheduleSync(downloadFileRepository.clearTeacherFace());
    }
}
