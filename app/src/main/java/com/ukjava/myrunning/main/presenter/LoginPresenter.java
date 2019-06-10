package com.ukjava.myrunning.main.presenter;


import android.content.Context;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.http.AddQueryParameterInterceptor;
import com.ukjava.myrunning.http.RetrofitUtil;
import com.ukjava.myrunning.http.base.BaseEntry;
import com.ukjava.myrunning.http.base.BaseObserver;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.main.contract.LoginContract;
import com.ukjava.myrunning.utils.CommonUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author ：zouyi
 * Time ： 2019/3/12
 * Declare ：网络登录操作
 */
public class LoginPresenter implements LoginContract.presenter {
    private Context mContext;
    private LoginContract.View view;


    public LoginPresenter(Context context, LoginContract.View view) {
        this.mContext = context;
        this.view = view;
    }


    @Override
    public void Login(HashMap<String, Object> maps) {
        RetrofitUtil.getInstance().initRetrofit().Login(AddQueryParameterInterceptor.addParameter(mContext,maps))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<LoginBean>(mContext) {
                    @Override
                    protected void onSuccees(BaseEntry<LoginBean> t) throws Exception {
                        if (t.isSuccess()){
                            view.setLogin(t.getData());
                        }else {
                            CommonUtil.showToast(String.valueOf(t.getErrorinfo()), mContext);
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        if (isNetWorkError) {
                            CommonUtil.showToast(mContext.getResources().getString(R.string.network_error), mContext);
                        } else {
                            CommonUtil.showToast(e.getMessage(), mContext);
                        }
                    }
                });
    }
}
