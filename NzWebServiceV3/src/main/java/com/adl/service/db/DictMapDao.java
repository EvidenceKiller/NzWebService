package com.adl.service.db;

import com.adl.service.db.entity.DictEntity;
import com.adl.service.db.entity.DictMapEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 类描述
 */
@Dao
public interface DictMapDao {
    @Query("select * from _dict_map")
    List<DictMapEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<DictMapEntity> list);

    @Query("select * from _dict_map where _sport_sku_id = :sportSkuId")
    List<DictMapEntity> queryDictMapBySportSkuId(String sportSkuId);

    @Query("delete from _dict_map where _sport_sku_id = :sportSkuId")
    void clearDictMapBySportSkuId(String sportSkuId);

    @Query("delete from _dict_map")
    void clearAll();
}
