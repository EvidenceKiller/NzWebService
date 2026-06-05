package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.GetPageResult;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.RequestUserCallback;
import com.adl.service.caller.CommonInfoCaller;
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
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.CommonInfoRepository;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * CommonInfoCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class CommonInfoCallerImpl implements CommonInfoCaller {

    private final CommonInfoRepository commonInfoRepository;

    public CommonInfoCallerImpl() {
        this.commonInfoRepository = CommonInfoRepository.getInstance();
    }

    @Override
    public Disposable loadCommonInfoAsync(boolean forceUpdate, RequestUserCallback callback) {
        return loadCommonInfoAsync(forceUpdate, 2, 1000, callback);
    }

    @Override
    public Disposable loadCommonInfoAsync(boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback) {
        return RxCallbackScheduler.schedule(commonInfoRepository.loadCommonInfo(forceUpdate, faceType, pageSize, callback), callback);
    }

    @Override
    public long loadCommonInfoAsync(RequestScope scope, boolean forceUpdate, RequestUserCallback callback) {
        return loadCommonInfoAsync(scope, forceUpdate, 2, 1000, callback);
    }

    @Override
    public long loadCommonInfoAsync(RequestScope scope, boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.loadCommonInfo(forceUpdate, faceType, pageSize, callback), callback);
    }

    @Override
    public void loadCommonInfoSync(boolean forceUpdate, RequestUserCallback callback) {
        loadCommonInfoSync(forceUpdate, 2, 1000, callback);
    }

    @Override
    public void loadCommonInfoSync(boolean forceUpdate, int faceType, long pageSize, RequestUserCallback callback) {
        RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.loadCommonInfo(forceUpdate, faceType, pageSize, callback));
    }

    @Override
    public long getGradeTreeAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<GradeTreeData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getGradeTree(request), callback);
    }

    @Override
    public List<GradeTreeData> getGradeTreeSync(EmptyRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getGradeTree(request));
    }

    @Override
    public long getGradeChineseNameListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<GradeChineseNameData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getGradeChineseNameList(request), callback);
    }

    @Override
    public List<GradeChineseNameData> getGradeChineseNameListSync(EmptyRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getGradeChineseNameList(request));
    }

    @Override
    public long getClassPageAsync(RequestScope scope, ClassPageRequest request, RequestCallback<List<ClassData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getClassPage(request), callback);
    }

    @Override
    public List<ClassData> getClassPageSync(ClassPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getClassPage(request));
    }

    @Override
    public long getClassInfoAsync(RequestScope scope, ClassInfoRequest request, RequestCallback<ClassInfoData> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getClassInfo(request), callback);
    }

    @Override
    public ClassInfoData getClassInfoSync(ClassInfoRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getClassInfo(request));
    }

    @Override
    public long getLoginInfoAsync(RequestScope scope, EmptyRequest request, RequestCallback<LoginInfoData> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getLoginInfo(request), callback);
    }

    @Override
    public LoginInfoData getLoginInfoSync(EmptyRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getLoginInfo(request));
    }

    @Override
    public long getAcayearListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<AcayearData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getAcayearList(request), callback);
    }

    @Override
    public List<AcayearData> getAcayearListSync(EmptyRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getAcayearList(request));
    }

    @Override
    public long getTeacherPagesAllAsync(RequestScope scope, TeacherPageRequest request, RequestCallback<GetPageResult> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getTeacherPagesAll(request, null), callback);
    }

    @Override
    public GetPageResult getTeacherPagesAllSync(TeacherPageRequest request, RequestUserCallback callback) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getTeacherPagesAll(request, callback));
    }

    @Override
    public GetPageResult getTeacherPagesAllSync(TeacherPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getTeacherPagesAll(request, null));
    }

    @Override
    public long getTeacherPageAsync(RequestScope scope, TeacherPageRequest request, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getTeacherPage(request), callback);
    }

    @Override
    public List<TeacherData> getTeacherPageSync(TeacherPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getTeacherPage(request));
    }

    @Override
    public long getStudentPagesAllAsync(RequestScope scope, StudentPageRequest request, RequestCallback<GetPageResult> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getStudentPagesAll(request, null), callback);
    }

    @Override
    public GetPageResult getStudentPagesAllSync(StudentPageRequest request, RequestUserCallback callback) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getStudentPagesAll(request, callback));
    }

    @Override
    public GetPageResult getStudentPagesAllSync(StudentPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getStudentPagesAll(request, null));
    }

    @Override
    public long getStudentPageAsync(RequestScope scope, StudentPageRequest request, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getStudentPage(request), callback);
    }

    @Override
    public List<StudentData> getStudentPageSync(StudentPageRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getStudentPage(request));
    }

    @Override
    public long getDictListAsync(RequestScope scope, DictRequest request, RequestCallback<List<DictData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getDictList(request), callback);
    }

    @Override
    public List<DictData> getDictListSync(DictRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getDictList(request));
    }

    @Override
    public long deviceActiveAsync(RequestScope scope, DeviceActiveRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.deviceActive(request), callback);
    }

    @Override
    public Boolean deviceActiveSync(DeviceActiveRequest request) {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.deviceActive(request), Boolean.class);
    }

    @Override
    public long getServerTimeAsync(RequestScope scope, RequestCallback<Long> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getServerTime(), callback);
    }

    @Override
    public Long getServerTimeSync() {
        return RxCallbackScheduler.blockingGetNoThrow(commonInfoRepository.getServerTime(), Long.class);
    }
}
