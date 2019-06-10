package com.ukjava.myrunning.step.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ukjava.myrunning.R;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyHolder> {

    private Context context;
    private String[] nums = new String[]{"1","2","3","4","5"};
    private String[] steps = new String[]{"5164","3624","5622","3335","6653"};

    public RecordAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_record_view, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {
            myHolder.tv_record_number.setText(nums[position]);
            myHolder.tv_record_step.setText(steps[position]);
    }

    @Override
    public int getItemCount() {
        return nums.length;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView tv_record_step,tv_record_number;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_record_step = itemView.findViewById(R.id.tv_record_step);
            tv_record_number = itemView.findViewById(R.id.tv_record_number);
        }
    }
}
