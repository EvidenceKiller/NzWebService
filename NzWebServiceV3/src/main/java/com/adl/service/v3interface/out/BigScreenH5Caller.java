package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.request.SunshineRunningCompetitionRecordPageRequest;
import com.adl.service.v3interface.request.SunshineRunningSportDetailPageRequest;
import com.adl.service.v3interface.request.TeachCourseButtonClickCountRequest;
import com.adl.service.v3interface.request.TeachCourseDataDatesRequest;
import com.adl.service.v3interface.request.TeachCourseRequest;
import com.adl.service.v3interface.response.SunshineRunningCompetitionRecordPageData;
import com.adl.service.v3interface.response.SunshineRunningSportDetailPageData;
import com.adl.service.v3interface.response.TeachCourseDetailData;

import java.util.List;

/**
 * BigScreenH5Caller。
 */
public interface BigScreenH5Caller {

    long getTeachCourseDetailListAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<TeachCourseDetailData> callback);

    TeachCourseDetailData getTeachCourseDetailListSync(TeachCourseRequest request);

    long getTeachCourseDataDatesAsync(RequestScope scope, TeachCourseDataDatesRequest request, RequestCallback<List<String>> callback);

    List<String> getTeachCourseDataDatesSync(TeachCourseDataDatesRequest request);

    long getTeachCourseTimesAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<Integer> callback);

    Integer getTeachCourseTimesSync(TeachCourseRequest request);

    long getTeachCourseButtonClickCountAsync(RequestScope scope, TeachCourseButtonClickCountRequest request, RequestCallback<Boolean> callback);

    Boolean getTeachCourseButtonClickCountSync(TeachCourseButtonClickCountRequest request);

    long getSunshineRunningSportDetailPageAsync(RequestScope scope, SunshineRunningSportDetailPageRequest request, RequestCallback<SunshineRunningSportDetailPageData> callback);

    SunshineRunningSportDetailPageData getSunshineRunningSportDetailPageSync(SunshineRunningSportDetailPageRequest request);

    long getSunshineRunningCompetitionRecordPageAsync(RequestScope scope, SunshineRunningCompetitionRecordPageRequest request, RequestCallback<SunshineRunningCompetitionRecordPageData> callback);

    SunshineRunningCompetitionRecordPageData getSunshineRunningCompetitionRecordPageSync(SunshineRunningCompetitionRecordPageRequest request);

}
