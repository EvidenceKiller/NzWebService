package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
public final class RecordDetailPageData {

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
