package com.ai.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.response.GradeTreeData;
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
    }

    private void getGradeTreeAsync() {
        AdlService.getService().getCommonInfoCaller().getGradeTreeAsync(RequestScope.of(this), new RequestCallback<List<GradeTreeData>>() {
            @Override
            public void onSuccess(List<GradeTreeData> data) {
                if (data != null) {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onSuccess : data" + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onFail : code" + code);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "CommonInfoCallerTestActivity::getGradeTreeAsync::onError : error" + error);
            }
        });
    }

    private Button createButton(String text) {
        Button button = new Button(this);
        button.setText(text);
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
