package com.adl.service.db.entity;

import com.adl.service.db.converter.ListFaceDataConverter;
import com.adl.service.internal.StrictJsonDeserializer;
import com.adl.service.web.response.TeacherData;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.TypeConverters;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity(tableName = "_teacher")
public final class TeacherEntity {

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
    private Integer userSex;

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
    private Boolean avatarFlag;

    @SerializedName("recordFlag")
    private Boolean recordFlag;

    @SerializedName("delFlag")
    private Boolean delFlag;

    public static TeacherEntity convertToEntity(TeacherData teacherData) {
        if (teacherData == null) {
            return null;
        }
        TeacherEntity entity = new TeacherEntity();
        entity.setUserId(teacherData.getUserId());
        entity.setAccountId(teacherData.getAccountId());
        entity.setAccountName(teacherData.getAccountName());
        entity.setAccountNum(teacherData.getAccountNum());
        entity.setAccountPhoneNum(teacherData.getAccountPhoneNum());
        entity.setUserSex(teacherData.getUserSex());
        entity.setJobNum(teacherData.getJobNum());
        entity.setAccountAvatar(teacherData.getAccountAvatar());
        entity.setAccountNamePinYin(teacherData.getAccountNamePinYin());
        entity.setAccountNameFirstLetterPinYin(teacherData.getAccountNameFirstLetterPinYin());
        entity.setUserFaceImgUrl(teacherData.getUserFaceImgUrl());
        entity.setThumbnailUserFaceImgUrl(teacherData.getThumbnailUserFaceImgUrl());
        entity.setCreateTime(teacherData.getCreateTime());
        entity.setUpdateTime(teacherData.getUpdateTime());
        entity.setAvatarFlag(teacherData.getAvatarFlag());
        entity.setRecordFlag(teacherData.getRecordFlag());
        entity.setDelFlag(teacherData.getDelFlag());
        return entity;
    }

    public static TeacherData convertToData(TeacherEntity entity) {
        if (entity == null) {
            return null;
        }
        TeacherData data = new TeacherData();
        data.setUserId(entity.getUserId());
        data.setAccountId(entity.getAccountId());
        data.setAccountName(entity.getAccountName());
        data.setAccountNum(entity.getAccountNum());
        data.setAccountPhoneNum(entity.getAccountPhoneNum());
        data.setUserSex(entity.getUserSex());
        data.setJobNum(entity.getJobNum());
        data.setAccountAvatar(entity.getAccountAvatar());
        data.setAccountNamePinYin(entity.getAccountNamePinYin());
        data.setAccountNameFirstLetterPinYin(entity.getAccountNameFirstLetterPinYin());
        data.setUserFaceImgUrl(entity.getUserFaceImgUrl());
        data.setThumbnailUserFaceImgUrl(entity.getThumbnailUserFaceImgUrl());
        data.setCreateTime(entity.getCreateTime());
        data.setUpdateTime(entity.getUpdateTime());
        data.setAvatarFlag(entity.getAvatarFlag());
        data.setRecordFlag(entity.getRecordFlag());
        data.setDelFlag(entity.getDelFlag());
        return data;
    }
}