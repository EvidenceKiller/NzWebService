package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.BannerDetailData;
import com.adl.service.data.UpgradePlanByDeviceData;
import com.adl.service.http.request.DeviceQrcodeRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.LogAddBatchRequest;
import com.adl.service.http.request.SoftwareReportRequest;
import com.adl.service.http.request.UpgradePlanByDeviceRequest;
import com.adl.service.http.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.http.request.UploadDeviceInfoRequest;
import com.adl.service.http.request.UploadUpgradeLogRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.OperationService;
import com.adl.service.web.OpsMaintService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OpsMaintFetchHelper {

    private volatile OpsMaintService opsMaintService;
    private volatile String baseUrl;

    public OpsMaintFetchHelper() {
    }

    private synchronized OpsMaintService getService() {
        if (opsMaintService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            opsMaintService = RetrofitManager.getInstance().create(OpsMaintService.class);
        }
        return opsMaintService;
    }

    public Function<UploadDeviceInfoRequest, Single<ResponseResult<Boolean>>> createUploadDeviceInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().uploadDeviceInfo(request));
    }

    public Function<UploadUpgradeLogRequest, Single<ResponseResult<Object>>> createUploadUpgradeLogFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().uploadUpgradeLog(request));
    }

    public Function<UpgradePlanByDeviceRequest, Single<ResponseResult<List<UpgradePlanByDeviceData>>>> createGetUpgradePlanByDeviceFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getUpgradePlanByDevice(request));
    }

    public Function<UpgradePlanByDeviceWithOutLoginRequest, Single<ResponseResult<String>>> createGetUpgradePlanByDeviceWithOutLoginFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getUpgradePlanByDeviceWithOutLogin(request));
    }

    public Function<SoftwareReportRequest, Single<ResponseResult<Boolean>>> createSoftwareReportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().softwareReport(request));
    }

    public Function<DeviceQrcodeRequest, Single<ResponseResult<String>>> createGetDeviceQrcodeFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDeviceQrcode(request));
    }

    public Function<LogAddBatchRequest, Single<ResponseResult<Object>>> createLogAddBatchFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().logAddBatch(request));
    }
}
