package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class ResTabData implements Serializable {

    /**
     * 主键ID
     */
    @SerializedName("id")
    private String id;

    /**
     * 分类名称
     */
    @SerializedName("tabName")
    private String tabName;

    @SerializedName("moduleStr")
    private String moduleStr;

    @SerializedName("enabled")
    private String enabled;

    @SerializedName("enableSort")
    private Boolean enableSort = Boolean.FALSE;

    /**
     * 创建时间
     */
    @SerializedName("createTime")
    private Long createTime = 0L;

    /**
     * 更新时间
     */
    @SerializedName("updateTime")
    private Long updateTime = 0L;
}
