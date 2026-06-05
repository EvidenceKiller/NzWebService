package com.adl.service.caller;

import com.adl.service.callback.GetPageResult;
import com.adl.service.callback.RequestCallback;
import com.adl.service.data.BannerDetailData;
import com.adl.service.data.DeviceFocusData;
import com.adl.service.data.DictMapData;
import com.adl.service.data.PointRuleDetailData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuData;
import com.adl.service.data.SportSkuDetailData;
import com.adl.service.data.WikiData;
import com.adl.service.data.WikiDetailData;
import com.adl.service.data.WikiTypeData;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.BannerDetailListRequest;
import com.adl.service.http.request.DeviceFocusListRequest;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.PointRuleDetailRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuDetailRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.http.request.UploadDeviceNameRequest;
import com.adl.service.http.request.WikiDetailRequest;
import com.adl.service.http.request.WikiPageRequest;
import com.adl.service.http.request.WikiTypePageRequest;

import java.util.List;
import java.util.Map;

/**
 * OperationCaller。
 */
public interface OperationCaller {

    void reLoadAllSceneDataSync(Map<String, List<String>> map);

    /**
     * 获取Banner详情列表
     * <p>异步调用。</p>
     */
    long getBannerDetailListAsync(RequestScope scope, BannerDetailListRequest request, RequestCallback<List<BannerDetailData>> callback);

    /**
     * 获取Banner详情列表
     * <p>同步调用。</p>
     */
    List<BannerDetailData> getBannerDetailListSync(BannerDetailListRequest request);

    long getSportSkuPagesAllAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<GetPageResult> callback);

    GetPageResult getSportSkuPagesAllSync(SportSkuPageRequest request);

    /**
     * 获取项目库列表
     * <p>异步调用。</p>
     */
    long getSportSkuPageAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<List<SportSkuData>> callback);

    /**
     * 获取项目库列表
     * <p>同步调用。</p>
     */
    List<SportSkuData> getSportSkuPageSync(SportSkuPageRequest request);

    /**
     * 获取项目详情
     * <p>异步调用。</p>
     */
    long getSportSkuDetailAsync(RequestScope scope, SportSkuDetailRequest request, RequestCallback<SportSkuDetailData> callback);

    /**
     * 获取项目详情
     * <p>同步调用。</p>
     */
    SportSkuDetailData getSportSkuDetailSync(SportSkuDetailRequest request);

    /**
     * 获取模板内容
     * <p>异步调用。</p>
     */
    long getDictMapAsync(RequestScope scope, DictMapRequest request, RequestCallback<List<DictMapData>> callback);

    /**
     * 获取模板内容
     * <p>同步调用。</p>
     */
    List<DictMapData> getDictMapSync(DictMapRequest request);

    /**
     * 获取场景列表
     * <p>异步调用。</p>
     */
    long getSceneListAsync(RequestScope scope, SceneListRequest request, RequestCallback<List<SceneData>> callback);

    /**
     * 获取场景列表
     * <p>同步调用。</p>
     */
    List<SceneData> getSceneListSync(SceneListRequest request);

    /**
     * 获取百科分类列表
     * <p>异步调用。</p>
     */
    long getWikiTypePageAsync(RequestScope scope, WikiTypePageRequest request, RequestCallback<List<WikiTypeData>> callback);

    /**
     * 获取百科分类列表
     * <p>同步调用。</p>
     */
    List<WikiTypeData> getWikiTypePageSync(WikiTypePageRequest request);

    /**
     * 获取百科列表
     * <p>异步调用。</p>
     */
    long getWikiPageAsync(RequestScope scope, WikiPageRequest request, RequestCallback<List<WikiData>> callback);

    /**
     * 获取百科列表
     * <p>同步调用。</p>
     */
    List<WikiData> getWikiPageSync(WikiPageRequest request);

    /**
     * 获取运动百科详情
     * <p>异步调用。</p>
     */
    long getWikiDetailAsync(RequestScope scope, WikiDetailRequest request, RequestCallback<WikiDetailData> callback);

    /**
     * 获取运动百科详情
     * <p>同步调用。</p>
     */
    WikiDetailData getWikiDetailSync(WikiDetailRequest request);

    /**
     * 修改设备名称
     * <p>异步调用。</p>
     */
    long uploadDeviceNameAsync(RequestScope scope, UploadDeviceNameRequest request, RequestCallback<Boolean> callback);

    /**
     * 修改设备名称
     * <p>同步调用。</p>
     */
    Boolean uploadDeviceNameSync(UploadDeviceNameRequest request);

    /**
     * 获取设备专注信息列表
     * <p>异步调用。</p>
     */
    long getDeviceFocusListAsync(RequestScope scope, DeviceFocusListRequest request, RequestCallback<List<DeviceFocusData>> callback);

    /**
     * 获取设备专注信息列表
     * <p>同步调用。</p>
     */
    List<DeviceFocusData> getDeviceFocusListSync(DeviceFocusListRequest request);

    /**
     * 查询运动能量分值
     * <p>异步调用。</p>
     */
    long getPointRuleDetailAsync(RequestScope scope, PointRuleDetailRequest request, RequestCallback<PointRuleDetailData> callback);

    /**
     * 查询运动能量分值
     * <p>同步调用。</p>
     */
    PointRuleDetailData getPointRuleDetailSync(PointRuleDetailRequest request);
}
