package com.adl.service.http.request;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class TeachCourseButtonClickCountRequest extends BaseRequest {
    /**
     * 班级Id
     */
    @SerializedName("classId")
    private String classId;

    /**
     * 日期
     */
    @SerializedName("date")
    private String date;

    private TeachCourseButtonClickCountRequest(Builder builder) {
        super(builder);
        this.classId = builder.classId;
        this.date = builder.date;
    }

    public static Builder builder(String classId, String date) {
        return new Builder(classId, date);
    }

    public static class Builder extends BaseRequest.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
        private String classId;
        private String date;

        private Builder(String classId, String data) {
            this.classId = classId;
            this.date = data;
        }

        public TeachCourseButtonClickCountRequest build() {
            return new TeachCourseButtonClickCountRequest(this);
        }
    }
}
