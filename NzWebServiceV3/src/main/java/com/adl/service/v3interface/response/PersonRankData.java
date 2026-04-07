package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



/**
 * Name : PersonRankData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class PersonRankData {
    /** 排名 */
    @SerializedName("rankNum")
    private long rankNum;

    /** 运动结果 */
    @SerializedName("sportResult")
    private String sportResult;

    /** 原始运动结果 */
    @SerializedName("originalSportResult")
    private String originalSportResult;

    public long getRankNum() { return rankNum; }
    public String getSportResult() { return sportResult; }
    public String getOriginalSportResult() { return originalSportResult; }
}