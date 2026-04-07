package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;



public final class GetWikiDetailRequest {
    @SerializedName("id")
    private String id;

    @SerializedName("wikiId")
    private String wikiId;

    private GetWikiDetailRequest(Builder b) {
        this.id = b.id;
        this.wikiId = b.wikiId;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String id;
        private String wikiId;

        public Builder id(String v) { this.id = v; return this; }

        public Builder wikiId(String v) { this.wikiId = v; return this; }

        public GetWikiDetailRequest build() { return new GetWikiDetailRequest(this); }
    }

    public String getId() { return id; }
    public String getWikiId() { return wikiId; }
}