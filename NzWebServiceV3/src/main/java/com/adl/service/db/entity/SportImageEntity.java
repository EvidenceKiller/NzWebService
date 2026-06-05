package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/3
 * Describe   : 图片集
 */
@Data
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SportImageEntity implements Serializable {

    //  图片相对地址
    private String imageUrl = "";

    //  运动分析图片说明
    private String motionAnalysisImageDesc;

    //  图片说明
    private String imageDesc = "";

    private String groupIndex;

    public SportImageEntity() {
    }

    public SportImageEntity(String imageUrl, String imageDesc) {
        this.imageUrl = imageUrl;
        this.imageDesc = imageDesc;
    }

    public SportImageEntity(String imageDesc, String imageUrl, String groupIndex) {
        this.imageUrl = imageUrl;
        this.imageDesc = imageDesc;
        this.groupIndex = groupIndex;
    }

    public SportImageEntity(String imageUrl, String imageDesc, String motionAnalysisImageDesc, String groupIndex) {
        this.imageUrl = imageUrl;
        this.imageDesc = imageDesc;
        this.groupIndex = groupIndex;
        this.motionAnalysisImageDesc = motionAnalysisImageDesc;
    }

    public SportImageEntity toCopy() {
        SportImageEntity entity = new SportImageEntity();
        entity.setImageUrl(this.imageUrl);
        entity.setImageDesc(this.imageDesc);
        entity.setGroupIndex(this.groupIndex);
        entity.setMotionAnalysisImageDesc(this.motionAnalysisImageDesc);
        return entity;
    }
}
