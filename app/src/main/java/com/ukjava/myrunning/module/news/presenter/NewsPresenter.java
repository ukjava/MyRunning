package com.ukjava.myrunning.module.news.presenter;

import android.content.Context;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.http.AddQueryParameterInterceptor;
import com.ukjava.myrunning.http.RetrofitUtil;
import com.ukjava.myrunning.http.base.BaseEntry;
import com.ukjava.myrunning.http.base.BaseObserver;
import com.ukjava.myrunning.module.news.bean.Result;
import com.ukjava.myrunning.module.news.contract.NewsContract;
import com.ukjava.myrunning.utils.CommonUtil;
import com.ukjava.myrunning.weather.bean.WeatherBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenter implements NewsContract.presenter {
    private Context mContext;
    private NewsContract.View view;

    public NewsPresenter(Context context,NewsContract.View view){
        this.mContext = context;
        this.view = view;
    }

    @Override
    public void getNews(HashMap<String, Object> maps) {
        RetrofitUtil.getInstance().initRetrofit().News(AddQueryParameterInterceptor.addParameter(mContext,maps))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Result>(mContext) {
                    @Override
                    protected void onSuccees(BaseEntry<Result> t) throws Exception {
                            view.setNews(t.getData());
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
