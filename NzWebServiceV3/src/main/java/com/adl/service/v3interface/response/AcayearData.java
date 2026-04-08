package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class AcayearData {

    /**
     * 学年
     */
    @SerializedName("year")
    private String year;

    /**
     * 学期阶段list
     */
    @SerializedName("acayearSemList")
    private List<AcayearSemData> acayearSemList;

    /**
     * 是否当前学年 1：是 0 不是
     */
    @SerializedName("isNowAcayear")
    private int isNowAcayear;

    public String getYear() {
        return year;
    }

    public List<AcayearSemData> getAcayearSemList() {
        return acayearSemList;
    }

    public int getIsNowAcayear() {
        return isNowAcayear;
    }
}
