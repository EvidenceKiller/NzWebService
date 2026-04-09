package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class BaseGroupRule {
    /**
     * 分组规则
     */
    @SerializedName("empty")
    private boolean empty;

    public boolean getEmpty() {
        return empty;
    }
}
