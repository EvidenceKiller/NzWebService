package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

public final class CompetitionMyRankData {
    /** 用户标识码 */
    @SerializedName("accountId")
    private String accountId;

    /** 学生姓名 */
    @SerializedName("accountName")
    private String accountName;

    /** 学生头像 */
    @SerializedName("accountAvatar")
    private String accountAvatar;

    /** 学生性别 1 男 2 女 */
    @SerializedName("sex")
    private String sex;

    /** 成绩 */
    @SerializedName("score")
    private int score;

    /** 运动结果 */
    @SerializedName("sportResult")
    private String sportResult;

    /** 学校名 */
    @SerializedName("orgName")
    private String orgName;

    /** 班级名（年级班级一起返回） */
    @SerializedName("className")
    private String className;

    /** 排名 */
    @SerializedName("rankNum")
    private int rankNum;

    /** 运动结束时间 */
    @SerializedName("sportEndTime")
    private long sportEndTime;

    /** 运动得分 */
    @SerializedName("sportScore")
    private double sportScore;

    /** 精度类型 */
    @SerializedName("accuracyType")
    private int accuracyType;

    /** 精度方式 */
    @SerializedName("accuracyMethod")
    private int accuracyMethod;

    /** 运动单位代码 */
    @SerializedName("sportUnitCode")
    private String sportUnitCode;

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountAvatar() {
        return accountAvatar;
    }

    public String getSex() {
        return sex;
    }

    public int getScore() {
        return score;
    }

    public String getSportResult() {
        return sportResult;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getClassName() {
        return className;
    }

    public int getRankNum() {
        return rankNum;
    }

    public long getSportEndTime() {
        return sportEndTime;
    }

    public double getSportScore() {
        return sportScore;
    }

    public int getAccuracyType() {
        return accuracyType;
    }

    public int getAccuracyMethod() {
        return accuracyMethod;
    }

    public String getSportUnitCode() {
        return sportUnitCode;
    }
}
