package com.ai.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.http.request.CheckStudentInPlanRequest;
import com.adl.service.http.request.PlanClassPageRequest;
import com.adl.service.http.request.PlanInfoRequest;
import com.adl.service.http.request.PlanPageRequest;
import com.adl.service.http.request.PlanStudentPageRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.StandardConfigPageRequest;
import com.adl.service.data.PlanClassData;
import com.adl.service.data.PlanInfoData;
import com.adl.service.data.PlanData;
import com.adl.service.data.PlanStudentData;
import com.adl.service.data.PageSummaryData;
import com.adl.service.data.StandardConfigData;
import com.adl.ts.general.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/** 演示在独立界面中调用 SDK「OrgTestCaller」接口。 */
public class V3OrgTestCallerTestActivity extends AppCompatActivity {

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

        createButton("getStandardConfigPageAsync").setOnClickListener(v -> getStandardConfigPageAsync());
        createButton("getStandardConfigPageSync").setOnClickListener(v -> getStandardConfigPageSync());
        createButton("getPlanStudentPageAsync").setOnClickListener(v -> getPlanStudentPageAsync());
        createButton("getPlanStudentPageSync").setOnClickListener(v -> getPlanStudentPageSync());
        createButton("getPlanPageAsync").setOnClickListener(v -> getPlanPageAsync());
        createButton("getPlanPageSync").setOnClickListener(v -> getPlanPageSync());
        createButton("getAllPlanPagesAsync").setOnClickListener(v -> getAllPlanPagesAsync());
        createButton("getAllPlanPagesSync").setOnClickListener(v -> getAllPlanPagesSync());
        createButton("getPlanInfoAsync").setOnClickListener(v -> getPlanInfoAsync());
        createButton("getPlanInfoSync").setOnClickListener(v -> getPlanInfoSync());
        createButton("getPlanClassListAsync").setOnClickListener(v -> getPlanClassListAsync());
        createButton("getPlanClassListSync").setOnClickListener(v -> getPlanClassListSync());
        createButton("getCheckStudentAsync").setOnClickListener(v -> checkStudentInPlanAsync());
        createButton("getCheckStudentSync").setOnClickListener(v -> checkStudentInPlanSync());
    }


    private StandardConfigPageRequest buildStandardConfigPageRequest() {
        return StandardConfigPageRequest.builder("")
                .build();
    }

    private PlanStudentPageRequest buildPlanStudentPageRequest() {
        return PlanStudentPageRequest.builder("fc7a820389f744b5a094c775ba3037db")
                .build();
    }

    private PlanPageRequest buildPlanPageRequest() {
        return PlanPageRequest.builder()
                .build();
    }

    private PlanPageRequest buildPlanListRequest() {
        return PlanPageRequest.builder()
                .current(1L)
                .build();
    }

    private PlanClassPageRequest buildPlanClassListRequest() {
        return PlanClassPageRequest.builder("fc7a820389f744b5a094c775ba3037db")
                .build();
    }

    private CheckStudentInPlanRequest buildCheckStudentInPlanRequest() {
        return CheckStudentInPlanRequest.builder("fc7a820389f744b5a094c775ba3037db")
                .build();
    }

    private void getStandardConfigPageAsync() {
        StandardConfigPageRequest request = buildStandardConfigPageRequest();
        AdlService.getService().getOrgTestCaller().getStandardConfigPageAsync(RequestScope.of(this), request, new RequestCallback<List<StandardConfigData>>() {
            @Override
            public void onSuccess(List<StandardConfigData> data) {
                if (data != null) {
                    Log.d(TAG, "OrgTestCallerTestActivity::getStandardConfigPageAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OrgTestCallerTestActivity::getStandardConfigPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OrgTestCallerTestActivity::getStandardConfigPageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OrgTestCallerTestActivity::getStandardConfigPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getStandardConfigPageSync() {
        ResponseResult<List<StandardConfigData>> result = AdlService.getService().getOrgTestCaller().getStandardConfigPageSync(buildStandardConfigPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OrgTestCallerTestActivity::getStandardConfigPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OrgTestCallerTestActivity::getStandardConfigPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getPlanStudentPageAsync() {
        PlanStudentPageRequest request = buildPlanStudentPageRequest();
        AdlService.getService().getOrgTestCaller().getPlanStudentPageAsync(RequestScope.of(this), request, new RequestCallback<List<PlanStudentData>>() {
            @Override
            public void onSuccess(List<PlanStudentData> data) {
                if (data != null) {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanStudentPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanStudentPageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OrgTestCallerTestActivity::getPlanStudentPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getPlanStudentPageSync() {
        ResponseResult<List<PlanStudentData>> result = AdlService.getService().getOrgTestCaller().getPlanStudentPageSync(buildPlanStudentPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanStudentPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanStudentPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getPlanPageAsync() {
        PlanPageRequest request = buildPlanPageRequest();
        AdlService.getService().getOrgTestCaller().getPlanPageAsync(RequestScope.of(this), request, new RequestCallback<List<PlanData>>() {
            @Override
            public void onSuccess(List<PlanData> data) {
                if (data != null) {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanPageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OrgTestCallerTestActivity::getPlanPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getPlanPageSync() {
        ResponseResult<List<PlanData>> result = AdlService.getService().getOrgTestCaller().getPlanPageSync(buildPlanPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getAllPlanPagesAsync() {
        PlanPageRequest request = buildPlanListRequest();
        AdlService.getService().getOrgTestCaller().getPlanPagesAllAsync(RequestScope.of(this), request, new RequestCallback<PageSummaryData>() {
            @Override
            public void onSuccess(PageSummaryData data) {
                if (data != null) {
                    Log.d(TAG, "OrgTestCallerTestActivity::getAllPlanPagesAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OrgTestCallerTestActivity::getAllPlanPagesAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OrgTestCallerTestActivity::getAllPlanPagesAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getAllPlanPagesSync() {
        ResponseResult<PageSummaryData> result = AdlService.getService().getOrgTestCaller().getPlanPagesAllSync(buildPlanListRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OrgTestCallerTestActivity::getAllPlanPagesSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OrgTestCallerTestActivity::getAllPlanPagesSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getPlanInfoAsync() {
        PlanInfoRequest request = PlanInfoRequest.builder("fc7a820389f744b5a094c775ba3037db").build();
        AdlService.getService().getOrgTestCaller().getPlanInfoAsync(RequestScope.of(this), request, new RequestCallback<PlanInfoData>() {
            @Override
            public void onSuccess(PlanInfoData data) {
                if (data != null) {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanInfoAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanInfoAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OrgTestCallerTestActivity::getPlanInfoAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getPlanInfoSync() {
        ResponseResult<PlanInfoData> result = AdlService.getService().getOrgTestCaller().getPlanInfoSync(PlanInfoRequest.builder("fc7a820389f744b5a094c775ba3037db").build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanInfoSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanInfoSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getPlanClassListAsync() {
        PlanClassPageRequest request = buildPlanClassListRequest();
        AdlService.getService().getOrgTestCaller().getPlanClassPageAsync(RequestScope.of(this), request, new RequestCallback<List<PlanClassData>>() {
            @Override
            public void onSuccess(List<PlanClassData> data) {
                if (data != null) {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanClassListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanClassListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OrgTestCallerTestActivity::getPlanClassListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OrgTestCallerTestActivity::getPlanClassListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getPlanClassListSync() {
        ResponseResult<List<PlanClassData>> result = AdlService.getService().getOrgTestCaller().getPlanClassPageSync(buildPlanClassListRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanClassListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OrgTestCallerTestActivity::getPlanClassListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void checkStudentInPlanAsync() {
        CheckStudentInPlanRequest request = buildCheckStudentInPlanRequest();
        AdlService.getService().getOrgTestCaller().checkStudentInPlanAsync(RequestScope.of(this), request, new RequestCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                if (data != null) {
                    Log.d(TAG, "OrgTestCallerTestActivity::getCheckStudentAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OrgTestCallerTestActivity::getCheckStudentAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OrgTestCallerTestActivity::getCheckStudentAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void checkStudentInPlanSync() {
        ResponseResult<Boolean> result = AdlService.getService().getOrgTestCaller().checkStudentInPlanSync(buildCheckStudentInPlanRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OrgTestCallerTestActivity::checkStudentInPlanSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "OrgTestCallerTestActivity::checkStudentInPlanSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
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
