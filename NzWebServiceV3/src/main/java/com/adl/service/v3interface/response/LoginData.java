package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Name : LoginData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class LoginData {
    /** token */
    @SerializedName("accessToken")
    private String accessToken;

    /** token类型 */
    @SerializedName("tokenType")
    private String tokenType;

    @SerializedName("refreshToken")
    private Object refreshToken;

    @SerializedName("expiresIn")
    private double expiresIn;

    @SerializedName("scope")
    private List<Object> scope;

    public String getAccessToken() { return accessToken; }
    public String getTokenType() { return tokenType; }
    public Object getRefreshToken() { return refreshToken; }
    public double getExpiresIn() { return expiresIn; }
    public List<Object> getScope() { return scope; }
}