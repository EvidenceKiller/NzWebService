package com.ai.test;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adl.auth.core.AdlAuthFactory;
import com.adl.service.common.FileUtil;
import com.adl.service.common.IDefine;
import com.adl.service.common.InnerUtil;
import com.adl.service.common.RequestCallback;
import com.adl.service.common.RequestResult;
import com.adl.service.common.RequestUserCallback;
import com.adl.service.entity.SceneSportInfoEntity;
import com.adl.service.outer.AdlService;
import com.adl.service.outer.ConfigService;
import com.adl.service.outer.PlanCaller;
import com.adl.service.outer.SportCaller;
import com.adl.service.outer.UserCaller;
import com.adl.service.web.SportService;
import com.adl.ts.general.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TempTestActivity extends BaseActivity {

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_temp_test);
        container = findViewById(R.id.ll);

        addTextView("UserService");
        createButton("syncBaseInfo").setOnClickListener(v -> {
            UserCaller.instance().syncBaseInfo(true, new RequestUserCallback(this) {
                @Override
                public void nextStatus(int status, String msg) {
                    Log.i("ZXN_TEST", "TempTestActivity::UserCallerRequestCallback::nextStatus : status : " + status + ", msg : " + msg);
                }

                @Override
                public void onResult(RequestResult result) {
                    Log.i("ZXN_TEST", "TempTestActivity::UserCallerRequestCallback::onResult : result : " + result.isOk());
                    flushResultToFile("UserService.syncBaseInfo.txt", result.getContent());
                }
            });
        });

        addTextView("SportService");
        createButton("获取场景列表").setOnClickListener(v -> {
            SportCaller.instance().querySceneList(AdlAuthFactory.create(getApplicationContext()).getAppCode(), true, new RequestCallback() {
                @Override
                public void onResult(RequestResult result) {
                    Log.i("ZXN_TEST", "TempTestActivity::getSceneList::onResult : result : " + result.isOk());
                    flushResultToFile("SportService.getSceneList.txt", result.getContent());
                }
            });
        });

        List<Pair<String, String>> params = new ArrayList<>();
        params.add(new Pair<>(AdlAuthFactory.create(getApplicationContext()).getAppCode(), "1001"));
        params.add(new Pair<>(AdlAuthFactory.create(getApplicationContext()).getAppCode(), "2001"));
        createButton("查询项目库列表").setOnClickListener(v -> {
            SportCaller.instance().querySportSkuList(params, new RequestCallback() {
                @Override
                public void onResult(RequestResult result) {
                    Log.i("ZXN_TEST", "TempTestActivity::getSportSkuList::onResult : result : " + result.isOk());
                    flushResultToFile("SportService.getSportSkuList.txt", result.getContent());
                }
            });
        });

        createButton("查询项目库列表").setOnClickListener(v -> {
            SceneSportInfoEntity result = SportService.getSportSkuDetail("0201010001");
            flushResultToFile("SportService.getSportSkuDetail.txt", result);
        });

    }

    private Button createButton(String btnText) {
        Button button = new Button(this);
        button.setText(btnText);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        container.addView(button);
        return button;
    }

    private void addTextView(String text) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setText(text);
        textView.setBackgroundColor(Color.RED);
        container.addView(textView);
    }

    private void flushResultToFile(String fileName, Object result) {
        File dir = FileUtil.createDirectory("result");
        File file = new File(dir, fileName);
        
        FileOutputStream out = null;
        try {
            String content = result.toString();
            out = new FileOutputStream(file, true);
            out.write(content.getBytes("UTF-8"));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
