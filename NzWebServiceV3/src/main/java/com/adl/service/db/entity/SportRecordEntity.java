package com.adl.service.db.entity;

import com.adl.service.data.SportImageData;
import com.adl.service.data.SportIndicatorsData;
import com.adl.service.data.ReportSportStudentAllData;
import com.adl.service.data.SportVideoData;
import com.adl.service.db.converter.ListSportImageConverter;
import com.adl.service.db.converter.ListSportIndicatorsConverter;
import com.adl.service.db.converter.ListSportVideoConverter;
import com.adl.service.db.converter.RecordCompetitionConverter;
import com.adl.service.db.converter.RecordMeetingConverter;
import com.adl.service.db.converter.RecordPlanConverter;
import com.adl.service.db.converter.SportTrainPlanConverter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 运动记录
 */
@Entity(tableName = "_sport_record_upload")
@TypeConverters(value = {ListSportImageConverter.class, ListSportVideoConverter.class,
        RecordCompetitionConverter.class, RecordMeetingConverter.class,
        RecordPlanConverter.class, ListSportIndicatorsConverter.class,
        SportTrainPlanConverter.class})
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SportRecordEntity implements Serializable {
    //  记录id(雪花算法生成)
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "_id")
    private String id;
    //  用户账号id(非必须)
    @ColumnInfo(name = "_account_id")
    private String accountId;
    //  应用编码
    @ColumnInfo(name = "_app_code")
    private String appCode;
    //  运动场景代码
    @ColumnInfo(name = "_sport_scene_code")
    private String sportSceneCode;
    //  用户类型 0：游客 1：普通用户
    @ColumnInfo(name = "_account_type")
    private String accountType;
    //  设备id
    @ColumnInfo(name = "_device_id")
    private String deviceId;

    //  记录有效标识位(非必须) 1：无效 0：有效
    @ColumnInfo(name = "_invalid_flag")
    private Integer invalidFlag= 0;
    //  运动sku编码，sku配置表
    @ColumnInfo(name = "_sport_sku_id")
    private String sportSkuId;
    //  运动单位Code不能为空
    @ColumnInfo(name = "_sport_unit")
    private String sportUnit;

    //  运动结果不能为空
    @ColumnInfo(name = "_sport_result")
    private String sportResult;
    //  是否违规 0：正常 1：违规
    @ColumnInfo(name = "_sport_violation_status")
    private Integer sportViolationStatus= 0;
    //  运动违规次数
    @ColumnInfo(name = "_sport_violation_number")
    private String sportViolationNumber;
    //  运动次数(非必须)
    @ColumnInfo(name = "_sport_count")
    private String sportCount;
    //  运动得分(非必须)
    @ColumnInfo(name = "_sport_score")
    private String sportScore;
    //  运动等级(非必须)
    @ColumnInfo(name = "_sport_level")
    private String sportLevel;

    //  运动时长，单位毫秒
    @ColumnInfo(name = "_sport_time")
    private String sportTime;
    //  运动测试时间，时间戳不能为空
    @ColumnInfo(name = "_sport_test_time")
    private String sportTestTime;
    //  运动开始时间，时间戳不能为空
    @ColumnInfo(name = "_sport_start_time")
    private String sportStartTime;
    //  运动结束时间，时间戳不能为空
    @ColumnInfo(name = "_sport_end_time")
    private String sportEndTime;

    //  多人运动Id
    @ColumnInfo(name = "_multi_person_id")
    private String multiPersonId;
    //  多人运动排名
    @ColumnInfo(name = "_multi_person_rank")
    private Integer multiPersonRank= 0;

    @ColumnInfo(name = "_multi_person_index", defaultValue = "0")
    private Integer multiPersonIndex= 0;

    //  图片集
    @ColumnInfo(name = "_sport_images")
    private List<SportImageEntity> sportImages;
    //  视频集
    @ColumnInfo(name = "_sport_videos")
    private List<SportVideoEntity> sportVideos;

    //  赛事
    @ColumnInfo(name = "_sport_competition")
    private RecordCompetition competitionAthletics;
    //  运动会
    @ColumnInfo(name = "_sport_meet")
    private RecordMeeting sportMeet;
    //  组织测试
    @ColumnInfo(name = "_sport_plan")
    private RecordPlan sportPlan;
    //  特训训练计划
    @ColumnInfo(name = "_sport_train_plan", defaultValue = "")
    public SportTrainPlan trainPlan;

    @ColumnInfo(name = "_sport_nature_code", defaultValue = "")
    public String sportNatureCodes;

    @ColumnInfo(name = "_sport_type_code", defaultValue = "")
    public String sportTypeCode;

    //  运动指标集合
    @ColumnInfo(name = "_sport_indicators")
    private List<SportIndicatorsEntity<?, ?>> sportIndicators;

    // 运动子项类型
    @ColumnInfo(name = "_sport_sku_sub_type", defaultValue = "")
    private String sportSkuSubType;

    @ColumnInfo(name = "_place_id", defaultValue = "")
    private String placeId;

    @ColumnInfo(name = "_place_name", defaultValue = "")
    private String placeName;

    @ColumnInfo(name = "_number", defaultValue = "0")
    private Integer number= 0;

    @ColumnInfo(name = "_circle", defaultValue = "0")
    private Integer circle= 0;
    @ColumnInfo(name = "_create_time", defaultValue = "0")
    private Long createTime = 0L;
    @ColumnInfo(name = "_update_time", defaultValue = "0")
    private Long updateTime = 0L;

    @ColumnInfo(name = "_report_version", defaultValue = "")
    private String reportVersion;

    @ColumnInfo(name = "_report_code", defaultValue = "")
    private String reportCode;

    public SportRecordEntity() {
    }

    @Ignore
    public SportRecordEntity(@NotNull String id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getSportSceneCode() {
        return sportSceneCode;
    }

    public void setSportSceneCode(String sportSceneCode) {
        this.sportSceneCode = sportSceneCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getInvalidFlag() {
        return invalidFlag;
    }

    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }

    public String getSportSkuId() {
        return sportSkuId;
    }

    public void setSportSkuId(String sportSkuId) {
        this.sportSkuId = sportSkuId;
    }

    public String getSportResult() {
        return sportResult;
    }

    public void setSportResult(String sportResult) {
        this.sportResult = sportResult;
    }

    public Integer getSportViolationStatus() {
        return sportViolationStatus;
    }

    public void setSportViolationStatus(Integer sportViolationStatus) {
        this.sportViolationStatus = sportViolationStatus;
    }

    public String getSportViolationNumber() {
        return sportViolationNumber;
    }

    public void setSportViolationNumber(String sportViolationNumber) {
        this.sportViolationNumber = sportViolationNumber;
    }

    public String getSportUnit() {
        return sportUnit;
    }

    public void setSportUnit(String sportUnit) {
        this.sportUnit = sportUnit;
    }

    public String getSportCount() {
        return sportCount;
    }

    public void setSportCount(String sportCount) {
        this.sportCount = sportCount;
    }

    public String getSportScore() {
        return sportScore;
    }

    public void setSportScore(String sportScore) {
        this.sportScore = sportScore;
    }

    public String getSportLevel() {
        return sportLevel;
    }

    public void setSportLevel(String sportLevel) {
        this.sportLevel = sportLevel;
    }

    public String getSportTime() {
        return sportTime;
    }

    public void setSportTime(String sportTime) {
        this.sportTime = sportTime;
    }

    public String getSportTestTime() {
        return sportTestTime;
    }

    public void setSportTestTime(String sportTestTime) {
        this.sportTestTime = sportTestTime;
    }

    public String getSportStartTime() {
        return sportStartTime;
    }

    public void setSportStartTime(String sportStartTime) {
        this.sportStartTime = sportStartTime;
    }

    public String getSportEndTime() {
        return sportEndTime;
    }

    public void setSportEndTime(String sportEndTime) {
        this.sportEndTime = sportEndTime;
    }

    public String getMultiPersonId() {
        return multiPersonId;
    }

    public void setMultiPersonId(String multiPersonId) {
        this.multiPersonId = multiPersonId;
    }

    public Integer getMultiPersonRank() {
        return multiPersonRank;
    }

    public void setMultiPersonRank(Integer multiPersonRank) {
        this.multiPersonRank = multiPersonRank;
    }

    public Integer getMultiPersonIndex() {
        return multiPersonIndex;
    }

    public String getReportVersion() {
        return reportVersion;
    }

    public void setReportVersion(String reportVersion) {
        this.reportVersion = reportVersion;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public void setMultiPersonIndex(Integer multiPersonIndex) {
        this.multiPersonIndex = multiPersonIndex;
    }

    public List<SportImageEntity> getSportImages() {
        if (sportImages == null) {
            sportImages = new ArrayList<>();
        }
        return sportImages;
    }

    public void setSportImages(List<SportImageEntity> sportImages) {
        this.sportImages = sportImages;
    }

    public List<SportVideoEntity> getSportVideos() {
        if (sportVideos == null) {
            sportVideos = new ArrayList<>();
        }
        return sportVideos;
    }

    public void setSportVideos(List<SportVideoEntity> sportVideos) {
        this.sportVideos = sportVideos;
    }

    public RecordCompetition getCompetitionAthletics() {
        return competitionAthletics;
    }

    public void setCompetitionAthletics(RecordCompetition competitionAthletics) {
        this.competitionAthletics = competitionAthletics;
    }

    public RecordMeeting getSportMeet() {
        if (sportMeet == null) {
            sportMeet = new RecordMeeting();
        }
        return sportMeet;
    }

    public void setSportMeet(RecordMeeting sportMeet) {
        this.sportMeet = sportMeet;
    }

    public RecordPlan getSportPlan() {
        if (sportPlan == null) {
            sportPlan = new RecordPlan();
        }
        return sportPlan;
    }

    public void setSportPlan(RecordPlan sportPlan) {
        this.sportPlan = sportPlan;
    }

    public String getSportNatureCodes() {
        return sportNatureCodes;
    }

    public void setSportNatureCodes(String sportNatureCodes) {
        this.sportNatureCodes = sportNatureCodes;
    }

    public String getSportTypeCode() {
        return sportTypeCode;
    }

    public void setSportTypeCode(String sportTypeCode) {
        this.sportTypeCode = sportTypeCode;
    }

    public SportTrainPlan getTrainPlan() {
        if (trainPlan == null) {
            trainPlan = new SportTrainPlan();
        }
        return trainPlan;
    }

    public void setTrainPlan(SportTrainPlan trainPlan) {
        this.trainPlan = trainPlan;
    }

    public String getSportSkuSubType() {
        return sportSkuSubType;
    }

    public void setSportSkuSubType(String sportSkuSubType) {
        this.sportSkuSubType = sportSkuSubType;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public List<SportIndicatorsEntity<?, ?>> getSportIndicators() {
        if (sportIndicators == null) {
            sportIndicators = new ArrayList<>();
        }
        return sportIndicators;
    }

    public void setSportIndicators(List<SportIndicatorsEntity<?, ?>> sportIndicators) {
        this.sportIndicators = sportIndicators;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCircle() {
        return circle;
    }

    public void setCircle(Integer circle) {
        this.circle = circle;
    }


    //  是否违规
    public Boolean isViolation() {
        return sportViolationStatus == 1;
    }

    public static class RecordCompetition implements Serializable {
        //  赛事id（赛事必传）
        private String competitionId;
        //  赛事名称（赛事必传）
        private String competitionName;
        //  赛事运动id（赛事必传）
        private String competitionAthSportId;
        //  赛事运动名称（赛事必传）
        private String competitionAthSportName;
        //  打卡状态
        private Boolean competitionCheckStatus= Boolean.FALSE;
        //  完成状态
        private Boolean competitionTaskStatus= Boolean.FALSE;

        public String getCompetitionId() {
            return competitionId;
        }

        public void setCompetitionId(String competitionId) {
            this.competitionId = competitionId;
        }

        public String getCompetitionName() {
            return competitionName;
        }

        public void setCompetitionName(String competitionName) {
            this.competitionName = competitionName;
        }

        public String getCompetitionAthSportId() {
            return competitionAthSportId;
        }

        public void setCompetitionAthSportId(String competitionAthSportId) {
            this.competitionAthSportId = competitionAthSportId;
        }

        public String getCompetitionAthSportName() {
            return competitionAthSportName;
        }

        public void setCompetitionAthSportName(String competitionAthSportName) {
            this.competitionAthSportName = competitionAthSportName;
        }

        public Boolean isCompetitionCheckStatus() {
            return competitionCheckStatus;
        }

        public void setCompetitionCheckStatus(Boolean competitionCheckStatus) {
            this.competitionCheckStatus = competitionCheckStatus;
        }

        public Boolean isCompetitionTaskStatus() {
            return competitionTaskStatus;
        }

        public void setCompetitionTaskStatus(Boolean competitionTaskStatus) {
            this.competitionTaskStatus = competitionTaskStatus;
        }
    }

    public static class RecordMeeting implements Serializable {
        //  班级Id【团体】
        private String classId;
        //  tis_competition_meet_type  1团体 2个人
        private String meetGroupType;
        //  运动会id
        private String meetId;
        //  运动会运动员编码
        private String meetNumberCode;
        //  比赛轮次
        private String meetRound;
        //  运动会跑道号
        private String meetRunwayCode;
        //  运动会运动sku关系标识码【关联运动会列表-skuList-id】
        private String meetSportSkuId;
        //  运动会组别
        private String meetTeamNo;
        //  分组单位  学级_班级_性别
        private String teamUnitCode;
        //  序号
        private String serialNumber;

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public String getMeetGroupType() {
            return meetGroupType;
        }

        public void setMeetGroupType(String meetGroupType) {
            this.meetGroupType = meetGroupType;
        }

        public String getMeetId() {
            return meetId;
        }

        public void setMeetId(String meetId) {
            this.meetId = meetId;
        }

        public String getMeetNumberCode() {
            return meetNumberCode;
        }

        public void setMeetNumberCode(String meetNumberCode) {
            this.meetNumberCode = meetNumberCode;
        }

        public String getMeetRound() {
            return meetRound;
        }

        public void setMeetRound(String meetRound) {
            this.meetRound = meetRound;
        }

        public String getMeetRunwayCode() {
            return meetRunwayCode;
        }

        public void setMeetRunwayCode(String meetRunwayCode) {
            this.meetRunwayCode = meetRunwayCode;
        }

        public String getMeetSportSkuId() {
            return meetSportSkuId;
        }

        public void setMeetSportSkuId(String meetSportSkuId) {
            this.meetSportSkuId = meetSportSkuId;
        }

        public String getMeetTeamNo() {
            return meetTeamNo;
        }

        public void setMeetTeamNo(String meetTeamNo) {
            this.meetTeamNo = meetTeamNo;
        }

        public String getTeamUnitCode() {
            return teamUnitCode;
        }

        public void setTeamUnitCode(String teamUnitCode) {
            this.teamUnitCode = teamUnitCode;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }
    }

    public static class RecordPlan implements Serializable {
        //  组织测试id（组织测试必传）
        private String ptPlanId;
        //  组织测试批次（组织测试必传）
        private String ptBatch;
        //  组织测试标准库id（组织测试必传）
        private String ptStandardId;
        //  组织测试标准得分（组织测试必传）
//        private String ptSportStandardScore;
        private String ptFlag;
        //  是否违规 0：正常 1：违规
        private Integer sportViolationStatus= 0;
        //  运动违规次数
        private String sportViolationNumber;
        //  组织测试测试类型 0：校方组织 1：自助测试
        private Integer ptTestType= 0;
        private String ptPlanName;

        public String getPtPlanName() {
            return ptPlanName;
        }

        public void setPtPlanName(String ptPlanName) {
            this.ptPlanName = ptPlanName;
        }

        public String getPtPlanId() {
            return ptPlanId;
        }

        public void setPtPlanId(String ptPlanId) {
            this.ptPlanId = ptPlanId;
        }

        public String getPtBatch() {
            return ptBatch;
        }

        public void setPtBatch(String ptBatch) {
            this.ptBatch = ptBatch;
        }

        public String getPtStandardId() {
            return ptStandardId;
        }

        public void setPtStandardId(String ptStandardId) {
            this.ptStandardId = ptStandardId;
        }

//        public String getPtSportStandardScore() {
//            return ptSportStandardScore;
//        }
//
//        public void setPtSportStandardScore(String ptSportStandardScore) {
//            this.ptSportStandardScore = ptSportStandardScore;
//        }

        public String getPtFlag() {
            return ptFlag;
        }

        public void setPtFlag(String ptFlag) {
            this.ptFlag = ptFlag;
        }

        public Integer getSportViolationStatus() {
            return sportViolationStatus;
        }

        public void setSportViolationStatus(Integer sportViolationStatus) {
            this.sportViolationStatus = sportViolationStatus;
        }

        public String getSportViolationNumber() {
            return sportViolationNumber;
        }

        public void setSportViolationNumber(String sportViolationNumber) {
            this.sportViolationNumber = sportViolationNumber;
        }

        public Integer getPtTestType() {
            return ptTestType;
        }

        public void setPtTestType(Integer ptTestType) {
            this.ptTestType = ptTestType;
        }
    }

    public static class SportTrainPlan implements Serializable {
        private String trainPlanId;
        private String trainPlanName;
        private String trainPlanSportId;
        private String trainPlanSportName;

        public String getTrainPlanId() {
            return trainPlanId;
        }

        public void setTrainPlanId(String trainPlanId) {
            this.trainPlanId = trainPlanId;
        }

        public String getTrainPlanName() {
            return trainPlanName;
        }

        public void setTrainPlanName(String trainPlanName) {
            this.trainPlanName = trainPlanName;
        }

        public String getTrainPlanSportId() {
            return trainPlanSportId;
        }

        public void setTrainPlanSportId(String trainPlanSportId) {
            this.trainPlanSportId = trainPlanSportId;
        }

        public String getTrainPlanSportName() {
            return trainPlanSportName;
        }

        public void setTrainPlanSportName(String trainPlanSportName) {
            this.trainPlanSportName = trainPlanSportName;
        }
    }

    public static ReportSportStudentAllData convertToData(SportRecordEntity entity) {
        if (entity == null) {
            return null;
        }
        ReportSportStudentAllData data = new ReportSportStudentAllData();
        data.setId(entity.getId());
        data.setAccountId(entity.getAccountId());
        data.setAppCode(entity.getAppCode());
        data.setSportSceneCode(entity.getSportSceneCode());
        data.setAccountType(entity.getAccountType());
        data.setDeviceId(entity.getDeviceId());
        data.setInvalidFlag(entity.getInvalidFlag());
        data.setSportSkuId(entity.getSportSkuId());
        data.setSportUnit(entity.getSportUnit());
        data.setSportResult(entity.getSportResult());
        data.setSportViolationStatus(entity.getSportViolationStatus());
        data.setSportViolationNumber(entity.getSportViolationNumber());
        data.setSportCount(entity.getSportCount());
        data.setSportScore(entity.getSportScore());
        data.setSportLevel(entity.getSportLevel());
        data.setSportTime(entity.getSportTime());
        data.setSportTestTime(entity.getSportTestTime());
        data.setSportStartTime(entity.getSportStartTime());
        data.setSportEndTime(entity.getSportEndTime());
        data.setMultiPersonId(entity.getMultiPersonId());
        data.setMultiPersonRank(entity.getMultiPersonRank());
        data.setMultiPersonIndex(entity.getMultiPersonIndex());
        data.setSportNatureCodes(entity.getSportNatureCodes());
        data.setSportTypeCode(entity.getSportTypeCode());
        data.setSportSkuSubType(entity.getSportSkuSubType());
        data.setPlaceId(entity.getPlaceId());
        data.setPlaceName(entity.getPlaceName());
        data.setNumber(entity.getNumber());
        data.setCircle(entity.getCircle());
        data.setCreateTime(entity.getCreateTime());
        data.setUpdateTime(entity.getUpdateTime());
        data.setReportVersion(entity.getReportVersion());
        data.setReportCode(entity.getReportCode());
        // sportImages
        List<SportImageData> imageDataList = new ArrayList<>();
        if (entity.getSportImages() != null) {
            for (SportImageEntity imageEntity : entity.getSportImages()) {
                if (imageEntity == null) continue;
                SportImageData imageData = new SportImageData();
                imageData.setImageUrl(imageEntity.getImageUrl());
                imageData.setImageDesc(imageEntity.getImageDesc());
                imageData.setMotionAnalysisImageDesc(imageEntity.getMotionAnalysisImageDesc());
                imageData.setGroupIndex(imageEntity.getGroupIndex());
                imageDataList.add(imageData);
            }
        }
        data.setSportImages(imageDataList);
        // sportVideos
        List<SportVideoData> videoDataList = new ArrayList<>();
        if (entity.getSportVideos() != null) {
            for (SportVideoEntity videoEntity : entity.getSportVideos()) {
                if (videoEntity == null) continue;
                SportVideoData videoData = new SportVideoData();
                videoData.setVideoUrl(videoEntity.getVideoUrl());
                videoData.setVideoCover(videoEntity.getVideoCover());
                videoData.setVideoDesc(videoEntity.getVideoDesc());
                videoDataList.add(videoData);
            }
        }
        data.setSportVideos(videoDataList);
        // sportIndicators
        List<SportIndicatorsData<?, ?>> indicatorsDataList = new ArrayList<>();
        if (entity.getSportIndicators() != null) {
            for (SportIndicatorsEntity<?, ?> indicatorEntity : entity.getSportIndicators()) {
                if (indicatorEntity == null) continue;
                SportIndicatorsData<Object, Object> indicatorData = new SportIndicatorsData<>();
                indicatorData.setIndicatorsCode(indicatorEntity.getIndicatorsCode());
                indicatorData.setIndicatorsName(indicatorEntity.getIndicatorsName());
                indicatorData.setIndicatorsValue(indicatorEntity.getIndicatorsValue());
                indicatorData.setIndicatorsRemark(indicatorEntity.getIndicatorsRemark());
                indicatorData.setIndicatorsUnit(indicatorEntity.getIndicatorsUnit());
                List<SportImageData> indicatorImages = new ArrayList<>();
                if (indicatorEntity.getIndicatorsImages() != null) {
                    for (SportImageEntity img : indicatorEntity.getIndicatorsImages()) {
                        if (img == null) continue;
                        SportImageData imageData = new SportImageData();
                        imageData.setImageUrl(img.getImageUrl());
                        imageData.setImageDesc(img.getImageDesc());
                        imageData.setMotionAnalysisImageDesc(img.getMotionAnalysisImageDesc());
                        imageData.setGroupIndex(img.getGroupIndex());
                        indicatorImages.add(imageData);
                    }
                }
                indicatorData.setIndicatorsImages(indicatorImages);
                List<SportVideoData> indicatorVideos = new ArrayList<>();
                if (indicatorEntity.getIndicatorsVideos() != null) {
                    for (SportVideoEntity vid : indicatorEntity.getIndicatorsVideos()) {
                        if (vid == null) continue;
                        SportVideoData videoData = new SportVideoData();
                        videoData.setVideoUrl(vid.getVideoUrl());
                        videoData.setVideoCover(vid.getVideoCover());
                        videoData.setVideoDesc(vid.getVideoDesc());
                        indicatorVideos.add(videoData);
                    }
                }
                indicatorData.setIndicatorsVideos(indicatorVideos);
                indicatorsDataList.add(indicatorData);
            }
        }
        data.setSportIndicators(indicatorsDataList);
        // competitionAthletics
        if (entity.getCompetitionAthletics() != null) {
            ReportSportStudentAllData.SportCompetitionData c = new ReportSportStudentAllData.SportCompetitionData();
            c.setCompetitionId(entity.getCompetitionAthletics().getCompetitionId());
            c.setCompetitionName(entity.getCompetitionAthletics().getCompetitionName());
            c.setCompetitionAthSportId(entity.getCompetitionAthletics().getCompetitionAthSportId());
            c.setCompetitionAthSportName(entity.getCompetitionAthletics().getCompetitionAthSportName());
            c.setCompetitionCheckStatus(entity.getCompetitionAthletics().isCompetitionCheckStatus());
            c.setCompetitionTaskStatus(entity.getCompetitionAthletics().isCompetitionTaskStatus());
            data.setCompetitionAthletics(c);
        }
        // sportMeet
        if (entity.getSportMeet() != null) {
            ReportSportStudentAllData.SportMeetingData m = new ReportSportStudentAllData.SportMeetingData();
            m.setClassId(entity.getSportMeet().getClassId());
            m.setMeetGroupType(entity.getSportMeet().getMeetGroupType());
            m.setMeetId(entity.getSportMeet().getMeetId());
            m.setMeetNumberCode(entity.getSportMeet().getMeetNumberCode());
            m.setMeetRound(entity.getSportMeet().getMeetRound());
            m.setMeetRunwayCode(entity.getSportMeet().getMeetRunwayCode());
            m.setMeetSportSkuId(entity.getSportMeet().getMeetSportSkuId());
            m.setMeetTeamNo(entity.getSportMeet().getMeetTeamNo());
            m.setTeamUnitCode(entity.getSportMeet().getTeamUnitCode());
            m.setSerialNumber(entity.getSportMeet().getSerialNumber());
            data.setSportMeet(m);
        }
        // sportPlan
        if (entity.getSportPlan() != null) {
            ReportSportStudentAllData.SportPlanData p = new ReportSportStudentAllData.SportPlanData();
            p.setPtPlanId(entity.getSportPlan().getPtPlanId());
            p.setPtPlanName(entity.getSportPlan().getPtPlanName());
            p.setPtBatch(entity.getSportPlan().getPtBatch());
            p.setPtStandardId(entity.getSportPlan().getPtStandardId());
            p.setPtFlag(entity.getSportPlan().getPtFlag());
            p.setSportViolationStatus(entity.getSportPlan().getSportViolationStatus());
            p.setSportViolationNumber(entity.getSportPlan().getSportViolationNumber());
            p.setPtTestType(entity.getSportPlan().getPtTestType());
            data.setSportPlan(p);
        }
        // trainPlan
        if (entity.getTrainPlan() != null) {
            ReportSportStudentAllData.SportTrainPlanData t = new ReportSportStudentAllData.SportTrainPlanData();
            t.setTrainPlanId(entity.getTrainPlan().getTrainPlanId());
            t.setTrainPlanName(entity.getTrainPlan().getTrainPlanName());
            t.setTrainPlanSportId(entity.getTrainPlan().getTrainPlanSportId());
            t.setTrainPlanSportName(entity.getTrainPlan().getTrainPlanSportName());
            data.setTrainPlan(t);
        }
        return data;
    }

    public static SportRecordEntity convertToEntity(ReportSportStudentAllData data) {
        if (data == null) {
            return null;
        }

        SportRecordEntity entity = new SportRecordEntity();
        // 基础字段
        entity.setId(data.getId());
        entity.setAccountId(data.getAccountId());
        entity.setAppCode(data.getAppCode());
        entity.setSportSceneCode(data.getSportSceneCode());
        entity.setAccountType(data.getAccountType());
        entity.setDeviceId(data.getDeviceId());
        entity.setInvalidFlag(data.getInvalidFlag() == null ? 0 : data.getInvalidFlag());
        entity.setSportSkuId(data.getSportSkuId());
        entity.setSportUnit(data.getSportUnit());
        entity.setSportResult(data.getSportResult());
        entity.setSportViolationStatus(data.getSportViolationStatus() == null ? 0 : data.getSportViolationStatus());
        entity.setSportViolationNumber(data.getSportViolationNumber());
        entity.setSportCount(data.getSportCount());
        entity.setSportScore(data.getSportScore());
        entity.setSportLevel(data.getSportLevel());
        entity.setSportTime(data.getSportTime());
        entity.setSportTestTime(data.getSportTestTime());
        entity.setSportStartTime(data.getSportStartTime());
        entity.setSportEndTime(data.getSportEndTime());
        entity.setMultiPersonId(data.getMultiPersonId());
        entity.setMultiPersonRank(data.getMultiPersonRank() == null ? 0 : data.getMultiPersonRank());
        entity.setMultiPersonIndex(data.getMultiPersonIndex() == null ? 0 : data.getMultiPersonIndex());
        entity.setSportNatureCodes(data.getSportNatureCodes());
        entity.setSportTypeCode(data.getSportTypeCode());
        entity.setSportSkuSubType(data.getSportSkuSubType());
        entity.setPlaceId(data.getPlaceId());
        entity.setPlaceName(data.getPlaceName());
        entity.setNumber(data.getNumber() == null ? 0 : data.getNumber());
        entity.setCircle(data.getCircle() == null ? 0 : data.getCircle());
        entity.setCreateTime(data.getCreateTime());
        entity.setUpdateTime(data.getUpdateTime());
        entity.setReportVersion(data.getReportVersion());
        entity.setReportCode(data.getReportCode());
        // 图片
        List<SportImageEntity> imageEntities = new ArrayList<>();
        if (data.getSportImages() != null) {
            for (SportImageData imageData : data.getSportImages()) {
                if (imageData == null) continue;
                SportImageEntity imageEntity = new SportImageEntity();
                imageEntity.setImageUrl(imageData.getImageUrl());
                imageEntity.setImageDesc(imageData.getImageDesc());
                imageEntity.setMotionAnalysisImageDesc(imageData.getMotionAnalysisImageDesc());
                imageEntity.setGroupIndex(imageData.getGroupIndex());
                imageEntities.add(imageEntity);
            }
        }
        entity.setSportImages(imageEntities);
        // 视频
        List<SportVideoEntity> videoEntities = new ArrayList<>();
        if (data.getSportVideos() != null) {
            for (SportVideoData videoData : data.getSportVideos()) {
                if (videoData == null) continue;
                SportVideoEntity videoEntity = new SportVideoEntity();
                videoEntity.setVideoUrl(videoData.getVideoUrl());
                videoEntity.setVideoCover(videoData.getVideoCover());
                videoEntity.setVideoDesc(videoData.getVideoDesc());
                videoEntities.add(videoEntity);
            }
        }
        entity.setSportVideos(videoEntities);
        // 指标
        List<SportIndicatorsEntity<?, ?>> indicatorEntities = new ArrayList<>();
        if (data.getSportIndicators() != null) {
            for (SportIndicatorsData<?, ?> indicatorData : data.getSportIndicators()) {
                if (indicatorData == null) continue;
                SportIndicatorsEntity<Object, Object> indicatorEntity = new SportIndicatorsEntity<>();
                indicatorEntity.setIndicatorsCode(indicatorData.getIndicatorsCode());
                indicatorEntity.setIndicatorsName(indicatorData.getIndicatorsName());
                indicatorEntity.setIndicatorsValue(indicatorData.getIndicatorsValue());
                indicatorEntity.setIndicatorsRemark(indicatorData.getIndicatorsRemark());
                indicatorEntity.setIndicatorsUnit(indicatorData.getIndicatorsUnit());
                List<SportImageEntity> indicatorImages = new ArrayList<>();
                if (indicatorData.getIndicatorsImages() != null) {
                    for (SportImageData imgData : indicatorData.getIndicatorsImages()) {
                        if (imgData == null) continue;
                        SportImageEntity imgEntity = new SportImageEntity();
                        imgEntity.setImageUrl(imgData.getImageUrl());
                        imgEntity.setImageDesc(imgData.getImageDesc());
                        imgEntity.setMotionAnalysisImageDesc(imgData.getMotionAnalysisImageDesc());
                        imgEntity.setGroupIndex(imgData.getGroupIndex());
                        indicatorImages.add(imgEntity);
                    }
                }
                indicatorEntity.setIndicatorsImages(indicatorImages);
                List<SportVideoEntity> indicatorVideos = new ArrayList<>();
                if (indicatorData.getIndicatorsVideos() != null) {
                    for (SportVideoData vidData : indicatorData.getIndicatorsVideos()) {
                        if (vidData == null) continue;
                        SportVideoEntity vidEntity = new SportVideoEntity();
                        vidEntity.setVideoUrl(vidData.getVideoUrl());
                        vidEntity.setVideoCover(vidData.getVideoCover());
                        vidEntity.setVideoDesc(vidData.getVideoDesc());
                        indicatorVideos.add(vidEntity);
                    }
                }
                indicatorEntity.setIndicatorsVideos(indicatorVideos);
                indicatorEntities.add(indicatorEntity);
            }
        }
        entity.setSportIndicators(indicatorEntities);
        // 赛事
        if (data.getCompetitionAthletics() != null) {
            RecordCompetition c = new RecordCompetition();
            c.setCompetitionId(data.getCompetitionAthletics().getCompetitionId());
            c.setCompetitionName(data.getCompetitionAthletics().getCompetitionName());
            c.setCompetitionAthSportId(data.getCompetitionAthletics().getCompetitionAthSportId());
            c.setCompetitionAthSportName(data.getCompetitionAthletics().getCompetitionAthSportName());
            c.setCompetitionCheckStatus(Boolean.TRUE.equals(data.getCompetitionAthletics().getCompetitionCheckStatus()));
            c.setCompetitionTaskStatus(Boolean.TRUE.equals(data.getCompetitionAthletics().getCompetitionTaskStatus()));
            entity.setCompetitionAthletics(c);
        }
        // 运动会
        if (data.getSportMeet() != null) {
            RecordMeeting m = new RecordMeeting();
            m.setClassId(data.getSportMeet().getClassId());
            m.setMeetGroupType(data.getSportMeet().getMeetGroupType());
            m.setMeetId(data.getSportMeet().getMeetId());
            m.setMeetNumberCode(data.getSportMeet().getMeetNumberCode());
            m.setMeetRound(data.getSportMeet().getMeetRound());
            m.setMeetRunwayCode(data.getSportMeet().getMeetRunwayCode());
            m.setMeetSportSkuId(data.getSportMeet().getMeetSportSkuId());
            m.setMeetTeamNo(data.getSportMeet().getMeetTeamNo());
            m.setTeamUnitCode(data.getSportMeet().getTeamUnitCode());
            m.setSerialNumber(data.getSportMeet().getSerialNumber());
            entity.setSportMeet(m);
        }
        // 组织测试
        if (data.getSportPlan() != null) {
            RecordPlan p = new RecordPlan();
            p.setPtPlanId(data.getSportPlan().getPtPlanId());
            p.setPtPlanName(data.getSportPlan().getPtPlanName());
            p.setPtBatch(data.getSportPlan().getPtBatch());
            p.setPtStandardId(data.getSportPlan().getPtStandardId());
            p.setPtFlag(data.getSportPlan().getPtFlag());
            p.setSportViolationStatus(data.getSportPlan().getSportViolationStatus() == null ? 0 : data.getSportPlan().getSportViolationStatus());
            p.setSportViolationNumber(data.getSportPlan().getSportViolationNumber());
            p.setPtTestType(data.getSportPlan().getPtTestType() == null ? 0 : data.getSportPlan().getPtTestType());
            entity.setSportPlan(p);
        }
        // 训练计划
        if (data.getTrainPlan() != null) {
            SportTrainPlan t = new SportTrainPlan();
            t.setTrainPlanId(data.getTrainPlan().getTrainPlanId());
            t.setTrainPlanName(data.getTrainPlan().getTrainPlanName());
            t.setTrainPlanSportId(data.getTrainPlan().getTrainPlanSportId());
            t.setTrainPlanSportName(data.getTrainPlan().getTrainPlanSportName());
            entity.setTrainPlan(t);
        }
        return entity;
    }
}
