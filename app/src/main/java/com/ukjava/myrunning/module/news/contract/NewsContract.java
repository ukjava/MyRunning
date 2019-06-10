package com.ukjava.myrunning.module.news.contract;

import com.ukjava.myrunning.http.base.BasePresenter;
import com.ukjava.myrunning.http.base.BaseView;
import com.ukjava.myrunning.module.news.bean.Result;

import java.util.HashMap;
import java.util.List;

public interface NewsContract {
    interface View extends BaseView<presenter>{
        void setNews(Result result);//数据的处理
    }

    interface presenter extends BasePresenter {
        void getNews(HashMap<String,Object> maps);//获取网络新闻
    }
}
