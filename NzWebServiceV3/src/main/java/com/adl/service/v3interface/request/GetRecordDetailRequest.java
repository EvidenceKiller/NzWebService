package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class GetRecordDetailRequest {
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

    /** 学院ID */
    @SerializedName("collegeId")
    private String collegeId;

    /** 学系Id */
    @SerializedName("facultyId")
    private String facultyId;

    /** 专业ID */
    @SerializedName("majorId")
    private String majorId;

    /** 学级ID */
    @SerializedName("gradeId")
    private String gradeId;

    /** 班级ID */
    @SerializedName("classId")
    private String classId;

    /** 性别 */
    @SerializedName("sex")
    private String sex;

    /** 项目ID */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /** 端 */
    @SerializedName("appCode")
    private String appCode;

    /** 关键字查询 */
    @SerializedName("keyword")
    private String keyword;

    /** 计划查询 */
    @SerializedName("planId")
    private String planId;

    /** 记录id */
    @SerializedName("recordId")
    private String recordId;

    /** 账号id列表 */
    @SerializedName("accountIds")
    private List<String> accountIds;

    /** 导出Excel标志 */
    @SerializedName("exportExcelFlag")
    private boolean exportExcelFlag;

    /** 转换单位标志，默认为true */
    @SerializedName("convertUnitFlag")
    private boolean convertUnitFlag;

    /** 无效标志 */
    @SerializedName("invalidFlag")
    private int invalidFlag;

    /** 是否违规不能为空 1:违规 */
    @SerializedName("sportViolationStatus")
    private int sportViolationStatus;

    /** 项目高低优 参考字典编码：adl_bms_sport_priority（1 高优 2 低优 9 其它） */
    @SerializedName("sportPriority")
    private int sportPriority;

    /** 是否查询报告 */
    @SerializedName("reportFlag")
    private boolean reportFlag;

    /** 开始时间排序 */
    @SerializedName("startTimeOrder")
    private String startTimeOrder;

    /** 运动开始时间 */
    @SerializedName("sportStartTime")
    private String sportStartTime;

    /** 运动结束时间 */
    @SerializedName("sportEndTime")
    private String sportEndTime;

    /** 不显示视频URL标志，默认为false */
    @SerializedName("dontShowVideoUrl")
    private boolean dontShowVideoUrl;

    private GetRecordDetailRequest(Builder b) {
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
        this.collegeId = b.collegeId;
        this.facultyId = b.facultyId;
        this.majorId = b.majorId;
        this.gradeId = b.gradeId;
        this.classId = b.classId;
        this.sex = b.sex;
        this.sportSkuId = b.sportSkuId;
        this.appCode = b.appCode;
        this.keyword = b.keyword;
        this.planId = b.planId;
        this.recordId = b.recordId;
        this.accountIds = b.accountIds;
        this.exportExcelFlag = b.exportExcelFlag;
        this.convertUnitFlag = b.convertUnitFlag;
        this.invalidFlag = b.invalidFlag;
        this.sportViolationStatus = b.sportViolationStatus;
        this.sportPriority = b.sportPriority;
        this.reportFlag = b.reportFlag;
        this.startTimeOrder = b.startTimeOrder;
        this.sportStartTime = b.sportStartTime;
        this.sportEndTime = b.sportEndTime;
        this.dontShowVideoUrl = b.dontShowVideoUrl;
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
        private String collegeId;
        private String facultyId;
        private String majorId;
        private String gradeId;
        private String classId;
        private String sex;
        private String sportSkuId;
        private String appCode;
        private String keyword;
        private String planId;
        private String recordId;
        private List<String> accountIds;
        private boolean exportExcelFlag;
        private boolean convertUnitFlag;
        private int invalidFlag;
        private int sportViolationStatus;
        private int sportPriority;
        private boolean reportFlag;
        private String startTimeOrder;
        private String sportStartTime;
        private String sportEndTime;
        private boolean dontShowVideoUrl;

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

        public Builder collegeId(String v) { this.collegeId = v; return this; }

        public Builder facultyId(String v) { this.facultyId = v; return this; }

        public Builder majorId(String v) { this.majorId = v; return this; }

        public Builder gradeId(String v) { this.gradeId = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public Builder sex(String v) { this.sex = v; return this; }

        public Builder sportSkuId(String v) { this.sportSkuId = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder keyword(String v) { this.keyword = v; return this; }

        public Builder planId(String v) { this.planId = v; return this; }

        public Builder recordId(String v) { this.recordId = v; return this; }

        public Builder accountIds(List<String> v) { this.accountIds = v; return this; }

        public Builder exportExcelFlag(boolean v) { this.exportExcelFlag = v; return this; }

        public Builder convertUnitFlag(boolean v) { this.convertUnitFlag = v; return this; }

        public Builder invalidFlag(int v) { this.invalidFlag = v; return this; }

        public Builder sportViolationStatus(int v) { this.sportViolationStatus = v; return this; }

        public Builder sportPriority(int v) { this.sportPriority = v; return this; }

        public Builder reportFlag(boolean v) { this.reportFlag = v; return this; }

        public Builder startTimeOrder(String v) { this.startTimeOrder = v; return this; }

        public Builder sportStartTime(String v) { this.sportStartTime = v; return this; }

        public Builder sportEndTime(String v) { this.sportEndTime = v; return this; }

        public Builder dontShowVideoUrl(boolean v) { this.dontShowVideoUrl = v; return this; }

        public GetRecordDetailRequest build() { return new GetRecordDetailRequest(this); }
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
    public String getCollegeId() { return collegeId; }
    public String getFacultyId() { return facultyId; }
    public String getMajorId() { return majorId; }
    public String getGradeId() { return gradeId; }
    public String getClassId() { return classId; }
    public String getSex() { return sex; }
    public String getSportSkuId() { return sportSkuId; }
    public String getAppCode() { return appCode; }
    public String getKeyword() { return keyword; }
    public String getPlanId() { return planId; }
    public String getRecordId() { return recordId; }
    public List<String> getAccountIds() { return accountIds; }
    public boolean getExportExcelFlag() { return exportExcelFlag; }
    public boolean getConvertUnitFlag() { return convertUnitFlag; }
    public int getInvalidFlag() { return invalidFlag; }
    public int getSportViolationStatus() { return sportViolationStatus; }
    public int getSportPriority() { return sportPriority; }
    public boolean getReportFlag() { return reportFlag; }
    public String getStartTimeOrder() { return startTimeOrder; }
    public String getSportStartTime() { return sportStartTime; }
    public String getSportEndTime() { return sportEndTime; }
    public boolean getDontShowVideoUrl() { return dontShowVideoUrl; }
}