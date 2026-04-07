package com.adl.service.v3interface.service;

import com.example.rxsdk.response.BaseResponse;
import com.example.rxsdk.v3interface.request.GetAccountRecordPageRequest;
import com.example.rxsdk.v3interface.request.GetOrgRecordPageRequest;
import com.example.rxsdk.v3interface.request.ReportNfSportRequest;
import com.example.rxsdk.v3interface.request.ReportStudentAllSportRequest;
import com.example.rxsdk.v3interface.request.ReportStudentCompetitionRequest;
import com.example.rxsdk.v3interface.request.ReportStudentMeetRequest;
import com.example.rxsdk.v3interface.request.ReportStudentPlanRequest;
import com.example.rxsdk.v3interface.request.ReportStudentSportRequest;
import com.example.rxsdk.v3interface.request.ReportStudentTrainRequest;
import com.example.rxsdk.v3interface.request.ReportTeacherSportRequest;
import com.example.rxsdk.v3interface.request.UpdateStudentSportRequest;
import com.example.rxsdk.v3interface.request.UploadStudentMeetRequest;
import com.example.rxsdk.v3interface.response.GetAccountRecordPageData;
import com.example.rxsdk.v3interface.response.GetOrgRecordPageData;
import com.example.rxsdk.v3interface.response.ReportNfSportData;
import com.example.rxsdk.v3interface.response.ReportStudentAllSportData;
import com.example.rxsdk.v3interface.response.ReportStudentCompetitionData;
import com.example.rxsdk.v3interface.response.ReportStudentMeetData;
import com.example.rxsdk.v3interface.response.ReportStudentPlanData;
import com.example.rxsdk.v3interface.response.ReportStudentSportData;
import com.example.rxsdk.v3interface.response.ReportStudentTrainData;
import com.example.rxsdk.v3interface.response.ReportTeacherSportData;
import com.example.rxsdk.v3interface.response.UpdateStudentSportData;
import com.example.rxsdk.v3interface.response.UploadStudentMeetData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Name : SportInfoService
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 提供Retrofit接口调用能力
 */
public interface SportInfoService {
    /** 通用修改学生运动成绩 */
    @POST("tis/device/sport/result/updateStudentSport")
    Single<BaseResponse<UpdateStudentSportData>> getUpdateStudentSport(@Body UpdateStudentSportRequest request);

    /** 上报教师普通运动成绩 */
    @POST("tis/device/sport/result/reportTeacherSport")
    Single<BaseResponse<ReportTeacherSportData>> getReportTeacherSport(@Body ReportTeacherSportRequest request);

    /** 上报学生特训成绩 */
    @POST("tis/device/sport/result/reportStudentTrain")
    Single<BaseResponse<ReportStudentTrainData>> getReportStudentTrain(@Body ReportStudentTrainRequest request);

    /** 上报学生普通运动成绩 */
    @POST("tis/device/sport/result/reportStudentSport")
    Single<BaseResponse<ReportStudentSportData>> getReportStudentSport(@Body ReportStudentSportRequest request);

    /** 上传学生运动会成绩 */
    @POST("tis/device/sport/result/uploadStudentMeet")
    Single<BaseResponse<UploadStudentMeetData>> getUploadStudentMeet(@Body UploadStudentMeetRequest request);

    /** 上报学生组织测试成绩 */
    @POST("tis/device/sport/result/reportStudentPlan")
    Single<BaseResponse<ReportStudentPlanData>> getReportStudentPlan(@Body ReportStudentPlanRequest request);

    /** 上报学生运动会成绩 */
    @POST("tis/device/sport/result/reportStudentMeet")
    Single<BaseResponse<ReportStudentMeetData>> getReportStudentMeet(@Body ReportStudentMeetRequest request);

    /** 上报学生竞技赛成绩 */
    @POST("tis/device/sport/result/reportStudentCompetition")
    Single<BaseResponse<ReportStudentCompetitionData>> getReportStudentCompetition(@Body ReportStudentCompetitionRequest request);

    /** 通用上报学生运动成绩接口 */
    @POST("tis/device/sport/result/reportStudentAllSport")
    Single<BaseResponse<ReportStudentAllSportData>> getReportStudentAllSport(@Body ReportStudentAllSportRequest request);

    /** 上报市民通运动成绩 */
    @POST("tis/device/sport/result/reportNfSport")
    Single<BaseResponse<ReportNfSportData>> getReportNfSport(@Body ReportNfSportRequest request);

    /** 获取机构/年级运动记录分页 */
    @POST("tis/device/sport/result/getOrgRecordPage")
    Single<BaseResponse<GetOrgRecordPageData>> getGetOrgRecordPage(@Body GetOrgRecordPageRequest request);

    /** 获取班级/个人运动记录分页 */
    @POST("tis/device/sport/result/getAccountRecordPage")
    Single<BaseResponse<GetAccountRecordPageData>> getGetAccountRecordPage(@Body GetAccountRecordPageRequest request);
}
