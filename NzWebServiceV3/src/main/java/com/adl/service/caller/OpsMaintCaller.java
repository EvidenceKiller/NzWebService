package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.data.UpgradePlanByDeviceData;
import com.adl.service.http.request.DeviceQrcodeRequest;
import com.adl.service.http.request.LogAddBatchRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.SoftwareReportRequest;
import com.adl.service.http.request.UpgradePlanByDeviceRequest;
import com.adl.service.http.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.http.request.UploadDeviceInfoRequest;
import com.adl.service.http.request.UploadUpgradeLogRequest;

import java.util.List;

/**
 * OpsMaintCaller。
 */
public interface OpsMaintCaller {

    /**
     * 上报设备信息(昵称及Mac)
     * <p>异步调用。</p>
     */
    long uploadDeviceInfoAsync(RequestScope scope, UploadDeviceInfoRequest request, RequestCallback<Boolean> callback);

    /**
     * 上报设备信息(昵称及Mac)
     * <p>同步调用。</p>
     */
    ResponseResult<Boolean> uploadDeviceInfoSync(UploadDeviceInfoRequest request);

    /**
     * 设备OTA（上报升级日志）
     * <p>异步调用。</p>
     */
    long uploadUpgradeLogAsync(RequestScope scope, UploadUpgradeLogRequest request, RequestCallback<Object> callback);

    /**
     * 设备OTA（上报升级日志）
     * <p>同步调用。</p>
     */
    ResponseResult<Object> uploadUpgradeLogSync(UploadUpgradeLogRequest request);

    /**
     * 设备OTA（获取升级计划）
     * <p>异步调用。</p>
     */
    long getUpgradePlanByDeviceAsync(RequestScope scope, UpgradePlanByDeviceRequest request, RequestCallback<List<UpgradePlanByDeviceData>> callback);

    /**
     * 设备OTA（获取升级计划）
     * <p>同步调用。</p>
     */
    ResponseResult<List<UpgradePlanByDeviceData>> getUpgradePlanByDeviceSync(UpgradePlanByDeviceRequest request);

    /**
     * 设备OTA（无登录状态获取升级计划）
     * <p>异步调用。</p>
     */
    long getUpgradePlanByDeviceWithOutLoginAsync(RequestScope scope, UpgradePlanByDeviceWithOutLoginRequest request, RequestCallback<String> callback);

    /**
     * 设备OTA（无登录状态获取升级计划）
     * <p>同步调用。</p>
     */
    ResponseResult<String> getUpgradePlanByDeviceWithOutLoginSync(UpgradePlanByDeviceWithOutLoginRequest request);

    /**
     * 设备状态上报（软件版本）
     * <p>异步调用。</p>
     */
    long softwareReportAsync(RequestScope scope, SoftwareReportRequest request, RequestCallback<Boolean> callback);

    /**
     * 设备状态上报（软件版本）
     * <p>同步调用。</p>
     */
    ResponseResult<Boolean> softwareReportSync(SoftwareReportRequest request);

    /**
     * 设备二维码
     * <p>异步调用。</p>
     */
    long getDeviceQrcodeAsync(RequestScope scope, DeviceQrcodeRequest request, RequestCallback<String> callback);

    /**
     * 设备二维码
     * <p>同步调用。</p>
     */
    ResponseResult<String> getDeviceQrcodeSync(DeviceQrcodeRequest request);

    /**
     * 设备日志上报
     * <p>异步调用。</p>
     */
    long logAddBatchAsync(RequestScope scope, LogAddBatchRequest request, RequestCallback<Object> callback);

    /**
     * 设备日志上报
     * <p>同步调用。</p>
     */
    ResponseResult<Object> logAddBatchSync(LogAddBatchRequest request);

}
