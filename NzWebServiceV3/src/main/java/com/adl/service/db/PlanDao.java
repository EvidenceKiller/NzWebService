package com.adl.service.db;

import com.adl.service.web.response.PlanData;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.rxjava3.core.Completable;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 类描述
 */
@Dao
public interface PlanDao {

    @Query("select * from _sport_plan")
    List<PlanData> getAll();

    @Query("select * from _sport_plan limit :noOfRows,:rowNum")
    List<PlanData> getAllByPage(int noOfRows, int rowNum);

    @Query("select * from _sport_plan where _start_time > strftime('%s','now')*1000")
    List<PlanData> queryPlanStatusNew();

    @Query("select * from _sport_plan where _start_time > strftime('%s','now')*1000 limit :noOfRows,:rowNum")
    List<PlanData> queryPlanStatusNewByPage(int noOfRows, int rowNum);

    @Query("select * from _sport_plan where (strftime('%s','now')*1000 between _start_time and _end_time)")
    List<PlanData> queryPlanStatusDoing();

    @Query("select * from _sport_plan where (strftime('%s','now')*1000 between _start_time and _end_time) limit :noOfRows,:rowNum")
    List<PlanData> queryPlanStatusDoingByPage(int noOfRows, int rowNum);

    @Query("select * from _sport_plan where _end_time < strftime('%s','now')*1000")
    List<PlanData> queryPlanStatusDone();

    @Query("select * from _sport_plan where _end_time < strftime('%s','now')*1000 limit :noOfRows,:rowNum")
    List<PlanData> queryPlanStatusDoneByPage(int noOfRows, int rowNum);

    @Query("select * from _sport_plan where _plan_id = :planId limit 1")
    PlanData queryPlanById(String planId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertPlanList(List<PlanData> list);

    @Query("delete from _sport_plan")
    void clearAll();

    @Query("select * from _sport_plan WHERE (:planStatus='' or :planStatus='0' or _status=:planStatus) LIMIT :pageIndex,:pageSize")
    List<PlanData> getByPage(int pageIndex, int pageSize, String planStatus);

}
