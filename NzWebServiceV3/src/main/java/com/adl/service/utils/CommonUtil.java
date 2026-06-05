package com.adl.service.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import com.adl.service.exception.NzCommonException;
import com.adl.service.log.NzLog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import io.reactivex.rxjava3.core.Single;

public class CommonUtil {

    public static void waitSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return null != networkInfo && networkInfo.isConnected();
        } else {
            Network network = cm.getActiveNetwork();
            if (network != null) {
                NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
                return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
            }
        }
        return false;
    }

    //  List深度复制，List<E> 需要 E 对象实现接口 Serializable，否则会报错。
    public static <E> List<E> deepCopy(List<E> src) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<E> dest = (List<E>) in.readObject();
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<E>();
        }
    }

    public static <T> boolean isNotEmptyList(List<T> list) {
        return list != null && !list.isEmpty();
    }

    public static <T> boolean isEmptyList(List<T> list) {
        return list == null || list.isEmpty();
    }

    private static final List<String> acceptLanguages = Arrays.asList("zh-CN", "zh-TW", "en-US");

    public static String getLocaleLanguage() {
        Locale currentLocale = Locale.getDefault();

        String language = currentLocale.getLanguage();//zh,en
        String regional = currentLocale.getCountry();//CN,TW,HK
        String script = currentLocale.getScript();//Hans 简体中文 Hant 繁体中文

        //  英文
        if ("en".equals(language)) {
            return acceptLanguages.get(2);
        }
        //  繁体中文
        if ("zh".equals(language) && ("TW".equals(regional) || "HK".equals(regional))) {
            return acceptLanguages.get(1);
        }
        //  繁体中文
        if ("zh".equals(language) && ("CN".equals(regional))) {
            if ("Hant".equals(script)) {
                return acceptLanguages.get(1);
            }
        }

        //  默认简体中文
        return acceptLanguages.get(0);
    }

    public static <T> T createEmptyObject(Class<T> clazz) {
        if (clazz == null) {
            NzLog.e("CommonUtil::createEmptyObject : clazz is null");
            return null;
        }
        if (clazz == String.class) return (T) "";
        if (clazz == int.class || clazz == Integer.class) return (T) Integer.valueOf(0);
        if (clazz == long.class || clazz == Long.class) return (T) Long.valueOf(0L);
        if (clazz == boolean.class || clazz == Boolean.class) return (T) Boolean.FALSE;
        if (clazz == double.class || clazz == Double.class) return (T) Double.valueOf(0D);
        if (clazz == float.class || clazz == Float.class) return (T) Float.valueOf(0F);
        if (clazz == short.class || clazz == Short.class) return (T) Short.valueOf((short) 0);
        if (clazz == byte.class || clazz == Byte.class) return (T) Byte.valueOf((byte) 0);
        if (clazz == char.class || clazz == Character.class) return (T) Character.valueOf('\0');
        if (List.class.isAssignableFrom(clazz)) {
            @SuppressWarnings("unchecked")
            T emptyList = (T) Collections.emptyList();
            return emptyList;
        }
        try {
            T defaultData = clazz.getDeclaredConstructor().newInstance();
            return defaultData;
        } catch (Throwable e) {
            NzLog.e("CommonUtil::createEmptyObject : " + clazz.getName() + " cannot instantiate : " + e.getMessage());
            return null;
        }
    }

    public static <T> Single<T> createEmptySingle(Class<T> clazz) {
        if (clazz == null) {
            return Single.error(new NzCommonException("data is null and clazz is null"));
        }
        if (clazz == String.class) return Single.just((T) "");
        if (clazz == int.class || clazz == Integer.class) return Single.just((T) Integer.valueOf(0));
        if (clazz == long.class || clazz == Long.class) return Single.just((T) Long.valueOf(0L));
        if (clazz == boolean.class || clazz == Boolean.class) return Single.just((T) Boolean.FALSE);
        if (clazz == double.class || clazz == Double.class) return Single.just((T) Double.valueOf(0D));
        if (clazz == float.class || clazz == Float.class) return Single.just((T) Float.valueOf(0F));
        if (clazz == short.class || clazz == Short.class) return Single.just((T) Short.valueOf((short) 0));
        if (clazz == byte.class || clazz == Byte.class) return Single.just((T) Byte.valueOf((byte) 0));
        if (clazz == char.class || clazz == Character.class) return Single.just((T) Character.valueOf('\0'));
        if (List.class.isAssignableFrom(clazz)) {
            @SuppressWarnings("unchecked")
            T emptyList = (T) Collections.emptyList();
            return Single.just(emptyList);
        }
        try {
            T defaultData = clazz.getDeclaredConstructor().newInstance();
            return Single.just(defaultData);
        } catch (Throwable e) {
            return Single.error(new NzCommonException("data is null and cannot instantiate " + clazz.getName(), e));
        }
    }
}
