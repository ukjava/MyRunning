package com.ukjava.myrunning.weather;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.ActionBaseActivity;
import com.ukjava.myrunning.weather.adapter.OtherWeatherAdapter;

import java.util.ArrayList;

public class OtherWeatherActivity extends ActionBaseActivity {
    private View view;
    private ArrayList<String> list = new ArrayList<>();
    private OtherWeatherAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void setBaseTitle(TextView titleView) {
        titleView.setText("城市天气");
    }

    @Override
    protected void addContainerView(ViewGroup viewGroup, LayoutInflater inflater) {
            view = inflater.inflate(R.layout.activity_other_weather,null);
            viewGroup.addView(view);
            initView();
            initData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rl_other_weather);
    }

    private void initData() {
        list.add("北京");
        list.add("上海");
        list.add("深圳");
        list.add("武汉");
        adapter = new OtherWeatherAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickLitener(new OtherWeatherAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getBaseContext(), OtherWterActivity.class);
                intent.putExtra("wtercity",list.get(position));
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list.clear();
    }
}
