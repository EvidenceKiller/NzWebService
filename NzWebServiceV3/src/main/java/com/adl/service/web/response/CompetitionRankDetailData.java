package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
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
    private int onlineType;

    @SerializedName("orgLevel")
    private int orgLevel;

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
    private int rankRule;

    @SerializedName("competitionItem")
    private List<Object> competitionItem;

    @SerializedName("remark")
    private String remark;

    @SerializedName("joinFlag")
    private boolean joinFlag;

    @SerializedName("orgType")
    private int orgType;

    @SerializedName("competitionEnabled")
    private int competitionEnabled;

    @SerializedName("orgId")
    private String orgId;

    @SerializedName("editFlag")
    private boolean editFlag;
}
