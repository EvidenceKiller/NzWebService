package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.BannerDetailListRequest;
import com.adl.service.web.request.DeviceFocusListRequest;
import com.adl.service.web.request.DictMapRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.SceneListRequest;
import com.adl.service.web.request.SportSkuDetailRequest;
import com.adl.service.web.request.SportSkuPageRequest;
import com.adl.service.web.request.UploadDeviceNameRequest;
import com.adl.service.web.request.WikiDetailRequest;
import com.adl.service.web.request.WikiPageRequest;
import com.adl.service.web.request.WikiTypePageRequest;
import com.adl.service.web.response.BannerDetailListData;
import com.adl.service.web.response.DeviceFocusData;
import com.adl.service.web.response.DictMapData;
import com.adl.service.web.response.SceneData;
import com.adl.service.web.response.SportSkuDetailData;
import com.adl.service.web.response.SportSkuPageData;
import com.adl.service.web.response.WikiDetailData;
import com.adl.service.web.response.WikiPageData;

import java.util.List;

/**
 * OperationCaller。
 */
public interface OperationCaller {

    long getDetailListAsync(RequestScope scope, BannerDetailListRequest request, RequestCallback<List<BannerDetailListData>> callback);

    List<BannerDetailListData> getDetailListSync(BannerDetailListRequest request) throws NzBaseException;

    long getSportSkuPageAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<SportSkuPageData> callback);

    SportSkuPageData getSportSkuPageSync(SportSkuPageRequest request) throws NzBaseException;

    long getSportSkuDetailAsync(RequestScope scope, SportSkuDetailRequest request, RequestCallback<SportSkuDetailData> callback);

    SportSkuDetailData getSportSkuDetailSync(SportSkuDetailRequest request) throws NzBaseException;

    long getDictMapAsync(RequestScope scope, DictMapRequest request, RequestCallback<List<DictMapData>> callback);

    List<DictMapData> getDictMapSync(DictMapRequest request) throws NzBaseException;

    long getSceneListAsync(RequestScope scope, SceneListRequest request, RequestCallback<List<SceneData>> callback);

    List<SceneData> getSceneListSync(SceneListRequest request) throws NzBaseException;

    long getWikiTypePageAsync(RequestScope scope, WikiTypePageRequest request, RequestCallback<WikiPageData> callback);

    WikiPageData getWikiTypePageSync(WikiTypePageRequest request) throws NzBaseException;

    long getWikiPageAsync(RequestScope scope, WikiPageRequest request, RequestCallback<WikiPageData> callback);

    WikiPageData getWikiPageSync(WikiPageRequest request) throws NzBaseException;

    long getWikiDetailAsync(RequestScope scope, WikiDetailRequest request, RequestCallback<WikiDetailData> callback);

    WikiDetailData getWikiDetailSync(WikiDetailRequest request) throws NzBaseException;

    long uploadDeviceNameAsync(RequestScope scope, UploadDeviceNameRequest request, RequestCallback<Boolean> callback);

    Boolean uploadDeviceNameSync(UploadDeviceNameRequest request) throws NzBaseException;

    long getDeviceFocusListAsync(RequestScope scope, DeviceFocusListRequest request, RequestCallback<List<DeviceFocusData>> callback);

    List<DeviceFocusData> getDeviceFocusListSync(DeviceFocusListRequest request) throws NzBaseException;

}
