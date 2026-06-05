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
public final class MorePeopleVictoryRankData implements Serializable {

    /**
     * 用户标识码
     */
    @SerializedName("accountId")
    private String accountId;

    /**
     * 用户姓名
     */
    @SerializedName("accountName")
    private String accountName;

    /**
     * 用户头像
     */
    @SerializedName("faceUrl")
    private String faceUrl;

    /**
     * 胜利次数
     */
    @SerializedName("victoryNumber")
    private Integer victoryNumber = 0;

    /**
     * 胜率
     */
    @SerializedName("victoryRate")
    private Double victoryRate = 0.0;

    /**
     * 性别
     */
    @SerializedName("sex")
    private Integer sex = 0;
}
