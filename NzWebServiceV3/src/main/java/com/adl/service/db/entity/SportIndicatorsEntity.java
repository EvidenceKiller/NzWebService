package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProjectName: AiPowerAuth
 * Author     : viwenzhang
 * Date       : 2024/7/31
 * Describe   : 运动记录
 */
@Data
@NoArgsConstructor
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SportIndicatorsEntity<VALUE, REMARK> implements Serializable {
    //  指标code
    private String indicatorsCode;
    //  指标名称
    private String indicatorsName;
    //  指标值
    private VALUE indicatorsValue;
    //  指标描述
    private REMARK indicatorsRemark;
    //  指标单位
    private String indicatorsUnit;
    //  指标视频
    private List<SportVideoEntity> indicatorsVideos;
    //  指标图片
    private List<SportImageEntity> indicatorsImages;

    public SportIndicatorsEntity<VALUE, REMARK> toCopy() {
        SportIndicatorsEntity<VALUE, REMARK> entity = new SportIndicatorsEntity<>();
        entity.setIndicatorsCode(this.indicatorsCode);
        entity.setIndicatorsName(this.indicatorsName);
        entity.setIndicatorsValue(this.indicatorsValue);
        entity.setIndicatorsRemark(this.indicatorsRemark);
        entity.setIndicatorsUnit(this.indicatorsUnit);
        entity.setIndicatorsVideos(this.indicatorsVideos);
        entity.setIndicatorsImages(this.indicatorsImages);
        return entity;
    }
}
