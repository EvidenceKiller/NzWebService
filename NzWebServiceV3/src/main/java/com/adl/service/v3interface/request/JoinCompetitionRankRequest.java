package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : JoinCompetitionRankRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class JoinCompetitionRankRequest {
    /** ID */
    @SerializedName("id")
    private String id;

    /** 账户ID */
    @SerializedName("accountId")
    private String accountId;

    /** 班级ID */
    @SerializedName("classId")
    private String classId;

    private JoinCompetitionRankRequest(Builder b) {
        this.id = b.id;
        this.accountId = b.accountId;
        this.classId = b.classId;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String id;
        private String accountId;
        private String classId;

        public Builder id(String v) { this.id = v; return this; }

        public Builder accountId(String v) { this.accountId = v; return this; }

        public Builder classId(String v) { this.classId = v; return this; }

        public JoinCompetitionRankRequest build() { return new JoinCompetitionRankRequest(this); }
    }

    public String getId() { return id; }
    public String getAccountId() { return accountId; }
    public String getClassId() { return classId; }
}