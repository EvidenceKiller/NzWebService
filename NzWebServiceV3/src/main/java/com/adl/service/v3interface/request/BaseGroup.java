package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class BaseGroup {

    /**
     * 分组ID
     */
    @SerializedName("groupId")
    private String groupId;

    /**
     * 分组班级ID
     */
    @SerializedName("groupClassId")
    private String groupClassId;

    /**
     * 分组名称
     */
    @SerializedName("groupName")
    private String groupName;

    /**
     * 分组序号
     */
    @SerializedName("groupNumber")
    private String groupNumber;

    /**
     * 分组账户信息列表
     */
    @SerializedName("groupAccountInfos")
    private List<Object> groupAccountInfos;

    public String getGroupId() {
        return groupId;
    }

    public String getGroupClassId() {
        return groupClassId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public List<Object> getGroupAccountInfos() {
        return groupAccountInfos;
    }
}
