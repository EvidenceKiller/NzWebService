package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

public final class SumScoreRankData {

    /**
     * 用户标识码
     */
    @SerializedName("accountId")
    private String accountId;

    /**
     * 用户名
     */
    @SerializedName("accountName")
    private String accountName;

    /**
     * 账户性别
     */
    @SerializedName("sex")
    private int sex;

    /**
     * 学籍号
     */
    @SerializedName("studentCode")
    private String studentCode;

    /**
     * 学级标识码
     */
    @SerializedName("gradeId")
    private String gradeId;

    /**
     * 学级名称
     */
    @SerializedName("gradeName")
    private String gradeName;

    /**
     * 班级标识码
     */
    @SerializedName("classId")
    private String classId;

    /**
     * 班级名称
     */
    @SerializedName("className")
    private String className;

    /**
     * 人脸地址
     */
    @SerializedName("faceImgUrl")
    private String faceImgUrl;

    /**
     * 运动结果
     */
    @SerializedName("score")
    private String score;

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getSex() {
        return sex;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getGradeId() {
        return gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public String getFaceImgUrl() {
        return faceImgUrl;
    }

    public String getScore() {
        return score;
    }
}
