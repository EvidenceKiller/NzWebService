package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : GetCompetitionListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetCompetitionListRequest {
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

    /** 赛事类型 */
    @SerializedName("onlineType")
    private int onlineType;

    /** 机构ID */
    @SerializedName("orgId")
    private String orgId;

    /** 赛事级别 */
    @SerializedName("competitionLevel")
    private int competitionLevel;

    /** 应用编码 */
    @SerializedName("appCode")
    private String appCode;

    /** 开始时间，时间戳毫秒 */
    @SerializedName("startTime")
    private String startTime;

    /** 结束时间，时间戳毫秒 */
    @SerializedName("endTime")
    private String endTime;

    /** 赛事状态 1未开始 2进行中 3已结束 */
    @SerializedName("competitionEnabled")
    private int competitionEnabled;

    /** 名称/发布人模糊搜索 */
    @SerializedName("keyword")
    private String keyword;

    /** 学期Code */
    @SerializedName("acayearSemCode")
    private String acayearSemCode;

    /** 机构类型 */
    @SerializedName("orgType")
    private int orgType;

    /** 终端标识 */
    @SerializedName("terminalFlag")
    private boolean terminalFlag;

    /** 账户ID */
    @SerializedName("accountId")
    private String accountId;

    /** 排序字段 0 createTime , 1 startTime */
    @SerializedName("sortField")
    private int sortField;

    private GetCompetitionListRequest(Builder b) {
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
        this.onlineType = b.onlineType;
        this.orgId = b.orgId;
        this.competitionLevel = b.competitionLevel;
        this.appCode = b.appCode;
        this.startTime = b.startTime;
        this.endTime = b.endTime;
        this.competitionEnabled = b.competitionEnabled;
        this.keyword = b.keyword;
        this.acayearSemCode = b.acayearSemCode;
        this.orgType = b.orgType;
        this.terminalFlag = b.terminalFlag;
        this.accountId = b.accountId;
        this.sortField = b.sortField;
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
        private int onlineType;
        private String orgId;
        private int competitionLevel;
        private String appCode;
        private String startTime;
        private String endTime;
        private int competitionEnabled;
        private String keyword;
        private String acayearSemCode;
        private int orgType;
        private boolean terminalFlag;
        private String accountId;
        private int sortField;

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

        public Builder onlineType(int v) { this.onlineType = v; return this; }

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder competitionLevel(int v) { this.competitionLevel = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder startTime(String v) { this.startTime = v; return this; }

        public Builder endTime(String v) { this.endTime = v; return this; }

        public Builder competitionEnabled(int v) { this.competitionEnabled = v; return this; }

        public Builder keyword(String v) { this.keyword = v; return this; }

        public Builder acayearSemCode(String v) { this.acayearSemCode = v; return this; }

        public Builder orgType(int v) { this.orgType = v; return this; }

        public Builder terminalFlag(boolean v) { this.terminalFlag = v; return this; }

        public Builder accountId(String v) { this.accountId = v; return this; }

        public Builder sortField(int v) { this.sortField = v; return this; }

        public GetCompetitionListRequest build() { return new GetCompetitionListRequest(this); }
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
    public int getOnlineType() { return onlineType; }
    public String getOrgId() { return orgId; }
    public int getCompetitionLevel() { return competitionLevel; }
    public String getAppCode() { return appCode; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public int getCompetitionEnabled() { return competitionEnabled; }
    public String getKeyword() { return keyword; }
    public String getAcayearSemCode() { return acayearSemCode; }
    public int getOrgType() { return orgType; }
    public boolean getTerminalFlag() { return terminalFlag; }
    public String getAccountId() { return accountId; }
    public int getSortField() { return sortField; }
}