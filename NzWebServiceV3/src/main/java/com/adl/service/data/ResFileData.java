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
public final class ResFileData implements Serializable {
    @SerializedName("id")
    private String id;

    @SerializedName("resFileDesc")
    private String resFileDesc;

    @SerializedName("resFileName")
    private String resFileName;

    @SerializedName("resFilePath")
    private String resFilePath;

    @SerializedName("resFileCover")
    private String resFileCover;

    @SerializedName("resFileSize")
    private Long resFileSize = 0L;

    @SerializedName("resFileTitle")
    private String resFileTitle;

    @SerializedName("resFileType")
    private Integer resFileType = 0;

    @SerializedName("resId")
    private String resId;
}
