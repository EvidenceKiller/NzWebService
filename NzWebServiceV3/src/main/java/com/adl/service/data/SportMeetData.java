package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.utils.CommonUtil;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class SportMeetData implements Serializable {
    /**
     * 是否启用排序
     */
    @SerializedName("enableSort")
    private Boolean enableSort = Boolean.FALSE;

    /**
     * 模块字符串
     */
    @SerializedName("moduleStr")
    private String moduleStr;

    /**
     * 唯一标识符
     */
    @SerializedName("id")
    private String id;

    /**
     * 机构ID
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * 运动会标题
     */
    @SerializedName("meetTitle")
    private String meetTitle;

    /**
     * 开始时间
     */
    @SerializedName("startTime")
    private Long startTime = 0L;

    /**
     * 结束时间
     */
    @SerializedName("endTime")
    private Long endTime = 0L;

    /**
     * 报名开始时间
     */
    @SerializedName("applyStartTime")
    private Long applyStartTime = 0L;

    /**
     * 报名结束时间
     */
    @SerializedName("applyEndTime")
    private Long applyEndTime = 0L;

    /**
     * 创建者编码
     */
    @SerializedName("creatorNum")
    private String creatorNum;

    /**
     * 文件URL
     */
    @SerializedName("fileUrl")
    private String fileUrl;

    /**
     * 文件名
     */
    @SerializedName("fileName")
    private String fileName;

    /**
     * 应用代码
     */
    @SerializedName("appCodes")
    private String appCodes;

    /**
     * 删除标志
     */
    @SerializedName("delFlag")
    private Boolean delFlag = Boolean.FALSE;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private Long createTime = 0L;

    /**
     * 更新时间
     */
    @SerializedName("updateTime")
    private Long updateTime = 0L;

    /**
     * 限制团队数量
     */
    @SerializedName("limitTeamNum")
    private Integer limitTeamNum = 0;

    /**
     * 限制人数
     */
    @SerializedName("limitPersonNum")
    private Integer limitPersonNum = 0;

    /**
     * 运动会副标题
     */
    @SerializedName("meetSubtitle")
    private String meetSubtitle;

    /**
     * 运动会封面
     */
    @SerializedName("meetCover")
    private String meetCover;

    /**
     * 学年学期代码
     */
    @SerializedName("acayearSemCode")
    private String acayearSemCode;

    /**
     * 运动风格图片列表
     */
    @SerializedName("sportStyleImages")
    private List<String> sportStyleImages;

    /**
     * SKU列表
     */
    @SerializedName("skuList")
    private List<SportMeetSkuData> skuList;

    /**
     * 班级列表
     */
    @SerializedName("classList")
    private List<SportMeetSimpleClassData> classList;

    /**
     * 状态
     */
    @SerializedName("state")
    private Integer state = 0;

    /**
     * 报名状态
     */
    @SerializedName("applyState")
    private Integer applyState = 0;

    /**
     * 班级ID列表
     */
    @SerializedName("classIds")
    private List<String> classIds;

    /**
     * 班级
     */
    @SerializedName("classes")
    private List<ClassSimpleData> classes;

    /**
     * 机构名称
     */
    @SerializedName("orgName")
    private String orgName;

    /**
     * 报名用户数量
     */
    @SerializedName("applyUserCount")
    private Integer applyUserCount = 0;

    /**
     * 运动员数量
     */
    @SerializedName("playersNum")
    private Integer playersNum = 0;

    /**
     * 密码
     */
    @SerializedName("password")
    private String password;

    /**
     * 分组团队
     */
    @SerializedName("groupTeams")
    private List<SportMeetGroupTeamData> groupTeams;

    public List<SportMeetSkuData> fliterSkuList(Predicate<SportMeetSkuData> predicate) {
        if (CommonUtil.isNotEmptyList(skuList)) {
            List<SportMeetSkuData> filterList = skuList.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
            skuList = filterList;
            return filterList;
        } else {
            return null;
        }
    }
}
