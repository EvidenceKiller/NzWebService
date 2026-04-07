package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



public final class GetResTypeListData {
    /** 主键ID */
    @SerializedName("id")
    private String id;

    /** 分类名称 */
    @SerializedName("typeName")
    private String typeName;

    /** 排序 */
    @SerializedName("sort")
    private int sort;

    /** 机构id */
    @SerializedName("orgId")
    private String orgId;

    /** 1 - 备课助手 2-校本资源 */
    @SerializedName("resType")
    private int resType;

    /** 创建时间 */
    @SerializedName("createTime")
    private String createTime;

    /** 更新时间 */
    @SerializedName("updateTime")
    private String updateTime;

    public String getId() { return id; }
    public String getTypeName() { return typeName; }
    public int getSort() { return sort; }
    public String getOrgId() { return orgId; }
    public int getResType() { return resType; }
    public String getCreateTime() { return createTime; }
    public String getUpdateTime() { return updateTime; }
}