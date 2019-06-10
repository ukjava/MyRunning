package com.ukjava.myrunning.http;


import android.util.Log;

import com.ukjava.myrunning.BuildConfig;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author:
 * @date: 2019/3/11
 * @description: 日志拦截器
 */

public class InterceptorUtil {
    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (BuildConfig.DEBUG)
                    Log.e("TAG日志拦截器", "log: " + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }
}
