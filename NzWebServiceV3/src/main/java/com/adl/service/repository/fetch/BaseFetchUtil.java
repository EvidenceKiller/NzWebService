package com.adl.service.repository.fetch;

import com.adl.service.data.BasePageData;
import com.adl.service.data.BaseResponse;
import com.adl.service.exception.NzEmptyResponseException;
import com.adl.service.exception.NzNetworkException;
import com.adl.service.utils.CommonUtil;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

class BaseFetchUtil {

    public static <T> Single<T> scheduleResponse(Single<BaseResponse<T>> response, Class<T> clazz) {
        if (response == null) {
            return Single.error(new NzEmptyResponseException("response single is null"));
        }
        return response.flatMap(baseResponse -> {
            if (baseResponse == null) {
                return Single.error(new NzEmptyResponseException("response is null"));
            }
            if (!Boolean.TRUE.equals(baseResponse.getSucceed()) || baseResponse.getCode() != 200) {
                return Single.error(new NzNetworkException(baseResponse.getCode(), baseResponse.getMsg()));
            }
            if (baseResponse.getData() == null) {
                return CommonUtil.createEmptySingle(clazz);
            }
            return Single.just(baseResponse.getData());
        });
    }

    public static <T> Single<List<T>> schedulePageResponse(Single<BaseResponse<BasePageData<T>>> response, Class<List<T>> clazz) {
        if (response == null) {
            return Single.error(new NzEmptyResponseException("response single is null"));
        }
        return response.flatMap(baseResponse -> {
            if (baseResponse == null) {
                return Single.error(new NzEmptyResponseException("response is null"));
            }
            if (!Boolean.TRUE.equals(baseResponse.getSucceed()) || baseResponse.getCode() != 200) {
                return Single.error(new NzNetworkException(baseResponse.getCode(), baseResponse.getMsg()));
            }
            if (baseResponse.getData() == null) {
                return Single.error(new NzEmptyResponseException("data is null"));
            }
            if (baseResponse.getData().getRecords() == null) {
                return CommonUtil.createEmptySingle(clazz);
            }
            return Single.just(baseResponse.getData().getRecords());
        });
    }
}
