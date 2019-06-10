package com.ukjava.myrunning.module.check.been.presenter;

import android.content.Context;
import android.util.Log;


import com.ukjava.myrunning.R;
import com.ukjava.myrunning.http.AddQueryParameterInterceptor;
import com.ukjava.myrunning.http.RetrofitUtil;
import com.ukjava.myrunning.http.base.BaseEntry;
import com.ukjava.myrunning.http.base.BaseObserver;
import com.ukjava.myrunning.module.check.been.CheckUserBeen;
import com.ukjava.myrunning.module.check.been.contract.CheckContract;

import com.ukjava.myrunning.utils.CommonUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CheckPresenter implements CheckContract.presenter {
    private Context mContext;
    private CheckContract.View view;

    public CheckPresenter(Context context,CheckContract.View view){
        this.mContext = context;
        this.view = view;
    }

    @Override
    public void getCheck(HashMap<String, Object> maps) {
        RetrofitUtil.getInstance().initRetrofit().Check(AddQueryParameterInterceptor.addParameter(mContext,maps))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<CheckUserBeen>(mContext) {
                    @Override
                    protected void onSuccees(BaseEntry<CheckUserBeen> t) throws Exception {
                        view.setCheck(t.getData());
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
