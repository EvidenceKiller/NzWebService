package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import com.adl.service.data.DictMapData;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(tableName = "_dict_map")
@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class DictMapEntity {
    public static final long EXPIRED_TIME = 1000L * 60L * 60L * 12L;

    @PrimaryKey(autoGenerate = true)
    private Long lid= 0L;

    @ColumnInfo(name = "_sport_sku_id")
    private String sportSkuId;

    @ColumnInfo(name = "_dict")
    private String dict;

    @ColumnInfo(name = "_right_key")
    private String rightKey;

    @ColumnInfo(name = "_wrong_key")
    private String wrongKey;

    @ColumnInfo(name = "_type")
    private String type;

    @ColumnInfo(name = "_expired_time")
    private Long expiredTime= 0L;

    public static DictMapEntity convertToEntity(DictMapData data, String sportSkuId) {
        if (data == null) {
            return null;
        }
        DictMapEntity entity = new DictMapEntity();
        entity.setSportSkuId(sportSkuId);
        entity.setDict(data.getDict());
        entity.setRightKey(data.getRightKey());
        entity.setWrongKey(data.getWrongKey());
        entity.setType(data.getType());
        entity.setExpiredTime(System.currentTimeMillis() + EXPIRED_TIME);
        return entity;
    }

    public static DictMapData convertToData(DictMapEntity entity) {
        if (entity == null) {
            return null;
        }
        DictMapData data = new DictMapData();
        data.setDict(entity.getDict());
        data.setRightKey(entity.getRightKey());
        data.setWrongKey(entity.getWrongKey());
        data.setType(entity.getType());
        return data;
    }
}
