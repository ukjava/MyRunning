package com.ukjava.myrunning.main.contract;


import com.ukjava.myrunning.http.base.BasePresenter;
import com.ukjava.myrunning.http.base.BaseView;
import com.ukjava.myrunning.main.bean.LoginBean;

import java.util.HashMap;

/**
 * Author ：zouyi
 * Time ： 2019/3/12
 * Declare ：登录
 */
public interface LoginContract {
    interface View extends BaseView<presenter>{
        void setLogin(LoginBean login);  //设置banner
    }

    interface presenter extends BasePresenter{
        void Login(HashMap<String, Object> maps); //登录
    }
}
