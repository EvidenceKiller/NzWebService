package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class BaseLoginAccountRoleMenu {
    /**
     * 菜单id
     */
    @SerializedName("menuId")
    private String menuId;

    /**
     * 菜单名
     */
    @SerializedName("menuName")
    private String menuName;

    /**
     * 功能菜单路径
     */
    @SerializedName("menuPath")
    private String menuPath;

    /**
     * 菜单权限标识
     */
    @SerializedName("menuPermission")
    private String menuPermission;

    /**
     * 菜单类型 0：菜单 1：按钮
     */
    @SerializedName("menuType")
    private String menuType;

    /**
     * 父级菜单id
     */
    @SerializedName("pid")
    private String pid;

    /**
     * 菜单排序标识符
     */
    @SerializedName("sortNum")
    private int sortNum;

    /**
     * 菜单使用平台
     */
    @SerializedName("platform")
    private String platform;

    /**
     * 是否是跳转菜单
     */
    @SerializedName("redirectFlag")
    private int redirectFlag;

    public String getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public String getMenuPermission() {
        return menuPermission;
    }

    public String getMenuType() {
        return menuType;
    }

    public String getPid() {
        return pid;
    }

    public int getSortNum() {
        return sortNum;
    }

    public String getPlatform() {
        return platform;
    }

    public int getRedirectFlag() {
        return redirectFlag;
    }

}
