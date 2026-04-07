package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : GetPlanListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetPlanListRequest {
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

    /** 机构ID */
    @SerializedName("orgId")
    private String orgId;

    /** 测试类型 */
    @SerializedName("standardType")
    private String standardType;

    /** 学年 */
    @SerializedName("acayearCode")
    private String acayearCode;

    /** 状态 1未开始 2进行中 3已结束 */
    @SerializedName("status")
    private String status;

    /** 是否显示统计 */
    @SerializedName("showStatistic")
    private boolean showStatistic;

    /** 计划ID */
    @SerializedName("planId")
    private String planId;

    private GetPlanListRequest(Builder b) {
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
        this.orgId = b.orgId;
        this.standardType = b.standardType;
        this.acayearCode = b.acayearCode;
        this.status = b.status;
        this.showStatistic = b.showStatistic;
        this.planId = b.planId;
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
        private String orgId;
        private String standardType;
        private String acayearCode;
        private String status;
        private boolean showStatistic;
        private String planId;

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

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder standardType(String v) { this.standardType = v; return this; }

        public Builder acayearCode(String v) { this.acayearCode = v; return this; }

        public Builder status(String v) { this.status = v; return this; }

        public Builder showStatistic(boolean v) { this.showStatistic = v; return this; }

        public Builder planId(String v) { this.planId = v; return this; }

        public GetPlanListRequest build() { return new GetPlanListRequest(this); }
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
    public String getOrgId() { return orgId; }
    public String getStandardType() { return standardType; }
    public String getAcayearCode() { return acayearCode; }
    public String getStatus() { return status; }
    public boolean getShowStatistic() { return showStatistic; }
    public String getPlanId() { return planId; }
}