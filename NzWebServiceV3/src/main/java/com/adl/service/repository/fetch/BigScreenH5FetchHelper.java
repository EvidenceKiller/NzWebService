package com.adl.service.repository.fetch;

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

    private final BigScreenH5Service bigScreenH5Service;

    public BigScreenH5FetchHelper() {
        this.bigScreenH5Service = RetrofitManager.getInstance().create(BigScreenH5Service.class);
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
    public Function<SunshineRunningSportDetailPageRequest, Single<List<SunshineRunningSportDetailData>>> createGetSunshineRunningSportDetailPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(
                bigScreenH5Service.getSunshineRunningSportDetailPage(request),
                (Class<List<SunshineRunningSportDetailData>>) (Class<?>) List.class
        );
    }

    @SuppressWarnings("unchecked")
    public Function<SunshineRunningCompetitionRecordPageRequest, Single<List<ClassroomCompetitionRecordData>>> createGetSunshineRunningCompetitionRecordPageFunc() {
        return (request) -> BaseFetchUtil.schedulePageResponse(
                bigScreenH5Service.getSunshineRunningCompetitionRecordPage(request),
                (Class<List<ClassroomCompetitionRecordData>>) (Class<?>) List.class
        );
    }
}
