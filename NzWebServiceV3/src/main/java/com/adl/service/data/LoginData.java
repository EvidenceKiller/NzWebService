package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class LoginData implements Serializable {

    /**
     * token
     */
    @SerializedName("access_token")
    private String accessToken;

    /**
     * token类型
     */
    @SerializedName("token_type")
    private Integer tokenType = 0;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("expires_in")
    private Double expiresIn = 0.0;

    @SerializedName("scope")
    private String scope;
}
