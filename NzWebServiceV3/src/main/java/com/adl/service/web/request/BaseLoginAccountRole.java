package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class BaseLoginAccountRole {
    /**
     *
     */
    @SerializedName("presentFlag")
    private boolean presentFlag;

    /**
     * 角色id
     */
    @SerializedName("roleId")
    private String roleId;

    /**
     * 角色名
     */
    @SerializedName("roleName")
    private String roleName;

    /**
     * 角色类型
     */
    @SerializedName("roleType")
    private String roleType;

    /**
     * 是否为系统预制角色: true: 是, false: 否
     */
    @SerializedName("systemFlag")
    private boolean systemFlag;

    /**
     * 菜单集
     */
    @SerializedName("menus")
    private List<BaseLoginAccountRoleMenu> menus;

    public boolean isPresentFlag() {
        return presentFlag;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public boolean isSystemFlag() {
        return systemFlag;
    }

    public List<BaseLoginAccountRoleMenu> getMenus() {
        return menus;
    }
}
