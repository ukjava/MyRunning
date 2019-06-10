package com.ukjava.myrunning.http;

public class HttpUrls {

    //---------域名------------
    public static final String baseUrl = "http://v.juhe.cn/";
    public static final String baseUrl1 = "http://192.168.191.1:8080/";


    //-----------登录接口----------------
    public static final String LOGIN = "HomeApi/login";

    //----------天气预报接口--------------
    public static final String WEATHER = "weather/index";
    //public static final String WEATHER = "192.168.191.1:8080/update74.json";

    //----------新闻头条接口--------------
    public static final String NEWS = "toutiao/index";


    //----------检查用户接口-----------
    public static final String Cheak = "app/CheckUserServlet";

    //---------获取用户跑步记录---------
    public static final String Record = "app/RecordServlet";
}
