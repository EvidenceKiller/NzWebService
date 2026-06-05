package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class DateConfigData implements Serializable {
    @SerializedName("id")
    private String id;

    // 计划id
    @SerializedName("planId")
    private String planId;

    // 预约时间yyyy-mm-dd
    @SerializedName("reserveDate")
    private String reserveDate;

    // 开始时间 hh:ss
    @SerializedName("startTime")
    private String startTime;

    // 结束时间 hh:ss
    @SerializedName("endTime")
    private String endTime;

    // 是否区分预约日期（0否 1是）
    @SerializedName("reserveType")
    private Integer reserveType = 0;

    // 预约人数上限
    @SerializedName("reserveMaxNum")
    private Integer reserveMaxNum = 0;

    // 运动类型 （0跑步类、1非跑步类）
    @SerializedName("sportType")
    private Integer sportType = 0;

    // 每周重复的预约日期（1,2,3对应周一,周二,周三）
    @SerializedName("reserveDay")
    private String reserveDay;

    // 发布账户ID
    @SerializedName("creatorId")
    private String creatorId;

    // 发布账户姓名
    @SerializedName("creatorName")
    private String creatorName;

    // 更新时间
    @SerializedName("updateTime")
    private Long updateTime = 0L;

    // 创建时间
    @SerializedName("createTime")
    private Long createTime = 0L;
}
