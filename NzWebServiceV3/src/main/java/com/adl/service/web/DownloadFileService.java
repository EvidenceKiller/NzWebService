package com.adl.service.web;

import io.reactivex.rxjava3.core.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Retrofit API（v3new 生成）
 */
public interface DownloadFileService {
    @Streaming
    @GET
    Single<Response<ResponseBody>> downloadFile(@Url String url);
}
