package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



/**
 * Name : GetDictMapData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class GetDictMapData {
    @SerializedName("dict")
    private String dict;

    @SerializedName("rightKey")
    private String rightKey;

    @SerializedName("wrongKey")
    private String wrongKey;

    @SerializedName("type")
    private String type;

    public String getDict() { return dict; }
    public String getRightKey() { return rightKey; }
    public String getWrongKey() { return wrongKey; }
    public String getType() { return type; }
}