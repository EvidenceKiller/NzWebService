package com.adl.service.persistence;

import android.text.TextUtils;

import com.adl.service.common.CommonUtil;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.DictEntity;
import com.adl.service.db.entity.PlanEntity;
import com.adl.service.db.entity.SportMeetEntity;
import com.adl.service.db.entity.SportMeetGroupDetailEntity;
import com.adl.service.db.entity.SportMeetGroupTeamEntity;
import com.adl.service.exception.NzEmptyDataException;
import com.adl.service.web.request.SportMeetPageRequest;
import com.adl.service.web.response.BasePageData;
import com.adl.service.web.response.BaseResponse;
import com.adl.service.web.response.DictData;
import com.adl.service.web.response.SportMeetData;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonInfoPersistenceHelper {

    private CommonInfoPersistenceHelper() {
    }

    public static Function<Void, Completable> createDictListPreparer(String dictCode) {
        return (v) -> {
            if (TextUtils.isEmpty(dictCode)) {
                DaoManagerProxy.getInstance().getDictDao().clearAll();
            } else {
                DaoManagerProxy.getInstance().getDictDao().clearByDictCode(dictCode);
            }
            return Completable.complete();
        };
    }

    public static Function<List<DictData>, Completable> createDictListPersister() {
        return (dataList) -> {
            if (dataList == null || dataList.isEmpty()) {
                return Completable.error(new NzEmptyDataException("dict data is empty"));
            }
            List<DictEntity> entityList = dataList.stream()
                    .map(data -> DictEntity.convertToEntity(data))
                    .collect(Collectors.toList());
            DaoManagerProxy.getInstance().getDictDao().insertAll(entityList);
            return Completable.complete();
        };
    }
}
