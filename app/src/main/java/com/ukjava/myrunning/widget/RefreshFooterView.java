package com.ukjava.myrunning.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.ukjava.myrunning.R;

/**
 * 加载更多底部view
 */

public class RefreshFooterView extends LinearLayout implements SwipeLoadMoreTrigger,SwipeTrigger {
    private TextView statusTV;
    private ImageView imageView;

    public boolean isNotMore = false;
    private String isNotMreString;

    public RefreshFooterView(Context context) {
       this(context,null,0);
    }

    public RefreshFooterView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public RefreshFooterView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {//初始化自定义view
        //动态布局添加
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = View.inflate(context, R.layout.refresh_footer_view, null);
        addView(view,lp);
        statusTV = view.findViewById(R.id.tv_loadmore_status);
        imageView = view.findViewById(R.id.iv_loadmore_success);

    }

    @Override
    public void onLoadMore() {
        if (isNotMore){
            statusTV.setText("...");
        }
        statusTV.setText("正在加载...");
    }

    @Override
    public void onPrepare() {
        statusTV.setText("上拉加载");
        imageView.setVisibility(View.GONE);
    }

    @Override
    public void onMove(int i, boolean b, boolean b1) {

    }

    @Override
    public void onRelease() {
        statusTV.setText("上拉加载");
    }

    @Override
    public void onComplete() {
        if (isNotMore && isNotMreString != null){
            statusTV.setText(isNotMreString);
            return;
        }
        statusTV.setText("加载成功！");
        imageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onReset() {
        statusTV.setText("上拉加载");
    }

    public void setNotMore(String isNotMreString,boolean isNotMore){
        this.isNotMreString = isNotMreString;
        this.isNotMore = isNotMore;
    }
}
