package com.adl.service.repository;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.PageSummaryData;
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
import com.adl.service.repository.fetch.OperationFetchHelper;
import com.adl.service.repository.persist.OperationPersistHelper;
import com.adl.service.repository.prepare.OperationPrepareHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
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

    public Single<ResponseResult<List<BannerDetailData>>> getBannerDetailList(BannerDetailListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetBannerDetailListFunc());
    }

    public Single<ResponseResult<PageSummaryData>> getSportSkuPagesAll(SportSkuPageRequest request) {
        return BaseRepositoryUtil.repositoryPagesAsSingle(request,
                prepareHelper.createGetSportSkuPagesAllFunc(),
                fetchHelper.createGetSportSkuPagesAllFunc(request),
                persistHelper.createPersistSportSkuPageFunc(request));
    }

    public Single<ResponseResult<List<SportSkuData>>> getSportSkuPage(SportSkuPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request,
                fetchHelper.createGetSportSkuPageFunc(),
                persistHelper.createPersistSportSkuPageFunc(request));
    }

    public Single<ResponseResult<SportSkuDetailData>> getSportSkuDetail(SportSkuDetailRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetSportSkuDetailFunc());
    }

    public Single<ResponseResult<List<DictMapData>>> getDictMap(DictMapRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                prepareHelper.createPrepareDictMapListFunc(),
                fetchHelper.createGetDictMapFunc(),
                persistHelper.createPersistDictMapListFunc(request));
    }

    public Single<ResponseResult<List<SceneData>>> getSceneList(SceneListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request,
                prepareHelper.createGetSceneListPrepareFunc(),
                fetchHelper.createGetSceneListFunc(),
                persistHelper.createPersistSceneListFunc(request));
    }

    public Single<ResponseResult<List<WikiTypeData>>> getWikiTypePage(WikiTypePageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetWikiTypePageFunc());
    }

    public Single<ResponseResult<List<WikiData>>> getWikiPage(WikiPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetWikiPageFunc());
    }

    public Single<ResponseResult<WikiDetailData>> getWikiDetail(WikiDetailRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetWikiDetailFunc());
    }

    public Single<ResponseResult<Boolean>> uploadDeviceName(UploadDeviceNameRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createUploadDeviceNameFunc());
    }

    public Single<ResponseResult<List<DeviceFocusData>>> getDeviceFocusList(DeviceFocusListRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetDeviceFocusListFunc());
    }

    public Single<ResponseResult<PointRuleDetailData>> getPointRuleDetail(PointRuleDetailRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetPointRuleDetailFunc());
    }
}
