package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.SunshineRunningCompetitionRecordPageRequest;
import com.adl.service.web.request.SunshineRunningSportDetailPageRequest;
import com.adl.service.web.request.TeachCourseButtonClickCountRequest;
import com.adl.service.web.request.TeachCourseDataDatesRequest;
import com.adl.service.web.request.TeachCourseRequest;
import com.adl.service.web.response.BasePageData;
import com.adl.service.web.response.ClassroomCompetitionRecordData;
import com.adl.service.web.response.SunshineRunningSportDetailData;
import com.adl.service.web.response.TeachCourseDetailData;

import java.util.List;

/**
 * BigScreenH5Caller。
 */
public interface BigScreenH5Caller {

    long getTeachCourseDetailListAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<List<TeachCourseDetailData>> callback);

    List<TeachCourseDetailData> getTeachCourseDetailListSync(TeachCourseRequest request) throws NzBaseException;

    long getTeachCourseDataDatesAsync(RequestScope scope, TeachCourseDataDatesRequest request, RequestCallback<List<String>> callback);

    List<String> getTeachCourseDataDatesSync(TeachCourseDataDatesRequest request) throws NzBaseException;

    long getTeachCourseTimesAsync(RequestScope scope, TeachCourseRequest request, RequestCallback<Integer> callback);

    Integer getTeachCourseTimesSync(TeachCourseRequest request) throws NzBaseException;

    long getTeachCourseButtonClickCountAsync(RequestScope scope, TeachCourseButtonClickCountRequest request, RequestCallback<Boolean> callback);

    Boolean getTeachCourseButtonClickCountSync(TeachCourseButtonClickCountRequest request) throws NzBaseException;

    long getSunshineRunningSportDetailPageAsync(RequestScope scope, SunshineRunningSportDetailPageRequest request, RequestCallback<BasePageData<SunshineRunningSportDetailData>> callback);

    BasePageData<SunshineRunningSportDetailData> getSunshineRunningSportDetailPageSync(SunshineRunningSportDetailPageRequest request) throws NzBaseException;

    long getSunshineRunningCompetitionRecordPageAsync(RequestScope scope, SunshineRunningCompetitionRecordPageRequest request, RequestCallback<BasePageData<ClassroomCompetitionRecordData>> callback);

    BasePageData<ClassroomCompetitionRecordData> getSunshineRunningCompetitionRecordPageSync(SunshineRunningCompetitionRecordPageRequest request) throws NzBaseException;

}
