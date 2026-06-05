package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.data.AccountRecordData;
import com.adl.service.data.OrgRecordData;
import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.ReportSportStudentCompetitionData;
import com.adl.service.data.ReportSportStudentData;
import com.adl.service.data.ReportSportStudentMeetData;
import com.adl.service.data.ReportSportStudentPlanData;
import com.adl.service.data.ReportSportStudentTrainData;
import com.adl.service.data.ReportSportTeacherData;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.AccountRecordPageRequest;
import com.adl.service.http.request.OrgRecordPageRequest;
import com.adl.service.http.request.RequestScope;

import java.util.List;

/**
 * SportInfoCaller。
 */
public interface SportInfoCaller {

    /**
     * 通用修改学生运动成绩
     * <p>异步调用。</p>
     */
    long updateStudentSportAsync(RequestScope scope, ReportSportStudentAllData request, RequestCallback<Boolean> callback);

    /**
     * 通用修改学生运动成绩
     * <p>同步调用。</p>
     */
    Boolean updateStudentSportSync(ReportSportStudentAllData request);

    /**
     * 上报教师普通运动成绩
     * <p>异步调用。</p>
     */
    long reportTeacherSportAsync(RequestScope scope, ReportSportTeacherData request, RequestCallback<Boolean> callback);

    /**
     * 上报教师普通运动成绩
     * <p>同步调用。</p>
     */
    Boolean reportTeacherSportSync(ReportSportTeacherData request);

    /**
     * 上报学生特训成绩
     * <p>异步调用。</p>
     */
    long reportStudentTrainAsync(RequestScope scope, ReportSportStudentTrainData request, RequestCallback<Boolean> callback);

    /**
     * 上报学生特训成绩
     * <p>同步调用。</p>
     */
    Boolean reportStudentTrainSync(ReportSportStudentTrainData request);

    /**
     * 上报学生普通运动成绩
     * <p>异步调用。</p>
     */
    long reportStudentSportAsync(RequestScope scope, ReportSportStudentData request, RequestCallback<Boolean> callback);

    /**
     * 上报学生普通运动成绩
     * <p>同步调用。</p>
     */
    Boolean reportStudentSportSync(ReportSportStudentData request);

    /**
     * 上报学生组织测试成绩
     * <p>异步调用。</p>
     */
    long reportStudentPlanAsync(RequestScope scope, ReportSportStudentPlanData request, RequestCallback<Boolean> callback);

    /**
     * 上报学生组织测试成绩
     * <p>同步调用。</p>
     */
    Boolean reportStudentPlanSync(ReportSportStudentPlanData request);

    /**
     * 上报学生运动会成绩
     * <p>异步调用。</p>
     */
    long reportStudentMeetAsync(RequestScope scope, ReportSportStudentMeetData request, RequestCallback<Boolean> callback);

    /**
     * 上报学生运动会成绩
     * <p>同步调用。</p>
     */
    Boolean reportStudentMeetSync(ReportSportStudentMeetData request);

    /**
     * 上报学生竞技赛成绩
     * <p>异步调用。</p>
     */
    long reportStudentCompetitionAsync(RequestScope scope, ReportSportStudentCompetitionData request, RequestCallback<Boolean> callback);

    /**
     * 上报学生竞技赛成绩
     * <p>同步调用。</p>
     */
    Boolean reportStudentCompetitionSync(ReportSportStudentCompetitionData request);

    /**
     * 通用上报学生运动成绩接口
     * <p>异步调用。</p>
     */
    long reportStudentAllSportAsync(RequestScope scope, ReportSportStudentAllData request, RequestCallback<Boolean> callback);

    /**
     * 通用上报学生运动成绩接口
     * <p>同步调用。</p>
     */
    Boolean reportStudentAllSportSync(ReportSportStudentAllData request);

    /**
     * 获取机构/年级运动记录分页
     * <p>异步调用。</p>
     */
    long getOrgRecordPageAsync(RequestScope scope, OrgRecordPageRequest request, RequestCallback<List<OrgRecordData>> callback);

    /**
     * 获取机构/年级运动记录分页
     * <p>同步调用。</p>
     */
    List<OrgRecordData> getOrgRecordPageSync(OrgRecordPageRequest request);

    /**
     * 获取班级/个人运动记录分页
     * <p>异步调用。</p>
     */
    long getAccountRecordPageAsync(RequestScope scope, AccountRecordPageRequest request, RequestCallback<List<AccountRecordData>> callback);

    /**
     * 获取班级/个人运动记录分页
     * <p>同步调用。</p>
     */
    List<AccountRecordData> getAccountRecordPageSync(AccountRecordPageRequest request);
}
