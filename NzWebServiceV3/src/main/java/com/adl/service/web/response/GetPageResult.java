package com.adl.service.web.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页同步结果摘要（不返回全量数据）。
 */
@Data
@NoArgsConstructor
public final class GetPageResult {

    /** 本次同步任务 ID。 */
    private String uuId;

    /** 是否成功。 */
    private boolean success = true;

    /** 后端声明的总页数（仅 BasePageData 模式可用）。 */
    private long totalPages;

    /** 成功处理的页数。 */
    private long successedPages;

    /** 拉取到的总记录数。 */
    private long fetchedCount;

    /** 持久化处理后的总记录数。 */
    private long persistedCount;

    /** 结果说明（成功/失败原因）。 */
    private String message = "success";
}
