package com.ukjava.myrunning.main;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.utils.StatusBarUtils;

/**
 * Declare : 带分享的action
 * Author : zouyi
 * Time : 2019/3/26
 */
public abstract class ActionBarBaseActivity extends BaseActivity{
    LinearLayout btnBack;
    TextView title;
    LinearLayout btnShare;
    RelativeLayout topHeand;
    FrameLayout baseContainerLayout;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_base);
        initViews();
    }

    private void initViews() {
        inflater = getLayoutInflater();

        btnBack = this.findViewById(R.id.btn_back);
        title = this.findViewById(R.id.headline);
        btnShare = this.findViewById(R.id.btn_share);
        topHeand = this.findViewById(R.id.topHeand);
        baseContainerLayout = this.findViewById(R.id.base_container_layout);

        //给控件设置对应自定义监听
        btnBack.setOnClickListener(new BackOnClickListener());
        btnShare.setOnClickListener(new ShareOnClickListener());

        addContainerView(baseContainerLayout, inflater);//子类必须添加的布局

        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.StatusBarLightMode(this,true);
        StatusBarUtils.getStateBar(this,topHeand);
    }

    /**
     * 设置标题
     */
    protected void setBaseTitle(String titles){
        title.setText(titles);
    }

    /**
     * 设置布局
     * @param viewGroup
     * @param inflater
     */
    protected abstract void addContainerView(ViewGroup viewGroup, LayoutInflater inflater);

    //自定义一个后退的接口，实现后退方法
    class BackOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            back();
        }
    }

    /**
     * 后退功能，子类可以重写,
     * 如退出定位、销毁实例等，也可以什么都不做
     */
    protected void back() {
        this.finish();
    }


    class ShareOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            share();
        }
    }

    /**
     * 分享
     */
    protected void share() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
            getResources();//设置字体不随系统改变
        super.onConfigurationChanged(newConfig);
    }

    //重写getResources()方法，设置字体不随系统改变
    @Override
    public Resources getResources() {
        Resources res =  super.getResources();
        if (res.getConfiguration().fontScale != 1){//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();
            res.updateConfiguration(newConfig,res.getDisplayMetrics());
        }
        return res;
    }
}
