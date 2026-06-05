package com.adl.service.common;

import android.text.TextUtils;

import com.adl.service.internal.RetrofitManager;
import com.adl.service.utils.InnerUtil;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/3
 * Describe   : 异步任务实现
 */
public abstract class AdlConfigService {

    private static AdlConfig mConfig;

    public AdlConfigService() {
    }

    public static void setAdlConfig(AdlConfig config) {
        mConfig = config;
    }

    public static AdlConfig getAdlConfig() {
        if (mConfig == null) {
            mConfig = InnerPreferences.instance().readObject(IDefine.SpConfigService, AdlConfig.class);
        }
        return mConfig;
    }
}
