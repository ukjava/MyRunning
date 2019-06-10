package com.ukjava.myrunning.step;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.BaseActivity;
import com.ukjava.myrunning.main.MainActivity;
import com.ukjava.myrunning.utils.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StepFinishActivity extends BaseActivity {
    @BindView(R.id.finish_km)
    TextView finishKm;
    @BindView(R.id.finish_allstep)
    TextView finish_allstep;
    @BindView(R.id.finish_time)
    TextView finishTime;
    @BindView(R.id.finish_sur)
    TextView finishSur;
    @BindView(R.id.btn_return)
    Button btnReturn;
    @BindView(R.id.iv_record)
    ImageView ivRecord;
    @BindView(R.id.rl_bg)
    RelativeLayout rlBg;
    @BindView(R.id.tv_ff)
    TextView tvFf;
    @BindView(R.id.tv_ll)
    TextView tvLl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_finish);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        if (intent != null && !intent.equals("")) {
            String step = intent.getStringExtra("step");
            String distance = intent.getStringExtra("distance");
            String calorie = intent.getStringExtra("calorie");
            String time = intent.getStringExtra("time");


            finishKm.setText(distance);
            finish_allstep.setText(step);
            finishSur.setText(calorie);
            finishTime.setText(time);

        }
    }

    @OnClick({R.id.iv_record, R.id.btn_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_record:
                Intent intent1 = new Intent(getApplicationContext(), RunningRecordActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_return:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
