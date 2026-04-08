package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

public final class AccountInfoRequest {

    /**
     * 路径参数
     */
    @SerializedName("accountId")
    private String accountId;

    private AccountInfoRequest(Builder builder) {
        this.accountId = builder.accountId;
    }

    public static Builder builder(String accountId) {
        return new Builder(accountId);
    }


    public static class Builder {
        private String accountId;

        Builder(String accountId) {
            this.accountId = accountId;
        }

        public AccountInfoRequest build() {
            return new AccountInfoRequest(this);
        }
    }

    public String getAccountId() {
        return accountId;
    }
}