package com.adl.service.db;


import com.adl.service.common.IDefine;
import com.adl.service.common.InnerPreferences;
import com.adl.service.entity.CitizenEntity;
import com.adl.service.entity.DictEntity;
import com.adl.service.entity.FileDownInfoEntity;
import com.adl.service.entity.FileUploadInfoEntity;
import com.adl.service.entity.MeetGroupDetailsEntity;
import com.adl.service.entity.MeetGroupTeamEntity;
import com.adl.service.entity.SceneEntity;
import com.adl.service.entity.SceneSportEntity;
import com.adl.service.entity.SportCompetitionEntity;
import com.adl.service.entity.SportMeetingEntity;
import com.adl.service.entity.SportPlanStudentEntity;
import com.adl.service.entity.SportRecordEntity;
import com.adl.service.entity.SportRecordLocalEntity;
import com.adl.service.entity.StandardConfigEntity;
import com.adl.service.entity.StudentEntity;
import com.adl.service.entity.TeacherEntity;
import com.adl.service.entity.TeacherSportLocalEntity;
import com.adl.service.db.converter.ListStringConverter;
import com.adl.service.web.response.PlanData;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.DeleteTable;
import androidx.room.RenameColumn;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/2
 * Describe   : 数据库DAO 管理
 */
@Database(entities = {StudentEntity.class, TeacherEntity.class, CitizenEntity.class,
        FileDownInfoEntity.class, FileUploadInfoEntity.class,
        PlanData.class, SportPlanStudentEntity.class, StandardConfigEntity.class,
        SceneEntity.class, SceneSportEntity.class,
        SportMeetingEntity.class, MeetGroupTeamEntity.class, MeetGroupDetailsEntity.class,
        SportCompetitionEntity.class,
        SportRecordLocalEntity.class, SportRecordEntity.class,
        DictEntity.class, TeacherSportLocalEntity.class
},
        version = 1,
        autoMigrations = {}
)
@TypeConverters(ListStringConverter.class)
public abstract class DaoManager extends RoomDatabase {

    public abstract StudentDao getStudentDao();

    public abstract TeacherDao getTeacherDao();

    public abstract CitizenDao getCitizenDao();

    public abstract FileDownDao getFileDownDao();

    public abstract FileUploadDao getFileUploadDao();

    public abstract PlanDao getPlanDao();

    public abstract PlanStudentDao getPlanStudentDao();

    public abstract StandardConfigDao getStandardConfigDao();

    public abstract SceneDao getSceneDao();

    public abstract SceneSportDao getSceneSportDao();

    public abstract RecordLocalDao getRecordLocalDao();

    public abstract RecordUploadDao getRecordUploadDao();

    public abstract DictDao getDictDao();

    public abstract MeetDao getMeetDao();

    public abstract MeetGroupTeamDao getMeetGroupTeamDao();

    public abstract MeetGroupDetailsDao getMeetGroupDetailsDao();

    public abstract TeacherSportDao getTeacherSportDao();
}
