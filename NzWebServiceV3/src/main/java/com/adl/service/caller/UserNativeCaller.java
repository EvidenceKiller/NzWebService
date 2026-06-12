package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.http.request.RequestScope;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * UserDaoCaller。
 */
public interface UserNativeCaller {

    Disposable queryAllStudentAsync(RequestCallback<List<StudentData>> callback);

    long queryAllStudentAsync(RequestScope scope, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryAllStudentSync();

    Disposable queryAllStudentWithFaceDataAsync(RequestCallback<List<StudentData>> callback);

    long queryAllStudentWithFaceDataAsync(RequestScope scope, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryAllStudentWithFaceDataSync();

    Disposable queryAllStudentCountAsync(RequestCallback<Integer> callback);

    long queryAllStudentCountAsync(RequestScope scope, RequestCallback<Integer> callback);

    int queryAllStudentCountSync();

    Disposable queryStudentByAccountIdAsync(String accountId, RequestCallback<StudentData> callback);

    long queryStudentByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<StudentData> callback);

    StudentData queryStudentByAccountIdSync(String accountId);

    Disposable queryStudentByAccountIdsAsync(List<String> accountIds, RequestCallback<List<StudentData>> callback);

    long queryStudentByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByAccountIdsSync(List<String> accountIds);

    Disposable queryStudentByClassIdsAsync(List<String> classIds, RequestCallback<List<StudentData>> callback);

    long queryStudentByClassIdsAsync(RequestScope scope, List<String> classIds, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByClassIdsSync(List<String> classIds);

    Disposable queryStudentByKeyWordAsync(String keyWord, RequestCallback<List<StudentData>> callback);

    long queryStudentByKeyWordAsync(RequestScope scope, String keyWord, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByKeyWordSync(String keyWord);

    Disposable queryStudentRecentUpdateTimeAsync(RequestCallback<Long> callback);

    long queryStudentRecentUpdateTimeAsync(RequestScope scope, RequestCallback<Long> callback);

    long queryStudentRecentUpdateTimeSync();

    Disposable queryStudentByCardNumAsync(String cardNum, RequestCallback<List<StudentData>> callback);

    long queryStudentByCardNumAsync(RequestScope scope, String cardNum, RequestCallback<List<StudentData>> callback);

    List<StudentData> queryStudentByCardNumSync(String cardNum);

    Disposable queryAllTeacherListAsync(RequestCallback<List<TeacherData>> callback);

    long queryAllTeacherListAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> queryAllTeacherListSync();

    Disposable queryAllTeacherListWithFaceDataAsync(RequestCallback<List<TeacherData>> callback);

    long queryAllTeacherListWithFaceDataAsync(RequestScope scope, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> queryAllTeacherListWithFaceDataSync();

    Disposable queryAllTeacherCountAsync(RequestCallback<Integer> callback);

    long queryAllTeacherCountAsync(RequestScope scope, RequestCallback<Integer> callback);

    int queryAllTeacherCountSync();

    Disposable queryTeacherByAccountIdAsync(String accountId, RequestCallback<TeacherData> callback);

    long queryTeacherByAccountIdAsync(RequestScope scope, String accountId, RequestCallback<TeacherData> callback);

    TeacherData queryTeacherByAccountIdSync(String accountId);

    Disposable queryTeacherListByAccountIdsAsync(List<String> accountIds, RequestCallback<List<TeacherData>> callback);

    long queryTeacherListByAccountIdsAsync(RequestScope scope, List<String> accountIds, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> queryTeacherListByAccountIdsSync(List<String> accountIds);
}
