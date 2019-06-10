package com.ukjava.myrunning.main.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.module.settings.SettingsActivity;
import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.PreferenceUtil;
import com.ukjava.myrunning.utils.StatusBarUtils;
import com.ukjava.myrunning.utils.photo.PhoneUtils;
import com.ukjava.myrunning.widget.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MineFragment extends Fragment {

    @BindView(R.id.bt_setting)
    Button btSetting;
    @BindView(R.id.bt_message)
    Button btMessage;
    @BindView(R.id.avatar)
    CircleImageView avatar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_follow_count)
    TextView tvFollowCount;
    @BindView(R.id.topsearch)
    LinearLayout topsearch;
    @BindView(R.id.daifukuan)
    LinearLayout daifukuan;
    @BindView(R.id.daifahuo)
    LinearLayout daifahuo;
    @BindView(R.id.daishouhuo)
    LinearLayout daishouhuo;
    @BindView(R.id.yiwancheng)
    LinearLayout yiwancheng;
    @BindView(R.id.quanbudingdan)
    LinearLayout quanbudingdan;
    @BindView(R.id.table)
    LinearLayout table;
    @BindView(R.id.tv_mybalance_number)
    TextView tvMybalanceNumber;
    @BindView(R.id.ll_mybalance)
    LinearLayout llMybalance;
    @BindView(R.id.tv_csahdeposit_number)
    TextView tvCsahdepositNumber;
    @BindView(R.id.ll_cashdeposit)
    LinearLayout llCashdeposit;
    @BindView(R.id.my_follow)
    LinearLayout myFollow;
    private View view;

    private Intent intent;

    private IntentFilter intentFilter;
    private UpdateLoginReceiver loginReceiver;

    public MineFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);
        //初始控件方法
        initView();
        return view;
    }

    private void initView() {
        StatusBarUtils.getStateBar(getContext(),topsearch);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) table.getLayoutParams();
        lp.setMargins((int) getResources().getDimension(R.dimen.dp_10), -(int) getResources().getDimension(R.dimen.dp_30), (int) getResources().getDimension(R.dimen.dp_10), 0);

        LoginBean bean = PreferenceUtil.getInstances(getContext()).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
        if (bean != null){
            tvName.setText(bean.getMemberName());

            GlideApp.with(this)
                    .load(bean.getMemberPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(avatar);
        }else {
            tvName.setText("UserName");
        }

        intentFilter = new IntentFilter();
        //为过滤器添加处理规则
        intentFilter.addAction(Constant.ActionConstant.UPDATE_LOGIN_INFO);
        loginReceiver = new UpdateLoginReceiver();
        //注册广播接收器
        getActivity().registerReceiver(loginReceiver, intentFilter);
    }

    //在fragment向activity传值时需要使用onAttach方法
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //嵌套fragment时必须要重写 onDetach()
    @Override
    public void onDetach() {
        super.onDetach();
    }


    @OnClick({R.id.bt_setting, R.id.bt_message, R.id.topsearch, R.id.daifukuan, R.id.daifahuo, R.id.daishouhuo, R.id.yiwancheng, R.id.quanbudingdan, R.id.ll_mybalance, R.id.ll_cashdeposit, R.id.my_follow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_setting:
                if (PhoneUtils.isLogin(getContext())) {
                    intent = new Intent(getActivity(), SettingsActivity.class);
                    getActivity().startActivity(intent);
                }
                break;
            case R.id.bt_message:
                break;
            case R.id.topsearch:
                break;
            case R.id.daifukuan:
                break;
            case R.id.daifahuo:
                break;
            case R.id.daishouhuo:
                break;
            case R.id.yiwancheng:
                break;
            case R.id.quanbudingdan:
                break;
            case R.id.ll_mybalance:
                break;
            case R.id.ll_cashdeposit:
                break;
            case R.id.my_follow:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注销广播
        getActivity().unregisterReceiver(loginReceiver);
    }

    class UpdateLoginReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            LoginBean bean = PreferenceUtil.getInstances(getContext()).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
            if (bean != null) {
                GlideApp.with(context)
                        .load(bean.getMemberPhoto())
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .into(avatar);
                tvName.setText(bean.getMemberName());
            } else {
                avatar.setImageDrawable(getResources().getDrawable(R.mipmap.icon));
                tvName.setText("UserName");
            }
        }
    }
}
