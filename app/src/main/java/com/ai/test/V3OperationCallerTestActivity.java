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
import com.adl.service.http.request.BannerDetailListRequest;
import com.adl.service.http.request.DeviceFocusListRequest;
import com.adl.service.http.request.DictMapRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.SceneListRequest;
import com.adl.service.http.request.SportSkuDetailRequest;
import com.adl.service.http.request.SportSkuPageRequest;
import com.adl.service.http.request.UploadDeviceNameRequest;
import com.adl.service.http.request.WikiDetailRequest;
import com.adl.service.http.request.WikiPageRequest;
import com.adl.service.http.request.WikiTypePageRequest;
import com.adl.service.data.BannerDetailData;
import com.adl.service.data.DeviceFocusData;
import com.adl.service.data.DictMapData;
import com.adl.service.data.SceneData;
import com.adl.service.data.SportSkuDetailData;
import com.adl.service.data.SportSkuData;
import com.adl.ts.general.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/** 演示在独立界面中调用 SDK「OperationCaller」接口。 */
public class V3OperationCallerTestActivity extends AppCompatActivity {

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

        createButton("getDetailListAsync").setOnClickListener(v -> getBannerDetailListAsync());
        createButton("getDetailListSync").setOnClickListener(v -> getBannerDetailListSync());
        createButton("getSportSkuPagesAllAsync").setOnClickListener(v -> getSportSkuPagesAllAsync());
        createButton("getSportSkuPagesAllSync").setOnClickListener(v -> getSportSkuPagesAllSync());
        createButton("getSportSkuPageAsync").setOnClickListener(v -> getSportSkuPageAsync());
        createButton("getSportSkuPageSync").setOnClickListener(v -> getSportSkuPageSync());
        createButton("getSportSkuDetailAsync").setOnClickListener(v -> getSportSkuDetailAsync());
        createButton("getSportSkuDetailSync").setOnClickListener(v -> getSportSkuDetailSync());
        createButton("getDictMapAsync").setOnClickListener(v -> getDictMapAsync());
        createButton("getDictMapSync").setOnClickListener(v -> getDictMapSync());
        createButton("getSceneListAsync").setOnClickListener(v -> getSceneListAsync());
        createButton("getSceneListSync").setOnClickListener(v -> getSceneListSync());
        createButton("uploadDeviceNameAsync").setOnClickListener(v -> uploadDeviceNameAsync());
        createButton("uploadDeviceNameSync").setOnClickListener(v -> uploadDeviceNameSync());
        createButton("getDeviceFocusListAsync").setOnClickListener(v -> getDeviceFocusListAsync());
        createButton("getDeviceFocusListSync").setOnClickListener(v -> getDeviceFocusListSync());
    }

    private BannerDetailListRequest buildBannerDetailListRequest() {
        return BannerDetailListRequest.builder("10110101")
                .build();
    }

    private SportSkuPageRequest buildSportSkuPageRequest() {
        return SportSkuPageRequest.builder()
                .appCode("101101")
                .delFlag(false)
                .enabled(true)
                .sceneId("1001")
                .current(1L)
                .pageSize(500L)
                .build();
    }

    private SportSkuDetailRequest buildSportSkuDetailRequest() {
        return SportSkuDetailRequest.builder("0401010001").build();
    }

    private DictMapRequest buildDictMapRequest() {
        return DictMapRequest.builder("9901060001").build();
    }

    private SceneListRequest buildSceneListRequest() {
        return SceneListRequest.builder()
                .build();
    }

    private WikiTypePageRequest buildWikiTypePageRequest() {
        return WikiTypePageRequest.builder().build();
    }

    private WikiPageRequest buildWikiPageRequest() {
        return WikiPageRequest.builder()
                .build();
    }

    private WikiDetailRequest buildWikiDetailRequest() {
        return WikiDetailRequest.builder()
                .build();
    }

    private UploadDeviceNameRequest buildUploadDeviceNameRequest() {
        return UploadDeviceNameRequest.builder("1111111111111")
                .build();
    }

    private DeviceFocusListRequest buildDeviceFocusListRequest() {
        return DeviceFocusListRequest.builder("1111111111111")
                .build();
    }

    private void getBannerDetailListAsync() {
        BannerDetailListRequest request = buildBannerDetailListRequest();
        AdlService.getService().getOperationCaller().getBannerDetailListAsync(RequestScope.of(this), request, new RequestCallback<List<BannerDetailData>>() {
            @Override
            public void onSuccess(List<BannerDetailData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getBannerDetailListSync() {
        ResponseResult<List<BannerDetailData>> result = AdlService.getService().getOperationCaller().getBannerDetailListSync(buildBannerDetailListRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::getBannerDetailListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OperationCallerTestActivity::getBannerDetailListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getSportSkuPagesAllAsync() {
        SportSkuPageRequest request = buildSportSkuPageRequest();
        AdlService.getService().getOperationCaller().getSportSkuPagesAllAsync(RequestScope.of(this), request, new RequestCallback<PageSummaryData>() {
            @Override
            public void onSuccess(PageSummaryData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPagesAllAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPagesAllAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuPagesAllAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getSportSkuPagesAllSync() {
        ResponseResult<PageSummaryData> result = AdlService.getService().getOperationCaller().getSportSkuPagesAllSync(buildSportSkuPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::getSportSkuPagesAllSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OperationCallerTestActivity::getSportSkuPagesAllSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getSportSkuPageAsync() {
        SportSkuPageRequest request = buildSportSkuPageRequest();
        AdlService.getService().getOperationCaller().getSportSkuPageAsync(RequestScope.of(this), request, new RequestCallback<List<SportSkuData>>() {
            @Override
            public void onSuccess(List<SportSkuData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getSportSkuPageSync() {
        ResponseResult<List<SportSkuData>> result = AdlService.getService().getOperationCaller().getSportSkuPageSync(buildSportSkuPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getSportSkuDetailAsync() {
        SportSkuDetailRequest request = buildSportSkuDetailRequest();
        AdlService.getService().getOperationCaller().getSportSkuDetailAsync(RequestScope.of(this), request, new RequestCallback<SportSkuDetailData>() {
            @Override
            public void onSuccess(SportSkuDetailData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getSportSkuDetailSync() {
        ResponseResult<SportSkuDetailData> result = AdlService.getService().getOperationCaller().getSportSkuDetailSync(buildSportSkuDetailRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getDictMapAsync() {
        DictMapRequest request = buildDictMapRequest();
        AdlService.getService().getOperationCaller().getDictMapAsync(RequestScope.of(this), request, new RequestCallback<List<DictMapData>>() {
            @Override
            public void onSuccess(List<DictMapData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getDictMapAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getDictMapAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getDictMapAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDictMapAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getDictMapSync() {
        ResponseResult<List<DictMapData>> result = AdlService.getService().getOperationCaller().getDictMapSync(DictMapRequest.builder("9901060001").forceUpdate(true).build());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::getDictMapSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OperationCallerTestActivity::getDictMapSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getSceneListAsync() {
        SceneListRequest request = buildSceneListRequest();
        AdlService.getService().getOperationCaller().getSceneListAsync(RequestScope.of(this), request, new RequestCallback<List<SceneData>>() {
            @Override
            public void onSuccess(List<SceneData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSceneListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getSceneListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSceneListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSceneListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getSceneListSync() {
        ResponseResult<List<SceneData>> result = AdlService.getService().getOperationCaller().getSceneListSync(buildSceneListRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::getSceneListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OperationCallerTestActivity::getSceneListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void uploadDeviceNameAsync() {
        UploadDeviceNameRequest request = buildUploadDeviceNameRequest();
        AdlService.getService().getOperationCaller().uploadDeviceNameAsync(RequestScope.of(this), request, new RequestCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameAsync::onSuccess : data : " + data);
                resultView.setText(String.valueOf(data));
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void uploadDeviceNameSync() {
        ResponseResult<Boolean> result = AdlService.getService().getOperationCaller().uploadDeviceNameSync(buildUploadDeviceNameRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getDeviceFocusListAsync() {
        DeviceFocusListRequest request = buildDeviceFocusListRequest();
        AdlService.getService().getOperationCaller().getDeviceFocusListAsync(RequestScope.of(this), request, new RequestCallback<List<DeviceFocusData>>() {
            @Override
            public void onSuccess(List<DeviceFocusData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getDeviceFocusListSync() {
        ResponseResult<List<DeviceFocusData>> result = AdlService.getService().getOperationCaller().getDeviceFocusListSync(buildDeviceFocusListRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
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
