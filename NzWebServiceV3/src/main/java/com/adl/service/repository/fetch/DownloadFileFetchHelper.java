package com.adl.service.repository.fetch;

import com.adl.service.callback.FileDownCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.TimeStamp;
import com.adl.service.exception.NzDownloadFileException;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.callback.DownloadFileTask;
import com.adl.service.log.NzLog;
import com.adl.service.utils.CommonUtil;
import com.adl.service.utils.InnerUtil;
import com.adl.service.web.DownloadFileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public final class DownloadFileFetchHelper {

    private final DownloadFileService downloadFileService;

    public DownloadFileFetchHelper() {
        this.downloadFileService = RetrofitManager.getInstance().create(DownloadFileService.class);
    }

    public Function<EmptyRequest, Single<ResponseResult<Boolean>>> createFetchDownloadFileFunc(DownloadFileTask task, FileDownCallback callback) {
        return (request) -> {
            Single<ResponseResult<ResponseBody>> responseBody = BaseFetchUtil.scheduleDownloadFileResponse(downloadFileService.downloadFile(task.url));
            return responseBody.flatMap(responseResult -> {
                if (responseResult == null) {
                    return Single.error(new NzDownloadFileException(NzResponseCode.NZ_DOWNLOAD_FILE_ERROR, "response result is null"));
                }
                ResponseBody respBody = responseResult.getData();
                MediaType mediaType = respBody.contentType();
                if (mediaType == null) {
                    NzLog.d("文件下载失败：mediaType is null");
                    return Single.error(new NzDownloadFileException(NzResponseCode.NZ_DOWNLOAD_FILE_ERROR, "media type is null"));
                }

                long length = respBody.contentLength();
                InputStream input = respBody.byteStream();

                File file = task.localFile;
                task.contentLength = length;

                // 文件是否存在
                if (file.exists()) {
                    file.delete();
                }

                long totalRead = 0L;
                try (OutputStream out = new FileOutputStream(file)) {
                    int read = -1;
                    byte[] buffer = new byte[64 * 1024];
                    while ((read = input.read(buffer)) > 0) {
                        out.write(buffer, 0, read);
                        out.flush();
                        totalRead += read;
                        if (callback != null) {
                            callback.onProgress(length, totalRead);
                        }
                    }
                } catch (FileNotFoundException e) {
                    NzLog.d("文件下载失败：FileNotFoundException : " + e.getMessage());
                } catch (IOException e) {
                    NzLog.d("文件下载失败：IOException : " + e.getMessage());
                }
                InnerUtil.close(input);
                closeResponseBody(respBody);

                // 是否读完
                if (totalRead != length) {
                    file.delete();
                    NzLog.d("文件下载失败：长度不一致 : totalRead : " + totalRead + " length : " + length);
                    if (callback != null) {
                        callback.onError("文件下载失败");
                    }
                    return Single.error(new NzDownloadFileException(NzResponseCode.NZ_DOWNLOAD_FILE_ERROR, "文件下载失败：长度不一致 : totalRead : " + totalRead + " length : " + length));
                }

                NzLog.d("文件下载完成");

                return Single.just(CommonUtil.createSuccessResponseResult(Boolean.TRUE));
            });
        };
    }

    private static void closeResponseBody(ResponseBody body) {
        try {
            if (body != null) {
                body.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
