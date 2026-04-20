package com.adl.service.internal;

import com.adl.service.caller.BigScreenH5Caller;
import com.adl.service.caller.BigScreenStatsCaller;
import com.adl.service.caller.BusinessCaller;
import com.adl.service.caller.CommonInfoCaller;
import com.adl.service.caller.LoginAuthCaller;
import com.adl.service.caller.OperationCaller;
import com.adl.service.caller.OrgTestCaller;
import com.adl.service.caller.SportInfoCaller;
import com.adl.service.caller.impl.BigScreenH5CallerImpl;
import com.adl.service.caller.impl.BigScreenStatsCallerImpl;
import com.adl.service.caller.impl.BusinessCallerImpl;
import com.adl.service.caller.impl.CommonInfoCallerImpl;
import com.adl.service.caller.impl.LoginAuthCallerImpl;
import com.adl.service.caller.impl.OperationCallerImpl;
import com.adl.service.caller.impl.OrgTestCallerImpl;
import com.adl.service.caller.impl.SportInfoCallerImpl;
import com.adl.service.log.NzLog;
import com.adl.service.web.BigScreenH5Service;
import com.adl.service.web.BigScreenStatsService;
import com.adl.service.web.BusinessService;
import com.adl.service.web.CommonInfoService;
import com.adl.service.web.LoginAuthService;
import com.adl.service.web.OperationService;
import com.adl.service.web.OrgTestService;
import com.adl.service.web.SportInfoService;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Retrofit 与 Caller 统一管理器（单例）。
 */
public final class RetrofitManager {

    private static volatile RetrofitManager instance;

    private String host;
    private boolean debug;

    private volatile boolean isInit = false;

    private RetrofitClient retrofitClient;

    private CommonInfoCaller commonInfoCaller;
    private SportInfoCaller sportInfoCaller;
    private OrgTestCaller orgTestCaller;
    private OperationCaller operationCaller;
    private BusinessCaller businessCaller;
    private LoginAuthCaller loginAuthCaller;
    private BigScreenStatsCaller bigScreenStatsCaller;
    private BigScreenH5Caller bigScreenH5Caller;

    private RetrofitManager() {
    }

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    public synchronized void init(String host, boolean debug) {
        if (isInit) {
            NzLog.i("RetrofitManager has been initialized.");
            return;
        }
        isInit = true;

        this.host = host;
        this.debug = debug;
        retrofitClient = new RetrofitClient();
        retrofitClient.init(host, debug);

        this.commonInfoCaller = new CommonInfoCallerImpl();
        this.sportInfoCaller = new SportInfoCallerImpl();
        this.orgTestCaller = new OrgTestCallerImpl();
        this.operationCaller = new OperationCallerImpl();
        this.businessCaller = new BusinessCallerImpl();
        this.loginAuthCaller = new LoginAuthCallerImpl();
        this.bigScreenStatsCaller = new BigScreenStatsCallerImpl();
        this.bigScreenH5Caller = new BigScreenH5CallerImpl();
    }

    public <T> T create(Class<T> service) {
        return retrofitClient.create(service);
    }

    // TODO 临时开放
    public Response newCall(Request request) throws IOException {
        return retrofitClient.newCall(request);
    }

    public synchronized void release() {
        isInit = false;
        retrofitClient.release();
        retrofitClient = null;

        commonInfoCaller = null;
        sportInfoCaller = null;
        orgTestCaller = null;
        operationCaller = null;
        businessCaller = null;
        loginAuthCaller = null;
        bigScreenStatsCaller = null;
        bigScreenH5Caller = null;
    }

    public CommonInfoCaller getCommonInfoCaller() {
        return commonInfoCaller;
    }

    public SportInfoCaller getSportInfoCaller() {
        return sportInfoCaller;
    }

    public OrgTestCaller getOrgTestCaller() {
        return orgTestCaller;
    }

    public OperationCaller getOperationCaller() {
        return operationCaller;
    }

    public BusinessCaller getBusinessCaller() {
        return businessCaller;
    }

    public LoginAuthCaller getLoginAuthCaller() {
        return loginAuthCaller;
    }

    public BigScreenStatsCaller getBigScreenStatsCaller() {
        return bigScreenStatsCaller;
    }

    public BigScreenH5Caller getBigScreenH5Caller() {
        return bigScreenH5Caller;
    }
}
