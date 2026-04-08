package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
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

import java.util.List;

/**
 * OperationCaller。
 */
public interface OperationCaller {

    long getDetailListAsync(RequestScope scope, BannerDetailListRequest request, RequestCallback<List<BannerDetailListData>> callback);

    List<BannerDetailListData> getDetailListSync(BannerDetailListRequest request);

    long getSportSkuPageAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<SportSkuPageData> callback);

    SportSkuPageData getSportSkuPageSync(SportSkuPageRequest request);

    long getSportSkuDetailAsync(RequestScope scope, SportSkuDetailRequest request, RequestCallback<SportSkuDetailData> callback);

    SportSkuDetailData getSportSkuDetailSync(SportSkuDetailRequest request);

    long getDictMapAsync(RequestScope scope, DictMapRequest request, RequestCallback<List<DictMapData>> callback);

    List<DictMapData> getDictMapSync(DictMapRequest request);

    long getSceneListAsync(RequestScope scope, SceneListRequest request, RequestCallback<List<SceneData>> callback);

    List<SceneData> getSceneListSync(SceneListRequest request);

    long getWikiTypePageAsync(RequestScope scope, WikiTypePageRequest request, RequestCallback<WikiPageData> callback);

    WikiPageData getWikiTypePageSync(WikiTypePageRequest request);

    long getWikiPageAsync(RequestScope scope, WikiPageRequest request, RequestCallback<WikiPageData> callback);

    WikiPageData getWikiPageSync(WikiPageRequest request);

    long getWikiDetailAsync(RequestScope scope, WikiDetailRequest request, RequestCallback<WikiDetailData> callback);

    WikiDetailData getWikiDetailSync(WikiDetailRequest request);

    long uploadDeviceNameAsync(RequestScope scope, UploadDeviceNameRequest request, RequestCallback<Boolean> callback);

    Boolean uploadDeviceNameSync(UploadDeviceNameRequest request);

    long getDeviceFocusListAsync(RequestScope scope, DeviceFocusListRequest request, RequestCallback<List<DeviceFocusData>> callback);

    List<DeviceFocusData> getDeviceFocusListSync(DeviceFocusListRequest request);

}
