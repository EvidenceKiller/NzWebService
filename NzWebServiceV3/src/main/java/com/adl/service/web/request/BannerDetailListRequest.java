package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class BannerDetailListRequest extends BaseRequest {

    @SerializedName("id")
    private String id;

    @SerializedName("wikiId")
    private String wikiId;

    @SerializedName("resType")
    private Integer resType;

    private BannerDetailListRequest(Builder builder) {
        this.id = builder.id;
        this.wikiId = builder.wikiId;
        this.resType = builder.resType;
    }

    public static Builder builder(String id) {
        return new Builder(id);
    }


    public static class Builder {
        private String id;
        private String wikiId;
        private Integer resType;

        Builder(String id) {
            this.id = id;
        }

        public Builder wikiId(String wikiId) {
            this.wikiId = wikiId;
            return this;
        }

        public Builder resType(Integer resType) {
            this.resType = resType;
            return this;
        }

        public BannerDetailListRequest build() {
            return new BannerDetailListRequest(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getWikiId() {
        return wikiId;
    }

    public Integer getResType() {
        return resType;
    }
}