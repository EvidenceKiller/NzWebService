package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;



public final class GetTeacherListData {
    @SerializedName("userId")
    private String userId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("accountName")
    private String accountName;

    @SerializedName("accountNum")
    private String accountNum;

    @SerializedName("accountPhoneNum")
    private String accountPhoneNum;

    @SerializedName("userSex")
    private int userSex;

    @SerializedName("jobNum")
    private String jobNum;

    @SerializedName("accountAvatar")
    private String accountAvatar;

    @SerializedName("accountNamePinYin")
    private String accountNamePinYin;

    @SerializedName("accountNameFirstLetterPinYin")
    private String accountNameFirstLetterPinYin;

    @SerializedName("userFaceImgUrl")
    private String userFaceImgUrl;

    @SerializedName("thumbnailUserFaceImgUrl")
    private String thumbnailUserFaceImgUrl;

    @SerializedName("createTime")
    private String createTime;

    @SerializedName("updateTime")
    private String updateTime;

    @SerializedName("avatarFlag")
    private boolean avatarFlag;

    @SerializedName("recordFlag")
    private boolean recordFlag;

    @SerializedName("delFlag")
    private boolean delFlag;

    public String getUserId() { return userId; }
    public String getAccountId() { return accountId; }
    public String getAccountName() { return accountName; }
    public String getAccountNum() { return accountNum; }
    public String getAccountPhoneNum() { return accountPhoneNum; }
    public int getUserSex() { return userSex; }
    public String getJobNum() { return jobNum; }
    public String getAccountAvatar() { return accountAvatar; }
    public String getAccountNamePinYin() { return accountNamePinYin; }
    public String getAccountNameFirstLetterPinYin() { return accountNameFirstLetterPinYin; }
    public String getUserFaceImgUrl() { return userFaceImgUrl; }
    public String getThumbnailUserFaceImgUrl() { return thumbnailUserFaceImgUrl; }
    public String getCreateTime() { return createTime; }
    public String getUpdateTime() { return updateTime; }
    public boolean getAvatarFlag() { return avatarFlag; }
    public boolean getRecordFlag() { return recordFlag; }
    public boolean getDelFlag() { return delFlag; }
}