package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

public final class OverviewData {

    /**
     * 运动总人次
     */
    @SerializedName("totalSportAccountNum")
    private long totalSportAccountNum;

    /**
     * 今日运动人次
     */
    @SerializedName("todaySportAccountNum")
    private long todaySportAccountNum;

    /**
     * 运动总时长 ms
     */
    @SerializedName("totalSportTime")
    private long totalSportTime;

    /**
     * 今日运动时长 ms
     */
    @SerializedName("todaySportTime")
    private long todaySportTime;

    public long getTotalSportAccountNum() {
        return totalSportAccountNum;
    }

    public long getTodaySportAccountNum() {
        return todaySportAccountNum;
    }

    public long getTotalSportTime() {
        return totalSportTime;
    }

    public long getTodaySportTime() {
        return todaySportTime;
    }
}
