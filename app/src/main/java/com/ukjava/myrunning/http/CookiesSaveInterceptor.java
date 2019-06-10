package com.ukjava.myrunning.http;


import com.ukjava.myrunning.main.MyApplication;
import com.ukjava.myrunning.utils.PreferenceUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author:
 * @date: 2019/3/11
 * @description: 保存cookie
 */
public class CookiesSaveInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()){
            String header = originalResponse.header("Set-Cookie");
            PreferenceUtil.getInstances(MyApplication.getInstance()).savePreferenceString("cookiess",header);

        }
        return originalResponse;
    }
}
