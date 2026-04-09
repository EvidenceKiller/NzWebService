package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class PlanInfoData {

    @SerializedName("planId")
    private String planId;

    @SerializedName("planName")
    private String planName;

    @SerializedName("standardType")
    private String standardType;

    @SerializedName("startTime")
    private String startTime;

    @SerializedName("endTime")
    private String endTime;

    @SerializedName("createTime")
    private String createTime;

    @SerializedName("standardId")
    private String standardId;

    @SerializedName("originStandardId")
    private String originStandardId;

    @SerializedName("sportList")
    private List<Object> sportList;

    @SerializedName("classIds")
    private List<Object> classIds;

    @SerializedName("classes")
    private List<Object> classes;

    @SerializedName("dayConfigsMap")
    private Object dayConfigsMap;

    @SerializedName("dateConfigsMap")
    private Object dateConfigsMap;

    @SerializedName("classAllFlag")
    private String classAllFlag;

    @SerializedName("status")
    private String status;

    /**
     * 总满分值
     */
    @SerializedName("totalFullCredit")
    private String totalFullCredit;

    /**
     * 总分计算方程式
     */
    @SerializedName("formula")
    private String formula;

    /**
     * 线上支付金额 线上支付金额，最低金额为0.01
     */
    @SerializedName("payPrice")
    private double payPrice;

    /**
     * 批量下发标识位 0 否 1 是
     */
    @SerializedName("distributeFlag")
    private boolean distributeFlag;

    /**
     * 全部学校标识位 0 全部 1 部分
     */
    @SerializedName("clazzAllFlag")
    private boolean clazzAllFlag;

    /**
     * 报名标识位 0 不需要 1 需要
     */
    @SerializedName("signUpFlag")
    private boolean signUpFlag;

    /**
     * 满分类型 参考字典编码：adl_tis_physical_test_plan_full_credit_type（1 项目满分 2 总满分）
     */
    @SerializedName("fullCreditType")
    private int fullCreditType;

    /**
     * 取整方式 参考字典编码：adl_tis_physical_test_plan_round（0 向上取整 1 向下取整 4 四舍五入）
     */
    @SerializedName("round")
    private int round;

    /**
     * 精度 参考字典编码：adl_tis_physical_test_plan_decimal_precision（0 整数 1 小数后一位 2 小数后两位 3 小数后三位 ）
     */
    @SerializedName("decimalPrecision")
    private int decimalPrecision;

    /**
     * 支付类型 参考字典编码：adl_tis_physical_test_plan_pay_type（1 免费 2 线下支付 3 线上支付（每人））
     */
    @SerializedName("payType")
    private int payType;

    /**
     * 自助测试 参考字典编码：adl_tis_physical_test_plan_self_test（0 非自助测试 1自助测试 ）
     */
    @SerializedName("selfTest")
    private int selfTest;

    @SerializedName("orgId")
    private String orgId;

    @SerializedName("delFlag")
    private boolean delFlag;

    /**
     * 预约标识位 0 不需要 1 需要
     */
    @SerializedName("reserveFlag")
    private boolean reserveFlag;

    /**
     * 计划结束时间
     */
    @SerializedName("reserveStartTime")
    private String reserveStartTime;

    /**
     * 计划开始时间
     */
    @SerializedName("reserveEndTime")
    private String reserveEndTime;

    /**
     * 两种模式的预约状态
     */
    @SerializedName("reserveStatusMap")
    private Object reserveStatusMap;

    public String getPlanId() {
        return planId;
    }

    public String getPlanName() {
        return planName;
    }

    public String getStandardType() {
        return standardType;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getStandardId() {
        return standardId;
    }

    public String getOriginStandardId() {
        return originStandardId;
    }

    public List<Object> getSportList() {
        return sportList;
    }

    public List<Object> getClassIds() {
        return classIds;
    }

    public List<Object> getClasses() {
        return classes;
    }

    public Object getDayConfigsMap() {
        return dayConfigsMap;
    }

    public Object getDateConfigsMap() {
        return dateConfigsMap;
    }

    public String getClassAllFlag() {
        return classAllFlag;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalFullCredit() {
        return totalFullCredit;
    }

    public String getFormula() {
        return formula;
    }

    public double getPayPrice() {
        return payPrice;
    }

    public boolean getDistributeFlag() {
        return distributeFlag;
    }

    public boolean getClazzAllFlag() {
        return clazzAllFlag;
    }

    public boolean getSignUpFlag() {
        return signUpFlag;
    }

    public int getFullCreditType() {
        return fullCreditType;
    }

    public int getRound() {
        return round;
    }

    public int getDecimalPrecision() {
        return decimalPrecision;
    }

    public int getPayType() {
        return payType;
    }

    public int getSelfTest() {
        return selfTest;
    }

    public String getOrgId() {
        return orgId;
    }

    public boolean getDelFlag() {
        return delFlag;
    }

    public boolean getReserveFlag() {
        return reserveFlag;
    }

    public String getReserveStartTime() {
        return reserveStartTime;
    }

    public String getReserveEndTime() {
        return reserveEndTime;
    }

    public Object getReserveStatusMap() {
        return reserveStatusMap;
    }
}
