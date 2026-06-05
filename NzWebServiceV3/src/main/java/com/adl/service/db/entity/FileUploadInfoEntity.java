package com.adl.service.db.entity;

import com.adl.service.data.FileUploadInfoData;

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
@Entity(tableName = "_file_upload_info")
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class FileUploadInfoEntity {

    @PrimaryKey(autoGenerate = true)
    private Long lid= 0L;

    // 机构信息（切换机构）
    @ColumnInfo(name = "_org_id")
    private String orgId;

    @ColumnInfo(name = "_local_path")
    private String localPath;

    // 上传状态
    @ColumnInfo(name = "_upload_status")
    private Integer uploadStatus= 0;

    @ColumnInfo(name = "_remote_file_name")
    private String remoteFileName;

    @ColumnInfo(name = "_remote_url")
    private String remoteUrl;

    @ColumnInfo(name = "_remote_bucket")
    private String remoteBucket;

    @ColumnInfo(name = "_create_time")
    private Long createTime= 0L;

    @ColumnInfo(name = "_remark")
    private String remark;

    public static FileUploadInfoData convertToData(FileUploadInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        FileUploadInfoData data = new FileUploadInfoData();
        data.setOrgId(entity.getOrgId());
        data.setLocalPath(entity.getLocalPath());
        data.setUploadStatus(entity.getUploadStatus());
        data.setRemoteFileName(entity.getRemoteFileName());
        data.setRemoteUrl(entity.getRemoteUrl());
        data.setRemoteBucket(entity.getRemoteBucket());
        data.setCreateTime(entity.getCreateTime());
        data.setRemark(entity.getRemark());
        return data;
    }

    public static FileUploadInfoEntity convertToEntity(FileUploadInfoData data) {
        if (data == null) {
            return null;
        }

        FileUploadInfoEntity entity = new FileUploadInfoEntity();
        entity.setOrgId(data.getOrgId());
        entity.setLocalPath(data.getLocalPath());
        entity.setUploadStatus(data.getUploadStatus());
        entity.setRemoteFileName(data.getRemoteFileName());
        entity.setRemoteUrl(data.getRemoteUrl());
        entity.setRemoteBucket(data.getRemoteBucket());
        entity.setCreateTime(data.getCreateTime());
        entity.setRemark(data.getRemark());
        return entity;
    }
}