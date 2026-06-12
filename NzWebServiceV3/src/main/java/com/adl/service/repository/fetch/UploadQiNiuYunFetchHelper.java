package com.adl.service.repository.fetch;

import com.adl.service.callback.ResponseResult;
import com.adl.service.http.request.QiNiuYunTokenRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.UploadQiNiuYunService;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class UploadQiNiuYunFetchHelper {

    private final UploadQiNiuYunService uploadQiNiuYunService;

    public UploadQiNiuYunFetchHelper() {
        this.uploadQiNiuYunService = RetrofitManager.getInstance().create(UploadQiNiuYunService.class);
    }

    public Function<QiNiuYunTokenRequest, Single<ResponseResult<String>>> createGetQiNiuYunTokenFunc(String url) {
        return (request) -> BaseFetchUtil.scheduleResponse(uploadQiNiuYunService.getQiNiuYunToken(url, request));
    }

}
