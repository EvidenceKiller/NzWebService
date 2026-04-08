package com.adl.service.v3interface.out.impl;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.api.RxSdk;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.exception.NzBaseException;
import com.adl.service.v3interface.internal.RxCallbackScheduler;
import com.adl.service.v3interface.internal.SubscriptionManager;
import com.adl.service.v3interface.out.OperationCaller;
import com.adl.service.v3interface.request.BannerDetailListRequest;
import com.adl.service.v3interface.request.DeviceFocusListRequest;
import com.adl.service.v3interface.request.DictMapRequest;
import com.adl.service.v3interface.request.SceneListRequest;
import com.adl.service.v3interface.request.SportSkuDetailRequest;
import com.adl.service.v3interface.request.SportSkuPageRequest;
import com.adl.service.v3interface.request.UploadDeviceNameRequest;
import com.adl.service.v3interface.request.WikiDetailRequest;
import com.adl.service.v3interface.request.WikiPageRequest;
import com.adl.service.v3interface.request.WikiTypePageRequest;
import com.adl.service.v3interface.response.BannerDetailListData;
import com.adl.service.v3interface.response.DeviceFocusData;
import com.adl.service.v3interface.response.DictMapData;
import com.adl.service.v3interface.response.SceneData;
import com.adl.service.v3interface.response.SportSkuDetailData;
import com.adl.service.v3interface.response.SportSkuPageData;
import com.adl.service.v3interface.response.WikiDetailData;
import com.adl.service.v3interface.response.WikiPageData;
import com.adl.service.v3interface.service.OperationService;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * OperationCaller 实现（SDK 内部使用，通过 {@link RxSdk} 暴露）。
 */
public final class OperationCallerImpl implements OperationCaller {

    private final OperationService operationService;

    public OperationCallerImpl(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public long getDetailListAsync(RequestScope scope, BannerDetailListRequest request, RequestCallback<List<BannerDetailListData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getDetailList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<BannerDetailListData> getDetailListSync(BannerDetailListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getDetailList(request));
    }

    @Override
    public long getSportSkuPageAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<SportSkuPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getSportSkuPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public SportSkuPageData getSportSkuPageSync(SportSkuPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getSportSkuPage(request));
    }

    @Override
    public long getSportSkuDetailAsync(RequestScope scope, SportSkuDetailRequest request, RequestCallback<SportSkuDetailData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getSportSkuDetail(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public SportSkuDetailData getSportSkuDetailSync(SportSkuDetailRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getSportSkuDetail(request));
    }

    @Override
    public long getDictMapAsync(RequestScope scope, DictMapRequest request, RequestCallback<List<DictMapData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getDictMap(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<DictMapData> getDictMapSync(DictMapRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getDictMap(request));
    }

    @Override
    public long getSceneListAsync(RequestScope scope, SceneListRequest request, RequestCallback<List<SceneData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getSceneList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<SceneData> getSceneListSync(SceneListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getSceneList(request));
    }

    @Override
    public long getWikiTypePageAsync(RequestScope scope, WikiTypePageRequest request, RequestCallback<WikiPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getWikiTypePage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public WikiPageData getWikiTypePageSync(WikiTypePageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getWikiTypePage(request));
    }

    @Override
    public long getWikiPageAsync(RequestScope scope, WikiPageRequest request, RequestCallback<WikiPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getWikiPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public WikiPageData getWikiPageSync(WikiPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getWikiPage(request));
    }

    @Override
    public long getWikiDetailAsync(RequestScope scope, WikiDetailRequest request, RequestCallback<WikiDetailData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getWikiDetail(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public WikiDetailData getWikiDetailSync(WikiDetailRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getWikiDetail(request));
    }

    @Override
    public long uploadDeviceNameAsync(RequestScope scope, UploadDeviceNameRequest request, RequestCallback<Boolean> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.uploadDeviceName(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Boolean uploadDeviceNameSync(UploadDeviceNameRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.uploadDeviceName(request));
    }

    @Override
    public long getDeviceFocusListAsync(RequestScope scope, DeviceFocusListRequest request, RequestCallback<List<DeviceFocusData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(operationService.getDeviceFocusList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<DeviceFocusData> getDeviceFocusListSync(DeviceFocusListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(operationService.getDeviceFocusList(request));
    }
}
