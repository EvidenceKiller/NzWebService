package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
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
    private double expiresIn;

    @SerializedName("scope")
    private List<Object> scope;
}
