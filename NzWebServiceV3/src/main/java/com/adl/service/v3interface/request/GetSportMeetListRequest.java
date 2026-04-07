package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : GetSportMeetListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetSportMeetListRequest {
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

    /** 应用端 */
    @SerializedName("appCode")
    private String appCode;

    /** 班级ID列表 */
    @SerializedName("classIds")
    private List<String> classIds;

    /** 机构ID */
    @SerializedName("orgId")
    private String orgId;

    /** 状态 */
    @SerializedName("state")
    private int state;

    /** 关键字 */
    @SerializedName("keyword")
    private String keyword;

    /** ID */
    @SerializedName("id")
    private String id;

    /** 是否显示分组 */
    @SerializedName("showGroup")
    private boolean showGroup;

    /** 检查时间 */
    @SerializedName("checkTime")
    private String checkTime;

    /** 排序字段 0 创建时间降序 1比赛时间降序 */
    @SerializedName("orderByField")
    private int orderByField;

    /** 最后更新时间 */
    @SerializedName("lastUpdateTime")
    private long lastUpdateTime;

    private GetSportMeetListRequest(Builder b) {
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
        this.appCode = b.appCode;
        this.classIds = b.classIds;
        this.orgId = b.orgId;
        this.state = b.state;
        this.keyword = b.keyword;
        this.id = b.id;
        this.showGroup = b.showGroup;
        this.checkTime = b.checkTime;
        this.orderByField = b.orderByField;
        this.lastUpdateTime = b.lastUpdateTime;
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
        private String appCode;
        private List<String> classIds;
        private String orgId;
        private int state;
        private String keyword;
        private String id;
        private boolean showGroup;
        private String checkTime;
        private int orderByField;
        private long lastUpdateTime;

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

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder classIds(List<String> v) { this.classIds = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder state(int v) { this.state = v; return this; }

        public Builder keyword(String v) { this.keyword = v; return this; }

        public Builder id(String v) { this.id = v; return this; }

        public Builder showGroup(boolean v) { this.showGroup = v; return this; }

        public Builder checkTime(String v) { this.checkTime = v; return this; }

        public Builder orderByField(int v) { this.orderByField = v; return this; }

        public Builder lastUpdateTime(long v) { this.lastUpdateTime = v; return this; }

        public GetSportMeetListRequest build() { return new GetSportMeetListRequest(this); }
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
    public String getAppCode() { return appCode; }
    public List<String> getClassIds() { return classIds; }
    public String getOrgId() { return orgId; }
    public int getState() { return state; }
    public String getKeyword() { return keyword; }
    public String getId() { return id; }
    public boolean getShowGroup() { return showGroup; }
    public String getCheckTime() { return checkTime; }
    public int getOrderByField() { return orderByField; }
    public long getLastUpdateTime() { return lastUpdateTime; }
}