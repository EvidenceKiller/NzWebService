package com.adl.service.http.request;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class UpgradePlanByDeviceRequest extends BaseRequest {

    /** 路径参数 */
    @SerializedName("appCode")
    private String appCode;

    @SerializedName("productCode")
    private String productCode;

    private UpgradePlanByDeviceRequest(Builder builder) {
        super(builder);
        this.appCode = builder.appCode;
        this.productCode = builder.productCode;
    }

    public static Builder builder(String appCode) {
        return new Builder(appCode);
    }

    public static class Builder extends BaseRequest.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
        private String appCode;
        private String productCode;
        Builder(String appCode) {
            this.appCode = appCode;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public UpgradePlanByDeviceRequest build() { return new UpgradePlanByDeviceRequest(this); }
    }

}