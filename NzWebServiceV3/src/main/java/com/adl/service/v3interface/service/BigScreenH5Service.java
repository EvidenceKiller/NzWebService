package com.adl.service.v3interface.service;


import com.adl.service.v3interface.request.SportDetailListRequest;
import com.adl.service.v3interface.response.SportDetailListData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Name : BigScreenH5Service
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 提供Retrofit接口调用能力
 */
public interface BigScreenH5Service {
    /** 历史记录 */
    @POST("tis/device/h5/org/sunshineRunning/sportDetailList")
    Single<BaseResponse<SportDetailListData>> getSportDetailList(@Body SportDetailListRequest request);
}
