package com.adl.service.db.converter;

import com.adl.service.web.response.SportMeetSimpleClassData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class ListSportMeetSimpleClassDataConverter {

    @TypeConverter
    public static List<SportMeetSimpleClassData> stringToObject(String value) {
        Type listType = new TypeToken<List<SportMeetSimpleClassData>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String objectToString(List<SportMeetSimpleClassData> json) {
        Gson gson = new Gson();
        return gson.toJson(json);
    }
}
