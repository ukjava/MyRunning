package com.ukjava.myrunning.http;


import android.content.Context;
import android.text.TextUtils;

import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.MD5Util;
import com.ukjava.myrunning.utils.PreferenceUtil;

import java.util.HashMap;

/**
 * Author ：zouyi
 * Time ： 2019/3/21
 * Declare ：公共请求参数
 * 根据需要请求的情况而定
 */
public class AddQueryParameterInterceptor {
    public static HashMap<String,Object> addParameter(Context mContext, HashMap<String, Object> parameter){
        /*if (parameter !=null && parameter.containsKey("data") ){
            parameter.put("sign",MD5Util.sign(parameter.get("data")));
        }else {
            parameter.put("sign",MD5Util.sign(null));
        }
        if (PreferenceUtil.getInstances(mContext)
                .getLogin(Constant.PreferenceConstants.LOGIN_BEAN)!=null
                && !TextUtils.isEmpty(PreferenceUtil.getInstances(mContext)
                .getLogin(Constant.PreferenceConstants.LOGIN_BEAN).getToken()))

            parameter.put("token",PreferenceUtil.getInstances(mContext)
                    .getLogin(Constant.PreferenceConstants.LOGIN_BEAN).getToken());
            parameter.put("version",Constant.commonConstants.VERSION);*/
            return parameter;
    }
}
