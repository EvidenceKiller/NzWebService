package com.adl.service.repository.fetch;

import com.adl.service.data.BasePageData;
import com.adl.service.data.BaseResponse;
import com.adl.service.exception.NzCommonException;
import com.adl.service.exception.NzDownloadFileException;
import com.adl.service.exception.NzHttpException;
import com.adl.service.utils.CommonUtil;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;

class BaseFetchUtil {

    public static <T> Single<T> schedule(Single<T> response, Class<T> clazz) {
        if (response == null) {
            return Single.error(new NzCommonException("response single is null"));
        }
        return response.flatMap(baseResponse -> {
            if (baseResponse == null) {
                return CommonUtil.createEmptySingle(clazz);
            }
            return Single.just(baseResponse);
        });
    }

    public static <T> Single<T> scheduleResponse(Single<BaseResponse<T>> response, Class<T> clazz) {
        if (response == null) {
            return Single.error(new NzCommonException("response single is null"));
        }
        return response.flatMap(baseResponse -> {
            if (baseResponse == null) {
                return Single.error(new NzCommonException("response is null"));
            }
            if (!Boolean.TRUE.equals(baseResponse.getSucceed()) || baseResponse.getCode() != 200) {
                return Single.error(new NzHttpException(baseResponse.getCode(), baseResponse.getMsg()));
            }
            if (baseResponse.getData() == null) {
                return CommonUtil.createEmptySingle(clazz);
            }
            return Single.just(baseResponse.getData());
        });
    }

    public static <T> Single<List<T>> schedulePageResponse(Single<BaseResponse<BasePageData<T>>> response, Class<List<T>> clazz) {
        if (response == null) {
            return Single.error(new NzCommonException("response single is null"));
        }
        return response.flatMap(baseResponse -> {
            if (baseResponse == null) {
                return Single.error(new NzCommonException("response is null"));
            }
            if (!Boolean.TRUE.equals(baseResponse.getSucceed()) || baseResponse.getCode() != 200) {
                return Single.error(new NzHttpException(baseResponse.getCode(), baseResponse.getMsg()));
            }
            if (baseResponse.getData() == null) {
                return Single.error(new NzCommonException("data is null"));
            }
            if (baseResponse.getData().getRecords() == null) {
                return CommonUtil.createEmptySingle(clazz);
            }
            return Single.just(baseResponse.getData().getRecords());
        });
    }

    public static Single<ResponseBody> scheduleDownloadFileResponse(Single<Response<ResponseBody>> response) {
        if (response == null) {
            return Single.error(new NzCommonException("response single is null"));
        }
        return response.flatMap(resp -> {
            if (resp == null) {
                return Single.error(new NzDownloadFileException(null, "response is null"));
            }
            if (!resp.isSuccessful()) {
                return Single.error(new NzDownloadFileException(String.valueOf(resp.body()), "response is not successful"));
            }
            if (resp.body() == null) {
                return Single.error(new NzDownloadFileException(String.valueOf(resp.body()), "response body is null"));
            }
            return Single.just(resp.body());
        });
    }
}
