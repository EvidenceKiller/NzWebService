package com.adl.service.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class TimeStamp {

    /**
     * 当前时间时间戳，单位秒
     */
    private Long timestamp;

    /**
     * 当前时间的标准字符串
     */
    private String currentTime;
}
