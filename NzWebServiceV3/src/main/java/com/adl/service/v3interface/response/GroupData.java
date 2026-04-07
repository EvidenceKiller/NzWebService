package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public final class GroupData {
    /** 场景 code */
    @SerializedName("sceneCode")
    private String sceneCode;

    /** 组织测试 Id */
    @SerializedName("ptPlanId")
    private String ptPlanId;

    /** 班级 Id */
    @SerializedName("classId")
    private String classId;

    /** 分组规则 */
    @SerializedName("groupRule")
    private Object groupRule;

    @SerializedName("empty")
    private boolean empty;

    /** 运动 Id */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 分组信息 */
    @SerializedName("groups")
    private List<Object> groups;

    /** 长跑分组模式 1-号牌 2-人脸 - 邓工要求加的字段 */
    @SerializedName("longModeType")
    private int longModeType;

    public String getSceneCode() { return sceneCode; }
    public String getPtPlanId() { return ptPlanId; }
    public String getClassId() { return classId; }
    public Object getGroupRule() { return groupRule; }
    public boolean getEmpty() { return empty; }
    public String getSportSkuId() { return sportSkuId; }
    public List<Object> getGroups() { return groups; }
    public int getLongModeType() { return longModeType; }
}