package com.ukjava.myrunning.utils;

import com.ukjava.myrunning.main.MyApplication;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.json.GsonImpl;

import java.security.MessageDigest;

/**
 * Description：
 * Created by xie_dingchi on 2019/3/5.
 * email:xiedingchi2008@126.com
 */
public class MD5Util {

    public static String sign(Object data) {
        /**
         * "sign":  "98aab11eec78a920ab5f2f84d56d74b6",
         * 	"token": "22222222",
         * 	"version": "1"
         *
         * 	sign 是 "data={"password":"af28be89d8cc17c981a8026da659c475","account":"test1"}&token=22222222&version=1&key=jimei"
         */
        String dataStr = GsonImpl.get().toJson(data);
        LoginBean bean = PreferenceUtil.getInstances(MyApplication.getInstance()).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
        String token = null;
        if (bean != null)
            token = bean.getToken();
        String version = Constant.commonConstants.VERSION;
        String sign = "data=" + dataStr + "&token=" + token + "&version=" + version + "&key=" + "jimei";
        return md5(sign.toLowerCase());
    }


    public static String md5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

}

