package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.DeviceQrcodeRequest;
import com.adl.service.web.request.LogAddBatchRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.SoftwareReportRequest;
import com.adl.service.web.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.web.request.UploadDeviceInfoRequest;
import com.adl.service.web.request.UploadUpgradeLogRequest;
import com.adl.service.web.response.UpgradePlanByDeviceData;

/**
 * OpsMaintCaller。
 */
public interface OpsMaintCaller {

    long uploadDeviceInfoAsync(RequestScope scope, UploadDeviceInfoRequest request, RequestCallback<Boolean> callback);

    Boolean uploadDeviceInfoSync(UploadDeviceInfoRequest request) throws NzBaseException;

    long uploadUpgradeLogAsync(RequestScope scope, UploadUpgradeLogRequest request, RequestCallback<Object> callback);

    Object uploadUpgradeLogSync(UploadUpgradeLogRequest request) throws NzBaseException;

    long getUpgradePlanByDeviceAsync(RequestScope scope, RequestCallback<UpgradePlanByDeviceData> callback);

    UpgradePlanByDeviceData getUpgradePlanByDeviceSync() throws NzBaseException;

    long getUpgradePlanByDeviceWithOutLoginAsync(RequestScope scope, UpgradePlanByDeviceWithOutLoginRequest request, RequestCallback<String> callback);

    String getUpgradePlanByDeviceWithOutLoginSync(UpgradePlanByDeviceWithOutLoginRequest request) throws NzBaseException;

    long softwareReportAsync(RequestScope scope, SoftwareReportRequest request, RequestCallback<Boolean> callback);

    Boolean softwareReportSync(SoftwareReportRequest request) throws NzBaseException;

    long getDeviceQrcodeAsync(RequestScope scope, DeviceQrcodeRequest request, RequestCallback<String> callback);

    String getDeviceQrcodeSync(DeviceQrcodeRequest request) throws NzBaseException;

    long logAddBatchAsync(RequestScope scope, LogAddBatchRequest request, RequestCallback<Object> callback);

    Object logAddBatchSync(LogAddBatchRequest request) throws NzBaseException;

}
