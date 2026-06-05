package com.adl.service.repository.fetch;

import com.adl.service.http.request.EmptyRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.callback.DownloadFileTask;
import com.adl.service.web.DownloadFileService;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import okhttp3.ResponseBody;

public final class DownloadFileFetchHelper {

    private final DownloadFileService downloadFileService;

    public DownloadFileFetchHelper() {
        this.downloadFileService = RetrofitManager.getInstance().create(DownloadFileService.class);
    }

    public Function<EmptyRequest, Single<ResponseBody>> createFetchDownloadFileFunc(DownloadFileTask task) {
        return (request) -> BaseFetchUtil.scheduleDownloadFileResponse(downloadFileService.downloadFile(task.url));
    }
}
