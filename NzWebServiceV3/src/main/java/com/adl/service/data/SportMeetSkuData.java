package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class SportMeetSkuData implements Serializable {
    @SerializedName("accuracyMethod")
    private Integer accuracyMethod = 0;

    @SerializedName("accuracyType")
    private Integer accuracyType = 0;

    @SerializedName("applyUserCount")
    private Integer applyUserCount = 0;

    @SerializedName("classList")
    private List<SportMeetSkuSimpleClassData> classList;

    @SerializedName("competitionType")
    private Integer competitionType = 0;

    @SerializedName("coverUrl")
    private String coverUrl;

    @SerializedName("createTime")
    private Long createTime = 0L;

    @SerializedName("endRemark")
    private String endRemark;

    @SerializedName("endType")
    private Integer endType = 0;

    @SerializedName("endValue")
    private Long endValue = 0L;

    @SerializedName("id")
    private String id;

    @SerializedName("measureMode")
    private String measureMode;

    @SerializedName("measureUnitCode")
    private String measureUnitCode;

    @SerializedName("meetId")
    private String meetId;

    @SerializedName("meetSkuSort")
    private Integer meetSkuSort = 0;

    @SerializedName("settingId")
    private String settingId;

    @SerializedName("sportPriority")
    private Integer sportPriority = 0;

    @SerializedName("sportSkuId")
    private String sportSkuId;

    @SerializedName("sportSkuName")
    private String sportSkuName;

    @SerializedName("sportTypeName")
    private String sportTypeName;

    @SerializedName("testCount")
    private Integer testCount = 0;

    @SerializedName("updateTime")
    private Long updateTime = 0L;

    @SerializedName("appCodes")
    private List<String> appCodes;

    @SerializedName("competitionNum")
    private Integer competitionNum = 0;

    @SerializedName("limitFemale")
    private Integer limitFemale = 0;

    @SerializedName("limitMale")
    private Integer limitMale = 0;

    @SerializedName("updateFlag")
    private Boolean updateFlag = Boolean.FALSE;

    @SerializedName("limitTeam")
    private Integer limitTeam = 0;
}
