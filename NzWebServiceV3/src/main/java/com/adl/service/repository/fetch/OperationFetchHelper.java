package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.data.BannerDetailData;
import com.adl.service.data.BasePageData;
import com.adl.service.data.DeviceFocusData;
import com.adl.service.data.DictMapData;
import com.adl.service.data.PointRuleDetailData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuData;
import com.adl.service.data.SportSkuDetailData;
import com.adl.service.data.WikiData;
import com.adl.service.data.WikiDetailData;
import com.adl.service.data.WikiTypeData;
import com.adl.service.http.request.BannerDetailListRequest;
import com.adl.service.http.request.DeviceFocusListRequest;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.PointRuleDetailRequest;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuDetailRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.http.request.UploadDeviceNameRequest;
import com.adl.service.http.request.WikiDetailRequest;
import com.adl.service.http.request.WikiPageRequest;
import com.adl.service.http.request.WikiTypePageRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.OperationService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OperationFetchHelper {

    private volatile OperationService operationService;
    private volatile String baseUrl;

    public OperationFetchHelper() {
    }

    private synchronized OperationService getService() {
        if (operationService == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            operationService = RetrofitManager.getInstance().create(OperationService.class);
        }
        return operationService;
    }

    @SuppressWarnings("unchecked")
    public Function<BannerDetailListRequest, Single<List<BannerDetailData>>> createGetBannerDetailListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getBannerDetailList(request), (Class<List<BannerDetailData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<Long, Single<BasePageData<SportSkuData>>> createGetSportSkuPagesAllFunc(SportSkuPageRequest request) {
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
            return BaseFetchUtil.scheduleResponse(getService().getSportSkuPage(pageReq), (Class<BasePageData<SportSkuData>>) (Class<?>) BasePageData.class);
        };
    }

    @SuppressWarnings("unchecked")
    public Function<SportSkuPageRequest, Single<BasePageData<SportSkuData>>> createGetSportSkuPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportSkuPage(request), (Class<BasePageData<SportSkuData>>) (Class<?>) BasePageData.class);
    }

    public Function<SportSkuDetailRequest, Single<SportSkuDetailData>> createGetSportSkuDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportSkuDetail(request), SportSkuDetailData.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DictMapRequest, Single<List<DictMapData>>> createGetDictMapFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDictMap(request), (Class<List<DictMapData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SceneListRequest, Single<List<SceneData>>> createGetSceneListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSceneList(request), (Class<List<SceneData>>) (Class<?>) List.class);
    }

    public Function<WikiTypePageRequest, Single<BasePageData<WikiTypeData>>> createGetWikiTypePageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getWikiTypePage(request), (Class<BasePageData<WikiTypeData>>) (Class<?>) BasePageData.class);
    }

    public Function<WikiPageRequest, Single<BasePageData<WikiData>>> createGetWikiPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getWikiPage(request), (Class<BasePageData<WikiData>>) (Class<?>) BasePageData.class);
    }

    public Function<WikiDetailRequest, Single<WikiDetailData>> createGetWikiDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getWikiDetail(request), WikiDetailData.class);
    }

    public Function<UploadDeviceNameRequest, Single<Boolean>> createUploadDeviceNameFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().uploadDeviceName(request), Boolean.class);
    }

    @SuppressWarnings("unchecked")
    public Function<DeviceFocusListRequest, Single<List<DeviceFocusData>>> createGetDeviceFocusListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDeviceFocusList(request), (Class<List<DeviceFocusData>>) (Class<?>) List.class);
    }

    @SuppressWarnings("unchecked")
    public Function<PointRuleDetailRequest, Single<PointRuleDetailData>> createGetPointRuleDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPointRuleDetail(request), PointRuleDetailData.class);
    }
}
