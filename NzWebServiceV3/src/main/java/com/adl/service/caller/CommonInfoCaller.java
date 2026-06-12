package com.adl.service.caller;

import com.adl.service.callback.ResponseResult;
import com.adl.service.data.PageSummaryData;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.RequestUserCallback;
import com.adl.service.data.AcayearData;
import com.adl.service.data.ClassData;
import com.adl.service.data.ClassInfoData;
import com.adl.service.data.DictData;
import com.adl.service.data.GradeChineseNameData;
import com.adl.service.data.GradeTreeData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.http.request.ClassInfoRequest;
import com.adl.service.http.request.ClassPageRequest;
import com.adl.service.http.request.DeviceActiveRequest;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * CommonInfoCaller。
 */
public interface CommonInfoCaller {


    Disposable loadCommonInfoAsync(boolean forceUpdate, RequestUserCallback callback);

    Disposable loadCommonInfoAsync(boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback);

    long loadCommonInfoAsync(RequestScope scope, boolean forceUpdate, RequestUserCallback callback);

    long loadCommonInfoAsync(RequestScope scope, boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback);

    void loadCommonInfoSync(boolean forceUpdate, RequestUserCallback callback);

    void loadCommonInfoSync(boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback);

    /**
     * 获取机构年级树
     * <p>异步调用。</p>
     */
    long getGradeTreeAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<GradeTreeData>> callback);

    /**
     * 获取机构年级树
     * <p>同步调用。</p>
     */
    ResponseResult<List<GradeTreeData>> getGradeTreeSync(EmptyRequest request);

    /**
     * 获取年级列表
     * <p>异步调用。</p>
     */
    long getGradeChineseNameListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<GradeChineseNameData>> callback);

    /**
     * 获取年级列表
     * <p>同步调用。</p>
     */
    ResponseResult<List<GradeChineseNameData>> getGradeChineseNameListSync(EmptyRequest request);

    /**
     * 获取班级列表
     * <p>异步调用。</p>
     */
    long getClassPageAsync(RequestScope scope, ClassPageRequest request, RequestCallback<List<ClassData>> callback);

    /**
     * 获取班级列表
     * <p>同步调用。</p>
     */
    ResponseResult<List<ClassData>> getClassPageSync(ClassPageRequest request);

    /**
     * 获取班级信息
     * <p>异步调用。</p>
     */
    long getClassInfoAsync(RequestScope scope, ClassInfoRequest request, RequestCallback<ClassInfoData> callback);

    /**
     * 获取班级信息
     * <p>同步调用。</p>
     */
    ResponseResult<ClassInfoData> getClassInfoSync(ClassInfoRequest request);

    /**
     * 获取登录用户信息
     * <p>异步调用。</p>
     */
    long getLoginInfoAsync(RequestScope scope, EmptyRequest request, RequestCallback<LoginInfoData> callback);

    /**
     * 获取登录用户信息
     * <p>同步调用。</p>
     */
    ResponseResult<LoginInfoData> getLoginInfoSync(EmptyRequest request);

    /**
     * 获取学年学期列表
     * <p>异步调用。</p>
     */
    long getAcayearListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<AcayearData>> callback);

    /**
     * 获取学年学期列表
     * <p>同步调用。</p>
     */
    ResponseResult<List<AcayearData>> getAcayearListSync(EmptyRequest request);

    long getTeacherPagesAllAsync(RequestScope scope, TeacherPageRequest request, RequestCallback<PageSummaryData> callback);

    ResponseResult<PageSummaryData> getTeacherPagesAllSync(TeacherPageRequest request, RequestUserCallback callback);

    ResponseResult<PageSummaryData> getTeacherPagesAllSync(TeacherPageRequest request);

    /**
     * 获取教师用户列表（全量）
     * <p>异步调用。</p>
     */
    long getTeacherPageAsync(RequestScope scope, TeacherPageRequest request, RequestCallback<List<TeacherData>> callback);

    /**
     * 获取教师用户列表（全量）
     * <p>同步调用。</p>
     */
    ResponseResult<List<TeacherData>> getTeacherPageSync(TeacherPageRequest request);

    long getStudentPagesAllAsync(RequestScope scope, StudentPageRequest request, RequestCallback<PageSummaryData> callback);

    ResponseResult<PageSummaryData> getStudentPagesAllSync(StudentPageRequest request, RequestUserCallback callback);

    ResponseResult<PageSummaryData> getStudentPagesAllSync(StudentPageRequest request);

    /**
     * 获取学生增量数据
     * <p>异步调用。</p>
     */
    long getStudentPageAsync(RequestScope scope, StudentPageRequest request, RequestCallback<List<StudentData>> callback);

    /**
     * 获取学生增量数据
     * <p>同步调用。</p>
     */
    ResponseResult<List<StudentData>> getStudentPageSync(StudentPageRequest request);

    /**
     * 获取系统字典
     * <p>异步调用。</p>
     */
    long getDictListAsync(RequestScope scope, DictRequest request, RequestCallback<List<DictData>> callback);

    /**
     * 获取系统字典
     * <p>同步调用。</p>
     */
    ResponseResult<List<DictData>> getDictListSync(DictRequest request);

    /**
     * 设备激活
     * <p>异步调用。</p>
     */
    long deviceActiveAsync(RequestScope scope, DeviceActiveRequest request, RequestCallback<Boolean> callback);

    /**
     * 设备激活
     * <p>同步调用。</p>
     */
    ResponseResult<Boolean> deviceActiveSync(DeviceActiveRequest request);

    /**
     * 获取服务端时间
     * <p>异步调用。</p>
     */
    long getServerTimeAsync(RequestScope scope, RequestCallback<Long> callback);

    /**
     * 获取服务端时间
     * <p>同步调用。</p>
     */
    ResponseResult<Long> getServerTimeSync();
}
