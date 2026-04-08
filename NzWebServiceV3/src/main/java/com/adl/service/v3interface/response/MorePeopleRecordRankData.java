package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    public String getUid() {
        return uid;
    }

    public List<Object> getMorePeopleRecordRank() {
        return morePeopleRecordRank;
    }
}
