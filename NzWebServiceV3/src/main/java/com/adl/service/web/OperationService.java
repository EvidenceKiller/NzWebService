package com.adl.service.web;

import com.adl.service.http.request.BannerDetailListRequest;
import com.adl.service.http.request.DeviceFocusListRequest;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuDetailRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.http.request.UploadDeviceNameRequest;
import com.adl.service.data.BannerDetailData;
import com.adl.service.data.BasePageData;
import com.adl.service.data.BaseResponse;
import com.adl.service.data.DeviceFocusData;
import com.adl.service.data.DictMapData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuDetailData;
import com.adl.service.data.SportSkuData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface OperationService {
    /**
     * 获取Banner详情列表
     */
    @POST("tis/device/oper/banner/getDetailList")
    Single<BaseResponse<List<BannerDetailData>>> getBannerDetailList(@Body BannerDetailListRequest request);

    /**
     * 获取项目库列表
     */
    @POST("tis/device/oper/sku/getSportSkuList")
    Single<BaseResponse<BasePageData<SportSkuData>>> getSportSkuPage(@Body SportSkuPageRequest request);

    /**
     * 获取项目详情
     */
    @POST("tis/device/oper/sku/getSportSkuDetail")
    Single<BaseResponse<SportSkuDetailData>> getSportSkuDetail(@Body SportSkuDetailRequest request);

    /**
     * 获取模板内容
     */
    @POST("tis/device/oper/sku/getDictMap")
    Single<BaseResponse<List<DictMapData>>> getDictMap(@Body DictMapRequest request);

    /**
     * 获取场景列表
     */
    @POST("tis/device/oper/scene/getSceneList")
    Single<BaseResponse<List<SceneData>>> getSceneList(@Body SceneListRequest request);

    /**
     * 修改设备名称
     */
    @POST("tis/device/oper/device/upload/deviceName")
    Single<BaseResponse<Boolean>> uploadDeviceName(@Body UploadDeviceNameRequest request);

    /**
     * 获取设备专注信息列表
     */
    @POST("tis/device/oper/device/getDeviceFocusList")
    Single<BaseResponse<List<DeviceFocusData>>> getDeviceFocusList(@Body DeviceFocusListRequest request);
}
