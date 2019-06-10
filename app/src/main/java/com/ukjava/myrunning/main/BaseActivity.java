package com.ukjava.myrunning.main;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import com.example.swipebackactivity.SwipeBackLayout;
import com.example.swipebackactivity.Utils;
import com.example.swipebackactivity.app.SwipeBackActivityBase;
import com.example.swipebackactivity.app.SwipeBackActivityHelper;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.utils.StatusBarUtils;


/**
 * activity的基类
 */
public class BaseActivity extends AppCompatActivity implements SwipeBackActivityBase,SwipeBackLayout.FinishActivityListener {
    //侧滑退出工具
    private SwipeBackActivityHelper mHelper;
    private static Resources mResources;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResources = getResources();
        RelativeLayout topHeand = this.findViewById(R.id.topHeand);
        if (topHeand != null){
            StatusBarUtils.getStateBar(this,topHeand);
        }
        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.StatusBarLightMode(this,true);

        //侧滑关闭，如果可以侧滑就关闭
        if (enableSliding()){
            mHelper = new SwipeBackActivityHelper(this);
            mHelper.onActivityCreate();
        }

        //将Activity放入一个容器内，对activity进行统一的管理
            ActivityCollector.addActivity(this);
    }

    public String getResString(int id){
        return mResources.getString(id);
    }

    public int getResColor(int id){
        return mResources.getColor(id);
    }

    //判断是否可侧滑
    protected boolean enableSliding() {
        //MainActivity,VideoActivity侧滑关闭不生效
            if (getClass().getSimpleName().equals("MainActivity")
                    || getClass().getSimpleName().equals("VideoActivity")){
                return false;
            }else {
                return true;
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    //Activity彻底运行起来之后的回调方法
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (enableSliding()){
            mHelper.onPostCreate();
            getSwipeBackLayout().setOnFinishActivityListener(this);
        }
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

    @Override
    public void dothingBeforeFinish() {

    }
}
