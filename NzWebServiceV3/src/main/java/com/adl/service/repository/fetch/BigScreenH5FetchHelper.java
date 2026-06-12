package com.adl.service.repository.fetch;

import android.text.TextUtils;

import com.adl.service.callback.ResponseResult;
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
import com.adl.service.web.OperationService;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class BigScreenH5FetchHelper {

    private volatile BigScreenH5Service bigScreenH5Service;
    private volatile String baseUrl;

    public BigScreenH5FetchHelper() {
    }

    private synchronized BigScreenH5Service getService() {
        if (bigScreenH5Service == null || !TextUtils.equals(baseUrl, RetrofitManager.getInstance().getBaseUrl())) {
            baseUrl = RetrofitManager.getInstance().getBaseUrl();
            bigScreenH5Service = RetrofitManager.getInstance().create(BigScreenH5Service.class);
        }
        return bigScreenH5Service;
    }

    public Function<TeachCourseRequest, Single<ResponseResult<List<TeachCourseDetailData>>>> createGetTeachCourseDetailListFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTeachCourseDetailList(request));
    }

    public Function<TeachCourseDataDatesRequest, Single<ResponseResult<List<String>>>> createGetTeachCourseDataDatesFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTeachCourseDataDates(request));
    }

    public Function<TeachCourseRequest, Single<ResponseResult<Integer>>> createGetTeachCourseTimesFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTeachCourseTimes(request));
    }

    public Function<TeachCourseButtonClickCountRequest, Single<ResponseResult<Boolean>>> createGetTeachCourseButtonClickableFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getTeachCourseButtonClickable(request));
    }

    public Function<SunshineRunningSportDetailPageRequest, Single<ResponseResult<BasePageData<SunshineRunningSportDetailData>>>> createGetSunshineRunningSportDetailPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSunshineRunningSportDetailPage(request));
    }

    public Function<SunshineRunningCompetitionRecordPageRequest, Single<ResponseResult<BasePageData<ClassroomCompetitionRecordData>>>> createGetSunshineRunningCompetitionRecordPageFunc() {
        return (request) -> BaseFetchUtil.scheduleResponse(getService().getSunshineRunningCompetitionRecordPage(request));
    }
}
