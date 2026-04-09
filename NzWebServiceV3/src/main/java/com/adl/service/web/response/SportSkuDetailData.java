package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class SportSkuDetailData {

    /** sku标识码 {运动单项code} + {四位顺序号} */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 运动性质代码逗号分割 */
    @SerializedName("sportNatureCodes")
    private String sportNatureCodes;

    /** 运动性质名称 */
    @SerializedName("sportNatureNames")
    private String sportNatureNames;

    /** 运动类型代码 参考字典编码：adl_sport_type */
    @SerializedName("sportTypeCode")
    private String sportTypeCode;

    /** 运动类型名称 */
    @SerializedName("sportTypeName")
    private String sportTypeName;

    /** 运动单项代码 参考字典编码：adl_sport_item */
    @SerializedName("sportItemCode")
    private String sportItemCode;

    /** 运动单项名称 */
    @SerializedName("sportItemName")
    private String sportItemName;

    /** 运动sku名称 */
    @SerializedName("sportSkuName")
    private String sportSkuName;

    /** 测量方式 参考字典编码：adl_bms_sport_sku_measure_mode */
    @SerializedName("measureMode")
    private String measureMode;

    /** 测量单位代码 参考字典编码：adl_sport_sport_unit */
    @SerializedName("measureUnitCode")
    private String measureUnitCode;

    /** 测量范围结束值 */
    @SerializedName("rangeEndValue")
    private double rangeEndValue;

    /** 测量范围起始值 */
    @SerializedName("rangeStartValue")
    private double rangeStartValue;

    /** 精度类型 详见码表 */
    @SerializedName("accuracyType")
    private int accuracyType;

    /** 结束类型 参考字典编码：adl_bms_sport_sku_end_type */
    @SerializedName("endType")
    private int endType;

    /** 精度方式 详见码表 */
    @SerializedName("accuracyMethod")
    private int accuracyMethod;

    /** 结束方式 参考字典编码：adl_sport_end_unit */
    @SerializedName("endValue")
    private long endValue;

    /** 结束方式为其他时的备注 */
    @SerializedName("endRemark")
    private String endRemark;

    /** 默认图标地址 */
    @SerializedName("iconUrl")
    private String iconUrl;

    /** 封面图片地址 */
    @SerializedName("coverUrl")
    private String coverUrl;

    /** 动作演示地址 */
    @SerializedName("actionVideoUrl")
    private String actionVideoUrl;

    /** 音频地址 */
    @SerializedName("audioUrl")
    private String audioUrl;

    /** 音频 */
    @SerializedName("audioName")
    private String audioName;

    /** 视频地址 */
    @SerializedName("videoUrl")
    private String videoUrl;

    /** 视频封面地址 */
    @SerializedName("videoCoverUrl")
    private String videoCoverUrl;

    /** 项目描述富文本 text */
    @SerializedName("sportSkuDesc")
    private String sportSkuDesc;

    /** 体测模板文件地址 */
    @SerializedName("testTemplateUrl")
    private String testTemplateUrl;

    /** 体测模板文件名称 */
    @SerializedName("testTemplateName")
    private String testTemplateName;

    /** 题库模板地址 */
    @SerializedName("qusTemplateUrl")
    private String qusTemplateUrl;

    /** 题库模板名称 */
    @SerializedName("qusTemplateName")
    private String qusTemplateName;

    /** 腾讯视频VID */
    @SerializedName("txVid")
    private String txVid;

    /** 备注 */
    @SerializedName("remark")
    private String remark;

    /** 启停用 参考字典编码：adl_bms_enabled（1 启用 0 禁用） */
    @SerializedName("enabled")
    private boolean enabled;

    /** 删除标记为 */
    @SerializedName("delFlag")
    private boolean delFlag;

    /** 项目高低优 参考字典编码：adl_bms_sport_priority */
    @SerializedName("sportPriority")
    private int sportPriority;

    /** 测试人数 空为不限制 */
    @SerializedName("testCount")
    private int testCount;

    /** 场景运动Id */
    @SerializedName("sceneSkuId")
    private String sceneSkuId;

    /** 场景Code */
    @SerializedName("sceneCode")
    private String sceneCode;

    /** 场景运动排序 */
    @SerializedName("sceneSkuSort")
    private int sceneSkuSort;

    @SerializedName("appCodes")
    private List<String> appCodes;

    @SerializedName("qualities")
    private List<Integer> qualities;

    @SerializedName("sceneSkuType")
    private String sceneSkuType;

    public String getSportSkuId() { return sportSkuId; }
    public String getSportNatureCodes() { return sportNatureCodes; }
    public String getSportNatureNames() { return sportNatureNames; }
    public String getSportTypeCode() { return sportTypeCode; }
    public String getSportTypeName() { return sportTypeName; }
    public String getSportItemCode() { return sportItemCode; }
    public String getSportItemName() { return sportItemName; }
    public String getSportSkuName() { return sportSkuName; }
    public String getMeasureMode() { return measureMode; }
    public String getMeasureUnitCode() { return measureUnitCode; }
    public double getRangeEndValue() { return rangeEndValue; }
    public double getRangeStartValue() { return rangeStartValue; }
    public int getAccuracyType() { return accuracyType; }
    public int getEndType() { return endType; }
    public int getAccuracyMethod() { return accuracyMethod; }
    public long getEndValue() { return endValue; }
    public String getEndRemark() { return endRemark; }
    public String getIconUrl() { return iconUrl; }
    public String getCoverUrl() { return coverUrl; }
    public String getActionVideoUrl() { return actionVideoUrl; }
    public String getAudioUrl() { return audioUrl; }
    public String getAudioName() { return audioName; }
    public String getVideoUrl() { return videoUrl; }
    public String getVideoCoverUrl() { return videoCoverUrl; }
    public String getSportSkuDesc() { return sportSkuDesc; }
    public String getTestTemplateUrl() { return testTemplateUrl; }
    public String getTestTemplateName() { return testTemplateName; }
    public String getQusTemplateUrl() { return qusTemplateUrl; }
    public String getQusTemplateName() { return qusTemplateName; }
    public String getTxVid() { return txVid; }
    public String getRemark() { return remark; }
    public boolean getEnabled() { return enabled; }
    public boolean getDelFlag() { return delFlag; }
    public int getSportPriority() { return sportPriority; }
    public int getTestCount() { return testCount; }
    public String getSceneSkuId() { return sceneSkuId; }
    public String getSceneCode() { return sceneCode; }
    public int getSceneSkuSort() { return sceneSkuSort; }
    public List<String> getAppCodes() { return appCodes; }
    public List<Integer> getQualities() { return qualities; }
    public String getSceneSkuType() { return sceneSkuType; }
}
