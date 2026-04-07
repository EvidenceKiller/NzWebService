package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Name : SportSkuRankRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class SportSkuRankRequest {
    /** 场景code 1001 锻炼 */
    @SerializedName("sportSceneCodes")
    private List<String> sportSceneCodes;

    /** 运动场景类型 */
    @SerializedName("sportSceneType")
    private String sportSceneType;

    /** 运动id */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 日期类型 1：今日 2：七日 3：三十日 */
    @SerializedName("dayType")
    private String dayType;

    /** 机构id */
    @SerializedName("orgId")
    private String orgId;

    /** 租户机构id */
    @SerializedName("tenantOrgId")
    private String tenantOrgId;

    /** 运动时间 */
    @SerializedName("sportDateList")
    private List<Object> sportDateList;

    /** 排行数 */
    @SerializedName("rankNumber")
    private long rankNumber;

    /** 应用端 */
    @SerializedName("appCode")
    private String appCode;

    private SportSkuRankRequest(Builder b) {
        this.sportSceneCodes = b.sportSceneCodes;
        this.sportSceneType = b.sportSceneType;
        this.sportSkuId = b.sportSkuId;
        this.dayType = b.dayType;
        this.orgId = b.orgId;
        this.tenantOrgId = b.tenantOrgId;
        this.sportDateList = b.sportDateList;
        this.rankNumber = b.rankNumber;
        this.appCode = b.appCode;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private List<String> sportSceneCodes;
        private String sportSceneType;
        private String sportSkuId;
        private String dayType;
        private String orgId;
        private String tenantOrgId;
        private List<Object> sportDateList;
        private long rankNumber;
        private String appCode;

        public Builder sportSceneCodes(List<String> v) { this.sportSceneCodes = v; return this; }

        public Builder sportSceneType(String v) { this.sportSceneType = v; return this; }

        public Builder sportSkuId(String v) { this.sportSkuId = v; return this; }

        public Builder dayType(String v) { this.dayType = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder tenantOrgId(String v) { this.tenantOrgId = v; return this; }

        public Builder sportDateList(List<Object> v) { this.sportDateList = v; return this; }

        public Builder rankNumber(long v) { this.rankNumber = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public SportSkuRankRequest build() { return new SportSkuRankRequest(this); }
    }

    public List<String> getSportSceneCodes() { return sportSceneCodes; }
    public String getSportSceneType() { return sportSceneType; }
    public String getSportSkuId() { return sportSkuId; }
    public String getDayType() { return dayType; }
    public String getOrgId() { return orgId; }
    public String getTenantOrgId() { return tenantOrgId; }
    public List<Object> getSportDateList() { return sportDateList; }
    public long getRankNumber() { return rankNumber; }
    public String getAppCode() { return appCode; }
}