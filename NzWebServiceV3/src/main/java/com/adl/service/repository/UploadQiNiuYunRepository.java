package com.adl.service.repository;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.AdlConfigService;
import com.adl.service.exception.NzCommonException;
import com.adl.service.http.request.QiNiuYunTokenRequest;
import com.adl.service.repository.fetch.UploadQiNiuYunFetchHelper;
import com.adl.service.repository.persist.UploadQiNiuYunPersistHelper;
import com.adl.service.repository.prepare.UploadQiNiuYunPrepareHelper;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class UploadQiNiuYunRepository {
    private final UploadQiNiuYunPrepareHelper prepareHelper = new UploadQiNiuYunPrepareHelper();
    private final UploadQiNiuYunFetchHelper fetchHelper = new UploadQiNiuYunFetchHelper();
    private final UploadQiNiuYunPersistHelper persistHelper = new UploadQiNiuYunPersistHelper();

    private static volatile UploadQiNiuYunRepository instance;

    private UploadQiNiuYunRepository() {
    }

    public static UploadQiNiuYunRepository getInstance() {
        if (instance == null) {
            synchronized (UploadQiNiuYunRepository.class) {
                if (instance == null) {
                    instance = new UploadQiNiuYunRepository();
                }
            }
        }
        return instance;
    }

    public Single<ResponseResult<String>> getQiNiuYunToken(QiNiuYunTokenRequest request) {
        if (AdlConfigService.getAdlConfig() == null) {
            return Single.error(new NzCommonException("AdlConfig is null"));
        }
        String url = AdlConfigService.getAdlConfig().getQiNiuHost() + "/uc/oss/v1/qiniu/token";
        return BaseRepositoryUtil.repositoryAsSingle(request, prepareHelper.createPrepareQiNiuYunTokenFunc(),
                fetchHelper.createGetQiNiuYunTokenFunc(url), persistHelper.createPersistQiNiuYunTokenFunc(request));
    }

}
