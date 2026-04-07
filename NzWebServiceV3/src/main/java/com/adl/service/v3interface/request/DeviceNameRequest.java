package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : DeviceNameRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class DeviceNameRequest {
    /** 设备 Id */
    @SerializedName("id")
    private String id;

    /** 设备名称 */
    @SerializedName("deviceName")
    private String deviceName;

    /** mac 地址 */
    @SerializedName("macAddress")
    private String macAddress;

    private DeviceNameRequest(Builder b) {
        this.id = b.id;
        this.deviceName = b.deviceName;
        this.macAddress = b.macAddress;
    }

    public static Builder builder(String id) {
        return new Builder(id);
    }

    public static class Builder {
        private String id;
        private String deviceName;
        private String macAddress;

        Builder(String id) {
            this.id = id;
        }

        public Builder deviceName(String v) { this.deviceName = v; return this; }

        public Builder macAddress(String v) { this.macAddress = v; return this; }

        public DeviceNameRequest build() { return new DeviceNameRequest(this); }
    }

    public String getId() { return id; }
    public String getDeviceName() { return deviceName; }
    public String getMacAddress() { return macAddress; }
}