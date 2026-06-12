package com.adl.service.repository.fetch;

import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
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

    public static <T> Single<ResponseResult<T>> schedule(Single<T> response) {
        if (response == null) {
            return Single.error(new NzCommonException("response single is null"));
        }
        return response.flatMap(resp -> {
            if (resp == null) {
                return Single.error(new NzHttpException(NzResponseCode.NZ_NO_DATA_ERROR, "response is null"));
            }
            ResponseResult<T> result = new ResponseResult<>();
            result.setCode(NzResponseCode.NZ_SUCCESS);
            result.setMsg("success");
            result.setData(resp);
            return Single.just(result);
        });
    }

//    public static <T> Single<T> scheduleResponse(Single<BaseResponse<T>> response, Class<T> clazz) {
//        if (response == null) {
//            return Single.error(new NzCommonException("response single is null"));
//        }
//        return response.flatMap(baseResponse -> {
//            if (baseResponse == null) {
//                return Single.error(new NzCommonException("response is null"));
//            }
//            if (!Boolean.TRUE.equals(baseResponse.getSucceed()) || baseResponse.getCode() != 200) {
//                return Single.error(new NzHttpException(baseResponse.getCode(), baseResponse.getMsg()));
//            }
//            if (baseResponse.getData() == null) {
//                return CommonUtil.createEmptySingle(clazz);
//            }
//            return Single.just(baseResponse.getData());
//        });
//    }

    public static <T> Single<ResponseResult<T>> scheduleResponse(Single<BaseResponse<T>> response) {
        if (response == null) {
            return Single.error(new NzCommonException("response single is null"));
        }
        return response.flatMap(baseResponse -> {
            if (baseResponse == null) {
                return Single.error(new NzHttpException(NzResponseCode.NZ_NO_DATA_ERROR, "response is null"));
            }
            if (!Boolean.TRUE.equals(baseResponse.getSucceed()) || baseResponse.getCode() != NzResponseCode.NZ_SUCCESS) {
                return Single.error(new NzHttpException(baseResponse.getCode(), baseResponse.getMsg()));
            }
            ResponseResult<T> result = new ResponseResult<>();
            result.setCode(baseResponse.getCode());
            result.setMsg(baseResponse.getMsg());
            result.setData(baseResponse.getData());
            return Single.just(result);
        });
    }

//    public static <T> Single<List<T>> schedulePageResponse(Single<BaseResponse<BasePageData<T>>> response, Class<List<T>> clazz) {
//        if (response == null) {
//            return Single.error(new NzCommonException("response single is null"));
//        }
//        return response.flatMap(baseResponse -> {
//            if (baseResponse == null) {
//                return Single.error(new NzCommonException("response is null"));
//            }
//            if (!Boolean.TRUE.equals(baseResponse.getSucceed()) || baseResponse.getCode() != 200) {
//                return Single.error(new NzHttpException(baseResponse.getCode(), baseResponse.getMsg()));
//            }
//            if (baseResponse.getData() == null) {
//                return Single.error(new NzCommonException("data is null"));
//            }
//            if (baseResponse.getData().getRecords() == null) {
//                return CommonUtil.createEmptySingle(clazz);
//            }
//            return Single.just(baseResponse.getData().getRecords());
//        });
//    }

    public static Single<ResponseResult<ResponseBody>> scheduleDownloadFileResponse(Single<Response<ResponseBody>> response) {
        if (response == null) {
            return Single.error(new NzCommonException("response single is null"));
        }
        return response.flatMap(resp -> {
            if (resp == null) {
                return Single.error(new NzDownloadFileException(NzResponseCode.NZ_DOWNLOAD_FILE_ERROR, "response is null"));
            }
            if (!resp.isSuccessful()) {
                return Single.error(new NzDownloadFileException(NzResponseCode.NZ_DOWNLOAD_FILE_ERROR, String.valueOf(resp.body())));
            }
            if (resp.body() == null) {
                return Single.error(new NzDownloadFileException(NzResponseCode.NZ_DOWNLOAD_FILE_ERROR, String.valueOf(resp.body())));
            }
            return Single.just(CommonUtil.createSuccessResponseResult(resp.body()));
        });
    }
}
