package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class GroupTeamData {

    /** 分组code */
    @SerializedName("teamUnitCode")
    private String teamUnitCode;

    /** 分组名称 */
    @SerializedName("teamUnitName")
    private String teamUnitName;

    /** 项目名称 */
    @SerializedName("sportSkuName")
    private String sportSkuName;

    /** 项目skuId */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 运动会项目skuId */
    @SerializedName("meetSportSkuId")
    private String meetSportSkuId;

    /** 组数 */
    @SerializedName("teamNum")
    private int teamNum;

    /** 人数 */
    @SerializedName("number")
    private int number;

    /** 比赛状态 0未完赛 1已完赛 */
    @SerializedName("competitionStatus")
    private int competitionStatus;

    /** tis_competition_meet_type 1集体 2个人 */
    @SerializedName("competitionType")
    private int competitionType;

    /** 轮次 */
    @SerializedName("competitionRound")
    private int competitionRound;

    /** 是否可以编辑成绩 0可以 1不可以 */
    @SerializedName("disabled")
    private int disabled;

    /** 人员详情 */
    @SerializedName("details")
    private List<Object> details;

    public String getTeamUnitCode() { return teamUnitCode; }
    public String getTeamUnitName() { return teamUnitName; }
    public String getSportSkuName() { return sportSkuName; }
    public String getSportSkuId() { return sportSkuId; }
    public String getMeetSportSkuId() { return meetSportSkuId; }
    public int getTeamNum() { return teamNum; }
    public int getNumber() { return number; }
    public int getCompetitionStatus() { return competitionStatus; }
    public int getCompetitionType() { return competitionType; }
    public int getCompetitionRound() { return competitionRound; }
    public int getDisabled() { return disabled; }
    public List<Object> getDetails() { return details; }
}
