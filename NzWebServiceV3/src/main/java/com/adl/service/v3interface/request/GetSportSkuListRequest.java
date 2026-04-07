package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Name : GetSportSkuListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetSportSkuListRequest {
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

    /** 运动性质 */
    @SerializedName("sportNature")
    private String sportNature;

    /** 运动类型编码 */
    @SerializedName("sportType")
    private String sportType;

    /** 关键字，根据项目/单项名称或代码模糊搜索 */
    @SerializedName("keyword")
    private String keyword;

    /** 模板标识 */
    @SerializedName("templateFlag")
    private int templateFlag;

    /** ID列表 */
    @SerializedName("ids")
    private List<String> ids;

    /** 应用编码列表 */
    @SerializedName("appCodes")
    private List<String> appCodes;

    /** 应用编码 */
    @SerializedName("appCode")
    private String appCode;

    /** 场景ID */
    @SerializedName("sceneId")
    private String sceneId;

    /** 删除标志 */
    @SerializedName("delFlag")
    private boolean delFlag;

    /** 启用状态 */
    @SerializedName("enabled")
    private boolean enabled;

    private GetSportSkuListRequest(Builder b) {
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
        this.sportNature = b.sportNature;
        this.sportType = b.sportType;
        this.keyword = b.keyword;
        this.templateFlag = b.templateFlag;
        this.ids = b.ids;
        this.appCodes = b.appCodes;
        this.appCode = b.appCode;
        this.sceneId = b.sceneId;
        this.delFlag = b.delFlag;
        this.enabled = b.enabled;
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
        private String sportNature;
        private String sportType;
        private String keyword;
        private int templateFlag;
        private List<String> ids;
        private List<String> appCodes;
        private String appCode;
        private String sceneId;
        private boolean delFlag;
        private boolean enabled;

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

        public Builder sportNature(String v) { this.sportNature = v; return this; }

        public Builder sportType(String v) { this.sportType = v; return this; }

        public Builder keyword(String v) { this.keyword = v; return this; }

        public Builder templateFlag(int v) { this.templateFlag = v; return this; }

        public Builder ids(List<String> v) { this.ids = v; return this; }

        public Builder appCodes(List<String> v) { this.appCodes = v; return this; }

        public Builder appCode(String v) { this.appCode = v; return this; }

        public Builder sceneId(String v) { this.sceneId = v; return this; }

        public Builder delFlag(boolean v) { this.delFlag = v; return this; }

        public Builder enabled(boolean v) { this.enabled = v; return this; }

        public GetSportSkuListRequest build() { return new GetSportSkuListRequest(this); }
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
    public String getSportNature() { return sportNature; }
    public String getSportType() { return sportType; }
    public String getKeyword() { return keyword; }
    public int getTemplateFlag() { return templateFlag; }
    public List<String> getIds() { return ids; }
    public List<String> getAppCodes() { return appCodes; }
    public String getAppCode() { return appCode; }
    public String getSceneId() { return sceneId; }
    public boolean getDelFlag() { return delFlag; }
    public boolean getEnabled() { return enabled; }
}