package com.ukjava.myrunning.http.base;

import com.ukjava.myrunning.http.CookieReadInterceptor;
import com.ukjava.myrunning.http.CookiesSaveInterceptor;
import com.ukjava.myrunning.http.InterceptorUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Author ：zouyi
 * Time ： 2019/3/20
 * Declare ：
 */

public class OkHttpClients {
    public static final int TIMEOUT = 60;//超时时间
    private static OkHttpClient mOkHttpClient;

    //实例化OKhttpclient的方法
    public static OkHttpClient initOKHttp(){
        if (mOkHttpClient == null){
            //如果OKhttpclient为空则创建
           mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
            .readTimeout(TIMEOUT,TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(TIMEOUT,TimeUnit.SECONDS)//设置写入超时时间
            .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
            //cookie
            .addInterceptor(new CookieReadInterceptor())
                    .addInterceptor(new CookiesSaveInterceptor())
                    .retryOnConnectionFailure(true)//错误重连
            .build();
        }

        //已经存在则直接返回
        return mOkHttpClient;
    }

}
