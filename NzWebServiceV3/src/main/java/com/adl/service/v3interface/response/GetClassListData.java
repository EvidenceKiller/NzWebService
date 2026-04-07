package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



public final class GetClassListData {
    /** 班级ID */
    @SerializedName("classId")
    private String classId;

    /** 年级ID */
    @SerializedName("gradeId")
    private String gradeId;

    /** 班级编号 */
    @SerializedName("classNum")
    private String classNum;

    /** 班级全名 */
    @SerializedName("classFullName")
    private String classFullName;

    /** 学年学期代码 */
    @SerializedName("acayearSemCode")
    private String acayearSemCode;

    /** 班级名称 */
    @SerializedName("className")
    private String className;

    /** 年级名称 */
    @SerializedName("gradeName")
    private String gradeName;

    /** 学段编码 */
    @SerializedName("secCode")
    private String secCode;

    /** 专业ID */
    @SerializedName("majorId")
    private String majorId;

    /** 专业代码 */
    @SerializedName("majorCode")
    private String majorCode;

    /** 专业名称 */
    @SerializedName("majorName")
    private String majorName;

    /** 院系ID */
    @SerializedName("facultyId")
    private String facultyId;

    /** 院系代码 */
    @SerializedName("facultyCode")
    private String facultyCode;

    /** 院系名称 */
    @SerializedName("facultyName")
    private String facultyName;

    /** 学院ID */
    @SerializedName("collegeId")
    private String collegeId;

    /** 学院代码 */
    @SerializedName("collegeCode")
    private String collegeCode;

    /** 学院名称 */
    @SerializedName("collegeName")
    private String collegeName;

    /** 年级中文名称 */
    @SerializedName("gradeChineseName")
    private String gradeChineseName;

    public String getClassId() { return classId; }
    public String getGradeId() { return gradeId; }
    public String getClassNum() { return classNum; }
    public String getClassFullName() { return classFullName; }
    public String getAcayearSemCode() { return acayearSemCode; }
    public String getClassName() { return className; }
    public String getGradeName() { return gradeName; }
    public String getSecCode() { return secCode; }
    public String getMajorId() { return majorId; }
    public String getMajorCode() { return majorCode; }
    public String getMajorName() { return majorName; }
    public String getFacultyId() { return facultyId; }
    public String getFacultyCode() { return facultyCode; }
    public String getFacultyName() { return facultyName; }
    public String getCollegeId() { return collegeId; }
    public String getCollegeCode() { return collegeCode; }
    public String getCollegeName() { return collegeName; }
    public String getGradeChineseName() { return gradeChineseName; }
}