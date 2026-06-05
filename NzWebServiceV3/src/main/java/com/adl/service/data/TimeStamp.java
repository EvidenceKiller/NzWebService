package com.adl.service.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class TimeStamp implements Serializable {

    /**
     * 当前时间时间戳，单位秒
     */
    @SerializedName("timestamp")
    private Double timestamp = 0.0;

    /**
     * 当前时间的标准字符串
     */
    @SerializedName("currentTime")
    private String currentTime;
}
