package com.adl.service.persistence;

import android.util.Log;

import com.adl.service.exception.NzCommonException;
import com.adl.service.exception.NzEmptyDataException;
import com.adl.service.web.response.BasePageData;
import com.adl.service.web.response.BaseResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

/**
 * 网络成功后按需写入本地，再向下游传递原响应。
 * 具体落库逻辑由调用方通过 {@code persistIfSuccess} 注入。
 */
public final class BasePagePersistence {

    private BasePagePersistence() {
    }

    /**
     * 网络 {@link Single} 成功后，若业务成功且含列表数据则插入本地库，再向下游传递原响应。
     */
    public static <T> Single<BaseResponse<BasePageData<T>>> persistAfterFetch(
            Single<BaseResponse<BasePageData<T>>> pageRequestCallable,
            Function<List<T>, List<T>> persistFunc) {
        Log.i("ZXN_TEST", "BasePagePersistence : persistAfterFetch");
        return BasePersistence.persistAfterFetch(pageRequestCallable, data -> {
            if (data == null || data.getSize() == 0) {
                return Completable.error(new NzEmptyDataException("request data is null before persist"));
            }
            if (data.getRecords() == null || data.getRecords().isEmpty()) {
                return Completable.error(new NzEmptyDataException("request page data is null before persist"));
            }
            return Completable.fromAction(() -> persistFunc.apply(data.getRecords()));
        });
    }

//    /**
//     * 按分页循环请求直至拉完全部数据：每一页成功后写入本地，再请求下一页。
//     * <p>
//     * {@link BasePageRequest} 中的 {@code current} 不参与计算，始终从第 1 页开始；
//     * {@code pageSize} 会用于每一页请求。
//     * </p>
//     *
//     * @param pageRequester    分页请求函数，接收页码返回 Single
//     * @param persistIfSuccess 每页成功后的持久化逻辑
//     * @return 最后一页的 {@link BaseResponse}
//     */
//    public static <T> Single<BasePageData<T>> persistAllPagesAsSingle(
//            Function<Long, Single<BaseResponse<BasePageData<T>>>> pageRequester,
//            Function<List<T>, Completable> persistIfSuccess) throws NzCommonException {
//        Log.i("ZXN_TEST", "BasePagePersistence : persistAllPagesAsSingle");
//        // 先请求第一页
//        try {
//            return pageRequester.apply(1L)
//                    .flatMap(firstResp -> {
//                        if (!firstResp.getSucceed() || firstResp.getData() == null) {
//                            return Single.error(new RuntimeException(
//                                    "persist page 1 failed: " + firstResp.getMsg()));
//                        }
//
//                        BasePageData<T> firstPage = firstResp.getData();
//                        // 持久化第一页数据
//                        return persistIfSuccess.apply(firstPage.getRecords())
//                                .andThen(Single.defer(() -> {
//                                    long totalPages = firstPage.getPages();
//                                    if (totalPages <= 1L) {
//                                        // 只有一页，直接返回
//                                        return Single.just(firstResp);
//                                    }
//
//                                    return persistRemainingPages(pageRequester, persistIfSuccess, 2L, totalPages - 1);
//                                }));
//                    });
//        } catch (Throwable e) {
//            throw new NzCommonException("persist all pages failed", e);
//        }
//    }

//    /**
//     * 获取剩余分页数据并逐页持久化
//     *
//     * @param pageRequester    分页请求函数
//     * @param persistIfSuccess 持久化逻辑
//     * @param startPage        起始页码（从2开始）
//     * @param pageCount        剩余页数
//     * @param <T>              数据类型
//     * @return 最后一页的响应
//     */
//    private static <T> Single<BaseResponse<BasePageData<T>>> persistRemainingPages(
//            Function<Long, Single<BaseResponse<BasePageData<T>>>> pageRequester,
//            Function<List<T>, Completable> persistIfSuccess,
//            long startPage,
//            long pageCount) {
//        Log.i("ZXN_TEST", "BasePagePersistence : persistAllPagesAsSingle : pageCount : " + pageCount);
//        Log.i("ZXN_TEST", "BasePagePersistence : persistAllPagesAsSingle : startPage : " + startPage);
//        return Observable.rangeLong(startPage, pageCount)
//                .concatMapSingle(currentPage -> pageRequester.apply(currentPage)
//                        .flatMap(resp -> {
//                            if (!resp.getSucceed() || resp.getData() == null) {
//                                return Single.error(new RuntimeException(
//                                        "Fetch page " + currentPage + " failed: " + resp.getMsg()));
//                            }
//                            return persistIfSuccess.apply(resp.getData().getRecords())
//                                    .andThen(Single.just(resp));
//                        }))
//                .lastOrError();
//    }

    /**
     * 按分页循环请求直至拉完全部数据：每一页成功后写入本地，并汇总所有数据。
     * <p>
     * 后端返回分页数据有两种方式，这个函数处理返回List的方式
     * 始终从第 1 页开始请求，直到拉取完所有页。
     * </p>
     *
     * @param pageRequestFunc 分页请求函数，接收页码返回 Single
     * @param persistFunc     每页成功后的持久化逻辑
     * @return 包含所有分页记录的汇总 {@link List}
     */
    public static <T> Single<List<T>> persistAllPageListAsSingle(
            Function<Long, Single<BaseResponse<List<T>>>> pageRequestFunc,
            Function<List<T>, List<T>> persistFunc) throws NzCommonException {
        Log.i("ZXN_TEST", "BasePagePersistence : persistAllPagesAsSingle");
        try {
            return Observable.<Long, Long>generate(() -> 1L, (current, emitter) -> {
                        emitter.onNext(current);
                        return current + 1L;
                    })
                    .concatMapSingle(currentPage -> pageRequestFunc.apply(currentPage)
                            .flatMap(resp -> {
                                if (!resp.getSucceed()) {
                                    return Single.error(new RuntimeException("request page " + currentPage + " failed: " + resp.getMsg()));
                                }
                                List<T> dataList = resp.getData();
                                if (dataList == null || dataList.isEmpty()) {
                                    return Single.just(Collections.emptyList());
                                }
                                return Single.fromCallable(() -> {
                                    try {
                                        return persistFunc.apply(dataList);
                                    } catch (Throwable e) {
                                        throw new NzCommonException("persist page " + currentPage + " failed", e);
                                    }
                                });
                            }))
                    .takeWhile(pageData -> !pageData.isEmpty())
                    .collect(ArrayList::new, (result, page) -> result.addAll((List<T>) page));
        } catch (Throwable e) {
            throw new NzCommonException("persist all page list failed", e);
        }
    }

    /**
     * 按分页循环请求直至拉完全部数据：每一页成功后写入本地，并汇总所有数据。
     * <p>
     * 后端返回分页数据有两种方式，这个函数处理返回BasePageData的方式
     * 始终从第 1 页开始请求，直到拉取完所有页。
     * </p>
     *
     * @param pageRequestFunc 分页请求函数，接收页码返回 Single
     * @param persistFunc     每页成功后的持久化逻辑
     * @return 包含所有分页记录的汇总 {@link List}
     */
    public static <T> Single<List<T>> persistAllPagesAsSingle(
            Function<Long, Single<BaseResponse<BasePageData<T>>>> pageRequestFunc,
            Function<List<T>, List<T>> persistFunc) throws NzCommonException {
        Log.i("ZXN_TEST", "BasePagePersistence : persistAllPagesAsSingle");
        try {
            return pageRequestFunc.apply(1L)
                    .flatMap(firstResp -> {
                        if (!firstResp.getSucceed() || firstResp.getData() == null) {
                            return Single.error(new RuntimeException("request page 1 failed: " + firstResp.getMsg()));
                        }

                        BasePageData<T> firstPage = firstResp.getData();
                        List<T> firstPageDataList = firstPage.getRecords();

                        // 持久化第一页
                        List<T> persistedFirstPageDataList = persistFunc.apply(firstPageDataList);
                        return Single.defer(() -> {
                            long totalPages = firstPage.getPages();
                            if (totalPages <= 1L) {
                                // 只有一页，直接返回
                                return Single.just(firstPageDataList);
                            }

                            // 获取剩余页并汇总
                            return persistAndAccumulateRemainingPages(pageRequestFunc, persistFunc, persistedFirstPageDataList, 2L, totalPages - 1);
                        });
                    });
        } catch (Throwable e) {
            throw new NzCommonException("persist all pages failed", e);
        }
    }

    /**
     * 获取剩余分页数据，逐页持久化并累加到总列表中
     */
    private static <T> Single<List<T>> persistAndAccumulateRemainingPages(
            Function<Long, Single<BaseResponse<BasePageData<T>>>> pageRequestFunc,
            Function<List<T>, List<T>> persistFunc,
            List<T> accumulatedList,
            long startPage,
            long pageCount) {
        Log.i("ZXN_TEST", "BasePagePersistence : persistAndAccumulateRemainingPages : pageCount : " + pageCount);
        Log.i("ZXN_TEST", "BasePagePersistence : persistAndAccumulateRemainingPages : startPage : " + startPage);
        return Observable.rangeLong(startPage, pageCount)
                .concatMapSingle(currentPage -> pageRequestFunc.apply(currentPage)
                        .flatMap(resp -> {
                            if (!resp.getSucceed() || resp.getData() == null) {
                                return Single.error(new RuntimeException("request page " + currentPage + " failed: " + resp.getMsg()));
                            }
                            List<T> records = resp.getData().getRecords();
                            // 持久化当前页
                            return Single.just(persistFunc.apply(records));
                        }))
                // 将每一页的 List<T> 累加到初始的 accumulatedList 中
                .toList()
                .map(allPages -> {
                    List<T> result = new ArrayList<>(accumulatedList);
                    for (List<T> page : allPages) {
                        result.addAll(page);
                    }
                    return result;
                });
    }
}
