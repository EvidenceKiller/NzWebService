package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class FaceData implements Serializable {

    // 人脸特征值
    @SerializedName("faceData")
    private String faceData;

    // 厂商类型 1：百度 2：商汤
    @SerializedName("type")
    private String type;
}