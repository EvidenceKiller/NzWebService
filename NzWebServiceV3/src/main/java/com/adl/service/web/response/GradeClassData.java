package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

class GradeClassData {
    /**
     * 班级全称 班级全称 小学一年级一班
     */
    @SerializedName("classFullName")
    private String classFullName;

    /**
     * 班级名称
     */
    @SerializedName("className")
    private String className;

    /**
     * 班级代码 1 2 3 4 5
     */
    @SerializedName("classNum")
    private int classNum;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private String createTime;

    /**
     * 专业代码 （高校）
     */
    @SerializedName("departmentCode")
    private String departmentCode;

    /**
     * 年级编码
     */
    @SerializedName("gradeCode")
    private String gradeCode;

    /**
     * 班级id
     */
    @SerializedName("id")
    private String id;

    /**
     * 机构id
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * 班级状态 1. 进行中 2. 未开学 3. 已毕业
     */
    @SerializedName("status")
    private int status;

    /**
     * 租户id
     */
    @SerializedName("tenantId")
    private String tenantId;

    /**
     * 更新时间
     */
    @SerializedName("updateTime")
    private String updateTime;

    /**
     * 学段年级中文名称
     */
    @SerializedName("gradeStageChineseName")
    private String gradeStageChineseName;

    /**
     *
     */
    @SerializedName("platformClassId")
    private String platformClassId;

    /**
     * 学院代码
     */
    @SerializedName("collegeCode")
    private String collegeCode;

    /**
     * 学院ID
     */
    @SerializedName("collegeId")
    private String collegeId;

    /**
     * 学院名称
     */
    @SerializedName("collegeName")
    private String collegeName;

    /**
     * 院系代码
     */
    @SerializedName("facultyCode")
    private String facultyCode;

    /**
     * 院系ID
     */
    @SerializedName("facultyId")
    private String facultyId;

    /**
     * 院系名称
     */
    @SerializedName("facultyName")
    private String facultyName;

    /**
     * 专业代码
     */
    @SerializedName("majorCode")
    private String majorCode;

    /**
     * 专业ID
     */
    @SerializedName("majorId")
    private String majorId;

    /**
     * 专业名称
     */
    @SerializedName("majorName")
    private String majorName;

    public String getClassFullName() {
        return classFullName;
    }

    public String getClassName() {
        return className;
    }

    public int getClassNum() {
        return classNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public String getId() {
        return id;
    }

    public String getOrgId() {
        return orgId;
    }

    public int getStatus() {
        return status;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getGradeStageChineseName() {
        return gradeStageChineseName;
    }

    public String getPlatformClassId() {
        return platformClassId;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getMajorName() {
        return majorName;
    }
}
