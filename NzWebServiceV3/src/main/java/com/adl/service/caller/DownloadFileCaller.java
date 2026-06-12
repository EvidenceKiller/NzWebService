package com.adl.service.caller;

import com.adl.service.callback.FileListDownCallback;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;

import java.util.List;

/**
 * UploadQiNiuYunCaller。
 */
public interface DownloadFileCaller {
    void setMultiThread(int threadNum);

    // 下载视频
    void downVideo(List<String> list, FileListDownCallback callback);

    // 下载图片
    void downImage(List<String> list, FileListDownCallback callback);

    // 下载文件
    void downFile(List<String> list, String suffix, FileListDownCallback callback);

    // 下载学生人脸信息
    void downStudentFaceImage(List<StudentData> list, FileListDownCallback callback);

    // 下载教师人脸信息
    void downTeacherFaceImage(List<TeacherData> list, FileListDownCallback callback);

    // 下载学生人脸信息
    void downStudentThumbnailFaceImage(Boolean useThumbnail, List<StudentData> list, FileListDownCallback callback);

    // 根据Url删除
    void clearByUrls(List<String> urls);

    // 清空保存的人脸文件
    void clearAllFace();

    //  清空学生人脸
    void clearStudentFace();

    //  清空教师人脸
    void clearTeacherFace();
}
