package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class MorePeopleVictoryRankRequest {
    /** SKU ID */
    @SerializedName("skuId")
    private String skuId;

    /** 上榜的最大排名 */
    @SerializedName("maxRank")
    private int maxRank;

    /** 前N名 */
    @SerializedName("top")
    private int top;

    private MorePeopleVictoryRankRequest(Builder b) {
        this.skuId = b.skuId;
        this.maxRank = b.maxRank;
        this.top = b.top;
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

        public Builder maxRank(int v) { this.maxRank = v; return this; }

        public Builder top(int v) { this.top = v; return this; }

        public MorePeopleVictoryRankRequest build() { return new MorePeopleVictoryRankRequest(this); }
    }

    public String getSkuId() { return skuId; }
    public int getMaxRank() { return maxRank; }
    public int getTop() { return top; }
}