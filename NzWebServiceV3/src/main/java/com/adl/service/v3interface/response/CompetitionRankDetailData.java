package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    public String getId() { return id; }
    public String getOnlineTitle() { return onlineTitle; }
    public String getOnlineSubtitle() { return onlineSubtitle; }
    public String getOnlineCover() { return onlineCover; }
    public String getCoverCustom() { return coverCustom; }
    public int getOnlineType() { return onlineType; }
    public int getOrgLevel() { return orgLevel; }
    public String getOrgLevelName() { return orgLevelName; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public List<Object> getAppCodes() { return appCodes; }
    public List<Object> getCompetitionRange() { return competitionRange; }
    public List<Object> getOrgNames() { return orgNames; }
    public int getRankRule() { return rankRule; }
    public List<Object> getCompetitionItem() { return competitionItem; }
    public String getRemark() { return remark; }
    public boolean getJoinFlag() { return joinFlag; }
    public int getOrgType() { return orgType; }
    public int getCompetitionEnabled() { return competitionEnabled; }
    public String getOrgId() { return orgId; }
    public boolean getEditFlag() { return editFlag; }
}
