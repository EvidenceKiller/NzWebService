package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class GroupRequest {
    /** 场景code */
    @SerializedName("sceneCode")
    private String sceneCode;

    /** 组织测试Id */
    @SerializedName("ptPlanId")
    private String ptPlanId;

    /** 随堂测班级Id */
    @SerializedName("classId")
    private String classId;

    /** 分组ID */
    @SerializedName("groupId")
    private String groupId;

    /** 分组班级ID */
    @SerializedName("groupClassId")
    private String groupClassId;

    /** 分组编号 */
    @SerializedName("groupNumber")
    private String groupNumber;

    /** 运动Id */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 长跑分组模式 - 邓工要求加的字段 */
    @SerializedName("longModeType")
    private int longModeType;

    private GroupRequest(Builder b) {
        this.sceneCode = b.sceneCode;
        this.ptPlanId = b.ptPlanId;
        this.classId = b.classId;
        this.groupId = b.groupId;
        this.groupClassId = b.groupClassId;
        this.groupNumber = b.groupNumber;
        this.sportSkuId = b.sportSkuId;
        this.longModeType = b.longModeType;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String sceneCode;
        private String ptPlanId;
        private String classId;
        private String groupId;
        private String groupClassId;
        private String groupNumber;
        private String sportSkuId;
        private int longModeType;

        public Builder sceneCode(String v) { this.sceneCode = v; return this; }

        public Builder ptPlanId(String v) { this.ptPlanId = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public Builder groupId(String v) { this.groupId = v; return this; }

        public Builder groupClassId(String v) { this.groupClassId = v; return this; }

        public Builder groupNumber(String v) { this.groupNumber = v; return this; }

        public Builder sportSkuId(String v) { this.sportSkuId = v; return this; }

        public Builder longModeType(int v) { this.longModeType = v; return this; }

        public GroupRequest build() { return new GroupRequest(this); }
    }

    public String getSceneCode() { return sceneCode; }
    public String getPtPlanId() { return ptPlanId; }
    public String getClassId() { return classId; }
    public String getGroupId() { return groupId; }
    public String getGroupClassId() { return groupClassId; }
    public String getGroupNumber() { return groupNumber; }
    public String getSportSkuId() { return sportSkuId; }
    public int getLongModeType() { return longModeType; }
}