package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
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
}
