package com.adl.service.internal;


import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.RequestLoadingCallback;
import com.adl.service.data.BaseResponse;
import com.adl.service.exception.NzBaseException;
import com.adl.service.exception.NzExceptionMapper;
import com.adl.service.exception.NzHttpException;
import com.adl.service.http.request.RequestScope;
import com.adl.service.log.NzLog;
import com.adl.service.utils.CommonUtil;

import androidx.annotation.MainThread;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * RxJava 调度与 {@link BaseResponse} 处理封装（SDK 内部使用，不对外暴露）。
 * <p>
 * 包含：异步回调调度（{@link #schedule}），以及同步阻塞解包（{@link #blockingGet}）。
 * </p>
 */
public final class RxCallbackScheduler {

    private RxCallbackScheduler() {
    }

    /**
     * 将 RxJava Single 转换为普通回调，自动处理线程切换和订阅管理
     *
     * @param callback 业务回调接口
     * @return Disposable 订阅对象（可用于取消）
     */
    @MainThread
    public static <T> Disposable schedule(Single<T> single,
                                    RequestCallback<T> callback
    ) {
        return single
                .subscribeOn(Schedulers.io())           // 在 IO 线程执行
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程回调
                .subscribe(
                        data -> {
                            if (callback != null) {
                                // data为空通常不会走到
                                if (data == null) {
                                    callback.onError("data is null");
                                } else {
                                    callback.onSuccess(data);
                                }
                            }
                        },
                        error -> {
                            if (callback != null) {
                                if (error instanceof NzHttpException) {
                                    callback.onFail(((NzHttpException) error).getHttpCode(), error.getMessage());
                                } else {
                                    // 统一异常映射，避免业务层到处散落 error.getMessage()。
                                    callback.onError(NzExceptionMapper.toMessage(error));
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
    public static <T> long schedule(RequestScope scope,
                                    Single<T> single,
                                    RequestCallback<T> callback
    ) {
        assertScope(scope);
        Disposable disposable = single
                .subscribeOn(Schedulers.io())           // 在 IO 线程执行
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程回调
                .subscribe(
                        data -> {
                            if (callback != null) {
                                // data为空通常不会走到
                                if (data == null) {
                                    callback.onError("data is null");
                                } else {
                                    callback.onSuccess(data);
                                }
                            }
                        },
                        error -> {
                            if (callback != null) {
                                if (error instanceof NzHttpException) {
                                    callback.onFail(((NzHttpException) error).getHttpCode(), error.getMessage());
                                } else {
                                    // 统一异常映射，避免业务层到处散落 error.getMessage()。
                                    callback.onError(NzExceptionMapper.toMessage(error));
                                }
                            }
                        }
                );

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
    public static <T> Disposable schedule(Single<T> single,
                                          RequestLoadingCallback<T> callback
    ) {
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
                        data -> {
                            if (callback != null) {
                                if (data == null) {
                                    callback.onError("data is null");
                                } else {
                                    callback.onSuccess(data);
                                }
                            }
                        },
                        error -> {
                            if (callback != null) {
                                // 统一异常映射，避免业务层到处散落 error.getMessage()。
                                callback.onError(NzExceptionMapper.toMessage(error));
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
    public static <T> long schedule(RequestScope scope,
                                    Single<T> single,
                                    RequestLoadingCallback<T> callback
    ) {
        assertScope(scope);
        Disposable disposable = single
                .subscribeOn(Schedulers.io())           // 在 IO 线程执行
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程回调
                .doOnSubscribe(d -> {
                    if (callback != null) callback.start();
                })
                .doFinally(() ->  {
                    if (callback != null) callback.end();
                })
                .subscribe(
                        data -> {
                            if (callback != null) {
                                if (data == null) {
                                    callback.onError("data is null");
                                } else {
                                    callback.onSuccess(data);
                                }
                            }
                        },
                        error -> {
                            if (callback != null) {
                                // 统一异常映射，避免业务层到处散落 error.getMessage()。
                                callback.onError(NzExceptionMapper.toMessage(error));
                            }
                        }
                );

        SubscriptionManager.getInstance().add(scope.owner(), disposable);
        return disposable.hashCode();
    }

    /**
     * 阻塞获取 Single，校验响应成功且 data 非空后返回 data；否则抛出 {@link NzBaseException}；
     * 其它异常经 {@link NzExceptionMapper} 映射。
     */
    public static <T> T blockingGet(Single<T> single) throws NzBaseException {
        try {
            return single
                    .doOnError(error -> NzLog.e("RxCallbackScheduler::blockingGet : error : " + error))
                    .blockingGet();
        } catch (Throwable t) {
            throw NzExceptionMapper.map(t);
        }
    }

    public static <T> T blockingGetNoThrow(Single<T> single, Class<T> clazz) {
        try {
            return single
                    .doOnError(error -> NzLog.e("RxCallbackScheduler::blockingGetNoThrowWithDefault : error : " + error))
                    .blockingGet();
        } catch (Throwable t) {
            if (NzExceptionMapper.isCatchException(t)) {
                if (NzExceptionMapper.isInterruptedException(t)) {
                    Thread.currentThread().interrupt();
                }
                return CommonUtil.createEmptyObject(clazz);
            }
            throw new RuntimeException(t);
        }
    }

    public static <T> T blockingGetNoThrow(Single<T> single) {
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

    private static void assertScope(RequestScope scope) {
        if (scope == null) {
            throw new IllegalArgumentException("scope must not be null (use RequestScope.of(activity|fragment))");
        }
    }
}
