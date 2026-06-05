package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import com.adl.service.data.SportProjectData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class SportProjectEntity implements Serializable {
    /**
     * 精度
     * 参考字典编码:adl_tis_physical_test_plan_decimal_precision
     * (0 整数 1 小数后一位 2 小数后两位 3 小数后三位)
     */
    private Integer decimalPrecision= 0;

    /**
     * 项目分计算方程式
     */
    private String formula;

    /**
     * 取整方式
     * 参考字典编码:adl_tis_physical_test_plan_round
     * (0 向上取整 1 向下取整 4 四舍五入)
     */
    private Integer round= 0;

    /**
     * 性别
     * 参考字典编码:adl_tis_sex
     */
    private String sex;

    /**
     * 权重值
     */
    private String weight;

    /**
     * 权重类型
     * 参考字典编码:adl_tis_physical_test_plan_arrake_project_weight_type
     * (1 必考 2 一类选考 3 二类选考)
     */
    private String weightType;

    /**
     * 项目id
     */
    private String sportSkuId;

    /**
     * 项目名称
     */
    private String sportSkuName;

    /**
     * 限制报告数量
     */
    private Integer limitReportCount = 0;

    private Integer testCount = 0;

    public static SportProjectEntity convertToEntity(SportProjectData data) {
        if (data == null) {
            return null;
        }
        SportProjectEntity entity = new SportProjectEntity();
        entity.setDecimalPrecision(data.getDecimalPrecision());
        entity.setFormula(data.getFormula());
        entity.setRound(data.getRound());
        entity.setSex(data.getSex());
        entity.setWeight(data.getWeight());
        entity.setWeightType(data.getWeightType());
        entity.setSportSkuId(data.getSportSkuId());
        entity.setSportSkuName(data.getSportSkuName());
        entity.setLimitReportCount(data.getLimitReportCount());
        entity.setTestCount(data.getTestCount());
        return entity;
    }

    public static SportProjectData convertToData(SportProjectEntity entity) {
        if (entity == null) {
            return null;
        }
        SportProjectData data = new SportProjectData();
        data.setDecimalPrecision(entity.getDecimalPrecision());
        data.setFormula(entity.getFormula());
        data.setRound(entity.getRound());
        data.setSex(entity.getSex());
        data.setWeight(entity.getWeight());
        data.setWeightType(entity.getWeightType());
        data.setSportSkuId(entity.getSportSkuId());
        data.setSportSkuName(entity.getSportSkuName());
        data.setLimitReportCount(entity.getLimitReportCount());
        data.setTestCount(entity.getTestCount());
        return data;
    }
}
