package com.adl.service.repository.persist;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.DictMapData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.DictMapEntity;
import com.adl.service.db.entity.SceneEntity;
import com.adl.service.db.entity.SportSkuEntity;
import com.adl.service.exception.NzCommonException;
import com.adl.service.exception.NzPersistException;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.repository.cache.CacheTag;
import com.adl.service.repository.cache.MemoryCacheManager;
import com.adl.service.utils.InnerUtil;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OperationPersistHelper {

    public OperationPersistHelper() {
    }

    public Function<ResponseResult<List<SceneData>>, Single<ResponseResult<List<SceneData>>>> createPersistSceneListFunc(SceneListRequest request) {
        return (responseResult) -> {
            if (responseResult == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            List<SceneData> dataList = responseResult.getData();
            if (dataList == null || dataList.isEmpty()) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "scene data list is null"));
            }
            if (TextUtils.isEmpty(request.getAppCode())) {
                DaoManagerProxy.getInstance().getSceneDao().clearAll();
            } else {
                DaoManagerProxy.getInstance().getSceneDao().clearByAppCode(request.getAppCode());
            }
            List<SceneEntity> entityList = dataList.stream()
                    .map(data -> SceneEntity.convertToEntity(data, request.getAppCode()))
                    .collect(Collectors.toList());
            DaoManagerProxy.getInstance().getSceneDao().insertAll(entityList);
            return Single.just(responseResult);
        };
    }

    public Function<ResponseResult<List<SportSkuData>>, Single<ResponseResult<List<SportSkuData>>>> createPersistSportSkuPageFunc(SportSkuPageRequest request) {
        return (responseResult) -> {
            if (responseResult == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            List<SportSkuData> pageData = responseResult.getData();
            if (pageData == null || pageData.isEmpty()) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "sport sku data list is null"));
            }
            List<SportSkuEntity> entityList = pageData.stream()
                    .map(data -> SportSkuEntity.convertToEntity(data, request.getAppCode(), request.getSceneId()))
                    .collect(Collectors.toList());
            DaoManagerProxy.getInstance().getSceneSportDao().insertAll(entityList);
            return Single.just(responseResult);
        };
    }

    public Function<ResponseResult<List<DictMapData>>, Single<ResponseResult<List<DictMapData>>>> createPersistDictMapListFunc(DictMapRequest request) {
        return (responseResult) -> {
            if (responseResult == null) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "response result is null"));
            }
            List<DictMapData> dataList = responseResult.getData();
            if (dataList == null || dataList.isEmpty()) {
                return Single.error(new NzPersistException(NzResponseCode.NZ_PERSIST_ERROR, "dict map data list is null"));
            }
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_DICT_MAP_LIST + InnerUtil.toJson(request), dataList, DictMapEntity.EXPIRED_TIME);
            DaoManagerProxy.getInstance().getDictMapDao().clearDictMapBySportSkuId(request.getSportSkuId());
            List<DictMapEntity> entityList = dataList.stream()
                    .map(data -> DictMapEntity.convertToEntity(data, request.getSportSkuId()))
                    .collect(Collectors.toList());
            DaoManagerProxy.getInstance().getDictMapDao().insertList(entityList);
            return Single.just(responseResult);
        };
    }
}
