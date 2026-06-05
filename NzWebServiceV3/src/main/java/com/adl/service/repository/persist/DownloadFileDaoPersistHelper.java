package com.adl.service.repository.persist;

import android.text.TextUtils;

import com.adl.service.AdlService;
import com.adl.service.caller.impl.DownloadFileCallerImpl;
import com.adl.service.common.IDefine;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.utils.FileUtil;
import com.adl.service.utils.InnerUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class DownloadFileDaoPersistHelper {

    public DownloadFileDaoPersistHelper() {
    }

    public Function<Void, Single<Boolean>> createClearByUrlsFunc(List<String> urls) {
        return (v) -> {
            if (urls == null || urls.isEmpty()) return Single.just(Boolean.FALSE);

            List<String> fileNames = new ArrayList<>();
            for (String url : urls) {
                if (TextUtils.isEmpty(url)) continue;
                fileNames.add(InnerUtil.md5(InnerUtil.formatFaceUrl(url)));
            }

            if (fileNames.isEmpty()) return Single.just(Boolean.FALSE);
            DaoManagerProxy.getInstance().getFileDownDao().clearByFileNames(fileNames);
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<Boolean>> createClearStudentFaceFunc() {
        return (v) -> {
            //  清空数据库
            DaoManagerProxy.getInstance().getFileDownDao().clearAllByType(IDefine.FileDownloadTypeStudentHead);
            //  清空文件
            File dataDir = AdlService.getService().getContext().getDataDir();
            //  清空人脸文件
            File studentFaceDir = new File(dataDir, DownloadFileCallerImpl.STUDENT_FACE_DIR_NAME);
            FileUtil.deleteFileDir(studentFaceDir);
            return Single.just(Boolean.TRUE);
        };
    }

    public Function<Void, Single<Boolean>> createClearTeacherFaceFunc() {
        return (v) -> {
            //  清空数据库
            DaoManagerProxy.getInstance().getFileDownDao().clearAllByType(IDefine.FileDownloadTypeTeacherHead);
            //  清空文件
            File dataDir = AdlService.getService().getContext().getDataDir();
            //  清空人脸文件
            File teacherFaceDir = new File(dataDir, DownloadFileCallerImpl.TEACHER_FACE_DIR_NAME);
            FileUtil.deleteFileDir(teacherFaceDir);
            return Single.just(Boolean.TRUE);
        };
    }
}
