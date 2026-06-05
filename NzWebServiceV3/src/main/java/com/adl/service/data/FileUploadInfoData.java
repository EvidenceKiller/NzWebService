package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/3
 * Describe   : 类描述
 */
@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public class FileUploadInfoData {
    // 机构信息（切换机构）
    @SerializedName("orgId")
    private String orgId;

    @SerializedName("localPath")
    private String localPath;

    // 上传状态
    @SerializedName("uploadStatus")
    private Integer uploadStatus = 0;

    @SerializedName("remoteFileName")
    private String remoteFileName;

    @SerializedName("remoteUrl")
    private String remoteUrl;

    @SerializedName("remoteBucket")
    private String remoteBucket;

    @SerializedName("createTime")
    private Long createTime = 0L;

    @SerializedName("remark")
    private String remark;
}