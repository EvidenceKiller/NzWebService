package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class BaseLoginAccountGrade {
    /**
     */
    @SerializedName("label")
    private String label;

    /**
     */
    @SerializedName("value")
    private String value;
}
