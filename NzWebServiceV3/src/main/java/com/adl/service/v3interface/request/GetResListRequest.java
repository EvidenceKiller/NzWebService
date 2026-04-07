package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class GetResListRequest {
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

    /** 资源id */
    @SerializedName("id")
    private String id;

    /** 启停用 参考枚举 adl_tis_enabled */
    @SerializedName("enabled")
    private boolean enabled;

    /** 资源类型 参考枚举 adl_tis_res_type */
    @SerializedName("type")
    private int type;

    /** 开始日期 */
    @SerializedName("startTime")
    private String startTime;

    /** 结束日期 */
    @SerializedName("endTime")
    private String endTime;

    /** 资源标题 */
    @SerializedName("title")
    private String title;

    /** 账号 */
    @SerializedName("createNum")
    private String createNum;

    /** 资源类型 1-备课助手 2-校本资源 */
    @SerializedName("resType")
    private int resType;

    /** 应用端代码 */
    @SerializedName("appCode")
    private String appCode;

    /** 分类Id */
    @SerializedName("resTypeId")
    private String resTypeId;

    @SerializedName("ids")
    private List<String> ids;

    private GetResListRequest(Builder b) {
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
        this.id = b.id;
        this.enabled = b.enabled;
        this.type = b.type;
        this.startTime = b.startTime;
        this.endTime = b.endTime;
        this.title = b.title;
        this.createNum = b.createNum;
        this.resType = b.resType;
        this.appCode = b.appCode;
        this.resTypeId = b.resTypeId;
        this.ids = b.ids;
    }

    public static Builder builder(String id) {
        return new Builder(id);
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
        private String id;
        private boolean enabled;
        private int type;
        private String startTime;
        private String endTime;
        private String title;
        private String createNum;
        private int resType;
        private String appCode;
        private String resTypeId;
        private List<String> ids;

        Builder(String id) {
            this.id = id;
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

        public Builder enabled(boolean v) { this.enabled = v; return this; }

        public Builder type(int v) { this.type = v; return this; }

        public Builder startTime(String v) { this.startTime = v; return this; }

        public Builder endTime(String v) { this.endTime = v; return this; }

        public Builder title(String v) { this.title = v; return this; }

        public Builder createNum(String v) { this.createNum = v; return this; }

        public Builder resType(int v) { this.resType = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder resTypeId(String v) { this.resTypeId = v; return this; }

        public Builder ids(List<String> v) { this.ids = v; return this; }

        public GetResListRequest build() { return new GetResListRequest(this); }
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
    public String getId() { return id; }
    public boolean getEnabled() { return enabled; }
    public int getType() { return type; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getTitle() { return title; }
    public String getCreateNum() { return createNum; }
    public int getResType() { return resType; }
    public String getAppCode() { return appCode; }
    public String getResTypeId() { return resTypeId; }
    public List<String> getIds() { return ids; }
}