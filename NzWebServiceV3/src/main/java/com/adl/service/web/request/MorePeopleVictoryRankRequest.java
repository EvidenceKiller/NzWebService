package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class MorePeopleVictoryRankRequest {

    /**
     * SKU ID
     */
    @SerializedName("skuId")
    private String skuId;

    /**
     * 上榜的最大排名
     */
    @SerializedName("maxRank")
    private int maxRank;

    /**
     * 前N名
     */
    @SerializedName("top")
    private int top;

    private MorePeopleVictoryRankRequest(Builder builder) {
        this.skuId = builder.skuId;
        this.maxRank = builder.maxRank;
        this.top = builder.top;
    }

    public static Builder builder(String skuId) {
        return new Builder(skuId);
    }


    public static class Builder {
        private String skuId;
        private int maxRank;
        private int top;

        Builder(String skuId) {
            this.skuId = skuId;
        }

        public Builder maxRank(int maxRank) {
            this.maxRank = maxRank;
            return this;
        }

        public Builder top(int top) {
            this.top = top;
            return this;
        }

        public MorePeopleVictoryRankRequest build() {
            return new MorePeopleVictoryRankRequest(this);
        }
    }

    public String getSkuId() {
        return skuId;
    }

    public int getMaxRank() {
        return maxRank;
    }

    public int getTop() {
        return top;
    }
}