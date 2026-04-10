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
    private int totalPages;

    @SerializedName("totalElements")
    private long totalElements;

    @SerializedName("size")
    private int size;

    @SerializedName("content")
    private List<Object> content;

    @SerializedName("number")
    private int number;

    @SerializedName("sort")
    private Object sort;

    @SerializedName("first")
    private boolean first;

    @SerializedName("last")
    private boolean last;

    @SerializedName("numberOfElements")
    private int numberOfElements;

    @SerializedName("pageable")
    private Object pageable;

    @SerializedName("empty")
    private boolean empty;
}
