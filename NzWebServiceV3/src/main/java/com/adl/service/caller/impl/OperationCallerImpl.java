package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.PageSummaryData;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.OperationCaller;
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
import com.adl.service.db.DaoManagerProxy;
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
import com.adl.service.internal.CallerManager;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.log.NzLog;
import com.adl.service.repository.OperationRepository;
import com.adl.service.utils.InnerUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * OperationCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class OperationCallerImpl implements OperationCaller {

    private final OperationRepository operationRepository;

    public OperationCallerImpl() {
        this.operationRepository = OperationRepository.getInstance();
    }

    @Override
    public void reLoadAllSceneDataSync(Map<String, List<String>> map) {
        ResponseResult<Long> serverTimeResult = CallerManager.getInstance().getCommonInfoCaller().getServerTimeSync();
        long serverTime = 0L;
        if (serverTimeResult.getCode() == NzResponseCode.NZ_SUCCESS && serverTimeResult.getData() != null) {
            serverTime = serverTimeResult.getData();
        }
        NzLog.d("服务器时间: " + InnerUtil.formatByTimeCode(serverTime));

        DaoManagerProxy.getInstance().getSceneDao().clearAll();
        DaoManagerProxy.getInstance().getSceneSportDao().clearAll();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String appCode = entry.getKey();
            List<String> sceneIds = entry.getValue();
            ////////////// 1.同步场景列表 ////////////
            SceneListRequest request = SceneListRequest.builder()
                    .appCode(appCode)
                    .build();
            ResponseResult<List<SceneData>> respResult = getSceneListSync(request);
            if (respResult.getCode() != NzResponseCode.NZ_SUCCESS || respResult.getData() == null) {
                break;
            }
            List<SceneData> sceneList = respResult.getData()
                    .stream()
                    .filter(sceneData -> sceneIds.contains(sceneData.getId()))
                    .collect(Collectors.toList());

            ////////////// 2.同步场景下运动列表 ////////////
            for (SceneData sceneData : sceneList) {
                SportSkuPageRequest req = SportSkuPageRequest.builder()
                        .appCode(appCode)
                        .sceneId(sceneData.getId())
                        .build();
                getSportSkuPagesAllSync(req);
            }
        }
    }

    @Override
    public long getBannerDetailListAsync(RequestScope scope, BannerDetailListRequest request, RequestCallback<List<BannerDetailData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getBannerDetailList(request), callback);
    }

    @Override
    public ResponseResult<List<BannerDetailData>> getBannerDetailListSync(BannerDetailListRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getBannerDetailList(request));
    }

    @Override
    public long getSportSkuPagesAllAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<PageSummaryData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getSportSkuPagesAll(request), callback);
    }

    @Override
    public ResponseResult<PageSummaryData> getSportSkuPagesAllSync(SportSkuPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getSportSkuPagesAll(request));
    }

    @Override
    public long getSportSkuPageAsync(RequestScope scope, SportSkuPageRequest request, RequestCallback<List<SportSkuData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getSportSkuPage(request), callback);
    }

    @Override
    public ResponseResult<List<SportSkuData>> getSportSkuPageSync(SportSkuPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getSportSkuPage(request));
    }

    @Override
    public long getSportSkuDetailAsync(RequestScope scope, SportSkuDetailRequest request, RequestCallback<SportSkuDetailData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getSportSkuDetail(request), callback);
    }

    @Override
    public ResponseResult<SportSkuDetailData> getSportSkuDetailSync(SportSkuDetailRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getSportSkuDetail(request));
    }

    @Override
    public long getDictMapAsync(RequestScope scope, DictMapRequest request, RequestCallback<List<DictMapData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getDictMap(request), callback);
    }

    @Override
    public ResponseResult<List<DictMapData>> getDictMapSync(DictMapRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getDictMap(request));
    }

    @Override
    public long getSceneListAsync(RequestScope scope, SceneListRequest request, RequestCallback<List<SceneData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getSceneList(request), callback);
    }

    @Override
    public ResponseResult<List<SceneData>> getSceneListSync(SceneListRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getSceneList(request));
    }

    @Override
    public long getWikiTypePageAsync(RequestScope scope, WikiTypePageRequest request, RequestCallback<List<WikiTypeData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getWikiTypePage(request), callback);
    }

    @Override
    public ResponseResult<List<WikiTypeData>> getWikiTypePageSync(WikiTypePageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getWikiTypePage(request));
    }

    @Override
    public long getWikiPageAsync(RequestScope scope, WikiPageRequest request, RequestCallback<List<WikiData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getWikiPage(request), callback);
    }

    @Override
    public ResponseResult<List<WikiData>> getWikiPageSync(WikiPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getWikiPage(request));
    }

    @Override
    public long getWikiDetailAsync(RequestScope scope, WikiDetailRequest request, RequestCallback<WikiDetailData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getWikiDetail(request), callback);
    }

    @Override
    public ResponseResult<WikiDetailData> getWikiDetailSync(WikiDetailRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getWikiDetail(request));
    }

    @Override
    public long uploadDeviceNameAsync(RequestScope scope, UploadDeviceNameRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.uploadDeviceName(request), callback);
    }

    @Override
    public ResponseResult<Boolean> uploadDeviceNameSync(UploadDeviceNameRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.uploadDeviceName(request));
    }

    @Override
    public long getDeviceFocusListAsync(RequestScope scope, DeviceFocusListRequest request, RequestCallback<List<DeviceFocusData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getDeviceFocusList(request), callback);
    }

    @Override
    public ResponseResult<List<DeviceFocusData>> getDeviceFocusListSync(DeviceFocusListRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getDeviceFocusList(request));
    }

    @Override
    public long getPointRuleDetailAsync(RequestScope scope, PointRuleDetailRequest request, RequestCallback<PointRuleDetailData> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, operationRepository.getPointRuleDetail(request), callback);
    }

    @Override
    public ResponseResult<PointRuleDetailData> getPointRuleDetailSync(PointRuleDetailRequest request) {
        return RxCallbackScheduler.scheduleResultSync(operationRepository.getPointRuleDetail(request));
    }
}
