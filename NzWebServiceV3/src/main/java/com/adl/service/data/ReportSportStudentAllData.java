package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class ReportSportStudentAllData implements Serializable {
    @SerializedName("id")
    private String id;

    //  用户账号id(非必须)
    @SerializedName("accountId")
    private String accountId;

    //  应用编码
    @SerializedName("appCode")
    private String appCode;

    //  运动场景代码
    @SerializedName("sportSceneCode")
    private String sportSceneCode;

    //  用户类型 0：游客 1：普通用户
    @SerializedName("accountType")
    private String accountType;

    //  设备id
    @SerializedName("deviceId")
    private String deviceId;

    //  记录有效标识位(非必须) 1：无效 0：有效
    @SerializedName("invalidFlag")
    private Integer invalidFlag = 0;

    //  运动sku编码，sku配置表
    @SerializedName("sportSkuId")
    private String sportSkuId;

    //  运动单位Code不能为空
    @SerializedName("sportUnit")
    private String sportUnit;

    //  运动结果不能为空
    @SerializedName("sportResult")
    private String sportResult;

    //  是否违规 0：正常 1：违规
    @SerializedName("sportViolationStatus")
    private Integer sportViolationStatus = 0;

    //  运动违规次数
    @SerializedName("sportViolationNumber")
    private String sportViolationNumber;

    //  运动次数(非必须)
    @SerializedName("sportCount")
    private String sportCount;

    //  运动得分(非必须)
    @SerializedName("sportScore")
    private String sportScore;

    //  运动等级(非必须)
    @SerializedName("sportLevel")
    private String sportLevel;

    //  运动时长，单位毫秒
    @SerializedName("sportTime")
    private String sportTime;

    //  运动测试时间，时间戳不能为空
    @SerializedName("sportTestTime")
    private String sportTestTime;

    //  运动开始时间，时间戳不能为空
    @SerializedName("sportStartTime")
    private String sportStartTime;

    //  运动结束时间，时间戳不能为空
    @SerializedName("sportEndTime")
    private String sportEndTime;

    //  多人运动Id
    @SerializedName("multiPersonId")
    private String multiPersonId;

    //  多人运动排名
    @SerializedName("multiPersonRank")
    private Integer multiPersonRank = 0;

    @SerializedName("multiPersonIndex")
    private Integer multiPersonIndex = 0;

    //  图片集
    @SerializedName("sportImages")
    private List<SportImageData> sportImages = new ArrayList<>();

    //  视频集
    @SerializedName("sportVideos")
    private List<SportVideoData> sportVideos = new ArrayList<>();

    //  赛事
    @SerializedName("competitionAthletics")
    private SportCompetitionData competitionAthletics = new SportCompetitionData();

    //  运动会
    @SerializedName("sportMeet")
    private SportMeetingData sportMeet = new SportMeetingData();

    //  组织测试
    @SerializedName("sportPlan")
    private SportPlanData sportPlan = new SportPlanData();

    //  特训训练计划
    @SerializedName("trainPlan")
    private SportTrainPlanData trainPlan = new SportTrainPlanData();

    @SerializedName("sportNatureCodes")
    private String sportNatureCodes;

    @SerializedName("sportTypeCode")
    private String sportTypeCode;

    //  运动指标集合
    @SerializedName("sportIndicators")
    private List<SportIndicatorsData<?, ?>> sportIndicators = new ArrayList<>();

    // 运动子项类型
    @SerializedName("sportSkuSubType")
    private String sportSkuSubType;

    @SerializedName("placeId")
    private String placeId;

    @SerializedName("placeName")
    private String placeName;

    @SerializedName("number")
    private Integer number = 0;

    @SerializedName("circle")
    private Integer circle = 0;

    @SerializedName("createTime")
    private Long createTime = 0L;

    @SerializedName("updateTime")
    private Long updateTime = 0L;

    @SerializedName("reportVersion")
    private String reportVersion;

    @SerializedName("reportCode")
    private String reportCode;

    public ReportSportStudentAllData(@NotNull String id) {
        this.id = id;
    }

    //  是否违规
    public boolean isViolation() {
        return sportViolationStatus == 1;
    }

    @Data
    @NoArgsConstructor
    public final static class SportCompetitionData implements Serializable {
        //  赛事id（赛事必传）
        @SerializedName("competitionId")
        private String competitionId;

        //  赛事名称（赛事必传）
        @SerializedName("competitionName")
        private String competitionName;

        //  赛事运动id（赛事必传）
        @SerializedName("competitionAthSportId")
        private String competitionAthSportId;

        //  赛事运动名称（赛事必传）
        @SerializedName("competitionAthSportName")
        private String competitionAthSportName;

        //  打卡状态
        @SerializedName("competitionCheckStatus")
        private Boolean competitionCheckStatus = Boolean.FALSE;

        //  完成状态
        @SerializedName("competitionTaskStatus")
        private Boolean competitionTaskStatus = Boolean.FALSE;
    }

    @Data
    @NoArgsConstructor
    public final static class SportMeetingData implements Serializable {
        //  班级Id【团体】
        @SerializedName("classId")
        private String classId;

        //  tis_competition_meet_type  1团体 2个人
        @SerializedName("meetGroupType")
        private String meetGroupType;

        //  运动会id
        @SerializedName("meetId")
        private String meetId;

        //  运动会运动员编码
        @SerializedName("meetNumberCode")
        private String meetNumberCode;

        //  比赛轮次
        @SerializedName("meetRound")
        private String meetRound;

        //  运动会跑道号
        @SerializedName("meetRunwayCode")
        private String meetRunwayCode;

        //  运动会运动sku关系标识码【关联运动会列表-skuList-id】
        @SerializedName("meetSportSkuId")
        private String meetSportSkuId;

        //  运动会组别
        @SerializedName("meetTeamNo")
        private String meetTeamNo;

        //  分组单位  学级_班级_性别
        @SerializedName("teamUnitCode")
        private String teamUnitCode;

        //  序号
        @SerializedName("serialNumber")
        private String serialNumber;
    }

    @Data
    @NoArgsConstructor
    public final static class SportPlanData implements Serializable {
        //  组织测试id（组织测试必传）
        @SerializedName("ptPlanId")
        private String ptPlanId;

        //  组织测试名称
        @SerializedName("ptPlanName")
        private String ptPlanName;

        //  组织测试批次（组织测试必传）
        @SerializedName("ptBatch")
        private String ptBatch;

        //  组织测试标准库id（组织测试必传）
        @SerializedName("ptStandardId")
        private String ptStandardId;

        @SerializedName("ptFlag")
        private String ptFlag;

        //  是否违规 0：正常 1：违规
        @SerializedName("sportViolationStatus")
        private Integer sportViolationStatus = 0;

        //  运动违规次数
        @SerializedName("sportViolationNumber")
        private String sportViolationNumber;

        //  组织测试测试类型 0：校方组织 1：自助测试
        @SerializedName("ptTestType")
        private Integer ptTestType = 0;
    }

    @Data
    @NoArgsConstructor
    public final static class SportTrainPlanData implements Serializable {
        @SerializedName("trainPlanId")
        private String trainPlanId;

        @SerializedName("trainPlanName")
        private String trainPlanName;

        @SerializedName("trainPlanSportId")
        private String trainPlanSportId;

        @SerializedName("trainPlanSportName")
        private String trainPlanSportName;
    }
}
