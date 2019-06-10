package com.ukjava.myrunning.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ukjava.myrunning.main.bean.LoginBean;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Copyright 2017-2100 ZYS.All rights reserved
 * Author：ZengYuSi
 * CreateTime：at  2017/11/22 16:32
 * Description：保存数据工具
 * Email: 1026348794@qq.com
 */


public class PreferenceUtil {
    private static PreferenceUtil instance;
    public static String TOKEN;

    private Context mContext;

    private PreferenceUtil(Context mContext) {
        this.mContext = mContext;
    }

    public static PreferenceUtil getInstances(Context context) {
        if (instance == null) {
            instance = new PreferenceUtil(context);
        }
        return instance;
    }


    /**
     * 存储的偏好名称
     */
    public static final String userinfo = "userinfo_pref";

    /**
     * 提交字符串
     *
     * @param key
     * @param value
     */
    public void savePreferenceString(String key, String value) {
        SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 删除某一个提交的偏好值
     *
     * @param key
     */
    public void deleteKey(String key) {
        try {
            SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(key);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 提交boolean类型的值
     *
     * @param key
     * @param value
     */
    public void savePreferenceBoolean(String key, boolean value) {
        SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 获取boolean类型的值
     *
     * @param key
     * @return false
     */
    public boolean getPreferenceBoolean(String key) {
        SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    /**
     * @param key
     * @return true
     */
    public boolean getPreferenceBoolean1(String key) {
        SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                MODE_PRIVATE);
        return preferences.getBoolean(key, true);
    }

    /**
     * 提交long类型的值
     *
     * @param key
     * @param value
     */
    public void savePreferenceLong(String key, long value) {
        SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * 获取偏好中的字符串
     *
     * @param key
     * @return
     */
    public String getPreferenceString(String key) {
        SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    /**
     * 获取偏好中的long类型的值
     *
     * @param key
     * @return
     */
    public long getPreferenceLong(String key) {
        SharedPreferences preferences = mContext.getSharedPreferences(userinfo,
                MODE_PRIVATE);
        return preferences.getLong(key, 0);
    }

    /**
     * 保存获取的登录值
     *
     * @param key
     * @param object
     */
    public void setLogin(String key, LoginBean object) {
        SharedPreferences sp = mContext.getSharedPreferences(userinfo, MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();// 获取编辑器
        String string = JSONObject.toJSONString(object);
        edit.putString(key, string);
        edit.commit();
    }

    /**
     * 获取Object
     *
     * @param key
     * @return
     */
    public LoginBean getLogin(String key) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(userinfo, MODE_PRIVATE);
        String string = sharedPreferences.getString(key, null);
        LoginBean bean = JSONObject.parseObject(string, LoginBean.class);
        return bean;
    }

    /**
     * 用于保存集合
     *
     * @param key  key
     * @param list 集合数据
     * @return 保存结果
     */
    public  <T> boolean putListData(String key, List<T> list) {
        boolean result;
        String type = list.get(0).getClass().getSimpleName();
        SharedPreferences sp = mContext.getSharedPreferences(userinfo, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        JsonArray array = new JsonArray();
        try {
            switch (type) {
                case "Boolean":
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Boolean) list.get(i));
                    }
                    break;
                case "Long":
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Long) list.get(i));
                    }
                    break;
                case "Float":
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Float) list.get(i));
                    }
                    break;
                case "String":
                    for (int i = 0; i < list.size(); i++) {
                        array.add((String) list.get(i));
                    }
                    break;
                case "Integer":
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Integer) list.get(i));
                    }
                    break;
                default:
                    Gson gson = new Gson();
                    for (int i = 0; i < list.size(); i++) {
                        JsonElement obj = gson.toJsonTree(list.get(i));
                        array.add(obj);
                    }
                    break;
            }
            editor.putString(key, array.toString());
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        editor.apply();
        return result;
    }


    /**
     * 获取保存的List
     *
     * @param key key
     * @return 对应的Lis集合
     */
    public  <T> List<T> getListData(String key, Class<T> cls) {
        List<T> list = new ArrayList<>();
        SharedPreferences sp = mContext.getSharedPreferences(userinfo, MODE_PRIVATE);
        String json = sp.getString(key, "");
        if (!json.equals("") && json.length() > 0) {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(json).getAsJsonArray();
            for (JsonElement elem : array) {
                list.add(gson.fromJson(elem, cls));
            }
        }
        return list;
    }



}
