package com.adl.service.http.request;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class QiNiuYunTokenRequest extends BaseRequest {
    /**
     * 班级id
     */
    @SerializedName("bucket")
    private String bucket;

    private QiNiuYunTokenRequest(Builder builder) {
        super(builder);
        this.bucket = builder.bucket;
    }

    public static Builder builder(String bucket) {
        return new Builder(bucket);
    }

    public static class Builder extends BaseRequest.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
        private String bucket;

        Builder(String bucket) {
            this.bucket = bucket;
        }

        public QiNiuYunTokenRequest build() {
            return new QiNiuYunTokenRequest(this);
        }
    }
}