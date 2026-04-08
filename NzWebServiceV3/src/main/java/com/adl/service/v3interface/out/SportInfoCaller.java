package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.request.AccountRecordPageRequest;
import com.adl.service.v3interface.request.OrgRecordPageRequest;
import com.adl.service.v3interface.request.ReportNfSportRequest;
import com.adl.service.v3interface.request.ReportStudentCompetitionRequest;
import com.adl.service.v3interface.request.ReportStudentMeetRequest;
import com.adl.service.v3interface.request.ReportStudentPlanRequest;
import com.adl.service.v3interface.request.ReportStudentSportRequest;
import com.adl.service.v3interface.request.ReportTeacherSportRequest;
import com.adl.service.v3interface.response.AccountRecordPageData;
import com.adl.service.v3interface.response.OrgRecordPageData;

/**
 * SportInfoCaller。
 */
public interface SportInfoCaller {

    long updateStudentSportAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean updateStudentSportSync(ReportStudentSportRequest request);

    long reportTeacherSportAsync(RequestScope scope, ReportTeacherSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportTeacherSportSync(ReportTeacherSportRequest request);

    long reportStudentTrainAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentTrainSync(ReportStudentSportRequest request);

    long reportStudentSportAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentSportSync(ReportStudentSportRequest request);

    long uploadStudentMeetAsync(RequestScope scope, ReportStudentMeetRequest request, RequestCallback<Boolean> callback);

    Boolean uploadStudentMeetSync(ReportStudentMeetRequest request);

    long reportStudentPlanAsync(RequestScope scope, ReportStudentPlanRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentPlanSync(ReportStudentPlanRequest request);

    long reportStudentMeetAsync(RequestScope scope, ReportStudentMeetRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentMeetSync(ReportStudentMeetRequest request);

    long reportStudentCompetitionAsync(RequestScope scope, ReportStudentCompetitionRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentCompetitionSync(ReportStudentCompetitionRequest request);

    long reportStudentAllSportAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentAllSportSync(ReportStudentSportRequest request);

    long reportNfSportAsync(RequestScope scope, ReportNfSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportNfSportSync(ReportNfSportRequest request);

    long getOrgRecordPageAsync(RequestScope scope, OrgRecordPageRequest request, RequestCallback<OrgRecordPageData> callback);

    OrgRecordPageData getOrgRecordPageSync(OrgRecordPageRequest request);

    long getAccountRecordPageAsync(RequestScope scope, AccountRecordPageRequest request, RequestCallback<AccountRecordPageData> callback);

    AccountRecordPageData getAccountRecordPageSync(AccountRecordPageRequest request);

}
