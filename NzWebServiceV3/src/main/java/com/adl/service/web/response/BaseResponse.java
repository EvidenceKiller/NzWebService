package com.adl.service.web.response;

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
public final class BaseResponse<T> {

    /** 业务状态码 */
    private int code;

    /** 提示信息 */
    private String msg;

    /** 是否成功标志位 */
    private boolean succeed;

    /** 业务数据 */
    private T data;

    // ---- Getter ----
    public int getCode()       { return code; }
    public String getMsg() { return msg; }
    public T getData()         { return data; }
    public boolean isSuccess() { return succeed; }

    @Override
    public String toString() {
        return "BaseResponse{code=" + code + ", message='" + msg + "', succeed=" + succeed + ", data=" + data + "}";
    }
}
