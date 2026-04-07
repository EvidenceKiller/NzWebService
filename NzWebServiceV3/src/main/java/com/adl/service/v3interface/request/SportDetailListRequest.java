package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class SportDetailListRequest {
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
    private List<Map<String, Object>> sorts;

    /** 枚举值: ASC,DESC */
    @SerializedName("direction")
    private String direction;

    @SerializedName("column")
    private String column;

    @SerializedName("sortsStr")
    private String sortsStr;

    @SerializedName("ignoreColumns")
    private List<String> ignoreColumns;

    @SerializedName("containColumns")
    private List<String> containColumns;

    @SerializedName("moduleStr")
    private String moduleStr;

    /** 学期Id */
    @SerializedName("semesterId")
    private String semesterId;

    /** 机构Id */
    @SerializedName("orgId")
    private String orgId;

    /** 日期 */
    @SerializedName("date")
    private String date;

    private SportDetailListRequest(Builder b) {
        this.noPaging = b.noPaging;
        this.pageSize = b.pageSize;
        this.current = b.current;
        this.detail = b.detail;
        this.enableSort = b.enableSort;
        this.sorts = b.sorts;
        this.direction = b.direction;
        this.column = b.column;
        this.sortsStr = b.sortsStr;
        this.ignoreColumns = b.ignoreColumns;
        this.containColumns = b.containColumns;
        this.moduleStr = b.moduleStr;
        this.semesterId = b.semesterId;
        this.orgId = b.orgId;
        this.date = b.date;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private boolean noPaging;
        private long pageSize;
        private long current;
        private boolean detail;
        private boolean enableSort;
        private List<Map<String, Object>> sorts;
        private String direction;
        private String column;
        private String sortsStr;
        private List<String> ignoreColumns;
        private List<String> containColumns;
        private String moduleStr;
        private String semesterId;
        private String orgId;
        private String date;

        public Builder noPaging(boolean v) { this.noPaging = v; return this; }

        public Builder pageSize(long v) { this.pageSize = v; return this; }

        public Builder current(long v) { this.current = v; return this; }

        public Builder detail(boolean v) { this.detail = v; return this; }

        public Builder enableSort(boolean v) { this.enableSort = v; return this; }

        public Builder sorts(List<Map<String, Object>> v) { this.sorts = v; return this; }

        public Builder direction(String v) { this.direction = v; return this; }

        public Builder column(String v) { this.column = v; return this; }

        public Builder sortsStr(String v) { this.sortsStr = v; return this; }

        public Builder ignoreColumns(List<String> v) { this.ignoreColumns = v; return this; }

        public Builder containColumns(List<String> v) { this.containColumns = v; return this; }

        public Builder moduleStr(String v) { this.moduleStr = v; return this; }

        public Builder semesterId(String v) { this.semesterId = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder date(String v) { this.date = v; return this; }

        public SportDetailListRequest build() { return new SportDetailListRequest(this); }
    }

    public boolean getNoPaging() { return noPaging; }
    public long getPageSize() { return pageSize; }
    public long getCurrent() { return current; }
    public boolean getDetail() { return detail; }
    public boolean getEnableSort() { return enableSort; }
    public List<Map<String, Object>> getSorts() { return sorts; }
    public String getDirection() { return direction; }
    public String getColumn() { return column; }
    public String getSortsStr() { return sortsStr; }
    public List<String> getIgnoreColumns() { return ignoreColumns; }
    public List<String> getContainColumns() { return containColumns; }
    public String getModuleStr() { return moduleStr; }
    public String getSemesterId() { return semesterId; }
    public String getOrgId() { return orgId; }
    public String getDate() { return date; }
}