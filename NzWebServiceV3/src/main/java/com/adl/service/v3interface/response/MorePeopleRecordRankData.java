package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Name : MorePeopleRecordRankData
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口响应数据结构
 */
public final class MorePeopleRecordRankData {
    /** 用户ID */
    @SerializedName("uid")
    private String uid;

    /** 多人对战最新战况 */
    @SerializedName("morePeopleRecordRank")
    private List<Object> morePeopleRecordRank;

    public String getUid() { return uid; }
    public List<Object> getMorePeopleRecordRank() { return morePeopleRecordRank; }
}