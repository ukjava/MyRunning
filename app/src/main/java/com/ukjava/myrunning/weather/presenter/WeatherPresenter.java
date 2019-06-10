package com.ukjava.myrunning.weather.presenter;

import android.content.Context;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.http.AddQueryParameterInterceptor;
import com.ukjava.myrunning.http.RetrofitUtil;
import com.ukjava.myrunning.http.base.BaseEntry;
import com.ukjava.myrunning.http.base.BaseObserver;
import com.ukjava.myrunning.module.news.bean.Result;
import com.ukjava.myrunning.utils.CommonUtil;
import com.ukjava.myrunning.weather.bean.WeatherBean;
import com.ukjava.myrunning.weather.contract.WeatherContract;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 网络获取天气操作
 */
public class WeatherPresenter implements WeatherContract.presenter {
    private Context mContext;
    private WeatherContract.View view;

    public WeatherPresenter(Context context,WeatherContract.View view){
        this.mContext = context;
        this.view = view;
    }


    @Override
    public void getWeather(HashMap<String, Object> maps) {
        RetrofitUtil.getInstance().initRetrofit().Weather(AddQueryParameterInterceptor.addParameter(mContext,maps))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<WeatherBean>(mContext) {
                    @Override
                    protected void onSuccees(BaseEntry<WeatherBean> t) throws Exception {
                        if (t.isSuccess()){
                            view.setWeather(t.getData());
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
