package com.adl.service.repository.persist;

import com.adl.service.data.LoginInfoData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.db.entity.LoginInfoEntity;
import com.adl.service.exception.NzCommonException;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class CommonDaoPersistHelper {

    public CommonDaoPersistHelper() {
    }

    public Function<Void, Single<String>> createQueryDictLabelFunc(String dictCode, String dictValue) {
        return (v) -> {
            String label = DaoManagerProxy.getInstance().getDictDao().queryDictLabel(dictCode, dictValue);
            if (label == null) {
                return Single.error(new NzCommonException("dict label not found"));
            } else {
                return Single.just(label);
            }
        };
    }

    public Function<Void, Single<LoginInfoData>> createGetLoginInfoFunc() {
        return (v) -> {
            LoginInfoEntity entity = DaoManagerProxy.getInstance().getLoginInfoDao().getLoginInfo();
            if (entity == null) {
                return Single.error(new NzCommonException("login info data is null"));
            } else {
                return Single.just(LoginInfoEntity.convertToData(entity));
            }
        };
    }
}
