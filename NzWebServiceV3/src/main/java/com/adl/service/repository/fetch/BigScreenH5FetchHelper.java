package com.adl.service.repository.fetch;

import com.adl.service.data.BasePageData;
import com.adl.service.data.ClassroomCompetitionRecordData;
import com.adl.service.data.SunshineRunningSportDetailData;
import com.adl.service.data.TeachCourseDetailData;
import com.adl.service.http.request.SunshineRunningCompetitionRecordPageRequest;
import com.adl.service.http.request.SunshineRunningSportDetailPageRequest;
import com.adl.service.http.request.TeachCourseButtonClickCountRequest;
import com.adl.service.http.request.TeachCourseDataDatesRequest;
import com.adl.service.http.request.TeachCourseRequest;
import com.adl.service.internal.RetrofitManager;
import com.adl.service.web.BigScreenH5Service;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class BigScreenH5FetchHelper {

    private static volatile BigScreenH5FetchHelper instance;

    private final BigScreenH5Service bigScreenH5Service;

    private BigScreenH5FetchHelper() {
        this.bigScreenH5Service = RetrofitManager.getInstance().create(BigScreenH5Service.class);
    }

    public static BigScreenH5FetchHelper getInstance() {
        if (instance == null) {
            synchronized (BigScreenH5FetchHelper.class) {
                if (instance == null) {
                    instance = new BigScreenH5FetchHelper();
                }
            }
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public Function<TeachCourseRequest, Single<List<TeachCourseDetailData>>> createGetTeachCourseDetailListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(
                bigScreenH5Service.getTeachCourseDetailList(request),
                (Class<List<TeachCourseDetailData>>) (Class<?>) List.class
        );
    }

    @SuppressWarnings("unchecked")
    public Function<TeachCourseDataDatesRequest, Single<List<String>>> createGetTeachCourseDataDatesFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(
                bigScreenH5Service.getTeachCourseDataDates(request),
                (Class<List<String>>) (Class<?>) List.class
        );
    }

    public Function<TeachCourseRequest, Single<Integer>> createGetTeachCourseTimesFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenH5Service.getTeachCourseTimes(request), Integer.class);
    }

    public Function<TeachCourseButtonClickCountRequest, Single<Boolean>> createGetTeachCourseButtonClickableFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(bigScreenH5Service.getTeachCourseButtonClickable(request), Boolean.class);
    }

    @SuppressWarnings("unchecked")
    public Function<SunshineRunningSportDetailPageRequest, Single<BasePageData<SunshineRunningSportDetailData>>> createGetSunshineRunningSportDetailPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(
                bigScreenH5Service.getSunshineRunningSportDetailPage(request),
                (Class<BasePageData<SunshineRunningSportDetailData>>) (Class<?>) BasePageData.class
        );
    }

    @SuppressWarnings("unchecked")
    public Function<SunshineRunningCompetitionRecordPageRequest, Single<BasePageData<ClassroomCompetitionRecordData>>> createGetSunshineRunningCompetitionRecordPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(
                bigScreenH5Service.getSunshineRunningCompetitionRecordPage(request),
                (Class<BasePageData<ClassroomCompetitionRecordData>>) (Class<?>) BasePageData.class
        );
    }
}
