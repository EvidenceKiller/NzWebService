package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.OrganizeTestCheckStudentRequest;
import com.adl.service.web.request.PlanClassListRequest;
import com.adl.service.web.request.PlanListRequest;
import com.adl.service.web.request.PlanStudentPageRequest;
import com.adl.service.web.request.RecordDetailPageRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.StandardConfigPageRequest;
import com.adl.service.web.response.OrganizeTestCheckStudentData;
import com.adl.service.web.response.PlanClassData;
import com.adl.service.web.response.PlanInfoData;
import com.adl.service.web.response.PlanPageData;
import com.adl.service.web.response.PlanStudentPageData;
import com.adl.service.web.response.RecordDetailPageData;
import com.adl.service.web.response.StandardConfigPageData;

import java.util.List;

/**
 * OrgTestCaller。
 */
public interface OrgTestCaller {

    long getStandardConfigPageAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigPageData>> callback);

    List<StandardConfigPageData> getStandardConfigPageSync(StandardConfigPageRequest request) throws NzBaseException;

    long getRecordDetailPageAsync(RequestScope scope, RecordDetailPageRequest request, RequestCallback<RecordDetailPageData> callback);

    RecordDetailPageData getRecordDetailPageSync(RecordDetailPageRequest request) throws NzBaseException;

    long getPlanStudentPageAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<PlanStudentPageData> callback);

    PlanStudentPageData getPlanStudentPageSync(PlanStudentPageRequest request) throws NzBaseException;

    long getPlanPageAsync(RequestScope scope, PlanListRequest request, RequestCallback<PlanPageData> callback);

    PlanPageData getPlanPageSync(PlanListRequest request) throws NzBaseException;

    long getPlanInfoAsync(RequestScope scope, RequestCallback<PlanInfoData> callback);

    PlanInfoData getPlanInfoSync() throws NzBaseException;

    long getPlanClassListAsync(RequestScope scope, PlanClassListRequest request, RequestCallback<List<PlanClassData>> callback);

    List<PlanClassData> getPlanClassListSync(PlanClassListRequest request) throws NzBaseException;

    long getCheckStudentAsync(RequestScope scope, OrganizeTestCheckStudentRequest request, RequestCallback<OrganizeTestCheckStudentData> callback);

    OrganizeTestCheckStudentData getCheckStudentSync(OrganizeTestCheckStudentRequest request) throws NzBaseException;

}
