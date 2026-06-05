package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class TeacherData implements Serializable {

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
    private Integer userSex = 0;

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
    private Long createTime = 0L;

    @SerializedName("updateTime")
    private Long updateTime = 0L;

    @SerializedName("avatarFlag")
    private Boolean avatarFlag = Boolean.FALSE;

    @SerializedName("recordFlag")
    private Boolean recordFlag = Boolean.FALSE;

    @SerializedName("delFlag")
    private Boolean delFlag = Boolean.FALSE;

    @SerializedName("faceDataList")
    private List<FaceData> faceDataList;
}
