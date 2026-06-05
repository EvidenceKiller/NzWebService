package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import com.adl.service.data.SportSkuSimpleData;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class SportSkuSimpleEntity {
    @SerializedName("sportSkuId")
    private String sportSkuId;

    @SerializedName("sportSkuName")
    private String sportSkuName;

    @SerializedName("createTime")
    private Long createTime = 0L;

    @SerializedName("levelType")
    private String levelType;

    @SerializedName("settlementType")
    private String settlementType;

    public static SportSkuSimpleEntity convertToEntity(SportSkuSimpleData data) {
        if (data == null) {
            return null;
        }
        SportSkuSimpleEntity entity = new SportSkuSimpleEntity();
        entity.setSportSkuId(data.getSportSkuId());
        entity.setSportSkuName(data.getSportSkuName());
        entity.setCreateTime(data.getCreateTime());
        entity.setLevelType(data.getLevelType());
        entity.setSettlementType(data.getSettlementType());
        return entity;
    }

    public static SportSkuSimpleData convertToData(SportSkuSimpleEntity entity) {
        if (entity == null) {
            return null;
        }
        SportSkuSimpleData data = new SportSkuSimpleData();
        data.setSportSkuId(entity.getSportSkuId());
        data.setSportSkuName(entity.getSportSkuName());
        data.setCreateTime(entity.getCreateTime());
        data.setLevelType(entity.getLevelType());
        data.setSettlementType(entity.getSettlementType());
        return data;
    }
}
