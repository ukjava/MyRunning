package com.ukjava.myrunning.module.news;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.BaseActivity;
import com.ukjava.myrunning.module.news.tool.ADFilterTool;

public class NewsDetailActivity extends BaseActivity {
    private WebView wb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        wb = findViewById(R.id.wv_news);
        Intent intent = getIntent();
        String url = intent.getStringExtra("news");
        if (url != null && !url.equals("")){
            wb.loadUrl(url);//加载url

            wb.addJavascriptInterface(this,"android");//添加js监听 这样html就能调用客户端
            wb.setWebChromeClient(webChromeClient);
            wb.setWebViewClient(webViewClient);

            WebSettings webSettings = wb.getSettings();

            webSettings.setJavaScriptEnabled(true);//允许使用js

            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//不使用缓存，只从网络获取数据.

            //支持屏幕缩放
            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);

            //不显示webview缩放按钮
            webSettings.setDisplayZoomControls(false);
        }
    }
    //WebViewClient主要帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient= new WebViewClient(){
        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            super.onPageFinished(view, url);

        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            url = url.toLowerCase();
            if (!ADFilterTool.hasAd(getBaseContext(), url)) {
                return super.shouldInterceptRequest(view, url);//正常加载
            }else{
                return new WebResourceResponse(null,null,null);//含有广告资源屏蔽请求
            }
        }
    };

    //WebChromeClient主要辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
    private WebChromeClient webChromeClient=new WebChromeClient(){

        //获取网页标题
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wb.destroy();
    }
}
