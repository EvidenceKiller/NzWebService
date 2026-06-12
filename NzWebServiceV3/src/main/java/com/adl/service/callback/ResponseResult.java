package com.adl.service.callback;

import com.adl.service.common.NzResponseCode;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class ResponseResult<T> {

    /**
     * 业务状态码
     */
    private Integer code = 0;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 业务数据
     */
    private T data;

    public boolean isSuccessWithData() {
        return isSuccess() && hasData();
    }

    public boolean isSuccess() {
        return code != null && code == NzResponseCode.NZ_SUCCESS;
    }

    public boolean hasData() {
        if (data == null) {
            return false;
        }
        if (data instanceof List) {
            return !((List<?>) data).isEmpty();
        }
        return true;
    }
}
