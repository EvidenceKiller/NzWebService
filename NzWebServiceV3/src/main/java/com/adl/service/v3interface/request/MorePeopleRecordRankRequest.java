package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : MorePeopleRecordRankRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class MorePeopleRecordRankRequest {
    /** 运动id */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 机构id */
    @SerializedName("orgId")
    private String orgId;

    /** 对战组数 */
    @SerializedName("rankNumber")
    private long rankNumber;

    private MorePeopleRecordRankRequest(Builder b) {
        this.sportSkuId = b.sportSkuId;
        this.orgId = b.orgId;
        this.rankNumber = b.rankNumber;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String sportSkuId;
        private String orgId;
        private long rankNumber;

        public Builder sportSkuId(String v) { this.sportSkuId = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder rankNumber(long v) { this.rankNumber = v; return this; }

        public MorePeopleRecordRankRequest build() { return new MorePeopleRecordRankRequest(this); }
    }

    public String getSportSkuId() { return sportSkuId; }
    public String getOrgId() { return orgId; }
    public long getRankNumber() { return rankNumber; }
}