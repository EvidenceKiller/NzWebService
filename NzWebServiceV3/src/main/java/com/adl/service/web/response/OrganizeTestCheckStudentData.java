package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public final class OrganizeTestCheckStudentData {

    @SerializedName("payload")
    private String payload;

    public String getPayload() { return payload; }
}
