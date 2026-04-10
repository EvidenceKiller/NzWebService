package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
public final class DeviceFocusData {

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
}
