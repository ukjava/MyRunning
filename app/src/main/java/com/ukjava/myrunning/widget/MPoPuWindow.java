package com.ukjava.myrunning.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.ukjava.myrunning.R;

/**
 * Declare : 上传头像PopupWindow
 * Author : zouyi
 * Time : 2019/3/19
 */
public class MPoPuWindow extends PopupWindow {

    private static final String TAG = "FinishProjectPopupWindows";

    private View mView;
    public Button btnSaveProject, btnAbandonProject, btnCancelProject;

    @SuppressLint("LongLogTag")
    public MPoPuWindow(Activity context, View.OnClickListener itemsOnClick){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.activity_popu,null);
        btnSaveProject = mView.findViewById(R.id.photo_take);
        btnAbandonProject = mView.findViewById(R.id.photo_album);
        btnCancelProject = mView.findViewById(R.id.photo_cancel);

        // 设置按钮监听
        btnCancelProject.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnSaveProject.setOnClickListener(itemsOnClick);
        btnAbandonProject.setOnClickListener(itemsOnClick);

        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.popuwindow_from_bottom);
        //设置屏幕透明度
        setBackgroundAlpha(context, 0.5f);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);

    }
    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha 屏幕透明度0.0-1.0 1表示完全不透明
     */
    public static void setBackgroundAlpha(Context mContext, float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) mContext).getWindow().setAttributes(lp);
    }

}
