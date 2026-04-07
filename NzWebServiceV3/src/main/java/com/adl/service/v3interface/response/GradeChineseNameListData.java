package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public final class GradeChineseNameListData {
    /** 年级ID */
    @SerializedName("id")
    private String id;

    /** 入学年份 入学年份 入学时间（2019） */
    @SerializedName("enterYear")
    private int enterYear;

    /** 毕业年份 毕业年份 毕业时间（2020） */
    @SerializedName("graduationYear")
    private int graduationYear;

    /** 年级编码 org_code_enter_year */
    @SerializedName("gradeCode")
    private String gradeCode;

    /** 年级名称 */
    @SerializedName("gradeName")
    private String gradeName;

    /** 部门编码 多个用-隔开 */
    @SerializedName("departmentCodes")
    private String departmentCodes;

    /** 是否毕业 参考字典编码：adl_tis_graduation_flag（1 毕业 0 未毕业） */
    @SerializedName("graduationFlag")
    private int graduationFlag;

    /** 班级列表 */
    @SerializedName("classList")
    private List<Object> classList;

    /** 年级序号（根据当前学段） */
    @SerializedName("gradeNumByStage")
    private int gradeNumByStage;

    /** 年级序号（总年级编号） */
    @SerializedName("gradeNum")
    private int gradeNum;

    /** 学段代码 */
    @SerializedName("secCode")
    private String secCode;

    /** 学段序号 */
    @SerializedName("stageType")
    private String stageType;

    /** 年级中文名称 */
    @SerializedName("gradeChineseName")
    private String gradeChineseName;

    /** 学段年级中文名称 */
    @SerializedName("gradeStageChineseName")
    private String gradeStageChineseName;

    public String getId() { return id; }
    public int getEnterYear() { return enterYear; }
    public int getGraduationYear() { return graduationYear; }
    public String getGradeCode() { return gradeCode; }
    public String getGradeName() { return gradeName; }
    public String getDepartmentCodes() { return departmentCodes; }
    public int getGraduationFlag() { return graduationFlag; }
    public List<Object> getClassList() { return classList; }
    public int getGradeNumByStage() { return gradeNumByStage; }
    public int getGradeNum() { return gradeNum; }
    public String getSecCode() { return secCode; }
    public String getStageType() { return stageType; }
    public String getGradeChineseName() { return gradeChineseName; }
    public String getGradeStageChineseName() { return gradeStageChineseName; }
}