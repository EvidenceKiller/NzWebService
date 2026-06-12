package com.adl.service.caller;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.PageSummaryData;
import com.adl.service.callback.RequestCallback;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;
import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassPageRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.StandardConfigPageRequest;

import java.util.List;

/**
 * OrgTestCaller。
 */
public interface OrgTestCaller {

    void reLoadAllOrgTestDataSync(boolean syncStandard);

    long getStandardConfigPagesAllAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<PageSummaryData> callback);

    ResponseResult<PageSummaryData> getStandardConfigPagesAllSync(StandardConfigPageRequest request);

    /**
     * 获取标准列表
     * <p>异步调用。</p>
     */
    long getStandardConfigPageAsync(RequestScope scope, StandardConfigPageRequest request, RequestCallback<List<StandardConfigData>> callback);

    /**
     * 获取标准列表
     * <p>同步调用。</p>
     */
    ResponseResult<List<StandardConfigData>> getStandardConfigPageSync(StandardConfigPageRequest request);

    long getPlanStudentPagesAllAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<PageSummaryData> callback);

    ResponseResult<PageSummaryData> getPlanStudentPagesAllSync(PlanStudentPageRequest request);

    /**
     * 获取计划下学生
     * <p>异步调用。</p>
     */
    long getPlanStudentPageAsync(RequestScope scope, PlanStudentPageRequest request, RequestCallback<List<PlanStudentData>> callback);

    /**
     * 获取计划下学生
     * <p>同步调用。</p>
     */
    ResponseResult<List<PlanStudentData>> getPlanStudentPageSync(PlanStudentPageRequest request);

    /**
     * 获取所有的分页计划列表
     * <p>异步调用。</p>
     *
     * @param scope
     * @param request
     * @param callback
     * @return
     */
    long getPlanPagesAllAsync(RequestScope scope, PlanPageRequest request, RequestCallback<PageSummaryData> callback);

    /**
     * 获取所有的分页计划列表
     * <p>同步调用。</p>
     *
     * @param request
     * @return
     */
    ResponseResult<PageSummaryData> getPlanPagesAllSync(PlanPageRequest request);

    /**
     * 获取计划列表
     * <p>异步调用。</p>
     */
    long getPlanPageAsync(RequestScope scope, PlanPageRequest request, RequestCallback<List<PlanData>> callback);

    /**
     * 获取计划列表
     * <p>同步调用。</p>
     */
    ResponseResult<List<PlanData>> getPlanPageSync(PlanPageRequest request);

    /**
     * 获取组织测试计划详情
     * <p>异步调用。</p>
     */
    long getPlanInfoAsync(RequestScope scope, PlanInfoRequest request, RequestCallback<PlanInfoData> callback);

    /**
     * 获取组织测试计划详情
     * <p>同步调用。</p>
     */
    ResponseResult<PlanInfoData> getPlanInfoSync(PlanInfoRequest request);

    /**
     * 获取计划班级列表
     * <p>异步调用。</p>
     */
    long getPlanClassPageAsync(RequestScope scope, PlanClassPageRequest request, RequestCallback<List<PlanClassData>> callback);

    /**
     * 获取计划班级列表
     * <p>同步调用。</p>
     */
    ResponseResult<List<PlanClassData>> getPlanClassPageSync(PlanClassPageRequest request);

    /**
     * 查询学生是否在计划下
     * <p>异步调用。</p>
     */
    long checkStudentInPlanAsync(RequestScope scope, CheckStudentInPlanRequest request, RequestCallback<Boolean> callback);

    /**
     * 查询学生是否在计划下
     * <p>同步调用。</p>
     */
    ResponseResult<Boolean> checkStudentInPlanSync(CheckStudentInPlanRequest request);

}
