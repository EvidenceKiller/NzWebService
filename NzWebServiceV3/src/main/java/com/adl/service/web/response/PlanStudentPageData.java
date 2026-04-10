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
public final class PlanStudentPageData {

    @SerializedName("records")
    private List<Object> records;

    @SerializedName("total")
    private long total;

    @SerializedName("size")
    private long size;

    @SerializedName("current")
    private long current;

    @SerializedName("orders")
    private List<Object> orders;

    @SerializedName("optimizeCountSql")
    private Object optimizeCountSql;

    @SerializedName("searchCount")
    private Object searchCount;

    @SerializedName("optimizeJoinOfCountSql")
    private boolean optimizeJoinOfCountSql;

    @SerializedName("maxLimit")
    private long maxLimit;

    @SerializedName("countId")
    private String countId;

    @SerializedName("pages")
    private long pages;
}
