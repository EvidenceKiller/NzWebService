package com.adl.service.v3interface.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 分页请求公共字段。
 */
public class BasePageRequest {

    @SerializedName("noPaging")
    protected boolean noPaging;

    @SerializedName("pageSize")
    protected long pageSize;

    @SerializedName("current")
    protected long current;

    @SerializedName("detail")
    protected boolean detail;

    @SerializedName("enableSort")
    protected boolean enableSort;

    @SerializedName("sorts")
    protected List<BaseSort> sorts;

    @SerializedName("sortsStr")
    protected String sortsStr;

    @SerializedName("ignoreColumns")
    protected List<String> ignoreColumns;

    @SerializedName("containColumns")
    protected List<String> containColumns;

    @SerializedName("moduleStr")
    protected String moduleStr;

    protected BasePageRequest() {
    }

    protected BasePageRequest(Builder<?> builder) {
        this.noPaging = builder.noPaging;
        this.pageSize = builder.pageSize;
        this.current = builder.current;
        this.detail = builder.detail;
        this.enableSort = builder.enableSort;
        this.sorts = builder.sorts;
        this.sortsStr = builder.sortsStr;
        this.ignoreColumns = builder.ignoreColumns;
        this.containColumns = builder.containColumns;
        this.moduleStr = builder.moduleStr;
    }

    public static abstract class Builder<T extends Builder<T>> {
        protected boolean noPaging;
        protected long pageSize;
        protected long current;
        protected boolean detail;
        protected boolean enableSort;
        protected List<BaseSort> sorts;
        protected String sortsStr;
        protected List<String> ignoreColumns;
        protected List<String> containColumns;
        protected String moduleStr;

        protected abstract T self();

        public T noPaging(boolean noPaging) {
            this.noPaging = noPaging;
            return self();
        }

        public T pageSize(long pageSize) {
            this.pageSize = pageSize;
            return self();
        }

        public T current(long current) {
            this.current = current;
            return self();
        }

        public T detail(boolean detail) {
            this.detail = detail;
            return self();
        }

        public T enableSort(boolean enableSort) {
            this.enableSort = enableSort;
            return self();
        }

        public T sorts(List<BaseSort> sorts) {
            this.sorts = sorts;
            return self();
        }

        public T sortsStr(String sortsStr) {
            this.sortsStr = sortsStr;
            return self();
        }

        public T ignoreColumns(List<String> ignoreColumns) {
            this.ignoreColumns = ignoreColumns;
            return self();
        }

        public T containColumns(List<String> containColumns) {
            this.containColumns = containColumns;
            return self();
        }

        public T moduleStr(String moduleStr) {
            this.moduleStr = moduleStr;
            return self();
        }
    }

    public boolean getNoPaging() { return noPaging; }
    public long getPageSize() { return pageSize; }
    public long getCurrent() { return current; }
    public boolean getDetail() { return detail; }
    public boolean getEnableSort() { return enableSort; }
    public List<BaseSort> getSorts() { return sorts; }
    public String getSortsStr() { return sortsStr; }
    public List<String> getIgnoreColumns() { return ignoreColumns; }
    public List<String> getContainColumns() { return containColumns; }
    public String getModuleStr() { return moduleStr; }
}
