package com.adl.service.db.entity;

import androidx.annotation.RestrictTo;

import android.util.Pair;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class TempUploadRecordEntity {
    //  Pair<RemoteFileName,LocalPath>
    private List<Pair<String, String>> filePath;
    private SportRecordEntity sportUploadRecord;
}
