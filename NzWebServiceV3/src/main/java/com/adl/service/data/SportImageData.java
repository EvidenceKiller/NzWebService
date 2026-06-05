package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class SportImageData implements Serializable {
    /**
     * 图片相对地址
     */
    @SerializedName("imageUrl")
    private String imageUrl;

    /**
     * 运动分析图片说明
     */
    @SerializedName("motionAnalysisImageDesc")
    private String motionAnalysisImageDesc;

    /**
     * 图片说明
     */
    @SerializedName("imageDesc")
    private String imageDesc;

    /**
     * 分组编号
     */
    @SerializedName("groupIndex")
    private String groupIndex;

    public SportImageData(String imageUrl, String imageDesc) {
        this.imageUrl = imageUrl;
        this.imageDesc = imageDesc;
    }

    public SportImageData(String imageDesc, String imageUrl, String groupIndex) {
        this.imageUrl = imageUrl;
        this.imageDesc = imageDesc;
        this.groupIndex = groupIndex;
    }
}
