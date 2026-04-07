package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class SumScoreRankRequest {
    /** 运动sku标识码 */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 运动sku子类 */
    @SerializedName("sportSkuSubType")
    private String sportSkuSubType;

    /** 1-今日 2-本周 3-本月 4-本季度 5-本年度 */
    @SerializedName("timeType")
    private int timeType;

    /** 班级标识码 */
    @SerializedName("classId")
    private String classId;

    /** 学籍标识码 */
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

    /** 前几的排行榜 */
    @SerializedName("topLimit")
    private int topLimit;

    private SumScoreRankRequest(Builder b) {
        this.sportSkuId = b.sportSkuId;
        this.sportSkuSubType = b.sportSkuSubType;
        this.timeType = b.timeType;
        this.classId = b.classId;
        this.gradeId = b.gradeId;
        this.orgId = b.orgId;
        this.collegeId = b.collegeId;
        this.facultyId = b.facultyId;
        this.majorId = b.majorId;
        this.topLimit = b.topLimit;
    }

    public static Builder builder(String sportSkuId, int timeType) {
        return new Builder(sportSkuId, timeType);
    }

    public static class Builder {
        private String sportSkuId;
        private String sportSkuSubType;
        private int timeType;
        private String classId;
        private String gradeId;
        private String orgId;
        private String collegeId;
        private String facultyId;
        private String majorId;
        private int topLimit;

        Builder(String sportSkuId, int timeType) {
            this.sportSkuId = sportSkuId;
            this.timeType = timeType;
        }

        public Builder sportSkuSubType(String v) { this.sportSkuSubType = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public Builder gradeId(String v) { this.gradeId = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder collegeId(String v) { this.collegeId = v; return this; }

        public Builder facultyId(String v) { this.facultyId = v; return this; }

        public Builder majorId(String v) { this.majorId = v; return this; }

        public Builder topLimit(int v) { this.topLimit = v; return this; }

        public SumScoreRankRequest build() { return new SumScoreRankRequest(this); }
    }

    public String getSportSkuId() { return sportSkuId; }
    public String getSportSkuSubType() { return sportSkuSubType; }
    public int getTimeType() { return timeType; }
    public String getClassId() { return classId; }
    public String getGradeId() { return gradeId; }
    public String getOrgId() { return orgId; }
    public String getCollegeId() { return collegeId; }
    public String getFacultyId() { return facultyId; }
    public String getMajorId() { return majorId; }
    public int getTopLimit() { return topLimit; }
}