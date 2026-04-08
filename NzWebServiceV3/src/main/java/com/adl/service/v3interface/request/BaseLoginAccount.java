package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 账户信息（与接口文档字段对应）。
 */
public final class BaseLoginAccount {

    /**
     * 头像
     */
    @SerializedName("accountAvatar")
    private String accountAvatar;

    /**
     * 用户id
     */
    @SerializedName("accountId")
    private String accountId;

    /**
     * 登录账号名
     */
    @SerializedName("accountName")
    private String accountName;

    /**
     * 用户登录账号
     */
    @SerializedName("accountNum")
    private String accountNum;

    /**
     * 账号手机号
     */
    @SerializedName("accountPhoneNum")
    private String accountPhoneNum;

    /**
     * 当前用户是否激活 true: 是 false: 不是
     */
    @SerializedName("enabled")
    private boolean enabled;

    /**
     * 机构编码
     */
    @SerializedName("orgCode")
    private String orgCode;

    /**
     * 机构id
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * 机构名称
     */
    @SerializedName("orgName")
    private String orgName;

    /**
     * 机构类型
     */
    @SerializedName("orgType")
    private String orgType;

    /**
     * 是否当前登录用户 true: 是 false: 不是
     */
    @SerializedName("presentFlag")
    private boolean presentFlag;

    /**
     * 当前执行身份
     */
    @SerializedName("roleType")
    private int roleType;

    /**
     * 角色集
     */
    @SerializedName("roles")
    private List<BaseLoginAccountRole> roles;

    public String getAccountAvatar() {
        return accountAvatar;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAccountPhoneNum() {
        return accountPhoneNum;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public boolean isPresentFlag() {
        return presentFlag;
    }

    public int getRoleType() {
        return roleType;
    }

    public List<BaseLoginAccountRole> getRoles() {
        return roles;
    }
}
