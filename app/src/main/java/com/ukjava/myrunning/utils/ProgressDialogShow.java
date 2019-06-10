package com.ukjava.myrunning.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.utils.animutils.AnimationsContainer;

/**
 * Copyright 2017 联合大数据有限公司.All rights reserved
 * Description：
 * create by ZYS on 17/9/15
 * Email:1026348794@qq.com
 */
public class ProgressDialogShow {
    public static Dialog loadingDialog;
    static AnimationDrawable animationDrawable;
    static AnimationsContainer.FramesSequenceAnimation animation;

    /**
     * 显示加载动画
     *
     * @param context
     * @return
     */
    public static void showProgress(Context context) {
        try {
            if (context != null) {
                if (loadingDialog == null) {
                    LayoutInflater inflater = LayoutInflater.from(context);
                    View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
                    LinearLayout layout = v.findViewById(R.id.dialog_view);// 加载布局
                    ImageView spaceshipImage = null;
                    loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
                    loadingDialog.setCancelable(false);// 不可以用“返回键”取消
                    //设置背景透明度，0~1.0  默认0.5
                    loadingDialog.getWindow().setDimAmount(0.3f);
                    loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));// 设置布局
                    spaceshipImage = v.findViewById(R.id.img);
                    animation = AnimationsContainer.getInstance(R.array.loading_anim, 15).createProgressDialogAnim(spaceshipImage);
                }
                loadingDialog.show();
//                spaceshipImage.setImageResource(R.drawable.loading_animation);
//                animationDrawable = (AnimationDrawable) spaceshipImage.getDrawable();
//                animationDrawable.start();
                animation.start();
            }
        } catch (Exception e) {
            Log.e("TAG", e.toString());
        }
    }

    /**
     * 关闭 加载动画
     *
     * @param
     */
    public static void cancleProgressDialog() {
        try {
            if (loadingDialog == null) {
                return;
            }
            if (animation == null) {
                return;
            }
            animation.stop();
            loadingDialog.dismiss();
        } catch (Exception e) {

        }
        loadingDialog = null;
        animation = null;
    }
}


