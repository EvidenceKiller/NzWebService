package com.adl.service.v3interface.out.impl;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.api.RxSdk;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.exception.NzBaseException;
import com.adl.service.v3interface.internal.RxCallbackScheduler;
import com.adl.service.v3interface.internal.SubscriptionManager;
import com.adl.service.v3interface.out.BigScreenH5Caller;
import com.adl.service.v3interface.request.SunshineRunningCompetitionRecordPageRequest;
import com.adl.service.v3interface.request.SunshineRunningSportDetailPageRequest;
import com.adl.service.v3interface.request.TeachCourseButtonClickCountRequest;
import com.adl.service.v3interface.request.TeachCourseDataDatesRequest;
import com.adl.service.v3interface.request.TeachCourseRequest;
import com.adl.service.v3interface.response.SunshineRunningCompetitionRecordPageData;
import com.adl.service.v3interface.response.SunshineRunningSportDetailPageData;
import com.adl.service.v3interface.response.TeachCourseDetailData;
import com.adl.service.v3interface.service.BigScreenH5Service;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * BigScreenH5Caller 实现（SDK 内部使用，通过 {@link RxSdk} 暴露）。
 */
public final class BigScreenH5CallerImpl implements BigScreenH5Caller {

    private final BigScreenH5Service bigScreenH5Service;

    public BigScreenH5CallerImpl(BigScreenH5Service bigScreenH5Service) {
        this.bigScreenH5Service = bigScreenH5Service;
    }

    @Override
    public long getTeachCourseDetailListAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<TeachCourseDetailData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenH5Service.getTeachCourseDetailList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public TeachCourseDetailData getTeachCourseDetailListSync(TeachCourseRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenH5Service.getTeachCourseDetailList(request));
    }

    @Override
    public long getTeachCourseDataDatesAsync(RequestScope scope, TeachCourseDataDatesRequest request, RequestCallback<List<String>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenH5Service.getTeachCourseDataDates(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<String> getTeachCourseDataDatesSync(TeachCourseDataDatesRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenH5Service.getTeachCourseDataDates(request));
    }

    @Override
    public long getTeachCourseTimesAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<Integer> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenH5Service.getTeachCourseTimes(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Integer getTeachCourseTimesSync(TeachCourseRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenH5Service.getTeachCourseTimes(request));
    }

    @Override
    public long getTeachCourseButtonClickCountAsync(RequestScope scope, TeachCourseButtonClickCountRequest request, RequestCallback<Boolean> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenH5Service.getTeachCourseButtonClickCount(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Boolean getTeachCourseButtonClickCountSync(TeachCourseButtonClickCountRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenH5Service.getTeachCourseButtonClickCount(request));
    }

    @Override
    public long getSunshineRunningSportDetailPageAsync(RequestScope scope, SunshineRunningSportDetailPageRequest request, RequestCallback<SunshineRunningSportDetailPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenH5Service.getSunshineRunningSportDetailPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public SunshineRunningSportDetailPageData getSunshineRunningSportDetailPageSync(SunshineRunningSportDetailPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenH5Service.getSunshineRunningSportDetailPage(request));
    }

    @Override
    public long getSunshineRunningCompetitionRecordPageAsync(RequestScope scope, SunshineRunningCompetitionRecordPageRequest request, RequestCallback<SunshineRunningCompetitionRecordPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(bigScreenH5Service.getSunshineRunningCompetitionRecordPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public SunshineRunningCompetitionRecordPageData getSunshineRunningCompetitionRecordPageSync(SunshineRunningCompetitionRecordPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(bigScreenH5Service.getSunshineRunningCompetitionRecordPage(request));
    }
}
