package com.adl.service.web.request;

import com.google.gson.annotations.SerializedName;

public final class BaseSportVideo {
    /**
     * 视频说明
     */
    @SerializedName("videoDesc")
    private String videoDesc;

    /**
     * 视频相对地址
     */
    @SerializedName("videoUrl")
    private String videoUrl;

    /**
     * 视频封面图
     */
    @SerializedName("videoCover")
    private String videoCover;

    public String getVideoDesc() {
        return videoDesc;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getVideoCover() {
        return videoCover;
    }
}
