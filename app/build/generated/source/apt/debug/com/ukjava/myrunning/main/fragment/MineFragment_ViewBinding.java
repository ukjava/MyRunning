// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.main.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ukjava.myrunning.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineFragment_ViewBinding implements Unbinder {
  private MineFragment target;

  private View view2131296321;

  private View view2131296320;

  private View view2131296643;

  private View view2131296355;

  private View view2131296354;

  private View view2131296356;

  private View view2131296702;

  private View view2131296509;

  private View view2131296465;

  private View view2131296462;

  private View view2131296478;

  @UiThread
  public MineFragment_ViewBinding(final MineFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.bt_setting, "field 'btSetting' and method 'onViewClicked'");
    target.btSetting = Utils.castView(view, R.id.bt_setting, "field 'btSetting'", Button.class);
    view2131296321 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_message, "field 'btMessage' and method 'onViewClicked'");
    target.btMessage = Utils.castView(view, R.id.bt_message, "field 'btMessage'", Button.class);
    view2131296320 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.avatar = Utils.findRequiredViewAsType(source, R.id.avatar, "field 'avatar'", CircleImageView.class);
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvFollowCount = Utils.findRequiredViewAsType(source, R.id.tv_follow_count, "field 'tvFollowCount'", TextView.class);
    view = Utils.findRequiredView(source, R.id.topsearch, "field 'topsearch' and method 'onViewClicked'");
    target.topsearch = Utils.castView(view, R.id.topsearch, "field 'topsearch'", LinearLayout.class);
    view2131296643 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.daifukuan, "field 'daifukuan' and method 'onViewClicked'");
    target.daifukuan = Utils.castView(view, R.id.daifukuan, "field 'daifukuan'", LinearLayout.class);
    view2131296355 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.daifahuo, "field 'daifahuo' and method 'onViewClicked'");
    target.daifahuo = Utils.castView(view, R.id.daifahuo, "field 'daifahuo'", LinearLayout.class);
    view2131296354 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.daishouhuo, "field 'daishouhuo' and method 'onViewClicked'");
    target.daishouhuo = Utils.castView(view, R.id.daishouhuo, "field 'daishouhuo'", LinearLayout.class);
    view2131296356 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.yiwancheng, "field 'yiwancheng' and method 'onViewClicked'");
    target.yiwancheng = Utils.castView(view, R.id.yiwancheng, "field 'yiwancheng'", LinearLayout.class);
    view2131296702 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.quanbudingdan, "field 'quanbudingdan' and method 'onViewClicked'");
    target.quanbudingdan = Utils.castView(view, R.id.quanbudingdan, "field 'quanbudingdan'", LinearLayout.class);
    view2131296509 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.table = Utils.findRequiredViewAsType(source, R.id.table, "field 'table'", LinearLayout.class);
    target.tvMybalanceNumber = Utils.findRequiredViewAsType(source, R.id.tv_mybalance_number, "field 'tvMybalanceNumber'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_mybalance, "field 'llMybalance' and method 'onViewClicked'");
    target.llMybalance = Utils.castView(view, R.id.ll_mybalance, "field 'llMybalance'", LinearLayout.class);
    view2131296465 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvCsahdepositNumber = Utils.findRequiredViewAsType(source, R.id.tv_csahdeposit_number, "field 'tvCsahdepositNumber'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_cashdeposit, "field 'llCashdeposit' and method 'onViewClicked'");
    target.llCashdeposit = Utils.castView(view, R.id.ll_cashdeposit, "field 'llCashdeposit'", LinearLayout.class);
    view2131296462 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.my_follow, "field 'myFollow' and method 'onViewClicked'");
    target.myFollow = Utils.castView(view, R.id.my_follow, "field 'myFollow'", LinearLayout.class);
    view2131296478 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MineFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btSetting = null;
    target.btMessage = null;
    target.avatar = null;
    target.tvName = null;
    target.tvFollowCount = null;
    target.topsearch = null;
    target.daifukuan = null;
    target.daifahuo = null;
    target.daishouhuo = null;
    target.yiwancheng = null;
    target.quanbudingdan = null;
    target.table = null;
    target.tvMybalanceNumber = null;
    target.llMybalance = null;
    target.tvCsahdepositNumber = null;
    target.llCashdeposit = null;
    target.myFollow = null;

    view2131296321.setOnClickListener(null);
    view2131296321 = null;
    view2131296320.setOnClickListener(null);
    view2131296320 = null;
    view2131296643.setOnClickListener(null);
    view2131296643 = null;
    view2131296355.setOnClickListener(null);
    view2131296355 = null;
    view2131296354.setOnClickListener(null);
    view2131296354 = null;
    view2131296356.setOnClickListener(null);
    view2131296356 = null;
    view2131296702.setOnClickListener(null);
    view2131296702 = null;
    view2131296509.setOnClickListener(null);
    view2131296509 = null;
    view2131296465.setOnClickListener(null);
    view2131296465 = null;
    view2131296462.setOnClickListener(null);
    view2131296462 = null;
    view2131296478.setOnClickListener(null);
    view2131296478 = null;
  }
}
