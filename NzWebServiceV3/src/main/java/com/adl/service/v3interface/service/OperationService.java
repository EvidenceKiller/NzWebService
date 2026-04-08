package com.adl.service.v3interface.service;

import com.adl.service.v3interface.request.BannerDetailListRequest;
import com.adl.service.v3interface.request.DeviceFocusListRequest;
import com.adl.service.v3interface.request.DictMapRequest;
import com.adl.service.v3interface.request.SceneListRequest;
import com.adl.service.v3interface.request.SportSkuDetailRequest;
import com.adl.service.v3interface.request.SportSkuPageRequest;
import com.adl.service.v3interface.request.UploadDeviceNameRequest;
import com.adl.service.v3interface.request.WikiDetailRequest;
import com.adl.service.v3interface.request.WikiPageRequest;
import com.adl.service.v3interface.request.WikiTypePageRequest;
import com.adl.service.v3interface.response.BannerDetailListData;
import com.adl.service.v3interface.response.DeviceFocusData;
import com.adl.service.v3interface.response.DictMapData;
import com.adl.service.v3interface.response.SceneData;
import com.adl.service.v3interface.response.SportSkuDetailData;
import com.adl.service.v3interface.response.SportSkuPageData;
import com.adl.service.v3interface.response.WikiDetailData;
import com.adl.service.v3interface.response.WikiPageData;
import com.example.rxsdk.response.BaseResponse;

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
    Single<BaseResponse<List<BannerDetailListData>>> getDetailList(@Body BannerDetailListRequest request);

    /**
     * 获取项目库列表
     */
    @POST("tis/device/oper/sku/getSportSkuList")
    Single<BaseResponse<SportSkuPageData>> getSportSkuPage(@Body SportSkuPageRequest request);

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
     * 获取百科分类列表
     */
    @POST("tis/device/oper/wiki/type/getWikiTypeList")
    Single<BaseResponse<WikiPageData>> getWikiTypePage(@Body WikiTypePageRequest request);

    /**
     * 获取百科列表
     */
    @POST("tis/device/oper/wiki/getWikiList")
    Single<BaseResponse<WikiPageData>> getWikiPage(@Body WikiPageRequest request);

    /**
     * 获取运动百科详情
     */
    @POST("tis/device/oper/wiki/getWikiDetail")
    Single<BaseResponse<WikiDetailData>> getWikiDetail(@Body WikiDetailRequest request);

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
