package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



/**
 * Name : WarRecordRankData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class WarRecordRankData {
    /** 用户ID */
    @SerializedName("uid")
    private String uid;

    /** 胜者用户ID */
    @SerializedName("winnerUid")
    private String winnerUid;

    /** 胜者姓名 */
    @SerializedName("winnerName")
    private String winnerName;

    /** 胜者头像路径 */
    @SerializedName("winnerHeadPath")
    private String winnerHeadPath;

    /** 胜者成绩 */
    @SerializedName("winnerAchievement")
    private int winnerAchievement;

    /** 胜者个数 */
    @SerializedName("winnerCount")
    private int winnerCount;

    /** 胜者时间 */
    @SerializedName("winnerTime")
    private int winnerTime;

    /** 败者用户ID */
    @SerializedName("loserUid")
    private String loserUid;

    /** 败者姓名 */
    @SerializedName("loserName")
    private String loserName;

    /** 败者头像路径 */
    @SerializedName("loserHeadPath")
    private String loserHeadPath;

    /** 败者成绩 */
    @SerializedName("loserAchievement")
    private int loserAchievement;

    /** 败者个数 */
    @SerializedName("loserCount")
    private int loserCount;

    /** 败者时间 */
    @SerializedName("loserTime")
    private int loserTime;

    public String getUid() { return uid; }
    public String getWinnerUid() { return winnerUid; }
    public String getWinnerName() { return winnerName; }
    public String getWinnerHeadPath() { return winnerHeadPath; }
    public int getWinnerAchievement() { return winnerAchievement; }
    public int getWinnerCount() { return winnerCount; }
    public int getWinnerTime() { return winnerTime; }
    public String getLoserUid() { return loserUid; }
    public String getLoserName() { return loserName; }
    public String getLoserHeadPath() { return loserHeadPath; }
    public int getLoserAchievement() { return loserAchievement; }
    public int getLoserCount() { return loserCount; }
    public int getLoserTime() { return loserTime; }
}