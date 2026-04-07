package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : CompetitionRankRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class CompetitionRankRequest {
    /** 赛事id */
    @SerializedName("competitionId")
    private String competitionId;

    /** 排行类型 1：总榜2：学校 3：年级 4：班级 */
    @SerializedName("rankType")
    private String rankType;

    /** 排行id （学校/年级/班级）id */
    @SerializedName("rankId")
    private String rankId;

    /** 运动id */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 排名的数量 */
    @SerializedName("rankNumber")
    private long rankNumber;

    /** 账号id */
    @SerializedName("accountId")
    private String accountId;

    private CompetitionRankRequest(Builder b) {
        this.competitionId = b.competitionId;
        this.rankType = b.rankType;
        this.rankId = b.rankId;
        this.sportSkuId = b.sportSkuId;
        this.rankNumber = b.rankNumber;
        this.accountId = b.accountId;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String competitionId;
        private String rankType;
        private String rankId;
        private String sportSkuId;
        private long rankNumber;
        private String accountId;

        public Builder competitionId(String v) { this.competitionId = v; return this; }

        public Builder rankType(String v) { this.rankType = v; return this; }

        public Builder rankId(String v) { this.rankId = v; return this; }

        public Builder sportSkuId(String v) { this.sportSkuId = v; return this; }

        public Builder rankNumber(long v) { this.rankNumber = v; return this; }

        public Builder accountId(String v) { this.accountId = v; return this; }

        public CompetitionRankRequest build() { return new CompetitionRankRequest(this); }
    }

    public String getCompetitionId() { return competitionId; }
    public String getRankType() { return rankType; }
    public String getRankId() { return rankId; }
    public String getSportSkuId() { return sportSkuId; }
    public long getRankNumber() { return rankNumber; }
    public String getAccountId() { return accountId; }
}