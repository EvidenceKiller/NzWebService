package com.adl.service.web;

import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassPageRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.StandardConfigPageRequest;
import com.adl.service.data.BasePageData;
import com.adl.service.data.BaseResponse;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.StandardConfigData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface OrgTestService {
    /**
     * 获取标准列表
     */
    @POST("v3/gateway/api/tis/device/pte/organizeTest/getStandardConfig")
    Single<BaseResponse<List<StandardConfigData>>> getStandardConfigPage(@Body StandardConfigPageRequest request);

    /**
     * 获取计划下学生
     */
    @POST("v3/gateway/api/tis/device/pte/organizeTest/getPlanStudents")
    Single<BaseResponse<BasePageData<PlanStudentData>>> getPlanStudentPage(@Body PlanStudentPageRequest request);

    /**
     * 获取计划列表
     */
    @POST("v3/gateway/api/tis/device/pte/organizeTest/getPlanList")
    Single<BaseResponse<BasePageData<PlanData>>> getPlanPage(@Body PlanPageRequest request);

    /**
     * 获取组织测试计划详情
     */
    @POST("v3/gateway/api/tis/device/pte/organizeTest/getPlanInfo")
    Single<BaseResponse<PlanInfoData>> getPlanInfo(@Body PlanInfoRequest request);

    /**
     * 获取计划班级列表
     */
    @POST("v3/gateway/api/tis/device/pte/organizeTest/getPlanClassList")
    Single<BaseResponse<List<PlanClassData>>> getPlanClassPage(@Body PlanClassPageRequest request);

    /**
     * 查询学生是否在计划下
     */
    @POST("v3/gateway/api/tis/device/pte/organizeTest/checkStudent")
    Single<BaseResponse<Boolean>> checkStudentInPlan(@Body CheckStudentInPlanRequest request);
}
