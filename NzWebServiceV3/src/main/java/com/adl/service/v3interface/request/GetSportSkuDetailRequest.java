package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : GetSportSkuDetailRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetSportSkuDetailRequest {
    /** 运动编码 */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    private GetSportSkuDetailRequest(Builder b) {
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

        public GetSportSkuDetailRequest build() { return new GetSportSkuDetailRequest(this); }
    }

    public String getSportSkuId() { return sportSkuId; }
}