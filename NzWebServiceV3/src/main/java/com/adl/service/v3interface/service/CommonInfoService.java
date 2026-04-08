package com.adl.service.v3interface.service;

import com.adl.service.v3interface.request.AccountInfoRequest;
import com.adl.service.v3interface.request.AddBatchPageRequest;
import com.adl.service.v3interface.request.CitizenPageRequest;
import com.adl.service.v3interface.request.ClassInfoRequest;
import com.adl.service.v3interface.request.ClassListRequest;
import com.adl.service.v3interface.request.DeviceActiveRequest;
import com.adl.service.v3interface.request.DictsRequest;
import com.adl.service.v3interface.request.StudentPageRequest;
import com.adl.service.v3interface.request.TeacherListRequest;
import com.adl.service.v3interface.response.AcayearData;
import com.adl.service.v3interface.response.AccountInfoData;
import com.adl.service.v3interface.response.CitizenPageData;
import com.adl.service.v3interface.response.ClassInfoData;
import com.adl.service.v3interface.response.ClassListData;
import com.adl.service.v3interface.response.DictsData;
import com.adl.service.v3interface.response.GradeChineseNameData;
import com.adl.service.v3interface.response.GradeTreeData;
import com.adl.service.v3interface.response.LoginInfoData;
import com.adl.service.v3interface.response.StudentPageData;
import com.adl.service.v3interface.response.TeacherData;
import com.example.rxsdk.response.BaseResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface CommonInfoService {
    /**
     * 获取机构年级树
     */
    @POST("tis/device/base/org/grade/getGradeTree")
    Single<BaseResponse<List<GradeTreeData>>> getGradeTree();

    /**
     * 获取年级列表
     */
    @POST("tis/device/base/org/grade/getGradeChineseNameList")
    Single<BaseResponse<List<GradeChineseNameData>>> getGradeChineseNameList();

    /**
     * 获取班级列表
     */
    @POST("tis/device/base/org/class/getClassList")
    Single<BaseResponse<List<ClassListData>>> getClassList(@Body ClassListRequest request);

    /**
     * 获取班级信息
     */
    @POST("tis/device/base/org/class/getClassInfo")
    Single<BaseResponse<ClassInfoData>> getClassInfo(@Body ClassInfoRequest request);

    /**
     * 获取登录用户信息
     */
    @POST("tis/device/base/org/account/getLoginInfo")
    Single<BaseResponse<LoginInfoData>> getLoginInfo();

    /**
     * 获取学年学期列表
     */
    @POST("tis/device/base/org/acayear/getAcayearList")
    Single<BaseResponse<List<AcayearData>>> getAcayearList();

    /**
     * 获取教师用户列表（全量）
     */
    @POST("tis/device/base/account/getTeacherList")
    Single<BaseResponse<List<TeacherData>>> getTeacherList(@Body TeacherListRequest request);

    /**
     * 获取学生增量数据
     */
    @POST("tis/device/base/account/getStudentList")
    Single<BaseResponse<StudentPageData>> getStudentPage(@Body StudentPageRequest request);

    /**
     * 获取市民用户列表
     */
    @POST("tis/device/base/account/getCitizenList")
    Single<BaseResponse<CitizenPageData>> getCitizenPage(@Body CitizenPageRequest request);

    /**
     * 获取用户信息
     */
    @POST("tis/device/base/account/getAccountInfo")
    Single<BaseResponse<AccountInfoData>> getAccountInfo(@Body AccountInfoRequest request);

    /**
     * 获取系统字典
     */
    @POST("tis/device/base/sys/dict/getDicts")
    Single<BaseResponse<List<DictsData>>> getDicts(@Body DictsRequest request);

    /**
     * 设备激活
     */
    @POST("tis/device/base/sys/device/active")
    Single<BaseResponse<Boolean>> deviceActive(@Body DeviceActiveRequest request);

    /**
     * 添加通用日志
     */
    @POST("tis/device/base/sys/addBatch")
    Single<BaseResponse<Object>> addBatchPage(@Body AddBatchPageRequest request);
}
