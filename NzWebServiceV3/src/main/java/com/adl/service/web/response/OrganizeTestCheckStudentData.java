package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class OrganizeTestCheckStudentData {

    @SerializedName("payload")
    private String payload;
}
