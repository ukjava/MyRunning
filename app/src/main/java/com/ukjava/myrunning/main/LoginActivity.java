package com.ukjava.myrunning.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONObject;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.main.contract.LoginContract;
import com.ukjava.myrunning.main.presenter.LoginPresenter;
import com.ukjava.myrunning.module.check.been.CheckUserBeen;
import com.ukjava.myrunning.module.check.been.contract.CheckContract;
import com.ukjava.myrunning.module.check.been.presenter.CheckPresenter;
import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.CommonUtil;
import com.ukjava.myrunning.utils.MD5Util;
import com.ukjava.myrunning.utils.PreferenceUtil;



import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements CheckContract.View {

    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private CheckPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new CheckPresenter(this,this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String s = etUser.getText().toString();
        String s1 = etPassword.getText().toString();

        /*HashMap<String,Object> maps = new HashMap<>();
        maps.put("username", s);
        //maps.put("password", MD5Util.md5("jimeiqwert"));
        maps.put("password", s1);
        HashMap<String,Object> map = new HashMap<>();
        map.put("data",new JSONObject(maps));
        presenter.getCheck(maps);*/

        if (s.equals("we") && s1.equals("123")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }else {
            CommonUtil.showToast("用户名或密码错误！",this);
        }


    }

    @Override
    public void setCheck(CheckUserBeen checkUserBeen) {
        Log.e("-=-=-=-==",checkUserBeen.getFlag());

        if (checkUserBeen.getFlag().equals("success")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }else {
            CommonUtil.showToast("用户名或密码错误！",this);
        }

    }

    /*@Override
    public void setLogin(LoginBean login) {
       *//* if (login != null && !TextUtils.isEmpty(login.getToken())){
            PreferenceUtil.getInstances(this).setLogin(Constant.PreferenceConstants.LOGIN_BEAN,login);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }else{
            CommonUtil.showToast("登录失败", this);
        }*//*
    }*/
}
