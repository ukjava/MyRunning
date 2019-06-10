package com.ukjava.myrunning.main.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.baidu.BaiduMapActivity;
import com.ukjava.myrunning.main.adapter.MallGoodsAdapter;
import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.CommonUtil;
import com.ukjava.myrunning.utils.PreferenceUtil;
import com.ukjava.myrunning.utils.StatusBarUtils;
import com.ukjava.myrunning.weather.OtherWeatherActivity;
import com.ukjava.myrunning.weather.bean.WeatherBean;
import com.ukjava.myrunning.weather.contract.WeatherContract;
import com.ukjava.myrunning.weather.presenter.WeatherPresenter;
import com.ukjava.myrunning.widget.RefreshFooterView;
import com.ukjava.myrunning.widget.RefreshHeaderView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MallFragment extends Fragment implements MallGoodsAdapter.OnTabSelectedListener, WeatherContract.View {

    @BindView(R.id.btn_back)
    LinearLayout btnBack;
    @BindView(R.id.ed_search)
    EditText edSearch;
    @BindView(R.id.btn_cart)
    Button btnCart;
    @BindView(R.id.btn_news)
    Button btnNews;
    @BindView(R.id.affirm_cancel)
    TextView affirmCancel;
    @BindView(R.id.topsearch)
    LinearLayout topsearch;
    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipe_load_more_footer)
    RefreshFooterView swipeLoadMoreFooter;
    @BindView(R.id.swipe_to_load_layout)
    SwipeToLoadLayout swipeToLoadLayout;
    @BindView(R.id.tb_class)
    TabLayout tbLayout;
    @BindView(R.id.content)
    LinearLayout content;
    private View view;

    private int pageIndex = 1;//默认第一页开始
    private int pageSize = 10;//默认10条一页
    private String goodClassId;
    private MallGoodsAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();

    private Intent intent;


    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;


    private IntentFilter intentFilter;
    private RefreshProductsReceiver productsReceiver;

    private WeatherPresenter presenter = null;

    public MallFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mall, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {

    }

    private void initView() {
        presenter = new WeatherPresenter(getContext(), this);

        //设置状态栏
        StatusBarUtils.getStateBar(getContext(), topsearch);
        edSearch.setCursorVisible(false);
        edSearch.setFocusable(false);
        edSearch.setFocusableInTouchMode(false);

        swipeTarget.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MallGoodsAdapter(getActivity(), this, list);
        swipeTarget.setAdapter(adapter);

        intentFilter = new IntentFilter();
        //为过滤器添加处理规则
        intentFilter.addAction(Constant.ActionConstant.REFRESH_HOMEPAGE_PRODUCTS);
        productsReceiver = new RefreshProductsReceiver();
        //注册广播接收器
        getActivity().registerReceiver(productsReceiver, intentFilter);


        //下拉刷新
        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {

                String ll = PreferenceUtil.getInstances(getContext()).getPreferenceString("censhi");
                ll.replace("市","").trim();

                if (TextUtils.isEmpty(ll) || ll == null){
                    ll = "广州";
                }

                //下拉
                //获取天气数据
                HashMap<String, Object> maps = new HashMap<>();
                maps.put("dtype", "");
                maps.put("format", 2);
                maps.put("cityname", ll);
                maps.put("key", "7489f7f128989e4fb2b68789bf4aff47");
                presenter.getWeather(maps);

                pageIndex = 1;
                if (swipeToLoadLayout != null) {
                    swipeToLoadLayout.setRefreshing(false);
                }
                //获取广告列表
                /*presenter.getAdverts();
                getGoodsClassId();*/
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageIndex++;
                if (swipeToLoadLayout != null) {
                    swipeToLoadLayout.setLoadingMore(false);
                }
                //getGoodsClassId();
            }
        });

        swipeTarget.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition(); //当前屏幕 首个 可见的 Item 的position
                if (pastVisiblesItems < 1) {
                    tbLayout.setVisibility(View.GONE);
                } else if (pastVisiblesItems == 1) {
                    tbLayout.setVisibility(View.VISIBLE);
                } else if (pastVisiblesItems > 1) {
                    tbLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mShouldScroll && RecyclerView.SCROLL_STATE_IDLE == newState) {
                    mShouldScroll = false;
                    smoothMoveToPosition(recyclerView, mToPosition);
                }
            }
        });

    }

    /**
     * 滑动到指定位置
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }


    /**
     * 加载分类标签tabs
     */
    private void initTabs() {
        tbLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.pink));
        tbLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < 2; i++) {
            TabLayout.Tab tab = tbLayout.newTab();
            tbLayout.addTab(tab);
        }
        /*for (GoodClassBean bean : good_classx) {
            TabLayout.Tab tab = tbLayout.newTab();
            tab.setText(bean.getGoodsClassName());
            tbLayout.addTab(tab);
        }*/
        /*goodClassId = good_classx.get(0).getGoodsClassId();
        getGoodsClassId();*/

        tbLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                OnTabSelected(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(productsReceiver);
    }

    /**
     * 点击tablayout条目
     *
     * @param position
     */
    @Override
    public void OnTabSelected(int position) {
        if (tbLayout.getSelectedTabPosition() != position)
            tbLayout.getTabAt(position);
        adapter.setSelect(position);
        pageIndex = 1;
        /*//根据分类id获取分类商品
        goodClassId = good_classx.get(position).getGoodsClassId();
        getGoodsClassId();*/
        if (position == 0) {
            CommonUtil.showToast("跑步按键", getActivity());
        } else {
            CommonUtil.showToast("地图按键", getActivity());
            Intent intent1 = new Intent(getActivity(), BaiduMapActivity.class);
            getActivity().startActivity(intent1);
        }
    }

    @Override
    public void setWeather(WeatherBean weatherBean) {
        list.add(weatherBean.getSk().getTemp());
        list.add(weatherBean.getToday().getCity());
        list.add(weatherBean.getToday().getDate_y());
        list.add(weatherBean.getToday().getWeather());
        list.add(weatherBean.getToday().getWeek());
        list.add(weatherBean.getToday().getExercise_index());
        list.add(weatherBean.getToday().getDressing_advice());
        adapter.notifyDataSetChanged();
        CommonUtil.showToast("天气更新成功！：" + weatherBean.getSk().getTime(), getContext());

    }

    @OnClick(R.id.ed_search)
    public void onViewClicked() {
        Intent intent1 = new Intent(getActivity(), OtherWeatherActivity.class);
        startActivity(intent1);
    }

    class RefreshProductsReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
           /* loginBean = PreferenceUtil.getInstances(context).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
            getGoodsClassId();*/
        }
    }
}
