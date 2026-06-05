package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class ReportSportTeacherData implements Serializable {
    /**
     * 用户标识码
     */
    @SerializedName("accountId")
    private String accountId;

    /**
     * 产品应用标识码
     */
    @SerializedName("appCode")
    private String appCode;

    /**
     * 产品应用标识码名称
     */
    @SerializedName("appName")
    private String appName;

    /**
     * 运动完美个数
     */
    @SerializedName("perfectCount")
    private Integer perfectCount = 0;

    /**
     * 运动优秀个数
     */
    @SerializedName("bravoCount")
    private Integer bravoCount = 0;

    /**
     * 运动良好个数
     */
    @SerializedName("goodeviceount")
    private Integer goodeviceount = 0;

    /**
     * 扩展JSON
     */
    @SerializedName("extraJson")
    private String extraJson;

    /**
     * 记录标识码
     */
    @SerializedName("id")
    private String id;

    /**
     * 记录有效标识位
     */
    @SerializedName("invalidFlag")
    private Integer invalidFlag = 0;

    /**
     * 运动统计字段：跳绳类为个数，阳光跑为 mm
     */
    @SerializedName("sportCount")
    private Long sportCount = 0L;

    /**
     * 运动开始时间，时间戳不能为空
     */
    @SerializedName("sportStartTime")
    private String sportStartTime;

    /**
     * 运动结束时间，时间戳不能为空
     */
    @SerializedName("sportEndTime")
    private String sportEndTime;

    /**
     * 运动图片集
     */
    @SerializedName("sportImages")
    private List<SportImageData> sportImages;

    /**
     * 运动视频集
     */
    @SerializedName("sportVideos")
    private List<SportVideoData> sportVideos;

    /**
     * 运动结果
     */
    @SerializedName("sportResult")
    private String sportResult;

    /**
     * 运动场景代码
     */
    @SerializedName("sportSceneCode")
    private String sportSceneCode;

    /**
     * 运动得分
     */
    @SerializedName("sportScore")
    private Double sportScore = 0.0;

    /**
     * 运动sku编码
     */
    @SerializedName("sportSkuId")
    private String sportSkuId;

    /**
     * 运动标签
     */
    @SerializedName("sportSkuSubType")
    private String sportSkuSubType;

    /**
     * 运动时长
     */
    @SerializedName("sportTime")
    private Long sportTime = 0L;

    /**
     * 运动单位编码
     */
    @SerializedName("sportUnitCode")
    private String sportUnitCode;

    /**
     * 原始运动结果
     */
    @SerializedName("originalSportResult")
    private String originalSportResult;

    /**
     * 是否违规，1表示违规
     */
    @SerializedName("sportViolationStatus")
    private Integer sportViolationStatus = 0;
}
