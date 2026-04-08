package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class SportMeetPageRequest extends BasePageRequest {

    /**
     * 应用端
     */
    @SerializedName("appCode")
    private String appCode;

    /**
     * 班级ID列表
     */
    @SerializedName("classIds")
    private List<String> classIds;

    /**
     * 机构ID
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * 状态
     */
    @SerializedName("state")
    private int state;

    /**
     * 关键字
     */
    @SerializedName("keyword")
    private String keyword;

    /**
     * ID
     */
    @SerializedName("id")
    private String id;

    /**
     * 是否显示分组
     */
    @SerializedName("showGroup")
    private boolean showGroup;

    /**
     * 检查时间
     */
    @SerializedName("checkTime")
    private String checkTime;

    /**
     * 排序字段 0 创建时间降序 1比赛时间降序
     */
    @SerializedName("orderByField")
    private int orderByField;

    /**
     * 最后更新时间
     */
    @SerializedName("lastUpdateTime")
    private long lastUpdateTime;

    private SportMeetPageRequest(Builder builder) {
        super(builder);
        this.appCode = builder.appCode;
        this.classIds = builder.classIds;
        this.orgId = builder.orgId;
        this.state = builder.state;
        this.keyword = builder.keyword;
        this.id = builder.id;
        this.showGroup = builder.showGroup;
        this.checkTime = builder.checkTime;
        this.orderByField = builder.orderByField;
        this.lastUpdateTime = builder.lastUpdateTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BasePageRequest.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
        private String appCode;
        private List<String> classIds;
        private String orgId;
        private int state;
        private String keyword;
        private String id;
        private boolean showGroup;
        private String checkTime;
        private int orderByField;
        private long lastUpdateTime;

        public Builder appCode(String appCode) {
            this.appCode = appCode;
            return this;
        }

        public Builder classIds(List<String> classIds) {
            this.classIds = classIds;
            return this;
        }

        public Builder orgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public Builder state(int state) {
            this.state = state;
            return this;
        }

        public Builder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder showGroup(boolean showGroup) {
            this.showGroup = showGroup;
            return this;
        }

        public Builder checkTime(String checkTime) {
            this.checkTime = checkTime;
            return this;
        }

        public Builder orderByField(int orderByField) {
            this.orderByField = orderByField;
            return this;
        }

        public Builder lastUpdateTime(long lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
            return this;
        }

        public SportMeetPageRequest build() {
            return new SportMeetPageRequest(this);
        }
    }

    public String getAppCode() {
        return appCode;
    }

    public List<String> getClassIds() {
        return classIds;
    }

    public String getOrgId() {
        return orgId;
    }

    public int getState() {
        return state;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getId() {
        return id;
    }

    public boolean getShowGroup() {
        return showGroup;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public int getOrderByField() {
        return orderByField;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }
}