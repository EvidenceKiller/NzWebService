package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public final class ClassInfoData {

    /**
     * 班级id
     */
    @SerializedName("id")
    private String id;

    /**
     * 班级代码 1 2 3 4 5
     */
    @SerializedName("classNum")
    private int classNum;

    /**
     * 班级名称
     */
    @SerializedName("className")
    private String className;

    /**
     * 班级全称 班级全称 小学一年级一班
     */
    @SerializedName("classFullName")
    private String classFullName;

    /**
     * 专业代码 （高校）
     */
    @SerializedName("departmentCode")
    private String departmentCode;

    /**
     * 班级状态 1. 进行中 2. 未开学 3. 已毕业
     */
    @SerializedName("status")
    private int status;

    /**
     * 专业ID
     */
    @SerializedName("majorId")
    private String majorId;

    /**
     * 专业代码
     */
    @SerializedName("majorCode")
    private String majorCode;

    /**
     * 专业名称
     */
    @SerializedName("majorName")
    private String majorName;

    /**
     * 院系ID
     */
    @SerializedName("facultyId")
    private String facultyId;

    /**
     * 院系代码
     */
    @SerializedName("facultyCode")
    private String facultyCode;

    /**
     * 院系名称
     */
    @SerializedName("facultyName")
    private String facultyName;

    /**
     * 学院ID
     */
    @SerializedName("collegeId")
    private String collegeId;

    /**
     * 学院代码
     */
    @SerializedName("collegeCode")
    private String collegeCode;

    /**
     * 学院名称
     */
    @SerializedName("collegeName")
    private String collegeName;

    public String getId() {
        return id;
    }

    public int getClassNum() {
        return classNum;
    }

    public String getClassName() {
        return className;
    }

    public String getClassFullName() {
        return classFullName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public int getStatus() {
        return status;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public String getCollegeName() {
        return collegeName;
    }
}
