package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.exception.NzBaseException;
import com.adl.service.http.request.RequestScope;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * UserDaoCaller。
 */
public interface UserDaoCaller {

    Disposable queryAllStudentAsync(RequestCallback<List<StudentData>> callback);

    long queryAllStudentAsync(RequestScope scope, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryAllStudent();

    Disposable queryAllStudentWithFaceDataAsync(RequestCallback<List<StudentData>> callback);

    long queryAllStudentWithFaceDataAsync(RequestScope scope, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryAllStudentWithFaceData();

    Disposable queryAllStudentCountAsync(RequestCallback<Integer> callback);

    long queryAllStudentCountAsync(RequestScope scope, RequestCallback<Integer> callback);

    int queryAllStudentCount();

    Disposable queryStudentByAccountIdAsync(String accountId, RequestCallback<StudentData> callback);

    long queryStudentByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<StudentData> callback);

    StudentData queryStudentByAccountId(String accountId);

    Disposable queryStudentByAccountIdsAsync(List<String> accountIds, RequestCallback<List<StudentData>> callback);

    long queryStudentByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByAccountIds(List<String> accountIds);

    Disposable queryStudentByClassIdsAsync(List<String> classIds, RequestCallback<List<StudentData>> callback);

    long queryStudentByClassIdsAsync(RequestScope scope, List<String> classIds, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByClassIds(List<String> classIds);

    Disposable queryStudentByKeyWordAsync(String keyWord, RequestCallback<List<StudentData>> callback);

    long queryStudentByKeyWordAsync(RequestScope scope, String keyWord, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByKeyWord(String keyWord);

    Disposable queryStudentRecentUpdateTimeAsync(RequestCallback<Long> callback);

    long queryStudentRecentUpdateTimeAsync(RequestScope scope, RequestCallback<Long> callback);

    long queryStudentRecentUpdateTime();

    Disposable queryStudentByCardNumAsync(String cardNum, RequestCallback<List<StudentData>> callback);

    long queryStudentByCardNumAsync(RequestScope scope, String cardNum, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByCardNum(String cardNum);

    Disposable queryAllTeacherListAsync(RequestCallback<List<TeacherData>> callback);

    long queryAllTeacherListAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> queryAllTeacherList();

    Disposable queryAllTeacherListWithFaceDataAsync(RequestCallback<List<TeacherData>> callback);

    long queryAllTeacherListWithFaceDataAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> queryAllTeacherListWithFaceData();

    Disposable queryAllTeacherCountAsync(RequestCallback<Integer> callback);

    long queryAllTeacherCountAsync(RequestScope scope, RequestCallback<Integer> callback);

    int queryAllTeacherCount();

    Disposable queryTeacherByAccountIdAsync(String accountId, RequestCallback<TeacherData> callback);

    long queryTeacherByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<TeacherData> callback);

    TeacherData queryTeacherByAccountId(String accountId);

    Disposable queryTeacherListByAccountIdsAsync(List<String> accountIds, RequestCallback<List<TeacherData>> callback);

    long queryTeacherListByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> queryTeacherListByAccountIds(List<String> accountIds);

    Disposable queryLoginInfoAsync(RequestCallback<LoginInfoData> callback);

    long queryLoginInfoAsync(RequestScope scope, RequestCallback<LoginInfoData> callback);

    LoginInfoData queryLoginInfo();
}
