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
import com.adl.service.data.ResInfoData;
import com.adl.service.http.request.BaseGroup;
import com.adl.service.http.request.BaseGroupAccountInfo;
import com.adl.service.http.request.CompetitionPageRequest;
import com.adl.service.http.request.CompetitionRankDetailRequest;
import com.adl.service.http.request.DownloadGroupTeamDetailPageRequest;
import com.adl.service.http.request.DownloadGroupTeamPageRequest;
import com.adl.service.http.request.GetGroupRequest;
import com.adl.service.http.request.JoinCompetitionRankRequest;
import com.adl.service.http.request.RequestScope;
import com.adl.service.http.request.ResInfoRequest;
import com.adl.service.http.request.ResPageRequest;
import com.adl.service.http.request.ResTypeListRequest;
import com.adl.service.http.request.SaveGroupRequest;
import com.adl.service.http.request.SportMeetPageRequest;
import com.adl.service.http.request.TrainPlanInfoPageRequest;
import com.adl.service.http.request.TrainPlanOneDayProjectListRequest;
import com.adl.service.data.CompetitionData;
import com.adl.service.data.CompetitionRankDetailData;
import com.adl.service.data.GroupData;
import com.adl.service.data.GroupTeamData;
import com.adl.service.data.GroupTeamDetailData;
import com.adl.service.data.ResData;
import com.adl.service.data.ResTypeData;
import com.adl.service.data.SportMeetData;
import com.adl.service.data.TrainPlanInfoData;
import com.adl.service.data.TrainPlanOneDayProjectData;
import com.adl.ts.general.R;

import java.util.Collections;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/** 演示在独立界面中调用 SDK「BusinessCaller」接口。 */
public class V3BusinessCallerTestActivity extends AppCompatActivity {

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

        createButton("saveGroupAsync").setOnClickListener(v -> saveGroupAsync());
        createButton("saveGroupSync").setOnClickListener(v -> saveGroupSync());
        createButton("getGroupAsync").setOnClickListener(v -> getGroupAsync());
        createButton("getGroupSync").setOnClickListener(v -> getGroupSync());
        createButton("getTrainPlanOneDayProjectListAsync").setOnClickListener(v -> getTrainPlanOneDayProjectListAsync());
        createButton("getTrainPlanOneDayProjectListSync").setOnClickListener(v -> getTrainPlanOneDayProjectListSync());
        createButton("getTrainPlanInfoPageAsync").setOnClickListener(v -> getTrainPlanInfoPageAsync());
        createButton("getTrainPlanInfoPageSync").setOnClickListener(v -> getTrainPlanInfoPageSync());
        createButton("joinCompetitionRankAsync").setOnClickListener(v -> joinCompetitionRankAsync());
        createButton("joinCompetitionRankSync").setOnClickListener(v -> joinCompetitionRankSync());
        createButton("getCompetitionRankDetailAsync").setOnClickListener(v -> getCompetitionRankDetailAsync());
        createButton("getCompetitionRankDetailSync").setOnClickListener(v -> getCompetitionRankDetailSync());
        createButton("getCompetitionPageAsync").setOnClickListener(v -> getCompetitionPageAsync());
        createButton("getCompetitionPageSync").setOnClickListener(v -> getCompetitionPageSync());
        createButton("getSportMeetPageAsync").setOnClickListener(v -> getSportMeetPageAsync());
        createButton("getSportMeetPageSync").setOnClickListener(v -> getSportMeetPageSync());
        createButton("downloadGroupTeamPageAsync").setOnClickListener(v -> downloadGroupTeamPageAsync());
        createButton("downloadGroupTeamPageSync").setOnClickListener(v -> downloadGroupTeamPageSync());
        createButton("downloadGroupTeamDetailPageAsync").setOnClickListener(v -> downloadGroupTeamDetailPageAsync());
        createButton("downloadGroupTeamDetailPageSync").setOnClickListener(v -> downloadGroupTeamDetailPageSync());
        createButton("getResTypeListAsync").setOnClickListener(v -> getResTypeListAsync());
        createButton("getResTypeListSync").setOnClickListener(v -> getResTypeListSync());
        createButton("getResPageAsync").setOnClickListener(v -> getResPageAsync());
        createButton("getResPageSync").setOnClickListener(v -> getResPageSync());
        createButton("getResInfoAsync").setOnClickListener(v -> getResInfoAsync());
        createButton("getResInfoSync").setOnClickListener(v -> getResInfoSync());

    }

    private SaveGroupRequest buildSaveGroupRequest() {
        return SaveGroupRequest.builder("2001", Collections.singletonList(
                new BaseGroup().setGroupId("1111").setGroupClassId("2222").setGroupName("testGroup").setGroupAccountInfos(Collections.singletonList(new BaseGroupAccountInfo()))))
                .build();
    }

    private GetGroupRequest buildGetGroupRequest() {
        return GetGroupRequest.builder()
                .build();
    }

    private TrainPlanOneDayProjectListRequest buildTrainPlanOneDayProjectListRequest() {
        return TrainPlanOneDayProjectListRequest.builder("1965665142485622785", "1965665142485622785")
                .build();
    }

    private TrainPlanInfoPageRequest buildTrainPlanInfoPageRequest() {
        return TrainPlanInfoPageRequest.builder()
                .build();
    }

    private JoinCompetitionRankRequest buildJoinCompetitionRankRequest() {
        return JoinCompetitionRankRequest.builder()
                .id("2041833871287713792")
                .accountId("1965665142485622785")
                .classId("123456789")
                .build();
    }

    private CompetitionRankDetailRequest buildCompetitionRankDetailRequest() {
        return CompetitionRankDetailRequest.builder()
                .build();
    }

    private CompetitionPageRequest buildCompetitionPageRequest() {
        return CompetitionPageRequest.builder()
                .build();
    }

    private SportMeetPageRequest buildSportMeetPageRequest() {
        return SportMeetPageRequest.builder()
                .build();
    }

    private DownloadGroupTeamPageRequest buildDownloadGroupTeamPageRequest() {
        return DownloadGroupTeamPageRequest.builder()
                .build();
    }

    private DownloadGroupTeamDetailPageRequest buildDownloadGroupTeamDetailPageRequest() {
        return DownloadGroupTeamDetailPageRequest.builder()
                .build();
    }

    private ResTypeListRequest buildResTypeListRequest() {
        return ResTypeListRequest.builder()
                .resType(1)
                .build();
    }

    private ResPageRequest buildResPageRequest() {
        return ResPageRequest.builder("")
                .build();
    }

    private ResInfoRequest buildResInfoRequest() {
        return ResInfoRequest.builder()
                .id("2041833871287713792")
                .build();
    }

    private void saveGroupAsync() {
        SaveGroupRequest request = buildSaveGroupRequest();
        AdlService.getService().getBusinessCaller().saveGroupAsync(RequestScope.of(this), request, new RequestCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                Log.d(TAG, "BusinessCallerTestActivity::saveGroupAsync::onSuccess : data : " + data);
                resultView.setText(String.valueOf(data));
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::saveGroupAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void saveGroupSync() {
        ResponseResult<Boolean> result = AdlService.getService().getBusinessCaller().saveGroupSync(buildSaveGroupRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::saveGroupSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::saveGroupSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getGroupAsync() {
        GetGroupRequest request = buildGetGroupRequest();
        AdlService.getService().getBusinessCaller().getGroupAsync(RequestScope.of(this), request, new RequestCallback<GroupData>() {
            @Override
            public void onSuccess(GroupData data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getGroupAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getGroupAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getGroupAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getGroupSync() {
        ResponseResult<GroupData> result = AdlService.getService().getBusinessCaller().getGroupSync(buildGetGroupRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getGroupSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getGroupSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getTrainPlanOneDayProjectListAsync() {
        TrainPlanOneDayProjectListRequest request = buildTrainPlanOneDayProjectListRequest();
        AdlService.getService().getBusinessCaller().getTrainPlanOneDayProjectListAsync(RequestScope.of(this), request, new RequestCallback<List<TrainPlanOneDayProjectData>>() {
            @Override
            public void onSuccess(List<TrainPlanOneDayProjectData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanOneDayProjectListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanOneDayProjectListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanOneDayProjectListAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanOneDayProjectListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getTrainPlanOneDayProjectListSync() {
        ResponseResult<List<TrainPlanOneDayProjectData>> result = AdlService.getService().getBusinessCaller().getTrainPlanOneDayProjectListSync(buildTrainPlanOneDayProjectListRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanOneDayProjectListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanOneDayProjectListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getTrainPlanInfoPageAsync() {
        TrainPlanInfoPageRequest request = buildTrainPlanInfoPageRequest();
        AdlService.getService().getBusinessCaller().getTrainPlanInfoPageAsync(RequestScope.of(this), request, new RequestCallback<List<TrainPlanInfoData>>() {
            @Override
            public void onSuccess(List<TrainPlanInfoData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanInfoPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanInfoPageAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanInfoPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getTrainPlanInfoPageSync() {
        ResponseResult<List<TrainPlanInfoData>> result = AdlService.getService().getBusinessCaller().getTrainPlanInfoPageSync(buildTrainPlanInfoPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanInfoPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getTrainPlanInfoPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void joinCompetitionRankAsync() {
        JoinCompetitionRankRequest request = buildJoinCompetitionRankRequest();
        AdlService.getService().getBusinessCaller().joinCompetitionRankAsync(RequestScope.of(this), request, new RequestCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                Log.d(TAG, "BusinessCallerTestActivity::joinCompetitionRankAsync::onSuccess : data : " + data);
                resultView.setText(String.valueOf(data));
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::joinCompetitionRankAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void joinCompetitionRankSync() {
        ResponseResult<Boolean> result = AdlService.getService().getBusinessCaller().joinCompetitionRankSync(buildJoinCompetitionRankRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::joinCompetitionRankSync::onSuccess : data : " + result.getData());
            resultView.setText(String.valueOf(result.getData()));
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::joinCompetitionRankSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getCompetitionRankDetailAsync() {
        CompetitionRankDetailRequest request = buildCompetitionRankDetailRequest();
        AdlService.getService().getBusinessCaller().getCompetitionRankDetailAsync(RequestScope.of(this), request, new RequestCallback<CompetitionRankDetailData>() {
            @Override
            public void onSuccess(CompetitionRankDetailData data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getCompetitionRankDetailAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getCompetitionRankDetailAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getCompetitionRankDetailAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getCompetitionRankDetailSync() {
        ResponseResult<CompetitionRankDetailData> result = AdlService.getService().getBusinessCaller().getCompetitionRankDetailSync(buildCompetitionRankDetailRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getCompetitionRankDetailSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getCompetitionRankDetailSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getCompetitionPageAsync() {
        CompetitionPageRequest request = buildCompetitionPageRequest();
        AdlService.getService().getBusinessCaller().getCompetitionPageAsync(RequestScope.of(this), request, new RequestCallback<List<CompetitionData>>() {
            @Override
            public void onSuccess(List<CompetitionData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getCompetitionPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getCompetitionPageAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getCompetitionPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getCompetitionPageSync() {
        ResponseResult<List<CompetitionData>> result = AdlService.getService().getBusinessCaller().getCompetitionPageSync(buildCompetitionPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getCompetitionPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getCompetitionPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getSportMeetPageAsync() {
        SportMeetPageRequest request = buildSportMeetPageRequest();
        AdlService.getService().getBusinessCaller().getSportMeetPageAsync(RequestScope.of(this), request, new RequestCallback<List<SportMeetData>>() {
            @Override
            public void onSuccess(List<SportMeetData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getSportMeetPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getSportMeetPageAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getSportMeetPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getSportMeetPageSync() {
        ResponseResult<List<SportMeetData>> result = AdlService.getService().getBusinessCaller().getSportMeetPageSync(buildSportMeetPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getSportMeetPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getSportMeetPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void downloadGroupTeamPageAsync() {
        DownloadGroupTeamPageRequest request = buildDownloadGroupTeamPageRequest();
        AdlService.getService().getBusinessCaller().downloadGroupTeamPageAsync(RequestScope.of(this), request, new RequestCallback<List<GroupTeamData>>() {
            @Override
            public void onSuccess(List<GroupTeamData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamPageAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamPageAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void downloadGroupTeamPageSync() {
        ResponseResult<List<GroupTeamData>> result = AdlService.getService().getBusinessCaller().downloadGroupTeamPageSync(buildDownloadGroupTeamPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void downloadGroupTeamDetailPageAsync() {
        DownloadGroupTeamDetailPageRequest request = buildDownloadGroupTeamDetailPageRequest();
        AdlService.getService().getBusinessCaller().downloadGroupTeamDetailPageAsync(RequestScope.of(this), request, new RequestCallback<List<GroupTeamDetailData>>() {
            @Override
            public void onSuccess(List<GroupTeamDetailData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamDetailPageAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamDetailPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamDetailPageAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamDetailPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void downloadGroupTeamDetailPageSync() {
        ResponseResult<List<GroupTeamDetailData>> result = AdlService.getService().getBusinessCaller().downloadGroupTeamDetailPageSync(buildDownloadGroupTeamDetailPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamDetailPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::downloadGroupTeamDetailPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getResTypeListAsync() {
        ResTypeListRequest request = buildResTypeListRequest();
        AdlService.getService().getBusinessCaller().getResTypeListAsync(RequestScope.of(this), request, new RequestCallback<List<ResTypeData>>() {
            @Override
            public void onSuccess(List<ResTypeData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getResTypeListAsync::onSuccess : data size : " + data.size());
                    Log.d(TAG, "BusinessCallerTestActivity::getResTypeListAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getResTypeListAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getResTypeListAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getResTypeListSync() {
        ResponseResult<List<ResTypeData>> result = AdlService.getService().getBusinessCaller().getResTypeListSync(buildResTypeListRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getResTypeListSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getResTypeListSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getResPageAsync() {
        ResPageRequest request = buildResPageRequest();
        AdlService.getService().getBusinessCaller().getResPageAsync(RequestScope.of(this), request, new RequestCallback<List<ResData>>() {
            @Override
            public void onSuccess(List<ResData> data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getResPageAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getResPageAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getResPageAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getResPageSync() {
        ResponseResult<List<ResData>> result = AdlService.getService().getBusinessCaller().getResPageSync(buildResPageRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getResPageSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getResPageSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
            resultView.setText(result.getMsg());
        }
    }

    private void getResInfoAsync() {
        ResInfoRequest request = buildResInfoRequest();
        AdlService.getService().getBusinessCaller().getResInfoAsync(RequestScope.of(this), request, new RequestCallback<ResInfoData>() {
            @Override
            public void onSuccess(ResInfoData data) {
                if (data != null) {
                    Log.d(TAG, "BusinessCallerTestActivity::getResInfoAsync::onSuccess : data : " + data);
                    resultView.setText(data.toString());
                } else {
                    Log.d(TAG, "BusinessCallerTestActivity::getResInfoAsync::onSuccess : data is null");
                }
            }
            @Override
            public void onError(int code, String msg) {
                Log.d(TAG, "BusinessCallerTestActivity::getResInfoAsync::onError : code : " + code + ", msg : " + msg);
                resultView.setText(msg);
            }
        });
    }

    private void getResInfoSync() {
        ResponseResult<ResInfoData> result = AdlService.getService().getBusinessCaller().getResInfoSync(buildResInfoRequest());
        if (result.getCode() == NzResponseCode.NZ_SUCCESS) {
            Log.d(TAG, "BusinessCallerTestActivity::getResInfoSync::onSuccess : data : " + result.getData());
            resultView.setText(result.getData().toString());
        } else {
            Log.d(TAG, "BusinessCallerTestActivity::getResInfoSync::onError : code : " + result.getCode() + ", msg : " + result.getMsg());
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
