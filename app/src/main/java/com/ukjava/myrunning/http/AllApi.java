package com.ukjava.myrunning.http;


import com.ukjava.myrunning.http.base.BaseEntry;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.module.Record.been.RecordBeen;
import com.ukjava.myrunning.module.check.been.CheckUserBeen;
import com.ukjava.myrunning.module.news.bean.Result;
import com.ukjava.myrunning.weather.bean.WeatherBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @declare : 全局api
 * @Author : zouyi
 * @Time : 2019/3/11
 */
public interface AllApi {

    /**
     * 登录
     * @param maps
     * @return
     */
    @POST(HttpUrls.LOGIN)
    Observable<BaseEntry<LoginBean>> Login (@Body HashMap<String,Object> maps);
    /**
     * 天气
     * @param maps
     * @return
     */
    @GET(HttpUrls.WEATHER)
    Observable<BaseEntry<WeatherBean>> Weather (@QueryMap HashMap<String,Object> maps);

    /**
     * 新闻头条
     *
     */
    @GET(HttpUrls.NEWS)
    Observable<BaseEntry<Result>> News (@QueryMap HashMap<String,Object> maps);

    /**
     * 检查用户
     *
     */
    @GET(HttpUrls.Cheak)
    Observable<BaseEntry<CheckUserBeen>> Check (@QueryMap HashMap<String,Object> maps);

    /**
     * 步数记录
     *
     */
    @GET(HttpUrls.Record)
    Observable<BaseEntry<RecordBeen>> Record (@QueryMap HashMap<String,Object> maps);
}
