package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class SportMeetSimpleClassData implements Serializable {
    @SerializedName("id")
    private Integer id = 0;

    /**
     * 机构Id
     */
    @SerializedName("orgId")
    private String orgId;

    /**
     * 运动会Id
     */
    @SerializedName("sportMeetId")
    private String sportMeetId;

    /**
     * 报名人数
     */
    @SerializedName("applyUserCount")
    private Integer applyUserCount = 0;

    /**
     * 班级Id
     */
    @SerializedName("classId")
    private String classId;

    @SerializedName("createTime")
    private Long createTime = 0L;

    @SerializedName("updateTime")
    private Long updateTime = 0L;
}
