package com.ukjava.myrunning.step;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.ActionBaseActivity;
import com.ukjava.myrunning.module.Record.Contract.RecordContract;
import com.ukjava.myrunning.module.Record.Presenter.RecordPresenter;
import com.ukjava.myrunning.module.Record.been.RecordBeen;
import com.ukjava.myrunning.step.adapter.RecordAdapter;
import com.ukjava.myrunning.step.view.WaveView;

import java.util.HashMap;

public class RunningRecordActivity extends ActionBaseActivity implements RecordContract.View {
    private View view;
    private RecordAdapter adapter;
    private RecordPresenter presenter;
    @Override
    protected void setBaseTitle(TextView titleView) {
        titleView.setText("跑步记录");
    }

    @Override
    protected void addContainerView(ViewGroup viewGroup, LayoutInflater inflater) {
        view  = inflater.inflate(R.layout.activity_running_record,null);
        viewGroup.addView(view);
        initView();
    }

    private void initView() {
        WaveView waveView=  view.findViewById(R.id.waveView);
        waveView.setFlowNum("LV1");
        RecyclerView view1 = view.findViewById(R.id.rl_item);

        presenter = new RecordPresenter(this,this);

        adapter = new RecordAdapter(this);
        view1.setLayoutManager(new LinearLayoutManager(this));
        view1.setAdapter(adapter);

      /*  HashMap<String,Object> maps = new HashMap<>();
        presenter.getRecord(maps);*/

    }

    @Override
    public void setRecord(RecordBeen recordBeen) {

    }
}
