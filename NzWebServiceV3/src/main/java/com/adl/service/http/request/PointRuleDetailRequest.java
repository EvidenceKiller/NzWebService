package com.adl.service.http.request;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class PointRuleDetailRequest extends BaseRequest {

    @SerializedName("skuId")
    private String skuId;

    @SerializedName("orgId")
    private String orgId;

    private PointRuleDetailRequest(Builder builder) {
        super(builder);
        this.skuId = builder.skuId;
        this.orgId = builder.orgId;
    }

    public static Builder builder(String skuId) {
        return new Builder(skuId);
    }

    public static class Builder extends BaseRequest.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
        private String skuId;
        private String orgId;

        Builder(String skuId) {
            this.skuId = skuId;
        }

        public Builder orgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public PointRuleDetailRequest build() {
            return new PointRuleDetailRequest(this);
        }
    }
}