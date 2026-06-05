package com.adl.service.repository;

import com.adl.service.data.LoginInfoData;
import com.adl.service.repository.persist.CommonDaoPersistHelper;
import com.adl.service.repository.persist.PlanDaoPersistHelper;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class CommonDaoRepository {
    private final CommonDaoPersistHelper persistHelper = new CommonDaoPersistHelper();

    private static volatile CommonDaoRepository instance;

    private CommonDaoRepository() {
    }

    public static CommonDaoRepository getInstance() {
        if (instance == null) {
            synchronized (CommonDaoRepository.class) {
                if (instance == null) {
                    instance = new CommonDaoRepository();
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
