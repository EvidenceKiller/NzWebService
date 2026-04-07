package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



public final class UploadStudentMeetData {
    @SerializedName("payload")
    private String payload;

    public String getPayload() { return payload; }
}