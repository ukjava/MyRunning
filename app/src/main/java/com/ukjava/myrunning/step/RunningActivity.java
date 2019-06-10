package com.ukjava.myrunning.step;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.today.step.lib.ISportStepInterface;
import com.today.step.lib.TodayStepManager;
import com.today.step.lib.TodayStepService;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.BaseActivity;
import com.ukjava.myrunning.main.MyApplication;
import com.ukjava.myrunning.utils.PreferenceUtil;

public class RunningActivity extends BaseActivity {
    //计步操作
    private static String TAG = "MainActivity";

    private static final int REFRESH_STEP_WHAT = 0;
    //循环取当前时刻的步数中间的间隔时间
    private long TIME_INTERVAL_REFRESH = 3000;

    private Handler mDelayHandler = new Handler(new TodayStepCounterCall());
    private int mStepSum;

    private ISportStepInterface iSportStepInterface;

    private Button run_finish;
    private TextView timeTextView,stepTextView,step_km,step_sur;

    private String distance = "0",calorie = "0" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
        initView();
    }

    private void initView() {
        //初始化计步模块
        TodayStepManager.startTodayStepService(MyApplication.getInstance());

        timeTextView = findViewById(R.id.timeTextView);
        stepTextView = findViewById(R.id.stepTextView);
        step_km = findViewById(R.id.step_km);
        step_sur = findViewById(R.id.step_sur);
        run_finish = findViewById(R.id.run_finish);

        //开启计步Service，同时绑定Activity进行aidl通信
        final Intent intent = new Intent(this, TodayStepService.class);
        startService(intent);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                //Activity和Service通过aidl进行通信
                iSportStepInterface = ISportStepInterface.Stub.asInterface(service);

                try {
                    mStepSum = iSportStepInterface.getCurrentTimeSportStep();

                    //保存当前的步数，方便清零
                    PreferenceUtil.getInstances(getBaseContext()).savePreferenceString("mStepSum", String.valueOf(mStepSum));

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT, TIME_INTERVAL_REFRESH);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        },Context.BIND_AUTO_CREATE);

        //计时器
        mhandmhandlele.post(timeRunable);

       run_finish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
               Intent intent1 = new Intent(getApplicationContext(), StepFinishActivity.class);
               intent1.putExtra("step",stepTextView.getText().toString());
               intent1.putExtra("distance",distance);
               intent1.putExtra("calorie",calorie);
               intent1.putExtra("time",timeTextView.getText().toString());

               getApplicationContext().startActivity(intent1);
           }
       });
    }

    class TodayStepCounterCall implements Handler.Callback{

        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case REFRESH_STEP_WHAT:
                    //每隔500毫秒获取一次计步数据刷新UI
                    if (null != iSportStepInterface){
                        int step = 0;
                        try {
                            step = iSportStepInterface.getCurrentTimeSportStep();

                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        if (mStepSum != step){
                            mStepSum = step;

                            //获取存储的步数
                            String lo = PreferenceUtil.getInstances(getBaseContext())
                                    .getPreferenceString("mStepSum");

                            if (!TextUtils.isEmpty(lo)){
                               mStepSum =  step - Integer.parseInt(lo);
                            }

                            distance = getDistanceByStep(mStepSum);//计算公里数
                            calorie = getCalorieByStep(mStepSum);//千卡路里计算

                            updateStepCount();//更新步数
                        }
                    }
                    mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT,TIME_INTERVAL_REFRESH);
                    break;
            }

            return false;
        }
    }

    //更新步数
    private void updateStepCount() {
        Log.e(TAG, "updateStepCount : " + mStepSum);
        stepTextView.setText(mStepSum + " 步");

        step_km.setText(distance);
        step_sur.setText(calorie);
    }

    /*****************计时器*******************/
    private Runnable timeRunable = new Runnable() {
        @Override
        public void run() {

            currentSecond = currentSecond + 1000;
            timeTextView.setText(getFormatHMS(currentSecond));
            if (!isPause) {
                //递归调用本runable对象，实现每隔一秒一次执行任务
                mhandmhandlele.postDelayed(this, 1000);
            }
        }
    };
    //计时器
    private Handler mhandmhandlele = new Handler();
    private boolean isPause = false;//是否暂停
    private long currentSecond = 0;//当前毫秒数

    /*****************计时器*******************/
    /**
     * 根据毫秒返回时分秒
     *
     * @param
     * @return
     */
    public static String getFormatHMS(long time) {
        time = time / 1000;//总秒数
        int s = (int) (time % 60);//秒
        int m = (int) (time / 60);//分
        int h = (int) (time / 3600);//秒
        return String.format("%02d:%02d:%02d", h, m, s);
    }


    // 公里计算公式
    static String getDistanceByStep(long steps) {
        return String.format("%.2f", steps * 0.6f / 1000);
    }

    // 千卡路里计算公式
    static String getCalorieByStep(long steps) {
        return String.format("%.1f", steps * 0.6f * 60 * 1.036f / 1000);
    }
}
