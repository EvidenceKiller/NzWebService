package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class OrgRecordPageData {

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

    public List<Object> getRecords() {
        return records;
    }

    public long getTotal() {
        return total;
    }

    public long getSize() {
        return size;
    }

    public long getCurrent() {
        return current;
    }

    public List<Object> getOrders() {
        return orders;
    }

    public Object getOptimizeCountSql() {
        return optimizeCountSql;
    }

    public Object getSearchCount() {
        return searchCount;
    }

    public boolean getOptimizeJoinOfCountSql() {
        return optimizeJoinOfCountSql;
    }

    public long getMaxLimit() {
        return maxLimit;
    }

    public String getCountId() {
        return countId;
    }

    public long getPages() {
        return pages;
    }
}
