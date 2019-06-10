package com.ukjava.myrunning.module.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.ActionBaseActivity;
import com.ukjava.myrunning.module.news.adapter.NewsAdapter;
import com.ukjava.myrunning.module.news.bean.Result;
import com.ukjava.myrunning.module.news.contract.NewsContract;
import com.ukjava.myrunning.module.news.presenter.NewsPresenter;
import com.ukjava.myrunning.widget.RefreshFooterView;
import com.ukjava.myrunning.widget.RefreshHeaderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends ActionBaseActivity implements NewsContract.View {
    private View view;
    private NewsPresenter presenter;
    private ArrayList<Result.Too> datas = new ArrayList<>();
    private NewsAdapter adapter;
    private RecyclerView swipeTarget;
    private SwipeToLoadLayout swipeToLoadLayout;

    @Override
    protected void setBaseTitle(TextView titleView) {
        titleView.setText("新闻头条");
    }

    @Override
    protected void addContainerView(ViewGroup viewGroup, LayoutInflater inflater) {
        view = inflater.inflate(R.layout.activity_news, null);
        initview();
        viewGroup.addView(view);
    }

    private void initview() {
        swipeTarget = view.findViewById(R.id.swipe_target);
        swipeToLoadLayout = view.findViewById(R.id.swipe_to_load_layout);

        //获取头条新闻
        initNew();

        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (swipeToLoadLayout != null) {

                    HashMap<String, Object> maps = new HashMap<>();
                    maps.put("type", "top");
                    maps.put("key", "3e15b4b08395bd58fdfceeddc4c31b06");
                    //HashMap<String,Object> map = new HashMap<>();
                    //map.put("data",new JSONObject(maps));
                    presenter.getNews(maps);

                    adapter.notifyDataSetChanged();
                    swipeToLoadLayout.setRefreshing(false);
                }
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (swipeToLoadLayout != null) {
                    swipeToLoadLayout.setLoadingMore(false);
                }
            }
        });

    }

    private void initNew() {
        presenter = new NewsPresenter(this, this);
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("type", "top");
        maps.put("key", "3e15b4b08395bd58fdfceeddc4c31b06");
        //HashMap<String,Object> map = new HashMap<>();
        //map.put("data",new JSONObject(maps));
        presenter.getNews(maps);
    }

    @Override
    public void setNews(Result result) {
        datas.clear();
        datas.addAll(result.getData());

        adapter = new NewsAdapter(this, datas);
        swipeTarget.setLayoutManager(new LinearLayoutManager(this));
        swipeTarget.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
