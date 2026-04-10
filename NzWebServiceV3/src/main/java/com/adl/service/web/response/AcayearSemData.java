package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class AcayearSemData {
    /**
     * 学年编码 2022-2023
     */
    @SerializedName("acayearCode")
    private String acayearCode;

    /**
     * 学期code
     */
    @SerializedName("acayearSemCode")
    private String acayearSemCode;

    /**
     * 学期name
     */
    @SerializedName("acayearSemName")
    private String acayearSemName;

    /**
     * 学年截止时间
     */
    @SerializedName("endDate")
    private String endDate;

    /**
     * 是否上一学期 1：是  0：不是
     */
    @SerializedName("isLastAcayearSem")
    private int isLastAcayearSem;

    /**
     * 是否当前学期 1：是  0：不是
     */
    @SerializedName("isNowAcayearSem")
    private int isNowAcayearSem;

    /**
     * 学年开始时间
     */
    @SerializedName("startDate")
    private String startDate;
}
