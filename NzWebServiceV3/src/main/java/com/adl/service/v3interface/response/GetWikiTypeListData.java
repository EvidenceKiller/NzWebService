package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public final class GetWikiTypeListData {
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

    @SerializedName("empty")
    private boolean empty;

    @SerializedName("sorted")
    private boolean sorted;

    @SerializedName("unsorted")
    private boolean unsorted;

    @SerializedName("first")
    private boolean first;

    @SerializedName("last")
    private boolean last;

    @SerializedName("numberOfElements")
    private int numberOfElements;

    @SerializedName("pageable")
    private Object pageable;

    @SerializedName("offset")
    private long offset;

    @SerializedName("sort")
    private Object sort;

    @SerializedName("empty")
    private boolean empty;

    @SerializedName("sorted")
    private boolean sorted;

    @SerializedName("unsorted")
    private boolean unsorted;

    @SerializedName("pageSize")
    private int pageSize;

    @SerializedName("paged")
    private boolean paged;

    @SerializedName("pageNumber")
    private int pageNumber;

    @SerializedName("unpaged")
    private boolean unpaged;

    @SerializedName("empty")
    private boolean empty;

    public int getTotalPages() { return totalPages; }
    public long getTotalElements() { return totalElements; }
    public int getSize() { return size; }
    public List<Object> getContent() { return content; }
    public int getNumber() { return number; }
    public Object getSort() { return sort; }
    public boolean getEmpty() { return empty; }
    public boolean getSorted() { return sorted; }
    public boolean getUnsorted() { return unsorted; }
    public boolean getFirst() { return first; }
    public boolean getLast() { return last; }
    public int getNumberOfElements() { return numberOfElements; }
    public Object getPageable() { return pageable; }
    public long getOffset() { return offset; }
    public Object getSort() { return sort; }
    public boolean getEmpty() { return empty; }
    public boolean getSorted() { return sorted; }
    public boolean getUnsorted() { return unsorted; }
    public int getPageSize() { return pageSize; }
    public boolean getPaged() { return paged; }
    public int getPageNumber() { return pageNumber; }
    public boolean getUnpaged() { return unpaged; }
    public boolean getEmpty() { return empty; }
}