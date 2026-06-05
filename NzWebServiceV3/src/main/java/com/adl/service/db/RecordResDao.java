package com.adl.service.db;


import com.adl.service.db.entity.SportRecordResEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 类描述
 */
@Dao
public interface RecordResDao {
    @Query("select * from _record_res_upload where _upload_flag = 0")
    List<SportRecordResEntity> queryNotUploadRecordRes();

    @Query("select * from _record_res_upload")
    List<SportRecordResEntity> queryAll();

    @Insert(onConflict = 1)
    void insert(SportRecordResEntity item);

    @Delete
    void clear(SportRecordResEntity item);
}
