package com.ukjava.myrunning.weather.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.weather.OtherWterActivity;

import java.util.ArrayList;
import java.util.List;

public class OtherWeatherAdapter extends RecyclerView.Adapter<OtherWeatherAdapter.MyHolder> {

    private View view;
    private Context context;
    private List<String> list = new ArrayList<>();
    private String wterName;
    private OnItemClickLitener   mOnItemClickLitener;

    //设置回调接口
    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public OtherWeatherAdapter(Context context,ArrayList<String> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder( ViewGroup parent, int position) {
        view = LayoutInflater.from(context).inflate(R.layout.item_other_weather,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder( MyHolder myHolder, final int position) {
        myHolder.textView.setText(list.get(position));

        //通过为条目设置点击事件触发回调
        if (mOnItemClickLitener != null) {
            myHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickLitener.onItemClick(view, position);
                }
            });
        }

        /*wterName = list.get(position);


        myHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OtherWterActivity.class);
                intent.putExtra("wtercity",wterName);
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_cityname);
        }
    }
}
