package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

public final class TrainPlanOneDayProjectData {

    /**
     * 训练计划 ID
     */
    @SerializedName("trainPlanId")
    private String trainPlanId;

    /**
     * 排序
     */
    @SerializedName("sort")
    private int sort;

    /**
     * 运动个数
     */
    @SerializedName("sportCount")
    private int sportCount;

    /**
     * 1 计时 2 计数 99 其他
     */
    @SerializedName("sportModel")
    private String sportModel;

    /**
     * 运动时间 (ms)
     */
    @SerializedName("sportTime")
    private int sportTime;

    /**
     * 运动成绩
     */
    @SerializedName("sportResult")
    private String sportResult;

    /**
     * 打卡完成，0 待完成 1 已完成
     */
    @SerializedName("checkStatus")
    private boolean checkStatus;

    /**
     * sku 唯一标识
     */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /**
     * sku 名称
     */
    @SerializedName("sportSkuName")
    private String sportSkuName;

    /**
     * 训练计划运动 id
     */
    @SerializedName("trainPlanSportId")
    private String trainPlanSportId;

    public String getTrainPlanId() {
        return trainPlanId;
    }

    public int getSort() {
        return sort;
    }

    public int getSportCount() {
        return sportCount;
    }

    public String getSportModel() {
        return sportModel;
    }

    public int getSportTime() {
        return sportTime;
    }

    public String getSportResult() {
        return sportResult;
    }

    public boolean getCheckStatus() {
        return checkStatus;
    }

    public String getSportSkuId() {
        return sportSkuId;
    }

    public String getSportSkuName() {
        return sportSkuName;
    }

    public String getTrainPlanSportId() {
        return trainPlanSportId;
    }
}
