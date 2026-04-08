package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

public final class BaseSportPlan {
    /**
     * 组织测试计划ID
     */
    @SerializedName("ptPlanId")
    private String ptPlanId;

    /**
     * 组织测试标准ID
     */
    @SerializedName("ptStandardId")
    private String ptStandardId;

    /**
     * 组织测试标准类型
     */
    @SerializedName("ptStandardType")
    private String ptStandardType;

    /**
     * 组织测试批次
     */
    @SerializedName("ptBatch")
    private Integer ptBatch;

    /**
     * 组织测试运动标准分
     */
    @SerializedName("ptSportStandardScore")
    private String ptSportStandardScore;

    /**
     * 组织测试运动标准等级
     */
    @SerializedName("ptSportStandardLevel")
    private String ptSportStandardLevel;

    /**
     * 组织测试运动单项得分
     */
    @SerializedName("ptSportScore")
    private String ptSportScore;

    /**
     * 组织测试运动单项附加分
     */
    @SerializedName("ptSportStandardAddScore")
    private String ptSportStandardAddScore;

    /**
     * 是否违规
     */
    @SerializedName("sportViolationStatus")
    private Integer sportViolationStatus;

    /**
     * 运动违规次数
     */
    @SerializedName("sportViolationNumber")
    private Integer sportViolationNumber;

    /**
     * 组织测试运动成绩加减结果
     */
    @SerializedName("ptExtrasResult")
    private String ptExtrasResult;

    /**
     * 组织测试运动成绩加减模式 (+/-)
     */
    @SerializedName("ptExtrasResultMod")
    private String ptExtrasResultMod;

    /**
     * 组织测试运动加减分数
     */
    @SerializedName("ptExtrasScore")
    private String ptExtrasScore;

    /**
     * 组织测试运动分数加减模式 (+/-)
     */
    @SerializedName("ptExtrasScoreMod")
    private String ptExtrasScoreMod;

    /**
     * 测试类型 0:校方测试 1:自助测试
     */
    @SerializedName("ptTestType")
    private Integer ptTestType;

    public String getPtPlanId() {
        return ptPlanId;
    }

    public String getPtStandardId() {
        return ptStandardId;
    }

    public String getPtStandardType() {
        return ptStandardType;
    }

    public Integer getPtBatch() {
        return ptBatch;
    }

    public String getPtSportStandardScore() {
        return ptSportStandardScore;
    }

    public String getPtSportStandardLevel() {
        return ptSportStandardLevel;
    }

    public String getPtSportScore() {
        return ptSportScore;
    }

    public String getPtSportStandardAddScore() {
        return ptSportStandardAddScore;
    }

    public Integer getSportViolationStatus() {
        return sportViolationStatus;
    }

    public Integer getSportViolationNumber() {
        return sportViolationNumber;
    }

    public String getPtExtrasResult() {
        return ptExtrasResult;
    }

    public String getPtExtrasResultMod() {
        return ptExtrasResultMod;
    }

    public String getPtExtrasScore() {
        return ptExtrasScore;
    }

    public String getPtExtrasScoreMod() {
        return ptExtrasScoreMod;
    }

    public Integer getPtTestType() {
        return ptTestType;
    }
}
