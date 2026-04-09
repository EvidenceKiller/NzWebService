package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class BaseSportIndicator {
    /**
     * 运动指标编码，索引列
     */
    @SerializedName("indicatorsCode")
    private String indicatorsCode;

    /**
     * 运动指标名称
     */
    @SerializedName("indicatorsName")
    private String indicatorsName;

    /**
     * 指标说明
     */
    @SerializedName("indicatorsRemark")
    private String indicatorsRemark;

    /**
     * 指标单位
     */
    @SerializedName("indicatorsUnit")
    private String indicatorsUnit;

    /**
     * 指标值
     */
    @SerializedName("indicatorsValue")
    private String indicatorsValue;

    /**
     * 运动图片
     */
    @SerializedName("indicatorsImages")
    private String indicatorsImages;

    /**
     * 运动视频
     */
    @SerializedName("indicatorsVideos")
    private String indicatorsVideos;

    public String getIndicatorsCode() {
        return indicatorsCode;
    }

    public String getIndicatorsName() {
        return indicatorsName;
    }

    public String getIndicatorsRemark() {
        return indicatorsRemark;
    }

    public String getIndicatorsUnit() {
        return indicatorsUnit;
    }

    public String getIndicatorsValue() {
        return indicatorsValue;
    }

    public String getIndicatorsImages() {
        return indicatorsImages;
    }

    public String getIndicatorsVideos() {
        return indicatorsVideos;
    }
}
