package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class TeacherData {

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
}
