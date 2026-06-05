package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class OverviewData implements Serializable {

    /**
     * 运动总人次
     */
    @SerializedName("totalSportAccountNum")
    private Long totalSportAccountNum = 0L;

    /**
     * 今日运动人次
     */
    @SerializedName("todaySportAccountNum")
    private Long todaySportAccountNum = 0L;

    /**
     * 运动总时长 ms
     */
    @SerializedName("totalSportTime")
    private Long totalSportTime = 0L;

    /**
     * 今日运动时长 ms
     */
    @SerializedName("todaySportTime")
    private Long todaySportTime = 0L;
}
