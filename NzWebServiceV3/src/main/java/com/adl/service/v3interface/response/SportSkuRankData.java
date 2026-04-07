package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



/**
 * Name : SportSkuRankData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class SportSkuRankData {
    /** 运动id */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 运动名称 */
    @SerializedName("sportSkuName")
    private String sportSkuName;

    public String getSportSkuId() { return sportSkuId; }
    public String getSportSkuName() { return sportSkuName; }
}