package com.adl.service.repository;

import com.adl.service.data.PageSummaryData;
import com.adl.service.callback.ResponseResult;
import com.adl.service.common.NzResponseCode;
import com.adl.service.data.BasePageData;
import com.adl.service.exception.NzCommonException;
import com.adl.service.exception.NzExceptionMapper;
import com.adl.service.exception.NzGetPageException;
import com.adl.service.exception.NzHttpException;
import com.adl.service.http.request.BasePageRequest;
import com.adl.service.http.request.BaseRequest;
import com.adl.service.log.NzLog;

import java.util.List;
import java.util.UUID;

import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Flowable;
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
@RestrictTo(RestrictTo.Scope.LIBRARY)
class BaseRepositoryUtil {

    /**
     * 执行带参数的异步操作并返回结果
     * <p>
     * 适用于简单的数据获取场景，直接执行函数并返回结果
     * </p>
     *
     * @param q 请求参数
     * @param func    异步函数，接收请求参数，返回 Single<R>
     * @param <Q>     请求参数类型
     * @param <R>     返回值类型
     * @return 异步结果的 Single 包装
     */
    public static <Q, R> Single<R> repositoryCommonAsSingle(Q q, Function<Q, Single<R>> func) {
        if (q == null) {
            return Single.error(new NzCommonException("request is null"));
        }
        return Single.defer(() -> applyFunc(func, q));
    }

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
        return Single.defer(() -> applyFunc(func));
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
        return repositoryAsSingle(request, null, func, null);
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
        return repositoryAsSingle(request, null, netFunc, persistFunc);
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
        if (request == null) {
            return Single.error(new NzCommonException("request is null"));
        }
        return Single.defer(() -> repositoryAsSingleInternal(request, prepareFunc, fetchFunc, persistFunc));
    }

    private static <Q extends BaseRequest, R> Single<R> repositoryAsSingleInternal(Q request,
                                                                                   Function<Q, Single<R>> prepareFunc,
                                                                                   Function<Q, Single<R>> fetchFunc,
                                                                                   Function<R, Single<R>> persistFunc) {
        if (prepareFunc != null) {
            Single<R> prepareData = applyFunc(prepareFunc, request);
            if (prepareData != null && !request.getForceUpdate()) {
                return prepareData;
            }
        }
        Single<R> fetchSingle = applyFunc(fetchFunc, request);
        if (fetchSingle == null) {
            return Single.error(new NzHttpException(NzResponseCode.NZ_NO_DATA_ERROR, "fetch single is null"));
        }
        return fetchSingle.flatMap(networkData -> {
            if (networkData == null) {
                return Single.error(new NzHttpException(NzResponseCode.NZ_NO_DATA_ERROR, "network data is null"));
            }
            if (persistFunc == null) {
                return Single.just(networkData);
            }
            return applyFunc(persistFunc, networkData);
        });
    }

    public static <Q extends BasePageRequest, R> Single<ResponseResult<List<R>>> repositoryPageAsSingle(Q request,
                                                                                                        Function<Q, Single<ResponseResult<BasePageData<R>>>> fetchFunc) {
        return repositoryPageAsSingle(request, null, fetchFunc, null);
    }

    public static <Q extends BasePageRequest, R> Single<ResponseResult<List<R>>> repositoryPageAsSingle(Q request,
                                                                                                        Function<Q, Single<ResponseResult<BasePageData<R>>>> fetchFunc,
                                                                                                        Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        return repositoryPageAsSingle(request, null, fetchFunc, persistFunc);
    }

    public static <Q extends BasePageRequest, R> Single<ResponseResult<List<R>>> repositoryPageAsSingle(Q request,
                                                                                                        Function<Q, Single<ResponseResult<List<R>>>> prepareFunc,
                                                                                                        Function<Q, Single<ResponseResult<BasePageData<R>>>> fetchFunc,
                                                                                                        Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        if (request == null) {
            return Single.error(new NzCommonException("request is null"));
        }
        if (request.getCurrent() == null) {
            return Single.error(new NzCommonException("must set page request current"));
        }
        return Single.defer(() -> repositoryPageAsSingleInternal(request, prepareFunc, fetchFunc, persistFunc));
    }

    private static <Q extends BasePageRequest, R> Single<ResponseResult<List<R>>> repositoryPageAsSingleInternal(Q request,
                                                                                                                   Function<Q, Single<ResponseResult<List<R>>>> prepareFunc,
                                                                                                                   Function<Q, Single<ResponseResult<BasePageData<R>>>> fetchFunc,
                                                                                                                   Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        if (prepareFunc != null) {
            Single<ResponseResult<List<R>>> prepareData = applyFunc(prepareFunc, request);
            if (prepareData != null && !request.getForceUpdate()) {
                return prepareData;
            }
        }
        Single<ResponseResult<BasePageData<R>>> fetchSingle = applyFunc(fetchFunc, request);
        if (fetchSingle == null) {
            return Single.error(new NzHttpException(NzResponseCode.NZ_NO_DATA_ERROR, "fetch single is null"));
        }
        return fetchSingle.flatMap(responseResult -> {
            if (responseResult == null) {
                return Single.error(new NzHttpException(NzResponseCode.NZ_NO_DATA_ERROR, "response result is null"));
            }

            ResponseResult<List<R>> result = new ResponseResult<>();
            result.setCode(responseResult.getCode());
            result.setMsg(responseResult.getMsg());
            BasePageData pageData = responseResult.getData();
            if (pageData == null || pageData.getRecords() == null || pageData.getRecords().isEmpty()) {
                return Single.just(result);
            }
            result.setData(responseResult.getData().getRecords());
            if (persistFunc == null) {
                return Single.just(result);
            }
            return applyFunc(persistFunc, result);
        });
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
    public static <Q extends BasePageRequest, R> Single<ResponseResult<PageSummaryData>> repositoryListsAsSingle(Q request,
                                                                                                                 Function<Long, Single<ResponseResult<List<R>>>> fetchFunc,
                                                                                                                 Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
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
    public static <Q extends BasePageRequest, R> Single<ResponseResult<PageSummaryData>> repositoryListsAsSingle(Q request,
                                                                                                                 Function<Q, Single<ResponseResult<List<R>>>> prepareFunc,
                                                                                                                 Function<Long, Single<ResponseResult<List<R>>>> fetchFunc,
                                                                                                                 Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        NzLog.d("BaseRepositoryUtil : repositoryListsAsSingle");
        if (request == null) {
            return Single.just(wrapPageSummaryError(new NzCommonException("request is null")));
        }
        if (request.getCurrent() != null && request.getCurrent() != 1) {
            return Single.just(wrapPageSummaryError(new NzCommonException("get all lists must set current is 1")));
        }
        return Single.defer(() -> repositoryListsAsSingleInternal(request, prepareFunc, fetchFunc, persistFunc));
    }

    private static <Q extends BasePageRequest, R> Single<ResponseResult<PageSummaryData>> repositoryListsAsSingleInternal(Q request,
                                                                                                                          Function<Q, Single<ResponseResult<List<R>>>> prepareFunc,
                                                                                                                          Function<Long, Single<ResponseResult<List<R>>>> fetchFunc,
                                                                                                                          Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        if (prepareFunc != null) {
            applyFunc(prepareFunc, request);
        }
        final String uuId = UUID.randomUUID().toString();
        return Flowable.<Long, Long>generate(() -> 1L, (current, emitter) -> {
                    emitter.onNext(current);
                    return current + 1L;
                })
                .concatMapSingle(currentPage -> applyFunc(fetchFunc, currentPage)
                        .flatMap(pageResponseResult -> {
                            if (pageResponseResult == null) {
                                return Single.error(new NzGetPageException(createFailedPageResult(uuId, "request page " + currentPage + " response is empty")));
                            }
                            if (pageResponseResult.getCode() != NzResponseCode.NZ_SUCCESS) {
                                return Single.error(new NzGetPageException(createFailedPageResult(uuId, "request page " + currentPage + " response is not success")));
                            }

                            PageSummaryData pageResult = new PageSummaryData();
                            pageResult.setUuId(uuId);
                            pageResult.setTotalPages(currentPage);

                            List<R> pageList = pageResponseResult.getData();
                            if (pageList == null || pageList.isEmpty()) {
                                return Single.just(createCurrentPageResult(pageResult, 0L, 0L));
                            }
                            NzLog.d("BaseRepositoryUtil : repositoryListsAsSingle : page " + currentPage + " : page size : " + pageList.size());
                            return applyFunc(persistFunc, pageResponseResult)
                                    .flatMap(persistedResult -> {
                                        List<R> persistedList = persistedResult == null ? null : persistedResult.getData();
                                        long fetchedCount = pageList == null ? 0 : pageList.size();
                                        long persistedCount = persistedList == null ? 0 : persistedList.size();
                                        return Single.just(createCurrentPageResult(pageResult, fetchedCount, persistedCount));
                                    });
                        }))
                .takeWhile(stat -> stat.getFetchedCount() > 0)
                .collect(PageSummaryData::new, (lastResult, currentResult) -> accumulatePageResult(uuId, lastResult, currentResult))
                .map(BaseRepositoryUtil::wrapPageSummarySuccess)
                .onErrorResumeNext(err -> {
                    if (NzExceptionMapper.isCatchException(err)) {
                        return Single.just(wrapPageSummaryError(err));
                    }
                    return Single.error(err);
                });
    }

    /**
     * 分页拉取分页对象数据并批量持久化（不带准备阶段）
     * <p>
     * 与 repositoryListsAsSingle 的区别：
     * <ul>
     *   <li>fetchFunc 返回的是 BasePageData<R>（包含总数、总页数等分页元数据）</li>
     *   <li>先拉取第一页获取总页数，然后并发拉取剩余页</li>
     *   <li>会验证分页一致性（当前页码、总页数、总数是否与第一页一致）</li>
     * </ul>
     * </p>
     *
     * @param request     请求参数
     * @param fetchFunc   分页获取函数，接收页码（从1开始），返回 Single<BasePageData<R>>
     * @param persistFunc 持久化函数，接收一页的分页对象，返回持久化后的 Single<BasePageData<R>>
     * @param <Q>         请求参数类型
     * @param <R>         列表元素类型
     * @return 分页结果的统计信息
     */
    public static <Q extends BasePageRequest, R> Single<ResponseResult<PageSummaryData>> repositoryPagesAsSingle(Q request,
                                                                                                                 Function<Long, Single<ResponseResult<BasePageData<R>>>> fetchFunc,
                                                                                                                 Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        return repositoryPagesAsSingle(request, null, fetchFunc, persistFunc);
    }

    /**
     * 分页拉取分页对象数据并批量持久化（带准备阶段）
     * <p>
     * 完整流程：
     * <ol>
     *   <li>执行准备函数 prepareFunc（如清理旧数据）</li>
     *   <li>拉取第一页数据，获取总页数和总数等元数据</li>
     *   <li>验证第一页数据有效性（不能为空）</li>
     *   <li>持久化第一页数据</li>
     *   <li>构建第一页的统计结果（uuId、总页数、成功页数=1等）</li>
     *   <li>如果总页数 <= 1，直接返回第一页结果</li>
     *   <li>否则顺序拉取并持久化剩余页（从第2页到最后一页）</li>
     *   <li>对每一页验证分页一致性（当前页码、总页数、总数必须与第一页一致）</li>
     *   <li>累积所有页的统计信息并返回</li>
     * </ol>
     * </p>
     * <p>
     * 注意：
     * <ul>
     *   <li>整个请求过程共享一个 uuId，用于追踪和错误定位</li>
     *   <li>任何一页失败都会导致整个请求失败</li>
     * </ul>
     * </p>
     *
     * @param request     请求参数
     * @param prepareFunc 准备函数，通常用于清理旧数据，返回 Single<Void>
     * @param fetchFunc   分页获取函数，接收页码（从1开始），返回 Single<BasePageData<R>>
     * @param persistFunc 持久化函数，接收一页的分页对象，返回持久化后的 Single<BasePageData<R>>
     * @param <Q>         请求参数类型
     * @param <R>         列表元素类型
     * @return 分页结果的统计信息（uuId、总页数、成功页数、拉取数量、持久化数量等）
     */
    public static <Q extends BasePageRequest, R> Single<ResponseResult<PageSummaryData>> repositoryPagesAsSingle(Q request,
                                                                                                                 Function<Q, Single<ResponseResult<List<R>>>> prepareFunc,
                                                                                                                 Function<Long, Single<ResponseResult<BasePageData<R>>>> fetchFunc,
                                                                                                                 Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        NzLog.d("BaseRepositoryUtil : repositoryPagesAsSingle");
        if (request == null) {
            return Single.just(wrapPageSummaryError(new NzCommonException("request is null")));
        }
        if (request.getCurrent() != null && request.getCurrent() != 1) {
            return Single.just(wrapPageSummaryError(new NzCommonException("get all pages must set current is 1")));
        }
        return Single.defer(() -> repositoryPagesAsSingleInternal(request, prepareFunc, fetchFunc, persistFunc));
    }

    private static <Q extends BasePageRequest, R> Single<ResponseResult<PageSummaryData>> repositoryPagesAsSingleInternal(Q request,
                                                                                                                          Function<Q, Single<ResponseResult<List<R>>>> prepareFunc,
                                                                                                                          Function<Long, Single<ResponseResult<BasePageData<R>>>> fetchFunc,
                                                                                                                          Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc) {
        if (prepareFunc != null) {
            applyFunc(prepareFunc, request);
        }
        final String uuId = UUID.randomUUID().toString();
        return applyFunc(fetchFunc, 1L)
                .flatMap(firstResponseResult -> {
                    if (firstResponseResult == null) {
                        return Single.error(new NzGetPageException(createFailedPageResult(uuId, "request page 1 response is empty")));
                    }
                    if (firstResponseResult.getCode() != NzResponseCode.NZ_SUCCESS) {
                        return Single.error(new NzGetPageException(createFailedPageResult(uuId, "request page 1 response is not success")));
                    }

                    BasePageData firstPageData = firstResponseResult.getData();
                    if (firstPageData == null || firstPageData.getRecords() == null || firstPageData.getRecords().isEmpty()) {
                        return Single.error(new NzGetPageException(createFailedPageResult(uuId, "request page 1 response data is empty")));
                    }

                    ResponseResult<List<R>> responseResult = new ResponseResult<>();
                    responseResult.setCode(firstResponseResult.getCode());
                    responseResult.setMsg(firstResponseResult.getMsg());
                    responseResult.setData(firstPageData.getRecords());
                    NzLog.d("BaseRepositoryUtil : repositoryPagesAsSingle : page 1 : page size : " + firstPageData.getRecords().size());

                    PageSummaryData firstResult = new PageSummaryData();
                    firstResult.setUuId(uuId);
                    firstResult.setSuccess(true);
                    firstResult.setMessage("success");
                    firstResult.setServerCount(firstPageData.getTotal() == null ? 0L : firstPageData.getTotal());
                    firstResult.setTotalPages(firstPageData.getPages() == null ? 0L : firstPageData.getPages());
                    firstResult.setSuccessedPages(1L);
                    firstResult.setFetchedCount(firstPageData.getRecords() == null ? 0 : firstPageData.getRecords().size());

                    return applyFunc(persistFunc, responseResult)
                            .flatMap(firstPersistedResultList -> {
                                List<R> firstPersistedPageList = firstPersistedResultList == null ? null : firstPersistedResultList.getData();
                                firstResult.setPersistedCount(firstPersistedPageList == null ? 0 : firstPersistedPageList.size());

                                if (firstResult.getTotalPages() <= 1L) {
                                    return Single.just(firstResult);
                                }
                                return persistAndAccumulateRemainingPages(fetchFunc, persistFunc, firstResult, 2L, firstResult.getTotalPages() - 1L);
                            });

                })
                .map(BaseRepositoryUtil::wrapPageSummarySuccess)
                .onErrorResumeNext(err -> {
                    if (NzExceptionMapper.isCatchException(err)) {
                        return Single.just(wrapPageSummaryError(err));
                    }
                    return Single.error(err);
                });
    }

    /**
     * 持久化并累积剩余页的数据
     * <p>
     * 内部方法，用于处理第一页之后的所有页
     * </p>
     *
     * @param fetchFunc   分页获取函数
     * @param persistFunc 持久化函数
     * @param firstResult 第一页的统计结果（作为累积的初始值）
     * @param startPage   起始页码（通常为2）
     * @param pageCount   剩余页数
     * @param <R>         列表元素类型
     * @return 累积所有页后的最终统计结果
     */
    private static <R> Single<PageSummaryData> persistAndAccumulateRemainingPages(Function<Long, Single<ResponseResult<BasePageData<R>>>> fetchFunc,
                                                                                  Function<ResponseResult<List<R>>, Single<ResponseResult<List<R>>>> persistFunc,
                                                                                  PageSummaryData firstResult,
                                                                                  Long startPage,
                                                                                  Long pageCount) {
        return Flowable.rangeLong(startPage, pageCount)
                .concatMapSingle(currentPage -> applyFunc(fetchFunc, currentPage)
                        .flatMap(pageResponseResult -> {
                            if (pageResponseResult == null) {
                                return Single.error(new NzGetPageException(createFailedPageResult(firstResult.getUuId(), "request page " + currentPage + " response is empty")));
                            }
                            if (pageResponseResult.getCode() != NzResponseCode.NZ_SUCCESS) {
                                return Single.error(new NzGetPageException(createFailedPageResult(firstResult.getUuId(), "request page " + currentPage + " response is not success")));
                            }
                            // 检查数据有效性
                            BasePageData<R> pageData = pageResponseResult.getData();
                            if (pageData == null || pageData.getRecords() == null || pageData.getRecords().isEmpty()) {
                                return Single.error(new NzGetPageException(createFailedPageResult(firstResult.getUuId(), "request page " + currentPage + " response data is empty")));
                            }
                            // 检查分页一致性
                            if (pageData.getCurrent() != currentPage || pageData.getPages() != firstResult.getTotalPages() || pageData.getTotal() != firstResult.getServerCount()) {
                                return Single.error(new NzGetPageException(createFailedPageResult(firstResult.getUuId(), "request page " + currentPage + " does not match the pagination data on the server side")));
                            }

                            ResponseResult<List<R>> responseResult = new ResponseResult<>();
                            responseResult.setCode(pageResponseResult.getCode());
                            responseResult.setMsg(pageResponseResult.getMsg());
                            responseResult.setData(pageData.getRecords());
                            NzLog.d("BaseRepositoryUtil : repositoryPagesAsSingle : page " + currentPage + " : page size : " + pageData.getRecords().size());

                            return applyFunc(persistFunc, responseResult)
                                    .flatMap(persistedResultList -> {
                                        List<R> persistedPageList = persistedResultList == null ? null : persistedResultList.getData();
                                        long fetchedCount = pageData.getRecords() == null ? 0 : pageData.getRecords().size();
                                        long persistedCount = persistedPageList == null ? 0 : persistedPageList.size();
                                        return Single.just(createCurrentPageResult(firstResult, fetchedCount, persistedCount));
                                    });
                        }))
                .reduce(firstResult, (lastResult, currentResult) -> accumulatePageResult(firstResult.getUuId(), lastResult, currentResult));
    }

    /**
     * 创建单页的统计结果
     *
     * @param firstPageResult 第一页的统计结果（用于继承服务器端的总数和总页数）
     * @param fetchedCount    本页拉取的数据数量
     * @param persistedCount  本页持久化的数据数量
     * @return 本页的统计结果
     */
    private static PageSummaryData createCurrentPageResult(PageSummaryData firstPageResult, long fetchedCount, long persistedCount) {
        PageSummaryData thisResult = new PageSummaryData();
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
    private static PageSummaryData createFailedPageResult(String uuId, String message) {
        PageSummaryData result = new PageSummaryData();
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
    private static PageSummaryData accumulatePageResult(String uuId, PageSummaryData lastResult, PageSummaryData currentResult) throws NzGetPageException {
        NzLog.d("BaseRepositoryUtil : accumulatePageResult : lastResult : " + lastResult.getFetchedCount() + ", currentResult : " + currentResult.getFetchedCount());
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

    private static ResponseResult<PageSummaryData> wrapPageSummarySuccess(PageSummaryData summary) {
        ResponseResult<PageSummaryData> result = new ResponseResult<>();
        result.setCode(NzResponseCode.NZ_SUCCESS);
        result.setMsg(summary != null ? summary.getMessage() : "success");
        result.setData(summary);
        return result;
    }

    private static ResponseResult<PageSummaryData> wrapPageSummaryError(Throwable throwable) {
        ResponseResult<PageSummaryData> result = new ResponseResult<>();

        if (throwable instanceof NzGetPageException) {
            PageSummaryData failed = ((NzGetPageException) throwable).getResult();
            result.setCode(NzResponseCode.NZ_FETCH_PAGE_ERROR);
            result.setMsg(failed != null ? failed.getMessage() : throwable.getMessage());
            result.setData(failed);
            return result;
        }

        ResponseResult<?> mappedResult = NzExceptionMapper.createExceptioResult(throwable);
        if (mappedResult != null) {
            result.setCode(mappedResult.getCode());
            result.setMsg(mappedResult.getMsg());
            result.setData(createFailedPageResult(UUID.randomUUID().toString(), mappedResult.getMsg()));
        } else {
            result.setCode(NzResponseCode.NZ_UNKNOWN_ERROR);
            result.setMsg(throwable.getMessage());
            result.setData(createFailedPageResult(UUID.randomUUID().toString(), throwable.getMessage()));
        }
        return result;
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
