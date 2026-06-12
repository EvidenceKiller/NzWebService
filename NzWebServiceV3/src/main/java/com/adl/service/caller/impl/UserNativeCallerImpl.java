package com.adl.service.caller.impl;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.caller.UserNativeCaller;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.http.request.RequestScope;
import com.adl.service.internal.RxCallbackScheduler;
import com.adl.service.repository.UserNativeRepository;
import com.adl.service.utils.CommonUtil;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * CommonInfoCaller 实现（SDK 内部使用，通过 {@link AdlService} 暴露）。
 */
public final class UserNativeCallerImpl implements UserNativeCaller {

    private final UserNativeRepository userNativeRepository;

    public UserNativeCallerImpl() {
        this.userNativeRepository = UserNativeRepository.getInstance();
    }

    @Override
    public Disposable queryAllStudentAsync(RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryAllStudent(), callback);
    }

    @Override
    public long queryAllStudentAsync(RequestScope scope, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryAllStudent(), callback);
    }

    @Override
    public List<StudentData> queryAllStudentSync() {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryAllStudent());
    }

    @Override
    public Disposable queryAllStudentWithFaceDataAsync(RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryAllStudentWithFaceData(), callback);
    }

    @Override
    public long queryAllStudentWithFaceDataAsync(RequestScope scope, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryAllStudentWithFaceData(), callback);
    }

    @Override
    public List<StudentData> queryAllStudentWithFaceDataSync() {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryAllStudentWithFaceData());
    }

    @Override
    public Disposable queryAllStudentCountAsync(RequestCallback<Integer> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryAllStudentCount(), callback);
    }

    @Override
    public long queryAllStudentCountAsync(RequestScope scope, RequestCallback<Integer> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryAllStudentCount(), callback);
    }

    @Override
    public int queryAllStudentCountSync() {
        Integer count =  RxCallbackScheduler.scheduleSync(userNativeRepository.queryAllStudentCount());
        if (count == null) {
            return CommonUtil.createEmptyObject(Integer.class);
        } else {
            return count;
        }
    }

    @Override
    public Disposable queryStudentByAccountIdAsync(String accountId, RequestCallback<StudentData> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryStudentByAccountId(accountId), callback);
    }

    @Override
    public long queryStudentByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<StudentData> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryStudentByAccountId(accountId), callback);
    }

    @Override
    public StudentData queryStudentByAccountIdSync(String accountId) {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryStudentByAccountId(accountId));
    }

    @Override
    public Disposable queryStudentByAccountIdsAsync(List<String> accountIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryStudentByAccountIds(accountIds), callback);
    }

    @Override
    public long queryStudentByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryStudentByAccountIds(accountIds), callback);
    }

    @Override
    public List<StudentData> queryStudentByAccountIdsSync(List<String> accountIds) {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryStudentByAccountIds(accountIds));
    }

    @Override
    public Disposable queryStudentByClassIdsAsync(List<String> classIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryStudentByClassIds(classIds), callback);
    }

    @Override
    public long queryStudentByClassIdsAsync(RequestScope scope, List<String> classIds, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryStudentByClassIds(classIds), callback);
    }

    @Override
    public List<StudentData> queryStudentByClassIdsSync(List<String> classIds) {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryStudentByClassIds(classIds));
    }

    @Override
    public Disposable queryStudentByKeyWordAsync(String keyWord, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryStudentByKeyWord(keyWord), callback);
    }

    @Override
    public long queryStudentByKeyWordAsync(RequestScope scope, String keyWord, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryStudentByKeyWord(keyWord), callback);
    }

    @Override
    public List<StudentData> queryStudentByKeyWordSync(String keyWord) {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryStudentByKeyWord(keyWord));
    }

    @Override
    public Disposable queryStudentRecentUpdateTimeAsync(RequestCallback<Long> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryStudentRecentUpdateTime(), callback);
    }

    @Override
    public long queryStudentRecentUpdateTimeAsync(RequestScope scope, RequestCallback<Long> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryStudentRecentUpdateTime(), callback);
    }

    @Override
    public long queryStudentRecentUpdateTimeSync() {
        Long time = RxCallbackScheduler.scheduleSync(userNativeRepository.queryStudentRecentUpdateTime());
        if (time == null) {
            return CommonUtil.createEmptyObject(Long.class);
        } else {
            return time;
        }
    }

    @Override
    public Disposable queryStudentByCardNumAsync(String cardNum, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryStudentByCardNum(cardNum), callback);
    }

    @Override
    public long queryStudentByCardNumAsync(RequestScope scope, String cardNum, RequestCallback<List<StudentData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryStudentByCardNum(cardNum), callback);
    }

    @Override
    public List<StudentData> queryStudentByCardNumSync(String cardNum) {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryStudentByCardNum(cardNum));
    }

    @Override
    public Disposable queryAllTeacherListAsync(RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryAllTeacherList(), callback);
    }

    @Override
    public long queryAllTeacherListAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryAllTeacherList(), callback);
    }

    @Override
    public List<TeacherData> queryAllTeacherListSync() {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryAllTeacherList());
    }

    @Override
    public Disposable queryAllTeacherListWithFaceDataAsync(RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryAllTeacherListWithFaceData(), callback);
    }

    @Override
    public long queryAllTeacherListWithFaceDataAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryAllTeacherListWithFaceData(), callback);
    }

    @Override
    public List<TeacherData> queryAllTeacherListWithFaceDataSync() {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryAllTeacherListWithFaceData());
    }

    @Override
    public Disposable queryAllTeacherCountAsync(RequestCallback<Integer> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryAllTeacherCount(), callback);
    }

    @Override
    public long queryAllTeacherCountAsync(RequestScope scope, RequestCallback<Integer> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryAllTeacherCount(), callback);
    }

    @Override
    public int queryAllTeacherCountSync() {
        Integer count = RxCallbackScheduler.scheduleSync(userNativeRepository.queryAllTeacherCount());
        if (count == null) {
            return CommonUtil.createEmptyObject(Integer.class);
        } else {
            return count;
        }
    }

    @Override
    public Disposable queryTeacherByAccountIdAsync(String accountId, RequestCallback<TeacherData> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryTeacherByAccountId(accountId), callback);
    }

    @Override
    public long queryTeacherByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<TeacherData> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryTeacherByAccountId(accountId), callback);
    }

    @Override
    public TeacherData queryTeacherByAccountIdSync(String accountId) {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryTeacherByAccountId(accountId));
    }

    @Override
    public Disposable queryTeacherListByAccountIdsAsync(List<String> accountIds, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.scheduleAsync(userNativeRepository.queryTeacherListByAccountIds(accountIds), callback);
    }

    @Override
    public long queryTeacherListByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<TeacherData>> callback) {
        return RxCallbackScheduler.scheduleAsync(scope, userNativeRepository.queryTeacherListByAccountIds(accountIds), callback);
    }

    @Override
    public List<TeacherData> queryTeacherListByAccountIdsSync(List<String> accountIds) {
        return RxCallbackScheduler.scheduleSync(userNativeRepository.queryTeacherListByAccountIds(accountIds));
    }
}
