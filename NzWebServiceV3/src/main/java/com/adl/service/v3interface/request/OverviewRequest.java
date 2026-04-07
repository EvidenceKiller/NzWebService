package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class OverviewRequest {
    /** 1-今日 2-本周 3-本月 4-本季度 5-本年度 */
    @SerializedName("timeType")
    private int timeType;

    /** 班级标识码 */
    @SerializedName("classId")
    private String classId;

    /** 学籍标识码 */
    @SerializedName("gradeId")
    private String gradeId;

    /** 学院标识码 */
    @SerializedName("collegeId")
    private String collegeId;

    /** 学系标识码 */
    @SerializedName("facultyId")
    private String facultyId;

    /** 专业标识码 */
    @SerializedName("majorId")
    private String majorId;

    private OverviewRequest(Builder b) {
        this.timeType = b.timeType;
        this.classId = b.classId;
        this.gradeId = b.gradeId;
        this.collegeId = b.collegeId;
        this.facultyId = b.facultyId;
        this.majorId = b.majorId;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private int timeType;
        private String classId;
        private String gradeId;
        private String collegeId;
        private String facultyId;
        private String majorId;

        public Builder timeType(int v) { this.timeType = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public Builder gradeId(String v) { this.gradeId = v; return this; }

        public Builder collegeId(String v) { this.collegeId = v; return this; }

        public Builder facultyId(String v) { this.facultyId = v; return this; }

        public Builder majorId(String v) { this.majorId = v; return this; }

        public OverviewRequest build() { return new OverviewRequest(this); }
    }

    public int getTimeType() { return timeType; }
    public String getClassId() { return classId; }
    public String getGradeId() { return gradeId; }
    public String getCollegeId() { return collegeId; }
    public String getFacultyId() { return facultyId; }
    public String getMajorId() { return majorId; }
}