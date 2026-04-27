package com.adl.service.caller.impl;

import android.text.TextUtils;

import com.adl.service.AdlService;
import com.adl.service.callback.GetPageResult;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.CommonInfoCaller;
import com.adl.service.common.FileDownManager;
import com.adl.service.common.IDefine;
import com.adl.service.common.InnerPreferences;
import com.adl.service.data.AcayearData;
import com.adl.service.data.ClassData;
import com.adl.service.data.ClassInfoData;
import com.adl.service.data.DictData;
import com.adl.service.data.GradeChineseNameData;
import com.adl.service.data.GradeTreeData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.ClassInfoRequest;
import com.adl.service.http.request.ClassPageRequest;
import com.adl.service.http.request.DeviceActiveRequest;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.log.NzLog;
import com.adl.service.repository.CommonInfoRepository;
import com.adl.service.utils.InnerUtil;

import java.util.List;

/**
 * CommonInfoCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class CommonInfoCallerImpl implements CommonInfoCaller {

    private final CommonInfoRepository commonInfoRepository;

    public CommonInfoCallerImpl() {
        this.commonInfoRepository = CommonInfoRepository.getInstance();
    }

    @Override
    public void reloadCommonInfoSync(boolean forceUpdate, int faceType, long pageSize) throws NzBaseException {
        InnerPreferences pf = InnerPreferences.instance();

        ////////////// 1.同步机构信息 ////////////
        NzLog.i("同步机构信息");
        //启动时，请求一次机构信息，如果机构变更，清除数据标识
        LoginInfoData loginInfo = queryLoginInfoSync();
        LoginInfoData newLoginInfo = getLoginInfoSync(EmptyRequest.builder().forceUpdate(true).build());
        if (newLoginInfo != null && !TextUtils.isEmpty(newLoginInfo.getOrgId()) && !newLoginInfo.getOrgId().equals(loginInfo.getOrgId())) {
            DaoManagerProxy.getInstance().getStudentDao().clearAll();
            DaoManagerProxy.getInstance().getTeacherDao().clearAll();
            FileDownManager.instance().clearAllFace();
            pf.putLong(IDefine.LAST_STUDENT_UPDATE_TIME, IDefine.INVALID_TIME);
            pf.putLong(IDefine.LAST_TEACHER_UPDATE_TIME, IDefine.INVALID_TIME);
            pf.putLong(IDefine.LAST_CITIZEN_UPDATE_TIME, IDefine.INVALID_TIME);
        }


        ////////////// 2.同步学生基本信息 ////////////
        long serverTime = getServerTimeSync();
        int size = queryAllStudentCountSync();
        long lastTime = pf.readLong(IDefine.LAST_STUDENT_UPDATE_TIME);
        NzLog.d("本机时间:size: " + size + ";forceUpdate:" + forceUpdate + ";serverTime:" + serverTime + ";lastTime:" + lastTime + ";UpdateIntervalTime:" + IDefine.UpdateIntervalTime);

        // 是否强制更新数据
        long recentUpdateTime = queryStudentRecentUpdateTimeSync();
        NzLog.d("本机时间:recentUpdateTime: " + recentUpdateTime);

        StudentPageRequest studentPageRequest = StudentPageRequest.builder()
                .current(1L)
                .pageSize(pageSize)
                .faceType(faceType)
                .lastUpdateTime(forceUpdate ? null : lastTime != IDefine.INVALID_TIME ? InnerUtil.formatByTimeCode(recentUpdateTime) : null)
                .build();

        getStudentPagesAllSync(studentPageRequest);
        pf.putLong(IDefine.LAST_STUDENT_UPDATE_TIME, serverTime);

        ////////////// 3.同步老师基本信息 ////////////
        size = DaoManagerProxy.getInstance().getTeacherDao().countSize();
        lastTime = pf.readLong(IDefine.LAST_TEACHER_UPDATE_TIME);

        // 数据会空，或者时间间隔2分钟
        if (size == 0 || forceUpdate || serverTime - lastTime > IDefine.UpdateIntervalTime) {
            TeacherPageRequest teacherPageRequest = TeacherPageRequest.builder()
                    .current(1L)
                    .pageSize(pageSize)
                    .lastUpdateTime(forceUpdate ? null : InnerUtil.formatByTimeCode(lastTime))
                    .build();
            getTeacherPagesAllSync(teacherPageRequest);
            pf.putLong(IDefine.LAST_TEACHER_UPDATE_TIME, serverTime);
        }
    }

    @Override
    public List<StudentData> queryAllStudentSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryAllStudent());
    }

    @Override
    public List<StudentData> queryAllStudentWithFaceDataSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryAllStudentWithFaceData());
    }

    @Override
    public int queryAllStudentCountSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryAllStudentCount());
    }

    @Override
    public StudentData queryStudentByAccountIdSync(String accountId) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryStudentByAccountId(accountId));
    }

    @Override
    public List<StudentData> queryStudentByAccountIdsSync(List<String> accountIds) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryStudentByAccountIds(accountIds));
    }

    @Override
    public List<StudentData> queryStudentByClassIdsSync(List<String> classIds) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryStudentByClassIds(classIds));
    }

    @Override
    public long queryStudentRecentUpdateTimeSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryStudentRecentUpdateTime());
    }

    @Override
    public List<StudentData> queryStudentByCarNumSync(String cardNum) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryStudentByCardNum(cardNum));
    }

    @Override
    public List<TeacherData> queryAllTeacherListSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryAllTeacherList());
    }

    @Override
    public List<TeacherData> queryAllTeacherListWithFaceDataSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryAllTeacherListWithFaceData());
    }

    @Override
    public int queryAllTeacherCountSync(RequestCallback callback) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryAllTeacherCount());
    }

    @Override
    public TeacherData queryTeacherByAccountIdSync(String accountId) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryTeacherByAccountId(accountId));
    }

    @Override
    public List<TeacherData> queryTeacherListByAccountIdsSync(List<String> accountIds) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryTeacherListByAccountIds(accountIds));
    }

    @Override
    public long getGradeTreeAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<GradeTreeData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getGradeTree(request), callback);
    }

    @Override
    public List<GradeTreeData> getGradeTreeSync(EmptyRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getGradeTree(request));
    }

    @Override
    public long getGradeChineseNameListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<GradeChineseNameData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getGradeChineseNameList(request), callback);
    }

    @Override
    public List<GradeChineseNameData> getGradeChineseNameListSync(EmptyRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getGradeChineseNameList(request));
    }

    @Override
    public long getClassPageAsync(RequestScope scope, ClassPageRequest request, RequestCallback<List<ClassData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getClassPage(request), callback);
    }

    @Override
    public List<ClassData> getClassPageSync(ClassPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getClassPage(request));
    }

    @Override
    public long getClassInfoAsync(RequestScope scope, ClassInfoRequest request, RequestCallback<ClassInfoData> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getClassInfo(request), callback);
    }

    @Override
    public ClassInfoData getClassInfoSync(ClassInfoRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getClassInfo(request));
    }

    public LoginInfoData queryLoginInfoSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.queryLoginInfo());
    }

    @Override
    public long getLoginInfoAsync(RequestScope scope, EmptyRequest request, RequestCallback<LoginInfoData> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getLoginInfo(request), callback);
    }

    @Override
    public LoginInfoData getLoginInfoSync(EmptyRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getLoginInfo(request));
    }

    @Override
    public long getAcayearListAsync(RequestScope scope, EmptyRequest request, RequestCallback<List<AcayearData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getAcayearList(request), callback);
    }

    @Override
    public List<AcayearData> getAcayearListSync(EmptyRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getAcayearList(request));
    }

    @Override
    public long getTeacherPagesAllAsync(RequestScope scope, TeacherPageRequest request, RequestCallback<GetPageResult> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getTeacherPagesAll(request), callback);
    }

    @Override
    public GetPageResult getTeacherPagesAllSync(TeacherPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getTeacherPagesAll(request));
    }

    @Override
    public long getTeacherPageAsync(RequestScope scope, TeacherPageRequest request, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getTeacherPage(request), callback);
    }

    @Override
    public List<TeacherData> getTeacherPageSync(TeacherPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getTeacherPage(request));
    }

    @Override
    public long getStudentPagesAllAsync(RequestScope scope, StudentPageRequest request, RequestCallback<GetPageResult> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getStudentPagesAll(request), callback);
    }

    @Override
    public GetPageResult getStudentPagesAllSync(StudentPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getStudentPagesAll(request));
    }

    @Override
    public long getStudentPageAsync(RequestScope scope, StudentPageRequest request, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getStudentPage(request), callback);
    }

    @Override
    public List<StudentData> getStudentPageSync(StudentPageRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getStudentPage(request));
    }

    @Override
    public long getDictListAsync(RequestScope scope, DictRequest request, RequestCallback<List<DictData>> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.getDictList(request), callback);
    }

    @Override
    public List<DictData> getDictListSync(DictRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getDictList(request));
    }

    @Override
    public long deviceActiveAsync(RequestScope scope, DeviceActiveRequest request, RequestCallback<Boolean> callback) {
        return RxCallbackScheduler.schedule(scope, commonInfoRepository.deviceActive(request), callback);
    }

    @Override
    public Boolean deviceActiveSync(DeviceActiveRequest request) throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.deviceActive(request));
    }

    @Override
    public Long getServerTimeSync() throws NzBaseException {
        return RxCallbackScheduler.blockingGet(commonInfoRepository.getServerTime());
    }
}
