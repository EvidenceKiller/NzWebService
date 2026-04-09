package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public final class PersonRankData {

    /**
     * 排名
     */
    @SerializedName("rankNum")
    private long rankNum;

    /**
     * 运动结果
     */
    @SerializedName("sportResult")
    private String sportResult;

    /**
     * 原始运动结果
     */
    @SerializedName("originalSportResult")
    private String originalSportResult;

    public long getRankNum() {
        return rankNum;
    }

    public String getSportResult() {
        return sportResult;
    }

    public String getOriginalSportResult() {
        return originalSportResult;
    }
}
