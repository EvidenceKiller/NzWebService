package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

public final class SceneListRequest {

    @SerializedName("appCode")
    private String appCode;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("sceneType")
    private String sceneType;

    private SceneListRequest(Builder builder) {
        this.appCode = builder.appCode;
        this.enabled = builder.enabled;
        this.sceneType = builder.sceneType;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private String appCode;
        private boolean enabled;
        private String sceneType;

        public Builder appCode(String appCode) {
            this.appCode = appCode;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder sceneType(String sceneType) {
            this.sceneType = sceneType;
            return this;
        }

        public SceneListRequest build() {
            return new SceneListRequest(this);
        }
    }

    public String getAppCode() {
        return appCode;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public String getSceneType() {
        return sceneType;
    }
}