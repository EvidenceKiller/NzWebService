package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public final class AddBatchRequest {
    @SerializedName("noPaging")
    private boolean noPaging;

    @SerializedName("pageSize")
    private long pageSize;

    @SerializedName("current")
    private long current;

    @SerializedName("detail")
    private boolean detail;

    @SerializedName("enableSort")
    private boolean enableSort;

    @SerializedName("sorts")
    private List<Object> sorts;

    @SerializedName("sortsStr")
    private String sortsStr;

    @SerializedName("ignoreColumns")
    private List<Object> ignoreColumns;

    @SerializedName("containColumns")
    private List<Object> containColumns;

    @SerializedName("moduleStr")
    private String moduleStr;

    /** 产品编码 */
    @SerializedName("productCode")
    private String productCode;

    /** 应用编码 */
    @SerializedName("appCode")
    private String appCode;

    /** 日志级别 常规日志级别，通常为 info(默认) warn error fatal debug trace */
    @SerializedName("level")
    private String level;

    /** 日志标签，用来快速查询日志信息，由各业务端自行定义 */
    @SerializedName("tags")
    private List<Object> tags;

    /** 日志内容 */
    @SerializedName("content")
    private String content;

    /** 日志过期时间，单位秒，范围在 86400 到 86400*60 即 1-7 天之间，如果不传默认存储 1 天 */
    @SerializedName("expireTime")
    private long expireTime;

    private AddBatchRequest(Builder b) {
        this.noPaging = b.noPaging;
        this.pageSize = b.pageSize;
        this.current = b.current;
        this.detail = b.detail;
        this.enableSort = b.enableSort;
        this.sorts = b.sorts;
        this.sortsStr = b.sortsStr;
        this.ignoreColumns = b.ignoreColumns;
        this.containColumns = b.containColumns;
        this.moduleStr = b.moduleStr;
        this.productCode = b.productCode;
        this.appCode = b.appCode;
        this.level = b.level;
        this.tags = b.tags;
        this.content = b.content;
        this.expireTime = b.expireTime;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private boolean noPaging;
        private long pageSize;
        private long current;
        private boolean detail;
        private boolean enableSort;
        private List<Object> sorts;
        private String sortsStr;
        private List<Object> ignoreColumns;
        private List<Object> containColumns;
        private String moduleStr;
        private String productCode;
        private String appCode;
        private String level;
        private List<Object> tags;
        private String content;
        private long expireTime;

        public Builder noPaging(boolean v) { this.noPaging = v; return this; }

        public Builder pageSize(long v) { this.pageSize = v; return this; }

        public Builder current(long v) { this.current = v; return this; }

        public Builder detail(boolean v) { this.detail = v; return this; }

        public Builder enableSort(boolean v) { this.enableSort = v; return this; }

        public Builder sorts(List<Object> v) { this.sorts = v; return this; }

        public Builder sortsStr(String v) { this.sortsStr = v; return this; }

        public Builder ignoreColumns(List<Object> v) { this.ignoreColumns = v; return this; }

        public Builder containColumns(List<Object> v) { this.containColumns = v; return this; }

        public Builder moduleStr(String v) { this.moduleStr = v; return this; }

        public Builder productCode(String v) { this.productCode = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder level(String v) { this.level = v; return this; }

        public Builder tags(List<Object> v) { this.tags = v; return this; }

        public Builder content(String v) { this.content = v; return this; }

        public Builder expireTime(long v) { this.expireTime = v; return this; }

        public AddBatchRequest build() { return new AddBatchRequest(this); }
    }

    public boolean getNoPaging() { return noPaging; }
    public long getPageSize() { return pageSize; }
    public long getCurrent() { return current; }
    public boolean getDetail() { return detail; }
    public boolean getEnableSort() { return enableSort; }
    public List<Object> getSorts() { return sorts; }
    public String getSortsStr() { return sortsStr; }
    public List<Object> getIgnoreColumns() { return ignoreColumns; }
    public List<Object> getContainColumns() { return containColumns; }
    public String getModuleStr() { return moduleStr; }
    public String getProductCode() { return productCode; }
    public String getAppCode() { return appCode; }
    public String getLevel() { return level; }
    public List<Object> getTags() { return tags; }
    public String getContent() { return content; }
    public long getExpireTime() { return expireTime; }
}