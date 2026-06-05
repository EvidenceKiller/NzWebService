package com.adl.service.internal;

import android.content.Context;

import androidx.annotation.RestrictTo;

/**
 * Retrofit 与 Caller 统一管理器（单例）。
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class RetrofitManager {

    private static volatile RetrofitManager instance;

    private RetrofitClient retrofitClient;

    private RetrofitManager() {
    }

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    public synchronized void init(Context context, String host) {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        retrofitClient.init(context, host);
    }

    public <T> T create(Class<T> service) {
        if (retrofitClient == null) {
            throw new IllegalStateException("请先调用 init() 初始化");
        }
        return retrofitClient.create(service);
    }

    public String getBaseUrl() {
        return retrofitClient.getBaseUrl();
    }

    public synchronized void release() {
        retrofitClient.release();
        retrofitClient = null;
    }
}
