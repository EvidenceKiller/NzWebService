package com.adl.service.repository.prepare;

import android.text.TextUtils;
import android.util.Log;

import com.adl.service.data.DictMapData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.DictEntity;
import com.adl.service.db.entity.DictMapEntity;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.utils.InnerUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class OperationPrepareHelper {

    public OperationPrepareHelper() {
    }

    public Function<SceneListRequest, Single<List<SceneData>>> createGetSceneListPrepareFunc() {
        return (request) -> {
            return null;
        };
    }

    public static Function<SportSkuPageRequest, Single<List<SportSkuData>>> createGetSportSkuPagesAllFunc() {
        return (requestu) -> {
            DaoManagerProxy.getInstance().getSceneSportDao().clearAll();
            return null;
        };
    }

    public Function<DictMapRequest, Single<List<DictMapData>>> createPrepareDictMapListFunc() {
        return (request) -> {
            if (TextUtils.isEmpty(request.getSportSkuId())) {
                Log.i("ZXN_TEST", "OperationPrepareHelper::createGetDictMapPrepareFunc : sportSkuId is empty");
                // 服务器逻辑sportSkuId为空，返回空列表，这里同样返回空列表
                return Single.just(Collections.EMPTY_LIST);
            }
            List<DictMapData> data = (List<DictMapData>) MemoryCacheManager.getInstance().get(CacheTag.CACHE_TAG_DICT_MAP_LIST + InnerUtil.toJson(request));
            if (data != null) {
                Log.i("ZXN_TEST", "OperationPrepareHelper::createGetDictMapPrepareFunc : 命中缓存 : " + data);
                return Single.just(data);
            }
            List<DictMapEntity> entities = DaoManagerProxy.getInstance().getDictMapDao().queryDictMapBySportSkuId(request.getSportSkuId());
            if (entities == null || entities.isEmpty()) {
                Log.w("ZXN_TEST", "OperationPrepareHelper::createGetDictMapPrepareFunc : 数据库数据为空");
                return null;
            }
            if (entities.get(0).getExpiredTime() < System.currentTimeMillis()) {
                Log.w("ZXN_TEST", "OperationPrepareHelper::createGetDictMapPrepareFunc : 数据库数据已过期");
                return null;
            }
            Log.w("ZXN_TEST", "OperationPrepareHelper::createGetDictMapPrepareFunc : 命中数据库 : " + entities);
            List<DictMapData> resultDataList = entities.stream()
                    .map(DictMapEntity::convertToData)
                    .collect(Collectors.toList());
            // 需要重新放到缓存中
            MemoryCacheManager.getInstance().put(CacheTag.CACHE_TAG_DICT_MAP_LIST + InnerUtil.toJson(request), resultDataList, CacheTag.CACHE_EXPIRED_TIME_DICT_MAP_LIST);

            return Single.just(resultDataList);
        };
    }
}
