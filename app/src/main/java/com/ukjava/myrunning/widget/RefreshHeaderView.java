package com.ukjava.myrunning.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.ukjava.myrunning.R;

/**
 * Created by zys on 2017/5/15.
 * 刷新头部view
 */

public class RefreshHeaderView extends LinearLayout implements SwipeRefreshTrigger, SwipeTrigger {
    ImageView imageViewRefresh;
    LinearLayout linearLayoutRefresh;
    private AnimationDrawable mAnimationDrawable;

    private int mHeaderHeight;

    public RefreshHeaderView(Context context) {
        this(context, null);
    }

    public RefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context mContext) {
        mHeaderHeight = (int) getResources().getDimension(R.dimen.dp_150);//跟刷新头布局高度一致80dp
        //动态布局添加
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = View.inflate(mContext, R.layout.refresh_header_view_shop, null);
        addView(view, lp);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imageViewRefresh = (ImageView) findViewById(R.id.image_view_refresh);
        linearLayoutRefresh = (LinearLayout) findViewById(R.id.linear_layout_refresh);
        mAnimationDrawable = (AnimationDrawable) imageViewRefresh.getBackground();
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
    }

    @Override
    public void onRefresh() {
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
    }

    @Override
    public void onPrepare() {
        linearLayoutRefresh.setAlpha(0.3f);
        imageViewRefresh.setScaleX(0.4f);
        imageViewRefresh.setScaleY(0.4f);
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
    }

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            float scale = (float) y / (float) mHeaderHeight;
            if (y >= mHeaderHeight) {
                imageViewRefresh.setScaleX(1);
                imageViewRefresh.setScaleY(1);
                linearLayoutRefresh.setAlpha(1.0f);
            } else if (y > 0 && y < mHeaderHeight) {
                imageViewRefresh.setScaleX(scale);
                imageViewRefresh.setScaleY(scale);
                linearLayoutRefresh.setAlpha(scale);
            } else {
                imageViewRefresh.setScaleX(0.4f);
                imageViewRefresh.setScaleY(0.4f);
                linearLayoutRefresh.setAlpha(0.3f);
            }
        }
    }

    @Override
    public void onRelease() {
        mAnimationDrawable.stop();
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onReset() {
        mAnimationDrawable.stop();
        linearLayoutRefresh.setAlpha(1.0f);
    }
}
