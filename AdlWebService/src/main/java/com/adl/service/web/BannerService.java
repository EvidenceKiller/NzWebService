package com.adl.service.web;

import com.adl.service.common.InnerUtil;
import com.adl.service.common.RequestResult;
import com.adl.service.entity.BannerEntity;
import com.adl.service.web.constants.Platform;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * ProjectName: AiPowerAuth
 * Author     : 南山
 * Date       : 2024/7/1
 * Describe   : 用户数据查询
 * 1. 获取banner
 */
public class BannerService extends BaseHttpService {

    ////////// 获取banner
    public static List<BannerEntity> getBannerDetail(String id) {
        try {
            d("From Http 获取banner");

            Map<String, Object> map = new HashMap<>();
            //  appcode+位置编码(adl_bms_banner_position) （例大屏首页：id=10110101，101101为appcode， 01为位置编码）
            map.put("id", id);
            String param = InnerUtil.toJson(map);

            String url;
            if (Platform.V3.equals(getConfigService().getPlatform())) {
                url = wrapperUrl("/v3/gateway/api/tis/device/oper/banner/getDetailList");
            } else {
                url = wrapperUrl("/busi/terminal/k12/banner/v1/detail/list");
            }
            Request request = new Request.Builder().url(url)
                    .post(RequestBody.create(param, jsonType)).build();
            RequestResult result = parserResponse(mClient.newCall(request).execute());
            if (result.isOk()) {
                String str = InnerUtil.readRecords(result.getContent().toString());
                return InnerUtil.jsonToType(str, new TypeToken<ArrayList<BannerEntity>>() {
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}