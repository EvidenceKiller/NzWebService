package com.adl.service.data;

import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
@EqualsAndHashCode(callSuper=false)
public final class ReportSportStudentPlanData extends ReportSportStudentData implements Serializable {
    @SerializedName("sportPlan")
    private ReportSportPlanData sportPlan;

    @SerializedName("reqDataSportIndicators")
    private List<SportIndicatorsData> reqDataSportIndicators;
}
