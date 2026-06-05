package com.adl.service.repository;

import com.adl.service.repository.persist.DownloadFileDaoPersistHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class DownloadFileDaoRepository {
    private final DownloadFileDaoPersistHelper persistHelper = new DownloadFileDaoPersistHelper();

    private static volatile DownloadFileDaoRepository instance;

    private DownloadFileDaoRepository() {
    }

    public static DownloadFileDaoRepository getInstance() {
        if (instance == null) {
            synchronized (DownloadFileDaoRepository.class) {
                if (instance == null) {
                    instance = new DownloadFileDaoRepository();
                }
            }
        }
        return instance;
    }

    public Single<Boolean> clearByUrls(List<String> urls) {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearByUrlsFunc(urls));
    }

    public Single<Boolean> clearStudentFace() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearStudentFaceFunc());
    }

    public Single<Boolean> clearTeacherFace() {
        return BaseRepositoryUtil.repositoryAsSingle(persistHelper.createClearTeacherFaceFunc());
    }
}
