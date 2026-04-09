package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class DownloadGroupTeamPageRequest extends BasePageRequest {

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

    private DownloadGroupTeamPageRequest(Builder builder) {
        super(builder);
        this.meetId = builder.meetId;
        this.meetSportSkuId = builder.meetSportSkuId;
        this.competitionRound = builder.competitionRound;
        this.checkTime = builder.checkTime;
        this.showDetail = builder.showDetail;
        this.competitionType = builder.competitionType;
        this.deviceFlag = builder.deviceFlag;
        this.result = builder.result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BasePageRequest.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
        private String meetId;
        private String meetSportSkuId;
        private int competitionRound;
        private String checkTime;
        private boolean showDetail;
        private int competitionType;
        private boolean deviceFlag;
        private boolean result;
        public Builder meetId(String meetId) {
            this.meetId = meetId;
            return this;
        }
        public Builder meetSportSkuId(String meetSportSkuId) {
            this.meetSportSkuId = meetSportSkuId;
            return this;
        }
        public Builder competitionRound(int competitionRound) {
            this.competitionRound = competitionRound;
            return this;
        }
        public Builder checkTime(String checkTime) {
            this.checkTime = checkTime;
            return this;
        }
        public Builder showDetail(boolean showDetail) {
            this.showDetail = showDetail;
            return this;
        }
        public Builder competitionType(int competitionType) {
            this.competitionType = competitionType;
            return this;
        }
        public Builder deviceFlag(boolean deviceFlag) {
            this.deviceFlag = deviceFlag;
            return this;
        }
        public Builder result(boolean result) {
            this.result = result;
            return this;
        }

        public DownloadGroupTeamPageRequest build() { return new DownloadGroupTeamPageRequest(this); }
    }
    public String getMeetId() { return meetId; }
    public String getMeetSportSkuId() { return meetSportSkuId; }
    public int getCompetitionRound() { return competitionRound; }
    public String getCheckTime() { return checkTime; }
    public boolean getShowDetail() { return showDetail; }
    public int getCompetitionType() { return competitionType; }
    public boolean getDeviceFlag() { return deviceFlag; }
    public boolean getResult() { return result; }
}