package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

public final class BaseSort {
    @SerializedName("direction")
    private BaseDirection direction;
    @SerializedName("column")
    private String column;

    public BaseDirection getDirection() {
        return direction;
    }

    public String getColumn() {
        return column;
    }
}
