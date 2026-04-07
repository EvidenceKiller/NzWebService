package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : GetDeviceFocusListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetDeviceFocusListRequest {
    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("appCode")
    private String appCode;

    private GetDeviceFocusListRequest(Builder b) {
        this.deviceId = b.deviceId;
        this.appCode = b.appCode;
    }

    public static Builder builder(String deviceId) {
        return new Builder(deviceId);
    }

    public static class Builder {
        private String deviceId;
        private String appCode;

        Builder(String deviceId) {
            this.deviceId = deviceId;
        }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public GetDeviceFocusListRequest build() { return new GetDeviceFocusListRequest(this); }
    }

    public String getDeviceId() { return deviceId; }
    public String getAppCode() { return appCode; }
}