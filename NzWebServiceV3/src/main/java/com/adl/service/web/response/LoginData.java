package com.adl.service.web.response;

import com.adl.service.internal.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonAdapter(StrictJsonDeserializer.class)
public final class LoginData {

    /**
     * token
     */
    @SerializedName("accessToken")
    private String accessToken;

    /**
     * token类型
     */
    @SerializedName("tokenType")
    private String tokenType;

    @SerializedName("refreshToken")
    private String refreshToken;

    @SerializedName("expiresIn")
    private Double expiresIn;

    @SerializedName("scope")
    private List<Object> scope;
}
