package com.adl.service.repository;

import com.adl.service.data.ClassroomCompetitionRecordData;
import com.adl.service.data.SunshineRunningSportDetailData;
import com.adl.service.data.TeachCourseDetailData;
import com.adl.service.http.request.SunshineRunningCompetitionRecordPageRequest;
import com.adl.service.http.request.SunshineRunningSportDetailPageRequest;
import com.adl.service.http.request.TeachCourseButtonClickCountRequest;
import com.adl.service.http.request.TeachCourseDataDatesRequest;
import com.adl.service.http.request.TeachCourseRequest;
import com.adl.service.repository.fetch.BigScreenH5FetchHelper;
import com.adl.service.repository.persist.BigScreenH5PersistHelper;
import com.adl.service.repository.prepare.BigScreenH5PrepareHelper;

import java.util.List;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Single;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class BigScreenH5Repository {
    private final BigScreenH5PrepareHelper prepareHelper = new BigScreenH5PrepareHelper();
    private final BigScreenH5FetchHelper fetchHelper = new BigScreenH5FetchHelper();
    private final BigScreenH5PersistHelper persistHelper = new BigScreenH5PersistHelper();

    private static volatile BigScreenH5Repository instance;

    private BigScreenH5Repository() {
    }

    public static BigScreenH5Repository getInstance() {
        if (instance == null) {
            synchronized (BigScreenH5Repository.class) {
                if (instance == null) {
                    instance = new BigScreenH5Repository();
                }
            }
        }
        return instance;
    }

    public Single<List<TeachCourseDetailData>> getTeachCourseDetailList(TeachCourseRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetTeachCourseDetailListFunc());
    }

    public Single<List<String>> getTeachCourseDataDates(TeachCourseDataDatesRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetTeachCourseDataDatesFunc());
    }

    public Single<Integer> getTeachCourseTimes(TeachCourseRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetTeachCourseTimesFunc());
    }

    public Single<Boolean> getTeachCourseButtonClickable(TeachCourseButtonClickCountRequest request) {
        return BaseRepositoryUtil.repositoryAsSingle(request, fetchHelper.createGetTeachCourseButtonClickableFunc());
    }

    public Single<List<SunshineRunningSportDetailData>> getSunshineRunningSportDetailPage(SunshineRunningSportDetailPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetSunshineRunningSportDetailPageFunc());
    }

    public Single<List<ClassroomCompetitionRecordData>> getSunshineRunningCompetitionRecordPage(SunshineRunningCompetitionRecordPageRequest request) {
        return BaseRepositoryUtil.repositoryPageAsSingle(request, fetchHelper.createGetSunshineRunningCompetitionRecordPageFunc());
    }
}
