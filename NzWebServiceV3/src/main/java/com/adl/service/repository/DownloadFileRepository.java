package com.adl.service.repository;

import com.adl.service.callback.ResponseResult;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.repository.fetch.DownloadFileFetchHelper;
import com.adl.service.repository.persist.DownloadFilePersistHelper;
import com.adl.service.callback.DownloadFileTask;
import com.adl.service.callback.FileDownCallback;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;
import okhttp3.ResponseBody;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class DownloadFileRepository {
    private final DownloadFileFetchHelper fetchHelper = new DownloadFileFetchHelper();
    private final DownloadFilePersistHelper persistHelper = new DownloadFilePersistHelper();

    private static volatile DownloadFileRepository instance;

    private DownloadFileRepository() {
    }

    public static DownloadFileRepository getInstance() {
        if (instance == null) {
            synchronized (DownloadFileRepository.class) {
                if (instance == null) {
                    instance = new DownloadFileRepository();
                }
            }
        }
        return instance;
    }

    public Single<ResponseResult<Boolean>> downloadFile(DownloadFileTask task, FileDownCallback callback) {
        return BaseRepositoryUtil.repositoryAsSingle(EmptyRequest.builder().build(), fetchHelper.createFetchDownloadFileFunc(task, callback));
    }

    public Single<Boolean> clearByUrls(List<String> urls) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearByUrlsFunc(urls));
    }

    public Single<Boolean> clearStudentFace() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearStudentFaceFunc());
    }

    public Single<Boolean> clearTeacherFace() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearTeacherFaceFunc());
    }

}
