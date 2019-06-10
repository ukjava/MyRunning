package com.ukjava.myrunning.main.adapter;

import android.app.Service;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.bean.NineGridTestModel;
import com.ukjava.myrunning.main.view.NineGridTestLayout;

import java.util.List;

public class NineGridTest2Adapter extends RecyclerView.Adapter<NineGridTest2Adapter.ViewHolder> {

    private Context mContext;
    private List<NineGridTestModel> mList;
    protected LayoutInflater inflater;
    private PopupWindow popWindow = null;
    private String ey = "hhh";
    private Button button;
    private EditText text;

    public NineGridTest2Adapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<NineGridTestModel> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = inflater.inflate(R.layout.fragment_sale_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.layout.setIsShowAll(mList.get(position).isShowAll);
        holder.layout.setUrlList(mList.get(position).urlList);



        //点击评论控件
        holder.ping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(holder.ping);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!ey.equals("hhh") && !ey.equals("")){
                            holder.textView.setText(ey);
                            holder.linearLayout.setVisibility(View.VISIBLE);
                        }else {
                            holder.linearLayout.setVisibility(View.GONE);
                        }
                        InputMethodManager imm = (InputMethodManager) holder.textView.getContext().getSystemService(Service.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                },0);
            }
        });



    }

    private void showPopup(View parent) {
        if(popWindow==null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.topic_popup_comext,null);
            button = view.findViewById(R.id.topic_comment_bt_send);
            text = view.findViewById(R.id.topic_comment_et_content);
            popWindow  = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,150,true);
        }
        popWindow.setFocusable(true);
        popWindow.setOutsideTouchable(false);//在外点击消失
        popWindow.setBackgroundDrawable(new BitmapDrawable());//设置背景，点击返回也能使其消失，并且不影响背景
//        popWindow.setInputMethodMode(popWindow.INPUT_METHOD_NEEDED);
        popWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);//软键盘不会遮挡住popuowindow
        popWindow.showAtLocation(parent, Gravity.BOTTOM,0,0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ey = text.getText().toString();
                text.setText("");
                popWindow.dismiss();
            }
        });

        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {//设置监听菜单关闭事件
            @Override
            public void onDismiss() {
            }
        });
        popWindow.setTouchInterceptor(new View.OnTouchListener() {//设置触屏事件
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListSize(mList);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        NineGridTestLayout layout;
        ImageView ping;
        TextView textView;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_nine_grid);
            ping = itemView.findViewById(R.id.iv_pinglun);
            textView = itemView.findViewById(R.id.tv_cont);
            linearLayout = itemView.findViewById(R.id.ll_ll);
        }
    }

    private int getListSize(List<NineGridTestModel> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }
}

