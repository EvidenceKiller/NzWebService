package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class MorePeopleRecordRankRequest {

    /**
     * 运动id
     */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /**
     * 机构id
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * 对战组数
     */
    @SerializedName("rankNumber")
    private long rankNumber;

    private MorePeopleRecordRankRequest(Builder builder) {
        this.sportSkuId = builder.sportSkuId;
        this.orgId = builder.orgId;
        this.rankNumber = builder.rankNumber;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private String sportSkuId;
        private String orgId;
        private long rankNumber;

        public Builder sportSkuId(String sportSkuId) {
            this.sportSkuId = sportSkuId;
            return this;
        }

        public Builder orgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public Builder rankNumber(long rankNumber) {
            this.rankNumber = rankNumber;
            return this;
        }

        public MorePeopleRecordRankRequest build() {
            return new MorePeopleRecordRankRequest(this);
        }
    }

    public String getSportSkuId() {
        return sportSkuId;
    }

    public String getOrgId() {
        return orgId;
    }

    public long getRankNumber() {
        return rankNumber;
    }
}