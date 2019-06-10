// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.module.settings.person.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ukjava.myrunning.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonActivity_ViewBinding implements Unbinder {
  private PersonActivity target;

  private View view2131296415;

  private View view2131296524;

  private View view2131296535;

  private View view2131296521;

  private View view2131296525;

  @UiThread
  public PersonActivity_ViewBinding(PersonActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonActivity_ViewBinding(final PersonActivity target, View source) {
    this.target = target;

    View view;
    target.circleImage = Utils.findRequiredViewAsType(source, R.id.circle_image, "field 'circleImage'", CircleImageView.class);
    view = Utils.findRequiredView(source, R.id.head_portraits, "field 'headPortraits' and method 'onViewClicked'");
    target.headPortraits = Utils.castView(view, R.id.head_portraits, "field 'headPortraits'", RelativeLayout.class);
    view2131296415 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.names = Utils.findRequiredViewAsType(source, R.id.names, "field 'names'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_nickname, "field 'rlNickname' and method 'onViewClicked'");
    target.rlNickname = Utils.castView(view, R.id.rl_nickname, "field 'rlNickname'", RelativeLayout.class);
    view2131296524 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.sex = Utils.findRequiredViewAsType(source, R.id.sex, "field 'sex'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_sex, "field 'rlSex' and method 'onViewClicked'");
    target.rlSex = Utils.castView(view, R.id.rl_sex, "field 'rlSex'", RelativeLayout.class);
    view2131296535 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.birthday = Utils.findRequiredViewAsType(source, R.id.birthday, "field 'birthday'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_birthday, "field 'rlBirthday' and method 'onViewClicked'");
    target.rlBirthday = Utils.castView(view, R.id.rl_birthday, "field 'rlBirthday'", RelativeLayout.class);
    view2131296521 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.phoneNumber = Utils.findRequiredViewAsType(source, R.id.phone_number, "field 'phoneNumber'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_number, "field 'rlNumber' and method 'onViewClicked'");
    target.rlNumber = Utils.castView(view, R.id.rl_number, "field 'rlNumber'", RelativeLayout.class);
    view2131296525 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.main = Utils.findRequiredViewAsType(source, R.id.main, "field 'main'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PersonActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.circleImage = null;
    target.headPortraits = null;
    target.names = null;
    target.rlNickname = null;
    target.sex = null;
    target.rlSex = null;
    target.birthday = null;
    target.rlBirthday = null;
    target.phoneNumber = null;
    target.rlNumber = null;
    target.main = null;

    view2131296415.setOnClickListener(null);
    view2131296415 = null;
    view2131296524.setOnClickListener(null);
    view2131296524 = null;
    view2131296535.setOnClickListener(null);
    view2131296535 = null;
    view2131296521.setOnClickListener(null);
    view2131296521 = null;
    view2131296525.setOnClickListener(null);
    view2131296525 = null;
  }
}
