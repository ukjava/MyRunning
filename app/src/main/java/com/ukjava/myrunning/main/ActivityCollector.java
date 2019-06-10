package com.ukjava.myrunning.main;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @declare :
 * @Author : zouyi
 * @Time : 2019/3/15
 * activity的一个容器，对activity的统一管理
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity (Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities){
            if (! activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
