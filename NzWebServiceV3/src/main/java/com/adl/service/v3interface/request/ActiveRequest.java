package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class ActiveRequest {
    /** 激活码 */
    @SerializedName("activeCode")
    private String activeCode;

    /** 设备 ID */
    @SerializedName("deviceId")
    private String deviceId;

    private ActiveRequest(Builder b) {
        this.activeCode = b.activeCode;
        this.deviceId = b.deviceId;
    }

    public static Builder builder(String activeCode, String deviceId) {
        return new Builder(activeCode, deviceId);
    }

    public static class Builder {
        private String activeCode;
        private String deviceId;

        Builder(String activeCode, String deviceId) {
            this.activeCode = activeCode;
            this.deviceId = deviceId;
        }

        public ActiveRequest build() { return new ActiveRequest(this); }
    }

    public String getActiveCode() { return activeCode; }
    public String getDeviceId() { return deviceId; }
}