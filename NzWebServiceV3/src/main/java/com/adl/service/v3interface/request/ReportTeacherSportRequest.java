package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class ReportTeacherSportRequest {
    /** 用户标识码 */
    @SerializedName("accountId")
    private String accountId;

    /** 产品应用标识码 */
    @SerializedName("appCode")
    private String appCode;

    /** 产品应用标识名称 */
    @SerializedName("appName")
    private String appName;

    /** 运动完美个数 */
    @SerializedName("perfectCount")
    private int perfectCount;

    /** 运动优秀个数 */
    @SerializedName("bravoCount")
    private int bravoCount;

    /** 运动良好个数 */
    @SerializedName("goodeviceount")
    private int goodeviceount;

    /** 扩展JSON */
    @SerializedName("extraJson")
    private String extraJson;

    /** 记录标识码 */
    @SerializedName("id")
    private String id;

    /** 记录有效标识位 */
    @SerializedName("invalidFlag")
    private int invalidFlag;

    /** 运动统计字段 例：跳绳类为个数 阳光跑为mm */
    @SerializedName("sportCount")
    private long sportCount;

    /** 运动开始时间，时间戳不能为空 */
    @SerializedName("sportStartTime")
    private String sportStartTime;

    /** 运动结束时间，时间戳不能为空 */
    @SerializedName("sportEndTime")
    private String sportEndTime;

    /** 运动图片集 */
    @SerializedName("sportImages")
    private List<Map<String, Object>> sportImages;

    /** 图片说明 */
    @SerializedName("imageDesc")
    private String imageDesc;

    /** 图片相对地址 */
    @SerializedName("imageUrl")
    private String imageUrl;

    /** 分组编号 */
    @SerializedName("groupIndex")
    private String groupIndex;

    /** 运动视频集 */
    @SerializedName("sportVideos")
    private List<Map<String, Object>> sportVideos;

    /** 视频说明 */
    @SerializedName("videoDesc")
    private String videoDesc;

    /** 视频相对地址 */
    @SerializedName("videoUrl")
    private String videoUrl;

    /** 视频封面图 */
    @SerializedName("videoCover")
    private String videoCover;

    /** 运动结果 */
    @SerializedName("sportResult")
    private String sportResult;

    /** 运动场景代码 */
    @SerializedName("sportSceneCode")
    private String sportSceneCode;

    /** 运动得分 */
    @SerializedName("sportScore")
    private double sportScore;

    /** 运动sku编码 */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 运动标签 */
    @SerializedName("sportSkuSubType")
    private String sportSkuSubType;

    /** 运动时长 */
    @SerializedName("sportTime")
    private long sportTime;

    /** 运动单位编码 */
    @SerializedName("sportUnitCode")
    private String sportUnitCode;

    /** 原始运动结果 */
    @SerializedName("originalSportResult")
    private String originalSportResult;

    /** 是否违规不能为空 1:违规 */
    @SerializedName("sportViolationStatus")
    private int sportViolationStatus;

    private ReportTeacherSportRequest(Builder b) {
        this.accountId = b.accountId;
        this.appCode = b.appCode;
        this.appName = b.appName;
        this.perfectCount = b.perfectCount;
        this.bravoCount = b.bravoCount;
        this.goodeviceount = b.goodeviceount;
        this.extraJson = b.extraJson;
        this.id = b.id;
        this.invalidFlag = b.invalidFlag;
        this.sportCount = b.sportCount;
        this.sportStartTime = b.sportStartTime;
        this.sportEndTime = b.sportEndTime;
        this.sportImages = b.sportImages;
        this.imageDesc = b.imageDesc;
        this.imageUrl = b.imageUrl;
        this.groupIndex = b.groupIndex;
        this.sportVideos = b.sportVideos;
        this.videoDesc = b.videoDesc;
        this.videoUrl = b.videoUrl;
        this.videoCover = b.videoCover;
        this.sportResult = b.sportResult;
        this.sportSceneCode = b.sportSceneCode;
        this.sportScore = b.sportScore;
        this.sportSkuId = b.sportSkuId;
        this.sportSkuSubType = b.sportSkuSubType;
        this.sportTime = b.sportTime;
        this.sportUnitCode = b.sportUnitCode;
        this.originalSportResult = b.originalSportResult;
        this.sportViolationStatus = b.sportViolationStatus;
    }

    public static Builder builder(String accountId, String appCode, String appName, int invalidFlag, long sportCount, String sportStartTime, String sportEndTime, String sportResult, String sportSceneCode, String sportSkuId, String sportSkuSubType, long sportTime) {
        return new Builder(accountId, appCode, appName, invalidFlag, sportCount, sportStartTime, sportEndTime, sportResult, sportSceneCode, sportSkuId, sportSkuSubType, sportTime);
    }

    public static class Builder {
        private String accountId;
        private String appCode;
        private String appName;
        private int perfectCount;
        private int bravoCount;
        private int goodeviceount;
        private String extraJson;
        private String id;
        private int invalidFlag;
        private long sportCount;
        private String sportStartTime;
        private String sportEndTime;
        private List<Map<String, Object>> sportImages;
        private String imageDesc;
        private String imageUrl;
        private String groupIndex;
        private List<Map<String, Object>> sportVideos;
        private String videoDesc;
        private String videoUrl;
        private String videoCover;
        private String sportResult;
        private String sportSceneCode;
        private double sportScore;
        private String sportSkuId;
        private String sportSkuSubType;
        private long sportTime;
        private String sportUnitCode;
        private String originalSportResult;
        private int sportViolationStatus;

        Builder(String accountId, String appCode, String appName, int invalidFlag, long sportCount, String sportStartTime, String sportEndTime, String sportResult, String sportSceneCode, String sportSkuId, String sportSkuSubType, long sportTime) {
            this.accountId = accountId;
            this.appCode = appCode;
            this.appName = appName;
            this.invalidFlag = invalidFlag;
            this.sportCount = sportCount;
            this.sportStartTime = sportStartTime;
            this.sportEndTime = sportEndTime;
            this.sportResult = sportResult;
            this.sportSceneCode = sportSceneCode;
            this.sportSkuId = sportSkuId;
            this.sportSkuSubType = sportSkuSubType;
            this.sportTime = sportTime;
        }

        public Builder perfectCount(int v) { this.perfectCount = v; return this; }

        public Builder bravoCount(int v) { this.bravoCount = v; return this; }

        public Builder goodeviceount(int v) { this.goodeviceount = v; return this; }

        public Builder extraJson(String v) { this.extraJson = v; return this; }

        public Builder id(String v) { this.id = v; return this; }

        public Builder sportImages(List<Map<String, Object>> v) { this.sportImages = v; return this; }

        public Builder imageDesc(String v) { this.imageDesc = v; return this; }

        public Builder imageUrl(String v) { this.imageUrl = v; return this; }

        public Builder groupIndex(String v) { this.groupIndex = v; return this; }

        public Builder sportVideos(List<Map<String, Object>> v) { this.sportVideos = v; return this; }

        public Builder videoDesc(String v) { this.videoDesc = v; return this; }

        public Builder videoUrl(String v) { this.videoUrl = v; return this; }

        public Builder videoCover(String v) { this.videoCover = v; return this; }

        public Builder sportScore(double v) { this.sportScore = v; return this; }

        public Builder sportUnitCode(String v) { this.sportUnitCode = v; return this; }

        public Builder originalSportResult(String v) { this.originalSportResult = v; return this; }

        public Builder sportViolationStatus(int v) { this.sportViolationStatus = v; return this; }

        public ReportTeacherSportRequest build() { return new ReportTeacherSportRequest(this); }
    }

    public String getAccountId() { return accountId; }
    public String getAppCode() { return appCode; }
    public String getAppName() { return appName; }
    public int getPerfectCount() { return perfectCount; }
    public int getBravoCount() { return bravoCount; }
    public int getGoodeviceount() { return goodeviceount; }
    public String getExtraJson() { return extraJson; }
    public String getId() { return id; }
    public int getInvalidFlag() { return invalidFlag; }
    public long getSportCount() { return sportCount; }
    public String getSportStartTime() { return sportStartTime; }
    public String getSportEndTime() { return sportEndTime; }
    public List<Map<String, Object>> getSportImages() { return sportImages; }
    public String getImageDesc() { return imageDesc; }
    public String getImageUrl() { return imageUrl; }
    public String getGroupIndex() { return groupIndex; }
    public List<Map<String, Object>> getSportVideos() { return sportVideos; }
    public String getVideoDesc() { return videoDesc; }
    public String getVideoUrl() { return videoUrl; }
    public String getVideoCover() { return videoCover; }
    public String getSportResult() { return sportResult; }
    public String getSportSceneCode() { return sportSceneCode; }
    public double getSportScore() { return sportScore; }
    public String getSportSkuId() { return sportSkuId; }
    public String getSportSkuSubType() { return sportSkuSubType; }
    public long getSportTime() { return sportTime; }
    public String getSportUnitCode() { return sportUnitCode; }
    public String getOriginalSportResult() { return originalSportResult; }
    public int getSportViolationStatus() { return sportViolationStatus; }
}