package com.ukjava.myrunning.module.Record.Contract;

import com.ukjava.myrunning.http.base.BasePresenter;
import com.ukjava.myrunning.http.base.BaseView;
import com.ukjava.myrunning.module.Record.been.RecordBeen;

import java.util.HashMap;

public interface RecordContract {

    interface View extends BaseView<presenter>{
        void setRecord (RecordBeen recordBeen);//数据处理
    }

    interface presenter extends BasePresenter{
        void getRecord (HashMap<String,Object> maps);//获取后台步数记录
    }
}
