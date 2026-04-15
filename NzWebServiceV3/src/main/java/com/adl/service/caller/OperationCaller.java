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
import com.adl.service.web.response.BannerDetailData;
import com.adl.service.web.response.BasePageData;
import com.adl.service.web.response.DeviceFocusData;
import com.adl.service.web.response.DictMapData;
import com.adl.service.web.response.SceneData;
import com.adl.service.web.response.SportSkuDetailData;
import com.adl.service.web.response.SportSkuData;
import com.adl.service.web.response.WikiData;
import com.adl.service.web.response.WikiDetailData;
import com.adl.service.web.response.WikiTypeData;

import java.util.List;
import java.util.Map;

/**
 * OperationCaller。
 */
public interface OperationCaller {

    void reLoadAllSceneDataSync(Map<String, List<String>> map) throws NzBaseException;

    /**
     * 获取Banner详情列表
     * <p>异步调用。</p>
     */
    long getBannerDetailListAsync(RequestScope scope, BannerDetailListRequest request, RequestCallback<List<BannerDetailData>> callback);

    /**
     * 获取Banner详情列表
     * <p>同步调用。</p>
     */
    List<BannerDetailData> getBannerDetailListSync(BannerDetailListRequest request) throws NzBaseException;

    long getSportSkuPagesAllAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<List<SportSkuData>> callback);

    List<SportSkuData> getSportSkuPagesAllSync(SportSkuPageRequest request) throws NzBaseException;

    /**
     * 获取项目库列表
     * <p>异步调用。</p>
     */
    long getSportSkuPageAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<BasePageData<SportSkuData>> callback);

    /**
     * 获取项目库列表
     * <p>同步调用。</p>
     */
    BasePageData<SportSkuData> getSportSkuPageSync(SportSkuPageRequest request) throws NzBaseException;

    /**
     * 获取项目详情
     * <p>异步调用。</p>
     */
    long getSportSkuDetailAsync(RequestScope scope, SportSkuDetailRequest request, RequestCallback<SportSkuDetailData> callback);

    /**
     * 获取项目详情
     * <p>同步调用。</p>
     */
    SportSkuDetailData getSportSkuDetailSync(SportSkuDetailRequest request) throws NzBaseException;

    /**
     * 获取模板内容
     * <p>异步调用。</p>
     */
    long getDictMapAsync(RequestScope scope, DictMapRequest request, RequestCallback<List<DictMapData>> callback);

    /**
     * 获取模板内容
     * <p>同步调用。</p>
     */
    List<DictMapData> getDictMapSync(DictMapRequest request) throws NzBaseException;

    /**
     * 获取场景列表
     * <p>异步调用。</p>
     */
    long getSceneListAsync(RequestScope scope, SceneListRequest request, RequestCallback<List<SceneData>> callback);

    /**
     * 获取场景列表
     * <p>同步调用。</p>
     */
    List<SceneData> getSceneListSync(SceneListRequest request) throws NzBaseException;

    /**
     * 修改设备名称
     * <p>异步调用。</p>
     */
    long uploadDeviceNameAsync(RequestScope scope, UploadDeviceNameRequest request, RequestCallback<Boolean> callback);

    /**
     * 修改设备名称
     * <p>同步调用。</p>
     */
    Boolean uploadDeviceNameSync(UploadDeviceNameRequest request) throws NzBaseException;

    /**
     * 获取设备专注信息列表
     * <p>异步调用。</p>
     */
    long getDeviceFocusListAsync(RequestScope scope, DeviceFocusListRequest request, RequestCallback<List<DeviceFocusData>> callback);

    /**
     * 获取设备专注信息列表
     * <p>同步调用。</p>
     */
    List<DeviceFocusData> getDeviceFocusListSync(DeviceFocusListRequest request) throws NzBaseException;

}
