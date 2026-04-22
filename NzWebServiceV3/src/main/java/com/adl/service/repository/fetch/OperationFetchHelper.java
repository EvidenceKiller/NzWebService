package com.adl.service.repository.fetch;

import com.adl.service.data.BannerDetailData;
import com.adl.service.data.DeviceFocusData;
import com.adl.service.data.DictMapData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuData;
import com.adl.service.data.SportSkuDetailData;
import com.adl.service.http.request.BannerDetailListRequest;
import com.adl.service.http.request.DeviceFocusListRequest;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuDetailRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.http.request.UploadDeviceNameRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.OperationService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OperationFetchHelper {

    private final OperationService operationService;

    public OperationFetchHelper() {
        this.operationService = RetrofitManager.getInstance().create(OperationService.class);
    }

    @SuppressWarnings("unchecked")
    public Function<BannerDetailListRequest, Single<List<BannerDetailData>>> createGetBannerDetailListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(operationService.getBannerDetailList(request), (Class<List<BannerDetailData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<List<SportSkuData>>> createGetSportSkuPagesAllFunc(SportSkuPageRequest request) {
        return (page) -> {
            SportSkuPageRequest pageReq = SportSkuPageRequest.builder()
                    .current(page)
                    .pageSize(request.getPageSize())
                    .sportNature(request.getSportNature())
                    .sportType(request.getSportType())
                    .keyword(request.getKeyword())
                    .templateFlag(request.getTemplateFlag())
                    .ids(request.getIds())
                    .appCodes(request.getAppCodes())
                    .appCode(request.getAppCode())
                    .sceneId(request.getSceneId())
                    .delFlag(request.getDelFlag())
                    .enabled(request.getEnabled())
                    .build();
            return BaseFetchUtil.schedulePageResponse(operationService.getSportSkuPage(pageReq), (Class<List<SportSkuData>>) (Class<?>) List.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<SportSkuPageRequest, Single<List<SportSkuData>>> createGetSportSkuPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(operationService.getSportSkuPage(request), (Class<List<SportSkuData>>) (Class<?>) List.class);
    }

    public Function<SportSkuDetailRequest, Single<SportSkuDetailData>> createGetSportSkuDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(operationService.getSportSkuDetail(request), SportSkuDetailData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DictMapRequest, Single<List<DictMapData>>> createGetDictMapFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(operationService.getDictMap(request), (Class<List<DictMapData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SceneListRequest, Single<List<SceneData>>> createGetSceneListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(operationService.getSceneList(request), (Class<List<SceneData>>) (Class<?>) List.class);
    }

    public Function<UploadDeviceNameRequest, Single<Boolean>> createUploadDeviceNameFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(operationService.uploadDeviceName(request), Boolean.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DeviceFocusListRequest, Single<List<DeviceFocusData>>> createGetDeviceFocusListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(operationService.getDeviceFocusList(request), (Class<List<DeviceFocusData>>) (Class<?>) List.class);
    }
}
