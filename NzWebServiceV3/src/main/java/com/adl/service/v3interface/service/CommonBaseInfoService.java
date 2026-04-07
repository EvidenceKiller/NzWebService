package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.request.ActiveRequest;
import com.example.rxsdk.v3interface.request.AddBatchRequest;
import com.example.rxsdk.v3interface.request.GetCitizenListRequest;
import com.example.rxsdk.v3interface.request.GetClassListRequest;
import com.example.rxsdk.v3interface.request.GetDictsRequest;
import com.example.rxsdk.v3interface.request.GetStudentListRequest;
import com.example.rxsdk.v3interface.request.GetTeacherListRequest;
import com.example.rxsdk.v3interface.response.ActiveData;
import com.example.rxsdk.v3interface.response.AddBatchData;
import com.example.rxsdk.v3interface.response.GetAcayearListData;
import com.example.rxsdk.v3interface.response.GetAccountInfoData;
import com.example.rxsdk.v3interface.response.GetCitizenListData;
import com.example.rxsdk.v3interface.response.GetClassInfoData;
import com.example.rxsdk.v3interface.response.GetClassListData;
import com.example.rxsdk.v3interface.response.GetDictsData;
import com.example.rxsdk.v3interface.response.GetLoginInfoData;
import com.example.rxsdk.v3interface.response.GetStudentListData;
import com.example.rxsdk.v3interface.response.GetTeacherListData;
import com.example.rxsdk.v3interface.response.GradeChineseNameListData;
import com.example.rxsdk.v3interface.response.GradeTreeData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Name : CommonBaseInfoService
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 提供Retrofit接口调用能力
 */
public interface CommonBaseInfoService {
    /** 获取机构年级树 */
    @POST("tis/device/base/org/grade/getGradeTree")
    Single<BaseResponse<List<GradeTreeData>>> getGradeTree();

    /** 获取年级列表 */
    @POST("tis/device/base/org/grade/getGradeChineseNameList")
    Single<BaseResponse<List<GradeChineseNameListData>>> getGradeChineseNameList();

    /** 获取班级列表 */
    @POST("tis/device/base/org/class/getClassList")
    Single<BaseResponse<List<GetClassListData>>> getGetClassList(@Body GetClassListRequest request);

    /**
     * 获取班级信息
     * Path classId: 班级id
     */
    @POST("tis/device/base/org/class/getClassInfo/{classId}")
    Single<BaseResponse<GetClassInfoData>> getGetClassInfo(@Path("classId") String classId);

    /** 获取登录用户信息 */
    @POST("tis/device/base/org/account/getLoginInfo")
    Single<BaseResponse<GetLoginInfoData>> getGetLoginInfo();

    /** 获取学年学期列表 */
    @POST("tis/device/base/org/acayear/getAcayearList")
    Single<BaseResponse<List<GetAcayearListData>>> getGetAcayearList();

    /** 获取教师用户列表（全量） */
    @POST("tis/device/base/account/getTeacherList")
    Single<BaseResponse<List<GetTeacherListData>>> getGetTeacherList(@Body GetTeacherListRequest request);

    /** 获取学生增量数据 */
    @POST("tis/device/base/account/getStudentList")
    Single<BaseResponse<GetStudentListData>> getGetStudentList(@Body GetStudentListRequest request);

    /** 获取市民用户列表 */
    @POST("tis/device/base/account/getCitizenList")
    Single<BaseResponse<GetCitizenListData>> getGetCitizenList(@Body GetCitizenListRequest request);

    /** 获取用户信息 */
    @POST("tis/device/base/account/getAccountInfo/{accountId}")
    Single<BaseResponse<GetAccountInfoData>> getGetAccountInfo(@Path("accountId") String accountId);

    /** 获取系统字典 */
    @POST("tis/device/base/sys/dict/getDicts")
    Single<BaseResponse<List<GetDictsData>>> getGetDicts(@Body GetDictsRequest request);

    /** 设备激活 */
    @POST("tis/device/base/sys/device/active")
    Single<BaseResponse<ActiveData>> getActive(@Body ActiveRequest request);

    /** 添加通用日志 */
    @POST("tis/device/base/sys/addBatch")
    Single<BaseResponse<AddBatchData>> getAddBatch(@Body AddBatchRequest request);
}
