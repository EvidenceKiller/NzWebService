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
public final class BannerDetailData implements Serializable {

    /**
     * 主键id
     */
    @SerializedName("id")
    private String id;

    /**
     * 租户标识码
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * banner标识码
     */
    @SerializedName("bannerId")
    private String bannerId;

    /**
     * 图片路径
     */
    @SerializedName("imageUrl")
    private String imageUrl;

    /**
     * 目标id
     */
    @SerializedName("targetId")
    private String targetId;

    /**
     * 类型 详见码表
     */
    @SerializedName("targetType")
    private String targetType;

    /**
     * 目标id
     */
    @SerializedName("targetIds")
    private String targetIds;

    /**
     * 排序
     */
    @SerializedName("bannerSort")
    private Integer bannerSort = 0;

    @SerializedName("createTime")
    private Long createTime = 0L;

    @SerializedName("updateTime")
    private Long updateTime = 0L;

    @SerializedName("bannerEnable")
    private Boolean bannerEnable = Boolean.FALSE;

    @SerializedName("currentFlag")
    private Boolean currentFlag = Boolean.FALSE;
}
