package com.adl.service.web.response;

import com.adl.service.web.request.BaseLoginAccount;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class LoginInfoData {

    /**
     * 设备标识码（设备侧相关用户登录必传字段）
     */
    @SerializedName("deviceId")
    private String deviceId;

    /**
     * 应用端编码
     */
    @SerializedName("appCodes")
    private List<String> appCodes;

    /**
     * 平台号（参考platformEnum）
     */
    @SerializedName("platform")
    private String platform;

    @SerializedName("openId")
    private String openId;

    /**
     * 租户id集合
     */
    @SerializedName("tenantIds")
    private List<String> tenantIds;

    /**
     * 用戶id
     */
    @SerializedName("userId")
    private String userId;

    /**
     * 用户姓名
     */
    @SerializedName("userName")
    private String userName;

    /**
     * 用户联系方式（包括手机号，座机号等）
     */
    @SerializedName("userTel")
    private String userTel;

    @SerializedName("height")
    private String height;

    @SerializedName("weight")
    private String weight;

    /**
     * 用户邮箱
     */
    @SerializedName("userEmail")
    private String userEmail;

    /**
     * 用户性别 1 男， 2 女
     */
    @SerializedName("userSex")
    private int userSex;

    /**
     * 用戶证件类型
     */
    @SerializedName("certType")
    private int certType;

    /**
     * 用户证件号
     */
    @SerializedName("certNum")
    private String certNum;

    /**
     * 账户人脸头像
     */
    @SerializedName("faceImgUrl")
    private String faceImgUrl;

    /**
     * 民族编码
     */
    @SerializedName("nationCode")
    private String nationCode;

    /**
     * 民族名
     */
    @SerializedName("nationName")
    private String nationName;

    /**
     * 生日
     */
    @SerializedName("birthday")
    private String birthday;

    /**
     * 学籍号
     */
    @SerializedName("studentCode")
    private String studentCode;

    @SerializedName("lang")
    private String lang;

    @SerializedName("inner")
    private boolean inner;

    /**
     * 账号信息列表
     */
    @SerializedName("accounts")
    private List<BaseLoginAccount> accounts;

    public String getDeviceId() {
        return deviceId;
    }

    public List<String> getAppCodes() {
        return appCodes;
    }

    public String getPlatform() {
        return platform;
    }

    public String getOpenId() {
        return openId;
    }

    public List<String> getTenantIds() {
        return tenantIds;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getUserSex() {
        return userSex;
    }

    public int getCertType() {
        return certType;
    }

    public String getCertNum() {
        return certNum;
    }

    public String getFaceImgUrl() {
        return faceImgUrl;
    }

    public String getNationCode() {
        return nationCode;
    }

    public String getNationName() {
        return nationName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getLang() {
        return lang;
    }

    public boolean getInner() {
        return inner;
    }

    public List<BaseLoginAccount> getAccounts() {
        return accounts;
    }
}
