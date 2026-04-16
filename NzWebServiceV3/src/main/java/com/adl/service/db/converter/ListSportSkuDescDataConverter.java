package com.adl.service.db.converter;

import com.adl.service.web.response.SportSkuDescData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class ListSportSkuDescDataConverter {

    @TypeConverter
    public static List<SportSkuDescData> stringToObject(String value) {
        Type listType = new TypeToken<List<SportSkuDescData>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String objectToString(List<SportSkuDescData> json) {
        Gson gson = new Gson();
        return gson.toJson(json);
    }
}
