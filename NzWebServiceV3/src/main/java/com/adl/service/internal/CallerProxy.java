package com.adl.service.internal;

import com.adl.service.callback.RequestCallback;
import com.adl.service.callback.RequestLoadingCallback;
import com.adl.service.callback.RequestUserCallback;
import com.adl.service.data.StudentData;
import com.adl.service.data.TeacherData;
import com.adl.service.http.request.RequestScope;
import com.adl.service.log.NzLog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import androidx.annotation.RestrictTo;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class CallerProxy {

    private static final int MAX_TEXT_LEN = 10000;
    private static final int MAX_STACK_DEPTH = 5;


    private CallerProxy() {}

    @SuppressWarnings("unchecked")
    public static <T> T wrap(Class<T> api, T target) {
        return (T) Proxy.newProxyInstance(api.getClassLoader(), new Class<?>[]{api}, (proxy, method, args) -> invoke(api, target, method, args)
        );
    }

    private static Object invoke(Class<?> api, Object target, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        String traceId = UUID.randomUUID().toString().substring(0, 8);
        String stackStr = convertStackTrace(api.getSimpleName() + "::" + method.getName());
        NzLog.d("[CALLER-IN ][%s] %s : args=%s", traceId, stackStr, formatArgs(args));

        Object[] invokeArgs = args;
        boolean hasCallback = containsRequestCallback(args);
        if (hasCallback) {
            invokeArgs = wrapRequestCallbacks(args, traceId, stackStr, start);
        }
        try {
            Object result = method.invoke(target, invokeArgs);
            long cost = System.currentTimeMillis() - start;
            NzLog.d("[CALLER-OUT][%s] %s : cost=%dms result=%s", traceId, stackStr, cost, formatResult(result));
            return result;
        } catch (InvocationTargetException e) {
            Throwable real = e.getTargetException();
            long cost = System.currentTimeMillis() - start;
            NzLog.e("[CALLER-ERR][%s] %s : cost=%dms err=%s", traceId, stackStr, cost, String.valueOf(real));
            throw real;
        }
    }

    private static String convertStackTrace(String methodName) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        List<StackTraceElement> frames = new ArrayList<>();

        for (StackTraceElement e : stack) {
            String cls = e.getClassName();
            // 过滤框架/系统/代理噪音
            if (cls.startsWith("java")
                    || cls.startsWith("kotlin")
                    || cls.startsWith("android")
                    || cls.startsWith("com.android")
                    || cls.startsWith("dalvik")
                    || cls.startsWith("sun")
                    || cls.startsWith("okhttp")
                    || cls.startsWith("retrofit")
                    || cls.startsWith("com.adl.service")
                    || cls.contains("$Proxy")) {
                continue;
            }
            frames.add(e);
        }
        Collections.reverse(frames);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (StackTraceElement e : frames) {
            if (count++ >= MAX_STACK_DEPTH) {
                break;
            }
            sb.append(extractHostClassName(e.getClassName())).append("::").append(e.getMethodName()).append("->");
        }

        sb.append(methodName);
        return sb.toString();
    }

    public static String extractHostClassName(String fullClassName) {
        if (fullClassName == null || fullClassName.trim().isEmpty()) {
            return "";
        }

        // 1) 取简单类名（去包名）
        String simple = fullClassName;
        int dot = simple.lastIndexOf('.');
        if (dot >= 0 && dot < simple.length() - 1) {
            simple = simple.substring(dot + 1);
        }

        // 2) 去掉 Kotlin/Java/Android 生成后缀：$$...
        int dollar2 = simple.indexOf("$$");
        if (dollar2 >= 0) {
            simple = simple.substring(0, dollar2);
        }

        // 3) 去掉内部类标记：Outer$Inner -> Outer（按你的需求只要宿主 Activity）
        int dollar1 = simple.indexOf('$');
        if (dollar1 >= 0) {
            simple = simple.substring(0, dollar1);
        }

        // 4) 去掉匿名类数字后缀（极端情况）
        // e.g. SomeActivity1 -> SomeActivity（如果你不希望这样，可去掉这段）
        int end = simple.length();
        while (end > 0 && Character.isDigit(simple.charAt(end - 1))) {
            end--;
        }
        if (end > 0 && end < simple.length()) {
            simple = simple.substring(0, end);
        }

        return simple;
    }

    private static boolean containsRequestCallback(Object[] args) {
        if (args == null) return false;
        for (Object arg : args) {
            if (arg instanceof RequestCallback) return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private static Object[] wrapRequestCallbacks(Object[] args, String traceId, String methodName, long start) {
        if (args == null || args.length == 0) return args;
        Object[] wrapped = Arrays.copyOf(args, args.length);

        for (int i = 0; i < wrapped.length; i++) {
            Object arg = wrapped[i];
            if (arg instanceof RequestUserCallback) {
                wrapped[i] = wrapRequestUserCallback(traceId, methodName, start, (RequestUserCallback) arg);
            } else if (arg instanceof RequestLoadingCallback) {
                wrapped[i] = wrapRequestLoadingCallback(traceId, methodName, start, (RequestLoadingCallback) arg);
            } else if (arg instanceof RequestCallback) {
                wrapped[i] = wrapRequestCallback(traceId, methodName, start, (RequestCallback) arg);
            }
        }
        return wrapped;
    }

    private static RequestCallback wrapRequestCallback(String traceId, String methodName, long start, RequestCallback origin) {
        return new RequestCallback<Object>() {
            @Override
            public void onSuccess(Object data) {
                long total = System.currentTimeMillis() - start;
                NzLog.d("[CALLER-CB ][%s] %s : onSuccess total=%dms result=%s", traceId, methodName, total, formatResult(data));
                origin.onSuccess(data);
            }

            @Override
            public void onError(int code, String msg) {
                long total = System.currentTimeMillis() - start;
                NzLog.e("[CALLER-CB ][%s] %s : onError total=%dms code=%d msg=%s", traceId, methodName, total, code, msg);
                origin.onError(code, msg);
            }
        };
    }

    private static RequestLoadingCallback wrapRequestLoadingCallback(String traceId, String methodName, long start, RequestLoadingCallback origin) {
        return new RequestLoadingCallback<Object>(origin.getContext()) {
            @Override
            public void success(Object data) {
                long total = System.currentTimeMillis() - start;
                NzLog.d("[CALLER-CB ][%s] %s : success total=%dms result=%s", traceId, methodName, total, formatResult(data));
                origin.success(data);
            }

            @Override
            public void error(String error) {
                long total = System.currentTimeMillis() - start;
                NzLog.e("[CALLER-CB ][%s] %s : error total=%dms err=%s", traceId, methodName, total, error);
                origin.error(error);
            }
        }.showDialog(origin.isShowDialog()).showErrorText(origin.isShowErrorText()).setLoadingText(origin.getLoadingText());
    }

    private static RequestUserCallback wrapRequestUserCallback(String traceId, String methodName, long start, RequestUserCallback origin) {
        return (RequestUserCallback) new RequestUserCallback(origin.getContext()) {
            @Override
            public void success(Object data) {
                long total = System.currentTimeMillis() - start;
                NzLog.d("[CALLER-CB ][%s] %s : success total=%dms result=%s", traceId, methodName, total, formatResult(data));
                origin.success(data);
            }

            @Override
            public void error(String error) {
                long total = System.currentTimeMillis() - start;
                NzLog.e("[CALLER-CB ][%s] %s : error total=%dms err=%s", traceId, methodName, total, error);
                origin.error(error);
            }

            @Override
            public void nextStatus(int status, String msg) {
                NzLog.d("[CALLER-CB ][%s] %s : nextStatus status=%d msg=%s", traceId, methodName, status, msg);
                origin.nextStatus(status, msg);
            }

            @Override
            public void orgChange(String newOrgId, String oldOrgId) {
                NzLog.d("[CALLER-CB ][%s] %s : orgChange newOrgId=%s oldOrgId=%s", traceId, methodName, newOrgId, oldOrgId);
                origin.orgChange(newOrgId, oldOrgId);
            }

            @Override
            public void updateStudent(List<StudentData> updateData, List<StudentData> deleteData) {
                NzLog.d("[CALLER-CB ][%s] %s : updateStudent updateData=%d deleteData=%d", traceId, methodName, (updateData == null ? 0 : updateData.size()), (deleteData == null ? 0 : deleteData.size()));
                origin.updateStudent(updateData, deleteData);
            }

            @Override
            public void updateTeacher(List<TeacherData> updateData, List<TeacherData> deleteData) {
                NzLog.d("[CALLER-CB ][%s] %s : updateTeacher updateData=%d deleteData=%d", traceId, methodName, (updateData == null ? 0 : updateData.size()), (deleteData == null ? 0 : deleteData.size()));
                origin.updateTeacher(updateData, deleteData);
            }
        }.showDialog(origin.isShowDialog()).showErrorText(origin.isShowErrorText()).setLoadingText(origin.getLoadingText());
    }

    private static String formatArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        boolean appended = false;
        for (Object arg : args) {
            if (shouldSkipArg(arg)) {
                continue;
            }
            if (appended) {
                sb.append(", ");
            }
            sb.append(formatValue(arg));
            appended = true;
        }
        sb.append("]");
        return sb.toString();
    }

    private static boolean shouldSkipArg(Object arg) {
        if (arg == null) {
            return false;
        }
        return arg instanceof RequestCallback || arg instanceof RequestScope;
    }

    private static String formatResult(Object result) {
        if (result == null) {
            return "null";
        }

        if (result instanceof java.util.List) {
            java.util.List<?> list = (java.util.List<?>) result;
            int size = list.size();

            String typeName = "UNKNOWN";
            if (size > 0 && list.get(0) != null) {
                typeName = list.get(0).getClass().getSimpleName();
            }

            return "List<" + typeName + ">(size=" + size + ")";
        } else {
            return formatValue(result); // 非集合对象打印 toString（带截断）
        }
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        String text = value.toString();
        if (text.length() > MAX_TEXT_LEN) {
            return text.substring(0, MAX_TEXT_LEN) + "...";
        }
        return text;
    }
}