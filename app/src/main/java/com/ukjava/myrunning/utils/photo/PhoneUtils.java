package com.ukjava.myrunning.utils.photo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import com.ukjava.myrunning.main.LoginActivity;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.CommonUtil;
import com.ukjava.myrunning.utils.PreferenceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author ：zouyi
 * Time ： 2019/3/19
 * Declare ：手机各类工具方法
 */

public class PhoneUtils {
    //手机号验证正则
    private static String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    public static final String getVersions(Context mContext) {
        String versionName = null;
        try {
            PackageManager pm = mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return "V" + versionName;
    }


    /**
     * 获取状态栏高度
     *
     * @param mContext
     * @return
     */
    public static int getPixelSize(Context mContext) {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 验证手机号是否正确
     *
     * @param phoneNumber
     * @return
     */
    public static Boolean verifyPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    /**
     * 判断是否登录
     *
     * @param mContext
     * @return
     */
    public static Boolean isLogin(Context mContext) {
        LoginBean loginBean = PreferenceUtil.getInstances(mContext).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
        if (loginBean != null) {
            if (!TextUtils.isEmpty(loginBean.getToken())) {
                return true;
            } else {
                CommonUtil.showToast("请登录", mContext);
                Intent intent = new Intent(mContext, LoginActivity.class);
                mContext.startActivity(intent);
                //return false;
                return true;
            }
        } else {
            CommonUtil.showToast("请登录", mContext);
            Intent intent = new Intent(mContext, LoginActivity.class);
            mContext.startActivity(intent);
            //return false;
            return true;
        }
    }
}

