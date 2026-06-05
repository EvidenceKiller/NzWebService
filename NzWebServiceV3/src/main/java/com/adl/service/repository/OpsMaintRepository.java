package com.adl.service.repository;

import com.adl.service.data.UpgradePlanByDeviceData;
import com.adl.service.http.request.DeviceQrcodeRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.LogAddBatchRequest;
import com.adl.service.http.request.SoftwareReportRequest;
import com.adl.service.http.request.UpgradePlanByDeviceRequest;
import com.adl.service.http.request.UpgradePlanByDeviceWithOutLoginRequest;
import com.adl.service.http.request.UploadDeviceInfoRequest;
import com.adl.service.http.request.UploadUpgradeLogRequest;
import com.adl.service.repository.fetch.OpsMaintFetchHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class OpsMaintRepository {
    private final OpsMaintFetchHelper fetchHelper = new OpsMaintFetchHelper();

    private static volatile OpsMaintRepository instance;

    private OpsMaintRepository() {
    }

    public static OpsMaintRepository getInstance() {
        if (instance == null) {
            synchronized (OpsMaintRepository.class) {
                if (instance == null) {
                    instance = new OpsMaintRepository();
                }
            }
        }
        return instance;
    }

    public Single<Boolean> uploadDeviceInfo(UploadDeviceInfoRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createUploadDeviceInfoFunc());
    }


    public Single<Object> uploadUpgradeLog(UploadUpgradeLogRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createUploadUpgradeLogFunc());
    }


    public Single<List<UpgradePlanByDeviceData>> getUpgradePlanByDevice(UpgradePlanByDeviceRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetUpgradePlanByDeviceFunc());
    }

    public Single<String> getUpgradePlanByDeviceWithOutLogin(UpgradePlanByDeviceWithOutLoginRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetUpgradePlanByDeviceWithOutLoginFunc());
    }

    public Single<Boolean> softwareReport(SoftwareReportRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createSoftwareReportFunc());
    }

    public Single<String> getDeviceQrcode(DeviceQrcodeRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetDeviceQrcodeFunc());
    }

    public Single<Object> logAddBatch(LogAddBatchRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createLogAddBatchFunc());
    }
}
