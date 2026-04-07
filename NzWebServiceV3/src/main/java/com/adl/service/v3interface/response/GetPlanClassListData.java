package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



public final class GetPlanClassListData {
    /** 班级id */
    @SerializedName("classId")
    private String classId;

    /** 年级名称 */
    @SerializedName("gradeName")
    private String gradeName;

    /** 年级id */
    @SerializedName("gradeId")
    private String gradeId;

    /** 班级名称 */
    @SerializedName("className")
    private String className;

    /** 学院id */
    @SerializedName("collegeId")
    private String collegeId;

    /** 学院名称 */
    @SerializedName("collegeName")
    private String collegeName;

    /** 专业id */
    @SerializedName("majorId")
    private String majorId;

    /** 专业名称 */
    @SerializedName("majorName")
    private String majorName;

    /** 系部id */
    @SerializedName("facultyId")
    private String facultyId;

    /** 系部名称 */
    @SerializedName("facultyName")
    private String facultyName;

    /** 学段编号 */
    @SerializedName("periodNum")
    private String periodNum;

    /** 年级编号 */
    @SerializedName("gradeNum")
    private String gradeNum;

    public String getClassId() { return classId; }
    public String getGradeName() { return gradeName; }
    public String getGradeId() { return gradeId; }
    public String getClassName() { return className; }
    public String getCollegeId() { return collegeId; }
    public String getCollegeName() { return collegeName; }
    public String getMajorId() { return majorId; }
    public String getMajorName() { return majorName; }
    public String getFacultyId() { return facultyId; }
    public String getFacultyName() { return facultyName; }
    public String getPeriodNum() { return periodNum; }
    public String getGradeNum() { return gradeNum; }
}