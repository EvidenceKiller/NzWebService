package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

public final class DictMapData {

    @SerializedName("dict")
    private String dict;

    @SerializedName("rightKey")
    private String rightKey;

    @SerializedName("wrongKey")
    private String wrongKey;

    @SerializedName("type")
    private String type;

    public String getDict() {
        return dict;
    }

    public String getRightKey() {
        return rightKey;
    }

    public String getWrongKey() {
        return wrongKey;
    }

    public String getType() {
        return type;
    }
}
