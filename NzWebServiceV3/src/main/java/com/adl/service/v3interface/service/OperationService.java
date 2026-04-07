package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.request.DeviceNameRequest;
import com.example.rxsdk.v3interface.request.GetDetailListRequest;
import com.example.rxsdk.v3interface.request.GetDeviceFocusListRequest;
import com.example.rxsdk.v3interface.request.GetDictMapRequest;
import com.example.rxsdk.v3interface.request.GetSceneListRequest;
import com.example.rxsdk.v3interface.request.GetSportSkuDetailRequest;
import com.example.rxsdk.v3interface.request.GetSportSkuListRequest;
import com.example.rxsdk.v3interface.request.GetWikiDetailRequest;
import com.example.rxsdk.v3interface.request.GetWikiListRequest;
import com.example.rxsdk.v3interface.request.GetWikiTypeListRequest;
import com.example.rxsdk.v3interface.response.DeviceNameData;
import com.example.rxsdk.v3interface.response.GetDetailListData;
import com.example.rxsdk.v3interface.response.GetDeviceFocusListData;
import com.example.rxsdk.v3interface.response.GetDictMapData;
import com.example.rxsdk.v3interface.response.GetSceneListData;
import com.example.rxsdk.v3interface.response.GetSportSkuDetailData;
import com.example.rxsdk.v3interface.response.GetSportSkuListData;
import com.example.rxsdk.v3interface.response.GetWikiDetailData;
import com.example.rxsdk.v3interface.response.GetWikiListData;
import com.example.rxsdk.v3interface.response.GetWikiTypeListData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/** Auto-generated from v3interface HTML. */
public interface OperationService {
    /** 获取Banner详情列表 — 来源:dev */
    @POST("tis/device/oper/banner/getDetailList")
    Single<BaseResponse<List<GetDetailListData>>> getGetDetailList(@Body GetDetailListRequest request);

    /** 获取项目库列表 — 来源:dev */
    @POST("tis/device/oper/sku/getSportSkuList")
    Single<BaseResponse<GetSportSkuListData>> getGetSportSkuList(@Body GetSportSkuListRequest request);

    /** 获取项目详情 — 来源:dev */
    @POST("tis/device/oper/sku/getSportSkuDetail")
    Single<BaseResponse<GetSportSkuDetailData>> getGetSportSkuDetail(@Body GetSportSkuDetailRequest request);

    /** 获取模板内容 — 来源:dev */
    @POST("tis/device/oper/sku/getDictMap")
    Single<BaseResponse<List<GetDictMapData>>> getGetDictMap(@Body GetDictMapRequest request);

    /** 获取场景列表 — 来源:dev */
    @POST("tis/device/oper/scene/getSceneList")
    Single<BaseResponse<List<GetSceneListData>>> getGetSceneList(@Body GetSceneListRequest request);

    /** 获取百科分类列表 — 来源:dev */
    @POST("tis/device/oper/wiki/type/getWikiTypeList")
    Single<BaseResponse<GetWikiTypeListData>> getGetWikiTypeList(@Body GetWikiTypeListRequest request);

    /** 获取百科列表 — 来源:dev */
    @POST("tis/device/oper/wiki/getWikiList")
    Single<BaseResponse<GetWikiListData>> getGetWikiList(@Body GetWikiListRequest request);

    /**
     * 获取运动百科详情 — 来源:dev
     * Path wikiId: 百科id
     */
    @POST("tis/device/oper/wiki/getWikiDetail/{wikiId}")
    Single<BaseResponse<GetWikiDetailData>> getGetWikiDetail(@Path("wikiId") String wikiId);

    /** 获取运动百科详情 — 来源:dev */
    @POST("tis/device/oper/wiki/getWikiDetail")
    Single<BaseResponse<GetWikiDetailData>> getGetWikiDetail(@Body GetWikiDetailRequest request);

    /** 修改设备名称 — 来源:dev */
    @POST("tis/device/oper/device/upload/deviceName")
    Single<BaseResponse<DeviceNameData>> getDeviceName(@Body DeviceNameRequest request);

    /** 获取设备专注信息列表 — 来源:dev */
    @POST("tis/device/oper/device/getDeviceFocusList")
    Single<BaseResponse<List<GetDeviceFocusListData>>> getGetDeviceFocusList(@Body GetDeviceFocusListRequest request);
}
