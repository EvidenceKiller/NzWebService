package com.adl.service.data;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结构
 * 对应后端 JSON：
 * <pre>
 * {
 *   "code": 0,
 *   "message": "success",
 *   "data": { ... }
 * }
 * </pre>
 *
 * @param <T> 业务数据类型
 */
@Data
@NoArgsConstructor
public final class BaseResponse<T> {

    /**
     * 业务状态码
     */
    @SerializedName("code")
    private Integer code = 0;

    /**
     * 提示信息
     */
    @SerializedName("msg")
    private String msg;

    /**
     * 是否成功标志位
     */
    @SerializedName("succeed")
    private Boolean succeed = Boolean.FALSE;

    /**
     * 业务数据
     */
    @SerializedName("data")
    private T data;
}
