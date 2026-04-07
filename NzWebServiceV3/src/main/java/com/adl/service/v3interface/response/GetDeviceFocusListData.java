package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public final class GetDeviceFocusListData {
    @SerializedName("id")
    private String id;

    /** 设备Id */
    @SerializedName("deviceId")
    private String deviceId;

    /** 应用代码 */
    @SerializedName("appCode")
    private String appCode;

    /** 场景标识码 */
    @SerializedName("sceneCode")
    private String sceneCode;

    /** 业务Id */
    @SerializedName("busiId")
    private String busiId;

    /** 业务名称 */
    @SerializedName("busiName")
    private String busiName;

    /** 专注时间类型 */
    @SerializedName("timeType")
    private int timeType;

    /** 专注开始时间 */
    @SerializedName("startTime")
    private String startTime;

    /** 专注结束时间 */
    @SerializedName("endTime")
    private String endTime;

    /** 设备ids */
    @SerializedName("deviceIds")
    private List<Object> deviceIds;

    public String getId() { return id; }
    public String getDeviceId() { return deviceId; }
    public String getAppCode() { return appCode; }
    public String getSceneCode() { return sceneCode; }
    public String getBusiId() { return busiId; }
    public String getBusiName() { return busiName; }
    public int getTimeType() { return timeType; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public List<Object> getDeviceIds() { return deviceIds; }
}