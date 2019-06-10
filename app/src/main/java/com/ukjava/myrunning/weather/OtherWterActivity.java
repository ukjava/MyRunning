package com.ukjava.myrunning.weather;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.ActionBaseActivity;
import com.ukjava.myrunning.utils.CommonUtil;
import com.ukjava.myrunning.weather.bean.WeatherBean;
import com.ukjava.myrunning.weather.contract.WeatherContract;
import com.ukjava.myrunning.weather.presenter.WeatherPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtherWterActivity extends ActionBaseActivity implements WeatherContract.View {
    @BindView(R.id.tv_wtertemp)
    TextView tvWtertemp;
    @BindView(R.id.sk_wtertemp)
    TextView skWtertemp;
    @BindView(R.id.wtertoday_week)
    TextView wtertodayWeek;
    @BindView(R.id.wtertoday_city)
    TextView wtertodayCity;
    @BindView(R.id.wtertoday_weather)
    TextView wtertodayWeather;
    @BindView(R.id.wtertoday_data)
    TextView wtertodayData;
    @BindView(R.id.wterexercise_index)
    TextView wterexerciseIndex;
    @BindView(R.id.wtertoday_exercise)
    TextView wtertodayExercise;
    private View view;
    private WeatherPresenter presenter = null;

    @Override
    protected void setBaseTitle(TextView titleView) {
        titleView.setText("天气");
    }

    @Override
    protected void addContainerView(ViewGroup viewGroup, LayoutInflater inflater) {
        view = inflater.inflate(R.layout.activity_other_wter, null);
        viewGroup.addView(view);
        ButterKnife.bind(this, view);
        initView();
    }

    private void initView() {
        presenter = new WeatherPresenter(getBaseContext(), this);
        Intent intent = getIntent();
        String wtercity = intent.getStringExtra("wtercity");
        if (!TextUtils.isEmpty(wtercity)) {
            //获取天气数据
            HashMap<String, Object> maps = new HashMap<>();
            maps.put("dtype", "");
            maps.put("format", 2);
            maps.put("cityname", wtercity);
            maps.put("key", "7489f7f128989e4fb2b68789bf4aff47");
            presenter.getWeather(maps);

            Log.e("-=-=-=-222=-=-=-=",wtercity);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void setWeather(WeatherBean weatherBean) {
        skWtertemp.setText(weatherBean.getSk().getTemp());
        wtertodayCity.setText(weatherBean.getToday().getCity());
        wtertodayData.setText(weatherBean.getToday().getDate_y());
        wtertodayWeather.setText(weatherBean.getToday().getWeather());
        wtertodayWeek.setText(weatherBean.getToday().getWeek());

        CommonUtil.showToast("天气更新成功！：" + weatherBean.getSk().getTime(), getBaseContext());


    }
}
