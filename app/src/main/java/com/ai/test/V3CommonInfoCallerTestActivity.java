package com.ai.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.ClassInfoRequest;
import com.adl.service.web.request.ClassListRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.response.ClassInfoData;
import com.adl.service.web.response.ClassListData;
import com.adl.service.web.response.GradeChineseNameData;
import com.adl.service.web.response.GradeTreeData;
import com.adl.service.web.response.LoginInfoData;
import com.adl.ts.general.R;

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
    }

    private void getGradeTreeAsync() {
        AdlService.getService().getCommonInfoCaller().getGradeTreeAsync(RequestScope.of(this), new RequestCallback<List<GradeTreeData>>() {
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getGradeTreeSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            return AdlService.getService().getCommonInfoCaller().getGradeTreeSync();
        }, new RequestCallback<List<GradeTreeData>>() {
            @Override
            public void onSuccess(List<GradeTreeData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeSync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getGradeChineseNameListAsync() {
        AdlService.getService().getCommonInfoCaller().getGradeChineseNameListAsync(RequestScope.of(this), new RequestCallback<List<GradeChineseNameData>>() {
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getGradeChineseNameListSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            return AdlService.getService().getCommonInfoCaller().getGradeChineseNameListSync();
        }, new RequestCallback<List<GradeChineseNameData>>() {
            @Override
            public void onSuccess(List<GradeChineseNameData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListSync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeChineseNameListSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getClassListAsync() {
        ClassListRequest request = ClassListRequest.builder().build();
        AdlService.getService().getCommonInfoCaller().getClassListAsync(RequestScope.of(this), request, new RequestCallback<List<ClassListData>>() {
            @Override
            public void onSuccess(List<ClassListData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassListAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getClassListSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            ClassListRequest request = ClassListRequest.builder().build();
            return AdlService.getService().getCommonInfoCaller().getClassListSync(request);
        }, new RequestCallback<List<ClassListData>>() {
            @Override
            public void onSuccess(List<ClassListData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListSync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassListSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassListSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassListSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getClassInfoAsync() {
        ClassInfoRequest request = ClassInfoRequest.builder("2011254439800274944").build();
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getClassInfoSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            ClassInfoRequest request = ClassInfoRequest.builder("2011254439800274944").build();
            return AdlService.getService().getCommonInfoCaller().getClassInfoSync(request);
        }, new RequestCallback<ClassInfoData>() {
            @Override
            public void onSuccess(ClassInfoData data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getClassInfoSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getLoginInfoAsync() {
        AdlService.getService().getCommonInfoCaller().getLoginInfoAsync(RequestScope.of(this), new RequestCallback<LoginInfoData>() {
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getLoginInfoSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            return AdlService.getService().getCommonInfoCaller().getLoginInfoSync();
        }, new RequestCallback<LoginInfoData>() {
            @Override
            public void onSuccess(LoginInfoData data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getLoginInfoSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
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
