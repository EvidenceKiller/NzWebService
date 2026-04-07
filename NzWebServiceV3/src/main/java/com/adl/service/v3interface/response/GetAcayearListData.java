package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Name : GetAcayearListData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class GetAcayearListData {
    /** 学年 */
    @SerializedName("year")
    private String year;

    /** 学期阶段list */
    @SerializedName("acayearSemList")
    private List<Object> acayearSemList;

    /** 是否当前学年 1：是 0 不是 */
    @SerializedName("isNowAcayear")
    private int isNowAcayear;

    public String getYear() { return year; }
    public List<Object> getAcayearSemList() { return acayearSemList; }
    public int getIsNowAcayear() { return isNowAcayear; }
}