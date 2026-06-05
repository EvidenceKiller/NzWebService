package com.adl.service.repository;

import com.adl.service.http.request.EmptyRequest;
import com.adl.service.repository.fetch.DownloadFileFetchHelper;
import com.adl.service.repository.persist.DownloadFilePersistHelper;
import com.adl.service.callback.DownloadFileTask;
import com.adl.service.callback.FileDownCallback;

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

    public Single<Boolean> downloadFile(DownloadFileTask task, FileDownCallback callback) {
        Single<ResponseBody> result = BaseRepositoryUtil.repositoryAsSingle(EmptyRequest.builder().build(), fetchHelper.createFetchDownloadFileFunc(task),
                persistHelper.createPersistDownloadFileFunc(task, callback));
        if (result == null) {
            return Single.just(false);
        } else {
            return Single.just(true);
        }
    }

}
