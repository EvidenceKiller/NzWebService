package com.adl.service.internal;


import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.RequestLoadingCallback;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.BaseResponse;
import com.adl.service.exception.NzExceptionMapper;
import com.adl.service.exception.NzHttpException;
import com.adl.service.http.request.RequestScope;
import com.adl.service.log.NzLog;

import androidx.annotation.MainThread;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * RxJava 调度与 {@link BaseResponse} 处理封装（SDK 内部使用，不对外暴露）。
 * <p>
 * 包含：异步回调调度（{@link #scheduleResultAsync}），以及同步阻塞解包（{@link #scheduleResultSync}）。
 * </p>
 */
public final class RxCallbackScheduler {

    private RxCallbackScheduler() {
    }

    /**
     * 将 RxJava Single 转换为普通回调，自动处理线程切换和订阅管理
     *
     * @param single   RxJava Single 源
     * @param callback 业务回调接口
     * @return Disposable 订阅对象（可用于取消）
     */
    @MainThread
    public static <T> long scheduleAsync(RequestScope scope,
                                         Single<T> single,
                                         RequestCallback<T> callback) {
        assertScope(scope);
        Disposable disposable = scheduleAsync(single, callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    /**
     * 将 RxJava Single 转换为普通回调，自动处理线程切换和订阅管理
     *
     * @param callback 业务回调接口
     * @return Disposable 订阅对象（可用于取消）
     */
    @MainThread
    public static <T> Disposable scheduleAsync(Single<T> single,
                                               RequestCallback<T> callback) {
        return single
                .subscribeOn(Schedulers.io())           // 在 IO 线程执行
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程回调
                .subscribe(
                        result -> {
                            if (callback != null) {
                                // data为空通常不会走到
                                if (result == null) {
                                    callback.onError(NzResponseCode.NZ_NO_DATA_ERROR, "request result is null");
                                } else {
                                    callback.onSuccess(result);
                                }
                            }
                        },
                        error -> {
                            if (callback != null) {
                                if (error instanceof NzHttpException) {
                                    callback.onError(((NzHttpException) error).getHttpCode(), error.getMessage());
                                } else {
                                    // 统一异常映射，避免业务层到处散落 error.getMessage()。
                                    callback.onError(NzResponseCode.NZ_UNKNOWN_ERROR, NzExceptionMapper.toMessage(error));
                                }
                            }
                        }
                );
    }

    /**
     * 将 RxJava Single 转换为普通回调，自动处理线程切换和订阅管理
     *
     * @param single   RxJava Single 源
     * @param callback 业务回调接口
     * @return Disposable 订阅对象（可用于取消）
     */
    @MainThread
    public static <T> long scheduleResultAsync(RequestScope scope,
                                               Single<ResponseResult<T>> single,
                                               RequestCallback<T> callback) {
        assertScope(scope);
        Disposable disposable = scheduleResultAsync(single, callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    /**
     * 将 RxJava Single 转换为普通回调，自动处理线程切换和订阅管理
     *
     * @param callback 业务回调接口
     * @return Disposable 订阅对象（可用于取消）
     */
    @MainThread
    public static <T> Disposable scheduleResultAsync(Single<ResponseResult<T>> single,
                                                     RequestCallback<T> callback) {
        return single
                .subscribeOn(Schedulers.io())           // 在 IO 线程执行
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程回调
                .subscribe(
                        result -> {
                            if (callback != null) {
                                // data为空通常不会走到
                                if (result == null) {
                                    callback.onError(NzResponseCode.NZ_NO_DATA_ERROR, "request result is null");
                                } else if (result.getCode() != NzResponseCode.NZ_SUCCESS) {
                                    callback.onError(result.getCode(), result.getMsg());
                                } else {
                                    callback.onSuccess(result.getData());
                                }
                            }
                        },
                        error -> {
                            if (callback != null) {
                                if (error instanceof NzHttpException) {
                                    callback.onError(((NzHttpException) error).getHttpCode(), error.getMessage());
                                } else {
                                    // 统一异常映射，避免业务层到处散落 error.getMessage()。
                                    callback.onError(NzResponseCode.NZ_UNKNOWN_ERROR, NzExceptionMapper.toMessage(error));
                                }
                            }
                        }
                );
    }

    /**
     * 将 RxJava Single 转换为普通回调，自动处理线程切换和订阅管理
     *
     * @param single   RxJava Single 源
     * @param callback 业务回调接口
     * @return Disposable 订阅对象（可用于取消）
     */
    @MainThread
    public static <T> long scheduleResultAsync(RequestScope scope,
                                               Single<ResponseResult<T>> single,
                                               RequestLoadingCallback<T> callback) {
        assertScope(scope);
        Disposable disposable = scheduleResultAsync(single, callback);
        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    /**
     * 将 RxJava Single 转换为普通回调，自动处理线程切换和订阅管理
     *
     * @param callback 业务回调接口
     * @return Disposable 订阅对象（可用于取消）
     */
    @MainThread
    public static <T> Disposable scheduleResultAsync(Single<ResponseResult<T>> single,
                                                     RequestLoadingCallback<T> callback) {
        return single
                .subscribeOn(Schedulers.io())           // 在 IO 线程执行
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程回调
                .doOnSubscribe(d -> {
                    if (callback != null) callback.start();
                })
                .doFinally(() -> {
                    if (callback != null) callback.end();
                })
                .subscribe(
                        result -> {
                            if (callback != null) {
                                // data为空通常不会走到
                                if (result == null) {
                                    callback.onError(NzResponseCode.NZ_NO_DATA_ERROR, "request result is null");
                                } else if (result.getCode() != NzResponseCode.NZ_SUCCESS) {
                                    callback.onError(result.getCode(), result.getMsg());
                                } else {
                                    callback.onSuccess(result.getData());
                                }
                            }
                        },
                        error -> {
                            if (callback != null) {
                                if (error instanceof NzHttpException) {
                                    callback.onError(((NzHttpException) error).getHttpCode(), error.getMessage());
                                } else {
                                    // 统一异常映射，避免业务层到处散落 error.getMessage()。
                                    callback.onError(NzResponseCode.NZ_UNKNOWN_ERROR, NzExceptionMapper.toMessage(error));
                                }
                            }
                        }
                );
    }

    public static <T> T scheduleSync(Single<T> single) {
        try {
            return single
                    .doOnError(error -> NzLog.e("RxCallbackScheduler::blockingGetNoThrow : error : " + error))
                    .blockingGet();
        } catch (Throwable t) {
            if (NzExceptionMapper.isCatchException(t)) {
                if (NzExceptionMapper.isInterruptedException(t)) {
                    Thread.currentThread().interrupt();
                }
                return null;
            }
            throw new RuntimeException(t);
        }
    }

    /**
     * 阻塞获取 Single
     */
    public static <T> ResponseResult<T> scheduleResultSync(Single<ResponseResult<T>> single) {
        try {
            return single
                    .doOnError(error -> NzLog.e("RxCallbackScheduler::blockingGetNoThrow : error : " + error))
                    .blockingGet();
        } catch (Throwable t) {
            ResponseResult result = NzExceptionMapper.createExceptioResult(t);
            if (result != null) {
                if (result.getCode() == NzResponseCode.NZ_INTERRUPTED_ERROR) {
                    Thread.currentThread().interrupt();
                }
                return result;
            } else {
                throw new RuntimeException(t);
            }
        }
    }

    private static void assertScope(RequestScope scope) {
        if (scope == null) {
            throw new IllegalArgumentException("scope must not be null (use RequestScope.of(activity|fragment))");
        }
    }
}
