package com.ukjava.myrunning.module.Record.Presenter;

import android.content.Context;
import android.util.Log;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.http.AddQueryParameterInterceptor;
import com.ukjava.myrunning.http.RetrofitUtil;
import com.ukjava.myrunning.http.base.BaseEntry;
import com.ukjava.myrunning.http.base.BaseObserver;
import com.ukjava.myrunning.module.Record.Contract.RecordContract;
import com.ukjava.myrunning.module.Record.been.RecordBeen;
import com.ukjava.myrunning.module.news.bean.Result;
import com.ukjava.myrunning.utils.CommonUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RecordPresenter implements RecordContract.presenter {
    private Context mContext;
    private RecordContract.View view;

    public RecordPresenter(Context context,RecordContract.View view){
        this.mContext = context;
        this.view = view;
    }

    @Override
    public void getRecord(HashMap<String, Object> maps) {
        RetrofitUtil.getInstance().initRetrofit().Record(AddQueryParameterInterceptor.addParameter(mContext,maps))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<RecordBeen>(mContext) {
                    @Override
                    protected void onSuccees(BaseEntry<RecordBeen> t) throws Exception {
                        view.setRecord(t.getData());
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        if (isNetWorkError) {
                            CommonUtil.showToast(mContext.getResources().getString(R.string.network_error), mContext);
                        } else {
                            CommonUtil.showToast(e.getMessage(), mContext);
                            Log.e("-=-=-=-=-=-",e.getMessage());
                        }
                    }
                });
    }
}
