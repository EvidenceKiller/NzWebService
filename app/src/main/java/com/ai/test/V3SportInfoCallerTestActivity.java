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
import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.ReportSportStudentCompetitionData;
import com.adl.service.data.ReportSportStudentData;
import com.adl.service.data.ReportSportStudentMeetData;
import com.adl.service.data.ReportSportStudentPlanData;
import com.adl.service.data.ReportSportStudentTrainData;
import com.adl.service.data.ReportSportTeacherData;
import com.adl.service.http.request.AccountRecordPageRequest;
import com.adl.service.http.request.OrgRecordPageRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.data.AccountRecordData;
import com.adl.service.data.OrgRecordData;
import com.adl.ts.general.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/** 演示在独立界面中调用 SDK「SportInfoCaller」接口。 */
public class V3SportInfoCallerTestActivity extends AppCompatActivity {

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

        createButton("updateStudentSportAsync").setOnClickListener(v -> updateStudentSportAsync());
        createButton("updateStudentSportSync").setOnClickListener(v -> updateStudentSportSync());
        createButton("reportTeacherSportAsync").setOnClickListener(v -> reportTeacherSportAsync());
        createButton("reportTeacherSportSync").setOnClickListener(v -> reportTeacherSportSync());
        createButton("reportStudentTrainAsync").setOnClickListener(v -> reportStudentTrainAsync());
        createButton("reportStudentTrainSync").setOnClickListener(v -> reportStudentTrainSync());
        createButton("reportStudentSportAsync").setOnClickListener(v -> reportStudentSportAsync());
        createButton("reportStudentSportSync").setOnClickListener(v -> reportStudentSportSync());
        createButton("reportStudentPlanAsync").setOnClickListener(v -> reportStudentPlanAsync());
        createButton("reportStudentPlanSync").setOnClickListener(v -> reportStudentPlanSync());
        createButton("reportStudentMeetAsync").setOnClickListener(v -> reportStudentMeetAsync());
        createButton("reportStudentMeetSync").setOnClickListener(v -> reportStudentMeetSync());
        createButton("reportStudentCompetitionAsync").setOnClickListener(v -> reportStudentCompetitionAsync());
        createButton("reportStudentCompetitionSync").setOnClickListener(v -> reportStudentCompetitionSync());
        createButton("reportStudentAllSportAsync").setOnClickListener(v -> reportStudentAllSportAsync());
        createButton("reportStudentAllSportSync").setOnClickListener(v -> reportStudentAllSportSync());
        createButton("getOrgRecordPageAsync").setOnClickListener(v -> getOrgRecordPageAsync());
        createButton("getOrgRecordPageSync").setOnClickListener(v -> getOrgRecordPageSync());
        createButton("getAccountRecordPageAsync").setOnClickListener(v -> getAccountRecordPageAsync());
        createButton("getAccountRecordPageSync").setOnClickListener(v -> getAccountRecordPageSync());
    }

    private AccountRecordPageRequest buildAccountRecordPageRequest() {
        AccountRecordPageRequest request = AccountRecordPageRequest.builder().forceUpdate(true).pageSize(10L).semesterId("101101").build();
        return request;
    }

    private RequestCallback<Boolean> booleanCallback(String methodName) {
        return new RequestCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                Log.d(TAG, "SportInfoCallerTestActivity::" + methodName + "::onSuccess : data : " + data);
                resultView.setText(String.valueOf(data));
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "SportInfoCallerTestActivity::" + methodName + "::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        };
    }

    private void updateStudentSportAsync() {
        AdlService.getService().getSportInfoCaller().updateStudentSportAsync(
                RequestScope.of(this), new ReportSportStudentAllData(), booleanCallback("updateStudentSportAsync"));
    }

    private void updateStudentSportSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().updateStudentSportSync(new ReportSportStudentAllData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::updateStudentSportSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::updateStudentSportSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void reportTeacherSportAsync() {
        AdlService.getService().getSportInfoCaller().reportTeacherSportAsync(
                RequestScope.of(this), new ReportSportTeacherData(), booleanCallback("reportTeacherSportAsync"));
    }

    private void reportTeacherSportSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().reportTeacherSportSync(new ReportSportTeacherData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::reportTeacherSportSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::reportTeacherSportSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void reportStudentTrainAsync() {
        AdlService.getService().getSportInfoCaller().reportStudentTrainAsync(
                RequestScope.of(this), new ReportSportStudentTrainData(), booleanCallback("reportStudentTrainAsync"));
    }

    private void reportStudentTrainSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().reportStudentTrainSync(new ReportSportStudentTrainData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentTrainSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentTrainSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void reportStudentSportAsync() {
        AdlService.getService().getSportInfoCaller().reportStudentSportAsync(
                RequestScope.of(this), new ReportSportStudentData(), booleanCallback("reportStudentSportAsync"));
    }

    private void reportStudentSportSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().reportStudentSportSync(new ReportSportStudentData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentSportSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentSportSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void reportStudentPlanAsync() {
        AdlService.getService().getSportInfoCaller().reportStudentPlanAsync(
                RequestScope.of(this), new ReportSportStudentPlanData(), booleanCallback("reportStudentPlanAsync"));
    }

    private void reportStudentPlanSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().reportStudentPlanSync(new ReportSportStudentPlanData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentPlanSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentPlanSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void reportStudentMeetAsync() {
        AdlService.getService().getSportInfoCaller().reportStudentMeetAsync(
                RequestScope.of(this), new ReportSportStudentMeetData(), booleanCallback("reportStudentMeetAsync"));
    }

    private void reportStudentMeetSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().reportStudentMeetSync(new ReportSportStudentMeetData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentMeetSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentMeetSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void reportStudentCompetitionAsync() {
        AdlService.getService().getSportInfoCaller().reportStudentCompetitionAsync(
                RequestScope.of(this), new ReportSportStudentCompetitionData(), booleanCallback("reportStudentCompetitionAsync"));
    }

    private void reportStudentCompetitionSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().reportStudentCompetitionSync(new ReportSportStudentCompetitionData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentCompetitionSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentCompetitionSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void reportStudentAllSportAsync() {
        AdlService.getService().getSportInfoCaller().reportStudentAllSportAsync(
                RequestScope.of(this), new ReportSportStudentAllData(), booleanCallback("reportStudentAllSportAsync"));
    }

    private void reportStudentAllSportSync() {
        ResponseResult<Boolean> result = AdlService.getService().getSportInfoCaller().reportStudentAllSportSync(new ReportSportStudentAllData());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentAllSportSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::reportStudentAllSportSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getOrgRecordPageAsync() {
        AdlService.getService().getSportInfoCaller().getOrgRecordPageAsync(
                RequestScope.of(this), OrgRecordPageRequest.builder().build(), new RequestCallback<List<OrgRecordData>>() {
                    @Override
                    public void onSuccess(List<OrgRecordData> data) {
                        Log.d(TAG, "SportInfoCallerTestActivity::getOrgRecordPageAsync::onSuccess : data : " + data);
                        resultView.setText(String.valueOf(data));
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, "SportInfoCallerTestActivity::getOrgRecordPageAsync::onError : code : " + code + ", msg : " + msg);
                        resultView.setText(msg);
                    }
                });
    }

    private void getOrgRecordPageSync() {
        ResponseResult<List<OrgRecordData>> result = AdlService.getService().getSportInfoCaller().getOrgRecordPageSync(OrgRecordPageRequest.builder().build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::getOrgRecordPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::getOrgRecordPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getAccountRecordPageAsync() {
        AdlService.getService().getSportInfoCaller().getAccountRecordPageAsync(
                RequestScope.of(this), buildAccountRecordPageRequest(), new RequestCallback<List<AccountRecordData>>() {
                    @Override
                    public void onSuccess(List<AccountRecordData> data) {
                        Log.d(TAG, "SportInfoCallerTestActivity::getAccountRecordPageAsync::onSuccess : data : " + data);
                        resultView.setText(String.valueOf(data));
                    }

                    @Override
                    public void onError(int code, String msg) {
                        Log.d(TAG, "SportInfoCallerTestActivity::getAccountRecordPageAsync::onError : code : " + code + ", msg : " + msg);
                        resultView.setText(msg);
                    }
                });
    }

    private void getAccountRecordPageSync() {
        ResponseResult<List<AccountRecordData>> result = AdlService.getService().getSportInfoCaller().getAccountRecordPageSync(buildAccountRecordPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "SportInfoCallerTestActivity::getAccountRecordPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "SportInfoCallerTestActivity::getAccountRecordPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
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
