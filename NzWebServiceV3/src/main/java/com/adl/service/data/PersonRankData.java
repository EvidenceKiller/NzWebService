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
public final class PersonRankData implements Serializable {

    /**
     * 排名
     */
    @SerializedName("rankNum")
    private Long rankNum = 0L;

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
}
