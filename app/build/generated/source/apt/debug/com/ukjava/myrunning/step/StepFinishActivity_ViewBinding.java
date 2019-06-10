// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.step;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ukjava.myrunning.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StepFinishActivity_ViewBinding implements Unbinder {
  private StepFinishActivity target;

  private View view2131296326;

  private View view2131296443;

  @UiThread
  public StepFinishActivity_ViewBinding(StepFinishActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StepFinishActivity_ViewBinding(final StepFinishActivity target, View source) {
    this.target = target;

    View view;
    target.finishKm = Utils.findRequiredViewAsType(source, R.id.finish_km, "field 'finishKm'", TextView.class);
    target.finish_allstep = Utils.findRequiredViewAsType(source, R.id.finish_allstep, "field 'finish_allstep'", TextView.class);
    target.finishTime = Utils.findRequiredViewAsType(source, R.id.finish_time, "field 'finishTime'", TextView.class);
    target.finishSur = Utils.findRequiredViewAsType(source, R.id.finish_sur, "field 'finishSur'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_return, "field 'btnReturn' and method 'onViewClicked'");
    target.btnReturn = Utils.castView(view, R.id.btn_return, "field 'btnReturn'", Button.class);
    view2131296326 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_record, "field 'ivRecord' and method 'onViewClicked'");
    target.ivRecord = Utils.castView(view, R.id.iv_record, "field 'ivRecord'", ImageView.class);
    view2131296443 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlBg = Utils.findRequiredViewAsType(source, R.id.rl_bg, "field 'rlBg'", RelativeLayout.class);
    target.tvFf = Utils.findRequiredViewAsType(source, R.id.tv_ff, "field 'tvFf'", TextView.class);
    target.tvLl = Utils.findRequiredViewAsType(source, R.id.tv_ll, "field 'tvLl'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StepFinishActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.finishKm = null;
    target.finish_allstep = null;
    target.finishTime = null;
    target.finishSur = null;
    target.btnReturn = null;
    target.ivRecord = null;
    target.rlBg = null;
    target.tvFf = null;
    target.tvLl = null;

    view2131296326.setOnClickListener(null);
    view2131296326 = null;
    view2131296443.setOnClickListener(null);
    view2131296443 = null;
  }
}
