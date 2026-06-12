package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
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

    public Function<BannerDetailListRequest, Single<ResponseResult<List<BannerDetailData>>>> createGetBannerDetailListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getBannerDetailList(request));
    }

    public Function<Long, Single<ResponseResult<BasePageData<SportSkuData>>>> createGetSportSkuPagesAllFunc(SportSkuPageRequest request) {
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
            return BaseFetchUtil.scheduleResponse(getService().getSportSkuPage(pageReq));
        };
    }

    public Function<SportSkuPageRequest, Single<ResponseResult<BasePageData<SportSkuData>>>> createGetSportSkuPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportSkuPage(request));
    }

    public Function<SportSkuDetailRequest, Single<ResponseResult<SportSkuDetailData>>> createGetSportSkuDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSportSkuDetail(request));
    }

    public Function<DictMapRequest, Single<ResponseResult<List<DictMapData>>>> createGetDictMapFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDictMap(request));
    }

    public Function<SceneListRequest, Single<ResponseResult<List<SceneData>>>> createGetSceneListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSceneList(request));
    }

    public Function<WikiTypePageRequest, Single<ResponseResult<BasePageData<WikiTypeData>>>> createGetWikiTypePageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getWikiTypePage(request));
    }

    public Function<WikiPageRequest, Single<ResponseResult<BasePageData<WikiData>>>> createGetWikiPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getWikiPage(request));
    }

    public Function<WikiDetailRequest, Single<ResponseResult<WikiDetailData>>> createGetWikiDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getWikiDetail(request));
    }

    public Function<UploadDeviceNameRequest, Single<ResponseResult<Boolean>>> createUploadDeviceNameFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().uploadDeviceName(request));
    }

    public Function<DeviceFocusListRequest, Single<ResponseResult<List<DeviceFocusData>>>> createGetDeviceFocusListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getDeviceFocusList(request));
    }

    public Function<PointRuleDetailRequest, Single<ResponseResult<PointRuleDetailData>>> createGetPointRuleDetailFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getPointRuleDetail(request));
    }
}
