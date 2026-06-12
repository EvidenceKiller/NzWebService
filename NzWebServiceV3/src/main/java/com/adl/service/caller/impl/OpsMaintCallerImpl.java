package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.caller.OpsMaintCaller;
import com.adl.service.data.UpgradePlanByDeviceData;
import com.adl.service.http.request.DeviceQrcodeRequest;
import com.adl.service.http.request.LogAddBatchRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.SoftwareReportRequest;
import com.adl.service.http.request.UpgradePlanByDeviceRequest;
import com.adl.service.http.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.http.request.UploadDeviceInfoRequest;
import com.adl.service.http.request.UploadUpgradeLogRequest;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.OpsMaintRepository;

import java.util.List;

/**
 * OpsMaintCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class OpsMaintCallerImpl implements OpsMaintCaller {

    private final OpsMaintRepository opsMaintRepository;

    public OpsMaintCallerImpl() {
        this.opsMaintRepository = OpsMaintRepository.getInstance();
    }

    @Override
    public long uploadDeviceInfoAsync(RequestScope scope, UploadDeviceInfoRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, opsMaintRepository.uploadDeviceInfo(request), callback);
    }

    @Override
    public ResponseResult<Boolean> uploadDeviceInfoSync(UploadDeviceInfoRequest request) {
        return RxCallbackScheduler.scheduleResultSync(opsMaintRepository.uploadDeviceInfo(request));
    }

    @Override
    public long uploadUpgradeLogAsync(RequestScope scope, UploadUpgradeLogRequest request, RequestCallback<Object> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, opsMaintRepository.uploadUpgradeLog(request), callback);
    }

    @Override
    public ResponseResult<Object> uploadUpgradeLogSync(UploadUpgradeLogRequest request) {
        return RxCallbackScheduler.scheduleResultSync(opsMaintRepository.uploadUpgradeLog(request));
    }

    @Override
    public long getUpgradePlanByDeviceAsync(RequestScope scope, UpgradePlanByDeviceRequest request, RequestCallback<List<UpgradePlanByDeviceData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, opsMaintRepository.getUpgradePlanByDevice(request), callback);
    }

    @Override
    public ResponseResult<List<UpgradePlanByDeviceData>> getUpgradePlanByDeviceSync(UpgradePlanByDeviceRequest request) {
        return RxCallbackScheduler.scheduleResultSync(opsMaintRepository.getUpgradePlanByDevice(request));
    }

    @Override
    public long getUpgradePlanByDeviceWithOutLoginAsync(RequestScope scope, UpgradePlanByDeviceWithOutLoginRequest request, RequestCallback<String> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, opsMaintRepository.getUpgradePlanByDeviceWithOutLogin(request), callback);
    }

    @Override
    public ResponseResult<String> getUpgradePlanByDeviceWithOutLoginSync(UpgradePlanByDeviceWithOutLoginRequest request) {
        return RxCallbackScheduler.scheduleResultSync(opsMaintRepository.getUpgradePlanByDeviceWithOutLogin(request));
    }

    @Override
    public long softwareReportAsync(RequestScope scope, SoftwareReportRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, opsMaintRepository.softwareReport(request), callback);
    }

    @Override
    public ResponseResult<Boolean> softwareReportSync(SoftwareReportRequest request) {
        return RxCallbackScheduler.scheduleResultSync(opsMaintRepository.softwareReport(request));
    }

    @Override
    public long getDeviceQrcodeAsync(RequestScope scope, DeviceQrcodeRequest request, RequestCallback<String> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, opsMaintRepository.getDeviceQrcode(request), callback);
    }

    @Override
    public ResponseResult<String> getDeviceQrcodeSync(DeviceQrcodeRequest request) {
        return RxCallbackScheduler.scheduleResultSync(opsMaintRepository.getDeviceQrcode(request));
    }

    @Override
    public long logAddBatchAsync(RequestScope scope, LogAddBatchRequest request, RequestCallback<Object> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, opsMaintRepository.logAddBatch(request), callback);
    }

    @Override
    public ResponseResult<Object> logAddBatchSync(LogAddBatchRequest request) {
        return RxCallbackScheduler.scheduleResultSync(opsMaintRepository.logAddBatch(request));
    }
}