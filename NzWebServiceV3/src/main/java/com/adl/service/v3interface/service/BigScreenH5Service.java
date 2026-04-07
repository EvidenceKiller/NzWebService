package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.request.SportDetailListRequest;
import com.example.rxsdk.v3interface.response.SportDetailListData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/** Auto-generated from v3interface HTML. */
public interface BigScreenH5Service {
    /** 历史记录 — 来源:dev */
    @POST("tis/device/h5/org/sunshineRunning/sportDetailList")
    Single<BaseResponse<SportDetailListData>> getSportDetailList(@Body SportDetailListRequest request);
}
