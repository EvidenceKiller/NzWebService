package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import androidx.room.ColumnInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SportRecordResultEntity {
    //  用户账号id(非必须)
    @ColumnInfo(name = "_account_id")
    private String accountId;

    //  运动sku编码，sku配置表
    @ColumnInfo(name = "_sport_sku_id")
    private String sportSkuId;
}
