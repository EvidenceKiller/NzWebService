package com.adl.service.web;

import com.adl.service.data.BaseResponse;
import com.adl.service.http.request.QiNiuYunTokenRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Retrofit API（v3new 生成）
 */
public interface UploadQiNiuYunService {

    /**
     * 获取七牛云Token
     */
    @POST
    Single<BaseResponse<String>> getQiNiuYunToken(@Url String url, @Body QiNiuYunTokenRequest request);
}
