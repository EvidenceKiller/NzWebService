package com.adl.service.db.entity;

import com.adl.service.data.SportRecordResData;

import androidx.annotation.RestrictTo;

import java.io.Serializable;

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
@Entity(tableName = "_record_res_upload")
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SportRecordResEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id= 0;

    @ColumnInfo(name = "_upload_flag")
    private Integer uploadFlag= 0;

    @ColumnInfo(name = "_account_id")
    private String accountId;

    @ColumnInfo(name = "_sport_sku_id")
    private String sportSkuId;

    @ColumnInfo(name = "_local_path")
    private String localPath;

    @ColumnInfo(name = "_upload_file_prefix")
    private String uploadFilePrefix;

    @ColumnInfo(name = "_upload_file_name")
    private String uploadFileName;

    public static SportRecordResData convertToData(SportRecordResEntity entity) {
        if (entity == null) {
            return null;
        }

        SportRecordResData data = new SportRecordResData();
        data.setId(entity.getId());
        data.setUploadFlag(entity.getUploadFlag());
        data.setAccountId(entity.getAccountId());
        data.setSportSkuId(entity.getSportSkuId());
        data.setLocalPath(entity.getLocalPath());
        data.setUploadFilePrefix(entity.getUploadFilePrefix());
        data.setUploadFileName(entity.getUploadFileName());
        return data;
    }

    public static SportRecordResEntity convertToEntity(SportRecordResData data) {
        if (data == null) {
            return null;
        }

        SportRecordResEntity entity = new SportRecordResEntity();
        entity.setId(data.getId());
        entity.setUploadFlag(data.getUploadFlag());
        entity.setAccountId(data.getAccountId());
        entity.setSportSkuId(data.getSportSkuId());
        entity.setLocalPath(data.getLocalPath());
        entity.setUploadFilePrefix(data.getUploadFilePrefix());
        entity.setUploadFileName(data.getUploadFileName());
        return entity;
    }
}

