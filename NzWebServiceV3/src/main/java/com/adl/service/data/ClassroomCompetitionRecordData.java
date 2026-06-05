package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Name : SportDetailListData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class ClassroomCompetitionRecordData implements Serializable {
    @SerializedName("orgId")
    private String orgId;

    @SerializedName("orgName")
    private String orgName;

    @SerializedName("gradeId")
    private String gradeId;

    @SerializedName("gradeName")
    private String gradeName;

    @SerializedName("classId")
    private String classId;

    @SerializedName("className")
    private String className;

    @SerializedName("accountIds")
    private List<String> accountIds;

    @SerializedName("avatars")
    private List<String> avatars;

    @SerializedName("userName")
    private String userName;

    @SerializedName("sex")
    private String sex;

    @SerializedName("studentCode")
    private String studentCode;

    @SerializedName("appCode")
    private String appCode;

    @SerializedName("appName")
    private String appName;

    @SerializedName("sportSkuId")
    private String sportSkuId;

    @SerializedName("sportSkuName")
    private String sportSkuName;

    @SerializedName("sportResultTotal")
    private String sportResultTotal;

    @SerializedName("originalSportResultTotal")
    private String originalSportResultTotal;

    @SerializedName("sportResultAvg")
    private String sportResultAvg;

    @SerializedName("originalSportResultAvg")
    private String originalSportResultAvg;

    @SerializedName("sportTime")
    private Long sportTime = 0L;

    @SerializedName("multiPersonId")
    private String multiPersonId;

    @SerializedName("multiPersonRank")
    private Integer multiPersonRank = 0;

    @SerializedName("multiPersonRanks")
    private List<String> multiPersonRanks;

    @SerializedName("multiPersonIndex")
    private Integer multiPersonIndex = 0;

    @SerializedName("ptSportStandardScore")
    private String ptSportStandardScore;

    @SerializedName("sportStartTime")
    private Long sportStartTime = 0L;

    @SerializedName("sportEndTime")
    private Long sportEndTime = 0L;

    @SerializedName("sportVideoUrls")
    private String sportVideoUrls;

    @SerializedName("accuracyType")
    private Integer accuracyType = 0;

    @SerializedName("accuracyMethod")
    private Integer accuracyMethod = 0;

    @SerializedName("sportUnitCode")
    private String sportUnitCode;

    @SerializedName("sportUnitName")
    private String sportUnitName;

    @SerializedName("sportPriority")
    private Integer sportPriority = 0;
}