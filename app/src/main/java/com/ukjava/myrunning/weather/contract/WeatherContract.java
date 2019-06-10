package com.ukjava.myrunning.weather.contract;

import com.ukjava.myrunning.http.base.BasePresenter;
import com.ukjava.myrunning.http.base.BaseView;
import com.ukjava.myrunning.module.news.bean.Result;
import com.ukjava.myrunning.weather.bean.WeatherBean;

import java.util.HashMap;

/**
 * 天气预报获取
 */
public interface WeatherContract {
    interface View extends BaseView<presenter>{
        void setWeather(WeatherBean weatherBean);//设置天气
    }

    interface presenter extends BasePresenter{
        void getWeather(HashMap<String, Object> maps);//获取天气

    }
}
