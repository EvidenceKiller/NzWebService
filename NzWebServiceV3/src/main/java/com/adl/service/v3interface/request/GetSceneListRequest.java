package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : GetSceneListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetSceneListRequest {
    @SerializedName("appCode")
    private String appCode;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("sceneType")
    private String sceneType;

    private GetSceneListRequest(Builder b) {
        this.appCode = b.appCode;
        this.enabled = b.enabled;
        this.sceneType = b.sceneType;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String appCode;
        private boolean enabled;
        private String sceneType;

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder enabled(boolean v) { this.enabled = v; return this; }

        public Builder sceneType(String v) { this.sceneType = v; return this; }

        public GetSceneListRequest build() { return new GetSceneListRequest(this); }
    }

    public String getAppCode() { return appCode; }
    public boolean getEnabled() { return enabled; }
    public String getSceneType() { return sceneType; }
}