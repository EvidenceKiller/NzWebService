package com.adl.service.db.entity;

import com.adl.service.db.converter.ListClassSimpleDataConverter;
import com.adl.service.db.converter.ListSportMeetGroupTeamEntityConverter;
import com.adl.service.db.converter.ListSportMeetSimpleClassDataConverter;
import com.adl.service.db.converter.ListSportMeetSkuEntityConverter;
import com.adl.service.web.response.ClassSimpleData;
import com.adl.service.web.response.SportMeetData;
import com.adl.service.web.response.SportMeetSimpleClassData;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(tableName = "_sport_meet")
@TypeConverters(value = {ListSportMeetSkuEntityConverter.class,
        ListSportMeetGroupTeamEntityConverter.class,
        ListSportMeetSimpleClassDataConverter.class,
        ListClassSimpleDataConverter.class})
public final class SportMeetEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long lid;

    // 应用编码【手动添加】
    @ColumnInfo(name = "_app_code")
    private String appCode;

    /**
     * 是否启用排序
     */
    @ColumnInfo(name = "_enable_sort")
    private Boolean enableSort;

    /**
     * 模块字符串
     */
    @ColumnInfo(name = "_module_str")
    private String moduleStr;

    /**
     * 唯一标识符
     */
    @ColumnInfo(name = "_id")
    private String id;

    /**
     * 机构ID
     */
    @ColumnInfo(name = "_org_id")
    private String orgId;

    /**
     * 运动会标题
     */
    @ColumnInfo(name = "_meet_title")
    private String meetTitle;

    /**
     * 开始时间
     */
    @ColumnInfo(name = "_start_time")
    private Long startTime;

    /**
     * 结束时间
     */
    @ColumnInfo(name = "_end_time")
    private Long endTime;

    /**
     * 报名开始时间
     */
    @ColumnInfo(name = "_apply_start_time")
    private Long applyStartTime;

    /**
     * 报名结束时间
     */
    @ColumnInfo(name = "_apply_end_time")
    private Long applyEndTime;

    /**
     * 创建者编码
     */
    @ColumnInfo(name = "_creator_num")
    private String creatorNum;

    /**
     * 文件URL
     */
    @ColumnInfo(name = "_file_url")
    private String fileUrl;

    /**
     * 文件名
     */
    @ColumnInfo(name = "_file_name")
    private String fileName;

    /**
     * 应用代码
     */
    @ColumnInfo(name = "_app_codes")
    private String appCodes;

    /**
     * 删除标志
     */
    @ColumnInfo(name = "_del_flag")
    private Boolean delFlag;

    /**
     * 创建时间
     */
    @ColumnInfo(name = "_create_time")
    private Long createTime;

    /**
     * 更新时间
     */
    @ColumnInfo(name = "_update_time")
    private Long updateTime;

    /**
     * 限制团队数量
     */
    @ColumnInfo(name = "_limit_team_num")
    private Integer limitTeamNum;

    /**
     * 限制人数
     */
    @ColumnInfo(name = "_limit_person_num")
    private Integer limitPersonNum;

    /**
     * 运动会副标题
     */
    @ColumnInfo(name = "_meet_subtitle")
    private String meetSubtitle;

    /**
     * 运动会封面
     */
    @ColumnInfo(name = "_meet_cover")
    private String meetCover;

    /**
     * 学年学期代码
     */
    @ColumnInfo(name = "_acayear_sem_code")
    private String acayearSemCode;

    /**
     * 运动风格图片列表
     */
    @ColumnInfo(name = "_sport_style_images")
    private List<String> sportStyleImages;

    /**
     * SKU列表
     */
    @ColumnInfo(name = "_sku_list")
    private List<SportMeetSkuEntity> skuList;

    /**
     * 班级列表
     */
    @ColumnInfo(name = "_class_list")
    private List<SportMeetSimpleClassData> classList;

    /**
     * 状态
     */
    @ColumnInfo(name = "_state")
    private Integer state;

    /**
     * 报名状态
     */
    @ColumnInfo(name = "_apply_state")
    private Integer applyState;

    /**
     * 班级ID列表
     */
    @ColumnInfo(name = "_class_ids")
    private List<String> classIds;

    /**
     * 班级
     */
    @ColumnInfo(name = "_classes")
    private List<ClassSimpleData> classes;

    /**
     * 机构名称
     */
    @ColumnInfo(name = "_org_name")
    private String orgName;

    /**
     * 报名用户数量
     */
    @ColumnInfo(name = "_apply_user_count")
    private Integer applyUserCount;

    /**
     * 运动员数量
     */
    @ColumnInfo(name = "_players_num")
    private Integer playersNum;

    /**
     * 密码
     */
    @ColumnInfo(name = "_password")
    private String password;

    /**
     * 分组团队
     */
    @ColumnInfo(name = "_group_teams")
    private List<SportMeetGroupTeamEntity> groupTeams;

    public static SportMeetEntity convertToEntity(SportMeetData data, String appCode) {
        if (data == null) {
            return null;
        }
        SportMeetEntity entity = new SportMeetEntity();
        entity.setAppCode(appCode);
        entity.setId(data.getId());
        entity.setOrgId(data.getOrgId());
        entity.setMeetTitle(data.getMeetTitle());
        entity.setStartTime(data.getStartTime());
        entity.setEndTime(data.getEndTime());
        entity.setApplyStartTime(data.getApplyStartTime());
        entity.setApplyEndTime(data.getApplyEndTime());
        entity.setCreatorNum(data.getCreatorNum());
        entity.setFileUrl(data.getFileUrl());
        entity.setFileName(data.getFileName());
        entity.setAppCodes(data.getAppCodes());
        entity.setDelFlag(data.getDelFlag());
        entity.setCreateTime(data.getCreateTime());
        entity.setUpdateTime(data.getUpdateTime());
        entity.setLimitTeamNum(data.getLimitTeamNum());
        entity.setLimitPersonNum(data.getLimitPersonNum());
        entity.setMeetSubtitle(data.getMeetSubtitle());
        entity.setMeetCover(data.getMeetCover());
        entity.setAcayearSemCode(data.getAcayearSemCode());
        entity.setSportStyleImages(data.getSportStyleImages());
        if (data.getSkuList() != null) {
            List<SportMeetSkuEntity> skuEntities = data.getSkuList().stream()
                    .map(sku -> SportMeetSkuEntity.convertToEntity(sku))
                    .collect(Collectors.toList());
            entity.setSkuList(skuEntities);
        }
        // classList 可能需要特殊处理，这里假设直接对应或忽略，视具体业务而定
        entity.setClassList(data.getClassList());
        entity.setState(data.getState());
        entity.setApplyState(data.getApplyState());
        entity.setClassIds(data.getClassIds());
        entity.setClasses(data.getClasses());
        entity.setOrgName(data.getOrgName());
        entity.setApplyUserCount(data.getApplyUserCount());
        entity.setPlayersNum(data.getPlayersNum());
        // password 和 groupTeams 在 SportMeetData 中未明确展示 getter，若存在则设置
        entity.setPassword(data.getPassword());
        if (data.getGroupTeams() != null) {
            List<SportMeetGroupTeamEntity> teamEntities = data.getGroupTeams().stream()
                    .map(team -> SportMeetGroupTeamEntity.convertToEntity(team, appCode))
                    .collect(Collectors.toList());
            entity.setGroupTeams(teamEntities);
        }
        entity.setEnableSort(data.getEnableSort());
        entity.setModuleStr(data.getModuleStr());
        return entity;
    }
}
