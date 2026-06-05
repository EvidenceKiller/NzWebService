package com.adl.service.db.entity;

import com.adl.service.data.ReportSportTeacherData;
import com.adl.service.utils.InnerUtil;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * hhd
 * 2025/4/22
 */
@Entity(tableName = "_teacher_sport_local")
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class TeacherSportLocalEntity implements Serializable {

    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "_id")
    private String id;

    @ColumnInfo(name = "_account_id")

    private String accountId;

    @ColumnInfo(name = "_belong_id")
    private String belongId;
    @ColumnInfo(name = "_app_code")
    private String appCode;
    @ColumnInfo(name = "_app_name")
    private String appName;

    @ColumnInfo(name = "_account_name")
    private String accountName;
    @ColumnInfo(name = "_perfect_count")
    private Integer perfectCount= 0;
    @ColumnInfo(name = "_bravo_count")
    private Integer bravoCount= 0;
    @ColumnInfo(name = "_extra_json")
    private String extraJson;
    @ColumnInfo(name = "_good_count")
    private Integer goodCount= 0;
    @ColumnInfo(name = "_sport_end_time")
    private String sportEndTime;

    @ColumnInfo(name = "_sport_start_time")
    private String sportStartTime;

    @ColumnInfo(name = "_sport_sku_id")
    private String sportSkuId;

    @ColumnInfo(name = "_sport_sku_sub_type")
    private String sportSkuSubType;

    @ColumnInfo(name = "_sport_status")
    private Long sportTime= 0L;

    @ColumnInfo(name = "_sport_count")
    private Long sportCount= 0L;

    @ColumnInfo(name = "_sport_score")
    private Double sportScore= 0.0;

    @ColumnInfo(name = "_sport_result")
    private String sportResult;

    @ColumnInfo(name = "_sport_violation_status")
    private Integer sportViolationStatus= 0;

    @ColumnInfo(name = "_sport_scene_code")
    private String sportSceneCode;

    //  业务数据状态:0（未上传）、1（已上传）、2（上传失败，后续不再上传）
    @ColumnInfo(name = "_upload_data_status")
    private Integer uploadDataStatus= 0;

    //  修改状态:0（未修改）、1（修改）
    @ColumnInfo(name = "_upload_modify_status", defaultValue = "0")
    private Integer uploadModifyStatus= 0;

    //  业务数据上传次数
    @ColumnInfo(name = "_upload_data_fail_num", defaultValue = "0")
    private Integer uploadDataFailNum= 0;

    //  上传日期【yyyy-MM-dd】
    @ColumnInfo(name = "_upload_date", defaultValue = "")
    private String uploadDate;

    @ColumnInfo(name = "_device_id", defaultValue = "")
    private String deviceId;

    @ColumnInfo(name = "_sport_unit_code")
    private String sportUnitCode;

    @ColumnInfo(name = "_invalid_flag")
    private Integer invalidFlag= 0;

    @Ignore
    private String originalSportResult;

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

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getPerfectCount() {
        return perfectCount;
    }

    public void setPerfectCount(Integer perfectCount) {
        this.perfectCount = perfectCount;
    }

    public Integer getBravoCount() {
        return bravoCount;
    }

    public void setBravoCount(Integer bravoCount) {
        this.bravoCount = bravoCount;
    }

    public String getExtraJson() {
        return extraJson;
    }

    public void setExtraJson(String extraJson) {
        this.extraJson = extraJson;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public String getSportEndTime() {
        return sportEndTime;
    }

    public void setSportEndTime(String sportEndTime) {
        this.sportEndTime = sportEndTime;
    }

    public String getSportStartTime() {
        return sportStartTime;
    }

    public void setSportStartTime(String sportStartTime) {
        this.sportStartTime = sportStartTime;
    }

    public String getSportSkuId() {
        return sportSkuId;
    }

    public void setSportSkuId(String sportSkuId) {
        this.sportSkuId = sportSkuId;
    }

    public String getSportSkuSubType() {
        return sportSkuSubType;
    }

    public void setSportSkuSubType(String sportSkuSubType) {
        this.sportSkuSubType = sportSkuSubType;
    }

    public Long getSportTime() {
        return sportTime;
    }

    public void setSportTime(Long sportTime) {
        this.sportTime = sportTime;
    }

    public Integer getSportViolationStatus() {
        return sportViolationStatus;
    }

    public void setSportViolationStatus(Integer sportViolationStatus) {
        this.sportViolationStatus = sportViolationStatus;
    }

    public Integer getUploadDataStatus() {
        return uploadDataStatus;
    }

    public void setUploadDataStatus(Integer uploadDataStatus) {
        this.uploadDataStatus = uploadDataStatus;
    }

    public Integer getUploadModifyStatus() {
        return uploadModifyStatus;
    }

    public void setUploadModifyStatus(Integer uploadModifyStatus) {
        this.uploadModifyStatus = uploadModifyStatus;
    }

    public Integer getUploadDataFailNum() {
        return uploadDataFailNum;
    }

    public void setUploadDataFailNum(Integer uploadDataFailNum) {
        this.uploadDataFailNum = uploadDataFailNum;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getSportCount() {
        return sportCount;
    }

    public void setSportCount(Long sportCount) {
        this.sportCount = sportCount;
    }

    public Double getSportScore() {
        return sportScore;
    }

    public void setSportScore(Double sportScore) {
        this.sportScore = sportScore;
    }

    public String getSportResult() {
        return sportResult;
    }

    public void setSportResult(String sportResult) {
        this.sportResult = sportResult;
    }

    public String getSportSceneCode() {
        return sportSceneCode;
    }

    public void setSportSceneCode(String sportSceneCode) {
        this.sportSceneCode = sportSceneCode;
    }

    public void setTodayUploadDate() {
        this.uploadDate = InnerUtil.formatYMDNow();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean isTodayUploadDate() {
        return InnerUtil.formatYMDNow().equals(this.uploadDate);
    }

    public void addUploadDataFailNum() {
        this.uploadDataFailNum += 1;
    }

    public void restUploadDataFailNum() {
        this.uploadDataFailNum = 0;
    }

    public String getOriginalSportResult() {
        return originalSportResult;
    }

    public void setOriginalSportResult(String originalSportResult) {
        this.originalSportResult = originalSportResult;
    }

    public String getSportUnitCode() {
        return sportUnitCode;
    }

    public void setSportUnitCode(String sportUnitCode) {
        this.sportUnitCode = sportUnitCode;
    }

    public Integer getInvalidFlag() {
        return invalidFlag;
    }

    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }

    public static ReportSportTeacherData convertToData(TeacherSportLocalEntity entity) {
        if (entity == null) {
            return null;
        }

        ReportSportTeacherData data = new ReportSportTeacherData();
        data.setId(entity.getId());
        data.setAccountId(entity.getAccountId());
        data.setAppCode(entity.getAppCode());
        data.setAppName(entity.getAppName());
        data.setPerfectCount(entity.getPerfectCount());
        data.setBravoCount(entity.getBravoCount());
        data.setGoodeviceount(entity.getGoodCount());
        data.setExtraJson(entity.getExtraJson());
        data.setInvalidFlag(entity.getInvalidFlag());
        data.setSportCount(entity.getSportCount());
        data.setSportStartTime(entity.getSportStartTime());
        data.setSportEndTime(entity.getSportEndTime());
        // 本地实体无图片/视频字段，留空
        data.setSportImages(null);
        data.setSportVideos(null);
        data.setSportResult(entity.getSportResult());
        data.setSportSceneCode(entity.getSportSceneCode());
        data.setSportScore(entity.getSportScore());
        data.setSportSkuId(entity.getSportSkuId());
        data.setSportSkuSubType(entity.getSportSkuSubType());
        data.setSportTime(entity.getSportTime());
        data.setSportUnitCode(entity.getSportUnitCode());
        data.setOriginalSportResult(entity.getOriginalSportResult());
        data.setSportViolationStatus(entity.getSportViolationStatus());
        return data;
    }

    public static TeacherSportLocalEntity convertToEntity(ReportSportTeacherData data) {
        if (data == null) {
            return null;
        }
        TeacherSportLocalEntity entity = new TeacherSportLocalEntity();
        entity.setId(data.getId());
        entity.setAccountId(data.getAccountId());
        entity.setAppCode(data.getAppCode());
        entity.setAppName(data.getAppName());
        entity.setPerfectCount(data.getPerfectCount());
        entity.setBravoCount(data.getBravoCount());
        entity.setGoodCount(data.getGoodeviceount());
        entity.setExtraJson(data.getExtraJson());
        entity.setInvalidFlag(data.getInvalidFlag());
        entity.setSportCount(data.getSportCount());
        entity.setSportStartTime(data.getSportStartTime());
        entity.setSportEndTime(data.getSportEndTime());
        entity.setSportResult(data.getSportResult());
        entity.setSportSceneCode(data.getSportSceneCode());
        entity.setSportScore(data.getSportScore());
        entity.setSportSkuId(data.getSportSkuId());
        entity.setSportSkuSubType(data.getSportSkuSubType());
        entity.setSportTime(data.getSportTime());
        entity.setSportUnitCode(data.getSportUnitCode());
        entity.setOriginalSportResult(data.getOriginalSportResult());
        entity.setSportViolationStatus(data.getSportViolationStatus());
        return entity;
    }
}
