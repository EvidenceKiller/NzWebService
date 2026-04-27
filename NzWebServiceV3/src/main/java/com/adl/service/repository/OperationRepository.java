package com.adl.service.repository;

import com.adl.service.callback.GetPageResult;
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
import com.adl.service.repository.fetch.OperationFetchHelper;
import com.adl.service.repository.persist.OperationPersistHelper;
import com.adl.service.repository.prepare.OperationPrepareHelper;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public final class OperationRepository {
    private final OperationPrepareHelper prepareHelper = new OperationPrepareHelper();
    private final OperationFetchHelper fetchHelper = new OperationFetchHelper();
    private final OperationPersistHelper persistHelper = new OperationPersistHelper();

    private static volatile OperationRepository instance;

    private OperationRepository() {
    }

    public static OperationRepository getInstance() {
        if (instance == null) {
            synchronized (OperationRepository.class) {
                if (instance == null) {
                    instance = new OperationRepository();
                }
            }
        }
        return instance;
    }

    public Single<List<BannerDetailData>> getBannerDetailList(BannerDetailListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetBannerDetailListFunc());
    }

    public Single<GetPageResult> getSportSkuPagesAll(SportSkuPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createGetSportSkuPagesAllFunc(),
                fetchHelper.createGetSportSkuPagesAllFunc(request),
                persistHelper.createPersistSportSkuPageFunc(request));
    }

    public Single<List<SportSkuData>> getSportSkuPage(SportSkuPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetSportSkuPageFunc(),
                persistHelper.createPersistSportSkuPageFunc(request));
    }

    public Single<SportSkuDetailData> getSportSkuDetail(SportSkuDetailRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetSportSkuDetailFunc());
    }

    public Single<List<DictMapData>> getDictMap(DictMapRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                prepareHelper.createPrepareDictMapListFunc(),
                fetchHelper.createGetDictMapFunc(),
                persistHelper.createPersistDictMapListFunc(request));
    }

    public Single<List<SceneData>> getSceneList(SceneListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                prepareHelper.createGetSceneListPrepareFunc(),
                fetchHelper.createGetSceneListFunc(),
                persistHelper.createPersistSceneListFunc(request));
    }

    public Single<Boolean> uploadDeviceName(UploadDeviceNameRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createUploadDeviceNameFunc());
    }

    public Single<List<DeviceFocusData>> getDeviceFocusList(DeviceFocusListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetDeviceFocusListFunc());
    }
}
