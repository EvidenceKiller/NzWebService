package com.adl.service.web;

import android.text.TextUtils;

import com.adl.service.common.InnerUtil;
import com.adl.service.common.RequestResult;
import com.adl.service.entity.OrgResInfoEntity;
import com.adl.service.entity.TeacherResEntity;
import com.adl.service.entity.WikiTypeEntity;
import com.adl.service.web.constants.Platform;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

public class ResService extends BaseHttpService {

    /**
     * 获取校本和备课助手详情信息
     * @param resId
     * @return
     */
    public static OrgResInfoEntity getOrgResInfo(String resId) {
        try {
            d("From Http 获取百科详情");
            Map<String, Object> map = new HashMap<>();
            map.put("id", resId);
            String param = InnerUtil.toJson(map);

            String url;
            if (Platform.V3.equals(getConfigService().getPlatform())) {
                url = wrapperUrl("/v3/gateway/api/tis/device/org/res/getResInfo");
            } else {
                url = wrapperUrl("/busi/terminal/org/res/v1/info");
            }
            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(param, jsonType)).build();
            RequestResult result = parserResponse(getHttpClient().newCall(request).execute());
            if (result.isOk()) {
                return InnerUtil.jsonToType(result.getContent().toString(), new TypeToken<OrgResInfoEntity>() {
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取资源列表
     *
     * @param createNum
     * @param resType
     * @return
     */
    public static TeacherResEntity getResList(String createNum, int resType, String appCode) {
        try {
            d("From Http 获取教师资源列表");
            Map<String, Object> map = new HashMap<>();
            map.put("createNum", createNum);
            map.put("resType", resType);
            map.put("appCode", appCode);
            String param = InnerUtil.toJson(map);
            String url;
            if (Platform.V3.equals(getConfigService().getPlatform())) {
                url = wrapperUrl("/v3/gateway/api/tis/device/org/res/getResList");
            } else {
                url = wrapperUrl("/busi/terminal/org/res/v1/list");
            }
            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(param, jsonType)).build();
            RequestResult result = parserResponse(getHttpClient().newCall(request).execute());
            if (result.isOk()) {
                return InnerUtil.jsonToType(result.getContent().toString(), new TypeToken<TeacherResEntity>() {
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取资源列表
     *
     * @param createNum
     * @param resType
     * @return
     */
    public static TeacherResEntity getResListByPage(String createNum, int resType, String appCode, int current, int pageSize) {
        return getResListByPage(createNum, resType, "", appCode, current, pageSize);
    }

    /**
     * 获取资源列表
     *
     * @param createNum
     * @param resType
     * @return
     */
    public static TeacherResEntity getResListByPage(String createNum, int resType, String resTypeId, String appCode, int current, int pageSize) {
        try {
            d("From Http 获取教师资源列表");
            Map<String, Object> map = new HashMap<>();
            map.put("createNum", createNum);
            map.put("resType", resType);
            map.put("appCode", appCode);
            map.put("current", current);// 当前页
            if (!TextUtils.isEmpty(resTypeId)){
                map.put("resTypeId", resTypeId);
            }
            map.put("pageSize", pageSize); // 每页大小
            String param = InnerUtil.toJson(map);

            String url;
            if (Platform.V3.equals(getConfigService().getPlatform())) {
                url = wrapperUrl("/v3/gateway/api/tis/device/org/res/getResList");
            } else {
                url = wrapperUrl("/busi/terminal/org/res/v1/list");
            }
            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(param, jsonType)).build();
            RequestResult result = parserResponse(getHttpClient().newCall(request).execute());
            if (result.isOk()) {
                String str = InnerUtil.readRecords(result.getContent().toString());
                return InnerUtil.jsonToType(str, new TypeToken<TeacherResEntity>() {
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取资源类型列表
     * @param resType
     * @return
     */
    public static List<WikiTypeEntity.WikiTypeInfo> getResListType(int resType) {
        try {
            d("From Http 获取教师资源列表");
            Map<String, Object> map = new HashMap<>();
            map.put("resType", resType);
            String param = InnerUtil.toJson(map);

            String url;
            if (Platform.V3.equals(getConfigService().getPlatform())) {
                url = wrapperUrl("/v3/gateway/api/tis/device/org/res/getResTypeList");
            } else {
                url = wrapperUrl("/busi/terminal/org/res/v1/list/type");
            }
            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(param, jsonType)).build();
            RequestResult result = parserResponse(getHttpClient().newCall(request).execute());
            if (result.isOk()) {
                return InnerUtil.jsonToType(result.getContent().toString(), new TypeToken<ArrayList<WikiTypeEntity.WikiTypeInfo>>() {
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
