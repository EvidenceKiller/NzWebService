package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class PlanInfoRequest {
    /**
     * 计划ID
     */
    @SerializedName("planId")
    private String planId;

    private PlanInfoRequest(Builder builder) {
        this.planId = builder.planId;
    }

    public static Builder builder(String planId) {
        return new Builder(planId);
    }

    public static class Builder {
        private String planId;

        Builder(String planId) {
            this.planId = planId;
        }

        public PlanInfoRequest build() {
            return new PlanInfoRequest(this);
        }
    }

    public String getPlanId() {
        return planId;
    }
}