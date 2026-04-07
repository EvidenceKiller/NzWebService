package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class GetClassListRequest {
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

    /** 机构标识码 */
    @SerializedName("orgId")
    private String orgId;

    /** 年级编码 */
    @SerializedName("gradeCode")
    private String gradeCode;

    /** 学年学期code */
    @SerializedName("acayearSem")
    private String acayearSem;

    /** 年级编码 */
    @SerializedName("keyword")
    private String keyword;

    /** 学院id */
    @SerializedName("collegeId")
    private String collegeId;

    /** 学系id */
    @SerializedName("facultyId")
    private String facultyId;

    /** 专业id */
    @SerializedName("majorId")
    private String majorId;

    private GetClassListRequest(Builder b) {
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
        this.gradeCode = b.gradeCode;
        this.acayearSem = b.acayearSem;
        this.keyword = b.keyword;
        this.collegeId = b.collegeId;
        this.facultyId = b.facultyId;
        this.majorId = b.majorId;
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
        private String gradeCode;
        private String acayearSem;
        private String keyword;
        private String collegeId;
        private String facultyId;
        private String majorId;

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

        public Builder gradeCode(String v) { this.gradeCode = v; return this; }

        public Builder acayearSem(String v) { this.acayearSem = v; return this; }

        public Builder keyword(String v) { this.keyword = v; return this; }

        public Builder collegeId(String v) { this.collegeId = v; return this; }

        public Builder facultyId(String v) { this.facultyId = v; return this; }

        public Builder majorId(String v) { this.majorId = v; return this; }

        public GetClassListRequest build() { return new GetClassListRequest(this); }
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
    public String getGradeCode() { return gradeCode; }
    public String getAcayearSem() { return acayearSem; }
    public String getKeyword() { return keyword; }
    public String getCollegeId() { return collegeId; }
    public String getFacultyId() { return facultyId; }
    public String getMajorId() { return majorId; }
}