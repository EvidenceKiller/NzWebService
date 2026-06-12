package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.caller.BigScreenH5Caller;
import com.adl.service.data.ClassroomCompetitionRecordData;
import com.adl.service.data.SunshineRunningSportDetailData;
import com.adl.service.data.TeachCourseDetailData;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.SunshineRunningCompetitionRecordPageRequest;
import com.adl.service.http.request.SunshineRunningSportDetailPageRequest;
import com.adl.service.http.request.TeachCourseButtonClickCountRequest;
import com.adl.service.http.request.TeachCourseDataDatesRequest;
import com.adl.service.http.request.TeachCourseRequest;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.BigScreenH5Repository;

import java.util.List;

/**
 * BigScreenH5Caller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class BigScreenH5CallerImpl implements BigScreenH5Caller {

    private final BigScreenH5Repository bigScreenH5Repository;

    public BigScreenH5CallerImpl() {
        this.bigScreenH5Repository = BigScreenH5Repository.getInstance();
    }

    @Override
    public long getTeachCourseDetailListAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<List<TeachCourseDetailData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, bigScreenH5Repository.getTeachCourseDetailList(request), callback);
    }

    @Override
    public ResponseResult<List<TeachCourseDetailData>> getTeachCourseDetailListSync(TeachCourseRequest request) {
        return RxCallbackScheduler.scheduleResultSync(bigScreenH5Repository.getTeachCourseDetailList(request));
    }

    @Override
    public long getTeachCourseDataDatesAsync(RequestScope scope, TeachCourseDataDatesRequest request, RequestCallback<List<String>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, bigScreenH5Repository.getTeachCourseDataDates(request), callback);
    }

    @Override
    public ResponseResult<List<String>> getTeachCourseDataDatesSync(TeachCourseDataDatesRequest request) {
        return RxCallbackScheduler.scheduleResultSync(bigScreenH5Repository.getTeachCourseDataDates(request));
    }

    @Override
    public long getTeachCourseTimesAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<Integer> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, bigScreenH5Repository.getTeachCourseTimes(request), callback);
    }

    @Override
    public ResponseResult<Integer> getTeachCourseTimesSync(TeachCourseRequest request) {
        return RxCallbackScheduler.scheduleResultSync(bigScreenH5Repository.getTeachCourseTimes(request));
    }

    @Override
    public long getTeachCourseButtonClickableAsync(RequestScope scope, TeachCourseButtonClickCountRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, bigScreenH5Repository.getTeachCourseButtonClickable(request), callback);
    }

    @Override
    public ResponseResult<Boolean> getTeachCourseButtonClickableSync(TeachCourseButtonClickCountRequest request) {
        return RxCallbackScheduler.scheduleResultSync(bigScreenH5Repository.getTeachCourseButtonClickable(request));
    }

    @Override
    public long getSunshineRunningSportDetailPageAsync(RequestScope scope, SunshineRunningSportDetailPageRequest request, RequestCallback<List<SunshineRunningSportDetailData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, bigScreenH5Repository.getSunshineRunningSportDetailPage(request), callback);
    }

    @Override
    public ResponseResult<List<SunshineRunningSportDetailData>> getSunshineRunningSportDetailPageSync(SunshineRunningSportDetailPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(bigScreenH5Repository.getSunshineRunningSportDetailPage(request));
    }

    @Override
    public long getSunshineRunningCompetitionRecordPageAsync(RequestScope scope, SunshineRunningCompetitionRecordPageRequest request, RequestCallback<List<ClassroomCompetitionRecordData>> callback) {
        return RxCallbackScheduler.scheduleResultAsync(scope, bigScreenH5Repository.getSunshineRunningCompetitionRecordPage(request), callback);
    }

    @Override
    public ResponseResult<List<ClassroomCompetitionRecordData>> getSunshineRunningCompetitionRecordPageSync(SunshineRunningCompetitionRecordPageRequest request) {
        return RxCallbackScheduler.scheduleResultSync(bigScreenH5Repository.getSunshineRunningCompetitionRecordPage(request));
    }
}
