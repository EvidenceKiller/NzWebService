package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : GetTrainPlanInfoListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetTrainPlanInfoListRequest {
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

    /** 关键字 训练计划/姓名 */
    @SerializedName("keyword")
    private String keyword;

    /** 机构id */
    @SerializedName("orgId")
    private String orgId;

    /** 计划id */
    @SerializedName("uid")
    private String uid;

    /** 状态 1：未开始 2:进行中 3：已结束 */
    @SerializedName("timeStatus")
    private String timeStatus;

    /** 年级id */
    @SerializedName("gradeUid")
    private String gradeUid;

    /** 班级id */
    @SerializedName("classUid")
    private String classUid;

    /** 计划日期 */
    @SerializedName("trainPlanTime")
    private String trainPlanTime;

    /** 运动日期 */
    @SerializedName("sportTime")
    private String sportTime;

    /** 计划开始时间 */
    @SerializedName("trainPlanStartTime")
    private String trainPlanStartTime;

    /** 计划结束时间 */
    @SerializedName("trainPlanEndTime")
    private String trainPlanEndTime;

    /** 运动开始时间 */
    @SerializedName("sportStarTime")
    private String sportStarTime;

    /** 运动结束时间 */
    @SerializedName("sportEndTime")
    private String sportEndTime;

    /** 学期编码 */
    @SerializedName("acayearSemCode")
    private String acayearSemCode;

    /** 特训人员id */
    @SerializedName("accountId")
    private String accountId;

    /** 特训计划id */
    @SerializedName("trainPlanIds")
    private List<String> trainPlanIds;

    private GetTrainPlanInfoListRequest(Builder b) {
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
        this.orgId = b.orgId;
        this.uid = b.uid;
        this.timeStatus = b.timeStatus;
        this.gradeUid = b.gradeUid;
        this.classUid = b.classUid;
        this.trainPlanTime = b.trainPlanTime;
        this.sportTime = b.sportTime;
        this.trainPlanStartTime = b.trainPlanStartTime;
        this.trainPlanEndTime = b.trainPlanEndTime;
        this.sportStarTime = b.sportStarTime;
        this.sportEndTime = b.sportEndTime;
        this.acayearSemCode = b.acayearSemCode;
        this.accountId = b.accountId;
        this.trainPlanIds = b.trainPlanIds;
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
        private String orgId;
        private String uid;
        private String timeStatus;
        private String gradeUid;
        private String classUid;
        private String trainPlanTime;
        private String sportTime;
        private String trainPlanStartTime;
        private String trainPlanEndTime;
        private String sportStarTime;
        private String sportEndTime;
        private String acayearSemCode;
        private String accountId;
        private List<String> trainPlanIds;

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

        public Builder orgId(String v) { this.orgId = v; return this; }

        public Builder uid(String v) { this.uid = v; return this; }

        public Builder timeStatus(String v) { this.timeStatus = v; return this; }

        public Builder gradeUid(String v) { this.gradeUid = v; return this; }

        public Builder classUid(String v) { this.classUid = v; return this; }

        public Builder trainPlanTime(String v) { this.trainPlanTime = v; return this; }

        public Builder sportTime(String v) { this.sportTime = v; return this; }

        public Builder trainPlanStartTime(String v) { this.trainPlanStartTime = v; return this; }

        public Builder trainPlanEndTime(String v) { this.trainPlanEndTime = v; return this; }

        public Builder sportStarTime(String v) { this.sportStarTime = v; return this; }

        public Builder sportEndTime(String v) { this.sportEndTime = v; return this; }

        public Builder acayearSemCode(String v) { this.acayearSemCode = v; return this; }

        public Builder accountId(String v) { this.accountId = v; return this; }

        public Builder trainPlanIds(List<String> v) { this.trainPlanIds = v; return this; }

        public GetTrainPlanInfoListRequest build() { return new GetTrainPlanInfoListRequest(this); }
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
    public String getOrgId() { return orgId; }
    public String getUid() { return uid; }
    public String getTimeStatus() { return timeStatus; }
    public String getGradeUid() { return gradeUid; }
    public String getClassUid() { return classUid; }
    public String getTrainPlanTime() { return trainPlanTime; }
    public String getSportTime() { return sportTime; }
    public String getTrainPlanStartTime() { return trainPlanStartTime; }
    public String getTrainPlanEndTime() { return trainPlanEndTime; }
    public String getSportStarTime() { return sportStarTime; }
    public String getSportEndTime() { return sportEndTime; }
    public String getAcayearSemCode() { return acayearSemCode; }
    public String getAccountId() { return accountId; }
    public List<String> getTrainPlanIds() { return trainPlanIds; }
}