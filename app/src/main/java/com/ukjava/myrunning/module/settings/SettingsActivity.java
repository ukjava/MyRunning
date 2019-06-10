package com.ukjava.myrunning.module.settings;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.ActionBaseActivity;
import com.ukjava.myrunning.main.LoginActivity;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.module.settings.person.activity.PersonActivity;
import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.PreferenceUtil;
import com.ukjava.myrunning.utils.photo.PhoneUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends ActionBaseActivity {

    @BindView(R.id.rl_settings_person)
    RelativeLayout rlSettingsPerson;
    @BindView(R.id.phone_number)
    TextView phoneNumber;
    @BindView(R.id.rl_settings_number)
    RelativeLayout rlSettingsNumber;
    @BindView(R.id.rl_settings_login_password)
    RelativeLayout rlSettingsLoginPassword;
    @BindView(R.id.rl_settings_pay_password)
    RelativeLayout rlSettingsPayPassword;
    @BindView(R.id.rl_settings_shipping_address)
    RelativeLayout rlSettingsShippingAddress;
    @BindView(R.id.rl_settings_Feedback)
    RelativeLayout rlSettingsFeedback;
    @BindView(R.id.rl_settings_about)
    RelativeLayout rlSettingsAbout;
    @BindView(R.id.versions)
    TextView versions;
    @BindView(R.id.rl_settings_version)
    RelativeLayout rlSettingsVersion;
    @BindView(R.id.btn_back)
    Button btnBack;
    private View view;
    private Intent intent;

    @Override
    protected void setBaseTitle(TextView titleView) {
        titleView.setText(R.string.settings);
    }

    @Override
    protected void addContainerView(ViewGroup viewGroup, LayoutInflater inflater) {
        view = inflater.inflate(R.layout.activity_settings, null);
        viewGroup.addView(view);
        ButterKnife.bind(this, view);
        initDatas();
    }

    private void initDatas() {
        LoginBean loginBean = PreferenceUtil.getInstances(SettingsActivity.this).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
        if (loginBean != null && !TextUtils.isEmpty(loginBean.getTel())) {
            String tel = loginBean.getTel().substring(0, 3) + "****" + loginBean.getTel().substring(7, 11);
            phoneNumber.setText(tel);
        }

        versions.setText(PhoneUtils.getVersions(SettingsActivity.this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_settings_person, R.id.phone_number, R.id.rl_settings_number, R.id.rl_settings_login_password, R.id.rl_settings_pay_password, R.id.rl_settings_shipping_address, R.id.rl_settings_Feedback, R.id.rl_settings_about, R.id.versions,R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_settings_person:
                intent = new Intent(SettingsActivity.this, PersonActivity.class);
                SettingsActivity.this.startActivity(intent);
                break;
            case R.id.phone_number:
                break;
            case R.id.rl_settings_number:
                break;
            case R.id.rl_settings_login_password:
                break;
            case R.id.rl_settings_pay_password:
                break;
            case R.id.rl_settings_shipping_address:
                break;
            case R.id.rl_settings_Feedback:
                break;
            case R.id.rl_settings_about:
                break;
            case R.id.versions:
                break;
            case R.id.btn_back:
                SettingsActivity.this.finish();
                intent = new Intent(SettingsActivity.this, LoginActivity.class);
               SettingsActivity.this.startActivity(intent);
                break;
        }
    }
}
