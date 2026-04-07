package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class DownloadGroupTeamRequest {
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

    /** 运动会id */
    @SerializedName("meetId")
    private String meetId;

    /** 运动会项目id */
    @SerializedName("meetSportSkuId")
    private String meetSportSkuId;

    /** 比赛轮次 */
    @SerializedName("competitionRound")
    private int competitionRound;

    /** 查看版本时间 */
    @SerializedName("checkTime")
    private String checkTime;

    /** 是否显示详情,false不显示 true显示 默认不显示 */
    @SerializedName("showDetail")
    private boolean showDetail;

    /** tis_competition_meet__type 1集体 2个人 */
    @SerializedName("competitionType")
    private int competitionType;

    /** 来源是否是终端 */
    @SerializedName("deviceFlag")
    private boolean deviceFlag;

    /** 结果标识 */
    @SerializedName("result")
    private boolean result;

    private DownloadGroupTeamRequest(Builder b) {
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
        this.meetId = b.meetId;
        this.meetSportSkuId = b.meetSportSkuId;
        this.competitionRound = b.competitionRound;
        this.checkTime = b.checkTime;
        this.showDetail = b.showDetail;
        this.competitionType = b.competitionType;
        this.deviceFlag = b.deviceFlag;
        this.result = b.result;
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
        private String meetId;
        private String meetSportSkuId;
        private int competitionRound;
        private String checkTime;
        private boolean showDetail;
        private int competitionType;
        private boolean deviceFlag;
        private boolean result;

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

        public Builder meetId(String v) { this.meetId = v; return this; }

        public Builder meetSportSkuId(String v) { this.meetSportSkuId = v; return this; }

        public Builder competitionRound(int v) { this.competitionRound = v; return this; }

        public Builder checkTime(String v) { this.checkTime = v; return this; }

        public Builder showDetail(boolean v) { this.showDetail = v; return this; }

        public Builder competitionType(int v) { this.competitionType = v; return this; }

        public Builder deviceFlag(boolean v) { this.deviceFlag = v; return this; }

        public Builder result(boolean v) { this.result = v; return this; }

        public DownloadGroupTeamRequest build() { return new DownloadGroupTeamRequest(this); }
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
    public String getMeetId() { return meetId; }
    public String getMeetSportSkuId() { return meetSportSkuId; }
    public int getCompetitionRound() { return competitionRound; }
    public String getCheckTime() { return checkTime; }
    public boolean getShowDetail() { return showDetail; }
    public int getCompetitionType() { return competitionType; }
    public boolean getDeviceFlag() { return deviceFlag; }
    public boolean getResult() { return result; }
}