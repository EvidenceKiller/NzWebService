package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

public final class UpgradePlanByDeviceData {

    /**
     * 应用代码
     */
    @SerializedName("appCode")
    private String appCode;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private String createTime;

    /**
     * 生效结束时间
     */
    @SerializedName("endTime")
    private String endTime;

    /**
     * 文件大小
     */
    @SerializedName("fileSize")
    private int fileSize;

    /**
     * 主键id
     */
    @SerializedName("id")
    private String id;

    /**
     * 包名称
     */
    @SerializedName("packageName")
    private String packageName;

    /**
     * 包路径
     */
    @SerializedName("packagePath")
    private String packagePath;

    /**
     * 文件签名
     */
    @SerializedName("packageSign")
    private String packageSign;

    /**
     * 计划名称
     */
    @SerializedName("planName")
    private String planName;

    /**
     * 产品代码
     */
    @SerializedName("productCode")
    private String productCode;

    /**
     * 备注
     */
    @SerializedName("remark")
    private String remark;

    /**
     * sso域名
     */
    @SerializedName("ssoDomain")
    private String ssoDomain;

    /**
     * 生效时间
     */
    @SerializedName("startTime")
    private String startTime;

    /**
     * 升级方式 参考字典编码：adl_bms_device_ota_upgrade_method 10 自动升级 11 自动升级-强制更新 12 自动升级-非强制更新 13 自动升级-静默更新 20 手动升级
     */
    @SerializedName("upgradeMethod")
    private int upgradeMethod;

    /**
     * 升级版本号
     */
    @SerializedName("upgradeVersion")
    private String upgradeVersion;

    public String getAppCode() {
        return appCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getId() {
        return id;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public String getPackageSign() {
        return packageSign;
    }

    public String getPlanName() {
        return planName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getRemark() {
        return remark;
    }

    public String getSsoDomain() {
        return ssoDomain;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getUpgradeMethod() {
        return upgradeMethod;
    }

    public String getUpgradeVersion() {
        return upgradeVersion;
    }
}
