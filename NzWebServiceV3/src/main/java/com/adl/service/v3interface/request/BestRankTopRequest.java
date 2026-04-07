package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : BestRankTopRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class BestRankTopRequest {
    /** 产品应用标识码 */
    @SerializedName("appCode")
    private String appCode;

    /** 运动sku标识码 */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 班级标识码 */
    @SerializedName("classId")
    private String classId;

    /** 学级标识码 */
    @SerializedName("gradeId")
    private String gradeId;

    /** 机构标识码 */
    @SerializedName("orgId")
    private String orgId;

    /** 学院标识码 */
    @SerializedName("collegeId")
    private String collegeId;

    /** 学系标识码 */
    @SerializedName("facultyId")
    private String facultyId;

    /** 专业标识码 */
    @SerializedName("majorId")
    private String majorId;

    /** 账户性别 */
    @SerializedName("sex")
    private int sex;

    /** 前几的排行榜 */
    @SerializedName("top")
    private int top;

    /** 1-今日 2-本周 3-本月 4-本季度 5-本年度 */
    @SerializedName("timeType")
    private int timeType;

    /** 运动场景代码 */
    @SerializedName("sportSceneCode")
    private String sportSceneCode;

    /** 运动场景类型 */
    @SerializedName("sportSceneType")
    private String sportSceneType;

    private BestRankTopRequest(Builder b) {
        this.appCode = b.appCode;
        this.sportSkuId = b.sportSkuId;
        this.classId = b.classId;
        this.gradeId = b.gradeId;
        this.orgId = b.orgId;
        this.collegeId = b.collegeId;
        this.facultyId = b.facultyId;
        this.majorId = b.majorId;
        this.sex = b.sex;
        this.top = b.top;
        this.timeType = b.timeType;
        this.sportSceneCode = b.sportSceneCode;
        this.sportSceneType = b.sportSceneType;
    }

    public static Builder builder(int timeType) {
        return new Builder(timeType);
    }

    public static class Builder {
        private String appCode;
        private String sportSkuId;
        private String classId;
        private String gradeId;
        private String orgId;
        private String collegeId;
        private String facultyId;
        private String majorId;
        private int sex;
        private int top;
        private int timeType;
        private String sportSceneCode;
        private String sportSceneType;

        Builder(int timeType) {
            this.timeType = timeType;
        }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder sportSkuId(String v) { this.sportSkuId = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public Builder gradeId(String v) { this.gradeId = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder collegeId(String v) { this.collegeId = v; return this; }

        public Builder facultyId(String v) { this.facultyId = v; return this; }

        public Builder majorId(String v) { this.majorId = v; return this; }

        public Builder sex(int v) { this.sex = v; return this; }

        public Builder top(int v) { this.top = v; return this; }

        public Builder sportSceneCode(String v) { this.sportSceneCode = v; return this; }

        public Builder sportSceneType(String v) { this.sportSceneType = v; return this; }

        public BestRankTopRequest build() { return new BestRankTopRequest(this); }
    }

    public String getAppCode() { return appCode; }
    public String getSportSkuId() { return sportSkuId; }
    public String getClassId() { return classId; }
    public String getGradeId() { return gradeId; }
    public String getOrgId() { return orgId; }
    public String getCollegeId() { return collegeId; }
    public String getFacultyId() { return facultyId; }
    public String getMajorId() { return majorId; }
    public int getSex() { return sex; }
    public int getTop() { return top; }
    public int getTimeType() { return timeType; }
    public String getSportSceneCode() { return sportSceneCode; }
    public String getSportSceneType() { return sportSceneType; }
}