package com.adl.service.repository;

import android.util.Log;

import com.adl.service.callback.GetPageResult;
import com.adl.service.data.BasePageData;
import com.adl.service.exception.NzCommonException;
import com.adl.service.exception.NzGetPageException;
import com.adl.service.exception.NzNetworkException;
import com.adl.service.http.request.BaseRequest;

import java.util.List;
import java.util.UUID;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

/**
 * Repository 工具类，提供统一的异步数据获取和持久化流程
 * <p>
 * 封装了网络请求、本地缓存查询、数据持久化的标准流程，支持：
 * <ul>
 *   <li>简单的网络请求 + 持久化</li>
 *   <li>带本地缓存的网络请求（缓存优先策略）</li>
 *   <li>列表数据的分页拉取和批量持久化</li>
 *   <li>分页对象的分页拉取和批量持久化</li>
 * </ul>
 * </p>
 */
class BaseRepositoryUtil {

    /**
     * 执行无参数的异步操作并返回结果
     * <p>
     * 适用于不需要请求参数的简单数据获取场景
     * </p>
     *
     * @param func 无参异步函数，返回 Single<R>
     * @param <R>  返回值类型
     * @return 异步结果的 Single 包装
     */
    public static <R> Single<R> repositoryAsSingle(Function<Void, Single<R>> func) {
        Log.i("ZXN_TEST", "BaseRepository : repositoryAsSingle");
        return applyFunc(func);
    }

    /**
     * 执行带参数的异步操作并返回结果
     * <p>
     * 适用于简单的数据获取场景，直接执行函数并返回结果
     * </p>
     *
     * @param request 请求参数
     * @param func    异步函数，接收请求参数，返回 Single<R>
     * @param <Q>     请求参数类型
     * @param <R>     返回值类型
     * @return 异步结果的 Single 包装
     */
    public static <Q extends BaseRequest, R> Single<R> repositoryAsSingle(Q request, Function<Q, Single<R>> func) {
        Log.i("ZXN_TEST", "BaseRepository : repositoryAsSingle");
        if (request == null) {
            return Single.error(new NzCommonException("request is null"));
        }
        Single<R> funcData = applyFunc(func, request);
        if (funcData == null) {
            return Single.error(new NzCommonException("funcData is null"));
        }
        return funcData;
    }

    /**
     * 执行网络请求并将结果持久化
     * <p>
     * 标准流程：
     * <ol>
     *   <li>执行网络请求函数 netFunc</li>
     *   <li>检查网络返回数据是否为 null，为 null 则抛出 NzNetworkException</li>
     *   <li>将网络数据通过 persistFunc 进行持久化</li>
     *   <li>返回持久化后的结果</li>
     * </ol>
     * </p>
     *
     * @param request     请求参数
     * @param netFunc     网络请求函数，接收请求参数，返回 Single<R>
     * @param persistFunc 持久化函数，接收网络数据，返回持久化后的 Single<R>
     * @param <Q>         请求参数类型
     * @param <R>         数据类型
     * @return 持久化后结果的 Single 包装
     */
    public static <Q extends BaseRequest, R> Single<R> repositoryAsSingle(Q request,
                                                                          Function<Q, Single<R>> netFunc,
                                                                          Function<R, Single<R>> persistFunc) {
        Log.i("ZXN_TEST", "BaseRepository : repositoryAsSingle");
        if (request == null) {
            return Single.error(new NzCommonException("request is null"));
        }
        return applyFunc(netFunc, request)
                .flatMap(networkData -> {
                    if (networkData == null) {
                        return Single.error(new NzNetworkException(-1, "network data is null"));
                    }
                    return applyFunc(persistFunc, networkData);
                });
    }

    /**
     * 执行带准备阶段的网络请求和持久化（缓存优先策略）
     * <p>
     * 标准流程：
     * <ol>
     *   <li>执行准备函数 prepareFunc（通常用于查询本地缓存或执行准备工作）</li>
     *   <li>如果 prepareFunc 返回非 null 数据，直接返回该数据（命中缓存）</li>
     *   <li>如果 prepareFunc 返回 null，执行网络请求函数 fetchFunc</li>
     *   <li>检查网络返回数据是否为 null，为 null 则抛出 NzNetworkException</li>
     *   <li>将网络数据通过 persistFunc 进行持久化</li>
     *   <li>返回持久化后的结果</li>
     * </ol>
     * </p>
     *
     * @param request     请求参数
     * @param prepareFunc 准备函数，通常用于查询本地缓存，返回 Single<R>（null 表示未命中）
     * @param fetchFunc   网络请求函数，接收请求参数，返回 Single<R>
     * @param persistFunc 持久化函数，接收网络数据，返回持久化后的 Single<R>
     * @param <Q>         请求参数类型
     * @param <R>         数据类型
     * @return 最终结果的 Single 包装（可能来自缓存或网络）
     */
    public static <Q extends BaseRequest, R> Single<R> repositoryAsSingle(Q request,
                                                                          Function<Q, Single<R>> prepareFunc,
                                                                          Function<Q, Single<R>> fetchFunc,
                                                                          Function<R, Single<R>> persistFunc) {
        Log.i("ZXN_TEST", "BaseRepository : repositoryAsSingle");
        if (request == null) {
            return Single.error(new NzCommonException("request is null"));
        }
        Single<R> prepareData = applyFunc(prepareFunc, request);
        if (request.getForceUpdate() || prepareData == null) {
            return applyFunc(fetchFunc, request)
                    .flatMap(networkData -> {
                        if (networkData == null) {
                            return Single.error(new NzNetworkException(-1, "network data is null"));
                        }
                        return applyFunc(persistFunc, networkData);
                    });
        } else {
            return prepareData;
        }
    }

    /**
     * 分页拉取列表数据并批量持久化（不带准备阶段）
     * <p>
     * 自动循环拉取所有分页数据，直到某页返回空列表为止
     * </p>
     *
     * @param request     请求参数
     * @param fetchFunc   分页获取函数，接收页码（从1开始），返回 Single<List<R>>
     * @param persistFunc 批量持久化函数，接收一页数据列表，返回持久化后的 Single<List<R>>
     * @param <Q>         请求参数类型
     * @param <R>         列表元素类型
     * @return 分页结果的统计信息（总页数、成功页数、拉取数量、持久化数量等）
     */
    public static <Q extends BaseRequest, R> Single<GetPageResult> repositoryListsAsSingle(Q request,
                                                                                           Function<Long, Single<List<R>>> fetchFunc,
                                                                                           Function<List<R>, Single<List<R>>> persistFunc) {
        return repositoryListsAsSingle(request, null, fetchFunc, persistFunc);
    }

    /**
     * 分页拉取列表数据并批量持久化（带准备阶段）
     * <p>
     * 完整流程：
     * <ol>
     *   <li>执行准备函数 prepareFunc（如清理旧数据）</li>
     *   <li>从第1页开始，循环调用 fetchFunc 拉取每一页数据</li>
     *   <li>对每一页数据调用 persistFunc 进行批量持久化</li>
     *   <li>统计每页的拉取数量和持久化数量</li>
     *   <li>当某页返回空列表时停止循环</li>
     *   <li>累积所有页的统计信息并返回</li>
     * </ol>
     * </p>
     * <p>
     * 注意：整个请求过程共享一个 uuId，用于追踪和错误定位
     * </p>
     *
     * @param request     请求参数
     * @param prepareFunc 准备函数，通常用于清理旧数据，返回 Single<Void>
     * @param fetchFunc   分页获取函数，接收页码（从1开始），返回 Single<List<R>>
     * @param persistFunc 批量持久化函数，接收一页数据列表，返回持久化后的 Single<List<R>>
     * @param <Q>         请求参数类型
     * @param <R>         列表元素类型
     * @return 分页结果的统计信息（uuId、总页数、成功页数、拉取数量、持久化数量等）
     */
    public static <Q extends BaseRequest, R> Single<GetPageResult> repositoryListsAsSingle(Q request,
                                                                                           Function<Q, Single<List<R>>> prepareFunc,
                                                                                           Function<Long, Single<List<R>>> fetchFunc,
                                                                                           Function<List<R>, Single<List<R>>> persistFunc) {
        Log.i("ZXN_TEST", "BasePagePersistence : repositoryListsAsSingle");
        if (request == null) {
            return Single.error(new NzCommonException("request is null"));
        }
        if (prepareFunc != null) {
            applyFunc(prepareFunc, request);
        }
        final String uuId = UUID.randomUUID().toString();
        return Observable.<Long, Long>generate(() -> 1L, (current, emitter) -> {
                    emitter.onNext(current);
                    return current + 1L;
                })
                .concatMapSingle(currentPage -> applyFunc(fetchFunc, currentPage)
                        .flatMap(pageList -> {
                            GetPageResult pageResult = new GetPageResult();
                            pageResult.setUuId(uuId);
                            pageResult.setTotalPages(currentPage);
                            if (pageList == null || pageList.isEmpty()) {
                                return Single.just(createCurrentPageResult(pageResult, 0L, 0L));
                            }
                            return applyFunc(persistFunc, pageList)
                                    .flatMap(persistedList -> {
                                        long fetchedCount = pageList == null ? 0 : pageList.size();
                                        long persistedCount = persistedList == null ? 0 : persistedList.size();
                                        return Single.just(createCurrentPageResult(pageResult, fetchedCount, persistedCount));
                                    });
                        }))
                .takeWhile(stat -> stat.getFetchedCount() > 0)
                .collect(GetPageResult::new, (lastResult, currentResult) -> accumulatePageResult(uuId, lastResult, currentResult));
    }

//    /**
//     * 分页拉取分页对象数据并批量持久化（不带准备阶段）
//     * <p>
//     * 与 repositoryListsAsSingle 的区别：
//     * <ul>
//     *   <li>fetchFunc 返回的是 BasePageData<R>（包含总数、总页数等分页元数据）</li>
//     *   <li>先拉取第一页获取总页数，然后并发拉取剩余页</li>
//     *   <li>会验证分页一致性（当前页码、总页数、总数是否与第一页一致）</li>
//     * </ul>
//     * </p>
//     *
//     * @param request     请求参数
//     * @param fetchFunc   分页获取函数，接收页码（从1开始），返回 Single<BasePageData<R>>
//     * @param persistFunc 持久化函数，接收一页的分页对象，返回持久化后的 Single<BasePageData<R>>
//     * @param <Q>         请求参数类型
//     * @param <R>         列表元素类型
//     * @return 分页结果的统计信息
//     */
//    public static <Q extends BaseRequest, R> Single<GetPageResult> repositoryPagesAsSingle(Q request,
//                                                                                           Function<Long, Single<BasePageData<R>>> fetchFunc,
//                                                                                           Function<BasePageData<R>, Single<BasePageData<R>>> persistFunc) {
//        return repositoryPagesAsSingle(request, null, fetchFunc, persistFunc);
//    }
//
//    /**
//     * 分页拉取分页对象数据并批量持久化（带准备阶段）
//     * <p>
//     * 完整流程：
//     * <ol>
//     *   <li>执行准备函数 prepareFunc（如清理旧数据）</li>
//     *   <li>拉取第一页数据，获取总页数和总数等元数据</li>
//     *   <li>验证第一页数据有效性（不能为空）</li>
//     *   <li>持久化第一页数据</li>
//     *   <li>构建第一页的统计结果（uuId、总页数、成功页数=1等）</li>
//     *   <li>如果总页数 <= 1，直接返回第一页结果</li>
//     *   <li>否则顺序拉取并持久化剩余页（从第2页到最后一页）</li>
//     *   <li>对每一页验证分页一致性（当前页码、总页数、总数必须与第一页一致）</li>
//     *   <li>累积所有页的统计信息并返回</li>
//     * </ol>
//     * </p>
//     * <p>
//     * 注意：
//     * <ul>
//     *   <li>整个请求过程共享一个 uuId，用于追踪和错误定位</li>
//     *   <li>任何一页失败都会导致整个请求失败</li>
//     * </ul>
//     * </p>
//     *
//     * @param request     请求参数
//     * @param prepareFunc 准备函数，通常用于清理旧数据，返回 Single<Void>
//     * @param fetchFunc   分页获取函数，接收页码（从1开始），返回 Single<BasePageData<R>>
//     * @param persistFunc 持久化函数，接收一页的分页对象，返回持久化后的 Single<BasePageData<R>>
//     * @param <Q>         请求参数类型
//     * @param <R>         列表元素类型
//     * @return 分页结果的统计信息（uuId、总页数、成功页数、拉取数量、持久化数量等）
//     */
//    public static <Q extends BaseRequest, R> Single<GetPageResult> repositoryPagesAsSingle(Q request,
//                                                                                           Function<Q, Single<List<R>>> prepareFunc,
//                                                                                           Function<Long, Single<BasePageData<R>>> fetchFunc,
//                                                                                           Function<BasePageData<R>, Single<BasePageData<R>>> persistFunc) {
//        Log.i("ZXN_TEST", "BaseRepository : repositoryPagesAsSingle");
//        if (request == null) {
//            return Single.error(new NzCommonException("request is null"));
//        }
//        if (prepareFunc != null) {
//            applyFunc(prepareFunc, request);
//        }
//        final String uuId = UUID.randomUUID().toString();
//        return applyFunc(fetchFunc, 1L)
//                .flatMap(firstPageData -> {
//                    if (firstPageData == null || firstPageData.getRecords() == null || firstPageData.getRecords().isEmpty()) {
//                        return Single.error(new NzGetPageException(createFailedPageResult(uuId, "request page 1 is empty")));
//                    }
//                    return applyFunc(persistFunc, firstPageData)
//                            .flatMap(firstPersistedPageData -> {
//                                GetPageResult firstResult = new GetPageResult();
//                                firstResult.setUuId(uuId);
//                                firstResult.setSuccess(true);
//                                firstResult.setMessage("success");
//                                firstResult.setServerCount(firstPageData.getTotal() == null ? 0L : firstPageData.getTotal());
//                                firstResult.setTotalPages(firstPageData.getPages() == null ? 0L : firstPageData.getPages());
//                                firstResult.setSuccessedPages(1L);
//                                firstResult.setFetchedCount(firstPageData.getRecords() == null ? 0 : firstPageData.getRecords().size());
//                                firstResult.setPersistedCount(firstPersistedPageData.getRecords() == null ? 0 : firstPersistedPageData.getRecords().size());
//
//                                if (firstResult.getTotalPages() <= 1L) {
//                                    return Single.just(firstResult);
//                                }
//                                return persistAndAccumulateRemainingPages(fetchFunc, persistFunc, firstResult, 2L, firstResult.getTotalPages() - 1L);
//                            });
//
//                });
//    }
//
//    /**
//     * 持久化并累积剩余页的数据
//     * <p>
//     * 内部方法，用于处理第一页之后的所有页
//     * </p>
//     *
//     * @param fetchFunc   分页获取函数
//     * @param persistFunc 持久化函数
//     * @param firstResult 第一页的统计结果（作为累积的初始值）
//     * @param startPage   起始页码（通常为2）
//     * @param pageCount   剩余页数
//     * @param <R>         列表元素类型
//     * @return 累积所有页后的最终统计结果
//     */
//    private static <R> Single<GetPageResult> persistAndAccumulateRemainingPages(
//            Function<Long, Single<BasePageData<R>>> fetchFunc,
//            Function<BasePageData<R>, Single<BasePageData<R>>> persistFunc,
//            GetPageResult firstResult,
//            Long startPage,
//            Long pageCount) {
//        return Observable.rangeLong(startPage, pageCount)
//                .concatMapSingle(currentPage -> applyFunc(fetchFunc, currentPage)
//                        .flatMap(pageData -> {
//                            // 检查数据有效性
//                            if (pageData == null || pageData.getRecords() == null || pageData.getRecords().isEmpty()) {
//                                throw new NzGetPageException(createFailedPageResult(firstResult.getUuId(), "request page " + currentPage + " is empty"));
//                            }
//                            // 检查分页一致性
//                            if (pageData.getCurrent() != currentPage || pageData.getPages() != firstResult.getTotalPages() || pageData.getTotal() != firstResult.getServerCount()) {
//                                throw new NzGetPageException(createFailedPageResult(firstResult.getUuId(), "request current page " + currentPage + " does not match the pagination data on the server side "));
//                            }
//                            return applyFunc(persistFunc, pageData)
//                                    .flatMap(persistedPageData -> {
//                                        long fetchedCount = pageData.getRecords() == null ? 0 : pageData.getRecords().size();
//                                        long persistedCount = persistedPageData.getRecords() == null ? 0 : persistedPageData.getRecords().size();
//                                        return Single.just(createCurrentPageResult(firstResult, fetchedCount, persistedCount));
//                                    });
//                        }))
//                .reduce(firstResult, (lastResult, currentResult) -> accumulatePageResult(firstResult.getUuId(), lastResult, currentResult));
//    }

    /**
     * 创建单页的统计结果
     *
     * @param firstPageResult 第一页的统计结果（用于继承服务器端的总数和总页数）
     * @param fetchedCount    本页拉取的数据数量
     * @param persistedCount  本页持久化的数据数量
     * @return 本页的统计结果
     */
    private static GetPageResult createCurrentPageResult(GetPageResult firstPageResult, long fetchedCount, long persistedCount) {
        GetPageResult thisResult = new GetPageResult();
        thisResult.setSuccess(true);
        thisResult.setMessage("success");
        thisResult.setServerCount(firstPageResult.getServerCount());
        thisResult.setTotalPages(firstPageResult.getTotalPages());
        thisResult.setFetchedCount(fetchedCount);
        thisResult.setPersistedCount(persistedCount);
        return thisResult;
    }

    /**
     * 创建失败的页面结果
     *
     * @param uuId    请求的唯一标识
     * @param message 错误消息
     * @return 失败的页面结果
     */
    private static GetPageResult createFailedPageResult(String uuId, String message) {
        GetPageResult result = new GetPageResult();
        result.setUuId(uuId);
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }

    /**
     * 累积分页统计结果
     * <p>
     * 将当前页的统计结果累加到之前的结果中
     * </p>
     *
     * @param uuId          请求的唯一标识
     * @param lastResult    之前累积的结果
     * @param currentResult 当前页的结果
     * @return 累积后的结果
     * @throws NzGetPageException 如果当前页失败则抛出异常
     */
    private static GetPageResult accumulatePageResult(String uuId, GetPageResult lastResult, GetPageResult currentResult) throws NzGetPageException {
        if (!currentResult.isSuccess()) {
            throw new NzGetPageException(createFailedPageResult(currentResult.getUuId(), "accumulate page meet some error"));
        }
        lastResult.setUuId(uuId);
        lastResult.setSuccess(true);
        lastResult.setMessage(currentResult.getMessage());
        if (currentResult.getFetchedCount() > 0L) {
            lastResult.setSuccessedPages(lastResult.getSuccessedPages() + 1L);
            lastResult.setFetchedCount(lastResult.getFetchedCount() + currentResult.getFetchedCount());
            lastResult.setPersistedCount(lastResult.getPersistedCount() + currentResult.getPersistedCount());
        }
        lastResult.setTotalPages(Math.max(lastResult.getTotalPages(), currentResult.getTotalPages()));
        return lastResult;
    }

    /**
     * 安全地执行异步函数
     * <p>
     * 捕获函数执行过程中的异常，并将其转换为 RuntimeException
     * </p>
     *
     * @param func 异步函数
     * @param q    函数参数
     * @param <Q>  参数类型
     * @param <R>  返回类型
     * @return 函数返回的 Single
     */
    private static <Q, R> Single<R> applyFunc(Function<Q, Single<R>> func, Q q) {
        try {
            return func.apply(q);
        } catch (Throwable throwable) {
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException) throwable;
            }
            throw new RuntimeException(throwable);
        }
    }

    /**
     * 安全地执行无参异步函数
     *
     * @param func 无参异步函数
     * @param <R>  返回类型
     * @return 函数返回的 Single
     */
    private static <R> Single<R> applyFunc(Function<Void, Single<R>> func) {
        return applyFunc(func, null);
    }
}
