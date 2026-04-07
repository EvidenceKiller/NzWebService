package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class GetOrgRecordPageRequest {
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

    /** 组织测试计划标识码 */
    @SerializedName("ptPlanId")
    private String ptPlanId;

    /** 运动类型代码 */
    @SerializedName("sportTypeCode")
    private String sportTypeCode;

    /** 运动单项代码 */
    @SerializedName("sportItemCode")
    private String sportItemCode;

    /** 学期id */
    @SerializedName("semesterId")
    private String semesterId;

    /** 场景Code */
    @SerializedName("sceneCode")
    private String sceneCode;

    /** 应用Code */
    @SerializedName("appCode")
    private String appCode;

    /** 用户ID */
    @SerializedName("accountId")
    private String accountId;

    /** 项目ID */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 年级id */
    @SerializedName("gradeId")
    private String gradeId;

    private GetOrgRecordPageRequest(Builder b) {
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
        this.ptPlanId = b.ptPlanId;
        this.sportTypeCode = b.sportTypeCode;
        this.sportItemCode = b.sportItemCode;
        this.semesterId = b.semesterId;
        this.sceneCode = b.sceneCode;
        this.appCode = b.appCode;
        this.accountId = b.accountId;
        this.sportSkuId = b.sportSkuId;
        this.gradeId = b.gradeId;
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
        private String ptPlanId;
        private String sportTypeCode;
        private String sportItemCode;
        private String semesterId;
        private String sceneCode;
        private String appCode;
        private String accountId;
        private String sportSkuId;
        private String gradeId;

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

        public Builder ptPlanId(String v) { this.ptPlanId = v; return this; }

        public Builder sportTypeCode(String v) { this.sportTypeCode = v; return this; }

        public Builder sportItemCode(String v) { this.sportItemCode = v; return this; }

        public Builder semesterId(String v) { this.semesterId = v; return this; }

        public Builder sceneCode(String v) { this.sceneCode = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder accountId(String v) { this.accountId = v; return this; }

        public Builder sportSkuId(String v) { this.sportSkuId = v; return this; }

        public Builder gradeId(String v) { this.gradeId = v; return this; }

        public GetOrgRecordPageRequest build() { return new GetOrgRecordPageRequest(this); }
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
    public String getPtPlanId() { return ptPlanId; }
    public String getSportTypeCode() { return sportTypeCode; }
    public String getSportItemCode() { return sportItemCode; }
    public String getSemesterId() { return semesterId; }
    public String getSceneCode() { return sceneCode; }
    public String getAppCode() { return appCode; }
    public String getAccountId() { return accountId; }
    public String getSportSkuId() { return sportSkuId; }
    public String getGradeId() { return gradeId; }
}