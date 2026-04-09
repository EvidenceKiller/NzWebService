package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString
public final class CompetitionRankData {

    /**
     * 我的排名
     */
    @SerializedName("myRank")
    private CompetitionMyRankData myRank;

    /**
     * 排行榜列表
     */
    @SerializedName("rankList")
    private List<Object> rankList;

    public Object getMyRank() {
        return myRank;
    }

    public List<Object> getRankList() {
        return rankList;
    }
}
