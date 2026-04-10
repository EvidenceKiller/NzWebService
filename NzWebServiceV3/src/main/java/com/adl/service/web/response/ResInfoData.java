package com.adl.service.web.response;

import com.adl.service.internal.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonAdapter(StrictJsonDeserializer.class)
public final class ResInfoData {

    @SerializedName("noPaging")
    private boolean noPaging;

    @SerializedName("pageSize")
    private long pageSize;

    @SerializedName("current")
    private long current;

    @SerializedName("detail")
    private boolean detail;

    @SerializedName("enableSort")
    private boolean enableSort;

    @SerializedName("sorts")
    private List<Object> sorts;

    @SerializedName("sortsStr")
    private String sortsStr;

    @SerializedName("ignoreColumns")
    private List<Object> ignoreColumns;

    @SerializedName("containColumns")
    private List<Object> containColumns;

    @SerializedName("moduleStr")
    private String moduleStr;

    /**
     * 主键ID
     */
    @SerializedName("id")
    private String id;

    /**
     * 机构id
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * 资源名
     */
    @SerializedName("name")
    private String name;

    /**
     * 资源标题
     */
    @SerializedName("title")
    private String title;

    /**
     * 资源封面（建议相对路径）
     */
    @SerializedName("cover")
    private String cover;

    /**
     * 启停用 参考枚举 adl_tis_enabled
     */
    @SerializedName("enabled")
    private boolean enabled;

    /**
     * 排序
     */
    @SerializedName("sortNum")
    private int sortNum;

    /**
     * 资源内容
     */
    @SerializedName("content")
    private String content;

    /**
     * 资源备注(最大500字符)
     */
    @SerializedName("remark")
    private String remark;

    /**
     * 资源文件类型 参考枚举 adl_tis_res_type
     */
    @SerializedName("type")
    private int type;

    /**
     * 资源类型 1-备课助手 2-校本资源
     */
    @SerializedName("resType")
    private int resType;

    /**
     * 创建者账号
     */
    @SerializedName("createNum")
    private String createNum;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private String createTime;

    /**
     * 更新时间
     */
    @SerializedName("updateTime")
    private String updateTime;

    /**
     * 资源类型列表
     */
    @SerializedName("resTypes")
    private List<Object> resTypes;
}
