package com.ukjava.myrunning.weather;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends BaseActivity {

    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_today_city)
    TextView tvTodayCity;
    @BindView(R.id.tv_today_week)
    TextView tvTodayWeek;
    @BindView(R.id.tv_today_weather)
    TextView tvTodayWeather;
    @BindView(R.id.rl_weather_bg)
    RelativeLayout rlWeatherBg;
    @BindView(R.id.iv_img_bg)
    ImageView ivImgBg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        if (intent != null && !intent.equals("")) {
            String temp = intent.getStringExtra("Temp");
            String city = intent.getStringExtra("todayCity");
            String weather = intent.getStringExtra("todayWeather");
            String week = intent.getStringExtra("todayWeek");

            tvTemp.setText(temp);
            tvTodayCity.setText(city);
            tvTodayWeather.setText(weather);
            tvTodayWeek.setText(week);

            Glide.with(this).load(R.mipmap.timg).into(ivImgBg);
            //Glide.with(this).load(R.mipmap.loading).into(ivTrn);
        }
    }
}
