package com.adl.service.web.response;

import com.adl.service.internal.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class SportMeetSkuAccountData {

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("accountName")
    private String accountName;

    @SerializedName("sex")
    private String sex;

    @SerializedName("studentCode")
    private String studentCode;
}
