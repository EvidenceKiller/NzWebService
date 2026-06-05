package com.adl.service.caller.impl;

import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.DownloadFileDaoCaller;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.RequestScope;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.DownloadFileDaoRepository;

import java.util.List;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 文件下载管理
 * 1. 学生人脸图片下载
 * 2. 视频下载
 * 3. 图片下载
 */
public final class DownloadFileDaoCallerImpl implements DownloadFileDaoCaller {

    private final DownloadFileDaoRepository downloadFileDaoRepository;

    public DownloadFileDaoCallerImpl() {
        downloadFileDaoRepository = DownloadFileDaoRepository.getInstance();
    }

    // 根据Url删除
    @Override
    public void clearByUrls(List<String> urls) {
        RxCallbackScheduler.blockingGetNoThrow(downloadFileDaoRepository.clearByUrls(urls));
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
        RxCallbackScheduler.blockingGetNoThrow(downloadFileDaoRepository.clearStudentFace());
    }

    //  清空教师人脸
    @Override
    public void clearTeacherFace() {
        RxCallbackScheduler.blockingGetNoThrow(downloadFileDaoRepository.clearTeacherFace());
    }

}
