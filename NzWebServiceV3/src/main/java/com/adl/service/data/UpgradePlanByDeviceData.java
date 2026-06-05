package com.adl.service.data;

import java.io.Serializable;

import com.adl.auth.common.AdlUpgradeInfo;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class UpgradePlanByDeviceData implements Serializable {

    /**
     * 应用代码
     */
    @SerializedName("appCode")
    private String appCode;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private Long createTime = 0L;

    /**
     * 生效结束时间
     */
    @SerializedName("endTime")
    private String endTime;

    /**
     * 文件大小
     */
    @SerializedName("fileSize")
    private Integer fileSize = 0;

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
     * 包版本
     */
    @SerializedName("packageVersion")
    private String packageVersion;

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
    private Integer upgradeMethod = 0;

    /**
     * 升级版本号
     */
    @SerializedName("upgradeVersion")
    private String upgradeVersion;

    @SerializedName("moduleStr")
    private String moduleStr;

    @SerializedName("enableSort")
    private Boolean enableSort = Boolean.FALSE;

    public String getDownloadUrl() {
        return this.ssoDomain + "/" + this.packagePath;
    }

    public AdlUpgradeInfo convertToAdlUpgradeInfo() {
        AdlUpgradeInfo adlUpgradeInfo = new AdlUpgradeInfo();
        adlUpgradeInfo.setAppCode(this.appCode);
        adlUpgradeInfo.setProductCode(this.productCode);
        adlUpgradeInfo.setId(this.id);
        adlUpgradeInfo.setModuleStr(this.moduleStr);
        adlUpgradeInfo.setEnableSort(this.enableSort);
        adlUpgradeInfo.setPlanName(this.planName);
        adlUpgradeInfo.setUpgradeVersion(this.upgradeVersion);
        adlUpgradeInfo.setUpgradeMethod(this.upgradeMethod);
        adlUpgradeInfo.setStartTime(Long.valueOf(this.startTime));
        adlUpgradeInfo.setEndTime(Long.valueOf(this.endTime));
        adlUpgradeInfo.setFileSize(this.fileSize);
        adlUpgradeInfo.setPackageSign(this.packageSign);
        adlUpgradeInfo.setPackagePath(this.packagePath);
        adlUpgradeInfo.setPackageVersion(this.packageVersion);
        adlUpgradeInfo.setSsoDomain(this.ssoDomain);
        adlUpgradeInfo.setRemark(this.remark);
        return adlUpgradeInfo;
    }
}
