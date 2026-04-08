package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.request.OrganizeTestCheckStudentRequest;
import com.adl.service.v3interface.request.PlanClassListRequest;
import com.adl.service.v3interface.request.PlanListRequest;
import com.adl.service.v3interface.request.PlanStudentPageRequest;
import com.adl.service.v3interface.request.RecordDetailPageRequest;
import com.adl.service.v3interface.request.StandardConfigPageRequest;
import com.adl.service.v3interface.response.OrganizeTestCheckStudentData;
import com.adl.service.v3interface.response.PlanClassData;
import com.adl.service.v3interface.response.PlanInfoData;
import com.adl.service.v3interface.response.PlanPageData;
import com.adl.service.v3interface.response.PlanStudentPageData;
import com.adl.service.v3interface.response.RecordDetailPageData;
import com.adl.service.v3interface.response.StandardConfigPageData;

import java.util.List;

/**
 * OrgTestCaller。
 */
public interface OrgTestCaller {

    long getStandardConfigPageAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigPageData>> callback);

    List<StandardConfigPageData> getStandardConfigPageSync(StandardConfigPageRequest request);

    long getRecordDetailPageAsync(RequestScope scope, RecordDetailPageRequest request, RequestCallback<RecordDetailPageData> callback);

    RecordDetailPageData getRecordDetailPageSync(RecordDetailPageRequest request);

    long getPlanStudentPageAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<PlanStudentPageData> callback);

    PlanStudentPageData getPlanStudentPageSync(PlanStudentPageRequest request);

    long getPlanPageAsync(RequestScope scope, PlanListRequest request, RequestCallback<PlanPageData> callback);

    PlanPageData getPlanPageSync(PlanListRequest request);

    long getPlanInfoAsync(RequestScope scope, RequestCallback<PlanInfoData> callback);

    PlanInfoData getPlanInfoSync();

    long getPlanClassListAsync(RequestScope scope, PlanClassListRequest request, RequestCallback<List<PlanClassData>> callback);

    List<PlanClassData> getPlanClassListSync(PlanClassListRequest request);

    long getCheckStudentAsync(RequestScope scope, OrganizeTestCheckStudentRequest request, RequestCallback<OrganizeTestCheckStudentData> callback);

    OrganizeTestCheckStudentData getCheckStudentSync(OrganizeTestCheckStudentRequest request);

}
