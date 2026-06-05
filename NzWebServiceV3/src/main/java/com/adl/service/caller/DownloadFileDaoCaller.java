package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.RequestScope;

import java.util.List;

/**
 * UploadQiNiuYunCaller。
 */
public interface DownloadFileDaoCaller {
    // 根据Url删除
    void clearByUrls(List<String> urls);

    // 清空保存的人脸文件
    void clearAllFace();

    //  清空学生人脸
    void clearStudentFace();

    //  清空教师人脸
    void clearTeacherFace();
}
