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
public final class SportSkuDescData implements Serializable {
    /**
     * id
     */
    @SerializedName("id")
    private String id;

    /**
     * title
     */
    @SerializedName("title")
    private String title;

    /**
     * context
     */
    @SerializedName("context")
    private String context;
}
