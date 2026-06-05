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
public class ReportSportStudentData implements Serializable {
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
     * 多人运动Id
     */
    @SerializedName("multiPersonId")
    private String multiPersonId;

    /**
     * 多人运动排名
     */
    @SerializedName("multiPersonRank")
    private Integer multiPersonRank = 0;

    /**
     * 运动统计字段 例：跳绳类为个数 阳光跑为mm
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
     * 运动指标
     */
    @SerializedName("sportIndicators")
    private List<SportIndicatorsData> sportIndicators;

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
     * 原始运动结果
     */
    @SerializedName("originalSportResult")
    private String originalSportResult;

    /**
     * 是否违规不能为空 1:违规
     */
    @SerializedName("sportViolationStatus")
    private Integer sportViolationStatus = 0;

    /**
     * 多人运动机位排序
     */
    @SerializedName("multiPersonIndex")
    private Integer multiPersonIndex = 0;

    /**
     * 场所id
     */
    @SerializedName("placeId")
    private String placeId;

    /**
     * 场所名称
     */
    @SerializedName("placeName")
    private String placeName;

    /**
     * 报告编码 端分对运动分类，如跳绳 0201 分为并脚跳、单脚跳、花式跳绳等
     */
    @SerializedName("reportCode")
    private String reportCode;
}
