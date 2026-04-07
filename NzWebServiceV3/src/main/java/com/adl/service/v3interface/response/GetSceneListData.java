package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



public final class GetSceneListData {
    /** 主键id */
    @SerializedName("id")
    private String id;

    /** 场景标识码 */
    @SerializedName("sceneCode")
    private String sceneCode;

    /** 场景名称 */
    @SerializedName("sceneName")
    private String sceneName;

    /** 产经对应端 多个逗号隔开 */
    @SerializedName("appCodes")
    private String appCodes;

    /** 序号 */
    @SerializedName("sceneSort")
    private long sceneSort;

    /** 场景类型 场景类型 1 锻炼 测试 */
    @SerializedName("sceneType")
    private String sceneType;

    @SerializedName("enabled")
    private boolean enabled;

    public String getId() { return id; }
    public String getSceneCode() { return sceneCode; }
    public String getSceneName() { return sceneName; }
    public String getAppCodes() { return appCodes; }
    public long getSceneSort() { return sceneSort; }
    public String getSceneType() { return sceneType; }
    public boolean getEnabled() { return enabled; }
}