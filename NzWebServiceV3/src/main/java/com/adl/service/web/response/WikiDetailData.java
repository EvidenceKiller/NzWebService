package com.adl.service.web.response;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString
public final class WikiDetailData {

    /** 运动百科id，唯一 */
    @SerializedName("wikiId")
    private String wikiId;

    /** 运动百科封面地址 */
    @SerializedName("wikiCover")
    private String wikiCover;

    /** 标题 */
    @SerializedName("wikiName")
    private String wikiName;

    /** 内容形式 */
    @SerializedName("wikiType")
    private String wikiType;

    /** 百科内容 */
    @SerializedName("wikiContext")
    private String wikiContext;

    /** 状态 */
    @SerializedName("enabled")
    private boolean enabled;

    /** 排序 */
    @SerializedName("wikiSort")
    private String wikiSort;

    /** 分类id */
    @SerializedName("wikiTypeIds")
    private List<Object> wikiTypeIds;

    /** 应用编码集合 */
    @SerializedName("appCodes")
    private List<Object> appCodes;

    /** 创建时间 */
    @SerializedName("createTime")
    private String createTime;

    /** 百科视频列表 */
    @SerializedName("wikiVideo")
    private List<Object> wikiVideo;

    public String getWikiId() { return wikiId; }
    public String getWikiCover() { return wikiCover; }
    public String getWikiName() { return wikiName; }
    public String getWikiType() { return wikiType; }
    public String getWikiContext() { return wikiContext; }
    public boolean getEnabled() { return enabled; }
    public String getWikiSort() { return wikiSort; }
    public List<Object> getWikiTypeIds() { return wikiTypeIds; }
    public List<Object> getAppCodes() { return appCodes; }
    public String getCreateTime() { return createTime; }
    public List<Object> getWikiVideo() { return wikiVideo; }
}
