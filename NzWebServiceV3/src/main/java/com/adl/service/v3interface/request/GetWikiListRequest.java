package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : GetWikiListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetWikiListRequest {
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

    /** 标题 */
    @SerializedName("keyword")
    private String keyword;

    /** 内容形式 */
    @SerializedName("wikiType")
    private String wikiType;

    /** 分类ID */
    @SerializedName("wikiTypeId")
    private String wikiTypeId;

    /** 状态 */
    @SerializedName("enabled")
    private String enabled;

    /** 应用编码 */
    @SerializedName("appCode")
    private String appCode;

    /** 机构id */
    @SerializedName("orgId")
    private String orgId;

    private GetWikiListRequest(Builder b) {
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
        this.keyword = b.keyword;
        this.wikiType = b.wikiType;
        this.wikiTypeId = b.wikiTypeId;
        this.enabled = b.enabled;
        this.appCode = b.appCode;
        this.orgId = b.orgId;
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
        private String keyword;
        private String wikiType;
        private String wikiTypeId;
        private String enabled;
        private String appCode;
        private String orgId;

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

        public Builder keyword(String v) { this.keyword = v; return this; }

        public Builder wikiType(String v) { this.wikiType = v; return this; }

        public Builder wikiTypeId(String v) { this.wikiTypeId = v; return this; }

        public Builder enabled(String v) { this.enabled = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public GetWikiListRequest build() { return new GetWikiListRequest(this); }
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
    public String getKeyword() { return keyword; }
    public String getWikiType() { return wikiType; }
    public String getWikiTypeId() { return wikiTypeId; }
    public String getEnabled() { return enabled; }
    public String getAppCode() { return appCode; }
    public String getOrgId() { return orgId; }
}