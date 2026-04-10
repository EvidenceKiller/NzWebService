package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
public final class MorePeopleRecordRankData {

    /**
     * 用户ID
     */
    @SerializedName("uid")
    private String uid;

    /**
     * 多人对战最新战况
     */
    @SerializedName("morePeopleRecordRank")
    private List<Object> morePeopleRecordRank;
}
