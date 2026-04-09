package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class BaseCompetitionAthletics {
    /**
     * 赛事id
     */
    @SerializedName("competitionId")
    private String competitionId;

    /**
     * 赛事名称
     */
    @SerializedName("competitionName")
    private String competitionName;

    /**
     * 赛事运动id
     */
    @SerializedName("competitionAthSportId")
    private String competitionAthSportId;

    /**
     * 赛事运动名称
     */
    @SerializedName("competitionAthSportName")
    private String competitionAthSportName;

    /**
     * 打卡状态
     */
    @SerializedName("competitionCheckStatus")
    private Boolean competitionCheckStatus;

    /**
     * 完成状态
     */
    @SerializedName("competitionTaskStatus")
    private Boolean competitionTaskStatus;

    public String getCompetitionId() {
        return competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getCompetitionAthSportId() {
        return competitionAthSportId;
    }

    public String getCompetitionAthSportName() {
        return competitionAthSportName;
    }

    public Boolean getCompetitionCheckStatus() {
        return competitionCheckStatus;
    }

    public Boolean getCompetitionTaskStatus() {
        return competitionTaskStatus;
    }
}
