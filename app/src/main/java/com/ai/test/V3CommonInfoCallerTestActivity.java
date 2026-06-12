package com.ai.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.adl.service.AdlService;
import com.adl.service.data.PageSummaryData;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.callback.RequestUserCallback;
import com.adl.service.http.request.BaseDirection;
import com.adl.service.http.request.BaseSort;
import com.adl.service.http.request.ClassInfoRequest;
import com.adl.service.http.request.ClassPageRequest;
import com.adl.service.http.request.DeviceActiveRequest;
import com.adl.service.http.request.DictRequest;
import com.adl.service.http.request.EmptyRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.StudentPageRequest;
import com.adl.service.http.request.TeacherPageRequest;
import com.adl.service.data.AcayearData;
import com.adl.service.data.ClassInfoData;
import com.adl.service.data.ClassData;
import com.adl.service.data.DictData;
import com.adl.service.data.GradeChineseNameData;
import com.adl.service.data.GradeTreeData;
import com.adl.service.data.LoginInfoData;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.ts.general.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 演示在独立界面中调用 SDK「学生列表」接口。
 */
public class V3CommonInfoCallerTestActivity extends AppCompatActivity {

    private static final String TAG = "ZXN_TEST";
    private TextView resultView;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_v3_interface_caller_test);

        resultView = findViewById(R.id.tv_result);
        gridLayout = findViewById(R.id.gl_test);
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
        findViewById(R.id.btn_clear).setOnClickListener(v -> resultView.setText(""));

        createButton("loadCommonInfo").setOnClickListener(v -> loadCommonInfo());
        createButton("loadCommonInfoForce").setOnClickListener(v -> loadCommonInfoForce());

        createButton("getGradeTreeAsync").setOnClickListener(v -> getGradeTreeAsync());
        createButton("getGradeTreeSync").setOnClickListener(v -> getGradeTreeSync());

        createButton("getGradeChineseNameListAsync").setOnClickListener(v -> getGradeChineseNameListAsync());
        createButton("getGradeChineseNameListSync").setOnClickListener(v -> getGradeChineseNameListSync());

        createButton("getClassListAsync").setOnClickListener(v -> getClassListAsync());
        createButton("getClassListSync").setOnClickListener(v -> getClassListSync());

        createButton("getClassInfoAsync").setOnClickListener(v -> getClassInfoAsync());
        createButton("getClassInfoSync").setOnClickListener(v -> getClassInfoSync());

        createButton("getLoginInfoAsync").setOnClickListener(v -> getLoginInfoAsync());
        createButton("getLoginInfoSync").setOnClickListener(v -> getLoginInfoSync());

        createButton("getAcayearListAsync").setOnClickListener(v -> getAcayearListAsync());
        createButton("getAcayearListSync").setOnClickListener(v -> getAcayearListSync());

        createButton("getTeacherListAsync").setOnClickListener(v -> getTeacherListAsync());
        createButton("getTeacherListSync").setOnClickListener(v -> getTeacherListSync());

        createButton("getStudentPageAsync").setOnClickListener(v -> getStudentPageAsync());
        createButton("getStudentPageSync").setOnClickListener(v -> getStudentPageSync());

        createButton("getDictsAsync").setOnClickListener(v -> getDictsAsync());
        createButton("getDictsSync").setOnClickListener(v -> getDictsSync());

        createButton("deviceActiveAsync").setOnClickListener(v -> deviceActiveAsync());
        createButton("deviceActiveSync").setOnClickListener(v -> deviceActiveSync());

        createButton("queryAllStudentSync").setOnClickListener(v -> queryAllStudentSync());
        createButton("queryAllStudentWithFaceDataSync").setOnClickListener(v -> queryAllStudentWithFaceDataSync());
        createButton("queryAllStudentCountSync").setOnClickListener(v -> queryAllStudentCountSync());
        createButton("queryStudentByAccountIdSync").setOnClickListener(v -> queryStudentByAccountIdSync());
        createButton("queryStudentByAccountIdsSync").setOnClickListener(v -> queryStudentByAccountIdsSync());
        createButton("queryStudentByClassIdsSync").setOnClickListener(v -> queryStudentByClassIdsSync());
        createButton("queryStudentByCarNumSync").setOnClickListener(v -> queryStudentByCarNumSync());

        createButton("queryAllTeacherListSync").setOnClickListener(v -> queryAllTeacherListSync());
        createButton("queryAllTeacherListWithFaceDataSync").setOnClickListener(v -> queryAllTeacherListWithFaceDataSync());
        createButton("queryTeacherByAccountIdSync").setOnClickListener(v -> queryTeacherByAccountIdSync());
        createButton("queryTeacherListByAccountIdsSync").setOnClickListener(v -> queryTeacherListByAccountIdsSync());

        createButton("getTeacherListsAllAsync").setOnClickListener(v -> getTeacherListsAllAsync());
        createButton("getTeacherListsAllSync").setOnClickListener(v -> getTeacherListsAllSync());

        createButton("getStudentPagesAllAsync").setOnClickListener(v -> getStudentPagesAllAsync());
        createButton("getStudentPagesAllSync").setOnClickListener(v -> getStudentPagesAllSync());
    }

    private void loadCommonInfo() {
        AdlService.getService().getCommonInfoCaller().loadCommonInfoAsync(RequestScope.of(this), false, new RequestUserCallback(this, true) {
            @Override
            public void nextStatus(int status, String msg) {

            }

            @Override
            public void success(Object data) {

            }

            @Override
            public void error(String error) {

            }
        });
    }

    private void loadCommonInfoForce() {
        AdlService.getService().getCommonInfoCaller().loadCommonInfoAsync(RequestScope.of(this), true, new RequestUserCallback(this, true) {
            @Override
            public void nextStatus(int status, String msg) {

            }

            @Override
            public void success(Object data) {

            }

            @Override
            public void error(String error) {

            }
        });
    }

    private void getGradeTreeAsync() {
        AdlService.getService().getCommonInfoCaller().getGradeTreeAsync(RequestScope.of(this), EmptyRequest.builder().build(), new RequestCallback<List<GradeTreeData>>() {
            @Override
            public void onSuccess(List<GradeTreeData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getGradeTreeSync() {
        ResponseResult<List<GradeTreeData>> result = AdlService.getService().getCommonInfoCaller().getGradeTreeSync(EmptyRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getGradeChineseNameListAsync() {
        AdlService.getService().getCommonInfoCaller().getGradeChineseNameListAsync(RequestScope.of(this), EmptyRequest.builder().build(), new RequestCallback<List<GradeChineseNameData>>() {
            @Override
            public void onSuccess(List<GradeChineseNameData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getGradeChineseNameListSync() {
        ResponseResult<List<GradeChineseNameData>> result = AdlService.getService().getCommonInfoCaller().getGradeChineseNameListSync(EmptyRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getClassListAsync() {
        ClassPageRequest request = ClassPageRequest.builder().build();
        AdlService.getService().getCommonInfoCaller().getClassPageAsync(RequestScope.of(this), request, new RequestCallback<List<ClassData>>() {
            @Override
            public void onSuccess(List<ClassData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getClassListSync() {
        ResponseResult<List<ClassData>> result = AdlService.getService().getCommonInfoCaller().getClassPageSync(ClassPageRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getClassListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getClassListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getClassInfoAsync() {
        List<BaseSort> sorts = new ArrayList<>();
        sorts.add(new BaseSort().setColumn("classNum").setDirection(BaseDirection.DESC));
        sorts.add(new BaseSort().setColumn("className").setDirection(BaseDirection.ASC));
        ClassInfoRequest request = ClassInfoRequest.builder("2011254439800274944")
                .sorts(sorts)
                .build();
        AdlService.getService().getCommonInfoCaller().getClassInfoAsync(RequestScope.of(this), request, new RequestCallback<ClassInfoData>() {
            @Override
            public void onSuccess(ClassInfoData data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getClassInfoSync() {
        List<BaseSort> sorts = new ArrayList<>();
        sorts.add(new BaseSort().setColumn("classNum").setDirection(BaseDirection.DESC));
        sorts.add(new BaseSort().setColumn("className").setDirection(BaseDirection.ASC));
        ClassInfoRequest request = ClassInfoRequest.builder("2011254439800274944")
                .sorts(sorts)
                .build();
        ResponseResult<ClassInfoData> result = AdlService.getService().getCommonInfoCaller().getClassInfoSync(request);
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getLoginInfoAsync() {
        AdlService.getService().getCommonInfoCaller().getLoginInfoAsync(RequestScope.of(this), EmptyRequest.builder().build(), new RequestCallback<LoginInfoData>() {
            @Override
            public void onSuccess(LoginInfoData data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getLoginInfoSync() {
        ResponseResult<LoginInfoData> result = AdlService.getService().getCommonInfoCaller().getLoginInfoSync(EmptyRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getAcayearListAsync() {
        AdlService.getService().getCommonInfoCaller().getAcayearListAsync(RequestScope.of(this), EmptyRequest.builder().build(), new RequestCallback<List<AcayearData>>() {
            @Override
            public void onSuccess(List<AcayearData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getAcayearListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getAcayearListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getAcayearListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getAcayearListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getAcayearListSync() {
        ResponseResult<List<AcayearData>> result = AdlService.getService().getCommonInfoCaller().getAcayearListSync(EmptyRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getAcayearListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getAcayearListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getTeacherListAsync() {
        TeacherPageRequest request = TeacherPageRequest.builder()
                .build();
        AdlService.getService().getCommonInfoCaller().getTeacherPageAsync(RequestScope.of(this), request, new RequestCallback<List<TeacherData>>() {
            @Override
            public void onSuccess(List<TeacherData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getTeacherListSync() {
        ResponseResult<List<TeacherData>> result = AdlService.getService().getCommonInfoCaller().getTeacherPageSync(TeacherPageRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getStudentPageAsync() {
        StudentPageRequest request = StudentPageRequest.builder()
                .current(1L)
                .faceType(2)
                .build();
        AdlService.getService().getCommonInfoCaller().getStudentPageAsync(RequestScope.of(this), request, new RequestCallback<List<StudentData>>() {
            @Override
            public void onSuccess(List<StudentData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getStudentPageSync() {
        ResponseResult<List<StudentData>> result = AdlService.getService().getCommonInfoCaller().getStudentPageSync(StudentPageRequest.builder().current(1L).build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getDictsAsync() {
        DictRequest request = DictRequest.builder().build();
        AdlService.getService().getCommonInfoCaller().getDictListAsync(RequestScope.of(this), request, new RequestCallback<List<DictData>>() {
            @Override
            public void onSuccess(List<DictData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getDictsAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getDictsAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getDictsAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getDictsAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getDictsSync() {
        ResponseResult<List<DictData>> result = AdlService.getService().getCommonInfoCaller().getDictListSync(DictRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getDictsSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getDictsSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void deviceActiveAsync() {
        DeviceActiveRequest request = DeviceActiveRequest.builder("", "").build();
        AdlService.getService().getCommonInfoCaller().deviceActiveAsync(RequestScope.of(this), request, new RequestCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                Log.d(TAG, "CommonInfoCallerTestActivity::deviceActiveAsync::onSuccess : data : " + data);
                resultView.setText(String.valueOf(data));
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::deviceActiveAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void deviceActiveSync() {
        ResponseResult<Boolean> result = AdlService.getService().getCommonInfoCaller().deviceActiveSync(DeviceActiveRequest.builder("", "").build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::deviceActiveSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::deviceActiveSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void queryAllStudentSync() {
        List<StudentData> data = AdlService.getService().getUserNativeCaller().queryAllStudentSync();
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllStudentSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllStudentSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllStudentSync::onSuccess : data is null");
        }
    }

    private void queryAllStudentWithFaceDataSync() {
        List<StudentData> data = AdlService.getService().getUserNativeCaller().queryAllStudentWithFaceDataSync();
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllStudentWithFaceDataSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllStudentWithFaceDataSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllStudentWithFaceDataSync::onSuccess : data is null");
        }
    }

    private void queryAllStudentCountSync() {
        int count = AdlService.getService().getUserNativeCaller().queryAllStudentCountSync();
        Log.d(TAG, "CommonInfoCallerTestActivity::queryAllStudentCountSync::onSuccess : count : " + count);
        resultView.setText(String.valueOf(count));
    }

    private void queryStudentByAccountIdSync() {
        StudentData data = AdlService.getService().getUserNativeCaller().queryStudentByAccountIdSync("test_account_id");
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByAccountIdSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByAccountIdSync::onSuccess : data is null");
        }
    }

    private void queryStudentByAccountIdsSync() {
        List<String> accountIds = new ArrayList<>();
        accountIds.add("test_account_id_1");
        accountIds.add("test_account_id_2");
        List<StudentData> data = AdlService.getService().getUserNativeCaller().queryStudentByAccountIdsSync(accountIds);
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByAccountIdsSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByAccountIdsSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByAccountIdsSync::onSuccess : data is null");
        }
    }

    private void queryStudentByClassIdsSync() {
        List<String> classIds = new ArrayList<>();
        classIds.add("test_class_id_1");
        classIds.add("test_class_id_2");
        List<StudentData> data = AdlService.getService().getUserNativeCaller().queryStudentByClassIdsSync(classIds);
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByClassIdsSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByClassIdsSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByClassIdsSync::onSuccess : data is null");
        }
    }

    private void queryStudentByCarNumSync() {
        List<StudentData> data = AdlService.getService().getUserNativeCaller().queryStudentByCardNumSync("1234567890");
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByCarNumSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByCarNumSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryStudentByCarNumSync::onSuccess : data is null");
        }
    }

    private void queryAllTeacherListSync() {
        List<TeacherData> data = AdlService.getService().getUserNativeCaller().queryAllTeacherListSync();
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllTeacherListSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllTeacherListSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllTeacherListSync::onSuccess : data is null");
        }
    }

    private void queryAllTeacherListWithFaceDataSync() {
        List<TeacherData> data = AdlService.getService().getUserNativeCaller().queryAllTeacherListWithFaceDataSync();
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllTeacherListWithFaceDataSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllTeacherListWithFaceDataSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryAllTeacherListWithFaceDataSync::onSuccess : data is null");
        }
    }

    private void queryTeacherByAccountIdSync() {
        TeacherData data = AdlService.getService().getUserNativeCaller().queryTeacherByAccountIdSync("test_teacher_account_id");
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryTeacherByAccountIdSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryTeacherByAccountIdSync::onSuccess : data is null");
        }
    }

    private void queryTeacherListByAccountIdsSync() {
        List<String> accountIds = new ArrayList<>();
        accountIds.add("test_teacher_account_id_1");
        accountIds.add("test_teacher_account_id_2");
        List<TeacherData> data = AdlService.getService().getUserNativeCaller().queryTeacherListByAccountIdsSync(accountIds);
        if (data != null) {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryTeacherListByAccountIdsSync::onSuccess : data size : " + data.size());
            Log.d(TAG, "CommonInfoCallerTestActivity::queryTeacherListByAccountIdsSync::onSuccess : data : " + data);
            resultView.setText(data.toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::queryTeacherListByAccountIdsSync::onSuccess : data is null");
        }
    }

    private void getTeacherListsAllAsync() {
        TeacherPageRequest request = TeacherPageRequest.builder().pageSize(3L).build();
        AdlService.getService().getCommonInfoCaller().getTeacherPagesAllAsync(RequestScope.of(this), request, new RequestCallback<PageSummaryData>() {
            @Override
            public void onSuccess(PageSummaryData data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListsAllAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListsAllAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListsAllAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getTeacherListsAllSync() {
        ResponseResult<PageSummaryData> result = AdlService.getService().getCommonInfoCaller().getTeacherPagesAllSync(TeacherPageRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListsAllSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getTeacherListsAllSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getStudentPagesAllAsync() {
        StudentPageRequest request = StudentPageRequest.builder().current(1L).pageSize(1000L).faceType(2).build();
        AdlService.getService().getCommonInfoCaller().getStudentPagesAllAsync(RequestScope.of(this), request, new RequestCallback<PageSummaryData>() {
            @Override
            public void onSuccess(PageSummaryData data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPagesAllAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPagesAllAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPagesAllAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getStudentPagesAllSync() {
        ResponseResult<PageSummaryData> result = AdlService.getService().getCommonInfoCaller().getStudentPagesAllSync(StudentPageRequest.builder().current(1L).pageSize(1000L).faceType(2).build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPagesAllSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "CommonInfoCallerTestActivity::getStudentPagesAllSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg() + ", data : " + result.getData());
            resultView.setText(result.getMsg());
        }
    }

    private Button createButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setAllCaps(false);
        button.setId(View.generateViewId());

        // 设置布局参数
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0; // 配合 columnWeight 使用
        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f); // 平分列宽
        button.setLayoutParams(params);
        gridLayout.addView(button);
        return button;
    }

    @Override
    protected void onDestroy() {
        AdlService.getService().cancelRequestScope(RequestScope.of(this));
        super.onDestroy();
    }
}
