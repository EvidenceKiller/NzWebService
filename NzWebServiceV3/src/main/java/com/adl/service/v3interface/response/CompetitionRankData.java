package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
