package com.ai.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.adl.service.AdlService;
import com.adl.service.callback.RequestCallback;
import com.adl.service.web.request.BannerDetailListRequest;
import com.adl.service.web.request.DeviceFocusListRequest;
import com.adl.service.web.request.DictMapRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.SceneListRequest;
import com.adl.service.web.request.SportSkuDetailRequest;
import com.adl.service.web.request.SportSkuPageRequest;
import com.adl.service.web.request.UploadDeviceNameRequest;
import com.adl.service.web.request.WikiDetailRequest;
import com.adl.service.web.request.WikiPageRequest;
import com.adl.service.web.request.WikiTypePageRequest;
import com.adl.service.web.response.BannerDetailListData;
import com.adl.service.web.response.DeviceFocusData;
import com.adl.service.web.response.DictMapData;
import com.adl.service.web.response.SceneData;
import com.adl.service.web.response.SportSkuDetailData;
import com.adl.service.web.response.SportSkuPageData;
import com.adl.service.web.response.WikiDetailData;
import com.adl.service.web.response.WikiPageData;
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

        createButton("getDetailListAsync").setOnClickListener(v -> getDetailListAsync());
        createButton("getDetailListSync").setOnClickListener(v -> getDetailListSync());
        createButton("getSportSkuPageAsync").setOnClickListener(v -> getSportSkuPageAsync());
        createButton("getSportSkuPageSync").setOnClickListener(v -> getSportSkuPageSync());
        createButton("getSportSkuDetailAsync").setOnClickListener(v -> getSportSkuDetailAsync());
        createButton("getSportSkuDetailSync").setOnClickListener(v -> getSportSkuDetailSync());
        createButton("getDictMapAsync").setOnClickListener(v -> getDictMapAsync());
        createButton("getDictMapSync").setOnClickListener(v -> getDictMapSync());
        createButton("getSceneListAsync").setOnClickListener(v -> getSceneListAsync());
        createButton("getSceneListSync").setOnClickListener(v -> getSceneListSync());
        createButton("getWikiTypePageAsync").setOnClickListener(v -> getWikiTypePageAsync());
        createButton("getWikiTypePageSync").setOnClickListener(v -> getWikiTypePageSync());
        createButton("getWikiPageAsync").setOnClickListener(v -> getWikiPageAsync());
        createButton("getWikiPageSync").setOnClickListener(v -> getWikiPageSync());
        createButton("getWikiDetailAsync").setOnClickListener(v -> getWikiDetailAsync());
        createButton("getWikiDetailSync").setOnClickListener(v -> getWikiDetailSync());
        createButton("uploadDeviceNameAsync").setOnClickListener(v -> uploadDeviceNameAsync());
        createButton("uploadDeviceNameSync").setOnClickListener(v -> uploadDeviceNameSync());
        createButton("getDeviceFocusListAsync").setOnClickListener(v -> getDeviceFocusListAsync());
        createButton("getDeviceFocusListSync").setOnClickListener(v -> getDeviceFocusListSync());
    }

    private BannerDetailListRequest buildBannerDetailListRequest() {
        return BannerDetailListRequest.builder()
                .id("")
                .wikiId("")
                .resType(0)
                .build();
    }

    private SportSkuPageRequest buildSportSkuPageRequest() {
        return SportSkuPageRequest.builder()
                .sportNature("")
                .sportType("")
                .keyword("")
                .templateFlag(0)
                .ids(null)
                .appCodes(null)
                .appCode("")
                .sceneId("")
                .delFlag(false)
                .enabled(false)
                .build();
    }

    private SportSkuDetailRequest buildSportSkuDetailRequest() {
        return SportSkuDetailRequest.builder("").build();
    }

    private DictMapRequest buildDictMapRequest() {
        return DictMapRequest.builder("").build();
    }

    private SceneListRequest buildSceneListRequest() {
        return SceneListRequest.builder()
                .appCode("")
                .enabled(false)
                .sceneType("")
                .build();
    }

    private WikiTypePageRequest buildWikiTypePageRequest() {
        return WikiTypePageRequest.builder().build();
    }

    private WikiPageRequest buildWikiPageRequest() {
        return WikiPageRequest.builder()
                .keyword("")
                .wikiType("")
                .wikiTypeId("")
                .enabled("")
                .appCode("")
                .orgId("")
                .build();
    }

    private WikiDetailRequest buildWikiDetailRequest() {
        return WikiDetailRequest.builder()
                .id("")
                .wikiId("")
                .resType(0)
                .build();
    }

    private UploadDeviceNameRequest buildUploadDeviceNameRequest() {
        return UploadDeviceNameRequest.builder("")
                .deviceName("")
                .macAddress("")
                .build();
    }

    private DeviceFocusListRequest buildDeviceFocusListRequest() {
        return DeviceFocusListRequest.builder("")
                .appCode("")
                .build();
    }

    private void getDetailListAsync() {
        BannerDetailListRequest request = buildBannerDetailListRequest();
        AdlService.getService().getOperationCaller().getDetailListAsync(RequestScope.of(this), request, new RequestCallback<List<BannerDetailListData>>() {
            @Override
            public void onSuccess(List<BannerDetailListData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getDetailListAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getDetailListSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            BannerDetailListRequest request = buildBannerDetailListRequest();
            return AdlService.getService().getOperationCaller().getDetailListSync(request);
        }, new RequestCallback<List<BannerDetailListData>>() {
            @Override
            public void onSuccess(List<BannerDetailListData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListSync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getDetailListSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDetailListSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getDetailListSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getSportSkuPageAsync() {
        SportSkuPageRequest request = buildSportSkuPageRequest();
        AdlService.getService().getOperationCaller().getSportSkuPageAsync(RequestScope.of(this), request, new RequestCallback<SportSkuPageData>() {
            @Override
            public void onSuccess(SportSkuPageData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getSportSkuPageSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            SportSkuPageRequest request = buildSportSkuPageRequest();
            return AdlService.getService().getOperationCaller().getSportSkuPageSync(request);
        }, new RequestCallback<SportSkuPageData>() {
            @Override
            public void onSuccess(SportSkuPageData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuPageSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getSportSkuDetailSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            SportSkuDetailRequest request = buildSportSkuDetailRequest();
            return AdlService.getService().getOperationCaller().getSportSkuDetailSync(request);
        }, new RequestCallback<SportSkuDetailData>() {
            @Override
            public void onSuccess(SportSkuDetailData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getSportSkuDetailSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDictMapAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getDictMapAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getDictMapSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            DictMapRequest request = buildDictMapRequest();
            return AdlService.getService().getOperationCaller().getDictMapSync(request);
        }, new RequestCallback<List<DictMapData>>() {
            @Override
            public void onSuccess(List<DictMapData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getDictMapSync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getDictMapSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getDictMapSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDictMapSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getDictMapSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSceneListAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getSceneListAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getSceneListSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            SceneListRequest request = buildSceneListRequest();
            return AdlService.getService().getOperationCaller().getSceneListSync(request);
        }, new RequestCallback<List<SceneData>>() {
            @Override
            public void onSuccess(List<SceneData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getSceneListSync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getSceneListSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getSceneListSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getSceneListSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getSceneListSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getWikiTypePageAsync() {
        WikiTypePageRequest request = buildWikiTypePageRequest();
        AdlService.getService().getOperationCaller().getWikiTypePageAsync(RequestScope.of(this), request, new RequestCallback<WikiPageData>() {
            @Override
            public void onSuccess(WikiPageData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getWikiTypePageSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            WikiTypePageRequest request = buildWikiTypePageRequest();
            return AdlService.getService().getOperationCaller().getWikiTypePageSync(request);
        }, new RequestCallback<WikiPageData>() {
            @Override
            public void onSuccess(WikiPageData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiTypePageSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getWikiPageAsync() {
        WikiPageRequest request = buildWikiPageRequest();
        AdlService.getService().getOperationCaller().getWikiPageAsync(RequestScope.of(this), request, new RequestCallback<WikiPageData>() {
            @Override
            public void onSuccess(WikiPageData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiPageAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiPageAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiPageAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getWikiPageSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            WikiPageRequest request = buildWikiPageRequest();
            return AdlService.getService().getOperationCaller().getWikiPageSync(request);
        }, new RequestCallback<WikiPageData>() {
            @Override
            public void onSuccess(WikiPageData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiPageSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiPageSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiPageSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiPageSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getWikiDetailAsync() {
        WikiDetailRequest request = buildWikiDetailRequest();
        AdlService.getService().getOperationCaller().getWikiDetailAsync(RequestScope.of(this), request, new RequestCallback<WikiDetailData>() {
            @Override
            public void onSuccess(WikiDetailData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiDetailAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiDetailAsync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiDetailAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiDetailAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getWikiDetailSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            WikiDetailRequest request = buildWikiDetailRequest();
            return AdlService.getService().getOperationCaller().getWikiDetailSync(request);
        }, new RequestCallback<WikiDetailData>() {
            @Override
            public void onSuccess(WikiDetailData data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiDetailSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getWikiDetailSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiDetailSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getWikiDetailSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void uploadDeviceNameSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            UploadDeviceNameRequest request = buildUploadDeviceNameRequest();
            return AdlService.getService().getOperationCaller().uploadDeviceNameSync(request);
        }, new RequestCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameSync::onSuccess : data : " + data);
                resultView.setText(String.valueOf(data));
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::uploadDeviceNameSync::onError : error : " + error);
                resultView.setText(error);
            }
        });
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
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListAsync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListAsync::onError : error : " + error);
                resultView.setText(error);
            }
        });
    }

    private void getDeviceFocusListSync() {
        AdlService.getService().executeSyncOnIo(RequestScope.of(this), () -> {
            DeviceFocusListRequest request = buildDeviceFocusListRequest();
            return AdlService.getService().getOperationCaller().getDeviceFocusListSync(request);
        }, new RequestCallback<List<DeviceFocusData>>() {
            @Override
            public void onSuccess(List<DeviceFocusData> data) {
                if (data != null) {
                    Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListSync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListSync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListSync::onSuccess : data is null");
                }
            }

            @Override
            public void onFail(int code, String msg) {
                Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListSync::onFail : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "OperationCallerTestActivity::getDeviceFocusListSync::onError : error : " + error);
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
