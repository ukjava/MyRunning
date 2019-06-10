package com.ukjava.myrunning.utils.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：gson工具类
 * create by cczhr on 2017/10/16
 * Email: cczhr1@163.com
 */
/*
 *    例子
 *    Bean bean[] = GsonImpl.get().toObject(json,  Bean[].class);//json串转数组
 *    List<Bean> been=GsonImpl.get().toList(json, Bean.class);//json串转list
 *    String json = GsonImpl.get().toJson(bean)//bean转json字符串
 *
 * */

public class GsonImpl extends Json{
    private Gson gson = new Gson();
    @Override
    public String toJson(Object src) {
        return gson.toJson(src);
    }
    @Override
    public <T> T toObject(String json, Class<T> claxx) {
        return gson.fromJson(json, claxx);
    }
    @Override
    public <T> T toObject(byte[] bytes, Class<T> claxx) {
        return gson.fromJson(new String(bytes), claxx);
    }
    @Override
    public <T> List<T> toList(String json, Class<T> claxx) {
        Type type = new TypeToken<ArrayList<T>>() {}.getType();
        List<T> list = gson.fromJson(json, type);
        return list;
    }
}
