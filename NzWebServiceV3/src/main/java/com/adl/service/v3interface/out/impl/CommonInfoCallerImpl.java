package com.adl.service.v3interface.out.impl;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.api.RxSdk;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.exception.NzBaseException;
import com.adl.service.v3interface.internal.RxCallbackScheduler;
import com.adl.service.v3interface.internal.SubscriptionManager;
import com.adl.service.v3interface.out.CommonInfoCaller;
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
import com.adl.service.v3interface.service.CommonInfoService;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * CommonInfoCaller 实现（SDK 内部使用，通过 {@link RxSdk} 暴露）。
 */
public final class CommonInfoCallerImpl implements CommonInfoCaller {

    private final CommonInfoService commonInfoService;

    public CommonInfoCallerImpl(CommonInfoService commonInfoService) {
        this.commonInfoService = commonInfoService;
    }

    @Override
    public long getGradeTreeAsync(RequestScope scope, RequestCallback<List<GradeTreeData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getGradeTree(), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<GradeTreeData> getGradeTreeSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getGradeTree());
    }

    @Override
    public long getGradeChineseNameListAsync(RequestScope scope, RequestCallback<List<GradeChineseNameData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getGradeChineseNameList(), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<GradeChineseNameData> getGradeChineseNameListSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getGradeChineseNameList());
    }

    @Override
    public long getClassListAsync(RequestScope scope, ClassListRequest request, RequestCallback<List<ClassListData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getClassList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<ClassListData> getClassListSync(ClassListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getClassList(request));
    }

    @Override
    public long getClassInfoAsync(RequestScope scope, ClassInfoRequest request, RequestCallback<ClassInfoData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getClassInfo(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public ClassInfoData getClassInfoSync(ClassInfoRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getClassInfo(request));
    }

    @Override
    public long getLoginInfoAsync(RequestScope scope, RequestCallback<LoginInfoData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getLoginInfo(), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public LoginInfoData getLoginInfoSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getLoginInfo());
    }

    @Override
    public long getAcayearListAsync(RequestScope scope, RequestCallback<List<AcayearData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getAcayearList(), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<AcayearData> getAcayearListSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getAcayearList());
    }

    @Override
    public long getTeacherListAsync(RequestScope scope, TeacherListRequest request, RequestCallback<List<TeacherData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getTeacherList(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<TeacherData> getTeacherListSync(TeacherListRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getTeacherList(request));
    }

    @Override
    public long getStudentPageAsync(RequestScope scope, StudentPageRequest request, RequestCallback<StudentPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getStudentPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public StudentPageData getStudentPageSync(StudentPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getStudentPage(request));
    }

    @Override
    public long getCitizenPageAsync(RequestScope scope, CitizenPageRequest request, RequestCallback<CitizenPageData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getCitizenPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public CitizenPageData getCitizenPageSync(CitizenPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getCitizenPage(request));
    }

    @Override
    public long getAccountInfoAsync(RequestScope scope, AccountInfoRequest request, RequestCallback<AccountInfoData> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getAccountInfo(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public AccountInfoData getAccountInfoSync(AccountInfoRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getAccountInfo(request));
    }

    @Override
    public long getDictsAsync(RequestScope scope, DictsRequest request, RequestCallback<List<DictsData>> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.getDicts(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public List<DictsData> getDictsSync(DictsRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.getDicts(request));
    }

    @Override
    public long deviceActiveAsync(RequestScope scope, DeviceActiveRequest request, RequestCallback<Boolean> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.deviceActive(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Boolean deviceActiveSync(DeviceActiveRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.deviceActive(request));
    }

    @Override
    public long addBatchPageAsync(RequestScope scope, AddBatchPageRequest request, RequestCallback<Object> callback) {
        CallerScopeUtils.requireScope(scope);
        Disposable disposable = RxCallbackScheduler.scheduleBaseResponse(commonInfoService.addBatchPage(request), callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    @Override
    public Object addBatchPageSync(AddBatchPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGetData(commonInfoService.addBatchPage(request));
    }
}
