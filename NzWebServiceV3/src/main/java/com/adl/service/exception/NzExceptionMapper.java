package com.adl.service.exception;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.log.NzLog;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

import retrofit2.HttpException;

/**
 * 将可抛出的异常映射成 SDK 统一异常类型（简单框架）。
 */
public final class NzExceptionMapper {

    private NzExceptionMapper() {
    }

    public static boolean isInterruptedException(Throwable t) {
        Throwable current = t;
        while (current != null && current.getCause() != current) {
            if (current instanceof InterruptedException) {
                return true;
            }
            current = current.getCause();
        }
        return false;
    }

    public static boolean isCatchException(Throwable throwable) {
        if (isNeedCatch(throwable)) {
            return true;
        }
        Throwable current = throwable;
        while (current != null && current.getCause() != current) {
            current = current.getCause();
            if (isNeedCatch(current)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNeedCatch(Throwable throwable) {
        if (throwable == null) {
            return false;
        }
        if (throwable instanceof NzBaseException) {
            return true;
        }
        if (throwable instanceof IOException) {
            return true;
        }
        if (throwable instanceof HttpException) {
            return true;
        }
        if (throwable instanceof CancellationException) {
            return true;
        }
        if (throwable instanceof TimeoutException) {
            return true;
        }
        if (throwable instanceof InterruptedException) {
            return true;
        }
        if (throwable instanceof JsonParseException) {
            return true;
        }
        return false;
    }

    public static ResponseResult createExceptioResult(Throwable throwable) {
        Throwable current = throwable;
        ResponseResult result = createExceptioResultInner(current);
        while (result == null && current.getCause() != null && current.getCause() != current) {
            current = current.getCause();
            result = createExceptioResultInner(current);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    private static ResponseResult createExceptioResultInner(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        ResponseResult result = new ResponseResult();
        if (throwable instanceof NzHttpException) {
            result.setCode(((NzHttpException) throwable).getHttpCode());
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof NzDownloadFileException) {
            result.setCode(((NzDownloadFileException) throwable).getCode());
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof NzPersistException) {
            result.setCode(((NzPersistException) throwable).getCode());
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof NzBaseException) {
            result.setCode(NzResponseCode.NZ_UNKNOWN_ERROR);
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof IOException) {
            result.setCode(NzResponseCode.NZ_IO_ERROR);
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof UnknownHostException) {
            result.setCode(NzResponseCode.NZ_NETWORK_ERROR);
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof ConnectException) {
            result.setCode(NzResponseCode.NZ_CONNECT_ERROR);
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof HttpException) {
            result.setCode(((HttpException) throwable).code());
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof CancellationException || throwable instanceof InterruptedException) {
            result.setCode(NzResponseCode.NZ_INTERRUPTED_ERROR);
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof TimeoutException) {
            result.setCode(NzResponseCode.NZ_TIMEOUT_ERROR);
            result.setMsg(throwable.getMessage());
            return result;
        }
        if (throwable instanceof JsonParseException) {
            result.setCode(NzResponseCode.NZ_JSON_PARSE_ERROR);
            result.setMsg(throwable.getMessage());
            return result;
        }
        return null;
    }

    public static NzBaseException map(Throwable throwable) {
        if (throwable == null) {
            return new NzUnknownException("unknown error", null);
        }
        if (throwable instanceof NzBaseException) {
            return (NzBaseException) throwable;
        }

        Throwable root = throwable;
        // 简化：不断往 cause 下找，尽量找到真实根因
        while (root.getCause() != null && root.getCause() != root) {
            root = root.getCause();
        }

        if (root instanceof NzBaseException) {
            return (NzBaseException) root;
        }

        if (root instanceof IOException) {
            return new NzIOException(root.getMessage() != null ? root.getMessage() : "io error", root);
        }
        if (root instanceof HttpException) {
            HttpException he = (HttpException) root;
            String msg = he.message() != null ? he.message() : ("http error " + he.code());
            return new NzHttpException(he.code(), msg, he);
        }

        String msg = root.getMessage() != null ? root.getMessage() : throwable.getMessage();
        return new NzCommonException(msg != null ? msg : "common error", throwable);
    }

    public static String toMessage(Throwable throwable) {
        NzLog.i("NzExceptionMapper : toMessage : " + throwable);
        throwable.printStackTrace();
        NzBaseException ex = map(throwable);
        String msg = ex.getMessage();
        return throwable.getClass().getSimpleName() + ": " + (msg != null ? msg : ex.toString());
    }
}

