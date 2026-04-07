package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class GetDictMapRequest {
    /** 运动编码 */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    private GetDictMapRequest(Builder b) {
        this.sportSkuId = b.sportSkuId;
    }

    public static Builder builder(String sportSkuId) {
        return new Builder(sportSkuId);
    }

    public static class Builder {
        private String sportSkuId;

        Builder(String sportSkuId) {
            this.sportSkuId = sportSkuId;
        }

        public GetDictMapRequest build() { return new GetDictMapRequest(this); }
    }

    public String getSportSkuId() { return sportSkuId; }
}