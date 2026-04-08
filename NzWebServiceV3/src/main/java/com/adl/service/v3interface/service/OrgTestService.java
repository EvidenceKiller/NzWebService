package com.adl.service.v3interface.service;

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
import com.example.rxsdk.response.BaseResponse;

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
    @POST("tis/device/pte/organizeTest/getStandardConfig")
    Single<BaseResponse<List<StandardConfigPageData>>> getStandardConfigPage(@Body StandardConfigPageRequest request);

    /**
     * 获取组织测试记录详情
     */
    @POST("tis/device/pte/organizeTest/getRecordDetail")
    Single<BaseResponse<RecordDetailPageData>> getRecordDetailPage(@Body RecordDetailPageRequest request);

    /**
     * 获取计划下学生
     */
    @POST("tis/device/pte/organizeTest/getPlanStudents")
    Single<BaseResponse<PlanStudentPageData>> getPlanStudentPage(@Body PlanStudentPageRequest request);

    /**
     * 获取计划列表
     */
    @POST("tis/device/pte/organizeTest/getPlanList")
    Single<BaseResponse<PlanPageData>> getPlanPage(@Body PlanListRequest request);

    /**
     * 获取组织测试计划详情
     */
    @POST("tis/device/pte/organizeTest/getPlanInfo")
    Single<BaseResponse<PlanInfoData>> getPlanInfo();

    /**
     * 获取计划班级列表
     */
    @POST("tis/device/pte/organizeTest/getPlanClassList")
    Single<BaseResponse<List<PlanClassData>>> getPlanClassList(@Body PlanClassListRequest request);

    /**
     * 查询学生是否在计划下
     */
    @POST("tis/device/pte/organizeTest/checkStudent")
    Single<BaseResponse<OrganizeTestCheckStudentData>> getCheckStudent(@Body OrganizeTestCheckStudentRequest request);
}
