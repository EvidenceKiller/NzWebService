package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString
public final class StandardConfigPageData {

    /**
     * 标准ID
     */
    @SerializedName("standardId")
    private String standardId;

    /**
     * 标准名称
     */
    @SerializedName("standardName")
    private String standardName;

    /**
     * 标准类型枚举值: ZK,TC
     */
    @SerializedName("standardType")
    private String standardType;

    /**
     * 启停用状态枚举值: 0,1
     */
    @SerializedName("enabled")
    private String enabled;

    /**
     * 组织全部标志枚举值: 0,1
     */
    @SerializedName("orgAllFlag")
    private String orgAllFlag;

    /**
     * 项目列表
     */
    @SerializedName("sportSkuList")
    private List<String> sportSkuList;

    /**
     * 区域名称列表
     */
    @SerializedName("areaNames")
    private List<String> areaNames;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private String createTime;

    public String getStandardId() {
        return standardId;
    }

    public String getStandardName() {
        return standardName;
    }

    public String getStandardType() {
        return standardType;
    }

    public String getEnabled() {
        return enabled;
    }

    public String getOrgAllFlag() {
        return orgAllFlag;
    }

    public List<String> getSportSkuList() {
        return sportSkuList;
    }

    public List<String> getAreaNames() {
        return areaNames;
    }

    public String getCreateTime() {
        return createTime;
    }
}
