package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
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

import java.util.List;

/**
 * CommonInfoCaller。
 */
public interface CommonInfoCaller {

    long getGradeTreeAsync(RequestScope scope, RequestCallback<List<GradeTreeData>> callback);

    List<GradeTreeData> getGradeTreeSync();

    long getGradeChineseNameListAsync(RequestScope scope, RequestCallback<List<GradeChineseNameData>> callback);

    List<GradeChineseNameData> getGradeChineseNameListSync();

    long getClassListAsync(RequestScope scope, ClassListRequest request, RequestCallback<List<ClassListData>> callback);

    List<ClassListData> getClassListSync(ClassListRequest request);

    long getClassInfoAsync(RequestScope scope, ClassInfoRequest request, RequestCallback<ClassInfoData> callback);

    ClassInfoData getClassInfoSync(ClassInfoRequest request);

    long getLoginInfoAsync(RequestScope scope, RequestCallback<LoginInfoData> callback);

    LoginInfoData getLoginInfoSync();

    long getAcayearListAsync(RequestScope scope, RequestCallback<List<AcayearData>> callback);

    List<AcayearData> getAcayearListSync();

    long getTeacherListAsync(RequestScope scope, TeacherListRequest request, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> getTeacherListSync(TeacherListRequest request);

    long getStudentPageAsync(RequestScope scope, StudentPageRequest request, RequestCallback<StudentPageData> callback);

    StudentPageData getStudentPageSync(StudentPageRequest request);

    long getCitizenPageAsync(RequestScope scope, CitizenPageRequest request, RequestCallback<CitizenPageData> callback);

    CitizenPageData getCitizenPageSync(CitizenPageRequest request);

    long getAccountInfoAsync(RequestScope scope, AccountInfoRequest request, RequestCallback<AccountInfoData> callback);

    AccountInfoData getAccountInfoSync(AccountInfoRequest request);

    long getDictsAsync(RequestScope scope, DictsRequest request, RequestCallback<List<DictsData>> callback);

    List<DictsData> getDictsSync(DictsRequest request);

    long deviceActiveAsync(RequestScope scope, DeviceActiveRequest request, RequestCallback<Boolean> callback);

    Boolean deviceActiveSync(DeviceActiveRequest request);

    long addBatchPageAsync(RequestScope scope, AddBatchPageRequest request, RequestCallback<Object> callback);

    Object addBatchPageSync(AddBatchPageRequest request);

}
