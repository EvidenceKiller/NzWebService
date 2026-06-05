package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import java.io.Serializable;

import lombok.Data;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/3
 * Describe   : 视频集
 */
@Data
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SportVideoEntity implements Serializable {

    //  视频相对地址
    private String videoUrl = "";

    //  视频封面图
    private String videoCover = "";

    //  视频说明
    private String videoDesc = "";

    public SportVideoEntity() {
    }

    public SportVideoEntity(String videoUrl, String videoCover, String videoDesc) {
        this.videoUrl = videoUrl;
        this.videoCover = videoCover;
        this.videoDesc = videoDesc;
    }

    public SportVideoEntity toCopy() {
        SportVideoEntity entity = new SportVideoEntity();
        entity.setVideoUrl(this.videoUrl);
        entity.setVideoCover(this.videoCover);
        entity.setVideoDesc(this.videoDesc);
        return entity;
    }
}
