package com.adl.service.web.response.converter;

import com.adl.service.web.response.SportProjectData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class ListSportProjectDataConverter {

    @TypeConverter
    public static List<SportProjectData> stringToObject(String value) {
        Type listType = new TypeToken<List<SportProjectData>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String objectToString(List<SportProjectData> json) {
        Gson gson = new Gson();
        return gson.toJson(json);
    }
}
