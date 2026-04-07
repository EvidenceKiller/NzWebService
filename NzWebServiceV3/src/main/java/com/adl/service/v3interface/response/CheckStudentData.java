package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



/**
 * Name : CheckStudentData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class CheckStudentData {
    @SerializedName("payload")
    private String payload;

    public String getPayload() { return payload; }
}