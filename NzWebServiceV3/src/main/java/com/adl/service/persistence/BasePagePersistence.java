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

    public static <T> Single<BaseResponse<BasePageData<T>>> persistOnePageAsSingle(
            Function<Void, Single<BaseResponse<BasePageData<T>>>> requestFunc,
            Function<List<T>, List<T>> persistFunc) {
        return persistOnePageAsSingle(BasePersistence.createBaseEmptyPreparer(), requestFunc, persistFunc);
    }

    /**
     * 网络 {@link Single} 成功后，若业务成功且含列表数据则插入本地库，再向下游传递原响应。
     */
    public static <T> Single<BaseResponse<BasePageData<T>>> persistOnePageAsSingle(
            Function<Void, Completable> prepareFunc,
            Function<Void, Single<BaseResponse<BasePageData<T>>>> requestFunc,
            Function<List<T>, List<T>> persistFunc) {
        Log.i("ZXN_TEST", "BasePagePersistence : persistOnePageAsSingle");
        return BasePersistence.persistAfterFetch(prepareFunc, requestFunc, data -> {
            if (data == null || data.getSize() == 0) {
                return Completable.error(new NzEmptyDataException("request data is null before persist"));
            }
            if (data.getRecords() == null || data.getRecords().isEmpty()) {
                return Completable.error(new NzEmptyDataException("request page data is null before persist"));
            }
            return Completable.fromAction(() -> persistFunc.apply(data.getRecords()));
        });
    }

    public static <T> Single<BaseResponse<List<T>>> persistOneListAsSingle(
            Function<Void, Single<BaseResponse<List<T>>>> requestFunc,
            Function<List<T>, List<T>> persistFunc) {
        return persistOneListAsSingle(BasePersistence.createBaseEmptyPreparer(), requestFunc, persistFunc);
    }

    public static <T> Single<BaseResponse<List<T>>> persistOneListAsSingle(
            Function<Void, Completable> prepareFunc,
            Function<Void, Single<BaseResponse<List<T>>>> requestFunc,
            Function<List<T>, List<T>> persistFunc) {
        Log.i("ZXN_TEST", "BasePagePersistence : persistOneListAsSingle");
        return BasePersistence.persistAfterFetch(prepareFunc, requestFunc, data -> {
            if (data == null || data.size() == 0) {
                return Completable.error(new NzEmptyDataException("request data is null before persist"));
            }
            return Completable.fromAction(() -> persistFunc.apply(data));
        });
    }

    public static <T> Single<List<T>> persistAllListsAsSingle(
            Function<Long, Single<BaseResponse<List<T>>>> pageRequestFunc,
            Function<List<T>, List<T>> persistFunc) {
        return persistAllListsAsSingle(BasePersistence.createBaseEmptyPreparer(), pageRequestFunc, persistFunc);
    }

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
    public static <T> Single<List<T>> persistAllListsAsSingle(
            Function<Void, Completable> prepareFunc,
            Function<Long, Single<BaseResponse<List<T>>>> pageRequestFunc,
            Function<List<T>, List<T>> persistFunc) {
        Log.i("ZXN_TEST", "BasePagePersistence : persistAllListsAsSingle");
        return Completable.defer(() -> prepareFunc.apply(null))
                .andThen(Observable.<Long, Long>generate(() -> 1L, (current, emitter) -> {
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
                        .collect(ArrayList::new, (result, page) -> result.addAll((List<T>) page)));

    }

    public static <T> Single<List<T>> persistAllPagesAsSingle(
            Function<Long, Single<BaseResponse<BasePageData<T>>>> pageRequestFunc,
            Function<List<T>, List<T>> persistFunc) {
        return persistAllPagesAsSingle(BasePersistence.createBaseEmptyPreparer(), pageRequestFunc, persistFunc);
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
            Function<Void, Completable> prepareFunc,
            Function<Long, Single<BaseResponse<BasePageData<T>>>> pageRequestFunc,
            Function<List<T>, List<T>> persistFunc) {
        Log.i("ZXN_TEST", "BasePagePersistence : persistAllPagesAsSingle");
        return Completable.defer(() -> prepareFunc.apply(null))
                .andThen(Single.defer(() -> pageRequestFunc.apply(1L)))
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
