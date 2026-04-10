package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class DictMapData {

    @SerializedName("dict")
    private String dict;

    @SerializedName("rightKey")
    private String rightKey;

    @SerializedName("wrongKey")
    private String wrongKey;

    @SerializedName("type")
    private String type;
}
