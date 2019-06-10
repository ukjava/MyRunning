package com.ukjava.myrunning.main.fragment;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.bean.LoginBean;
import com.ukjava.myrunning.module.settings.person.activity.PersonActivity;
import com.ukjava.myrunning.service.Constant;
import com.ukjava.myrunning.utils.CheckPermission;
import com.ukjava.myrunning.utils.PreferenceUtil;
import com.ukjava.myrunning.utils.photo.CropImageUtils;
import com.ukjava.myrunning.widget.GlideApp;
import com.ukjava.myrunning.widget.MPoPuWindow;

import java.io.File;
import java.io.FileInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonFragment extends Fragment {
    @BindView(R.id.circle_image)
    CircleImageView circleImage;
    @BindView(R.id.head_portraits)
    RelativeLayout headPortraits;
    @BindView(R.id.names)
    TextView names;
    @BindView(R.id.rl_nickname)
    RelativeLayout rlNickname;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.rl_sex)
    RelativeLayout rlSex;
    @BindView(R.id.birthday)
    TextView birthday;
    @BindView(R.id.rl_birthday)
    RelativeLayout rlBirthday;
    @BindView(R.id.phone_number)
    TextView phoneNumber;
    @BindView(R.id.rl_number)
    RelativeLayout rlNumber;
    @BindView(R.id.main)
    LinearLayout main;
    @BindView(R.id.titlei)
    LinearLayout titlei;

    private View view;
    private TextView textView;
    private MPoPuWindow poPuWindow;
    private CheckPermission permission;
    private LoginBean loginBean;
    private String Sex;//性别 F=女 M=男

    public PersonFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_settings_person, container, false);
        ButterKnife.bind(this, view);
        initView();
        initDatas();
        return view;
    }

    private void initDatas() {
        loginBean = PreferenceUtil.getInstances(getActivity()).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
        if (loginBean != null) {
            GlideApp.with(getActivity())
                    .load(loginBean.getMemberPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(circleImage);
            names.setText(loginBean.getMemberName());
            sex.setText(loginBean.getSex());
            birthday.setText(loginBean.getBirthdate());
            phoneNumber.setText(loginBean.getTel());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            permission = new CheckPermission(getActivity()) {
                @Override
                public void permissionSuccess() {
                    CropImageUtils.getInstance().takePhoto(getActivity());
                }
            };
        }
    }

    private void initView() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.head_portraits, R.id.rl_nickname, R.id.rl_sex, R.id.rl_birthday, R.id.rl_number})
    public void onViewClicked(View view1) {
        switch (view1.getId()) {
            case R.id.head_portraits://修改头像
                poPuWindow = new MPoPuWindow(getActivity(),itemsOnClick);
                poPuWindow.showAtLocation(view.findViewById(R.id.main),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,0,0);
                poPuWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        poPuWindow.setBackgroundAlpha(getActivity(),1.0f);
                    }
                });
                break;
            case R.id.rl_nickname:
                final EditText inputServer = new EditText(getActivity());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.enter_nickname).setIcon(android.R.drawable.ic_dialog_info)
                        .setView(inputServer)
                        .setNegativeButton(R.string.affirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                inputServer.getText().toString();
                                if (!TextUtils.isEmpty(inputServer.getText().toString())){
                                    names.setText(inputServer.getText().toString());
                                    //textView.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                builder.show();
                break;
            case R.id.rl_sex:
                OptionPicker picker = new OptionPicker(getActivity(), new String[]{"男", "女"});
                picker.setOffset(1);
                if (!TextUtils.isEmpty(sex.getText().toString()) && !sex.getText().toString().equals("请选择")){
                    if (sex.getText().equals("女")){
                        picker.setSelectedIndex(1);
                    }else {
                        picker.setSelectedIndex(2);
                    }
                }
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(String option) {
                        sex.setText(option);
                        /*if (!option.equals(loginBean.getSex())){
                            textView.setVisibility(View.VISIBLE);
                        }*/
                    }
                });
                picker.show();
                break;
            case R.id.rl_birthday:
                //修改生日
                DatePicker pickers = new DatePicker(getActivity());
                pickers.setRange(1960,2019);//年份范围
                if (!TextUtils.isEmpty(birthday.getText().toString())){
                    String[] strings = birthday.getText().toString().split("-");
                    pickers.setSelectedItem(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]),Integer.parseInt(strings[2]));
                }
                pickers.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        String birthdate = year + "-" + month + "-" + day;
                        birthday.setText(birthdate);
                        /*if (!birthdate.equals(loginBean.getBirthdate())) {
                            textView.setVisibility(View.VISIBLE);
                        }
                        textView.setVisibility(View.VISIBLE);*/
                    }
                });
                pickers.show();
                break;
            case R.id.rl_number:
                break;
        }
    }

    /**
     * 点击修改头像回调
     */
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.photo_take://拍照
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                        //判断存储权限
                        permission.permission(CheckPermission.REQUEST_CODE_PERMISSION_CAMERA);
                    }else {
                        //打开相机
                        CropImageUtils.getInstance().takePhoto(getActivity());
                    }
                    poPuWindow.dismiss();
                    break;
                case R.id.photo_album: //打开相册
                    CropImageUtils.getInstance().openAlbum(getActivity());
                    poPuWindow.dismiss();
                    break;
                case R.id.photo_cancel://取消
                    poPuWindow.dismiss();
                    break;
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CropImageUtils.getInstance().onActivityResult(getActivity(), requestCode, resultCode, data, new CropImageUtils.OnResultListener() {
            @Override
            public void takePhotoFinish(String path) {
                //拍照回调，去裁剪
                CropImageUtils.getInstance().cropPicture(getActivity(), path);
            }

            @Override
            public void selectPictureFinish(String path) {
                //相册回调，去裁剪
                CropImageUtils.getInstance().cropPicture(getActivity(), path);
            }

            @Override
            public void cropPictureFinish(String path) {
                //裁剪回调
                try {
                    FileInputStream fis = new FileInputStream(path);
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    LoginBean loginBean = PreferenceUtil.getInstances(getActivity()).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
                    File file = new File(path);
                    /*HashMap<String, Object> map = new HashMap<>();
                    HashMap<String, Object> maps = new HashMap<>();
                    maps.put("base64String", PhotoUtil.readStream(bitmap));
                    maps.put("imgFileName", file.getName());
                    map.put("data", maps);
                    presenter.uploadHeader(map);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*@Override
    public void setUploadHeader(String MemberPhoto) {
        LoginBean loginBean = PreferenceUtil.getInstances(PersonActivity.this).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
        loginBean.setMemberPhoto(MemberPhoto);
        PreferenceUtil.getInstances(PersonActivity.this).setLogin(Constant.PreferenceConstants.LOGIN_BEAN, loginBean);
        GlideApp.with(PersonActivity.this)
                .load(MemberPhoto)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(circleImage);
        Intent intents = new Intent(Constant.ActionConstant.UPDATE_LOGIN_INFO);
        //发送更新头像 广播
        PersonActivity.this.sendBroadcast(intents);
    }

    @Override
    public void setModMember() {
        CommonUtil.showToast("修改成功", PersonActivity.this);
        LoginBean loginBean = PreferenceUtil.getInstances(PersonActivity.this).getLogin(Constant.PreferenceConstants.LOGIN_BEAN);
        loginBean.setBirthdate(birthday.getText().toString());
        loginBean.setSex(sex.getText().toString());
        loginBean.setMemberName(names.getText().toString());
        PreferenceUtil.getInstances(PersonActivity.this).setLogin(Constant.PreferenceConstants.LOGIN_BEAN, loginBean);
        textView.setVisibility(View.GONE);
    }*/
}
