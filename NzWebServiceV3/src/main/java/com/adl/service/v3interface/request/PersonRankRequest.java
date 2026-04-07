package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class PersonRankRequest {
    /** 人员id */
    @SerializedName("accountId")
    private String accountId;

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

    private PersonRankRequest(Builder b) {
        this.accountId = b.accountId;
        this.sportSkuId = b.sportSkuId;
        this.sportSkuSubType = b.sportSkuSubType;
        this.timeType = b.timeType;
        this.classId = b.classId;
        this.gradeId = b.gradeId;
        this.orgId = b.orgId;
        this.collegeId = b.collegeId;
        this.facultyId = b.facultyId;
        this.majorId = b.majorId;
    }

    public static Builder builder(String accountId, String sportSkuId) {
        return new Builder(accountId, sportSkuId);
    }

    public static class Builder {
        private String accountId;
        private String sportSkuId;
        private String sportSkuSubType;
        private int timeType;
        private String classId;
        private String gradeId;
        private String orgId;
        private String collegeId;
        private String facultyId;
        private String majorId;

        Builder(String accountId, String sportSkuId) {
            this.accountId = accountId;
            this.sportSkuId = sportSkuId;
        }

        public Builder sportSkuSubType(String v) { this.sportSkuSubType = v; return this; }

        public Builder timeType(int v) { this.timeType = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public Builder gradeId(String v) { this.gradeId = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder collegeId(String v) { this.collegeId = v; return this; }

        public Builder facultyId(String v) { this.facultyId = v; return this; }

        public Builder majorId(String v) { this.majorId = v; return this; }

        public PersonRankRequest build() { return new PersonRankRequest(this); }
    }

    public String getAccountId() { return accountId; }
    public String getSportSkuId() { return sportSkuId; }
    public String getSportSkuSubType() { return sportSkuSubType; }
    public int getTimeType() { return timeType; }
    public String getClassId() { return classId; }
    public String getGradeId() { return gradeId; }
    public String getOrgId() { return orgId; }
    public String getCollegeId() { return collegeId; }
    public String getFacultyId() { return facultyId; }
    public String getMajorId() { return majorId; }
}