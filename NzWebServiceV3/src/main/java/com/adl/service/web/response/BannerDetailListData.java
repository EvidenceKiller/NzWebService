package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

public final class BannerDetailListData {

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
    private int bannerSort;

    @SerializedName("createTime")
    private String createTime;

    @SerializedName("updateTime")
    private String updateTime;

    @SerializedName("bannerEnable")
    private boolean bannerEnable;

    @SerializedName("currentFlag")
    private boolean currentFlag;

    public String getId() {
        return id;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getBannerId() {
        return bannerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTargetId() {
        return targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public String getTargetIds() {
        return targetIds;
    }

    public int getBannerSort() {
        return bannerSort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public boolean getBannerEnable() {
        return bannerEnable;
    }

    public boolean getCurrentFlag() {
        return currentFlag;
    }
}
