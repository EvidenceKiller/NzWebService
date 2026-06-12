package com.adl.service.repository.prepare;

import android.text.TextUtils;
import android.util.Log;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.DictMapData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.DictMapEntity;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.repository.cache.CacheTag;
import com.adl.service.repository.cache.MemoryCacheManager;
import com.adl.service.utils.CommonUtil;
import com.adl.service.utils.InnerUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OperationPrepareHelper {

    public OperationPrepareHelper() {
    }

    public Function<SceneListRequest, Single<ResponseResult<List<SceneData>>>> createGetSceneListPrepareFunc() {
        return request -> null;
    }

    public static Function<SportSkuPageRequest, Single<ResponseResult<List<SportSkuData>>>> createGetSportSkuPagesAllFunc() {
        return (requestu) -> {
            DaoManagerProxy.getInstance().getSceneSportDao().clearAll();
            return null;
        };
    }

    public Function<DictMapRequest, Single<ResponseResult<List<DictMapData>>>> createPrepareDictMapListFunc() {
        return (request) -> {
            if (TextUtils.isEmpty(request.getSportSkuId())) {
                // 服务器逻辑sportSkuId为空，返回空列表，这里同样返回空列表
                return Single.just(CommonUtil.createSuccessResponseResult(Collections.EMPTY_LIST));
            }
            List<DictMapData> data = (List<DictMapData>) MemoryCacheManager.getInstance().get(CacheTag.CACHE_TAG_DICT_MAP_LIST + InnerUtil.toJson(request));
            if (data != null) {
                return Single.just(CommonUtil.createSuccessResponseResult(data));
            }
            List<DictMapEntity> entities = DaoManagerProxy.getInstance().getDictMapDao().queryDictMapBySportSkuId(request.getSportSkuId());
            if (entities == null || entities.isEmpty()) {
                return null;
            }
            long expiredTime = entities.get(0).getExpiredTime();
            if (expiredTime <= System.currentTimeMillis()) {
                return null;
            }
            data = entities.stream()
                    .map(DictMapEntity::convertToData)
                    .collect(Collectors.toList());
            // 需要重新放到缓存中
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_DICT_MAP_LIST + InnerUtil.toJson(request), data, expiredTime - System.currentTimeMillis());

            return Single.just(CommonUtil.createSuccessResponseResult(data));
        };
    }
}
