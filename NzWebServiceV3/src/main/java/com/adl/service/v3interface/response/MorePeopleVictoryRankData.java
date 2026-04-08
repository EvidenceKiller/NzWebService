package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

public final class MorePeopleVictoryRankData {

    /** 用户标识码 */
    @SerializedName("accountId")
    private String accountId;

    /** 用户姓名 */
    @SerializedName("accountName")
    private String accountName;

    /** 用户头像 */
    @SerializedName("faceUrl")
    private String faceUrl;

    /** 胜利次数 */
    @SerializedName("victoryNumber")
    private int victoryNumber;

    /** 胜率 */
    @SerializedName("victoryRate")
    private double victoryRate;

    /** 性别 */
    @SerializedName("sex")
    private int sex;

    public String getAccountId() { return accountId; }
    public String getAccountName() { return accountName; }
    public String getFaceUrl() { return faceUrl; }
    public int getVictoryNumber() { return victoryNumber; }
    public double getVictoryRate() { return victoryRate; }
    public int getSex() { return sex; }
}
