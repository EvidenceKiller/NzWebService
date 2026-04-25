package com.adl.service.web;

import com.adl.service.data.TimeStamp;
import com.adl.service.http.request.ClassInfoRequest;
import com.adl.service.http.request.ClassPageRequest;
import com.adl.service.http.request.DeviceActiveRequest;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.data.AcayearData;
import com.adl.service.data.BasePageData;
import com.adl.service.data.BaseResponse;
import com.adl.service.data.ClassInfoData;
import com.adl.service.data.ClassData;
import com.adl.service.data.DictData;
import com.adl.service.data.GradeChineseNameData;
import com.adl.service.data.GradeTreeData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Retrofit API（v3new 生成）
 */
public interface CommonInfoService {
    /**
     * 获取机构年级树
     */
    @POST("v3/gateway/api/tis/device/base/org/grade/getGradeTree")
    Single<BaseResponse<List<GradeTreeData>>> getGradeTree();

    /**
     * 获取年级列表
     */
    @POST("v3/gateway/api/tis/device/base/org/grade/getGradeChineseNameList")
    Single<BaseResponse<List<GradeChineseNameData>>> getGradeChineseNameList();

    /**
     * 获取班级列表
     */
    @POST("v3/gateway/api/tis/device/base/org/class/getClassList")
    Single<BaseResponse<List<ClassData>>> getClassPage(@Body ClassPageRequest request);

    /**
     * 获取班级信息
     */
    @POST("v3/gateway/api/tis/device/base/org/class/getClassInfo")
    Single<BaseResponse<ClassInfoData>> getClassInfo(@Body ClassInfoRequest request);

    /**
     * 获取登录用户信息
     */
    @POST("v3/gateway/api/tis/device/base/org/account/getLoginInfo")
    Single<BaseResponse<LoginInfoData>> getLoginInfo();

    /**
     * 获取学年学期列表
     */
    @POST("v3/gateway/api/tis/device/base/org/acayear/getAcayearList")
    Single<BaseResponse<List<AcayearData>>> getAcayearList();

    /**
     * 获取教师用户列表（全量）
     */
    @POST("v3/gateway/api/tis/device/base/account/getTeacherList")
    Single<BaseResponse<List<TeacherData>>> getTeacherPage(@Body TeacherPageRequest request);

    /**
     * 获取学生增量数据
     */
    @POST("v3/gateway/api/tis/device/base/account/getStudentList")
    Single<BaseResponse<BasePageData<StudentData>>> getStudentPage(@Body StudentPageRequest request);

    /**
     * 获取系统字典
     */
    @POST("v3/gateway/api/tis/device/base/sys/dict/getDicts")
    Single<BaseResponse<List<DictData>>> getDictList(@Body DictRequest request);

    /**
     * 设备激活
     */
    @POST("v3/gateway/api/tis/device/base/sys/device/active")
    Single<BaseResponse<Boolean>> deviceActive(@Body DeviceActiveRequest request);

    /**
     * 服务端时间
     */
    @GET("time")
    Single<TimeStamp> getServerTime();
}
