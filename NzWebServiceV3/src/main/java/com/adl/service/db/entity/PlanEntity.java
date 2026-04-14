package com.adl.service.db.entity;

import com.adl.service.web.response.PlanData;
import com.adl.service.web.response.SportProjectData;
import com.adl.service.db.converter.ListSportProjectDataConverter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(tableName = "_sport_plan")
@TypeConverters(value = {ListSportProjectDataConverter.class})
public final class PlanEntity implements Serializable {
    /**
     * 创建时间
     */
    @ColumnInfo(name = "_create_time")
    private String createTime;

    /**
     * 创建者名称
     */
    @ColumnInfo(name = "_creator_name")
    private String creatorName;

    /**
     * 结束时间
     */
    @ColumnInfo(name = "_end_time")
    private String endTime;

    /**
     * 计划id
     */
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "_plan_id")
    private String planId;

    /**
     * 计划名称
     */
    @ColumnInfo(name = "_plan_name")
    private String planName;

    /**
     * 运动项目列表
     */
    @ColumnInfo(name = "_sport_projects")
    private List<SportProjectData> sportProjects;

    /**
     * 标准id
     */
    @ColumnInfo(name = "_standard_id")
    private String standardId;

    /**
     * 标准名称
     */
    @ColumnInfo(name = "_standard_name")
    private String standardName;

    /**
     * 标准类型
     */
    @ColumnInfo(name = "_standard_type")
    private String standardType;

    /**
     * 开始时间
     */
    @ColumnInfo(name = "_start_time")
    private String startTime;

    /**
     * 状态
     */
    @ColumnInfo(name = "_status")
    private String status;

    /**
     * 学生数量
     */
    @ColumnInfo(name = "_student_num")
    private Integer studentNum;

    /**
     * 安排数量
     */
    @ColumnInfo(name = "_arrange_num")
    private Integer arrangeNum;

    /**
     * 完成数量
     */
    @ColumnInfo(name = "_finish_num")
    private Integer finishNum;

    /**
     * 自测标识
     */
    @ColumnInfo(name = "_self_test")
    private Integer selfTest;

    public static PlanEntity convertToEntity(PlanData data) {
        if (data == null) {
            return null;
        }
        PlanEntity entity = new PlanEntity();
        entity.setCreateTime(data.getCreateTime());
        entity.setCreatorName(data.getCreatorName());
        entity.setEndTime(data.getEndTime());
        entity.setPlanId(data.getPlanId());
        entity.setPlanName(data.getPlanName());
        entity.setSportProjects(data.getSportProjects());
        entity.setStandardId(data.getStandardId());
        entity.setStandardName(data.getStandardName());
        entity.setStandardType(data.getStandardType());
        entity.setStartTime(data.getStartTime());
        entity.setStatus(data.getStatus());
        entity.setStudentNum(data.getStudentNum());
        entity.setArrangeNum(data.getArrangeNum());
        entity.setFinishNum(data.getFinishNum());
        entity.setSelfTest(data.getSelfTest());
        return entity;
    }
}
