package com.ukjava.myrunning.step;

import android.content.Context;
import android.content.Intent;

import com.today.step.lib.BaseClickBroadcast;
import com.ukjava.myrunning.main.MainActivity;
import com.ukjava.myrunning.main.MyApplication;

public class MyReceiver extends BaseClickBroadcast {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        MyApplication myApplication = (MyApplication) context.getApplicationContext();
        if (!myApplication.isForeground()){
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }else {

        }
    }
}
