package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class DictRequest extends BaseRequest {

    @SerializedName("dictId")
    private String dictId;

    private DictRequest(Builder builder) {
        this.dictId = builder.dictId;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private String dictId;

        public Builder dictId(String dictId) {
            this.dictId = dictId;
            return this;
        }

        public DictRequest build() {
            return new DictRequest(this);
        }
    }

    public String getDictId() {
        return dictId;
    }
}