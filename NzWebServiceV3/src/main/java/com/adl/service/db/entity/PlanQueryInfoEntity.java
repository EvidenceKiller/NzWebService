package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import androidx.room.ColumnInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class PlanQueryInfoEntity {
    @ColumnInfo(name = "_scene_sub_id")
    private String planId;

    @ColumnInfo(name = "_scene_sub_name")
    private String planName;
}
