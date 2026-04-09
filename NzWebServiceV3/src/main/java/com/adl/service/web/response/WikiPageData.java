package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString
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

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getSize() {
        return size;
    }

    public List<Object> getContent() {
        return content;
    }

    public int getNumber() {
        return number;
    }

    public Object getSort() {
        return sort;
    }

    public boolean getFirst() {
        return first;
    }

    public boolean getLast() {
        return last;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public Object getPageable() {
        return pageable;
    }

    public boolean getEmpty() {
        return empty;
    }
}
