package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.request.CheckStudentRequest;
import com.example.rxsdk.v3interface.request.GetPlanClassListRequest;
import com.example.rxsdk.v3interface.request.GetPlanListRequest;
import com.example.rxsdk.v3interface.request.GetPlanStudentsRequest;
import com.example.rxsdk.v3interface.request.GetRecordDetailRequest;
import com.example.rxsdk.v3interface.request.GetStandardConfigRequest;
import com.example.rxsdk.v3interface.response.CheckStudentData;
import com.example.rxsdk.v3interface.response.GetPlanClassListData;
import com.example.rxsdk.v3interface.response.GetPlanInfoData;
import com.example.rxsdk.v3interface.response.GetPlanListData;
import com.example.rxsdk.v3interface.response.GetPlanStudentsData;
import com.example.rxsdk.v3interface.response.GetRecordDetailData;
import com.example.rxsdk.v3interface.response.GetStandardConfigData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/** Auto-generated from v3interface HTML. */
public interface OrgTestService {
    /** 获取标准列表 — 来源:dev */
    @POST("tis/device/pte/organizeTest/getStandardConfig")
    Single<BaseResponse<List<GetStandardConfigData>>> getGetStandardConfig(@Body GetStandardConfigRequest request);

    /** 获取组织测试记录详情 — 来源:dev */
    @POST("tis/device/pte/organizeTest/getRecordDetail")
    Single<BaseResponse<GetRecordDetailData>> getGetRecordDetail(@Body GetRecordDetailRequest request);

    /** 获取计划下学生 — 来源:dev */
    @POST("tis/device/pte/organizeTest/getPlanStudents")
    Single<BaseResponse<GetPlanStudentsData>> getGetPlanStudents(@Body GetPlanStudentsRequest request);

    /** 获取计划列表 — 来源:dev */
    @POST("tis/device/pte/organizeTest/getPlanList")
    Single<BaseResponse<GetPlanListData>> getGetPlanList(@Body GetPlanListRequest request);

    /** 获取组织测试计划详情 — 来源:dev */
    @POST("tis/device/pte/organizeTest/getPlanInfo")
    Single<BaseResponse<GetPlanInfoData>> getGetPlanInfo();

    /** 获取计划班级列表 — 来源:dev */
    @POST("tis/device/pte/organizeTest/getPlanClassList")
    Single<BaseResponse<List<GetPlanClassListData>>> getGetPlanClassList(@Body GetPlanClassListRequest request);

    /** 查询学生是否在计划下 — 来源:dev */
    @POST("tis/device/pte/organizeTest/checkStudent")
    Single<BaseResponse<CheckStudentData>> getCheckStudent(@Body CheckStudentRequest request);
}
