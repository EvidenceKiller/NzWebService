package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : GetDictsRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetDictsRequest {
    @SerializedName("dictId")
    private String dictId;

    private GetDictsRequest(Builder b) {
        this.dictId = b.dictId;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String dictId;

        public Builder dictId(String v) { this.dictId = v; return this; }

        public GetDictsRequest build() { return new GetDictsRequest(this); }
    }

    public String getDictId() { return dictId; }
}