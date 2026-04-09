package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class AccountUserData {
    /**
     * 人脸Base64数据
     */
    @SerializedName("faceBase64")
    private String faceBase64;

    /**
     * 人脸特征值
     */
    @SerializedName("userFaces")
    private List<Object> userFaces;

    /**
     * 用户ID编码
     */
    @SerializedName("id")
    private String id;

    /**
     * 租户id
     */
    @SerializedName("tenantId")
    private String tenantId;

    /**
     * 用户姓名
     */
    @SerializedName("userName")
    private String userName;

    /**
     * 用户邮箱
     */
    @SerializedName("email")
    private String email;

    /**
     * 手机号，非联系电话
     */
    @SerializedName("phoneNumber")
    private String phoneNumber;

    /**
     * 性别 参考字典编码:adltis_user_sex(1男2女9未知)
     */
    @SerializedName("sex")
    private int sex;

    /**
     * 民族代码
     */
    @SerializedName("nationCode")
    private String nationCode;

    /**
     * 人像图片地址 人像图片地址，相对路径，用于人脸检测
     */
    @SerializedName("faceImgUrl")
    private String faceImgUrl;

    /**
     * 证件类型 参考字典编码:adlbms_cert_type(1.身份证)
     */
    @SerializedName("certType")
    private int certType;

    /**
     * 证件号
     */
    @SerializedName("certNum")
    private String certNum;

    /**
     * 学籍号
     */
    @SerializedName("studentCode")
    private String studentCode;

    /**
     * 用户生日
     */
    @SerializedName("birthday")
    private String birthday;

    /**
     * 用户地址
     */
    @SerializedName("address")
    private String address;

    /**
     * 删除标识位0可用1删除
     */
    @SerializedName("delFlag")
    private boolean delFlag;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private String createTime;

    /**
     * 更新时间
     */
    @SerializedName("updateTime")
    private String updateTime;

    public String getFaceBase64() {
        return faceBase64;
    }

    public List<Object> getUserFaces() {
        return userFaces;
    }

    public String getId() {
        return id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSex() {
        return sex;
    }

    public String getNationCode() {
        return nationCode;
    }

    public String getFaceImgUrl() {
        return faceImgUrl;
    }

    public int getCertType() {
        return certType;
    }

    public String getCertNum() {
        return certNum;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public boolean isDelFlag() {
        return delFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }
}
