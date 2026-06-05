package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.OpsMaintCaller;
import com.adl.service.data.UpgradePlanByDeviceData;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.DeviceQrcodeRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.LogAddBatchRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.SoftwareReportRequest;
import com.adl.service.http.request.UpgradePlanByDeviceRequest;
import com.adl.service.http.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.http.request.UploadDeviceInfoRequest;
import com.adl.service.http.request.UploadUpgradeLogRequest;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.OpsMaintRepository;
import com.adl.service.web.OpsMaintService;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

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
        return RxCallbackScheduler.schedule(scope, opsMaintRepository.uploadDeviceInfo(request), callback);
    }

    @Override
    public Boolean uploadDeviceInfoSync(UploadDeviceInfoRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(opsMaintRepository.uploadDeviceInfo(request), Boolean.class);
    }

    @Override
    public long uploadUpgradeLogAsync(RequestScope scope, UploadUpgradeLogRequest request, RequestCallback<Object> callback) {
        return RxCallbackScheduler.schedule(scope, opsMaintRepository.uploadUpgradeLog(request), callback);
    }

    @Override
    public Object uploadUpgradeLogSync(UploadUpgradeLogRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(opsMaintRepository.uploadUpgradeLog(request), Object.class);
    }

    @Override
    public long getUpgradePlanByDeviceAsync(RequestScope scope, UpgradePlanByDeviceRequest request, RequestCallback<List<UpgradePlanByDeviceData>> callback) {
        return RxCallbackScheduler.schedule(scope, opsMaintRepository.getUpgradePlanByDevice(request), callback);
    }

    @Override
    public List<UpgradePlanByDeviceData> getUpgradePlanByDeviceSync(UpgradePlanByDeviceRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(opsMaintRepository.getUpgradePlanByDevice(request));
    }

    @Override
    public long getUpgradePlanByDeviceWithOutLoginAsync(RequestScope scope, UpgradePlanByDeviceWithOutLoginRequest request, RequestCallback<String> callback) {
        return RxCallbackScheduler.schedule(scope, opsMaintRepository.getUpgradePlanByDeviceWithOutLogin(request), callback);
    }

    @Override
    public String getUpgradePlanByDeviceWithOutLoginSync(UpgradePlanByDeviceWithOutLoginRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(opsMaintRepository.getUpgradePlanByDeviceWithOutLogin(request), String.class);
    }

    @Override
    public long softwareReportAsync(RequestScope scope, SoftwareReportRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, opsMaintRepository.softwareReport(request), callback);
    }

    @Override
    public Boolean softwareReportSync(SoftwareReportRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(opsMaintRepository.softwareReport(request), Boolean.class);
    }

    @Override
    public long getDeviceQrcodeAsync(RequestScope scope, DeviceQrcodeRequest request, RequestCallback<String> callback) {
        return RxCallbackScheduler.schedule(scope, opsMaintRepository.getDeviceQrcode(request), callback);
    }

    @Override
    public String getDeviceQrcodeSync(DeviceQrcodeRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(opsMaintRepository.getDeviceQrcode(request));
    }

    @Override
    public long logAddBatchAsync(RequestScope scope, LogAddBatchRequest request, RequestCallback<Object> callback) {
        return RxCallbackScheduler.schedule(scope, opsMaintRepository.logAddBatch(request), callback);
    }

    @Override
    public Object logAddBatchSync(LogAddBatchRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(opsMaintRepository.logAddBatch(request), Object.class);
    }
}