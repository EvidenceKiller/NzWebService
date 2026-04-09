package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class BaseSportIndicatorReqData {
    /**
     * 运动指标编码, 索引列
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
    private List<String> indicatorsImages;

    /**
     * 运动视频
     */
    @SerializedName("indicatorsVideos")
    private List<String> indicatorsVideos;

    public List<String> getIndicatorsVideos() {
        return indicatorsVideos;
    }

    public List<String> getIndicatorsImages() {
        return indicatorsImages;
    }

    public String getIndicatorsValue() {
        return indicatorsValue;
    }

    public String getIndicatorsUnit() {
        return indicatorsUnit;
    }

    public String getIndicatorsRemark() {
        return indicatorsRemark;
    }

    public String getIndicatorsName() {
        return indicatorsName;
    }

    public String getIndicatorsCode() {
        return indicatorsCode;
    }

}
