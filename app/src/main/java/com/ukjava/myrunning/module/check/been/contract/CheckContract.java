package com.ukjava.myrunning.module.check.been.contract;

import com.ukjava.myrunning.http.base.BasePresenter;
import com.ukjava.myrunning.http.base.BaseView;
import com.ukjava.myrunning.module.check.been.CheckUserBeen;

import java.util.HashMap;

public interface CheckContract {

    interface View extends BaseView<presenter>{
        void setCheck(CheckUserBeen checkUserBeen);//数据处理
    }


    interface presenter extends BasePresenter{
        void getCheck (HashMap<String,Object> maps);//获取后台检查用户
    }
}
