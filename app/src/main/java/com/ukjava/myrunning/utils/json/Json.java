package com.ukjava.myrunning.utils.json;

/**
 * Description：gson工具类
 * create by cczhr on 2017/10/16
 * Email: cczhr1@163.com
 */

import java.util.List;

public abstract class Json {
    private static Json json;
    Json() {
    }
    public static Json get() {
        if (json == null) {
            json = new GsonImpl();
        }
        return json;
    }
    public abstract String toJson(Object src);
    public abstract <T> T toObject(String json, Class<T> claxx);
    public abstract <T> T toObject(byte[] bytes, Class<T> claxx);
    public abstract <T> List<T> toList(String json, Class<T> claxx);
}