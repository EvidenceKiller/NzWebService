package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import com.adl.service.utils.InnerUtil;

import androidx.room.ColumnInfo;
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
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SportRecordModifyEntity {
    @ColumnInfo(name = "_id")
    private String id;

    @ColumnInfo(name = "_sport_result")
    private String sportResult;

    @ColumnInfo(name = "_sport_score")
    private String sportScore;

    @ColumnInfo(name = "_sport_level")
    private String sportLevel;

    //  业务数据状态:0（未上传）、1（已上传）、2（上传失败，后续不再上传）
    @ColumnInfo(name = "_upload_data_status")
    private Integer uploadDataStatus= 0;

    //  修改状态:0（未修改）、1（修改）
    @ColumnInfo(name = "_upload_modify_status")
    private Integer uploadModifyStatus= 0;

    //  多人运动Id
    @ColumnInfo(name = "_multi_person_id")
    private String multiPersonId;

    //  多人运动排名
    @ColumnInfo(name = "_multi_person_rank")
    private Integer multiPersonRank= 0;

    //  业务数据上传次数
    @ColumnInfo(name = "_upload_data_fail_num", defaultValue = "0")
    private Integer uploadDataFailNum= 0;

    //  上传日期【yyyy-MM-dd】
    @ColumnInfo(name = "_upload_date", defaultValue = "")
    private String uploadDate;

    public void restUpdateFail() {
        this.uploadDataFailNum = 0;
        this.uploadDate = InnerUtil.formatYMDNow();
    }
}
