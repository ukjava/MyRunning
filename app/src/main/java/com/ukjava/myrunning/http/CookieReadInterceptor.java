package com.ukjava.myrunning.http;


import com.ukjava.myrunning.main.MyApplication;
import com.ukjava.myrunning.utils.PreferenceUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author:
 * @date: 2019/3/11
 * @description: 读取cookie
 */
public class CookieReadInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Cookie",PreferenceUtil.getInstances(MyApplication.getInstance()).getPreferenceString("cookiess"));
        return chain.proceed(builder.build());
    }
}
