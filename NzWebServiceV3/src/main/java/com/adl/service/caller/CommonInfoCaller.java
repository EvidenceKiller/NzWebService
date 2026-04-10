package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.AddBatchPageRequest;
import com.adl.service.web.request.CitizenPageRequest;
import com.adl.service.web.request.ClassInfoRequest;
import com.adl.service.web.request.ClassListRequest;
import com.adl.service.web.request.DeviceActiveRequest;
import com.adl.service.web.request.DictsRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.StudentPageRequest;
import com.adl.service.web.request.TeacherListRequest;
import com.adl.service.web.response.AcayearData;
import com.adl.service.web.response.AccountInfoData;
import com.adl.service.web.response.CitizenPageData;
import com.adl.service.web.response.ClassInfoData;
import com.adl.service.web.response.ClassListData;
import com.adl.service.web.response.DictsData;
import com.adl.service.web.response.GradeChineseNameData;
import com.adl.service.web.response.GradeTreeData;
import com.adl.service.web.response.LoginInfoData;
import com.adl.service.web.response.StudentPageData;
import com.adl.service.web.response.TeacherData;

import java.util.List;

/**
 * CommonInfoCaller。
 */
public interface CommonInfoCaller {

    long getGradeTreeAsync(RequestScope scope, RequestCallback<List<GradeTreeData>> callback);

    List<GradeTreeData> getGradeTreeSync() throws NzBaseException;

    long getGradeChineseNameListAsync(RequestScope scope, RequestCallback<List<GradeChineseNameData>> callback);

    List<GradeChineseNameData> getGradeChineseNameListSync() throws NzBaseException;

    long getClassListAsync(RequestScope scope, ClassListRequest request, RequestCallback<List<ClassListData>> callback);

    List<ClassListData> getClassListSync(ClassListRequest request) throws NzBaseException;

    long getClassInfoAsync(RequestScope scope, ClassInfoRequest request, RequestCallback<ClassInfoData> callback);

    ClassInfoData getClassInfoSync(ClassInfoRequest request) throws NzBaseException;

    long getLoginInfoAsync(RequestScope scope, RequestCallback<LoginInfoData> callback);

    LoginInfoData getLoginInfoSync() throws NzBaseException;

    long getAcayearListAsync(RequestScope scope, RequestCallback<List<AcayearData>> callback);

    List<AcayearData> getAcayearListSync() throws NzBaseException;

    long getTeacherListAsync(RequestScope scope, TeacherListRequest request, RequestCallback<List<TeacherData>> callback);

    List<TeacherData> getTeacherListSync(TeacherListRequest request) throws NzBaseException;

    long getStudentPageAsync(RequestScope scope, StudentPageRequest request, RequestCallback<StudentPageData> callback);

    StudentPageData getStudentPageSync(StudentPageRequest request) throws NzBaseException;

    long getCitizenPageAsync(RequestScope scope, CitizenPageRequest request, RequestCallback<CitizenPageData> callback);

    CitizenPageData getCitizenPageSync(CitizenPageRequest request) throws NzBaseException;

    long getDictsAsync(RequestScope scope, DictsRequest request, RequestCallback<List<DictsData>> callback);

    List<DictsData> getDictsSync(DictsRequest request) throws NzBaseException;

    long deviceActiveAsync(RequestScope scope, DeviceActiveRequest request, RequestCallback<Boolean> callback);

    Boolean deviceActiveSync(DeviceActiveRequest request) throws NzBaseException;

    long addBatchPageAsync(RequestScope scope, AddBatchPageRequest request, RequestCallback<Object> callback);

    Object addBatchPageSync(AddBatchPageRequest request) throws NzBaseException;

}
