package com.adl.service.data;

import java.io.Serializable;
import com.adl.service.internal.json.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAdapter(StrictJsonDeserializer.class)
public final class BasePageData<T> implements Serializable {

    @SerializedName("records")
    private List<T> records;

    @SerializedName("total")
    private Long total = 0L;

    @SerializedName("size")
    private Long size = 0L;

    @SerializedName("current")
    private Long current = 0L;

    @SerializedName("pages")
    private Long pages = 0L;
}
