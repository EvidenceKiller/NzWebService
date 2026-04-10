package com.adl.service.web.response;

import com.adl.service.internal.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonAdapter(StrictJsonDeserializer.class)
public final class CompetitionRankDetailData {

    @SerializedName("id")
    private String id;

    @SerializedName("onlineTitle")
    private String onlineTitle;

    @SerializedName("onlineSubtitle")
    private String onlineSubtitle;

    @SerializedName("onlineCover")
    private String onlineCover;

    @SerializedName("coverCustom")
    private String coverCustom;

    @SerializedName("onlineType")
    private Integer onlineType;

    @SerializedName("orgLevel")
    private Integer orgLevel;

    @SerializedName("orgLevelName")
    private String orgLevelName;

    @SerializedName("startTime")
    private String startTime;

    @SerializedName("endTime")
    private String endTime;

    @SerializedName("appCodes")
    private List<Object> appCodes;

    @SerializedName("competitionRange")
    private List<Object> competitionRange;

    @SerializedName("orgNames")
    private List<Object> orgNames;

    @SerializedName("rankRule")
    private Integer rankRule;

    @SerializedName("competitionItem")
    private List<Object> competitionItem;

    @SerializedName("remark")
    private String remark;

    @SerializedName("joinFlag")
    private Boolean joinFlag;

    @SerializedName("orgType")
    private Integer orgType;

    @SerializedName("competitionEnabled")
    private Integer competitionEnabled;

    @SerializedName("orgId")
    private String orgId;

    @SerializedName("editFlag")
    private Boolean editFlag;
}
