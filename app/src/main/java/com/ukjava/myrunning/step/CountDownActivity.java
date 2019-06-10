package com.ukjava.myrunning.step;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.step.view.CountDownView;

public class CountDownActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        CountDownView cdv = findViewById(R.id.tv_red_skip);
        cdv.setAddCountDownListener(new CountDownView.OnCountDownFinishListener() {
            @Override
            public void countDownFinished() {
                //倒数完后干的事
                finish();
                Intent intent = new Intent(getApplicationContext(), RunningActivity.class);
                startActivity(intent);
            }
        });
        cdv.startCountDown();
    }
}
