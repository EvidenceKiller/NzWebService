package com.ai.test;

import android.os.Bundle;
import android.util.Log;

import com.adl.auth.core.AdlAuthFactory;
import com.adl.service.common.RequestCallback;
import com.adl.service.common.RequestResult;
import com.adl.service.common.RequestUserCallback;
import com.adl.service.outer.ConfigService;
import com.adl.service.outer.PlanCaller;
import com.adl.service.outer.SportCaller;
import com.adl.service.outer.UserCaller;
import com.adl.ts.general.R;


public class TempTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_temp_test);

        findViewById(R.id.btn_1).setOnClickListener(v -> {
            UserCaller.instance().syncBaseInfo(true, new RequestUserCallback(this) {
                @Override
                public void nextStatus(int status, String msg) {
                    Log.i("ZXN_TEST", "TempTestActivity::UserCallerRequestCallback::nextStatus : status : " + status + ", msg : " + msg);
                }

                @Override
                public void onResult(RequestResult result) {
                    Log.i("ZXN_TEST", "TempTestActivity::UserCallerRequestCallback::onResult : result : " + result.isOk());
                }
            });
        });

        findViewById(R.id.btn_2).setOnClickListener(v -> {
            SportCaller.instance().querySceneList(AdlAuthFactory.create(getApplicationContext()).getAppCode(), true, new RequestCallback() {
                @Override
                public void onResult(RequestResult result) {
                    Log.i("ZXN_TEST", "TempTestActivity::SportCallerRequestCallback::onResult : result : " + result.isOk());
                }
            });
        });

        findViewById(R.id.btn_3).setOnClickListener(v -> {
            SportCaller.instance().getSportUnitDirct(new RequestCallback() {
                @Override
                public void onResult(RequestResult result) {
                    Log.i("ZXN_TEST", "TempTestActivity::SportCallerRequestCallback::onResult : result : " + result.isOk());
                }
            });
        });


        findViewById(R.id.btn_4).setOnClickListener(v -> {
            PlanCaller.instance().querySportPlan("TC", 1, new RequestCallback() {
                @Override
                public void onResult(RequestResult result) {
                    Log.i("ZXN_TEST", "TempTestActivity::QuerySportPlanCallback::onResult : result : " + result.isOk());
                }
            });
        });

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
