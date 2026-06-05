package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 运动记录
 */
@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class SportRecordResData implements Serializable {
    @SerializedName("id")
    private Integer id = 0;

    @SerializedName("uploadFlag")
    private Integer uploadFlag = 0;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("sportSkuId")
    private String sportSkuId;

    @SerializedName("localPath")
    private String localPath;

    @SerializedName("uploadFilePrefix")
    private String uploadFilePrefix;

    @SerializedName("uploadFileName")
    private String uploadFileName;
}

