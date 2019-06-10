package com.ukjava.myrunning.module.adverts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.BaseActivity;

public class ImageActivity extends BaseActivity {
    private ImageView img;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initview();
    }

    private void initview() {
        img = findViewById(R.id.iv_img);

        Intent intent = getIntent();
        String dizhi = intent.getStringExtra("dizhi");
        if (!TextUtils.isEmpty(dizhi)){

            Glide.with(getBaseContext()).load(dizhi).into(img);
        }

    }
}
