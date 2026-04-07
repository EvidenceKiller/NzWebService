package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : ReportNfSportRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class ReportNfSportRequest {
    /** 记录标识码 */
    @SerializedName("id")
    private String id;

    /** 记录标识id */
    @SerializedName("recordId")
    private String recordId;

    /** 学年标识码 */
    @SerializedName("academicYearCode")
    private int academicYearCode;

    /** 用户标识码 */
    @SerializedName("accountId")
    private String accountId;

    /** 产品应用标识码 */
    @SerializedName("appCode")
    private String appCode;

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

    /** 赛事信息 */
    @SerializedName("competitionAthletics")
    private Object competitionAthletics;

    /** 赛事id */
    @SerializedName("competitionId")
    private String competitionId;

    /** 赛事名称 */
    @SerializedName("competitionName")
    private String competitionName;

    /** 赛事运动id */
    @SerializedName("competitionAthSportId")
    private String competitionAthSportId;

    /** 赛事运动名称 */
    @SerializedName("competitionAthSportName")
    private String competitionAthSportName;

    /** 打卡状态 */
    @SerializedName("competitionCheckStatus")
    private boolean competitionCheckStatus;

    /** 完成状态 */
    @SerializedName("competitionTaskStatus")
    private boolean competitionTaskStatus;

    /** 指标信息 */
    @SerializedName("sportIndicators")
    private List<Map<String, Object>> sportIndicators;

    /** 运动指标编码，索引列 */
    @SerializedName("indicatorsCode")
    private String indicatorsCode;

    /** 运动指标名称 */
    @SerializedName("indicatorsName")
    private String indicatorsName;

    /** 指标说明 */
    @SerializedName("indicatorsRemark")
    private String indicatorsRemark;

    /** 指标单位 */
    @SerializedName("indicatorsUnit")
    private String indicatorsUnit;

    /** 指标值 */
    @SerializedName("indicatorsValue")
    private String indicatorsValue;

    /** 运动图片 */
    @SerializedName("indicatorsImages")
    private List<Object> indicatorsImages;

    /** 运动视频 */
    @SerializedName("indicatorsVideos")
    private List<Object> indicatorsVideos;

    /** 竞技赛信息 */
    @SerializedName("sportMeet")
    private Object sportMeet;

    /** 运动会id */
    @SerializedName("meetId")
    private String meetId;

    /** 班级Id */
    @SerializedName("classId")
    private String classId;

    /** tis_competition_meet_type 1团体 2个人 */
    @SerializedName("meetGroupType")
    private int meetGroupType;

    /** 运动会运动员编码 */
    @SerializedName("meetNumberCode")
    private String meetNumberCode;

    /** 比赛轮次 */
    @SerializedName("meetRound")
    private int meetRound;

    /** 运动会跑道号 */
    @SerializedName("meetRunwayCode")
    private String meetRunwayCode;

    /** 运动会组别 */
    @SerializedName("meetTeamNo")
    private String meetTeamNo;

    /** 分组单位 学级_班级_性别 */
    @SerializedName("teamUnitCode")
    private String teamUnitCode;

    /** 运动结果同步标识 */
    @SerializedName("resultSyncFlag")
    private boolean resultSyncFlag;

    /** 运动会运动sku关系标识码 */
    @SerializedName("meetSportSkuId")
    private String meetSportSkuId;

    /** 序号 */
    @SerializedName("serialNumber")
    private String serialNumber;

    /** 组织测试信息 */
    @SerializedName("sportPlan")
    private Object sportPlan;

    /** 组织测试计划ID */
    @SerializedName("ptPlanId")
    private String ptPlanId;

    /** 组织测试标准ID */
    @SerializedName("ptStandardId")
    private String ptStandardId;

    /** 组织测试标准类型 */
    @SerializedName("ptStandardType")
    private String ptStandardType;

    /** 组织测试批次 */
    @SerializedName("ptBatch")
    private int ptBatch;

    /** 组织测试运动标准分 */
    @SerializedName("ptSportStandardScore")
    private String ptSportStandardScore;

    /** 组织测试运动标准等级 */
    @SerializedName("ptSportStandardLevel")
    private String ptSportStandardLevel;

    /** 组织测试运动单项得分 */
    @SerializedName("ptSportScore")
    private String ptSportScore;

    /** 组织测试运动单项附加分 */
    @SerializedName("ptSportStandardAddScore")
    private String ptSportStandardAddScore;

    /** 是否违规 */
    @SerializedName("sportViolationStatus")
    private int sportViolationStatus;

    /** 运动违规次数 */
    @SerializedName("sportViolationNumber")
    private int sportViolationNumber;

    /** 组织测试运动成绩加减结果 */
    @SerializedName("ptExtrasResult")
    private String ptExtrasResult;

    /** 组织测试运动成绩加减模式（+/-） */
    @SerializedName("ptExtrasResultMod")
    private String ptExtrasResultMod;

    /** 组织测试运动加减分数 */
    @SerializedName("ptExtrasScore")
    private String ptExtrasScore;

    /** 组织测试运动分数加减模式（+/-） */
    @SerializedName("ptExtrasScoreMod")
    private String ptExtrasScoreMod;

    /** 测试类型 0校方测试 1自助测试 */
    @SerializedName("ptTestType")
    private int ptTestType;

    /** 特训信息 */
    @SerializedName("trainPlan")
    private Object trainPlan;

    /** 特训计划id */
    @SerializedName("trainPlanId")
    private String trainPlanId;

    /** 特训计划名称 */
    @SerializedName("trainPlanName")
    private String trainPlanName;

    /** 特训计划运动id */
    @SerializedName("trainPlanSportId")
    private String trainPlanSportId;

    /** 特训计划运动名称 */
    @SerializedName("trainPlanSportName")
    private String trainPlanSportName;

    /** 记录有效标识位 */
    @SerializedName("invalidFlag")
    private int invalidFlag;

    /** 多人运动Id */
    @SerializedName("multiPersonId")
    private String multiPersonId;

    /** 多人运动排名 */
    @SerializedName("multiPersonRank")
    private int multiPersonRank;

    /** 多人运动机位排序 */
    @SerializedName("multiPersonIndex")
    private int multiPersonIndex;

    /** 原始运动结果 */
    @SerializedName("originalSportResult")
    private String originalSportResult;

    /** 场所id */
    @SerializedName("placeId")
    private String placeId;

    /** 场所名称 */
    @SerializedName("placeName")
    private String placeName;

    /** 学期标识码 */
    @SerializedName("semesterId")
    private String semesterId;

    /** 来源 0（正常来源） 1（平台手动录入） */
    @SerializedName("sourceType")
    private String sourceType;

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
    private int sportUnitCode;

    /** 是否违规不能为空 1:违规 */
    @SerializedName("sportViolationStatus")
    private int sportViolationStatus;

    private ReportNfSportRequest(Builder b) {
        this.id = b.id;
        this.recordId = b.recordId;
        this.academicYearCode = b.academicYearCode;
        this.accountId = b.accountId;
        this.appCode = b.appCode;
        this.perfectCount = b.perfectCount;
        this.bravoCount = b.bravoCount;
        this.goodeviceount = b.goodeviceount;
        this.extraJson = b.extraJson;
        this.competitionAthletics = b.competitionAthletics;
        this.competitionId = b.competitionId;
        this.competitionName = b.competitionName;
        this.competitionAthSportId = b.competitionAthSportId;
        this.competitionAthSportName = b.competitionAthSportName;
        this.competitionCheckStatus = b.competitionCheckStatus;
        this.competitionTaskStatus = b.competitionTaskStatus;
        this.sportIndicators = b.sportIndicators;
        this.indicatorsCode = b.indicatorsCode;
        this.indicatorsName = b.indicatorsName;
        this.indicatorsRemark = b.indicatorsRemark;
        this.indicatorsUnit = b.indicatorsUnit;
        this.indicatorsValue = b.indicatorsValue;
        this.indicatorsImages = b.indicatorsImages;
        this.indicatorsVideos = b.indicatorsVideos;
        this.sportMeet = b.sportMeet;
        this.meetId = b.meetId;
        this.classId = b.classId;
        this.meetGroupType = b.meetGroupType;
        this.meetNumberCode = b.meetNumberCode;
        this.meetRound = b.meetRound;
        this.meetRunwayCode = b.meetRunwayCode;
        this.meetTeamNo = b.meetTeamNo;
        this.teamUnitCode = b.teamUnitCode;
        this.resultSyncFlag = b.resultSyncFlag;
        this.meetSportSkuId = b.meetSportSkuId;
        this.serialNumber = b.serialNumber;
        this.sportPlan = b.sportPlan;
        this.ptPlanId = b.ptPlanId;
        this.ptStandardId = b.ptStandardId;
        this.ptStandardType = b.ptStandardType;
        this.ptBatch = b.ptBatch;
        this.ptSportStandardScore = b.ptSportStandardScore;
        this.ptSportStandardLevel = b.ptSportStandardLevel;
        this.ptSportScore = b.ptSportScore;
        this.ptSportStandardAddScore = b.ptSportStandardAddScore;
        this.sportViolationStatus = b.sportViolationStatus;
        this.sportViolationNumber = b.sportViolationNumber;
        this.ptExtrasResult = b.ptExtrasResult;
        this.ptExtrasResultMod = b.ptExtrasResultMod;
        this.ptExtrasScore = b.ptExtrasScore;
        this.ptExtrasScoreMod = b.ptExtrasScoreMod;
        this.ptTestType = b.ptTestType;
        this.trainPlan = b.trainPlan;
        this.trainPlanId = b.trainPlanId;
        this.trainPlanName = b.trainPlanName;
        this.trainPlanSportId = b.trainPlanSportId;
        this.trainPlanSportName = b.trainPlanSportName;
        this.invalidFlag = b.invalidFlag;
        this.multiPersonId = b.multiPersonId;
        this.multiPersonRank = b.multiPersonRank;
        this.multiPersonIndex = b.multiPersonIndex;
        this.originalSportResult = b.originalSportResult;
        this.placeId = b.placeId;
        this.placeName = b.placeName;
        this.semesterId = b.semesterId;
        this.sourceType = b.sourceType;
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
        this.sportViolationStatus = b.sportViolationStatus;
    }

    public static Builder builder(String accountId, String appCode, String indicatorsCode, String indicatorsName, String indicatorsRemark, String indicatorsValue, int invalidFlag, long sportCount, String sportStartTime, String sportEndTime, String sportResult, String sportSceneCode, String sportSkuId, String sportSkuSubType, long sportTime) {
        return new Builder(accountId, appCode, indicatorsCode, indicatorsName, indicatorsRemark, indicatorsValue, invalidFlag, sportCount, sportStartTime, sportEndTime, sportResult, sportSceneCode, sportSkuId, sportSkuSubType, sportTime);
    }

    public static class Builder {
        private String id;
        private String recordId;
        private int academicYearCode;
        private String accountId;
        private String appCode;
        private int perfectCount;
        private int bravoCount;
        private int goodeviceount;
        private String extraJson;
        private Object competitionAthletics;
        private String competitionId;
        private String competitionName;
        private String competitionAthSportId;
        private String competitionAthSportName;
        private boolean competitionCheckStatus;
        private boolean competitionTaskStatus;
        private List<Map<String, Object>> sportIndicators;
        private String indicatorsCode;
        private String indicatorsName;
        private String indicatorsRemark;
        private String indicatorsUnit;
        private String indicatorsValue;
        private List<Object> indicatorsImages;
        private List<Object> indicatorsVideos;
        private Object sportMeet;
        private String meetId;
        private String classId;
        private int meetGroupType;
        private String meetNumberCode;
        private int meetRound;
        private String meetRunwayCode;
        private String meetTeamNo;
        private String teamUnitCode;
        private boolean resultSyncFlag;
        private String meetSportSkuId;
        private String serialNumber;
        private Object sportPlan;
        private String ptPlanId;
        private String ptStandardId;
        private String ptStandardType;
        private int ptBatch;
        private String ptSportStandardScore;
        private String ptSportStandardLevel;
        private String ptSportScore;
        private String ptSportStandardAddScore;
        private int sportViolationStatus;
        private int sportViolationNumber;
        private String ptExtrasResult;
        private String ptExtrasResultMod;
        private String ptExtrasScore;
        private String ptExtrasScoreMod;
        private int ptTestType;
        private Object trainPlan;
        private String trainPlanId;
        private String trainPlanName;
        private String trainPlanSportId;
        private String trainPlanSportName;
        private int invalidFlag;
        private String multiPersonId;
        private int multiPersonRank;
        private int multiPersonIndex;
        private String originalSportResult;
        private String placeId;
        private String placeName;
        private String semesterId;
        private String sourceType;
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
        private int sportUnitCode;
        private int sportViolationStatus;

        Builder(String accountId, String appCode, String indicatorsCode, String indicatorsName, String indicatorsRemark, String indicatorsValue, int invalidFlag, long sportCount, String sportStartTime, String sportEndTime, String sportResult, String sportSceneCode, String sportSkuId, String sportSkuSubType, long sportTime) {
            this.accountId = accountId;
            this.appCode = appCode;
            this.indicatorsCode = indicatorsCode;
            this.indicatorsName = indicatorsName;
            this.indicatorsRemark = indicatorsRemark;
            this.indicatorsValue = indicatorsValue;
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

        public Builder id(String v) { this.id = v; return this; }

        public Builder recordId(String v) { this.recordId = v; return this; }

        public Builder academicYearCode(int v) { this.academicYearCode = v; return this; }

        public Builder perfectCount(int v) { this.perfectCount = v; return this; }

        public Builder bravoCount(int v) { this.bravoCount = v; return this; }

        public Builder goodeviceount(int v) { this.goodeviceount = v; return this; }

        public Builder extraJson(String v) { this.extraJson = v; return this; }

        public Builder competitionAthletics(Object v) { this.competitionAthletics = v; return this; }

        public Builder competitionId(String v) { this.competitionId = v; return this; }

        public Builder competitionName(String v) { this.competitionName = v; return this; }

        public Builder competitionAthSportId(String v) { this.competitionAthSportId = v; return this; }

        public Builder competitionAthSportName(String v) { this.competitionAthSportName = v; return this; }

        public Builder competitionCheckStatus(boolean v) { this.competitionCheckStatus = v; return this; }

        public Builder competitionTaskStatus(boolean v) { this.competitionTaskStatus = v; return this; }

        public Builder sportIndicators(List<Map<String, Object>> v) { this.sportIndicators = v; return this; }

        public Builder indicatorsUnit(String v) { this.indicatorsUnit = v; return this; }

        public Builder indicatorsImages(List<Object> v) { this.indicatorsImages = v; return this; }

        public Builder indicatorsVideos(List<Object> v) { this.indicatorsVideos = v; return this; }

        public Builder sportMeet(Object v) { this.sportMeet = v; return this; }

        public Builder meetId(String v) { this.meetId = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public Builder meetGroupType(int v) { this.meetGroupType = v; return this; }

        public Builder meetNumberCode(String v) { this.meetNumberCode = v; return this; }

        public Builder meetRound(int v) { this.meetRound = v; return this; }

        public Builder meetRunwayCode(String v) { this.meetRunwayCode = v; return this; }

        public Builder meetTeamNo(String v) { this.meetTeamNo = v; return this; }

        public Builder teamUnitCode(String v) { this.teamUnitCode = v; return this; }

        public Builder resultSyncFlag(boolean v) { this.resultSyncFlag = v; return this; }

        public Builder meetSportSkuId(String v) { this.meetSportSkuId = v; return this; }

        public Builder serialNumber(String v) { this.serialNumber = v; return this; }

        public Builder sportPlan(Object v) { this.sportPlan = v; return this; }

        public Builder ptPlanId(String v) { this.ptPlanId = v; return this; }

        public Builder ptStandardId(String v) { this.ptStandardId = v; return this; }

        public Builder ptStandardType(String v) { this.ptStandardType = v; return this; }

        public Builder ptBatch(int v) { this.ptBatch = v; return this; }

        public Builder ptSportStandardScore(String v) { this.ptSportStandardScore = v; return this; }

        public Builder ptSportStandardLevel(String v) { this.ptSportStandardLevel = v; return this; }

        public Builder ptSportScore(String v) { this.ptSportScore = v; return this; }

        public Builder ptSportStandardAddScore(String v) { this.ptSportStandardAddScore = v; return this; }

        public Builder sportViolationStatus(int v) { this.sportViolationStatus = v; return this; }

        public Builder sportViolationNumber(int v) { this.sportViolationNumber = v; return this; }

        public Builder ptExtrasResult(String v) { this.ptExtrasResult = v; return this; }

        public Builder ptExtrasResultMod(String v) { this.ptExtrasResultMod = v; return this; }

        public Builder ptExtrasScore(String v) { this.ptExtrasScore = v; return this; }

        public Builder ptExtrasScoreMod(String v) { this.ptExtrasScoreMod = v; return this; }

        public Builder ptTestType(int v) { this.ptTestType = v; return this; }

        public Builder trainPlan(Object v) { this.trainPlan = v; return this; }

        public Builder trainPlanId(String v) { this.trainPlanId = v; return this; }

        public Builder trainPlanName(String v) { this.trainPlanName = v; return this; }

        public Builder trainPlanSportId(String v) { this.trainPlanSportId = v; return this; }

        public Builder trainPlanSportName(String v) { this.trainPlanSportName = v; return this; }

        public Builder multiPersonId(String v) { this.multiPersonId = v; return this; }

        public Builder multiPersonRank(int v) { this.multiPersonRank = v; return this; }

        public Builder multiPersonIndex(int v) { this.multiPersonIndex = v; return this; }

        public Builder originalSportResult(String v) { this.originalSportResult = v; return this; }

        public Builder placeId(String v) { this.placeId = v; return this; }

        public Builder placeName(String v) { this.placeName = v; return this; }

        public Builder semesterId(String v) { this.semesterId = v; return this; }

        public Builder sourceType(String v) { this.sourceType = v; return this; }

        public Builder sportImages(List<Map<String, Object>> v) { this.sportImages = v; return this; }

        public Builder imageDesc(String v) { this.imageDesc = v; return this; }

        public Builder imageUrl(String v) { this.imageUrl = v; return this; }

        public Builder groupIndex(String v) { this.groupIndex = v; return this; }

        public Builder sportVideos(List<Map<String, Object>> v) { this.sportVideos = v; return this; }

        public Builder videoDesc(String v) { this.videoDesc = v; return this; }

        public Builder videoUrl(String v) { this.videoUrl = v; return this; }

        public Builder videoCover(String v) { this.videoCover = v; return this; }

        public Builder sportScore(double v) { this.sportScore = v; return this; }

        public Builder sportUnitCode(int v) { this.sportUnitCode = v; return this; }

        public Builder sportViolationStatus(int v) { this.sportViolationStatus = v; return this; }

        public ReportNfSportRequest build() { return new ReportNfSportRequest(this); }
    }

    public String getId() { return id; }
    public String getRecordId() { return recordId; }
    public int getAcademicYearCode() { return academicYearCode; }
    public String getAccountId() { return accountId; }
    public String getAppCode() { return appCode; }
    public int getPerfectCount() { return perfectCount; }
    public int getBravoCount() { return bravoCount; }
    public int getGoodeviceount() { return goodeviceount; }
    public String getExtraJson() { return extraJson; }
    public Object getCompetitionAthletics() { return competitionAthletics; }
    public String getCompetitionId() { return competitionId; }
    public String getCompetitionName() { return competitionName; }
    public String getCompetitionAthSportId() { return competitionAthSportId; }
    public String getCompetitionAthSportName() { return competitionAthSportName; }
    public boolean getCompetitionCheckStatus() { return competitionCheckStatus; }
    public boolean getCompetitionTaskStatus() { return competitionTaskStatus; }
    public List<Map<String, Object>> getSportIndicators() { return sportIndicators; }
    public String getIndicatorsCode() { return indicatorsCode; }
    public String getIndicatorsName() { return indicatorsName; }
    public String getIndicatorsRemark() { return indicatorsRemark; }
    public String getIndicatorsUnit() { return indicatorsUnit; }
    public String getIndicatorsValue() { return indicatorsValue; }
    public List<Object> getIndicatorsImages() { return indicatorsImages; }
    public List<Object> getIndicatorsVideos() { return indicatorsVideos; }
    public Object getSportMeet() { return sportMeet; }
    public String getMeetId() { return meetId; }
    public String getClassId() { return classId; }
    public int getMeetGroupType() { return meetGroupType; }
    public String getMeetNumberCode() { return meetNumberCode; }
    public int getMeetRound() { return meetRound; }
    public String getMeetRunwayCode() { return meetRunwayCode; }
    public String getMeetTeamNo() { return meetTeamNo; }
    public String getTeamUnitCode() { return teamUnitCode; }
    public boolean getResultSyncFlag() { return resultSyncFlag; }
    public String getMeetSportSkuId() { return meetSportSkuId; }
    public String getSerialNumber() { return serialNumber; }
    public Object getSportPlan() { return sportPlan; }
    public String getPtPlanId() { return ptPlanId; }
    public String getPtStandardId() { return ptStandardId; }
    public String getPtStandardType() { return ptStandardType; }
    public int getPtBatch() { return ptBatch; }
    public String getPtSportStandardScore() { return ptSportStandardScore; }
    public String getPtSportStandardLevel() { return ptSportStandardLevel; }
    public String getPtSportScore() { return ptSportScore; }
    public String getPtSportStandardAddScore() { return ptSportStandardAddScore; }
    public int getSportViolationStatus() { return sportViolationStatus; }
    public int getSportViolationNumber() { return sportViolationNumber; }
    public String getPtExtrasResult() { return ptExtrasResult; }
    public String getPtExtrasResultMod() { return ptExtrasResultMod; }
    public String getPtExtrasScore() { return ptExtrasScore; }
    public String getPtExtrasScoreMod() { return ptExtrasScoreMod; }
    public int getPtTestType() { return ptTestType; }
    public Object getTrainPlan() { return trainPlan; }
    public String getTrainPlanId() { return trainPlanId; }
    public String getTrainPlanName() { return trainPlanName; }
    public String getTrainPlanSportId() { return trainPlanSportId; }
    public String getTrainPlanSportName() { return trainPlanSportName; }
    public int getInvalidFlag() { return invalidFlag; }
    public String getMultiPersonId() { return multiPersonId; }
    public int getMultiPersonRank() { return multiPersonRank; }
    public int getMultiPersonIndex() { return multiPersonIndex; }
    public String getOriginalSportResult() { return originalSportResult; }
    public String getPlaceId() { return placeId; }
    public String getPlaceName() { return placeName; }
    public String getSemesterId() { return semesterId; }
    public String getSourceType() { return sourceType; }
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
    public int getSportUnitCode() { return sportUnitCode; }
    public int getSportViolationStatus() { return sportViolationStatus; }
}