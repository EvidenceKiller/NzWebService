package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.AccountRecordPageRequest;
import com.adl.service.web.request.OrgRecordPageRequest;
import com.adl.service.web.request.ReportNfSportRequest;
import com.adl.service.web.request.ReportStudentCompetitionRequest;
import com.adl.service.web.request.ReportStudentMeetRequest;
import com.adl.service.web.request.ReportStudentPlanRequest;
import com.adl.service.web.request.ReportStudentSportRequest;
import com.adl.service.web.request.ReportTeacherSportRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.response.AccountRecordPageData;
import com.adl.service.web.response.OrgRecordPageData;

/**
 * SportInfoCaller。
 */
public interface SportInfoCaller {

    long updateStudentSportAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean updateStudentSportSync(ReportStudentSportRequest request) throws NzBaseException;

    long reportTeacherSportAsync(RequestScope scope, ReportTeacherSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportTeacherSportSync(ReportTeacherSportRequest request) throws NzBaseException;

    long reportStudentTrainAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentTrainSync(ReportStudentSportRequest request) throws NzBaseException;

    long reportStudentSportAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentSportSync(ReportStudentSportRequest request) throws NzBaseException;

    long uploadStudentMeetAsync(RequestScope scope, ReportStudentMeetRequest request, RequestCallback<Boolean> callback);

    Boolean uploadStudentMeetSync(ReportStudentMeetRequest request) throws NzBaseException;

    long reportStudentPlanAsync(RequestScope scope, ReportStudentPlanRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentPlanSync(ReportStudentPlanRequest request) throws NzBaseException;

    long reportStudentMeetAsync(RequestScope scope, ReportStudentMeetRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentMeetSync(ReportStudentMeetRequest request) throws NzBaseException;

    long reportStudentCompetitionAsync(RequestScope scope, ReportStudentCompetitionRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentCompetitionSync(ReportStudentCompetitionRequest request) throws NzBaseException;

    long reportStudentAllSportAsync(RequestScope scope, ReportStudentSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportStudentAllSportSync(ReportStudentSportRequest request) throws NzBaseException;

    long reportNfSportAsync(RequestScope scope, ReportNfSportRequest request, RequestCallback<Boolean> callback);

    Boolean reportNfSportSync(ReportNfSportRequest request) throws NzBaseException;

    long getOrgRecordPageAsync(RequestScope scope, OrgRecordPageRequest request, RequestCallback<OrgRecordPageData> callback);

    OrgRecordPageData getOrgRecordPageSync(OrgRecordPageRequest request) throws NzBaseException;

    long getAccountRecordPageAsync(RequestScope scope, AccountRecordPageRequest request, RequestCallback<AccountRecordPageData> callback);

    AccountRecordPageData getAccountRecordPageSync(AccountRecordPageRequest request) throws NzBaseException;

}
