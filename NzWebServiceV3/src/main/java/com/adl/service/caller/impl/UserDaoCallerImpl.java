package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.UserDaoCaller;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.http.request.RequestScope;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.UserDaoRepository;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * CommonInfoCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class UserDaoCallerImpl implements UserDaoCaller {

    private final UserDaoRepository userDaoRepository;

    public UserDaoCallerImpl() {
        this.userDaoRepository = UserDaoRepository.getInstance();
    }

    @Override
    public Disposable queryAllStudentAsync(RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryAllStudent(), callback);
    }

    @Override
    public long queryAllStudentAsync(RequestScope scope, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryAllStudent(), callback);
    }

    @Override
    public List<StudentData> queryAllStudent() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryAllStudent());
    }

    @Override
    public Disposable queryAllStudentWithFaceDataAsync(RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryAllStudentWithFaceData(), callback);
    }

    @Override
    public long queryAllStudentWithFaceDataAsync(RequestScope scope, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryAllStudentWithFaceData(), callback);
    }

    @Override
    public List<StudentData> queryAllStudentWithFaceData() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryAllStudentWithFaceData());
    }

    @Override
    public Disposable queryAllStudentCountAsync(RequestCallback<Integer> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryAllStudentCount(), callback);
    }

    @Override
    public long queryAllStudentCountAsync(RequestScope scope, RequestCallback<Integer> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryAllStudentCount(), callback);
    }

    @Override
    public int queryAllStudentCount() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryAllStudentCount(), Integer.class);
    }

    @Override
    public Disposable queryStudentByAccountIdAsync(String accountId, RequestCallback<StudentData> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryStudentByAccountId(accountId), callback);
    }

    @Override
    public long queryStudentByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<StudentData> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryStudentByAccountId(accountId), callback);
    }

    @Override
    public StudentData queryStudentByAccountId(String accountId) {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryStudentByAccountId(accountId));
    }

    @Override
    public Disposable queryStudentByAccountIdsAsync(List<String> accountIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryStudentByAccountIds(accountIds), callback);
    }

    @Override
    public long queryStudentByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryStudentByAccountIds(accountIds), callback);
    }

    @Override
    public List<StudentData> queryStudentByAccountIds(List<String> accountIds) {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryStudentByAccountIds(accountIds));
    }

    @Override
    public Disposable queryStudentByClassIdsAsync(List<String> classIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryStudentByClassIds(classIds), callback);
    }

    @Override
    public long queryStudentByClassIdsAsync(RequestScope scope, List<String> classIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryStudentByClassIds(classIds), callback);
    }

    @Override
    public List<StudentData> queryStudentByClassIds(List<String> classIds) {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryStudentByClassIds(classIds));
    }

    @Override
    public Disposable queryStudentByKeyWordAsync(String keyWord, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryStudentByKeyWord(keyWord), callback);
    }

    @Override
    public long queryStudentByKeyWordAsync(RequestScope scope, String keyWord, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryStudentByKeyWord(keyWord), callback);
    }

    @Override
    public List<StudentData> queryStudentByKeyWord(String keyWord) {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryStudentByKeyWord(keyWord));
    }

    @Override
    public Disposable queryStudentRecentUpdateTimeAsync(RequestCallback<Long> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryStudentRecentUpdateTime(), callback);
    }

    @Override
    public long queryStudentRecentUpdateTimeAsync(RequestScope scope, RequestCallback<Long> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryStudentRecentUpdateTime(), callback);
    }

    @Override
    public long queryStudentRecentUpdateTime() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryStudentRecentUpdateTime(), Long.class);
    }

    @Override
    public Disposable queryStudentByCardNumAsync(String cardNum, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryStudentByCardNum(cardNum), callback);
    }

    @Override
    public long queryStudentByCardNumAsync(RequestScope scope, String cardNum, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryStudentByCardNum(cardNum), callback);
    }

    @Override
    public List<StudentData> queryStudentByCardNum(String cardNum) {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryStudentByCardNum(cardNum));
    }

    @Override
    public Disposable queryAllTeacherListAsync(RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryAllTeacherList(), callback);
    }

    @Override
    public long queryAllTeacherListAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryAllTeacherList(), callback);
    }

    @Override
    public List<TeacherData> queryAllTeacherList() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryAllTeacherList());
    }

    @Override
    public Disposable queryAllTeacherListWithFaceDataAsync(RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryAllTeacherListWithFaceData(), callback);
    }

    @Override
    public long queryAllTeacherListWithFaceDataAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryAllTeacherListWithFaceData(), callback);
    }

    @Override
    public List<TeacherData> queryAllTeacherListWithFaceData() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryAllTeacherListWithFaceData());
    }

    @Override
    public Disposable queryAllTeacherCountAsync(RequestCallback<Integer> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryAllTeacherCount(), callback);
    }

    @Override
    public long queryAllTeacherCountAsync(RequestScope scope, RequestCallback<Integer> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryAllTeacherCount(), callback);
    }

    @Override
    public int queryAllTeacherCount() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryAllTeacherCount(), Integer.class);
    }

    @Override
    public Disposable queryTeacherByAccountIdAsync(String accountId, RequestCallback<TeacherData> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryTeacherByAccountId(accountId), callback);
    }

    @Override
    public long queryTeacherByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<TeacherData> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryTeacherByAccountId(accountId), callback);
    }

    @Override
    public TeacherData queryTeacherByAccountId(String accountId) {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryTeacherByAccountId(accountId));
    }

    @Override
    public Disposable queryTeacherListByAccountIdsAsync(List<String> accountIds, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryTeacherListByAccountIds(accountIds), callback);
    }

    @Override
    public long queryTeacherListByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryTeacherListByAccountIds(accountIds), callback);
    }

    @Override
    public List<TeacherData> queryTeacherListByAccountIds(List<String> accountIds) {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryTeacherListByAccountIds(accountIds));
    }

    @Override
    public Disposable queryLoginInfoAsync(RequestCallback<LoginInfoData> callback) {
        return RxCallbackScheduler.schedule(userDaoRepository.queryLoginInfo(), callback);
    }

    @Override
    public long queryLoginInfoAsync(RequestScope scope, RequestCallback<LoginInfoData> callback) {
        return RxCallbackScheduler.schedule(scope, userDaoRepository.queryLoginInfo(), callback);
    }

    @Override
    public LoginInfoData queryLoginInfo() {
        return RxCallbackScheduler.blockingGetNoThrow(userDaoRepository.queryLoginInfo(), LoginInfoData.class);
    }
}
