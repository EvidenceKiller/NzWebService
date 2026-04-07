package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : CheckStudentRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class CheckStudentRequest {
    /** 计划 id */
    @SerializedName("planId")
    private String planId;

    /** 账号 id */
    @SerializedName("accountId")
    private String accountId;

    private CheckStudentRequest(Builder b) {
        this.planId = b.planId;
        this.accountId = b.accountId;
    }

    public static Builder builder(String planId) {
        return new Builder(planId);
    }

    public static class Builder {
        private String planId;
        private String accountId;

        Builder(String planId) {
            this.planId = planId;
        }

        public Builder accountId(String v) { this.accountId = v; return this; }

        public CheckStudentRequest build() { return new CheckStudentRequest(this); }
    }

    public String getPlanId() { return planId; }
    public String getAccountId() { return accountId; }
}