package com.adl.service.repository.fetch;

import android.text.TextUtils;

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

    @SuppressWarnings("unchecked")
    public Function<UploadDeviceInfoRequest, Single<Boolean>> createUploadDeviceInfoFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().uploadDeviceInfo(request), Boolean.class);
    }

    @SuppressWarnings("unchecked")
    public Function<UploadUpgradeLogRequest, Single<Object>> createUploadUpgradeLogFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().uploadUpgradeLog(request), Object.class);
    }

    @SuppressWarnings("unchecked")
    public Function<UpgradePlanByDeviceRequest, Single<List<UpgradePlanByDeviceData>>> createGetUpgradePlanByDeviceFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getUpgradePlanByDevice(request), (Class<List< UpgradePlanByDeviceData >>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<UpgradePlanByDeviceWithOutLoginRequest, Single<String>> createGetUpgradePlanByDeviceWithOutLoginFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getUpgradePlanByDeviceWithOutLogin(request), String.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SoftwareReportRequest, Single<Boolean>> createSoftwareReportFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().softwareReport(request), Boolean.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DeviceQrcodeRequest, Single<String>> createGetDeviceQrcodeFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDeviceQrcode(request), String.class);
    }

    @SuppressWarnings("unchecked")
    public Function<LogAddBatchRequest, Single<Object>> createLogAddBatchFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().logAddBatch(request), Object.class);
    }
}
