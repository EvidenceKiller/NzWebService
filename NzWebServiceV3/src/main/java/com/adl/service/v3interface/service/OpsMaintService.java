package com.adl.service.v3interface.service;

import com.adl.service.v3interface.request.DeviceQrcodeRequest;
import com.adl.service.v3interface.request.LogAddBatchRequest;
import com.adl.service.v3interface.request.SoftwareReportRequest;
import com.adl.service.v3interface.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.v3interface.request.UploadDeviceInfoRequest;
import com.adl.service.v3interface.request.UploadUpgradeLogRequest;
import com.adl.service.v3interface.response.UpgradePlanByDeviceData;
import com.example.rxsdk.response.BaseResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface OpsMaintService {
    /**
     * 上报设备信息(昵称及Mac)
     */
    @POST("tis/device/ops/info/upload/deviceInfo")
    Single<BaseResponse<Boolean>> uploadDeviceInfo(@Body UploadDeviceInfoRequest request);

    /**
     * 设备OTA（上报升级日志）
     */
    @POST("tis/device/ops/info/upgradePlan/uploadUpgradeLog")
    Single<BaseResponse<Object>> uploadUpgradeLog(@Body UploadUpgradeLogRequest request);

    /**
     * 设备OTA（获取升级计划）
     */
    @POST("tis/device/ops/info/upgradePlan/getUpgradePlanByDevice")
    Single<BaseResponse<UpgradePlanByDeviceData>> getUpgradePlanByDevice();

    /**
     * 设备OTA（无登录状态获取升级计划）
     */
    @POST("tis/device/ops/info/upgradePlan/getUpgradePlanByDeviceWithOutLogin")
    Single<BaseResponse<String>> getUpgradePlanByDeviceWithOutLogin(@Body UpgradePlanByDeviceWithOutLoginRequest request);

    /**
     * 设备状态上报（软件版本）
     */
    @POST("tis/device/ops/info/software/report")
    Single<BaseResponse<Boolean>> softwareReport(@Body SoftwareReportRequest request);

    /**
     * 设备二维码
     */
    @POST("tis/device/ops/info/device/qrcode")
    Single<BaseResponse<String>> getDeviceQrcode(@Body DeviceQrcodeRequest request);

    /**
     * 设备日志上报
     */
    @POST("tis/device/ops/info/common/log/addBatch")
    Single<BaseResponse<Object>> logAddBatch(@Body LogAddBatchRequest request);
}
