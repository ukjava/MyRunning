package com.ukjava.myrunning.main;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.utils.CommonUtil;
import com.ukjava.myrunning.utils.StatusBarUtils;

/**
 * Declare : 不带分享的activity
 * Author : zouyi
 * Time : 2019/3/26
 */
public abstract class ActionBaseActivity extends BaseActivity {
    private LinearLayout actionbar;
    private LinearLayout btn_back;
    private RelativeLayout actionBarView;
    private LayoutInflater inflater;
    private TextView title_tv;
    private FrameLayout containerView;
    private LinearLayout add_bt_view;
    private TextView edit;
    private ImageView add;
    private ImageView search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = getLayoutInflater();
        setContentView(R.layout.activity_base);
        initViews();
    }

    private void initViews() {
        actionbar = findViewById(R.id.action_bar);
        btn_back = findViewById(R.id.ll_back);
        actionBarView = findViewById(R.id.action_bar_view);
        title_tv = findViewById(R.id.base_title_tv);
        containerView = findViewById(R.id.base_container_layout);
        add_bt_view = findViewById(R.id.add_button_layout);
        edit = findViewById(R.id.edit);
        add = findViewById(R.id.add);
        search = findViewById(R.id.search);

        //给后退按钮添加自定义回退事件
        btn_back.setOnClickListener(new BackOnClickListener());

        setBaseTitle(title_tv);
        setButton(edit, add, search);
        setActionBar(actionBarView);
        addContainerView(containerView, inflater);

        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.StatusBarLightMode(this,true);
        StatusBarUtils.getStateBar(this,actionbar);
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

    /**
     * 设置标题的方法，子类必须重写
     * @param titleView
     */
    protected abstract void setBaseTitle(TextView titleView);

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

    /**
     * 显示右上角按钮，由子activity根据具体情况重写
     */

    public void setButton(TextView edit, ImageView add, ImageView search) {
        edit.setVisibility(View.GONE);
        add.setVisibility(View.GONE);
        search.setVisibility(View.GONE);
    }

    /**
     * 设置标题栏
     *
     * @param view
     */

    public void setActionBar(RelativeLayout view) {
        view.setVisibility(View.VISIBLE);
    }

    protected abstract void addContainerView(ViewGroup viewGroup, LayoutInflater inflater);

    public void showToast(String stringRes){
        try {
            CommonUtil.showToast(stringRes,ActionBaseActivity.this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
