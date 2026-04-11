package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.CheckStudentInPlanRequest;
import com.adl.service.web.request.PlanClassListRequest;
import com.adl.service.web.request.PlanListRequest;
import com.adl.service.web.request.PlanStudentPageRequest;
import com.adl.service.web.request.RecordDetailPageRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.StandardConfigPageRequest;
import com.adl.service.web.response.BasePageData;
import com.adl.service.web.response.PlanClassData;
import com.adl.service.web.response.PlanInfoData;
import com.adl.service.web.response.PlanData;
import com.adl.service.web.response.PlanStudentData;
import com.adl.service.web.response.RecordDetailData;
import com.adl.service.web.response.StandardConfigPageData;

import java.util.List;

/**
 * OrgTestCaller。
 */
public interface OrgTestCaller {

    long getStandardConfigPageAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigPageData>> callback);

    List<StandardConfigPageData> getStandardConfigPageSync(StandardConfigPageRequest request) throws NzBaseException;

    long getRecordDetailPageAsync(RequestScope scope, RecordDetailPageRequest request, RequestCallback<BasePageData<RecordDetailData>> callback);

    BasePageData<RecordDetailData> getRecordDetailPageSync(RecordDetailPageRequest request) throws NzBaseException;

    long getPlanStudentPageAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<BasePageData<PlanStudentData>> callback);

    BasePageData<PlanStudentData> getPlanStudentPageSync(PlanStudentPageRequest request) throws NzBaseException;

    long getPlanPageAsync(RequestScope scope, PlanListRequest request, RequestCallback<BasePageData<PlanData>> callback);

    BasePageData<PlanData> getPlanPageSync(PlanListRequest request) throws NzBaseException;

    long getPlanInfoAsync(RequestScope scope, RequestCallback<PlanInfoData> callback);

    PlanInfoData getPlanInfoSync() throws NzBaseException;

    long getPlanClassListAsync(RequestScope scope, PlanClassListRequest request, RequestCallback<List<PlanClassData>> callback);

    List<PlanClassData> getPlanClassListSync(PlanClassListRequest request) throws NzBaseException;

    long checkStudentInPlanAsync(RequestScope scope, CheckStudentInPlanRequest request, RequestCallback<Boolean> callback);

    Boolean checkStudentInPlanSync(CheckStudentInPlanRequest request) throws NzBaseException;

}
