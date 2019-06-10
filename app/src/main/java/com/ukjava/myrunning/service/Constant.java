package com.ukjava.myrunning.service;

public class Constant {
    //action 广播标志类
    public class ActionConstant {
        public static final String ACTION_GET_MESSAGE_INFO_SUCCESS = "action_get_message_info_success";//获取消息成功

        public static final String UPDATE_LOGIN_INFO = "update_login_info";//上传头像成功   更新信息

        public static final String UPDATE_MY_ORDER = "UPDATE_MY_ORDER";//订单支付成功    更新我的订单

        public static final String RETURN_TO_THE_HOME_PAGE = "RETURN_TO_THE_HOME_PAGE";//订单支付成功    返回首页

        public static final String REFRESH_HOMEPAGE_PRODUCTS = "REFRESH_HOMEPAGE_PRODUCTS";//当重新登录或者退出登录   重新刷新首页的商品
    }

    //传值常量类
    public class BundleConstant {
        public static final String BUNDLE_GET_MESSAGE_INFO = "bundle_get_message_info";//消息信息
        public static final String BUNDLE_GET_UPDATE_INFO = "bundle_get_message_info";//更新信息

    }

    //保存常量类
    public class PreferenceConstants {
        public static final String APK_NAME = "my.apk";//保存的apk名称
        public static final String LOGIN_BEAN = "login";//保存登录数据
    }

    //订单类型字典项
    public class OrderTypeDic {
        //普通订单
        public static final String Common = "c621a076e3274433b9b4c958971b62d6";

        //拍卖订单
        public static final String Auction = "6dc5bca403af43a28b2edbc320402ae8";

        //安卓   订单来源字典项
        public static final String Android = "d8ed274e3c0247c2b97eb45d0e59f9db";
    }

    public class OrderStatusDic {
        //待支付
        public static final String UnPaid = "5337434db0ca4a2192c52492d3c941c3";
        //待发货
        public static final String UnDeliver = "413843e9f9344990a4f66049a5ec5d27";
        //待收货
        public static final String UnReceipt = "c44d399a8ac44d61b6e1223523fa9a6e";
        //已收货
        public static final String HasReceipted = "6543d96ae3924ce5b638efd57796dfdd";
        //已取消
        public static final String HasCancelled = "e646e625128d403086ead89f94a310e0";
    }

    //支付方式字典
    public class PayMethodDic {
        //货到付款
        public static final String Cash = "c621a076e3274433b9b4c958971b62d6";
        //支付宝付款
        public static final String AliPay = "0f6bfbe894e647dd9ba0c774a6342ea0";
        //微信支付
        public static final String WechatPay = "0457ae23d7fa4a63bdc59fd5f10f7382";
    }

    //普通常量类
    public static class commonConstants {
        public static final String VERSION = "1";//版本号，服务器用来区分

        //商品详情
        public static final String GoodsDetail = "cf6be687d0fd454ba4c51f241f627812";
        //商品列表
        public static final String GoodsList = "957c31d2ea3b41cf920f649027e65f78";
        //文章详情
        public static final String ArticleDetail = "c1c17e4c881642cdbee0e097489807e8";
        //文章列表
        public static final String ArticleList = "835f95627b364139b1d7ab40a19d620f";
        //视频
        public static final String Video = "1094e22774c441d1890c17fdc8e20e04";
    }


}
