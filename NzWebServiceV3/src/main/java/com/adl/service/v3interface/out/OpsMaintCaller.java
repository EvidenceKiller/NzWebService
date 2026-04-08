package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.request.DeviceQrcodeRequest;
import com.adl.service.v3interface.request.LogAddBatchRequest;
import com.adl.service.v3interface.request.SoftwareReportRequest;
import com.adl.service.v3interface.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.v3interface.request.UploadDeviceInfoRequest;
import com.adl.service.v3interface.request.UploadUpgradeLogRequest;
import com.adl.service.v3interface.response.UpgradePlanByDeviceData;

/**
 * OpsMaintCaller。
 */
public interface OpsMaintCaller {

    long uploadDeviceInfoAsync(RequestScope scope, UploadDeviceInfoRequest request, RequestCallback<Boolean> callback);

    Boolean uploadDeviceInfoSync(UploadDeviceInfoRequest request);

    long uploadUpgradeLogAsync(RequestScope scope, UploadUpgradeLogRequest request, RequestCallback<Object> callback);

    Object uploadUpgradeLogSync(UploadUpgradeLogRequest request);

    long getUpgradePlanByDeviceAsync(RequestScope scope, RequestCallback<UpgradePlanByDeviceData> callback);

    UpgradePlanByDeviceData getUpgradePlanByDeviceSync();

    long getUpgradePlanByDeviceWithOutLoginAsync(RequestScope scope, UpgradePlanByDeviceWithOutLoginRequest request, RequestCallback<String> callback);

    String getUpgradePlanByDeviceWithOutLoginSync(UpgradePlanByDeviceWithOutLoginRequest request);

    long softwareReportAsync(RequestScope scope, SoftwareReportRequest request, RequestCallback<Boolean> callback);

    Boolean softwareReportSync(SoftwareReportRequest request);

    long getDeviceQrcodeAsync(RequestScope scope, DeviceQrcodeRequest request, RequestCallback<String> callback);

    String getDeviceQrcodeSync(DeviceQrcodeRequest request);

    long logAddBatchAsync(RequestScope scope, LogAddBatchRequest request, RequestCallback<Object> callback);

    Object logAddBatchSync(LogAddBatchRequest request);

}
