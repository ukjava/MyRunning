// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.module.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ukjava.myrunning.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingsActivity_ViewBinding implements Unbinder {
  private SettingsActivity target;

  private View view2131296532;

  private View view2131296499;

  private View view2131296530;

  private View view2131296529;

  private View view2131296531;

  private View view2131296533;

  private View view2131296527;

  private View view2131296528;

  private View view2131296680;

  private View view2131296322;

  @UiThread
  public SettingsActivity_ViewBinding(SettingsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingsActivity_ViewBinding(final SettingsActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.rl_settings_person, "field 'rlSettingsPerson' and method 'onViewClicked'");
    target.rlSettingsPerson = Utils.castView(view, R.id.rl_settings_person, "field 'rlSettingsPerson'", RelativeLayout.class);
    view2131296532 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.phone_number, "field 'phoneNumber' and method 'onViewClicked'");
    target.phoneNumber = Utils.castView(view, R.id.phone_number, "field 'phoneNumber'", TextView.class);
    view2131296499 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_settings_number, "field 'rlSettingsNumber' and method 'onViewClicked'");
    target.rlSettingsNumber = Utils.castView(view, R.id.rl_settings_number, "field 'rlSettingsNumber'", RelativeLayout.class);
    view2131296530 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_settings_login_password, "field 'rlSettingsLoginPassword' and method 'onViewClicked'");
    target.rlSettingsLoginPassword = Utils.castView(view, R.id.rl_settings_login_password, "field 'rlSettingsLoginPassword'", RelativeLayout.class);
    view2131296529 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_settings_pay_password, "field 'rlSettingsPayPassword' and method 'onViewClicked'");
    target.rlSettingsPayPassword = Utils.castView(view, R.id.rl_settings_pay_password, "field 'rlSettingsPayPassword'", RelativeLayout.class);
    view2131296531 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_settings_shipping_address, "field 'rlSettingsShippingAddress' and method 'onViewClicked'");
    target.rlSettingsShippingAddress = Utils.castView(view, R.id.rl_settings_shipping_address, "field 'rlSettingsShippingAddress'", RelativeLayout.class);
    view2131296533 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_settings_Feedback, "field 'rlSettingsFeedback' and method 'onViewClicked'");
    target.rlSettingsFeedback = Utils.castView(view, R.id.rl_settings_Feedback, "field 'rlSettingsFeedback'", RelativeLayout.class);
    view2131296527 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_settings_about, "field 'rlSettingsAbout' and method 'onViewClicked'");
    target.rlSettingsAbout = Utils.castView(view, R.id.rl_settings_about, "field 'rlSettingsAbout'", RelativeLayout.class);
    view2131296528 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.versions, "field 'versions' and method 'onViewClicked'");
    target.versions = Utils.castView(view, R.id.versions, "field 'versions'", TextView.class);
    view2131296680 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlSettingsVersion = Utils.findRequiredViewAsType(source, R.id.rl_settings_version, "field 'rlSettingsVersion'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_back, "field 'btnBack' and method 'onViewClicked'");
    target.btnBack = Utils.castView(view, R.id.btn_back, "field 'btnBack'", Button.class);
    view2131296322 = view;
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
    SettingsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rlSettingsPerson = null;
    target.phoneNumber = null;
    target.rlSettingsNumber = null;
    target.rlSettingsLoginPassword = null;
    target.rlSettingsPayPassword = null;
    target.rlSettingsShippingAddress = null;
    target.rlSettingsFeedback = null;
    target.rlSettingsAbout = null;
    target.versions = null;
    target.rlSettingsVersion = null;
    target.btnBack = null;

    view2131296532.setOnClickListener(null);
    view2131296532 = null;
    view2131296499.setOnClickListener(null);
    view2131296499 = null;
    view2131296530.setOnClickListener(null);
    view2131296530 = null;
    view2131296529.setOnClickListener(null);
    view2131296529 = null;
    view2131296531.setOnClickListener(null);
    view2131296531 = null;
    view2131296533.setOnClickListener(null);
    view2131296533 = null;
    view2131296527.setOnClickListener(null);
    view2131296527 = null;
    view2131296528.setOnClickListener(null);
    view2131296528 = null;
    view2131296680.setOnClickListener(null);
    view2131296680 = null;
    view2131296322.setOnClickListener(null);
    view2131296322 = null;
  }
}
