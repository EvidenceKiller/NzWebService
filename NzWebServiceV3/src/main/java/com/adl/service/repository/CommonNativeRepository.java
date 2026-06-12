package com.adl.service.repository;

import com.adl.service.data.LoginInfoData;
import com.adl.service.repository.persist.CommonNativePersistHelper;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class CommonNativeRepository {
    private final CommonNativePersistHelper persistHelper = new CommonNativePersistHelper();

    private static volatile CommonNativeRepository instance;

    private CommonNativeRepository() {
    }

    public static CommonNativeRepository getInstance() {
        if (instance == null) {
            synchronized (CommonNativeRepository.class) {
                if (instance == null) {
                    instance = new CommonNativeRepository();
                }
            }
        }
        return instance;
    }

    public Single<String> queryDictLabel(String dictCode, String dictValue) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createQueryDictLabelFunc(dictCode, dictValue));
    }

    public Single<LoginInfoData> getLoginInfo() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createGetLoginInfoFunc());
    }
}
