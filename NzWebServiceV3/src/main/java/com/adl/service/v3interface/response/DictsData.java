package com.adl.service.v3interface.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class DictsData {

    @SerializedName("noPaging")
    private boolean noPaging;

    @SerializedName("pageSize")
    private long pageSize;

    @SerializedName("current")
    private long current;

    @SerializedName("detail")
    private boolean detail;

    @SerializedName("enableSort")
    private boolean enableSort;

    @SerializedName("sorts")
    private List<Object> sorts;

    @SerializedName("sortsStr")
    private String sortsStr;

    @SerializedName("ignoreColumns")
    private List<Object> ignoreColumns;

    @SerializedName("containColumns")
    private List<Object> containColumns;

    @SerializedName("moduleStr")
    private String moduleStr;

    /** 主键 ID */
    @SerializedName("id")
    private String id;

    /** 字典编码 */
    @SerializedName("dictCode")
    private String dictCode;

    /** 字典值 */
    @SerializedName("dictValue")
    private String dictValue;

    /** 字典显示 */
    @SerializedName("dictLabel")
    private String dictLabel;

    /** 排序 升序 */
    @SerializedName("sortNum")
    private int sortNum;

    /** 是否默认 */
    @SerializedName("defaultFlag")
    private String defaultFlag;

    /** 扩展 json 扩展 json，存储扩展值可使用 */
    @SerializedName("extData")
    private String extData;

    /** 备注 */
    @SerializedName("remark")
    private String remark;

    /** 语言类型 */
    @SerializedName("lang")
    private String lang;

    /** 创建时间 */
    @SerializedName("createTime")
    private String createTime;

    /** 更新时间 */
    @SerializedName("updateTime")
    private String updateTime;

    /** 字典数据类型 1-string 2-number 3-bool */
    @SerializedName("dataType")
    private int dataType;

    public boolean getNoPaging() { return noPaging; }
    public long getPageSize() { return pageSize; }
    public long getCurrent() { return current; }
    public boolean getDetail() { return detail; }
    public boolean getEnableSort() { return enableSort; }
    public List<Object> getSorts() { return sorts; }
    public String getSortsStr() { return sortsStr; }
    public List<Object> getIgnoreColumns() { return ignoreColumns; }
    public List<Object> getContainColumns() { return containColumns; }
    public String getModuleStr() { return moduleStr; }
    public String getId() { return id; }
    public String getDictCode() { return dictCode; }
    public String getDictValue() { return dictValue; }
    public String getDictLabel() { return dictLabel; }
    public int getSortNum() { return sortNum; }
    public String getDefaultFlag() { return defaultFlag; }
    public String getExtData() { return extData; }
    public String getRemark() { return remark; }
    public String getLang() { return lang; }
    public String getCreateTime() { return createTime; }
    public String getUpdateTime() { return updateTime; }
    public int getDataType() { return dataType; }
}
