package com.adl.service.exception;

import com.adl.service.data.PageSummaryData;

public final class NzGetPageException extends NzBaseException {
    private static final String TAG = "NZ_PAGE_REQUEST_EXCEPTION";

    private final PageSummaryData result;

    public NzGetPageException(PageSummaryData result) {
        super(TAG, result.getMessage());
        this.result = result;
    }

    public NzGetPageException(PageSummaryData result, Throwable cause) {
        super(TAG, result.getMessage(), cause);
        this.result = result;
    }

    public PageSummaryData getResult() {
        return result;
    }
}
