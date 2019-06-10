package com.ukjava.myrunning.http;


import com.ukjava.myrunning.http.base.OkHttpClients;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Params : retrofit请求工具类
 * @Author : zouyi
 * @Time : 2019/3/11
 */
public class RetrofitUtil {
    //超时时间
    private static volatile RetrofitUtil mInstance;
    private AllApi allApi;

    /**
     * 单例封装
     * @return
     */
    public static RetrofitUtil getInstance(){
        if (mInstance == null){
            synchronized (RetrofitUtil.class){
                if (mInstance == null){
                    mInstance = new RetrofitUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化Retrofit
     */
    public AllApi initRetrofit(){
        if (allApi == null){
            Retrofit mRetrofit = new Retrofit.Builder()
                    .client(OkHttpClients.initOKHttp())
                    // 设置请求的域名
                    .baseUrl(HttpUrls.baseUrl)
                    // 设置解析转换工厂，用自己定义的
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            allApi = mRetrofit.create(AllApi.class);
        }
        return allApi;
    }
}
