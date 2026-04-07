package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : GetStudentListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetStudentListRequest {
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

    /** 机构id */
    @SerializedName("orgId")
    private String orgId;

    /** 账户类型 */
    @SerializedName("accountType")
    private int accountType;

    /** 最后更新时间 */
    @SerializedName("lastUpdateTime")
    private String lastUpdateTime;

    /** 学年代码 */
    @SerializedName("acayearSem")
    private String acayearSem;

    /** 学期代码 */
    @SerializedName("acayearSemCode")
    private String acayearSemCode;

    /** 1 百度 2 商汤 */
    @SerializedName("faceType")
    private int faceType;

    @SerializedName("delFlag")
    private boolean delFlag;

    private GetStudentListRequest(Builder b) {
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
        this.accountType = b.accountType;
        this.lastUpdateTime = b.lastUpdateTime;
        this.acayearSem = b.acayearSem;
        this.acayearSemCode = b.acayearSemCode;
        this.faceType = b.faceType;
        this.delFlag = b.delFlag;
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
        private int accountType;
        private String lastUpdateTime;
        private String acayearSem;
        private String acayearSemCode;
        private int faceType;
        private boolean delFlag;

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

        public Builder accountType(int v) { this.accountType = v; return this; }

        public Builder lastUpdateTime(String v) { this.lastUpdateTime = v; return this; }

        public Builder acayearSem(String v) { this.acayearSem = v; return this; }

        public Builder acayearSemCode(String v) { this.acayearSemCode = v; return this; }

        public Builder faceType(int v) { this.faceType = v; return this; }

        public Builder delFlag(boolean v) { this.delFlag = v; return this; }

        public GetStudentListRequest build() { return new GetStudentListRequest(this); }
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
    public int getAccountType() { return accountType; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public String getAcayearSem() { return acayearSem; }
    public String getAcayearSemCode() { return acayearSemCode; }
    public int getFaceType() { return faceType; }
    public boolean getDelFlag() { return delFlag; }
}