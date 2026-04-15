package com.adl.service.db.entity;

import com.adl.service.web.response.SceneData;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(tableName = "_scene")
public final class SceneEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long lid;

    /**
     * 主键id
     */
    @ColumnInfo(name = "_id")
    private String id;

    /**
     * 场景标识码
     */
    @ColumnInfo(name = "_scene_code")
    private String sceneCode;

    /**
     * 场景名称
     */
    @ColumnInfo(name = "_scene_name")
    private String sceneName;

    @ColumnInfo(name = "_app_code")
    private String appCode;

    /**
     * 产经对应端 多个逗号隔开
     */
    @ColumnInfo(name = "_app_codes")
    private String appCodes;

    /**
     * 序号
     */
    @ColumnInfo(name = "_scene_sort")
    private Long sceneSort;

    /**
     * 场景类型 场景类型 1 锻炼 测试
     */
    @ColumnInfo(name = "_scene_type")
    private String sceneType;

    @ColumnInfo(name = "_enabled")
    private Boolean enabled;
    ;

    public static SceneEntity convertToEntity(SceneData data, String appCode) {
        if (data == null) {
            return null;
        }
        SceneEntity entity = new SceneEntity();
        entity.setId(data.getId());
        entity.setSceneCode(data.getSceneCode());
        entity.setSceneName(data.getSceneName());
        entity.setAppCode(appCode);
        entity.setAppCodes(data.getAppCodes());
        entity.setSceneSort(data.getSceneSort());
        entity.setSceneType(data.getSceneType());
        entity.setEnabled(data.getEnabled());
        return entity;
    }
}
