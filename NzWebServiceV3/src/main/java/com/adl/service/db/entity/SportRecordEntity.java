package com.adl.service.db.entity;

import com.adl.service.db.converter.ListSportImageConverter;
import com.adl.service.db.converter.ListSportIndicatorsConverter;
import com.adl.service.db.converter.ListSportVideoConverter;
import com.adl.service.web.response.SportImageData;
import com.adl.service.web.response.SportIndicatorsData;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 运动记录
 */
@Data
@NoArgsConstructor
@Entity(tableName = "_sport_record_upload")
@TypeConverters(value = {ListSportImageConverter.class, ListSportVideoConverter.class, ListSportIndicatorsConverter.class})
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
    private int invalidFlag;
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
    private int sportViolationStatus;
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
    private int multiPersonRank;

    @ColumnInfo(name = "_multi_person_index", defaultValue = "0")
    private int multiPersonIndex;

    //  图片集
    @ColumnInfo(name = "_sport_images")
    private List<SportImageData> sportImages;
    //  视频集
    @ColumnInfo(name = "_sport_videos")
    private List<SportImageData> sportVideos;

    //  赛事
    @ColumnInfo(name = "_sport_competition")
    private RecordCompetition competitionAthletics;
    //  运动会
    @ColumnInfo(name = "_sport_meet")
    private RecordMeeting sportMeet;
    //  组织测试
    @ColumnInfo(name = "_sport_plan")
    private RecordPlan sportPlan;

    //特训训练计划
    @ColumnInfo(name = "_sport_train_plan", defaultValue = "")
    public SportTrainPlan trainPlan;

    @ColumnInfo(name = "_sport_nature_code", defaultValue = "")
    public String sportNatureCodes;

    @ColumnInfo(name = "_sport_type_code", defaultValue = "")
    public String sportTypeCode;

    //  运动指标集合
    @ColumnInfo(name = "_sport_indicators")
    private List<SportIndicatorsData> sportIndicators;

    // 运动子项类型
    @ColumnInfo(name = "_sport_sku_sub_type", defaultValue = "")
    private String sportSkuSubType;

    @ColumnInfo(name = "_place_id", defaultValue = "")
    private String placeId;

    @ColumnInfo(name = "_place_name", defaultValue = "")
    private String placeName;

    @ColumnInfo(name = "_number", defaultValue = "0")
    private int number;

    @ColumnInfo(name = "_circle", defaultValue = "0")
    private int circle;
    @ColumnInfo(name = "_create_time", defaultValue = "0")
    private String createTime;
    @ColumnInfo(name = "_update_time", defaultValue = "0")
    private String updateTime;

    @ColumnInfo(name = "_report_version", defaultValue = "")
    private String reportVersion;

    @ColumnInfo(name = "_report_code", defaultValue = "")
    private String reportCode;
}
