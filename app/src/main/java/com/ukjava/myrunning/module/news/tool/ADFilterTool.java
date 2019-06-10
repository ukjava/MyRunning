package com.ukjava.myrunning.module.news.tool;


import android.content.Context;
import android.content.res.Resources;

import com.ukjava.myrunning.R;

/**
 * 判断URL是否含广告的ADFilterTool类：该类通过判断url是否包含在广告拦截库中
 */
public class ADFilterTool {
    public static boolean hasAd(Context context, String url) {
        Resources res = context.getResources();
        String[] adUrls = res.getStringArray(R.array.adBlockUrl);
        for (String adUrl : adUrls) {
            if (url.contains(adUrl)) {
                return true;
            }
        }
        return false;
    }
}