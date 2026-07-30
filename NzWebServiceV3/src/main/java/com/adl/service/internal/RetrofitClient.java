package com.adl.service.internal;

import android.content.Context;
import android.text.TextUtils;

import com.adl.service.AdlService;
import com.adl.service.http.interceptor.HeaderInterceptor;
import com.adl.service.http.interceptor.SmartCacheInterceptor;
import com.adl.service.http.interceptor.TokenRefreshInterceptor;
import com.adl.service.internal.json.SerializedNameExclusionStrategy;
import com.adl.service.log.NzLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit + OkHttp 单例客户端（SDK 内部使用，不对外暴露）
 */
final class RetrofitClient {

    private static long HTTP_CACHE_TIME = 30 * 24 * 60 * 60; //接口缓存时间

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    @Getter
    private String baseUrl;

    public RetrofitClient() {
    }

    public synchronized void init(Context context, String baseUrl) {
        NzLog.i("RetorfitClient::init : baseUrl : " + baseUrl);
        if (context == null) {
            NzLog.e("RetorfitClient::init : context is null!!!");
        }
        if (TextUtils.isEmpty(baseUrl)) {
            NzLog.e("RetorfitClient::init : baseUrl is empty!!!");
        }
        String url = "";
        if (baseUrl.endsWith("/")) {
            url = baseUrl;
        } else {
            url = baseUrl + "/";
        }
        if (okHttpClient == null) {
            // 1. OkHttpClient
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new HeaderInterceptor())
                    .addInterceptor(new TokenRefreshInterceptor())
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(new SmartCacheInterceptor(context, true, HTTP_CACHE_TIME))
                    .build();
        }

        if (!TextUtils.equals(this.baseUrl, url)) {
            this.baseUrl = url;

            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new SerializedNameExclusionStrategy())
                    .create();

            NzLog.i("RetorfitClient::init : setBaseUrl : " + url);
            // 2. Retrofit（支持 RxJava3）
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
    }

    /**
     * 重置单例（用于切换 baseUrl，如环境切换）
     */
    public synchronized void release() {
        NzLog.i("RetorfitClient::release");
        // 关闭 OkHttpClient
        if (okHttpClient != null) {
            // 关闭连接池
            okHttpClient.connectionPool().evictAll();

            // 关闭缓存（如果有）
            if (okHttpClient.cache() != null) {
                try {
                    okHttpClient.cache().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 取消所有正在进行的请求
            okHttpClient.dispatcher().cancelAll();

            okHttpClient = null;
        }
        retrofit = null;
        baseUrl = null;
    }

    public synchronized <T> T create(Class<T> service) {
        if (retrofit == null) {
            throw new IllegalStateException("请先调用 init() 初始化");
        }
        return retrofit.create(service);
    }
}
