package com.adl.service.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class ReportSportCompetitionData implements Serializable {
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
    private Boolean competitionCheckStatus = Boolean.FALSE;

    /**
     * 完成状态
     */
    @SerializedName("competitionTaskStatus")
    private Boolean competitionTaskStatus = Boolean.FALSE;
}
