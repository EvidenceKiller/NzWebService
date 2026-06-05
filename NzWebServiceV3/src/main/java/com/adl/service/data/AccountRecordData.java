package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class AccountRecordData implements Serializable {

    @SerializedName("enableSort")
    private Boolean enableSort = Boolean.FALSE;

    @SerializedName("moduleStr")
    private String moduleStr;

    @SerializedName("classId")
    private String classId;

    @SerializedName("sportSkuId")
    private String sportSkuId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("appCode")
    private String appCode;

    @SerializedName("sceneCode")
    private String sceneCode;

    @SerializedName("sportSceneCode")
    private String sportSceneCode;

    @SerializedName("semesterId")
    private String semesterId;

    @SerializedName("sportItemCode")
    private String sportItemCode;

    @SerializedName("sportTypeCode")
    private String sportTypeCode;

    @SerializedName("ptPlanId")
    private String ptPlanId;

    @SerializedName("recordId")
    private String recordId;

    @SerializedName("semesterName")
    private String semesterName;

    @SerializedName("accountName")
    private String accountName;

    @SerializedName("sex")
    private Integer sex = 0;

    @SerializedName("studentCode")
    private String studentCode;

    @SerializedName("orgName")
    private String orgName;

    @SerializedName("majorName")
    private String majorName;

    @SerializedName("gradeName")
    private String gradeName;

    @SerializedName("className")
    private String className;

    @SerializedName("appName")
    private String appName;

    @SerializedName("placeName")
    private String placeName;

    @SerializedName("placeId")
    private String placeId;

    @SerializedName("sportSceneName")
    private String sportSceneName;

    @SerializedName("sportSkuName")
    private String sportSkuName;

    @SerializedName("sportResult")
    private String sportResult;

    @SerializedName("sportUnitCode")
    private String sportUnitCode;

    @SerializedName("sportTime")
    private Integer sportTime = 0;

    @SerializedName("sportStartTime")
    private Long sportStartTime = 0L;

    @SerializedName("sportEndTime")
    private Long sportEndTime = 0L;

    @SerializedName("sportVideoUrls")
    private String sportVideoUrls;

    @SerializedName("reportFlag")
    private Boolean reportFlag = Boolean.FALSE;
}
