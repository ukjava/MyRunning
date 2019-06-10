package com.ukjava.myrunning.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.module.news.NewsActivity;
import com.ukjava.myrunning.step.CountDownActivity;
import com.ukjava.myrunning.step.RunningRecordActivity;
import com.ukjava.myrunning.weather.WeatherActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

public class MallGoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements TabLayout.OnTabSelectedListener {

    private Context context;
    private OnTabSelectedListener mTabSelected;
    private int select;

    private ArrayList<String> good_classx = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    //头部banner
    private int TYPE_HEADER = 1001;
    //中间的table
    private int TYPE_SENTRE = 1002;



    public MallGoodsAdapter(Context context,
                            OnTabSelectedListener mTabSelected,
                            ArrayList<String> list
                           ) {
        this.context = context;
        this.mTabSelected = mTabSelected;
        this.list = list;

        good_classx.add("跑步");
        good_classx.add("地图");
    }

    //taclass选中的位置
    public void setSelect(int select) {
        this.select = select;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View headerView = LayoutInflater.from(context).inflate(R.layout.mall_header_view, parent, false);
            return new HeaderViewHolder(headerView);
        } else if (viewType == TYPE_SENTRE) {
            View headerView = LayoutInflater.from(context).inflate(R.layout.mall_centre_view, parent, false);
            return new CentreViewHolder(headerView);
        } else {
            View v = LayoutInflater.from(context).inflate(R.layout.item_mall_goods, parent, false);
            return new MyHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder) {
            //跑步按钮
            ((MyHolder) holder).stepArrayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 跳转到跑步页面
                    Intent intent = new Intent(context, CountDownActivity.class);
                    context.startActivity(intent);
                }
            });

        } else if (holder instanceof HeaderViewHolder) {
            //头布局
                    if (list.size()>0 && list != null){
                        ((HeaderViewHolder) holder).skTemp.setText(list.get(0));
                        ((HeaderViewHolder) holder).todayCity.setText(list.get(1));
                        ((HeaderViewHolder) holder).todayData.setText(list.get(2));
                        ((HeaderViewHolder) holder).todayWeather.setText(list.get(3));
                        ((HeaderViewHolder) holder).todayWeek.setText(list.get(4));
                        ((HeaderViewHolder) holder).today_exercise.setText(list.get(5));
                    }
                    ((HeaderViewHolder) holder).banner.setOnClickListener(new View.OnClickListener() {
                        @Override public void onClick(View view) {
                            Intent intent = new Intent(context, WeatherActivity.class);
                            intent.putExtra("Temp",((HeaderViewHolder) holder).skTemp.getText().toString());
                            intent.putExtra("todayCity",((HeaderViewHolder) holder).todayCity.getText().toString());
                            intent.putExtra("todayWeather",((HeaderViewHolder) holder).todayWeather.getText().toString());
                            intent.putExtra("todayWeek",((HeaderViewHolder) holder).todayWeek.getText().toString());
                            context.startActivity(intent);
                            }}
                    );

        } else if (holder instanceof CentreViewHolder) {
            //中间TabLayout布局
            ((CentreViewHolder) holder).tbClass.setSelectedTabIndicatorColor(context.getResources().getColor(R.color.pink));
            ((CentreViewHolder) holder).tbClass.setTabMode(TabLayout.MODE_SCROLLABLE);
            if (good_classx != null && good_classx.size() > 0) {
                for (int i = 0; i < good_classx.size(); i++) {
                    if (((CentreViewHolder) holder).tbClass.getTabAt(i) != null) {
                        if (!((CentreViewHolder) holder).tbClass.getTabAt(i).getText().toString()
                                .equals(good_classx.get(i))) {
                            TabLayout.Tab tab = ((CentreViewHolder) holder).tbClass.newTab();
                            tab.setText(good_classx.get(i));
                            ((CentreViewHolder) holder).tbClass.addTab(tab);
                        }
                    } else {
                        TabLayout.Tab tab = ((CentreViewHolder) holder).tbClass.newTab();
                        tab.setText(good_classx.get(i));
                        ((CentreViewHolder) holder).tbClass.addTab(tab);
                    }
                }
            }

            ((CentreViewHolder) holder).tbClass.addOnTabSelectedListener(this);
            Log.e("TAG", select + "");
            if (((CentreViewHolder) holder).tbClass.getTabCount() > 0) {
                if (((CentreViewHolder) holder).tbClass.getSelectedTabPosition() != select)
                    ((CentreViewHolder) holder).tbClass.getTabAt(select).select();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == 1) {
            return TYPE_SENTRE;
        }

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (mTabSelected != null)
            mTabSelected.OnTabSelected(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    //自定义接口
    public interface OnTabSelectedListener {
        void OnTabSelected(int position);
    }


    class MyHolder extends RecyclerView.ViewHolder {
        Button stepArrayButton;

        public MyHolder(View itemView) {
            super(itemView);
            stepArrayButton = itemView.findViewById(R.id.stepArrayButton);
        }
    }

    /**
     * 头布局的viewholder
     */
    class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.banner)
        Banner banner;
        @BindView(R.id.vvp_main_video1)
        JZVideoPlayerStandard vvpMainVideo1;
        @BindView(R.id.fl_banner)
        FrameLayout flBanner;
        @BindView(R.id.new_products)
        LinearLayout newProducts;
        @BindView(R.id.selling_goods)
        LinearLayout sellingGoods;
        @BindView(R.id.jimei_headlines)
        LinearLayout jimeiHeadlines;

        @BindView(R.id.sk_temp)
        TextView skTemp;
        @BindView(R.id.today_week)
        TextView todayWeek;
        @BindView(R.id.today_city)
        TextView todayCity;
        @BindView(R.id.today_weather)
        TextView todayWeather;
        @BindView(R.id.today_data)
        TextView todayData;
        @BindView(R.id.today_exercise)
        TextView today_exercise;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            newProducts.setOnClickListener(this);
            sellingGoods.setOnClickListener(this);
            jimeiHeadlines.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.jimei_headlines:
                       //跳转页面
                    Intent intent = new Intent(context, NewsActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.new_products:
                    /*Intent intent1 = new Intent(context, NewProductSellingActivity.class);
                    intent1.putExtra("type", "1");
                    context.startActivity(intent1);*/
                    //跳转页面
                    Intent intent1 = new Intent(context, RunningRecordActivity.class);
                    context.startActivity(intent1);
                    break;
                case R.id.selling_goods:
                    /*Intent intent2 = new Intent(context, NewProductSellingActivity.class);
                    intent2.putExtra("type", "2");
                    context.startActivity(intent2);*/
                    //跳转页面
                    Intent intent2 = new Intent(context, NewsActivity.class);
                    context.startActivity(intent2);
                    break;
            }
        }

    }

    class CentreViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tb_class)
        TabLayout tbClass;

        public CentreViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }


}
