package com.adl.service.internal;

import com.adl.service.caller.BigScreenH5Caller;
import com.adl.service.caller.BigScreenStatsCaller;
import com.adl.service.caller.BusinessCaller;
import com.adl.service.caller.CommonNativeCaller;
import com.adl.service.caller.CommonInfoCaller;
import com.adl.service.caller.DownloadFileCaller;
import com.adl.service.caller.LoginAuthCaller;
import com.adl.service.caller.OperationCaller;
import com.adl.service.caller.OpsMaintCaller;
import com.adl.service.caller.OrgTestCaller;
import com.adl.service.caller.PlanNativeCaller;
import com.adl.service.caller.RecordNativeCaller;
import com.adl.service.caller.SportInfoCaller;
import com.adl.service.caller.UploadOssCaller;
import com.adl.service.caller.UploadQiNiuYunCaller;
import com.adl.service.caller.UploadRecordCaller;
import com.adl.service.caller.UserNativeCaller;
import com.adl.service.caller.impl.BigScreenH5CallerImpl;
import com.adl.service.caller.impl.BigScreenStatsCallerImpl;
import com.adl.service.caller.impl.BusinessCallerImpl;
import com.adl.service.caller.impl.CommonNativeCallerImpl;
import com.adl.service.caller.impl.CommonInfoCallerImpl;
import com.adl.service.caller.impl.DownloadFileCallerImpl;
import com.adl.service.caller.impl.LoginAuthCallerImpl;
import com.adl.service.caller.impl.OperationCallerImpl;
import com.adl.service.caller.impl.OpsMaintCallerImpl;
import com.adl.service.caller.impl.OrgTestCallerImpl;
import com.adl.service.caller.impl.PlanNativeCallerImpl;
import com.adl.service.caller.impl.RecordNativeCallerImpl;
import com.adl.service.caller.impl.SportInfoCallerImpl;
import com.adl.service.caller.impl.UploadOssCallerImpl;
import com.adl.service.caller.impl.UploadQiNiuYunCallerImpl;
import com.adl.service.caller.impl.UploadRecordCallerImpl;
import com.adl.service.caller.impl.UserNativeCallerImpl;

import androidx.annotation.RestrictTo;
import lombok.Getter;

/**
 * Retrofit 与 Caller 统一管理器（单例）。
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class CallerManager {

    private static volatile CallerManager instance;

    @Getter
    private CommonInfoCaller commonInfoCaller;
    @Getter
    private SportInfoCaller sportInfoCaller;
    @Getter
    private OrgTestCaller orgTestCaller;
    @Getter
    private OperationCaller operationCaller;
    @Getter
    private OpsMaintCaller opsMaintCaller;
    @Getter
    private BusinessCaller businessCaller;
    @Getter
    private LoginAuthCaller loginAuthCaller;
    @Getter
    private BigScreenStatsCaller bigScreenStatsCaller;
    @Getter
    private BigScreenH5Caller bigScreenH5Caller;
    @Getter
    private UploadQiNiuYunCaller uploadQiNiuYunCaller;
    @Getter
    private UploadOssCaller uploadOssCaller;
    @Getter
    private UploadRecordCaller uploadRecordCaller;
    @Getter
    private DownloadFileCaller downloadFileCaller;
    @Getter
    private CommonNativeCaller commonNativeCaller;
    @Getter
    private UserNativeCaller userNativeCaller;
    @Getter
    private PlanNativeCaller planNativeCaller;
    @Getter
    private RecordNativeCaller recordNativeCaller;

    private CallerManager() {
        this.commonInfoCaller = CallerProxy.wrap(CommonInfoCaller.class, new CommonInfoCallerImpl());
        this.sportInfoCaller = CallerProxy.wrap(SportInfoCaller.class, new SportInfoCallerImpl());
        this.orgTestCaller = CallerProxy.wrap(OrgTestCaller.class, new OrgTestCallerImpl());
        this.operationCaller = CallerProxy.wrap(OperationCaller.class, new OperationCallerImpl());
        this.opsMaintCaller = CallerProxy.wrap(OpsMaintCaller.class, new OpsMaintCallerImpl());
        this.businessCaller = CallerProxy.wrap(BusinessCaller.class, new BusinessCallerImpl());
        this.loginAuthCaller = CallerProxy.wrap(LoginAuthCaller.class, new LoginAuthCallerImpl());
        this.bigScreenStatsCaller = CallerProxy.wrap(BigScreenStatsCaller.class, new BigScreenStatsCallerImpl());
        this.bigScreenH5Caller = CallerProxy.wrap(BigScreenH5Caller.class, new BigScreenH5CallerImpl());
        this.uploadQiNiuYunCaller = CallerProxy.wrap(UploadQiNiuYunCaller.class, new UploadQiNiuYunCallerImpl());
        this.uploadOssCaller = CallerProxy.wrap(UploadOssCaller.class, new UploadOssCallerImpl());
        this.uploadRecordCaller = CallerProxy.wrap(UploadRecordCaller.class, new UploadRecordCallerImpl());
        this.downloadFileCaller = CallerProxy.wrap(DownloadFileCaller.class, new DownloadFileCallerImpl());
        this.commonNativeCaller = CallerProxy.wrap(CommonNativeCaller.class, new CommonNativeCallerImpl());
        this.userNativeCaller = CallerProxy.wrap(UserNativeCaller.class, new UserNativeCallerImpl());
        this.planNativeCaller = CallerProxy.wrap(PlanNativeCaller.class, new PlanNativeCallerImpl());
        this.recordNativeCaller = CallerProxy.wrap(RecordNativeCaller.class, new RecordNativeCallerImpl());
    }

    public static CallerManager getInstance() {
        if (instance == null) {
            synchronized (CallerManager.class) {
                if (instance == null) {
                    instance = new CallerManager();
                }
            }
        }
        return instance;
    }

    public synchronized void init() {
        if (this.commonInfoCaller == null) this.commonInfoCaller = CallerProxy.wrap(CommonInfoCaller.class, new CommonInfoCallerImpl());
        if (this.sportInfoCaller == null) this.sportInfoCaller = CallerProxy.wrap(SportInfoCaller.class, new SportInfoCallerImpl());
        if (this.orgTestCaller == null) this.orgTestCaller = CallerProxy.wrap(OrgTestCaller.class, new OrgTestCallerImpl());
        if (this.operationCaller == null) this.operationCaller = CallerProxy.wrap(OperationCaller.class, new OperationCallerImpl());
        if (this.opsMaintCaller == null) this.opsMaintCaller = CallerProxy.wrap(OpsMaintCaller.class, new OpsMaintCallerImpl());
        if (this.businessCaller == null) this.businessCaller = CallerProxy.wrap(BusinessCaller.class, new BusinessCallerImpl());
        if (this.loginAuthCaller == null) this.loginAuthCaller = CallerProxy.wrap(LoginAuthCaller.class, new LoginAuthCallerImpl());
        if (this.bigScreenStatsCaller == null) this.bigScreenStatsCaller = CallerProxy.wrap(BigScreenStatsCaller.class, new BigScreenStatsCallerImpl());
        if (this.bigScreenH5Caller == null) this.bigScreenH5Caller = CallerProxy.wrap(BigScreenH5Caller.class, new BigScreenH5CallerImpl());
        if (this.uploadQiNiuYunCaller == null) this.uploadQiNiuYunCaller = CallerProxy.wrap(UploadQiNiuYunCaller.class, new UploadQiNiuYunCallerImpl());
        if (this.uploadOssCaller == null) this.uploadOssCaller = CallerProxy.wrap(UploadOssCaller.class, new UploadOssCallerImpl());
        if (this.uploadRecordCaller == null) this.uploadRecordCaller = CallerProxy.wrap(UploadRecordCaller.class, new UploadRecordCallerImpl());
        if (this.downloadFileCaller == null) this.downloadFileCaller = CallerProxy.wrap(DownloadFileCaller.class, new DownloadFileCallerImpl());
        if (this.commonNativeCaller == null) this.commonNativeCaller = CallerProxy.wrap(CommonNativeCaller.class, new CommonNativeCallerImpl());
        if (this.userNativeCaller == null) this.userNativeCaller = CallerProxy.wrap(UserNativeCaller.class, new UserNativeCallerImpl());
        if (this.planNativeCaller == null) this.planNativeCaller = CallerProxy.wrap(PlanNativeCaller.class, new PlanNativeCallerImpl());
        if (this.recordNativeCaller == null) this.recordNativeCaller = CallerProxy.wrap(RecordNativeCaller.class, new RecordNativeCallerImpl());
    }

    public synchronized void release() {
        commonInfoCaller = null;
        sportInfoCaller = null;
        orgTestCaller = null;
        operationCaller = null;
        opsMaintCaller = null;
        businessCaller = null;
        loginAuthCaller = null;
        bigScreenStatsCaller = null;
        bigScreenH5Caller = null;

        uploadQiNiuYunCaller.release();
        uploadQiNiuYunCaller = null;
        uploadOssCaller.release();
        uploadOssCaller = null;
        uploadRecordCaller = null;
        downloadFileCaller = null;

        commonNativeCaller = null;
        userNativeCaller = null;
        planNativeCaller = null;
        recordNativeCaller = null;
    }
}
