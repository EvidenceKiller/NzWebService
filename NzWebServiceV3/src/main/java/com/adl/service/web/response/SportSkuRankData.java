package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class SportSkuRankData {

    /**
     * 运动id
     */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /**
     * 运动名称
     */
    @SerializedName("sportSkuName")
    private String sportSkuName;
}
