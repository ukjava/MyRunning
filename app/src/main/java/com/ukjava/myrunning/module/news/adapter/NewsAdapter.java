package com.ukjava.myrunning.module.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.module.news.NewsDetailActivity;
import com.ukjava.myrunning.module.news.bean.Result;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder> {


    private View view;
    private Context context;
    private ArrayList<Result.Too> datas;

    public NewsAdapter(Context context, ArrayList<Result.Too> data) {
        this.context = context;
        this.datas = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        view = LayoutInflater.from(context).inflate(R.layout.activity_new_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
            holder.tvTitle.setText(datas.get(position).getTitle());
            holder.tvAuthorName.setText(datas.get(position).getAuthor_name());
        Glide.with(context).load(datas.get(position).getThumbnail_pic_s())
                .into(holder.tvThumbnailPicS);
        Glide.with(context).load(datas.get(position).getThumbnail_pic_s02())
                .into(holder.ivThumbnailPicS02);
        Glide.with(context).load(datas.get(position).getThumbnail_pic_s03())
                .into(holder.ivThumbnailPicS03);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("news",datas.get(position).getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_thumbnail_pic_s)
        ImageView tvThumbnailPicS;
        @BindView(R.id.iv_thumbnail_pic_s02)
        ImageView ivThumbnailPicS02;
        @BindView(R.id.iv_thumbnail_pic_s03)
        ImageView ivThumbnailPicS03;
        @BindView(R.id.ll_mags)
        LinearLayout llMags;
        @BindView(R.id.tv_author_name)
        TextView tvAuthorName;
        @BindView(R.id.rl_news)
        RelativeLayout rlNews;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
