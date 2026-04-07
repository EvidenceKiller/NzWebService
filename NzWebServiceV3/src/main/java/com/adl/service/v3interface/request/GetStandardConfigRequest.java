package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class GetStandardConfigRequest {
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

    /** 测试标准标识码 */
    @SerializedName("standardId")
    private String standardId;

    /** 运动项目标识码 */
    @SerializedName("sportProjectCode")
    private String sportProjectCode;

    /** 测试类型 */
    @SerializedName("standardType")
    private String standardType;

    private GetStandardConfigRequest(Builder b) {
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
        this.standardId = b.standardId;
        this.sportProjectCode = b.sportProjectCode;
        this.standardType = b.standardType;
    }

    public static Builder builder(String standardType) {
        return new Builder(standardType);
    }

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
        private String standardId;
        private String sportProjectCode;
        private String standardType;

        Builder(String standardType) {
            this.standardType = standardType;
        }

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

        public Builder standardId(String v) { this.standardId = v; return this; }

        public Builder sportProjectCode(String v) { this.sportProjectCode = v; return this; }

        public GetStandardConfigRequest build() { return new GetStandardConfigRequest(this); }
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
    public String getStandardId() { return standardId; }
    public String getSportProjectCode() { return sportProjectCode; }
    public String getStandardType() { return standardType; }
}