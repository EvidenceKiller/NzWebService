package com.adl.service.web.response;

import com.adl.service.internal.StrictJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonAdapter(StrictJsonDeserializer.class)
public final class WikiPageData {

    @SerializedName("totalPages")
    private Integer totalPages;

    @SerializedName("totalElements")
    private Long totalElements;

    @SerializedName("size")
    private Integer size;

    @SerializedName("content")
    private List<Object> content;

    @SerializedName("number")
    private Integer number;

    @SerializedName("sort")
    private Object sort;

    @SerializedName("first")
    private Boolean first;

    @SerializedName("last")
    private Boolean last;

    @SerializedName("numberOfElements")
    private Integer numberOfElements;

    @SerializedName("pageable")
    private Object pageable;

    @SerializedName("empty")
    private Boolean empty;
}
