package com.ukjava.myrunning.http.base;

/**
 * @declare : 自定义Observer（Rxjava）
 * @Author : zouyi
 * @Time : 2019/3/11
 */

//抽象类的作用 ：接口和实现分离

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Log;

import com.ukjava.myrunning.utils.ProgressDialogShow;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**抽象类定义
 * Java中可以定义没有方法体的方法，
 * 该方法由其子类来具体的实现。该没有方法体的方法我们称之为抽象方法，
 * 含有抽象方法的类我们称之为抽象类
 */

public abstract class BaseObserver<T> implements Observer<BaseEntry<T>> {
    protected Context mContext;

    public BaseObserver (Context cxt){
        this.mContext = cxt;
    }

    //开始请求
    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    //获取数据
    @Override
    public void onNext(BaseEntry<T> tBaseEntry) {
        try {
            onSuccees(tBaseEntry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //失败
    @Override
    public void onError(Throwable e) {
        onRequestEnd();
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException){
                onFailure(e, true);//是网络错误
            }else{
                onFailure(e, false);//不是网络错误
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    //结束
    @Override
    public void onComplete() {
        onRequestEnd();
    }

    /**
     * 返回成功
     * @param t
     * @throws Exception
     */
    protected abstract void onSuccees(BaseEntry<T> t)throws Exception;


    /**
     * 返回失败
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    protected abstract void onFailure(Throwable e, boolean isNetWorkError)throws Exception;

    //开始请求操作
    protected void onRequestStart() {
        //加载请求动画
        ProgressDialogShow.showProgress(mContext);
    }

    //结束请求操作
    private void onRequestEnd() {
        ProgressDialogShow.cancleProgressDialog();
    }

}
