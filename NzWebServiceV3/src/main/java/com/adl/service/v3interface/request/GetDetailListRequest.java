package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



/**
 * Name : GetDetailListRequest
 * Author : zhouxiangnan
 * Date : 2026/4/7
 * Describe : 定义接口请求参数结构
 */
public final class GetDetailListRequest {
    @SerializedName("id")
    private String id;

    @SerializedName("wikiId")
    private String wikiId;

    private GetDetailListRequest(Builder b) {
        this.id = b.id;
        this.wikiId = b.wikiId;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String id;
        private String wikiId;

        public Builder id(String v) { this.id = v; return this; }

        public Builder wikiId(String v) { this.wikiId = v; return this; }

        public GetDetailListRequest build() { return new GetDetailListRequest(this); }
    }

    public String getId() { return id; }
    public String getWikiId() { return wikiId; }
}