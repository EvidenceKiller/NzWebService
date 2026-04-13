package com.adl.service.web.response;

import com.adl.service.internal.StrictJsonDeserializer;
import com.adl.service.web.response.converter.ListSportProjectDataConverter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@JsonAdapter(StrictJsonDeserializer.class)
@Entity(tableName = "_sport_plan")
@TypeConverters(value = {ListSportProjectDataConverter.class})
public final class PlanData implements Serializable {
    /**
     * 创建时间
     */
    @SerializedName("createTime")
    @ColumnInfo(name = "_create_time")
    private String createTime;

    /**
     * 创建者名称
     */
    @SerializedName("creatorName")
    @ColumnInfo(name = "_creator_name")
    private String creatorName;

    /**
     * 结束时间
     */
    @SerializedName("endTime")
    @ColumnInfo(name = "_end_time")
    private String endTime;

    /**
     * 计划id
     */
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "_plan_id")
    @SerializedName("planId")
    private String planId;

    /**
     * 计划名称
     */
    @SerializedName("planName")
    @ColumnInfo(name = "_plan_name")
    private String planName;

    /**
     * 运动项目列表
     */
    @SerializedName("sportProjects")
    @ColumnInfo(name = "_sport_projects")
    private List<SportProjectData> sportProjects;

    /**
     * 标准id
     */
    @SerializedName("standardId")
    @ColumnInfo(name = "_standard_id")
    private String standardId;

    /**
     * 标准名称
     */
    @SerializedName("standardName")
    @ColumnInfo(name = "_standard_name")
    private String standardName;

    /**
     * 标准类型
     */
    @SerializedName("standardType")
    @ColumnInfo(name = "_standard_type")
    private String standardType;

    /**
     * 开始时间
     */
    @SerializedName("startTime")
    @ColumnInfo(name = "_start_time")
    private String startTime;

    /**
     * 状态
     */
    @SerializedName("status")
    @ColumnInfo(name = "_status")
    private String status;

    /**
     * 学生数量
     */
    @SerializedName("studentNum")
    @ColumnInfo(name = "_student_num")
    private Integer studentNum;

    /**
     * 安排数量
     */
    @SerializedName("arrangeNum")
    @ColumnInfo(name = "_arrange_num")
    private Integer arrangeNum;

    /**
     * 完成数量
     */
    @SerializedName("finishNum")
    @ColumnInfo(name = "_finish_num")
    private Integer finishNum;

    /**
     * 自测标识
     */
    @SerializedName("selfTest")
    @ColumnInfo(name = "_self_test")
    private Integer selfTest;
}
