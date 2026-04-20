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

    private final BigScreenH5Service bigScreenH5Service;

    public BigScreenH5FetchHelper() {
        this.bigScreenH5Service = RetrofitManager.getInstance().create(BigScreenH5Service.class);
    }

    public Function<TeachCourseRequest, Single<List<TeachCourseDetailData>>> createGetTeachCourseDetailListFunc() {
        return (request) -> bigScreenH5Service.getTeachCourseDetailList(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<TeachCourseDataDatesRequest, Single<List<String>>> createGetTeachCourseDataDatesFunc() {
        return (request) -> bigScreenH5Service.getTeachCourseDataDates(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<TeachCourseRequest, Single<Integer>> createGetTeachCourseTimesFunc() {
        return (request) -> bigScreenH5Service.getTeachCourseTimes(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<TeachCourseButtonClickCountRequest, Single<Boolean>> createGetTeachCourseButtonClickableFunc() {
        return (request) -> bigScreenH5Service.getTeachCourseButtonClickable(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<SunshineRunningSportDetailPageRequest, Single<BasePageData<SunshineRunningSportDetailData>>> createGetSunshineRunningSportDetailPageFunc() {
        return (request) -> bigScreenH5Service.getSunshineRunningSportDetailPage(request).map(BaseFetchUtil::scheduleResponse);
    }

    public Function<SunshineRunningCompetitionRecordPageRequest, Single<BasePageData<ClassroomCompetitionRecordData>>> createGetSunshineRunningCompetitionRecordPageFunc() {
        return (request) -> bigScreenH5Service.getSunshineRunningCompetitionRecordPage(request).map(BaseFetchUtil::scheduleResponse);
    }
}
