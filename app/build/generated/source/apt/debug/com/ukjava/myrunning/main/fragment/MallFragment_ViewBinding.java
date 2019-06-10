// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.main.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.widget.RefreshFooterView;
import com.ukjava.myrunning.widget.RefreshHeaderView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MallFragment_ViewBinding implements Unbinder {
  private MallFragment target;

  private View view2131296375;

  @UiThread
  public MallFragment_ViewBinding(final MallFragment target, View source) {
    this.target = target;

    View view;
    target.btnBack = Utils.findRequiredViewAsType(source, R.id.btn_back, "field 'btnBack'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ed_search, "field 'edSearch' and method 'onViewClicked'");
    target.edSearch = Utils.castView(view, R.id.ed_search, "field 'edSearch'", EditText.class);
    view2131296375 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.btnCart = Utils.findRequiredViewAsType(source, R.id.btn_cart, "field 'btnCart'", Button.class);
    target.btnNews = Utils.findRequiredViewAsType(source, R.id.btn_news, "field 'btnNews'", Button.class);
    target.affirmCancel = Utils.findRequiredViewAsType(source, R.id.affirm_cancel, "field 'affirmCancel'", TextView.class);
    target.topsearch = Utils.findRequiredViewAsType(source, R.id.topsearch, "field 'topsearch'", LinearLayout.class);
    target.swipeRefreshHeader = Utils.findRequiredViewAsType(source, R.id.swipe_refresh_header, "field 'swipeRefreshHeader'", RefreshHeaderView.class);
    target.swipeTarget = Utils.findRequiredViewAsType(source, R.id.swipe_target, "field 'swipeTarget'", RecyclerView.class);
    target.swipeLoadMoreFooter = Utils.findRequiredViewAsType(source, R.id.swipe_load_more_footer, "field 'swipeLoadMoreFooter'", RefreshFooterView.class);
    target.swipeToLoadLayout = Utils.findRequiredViewAsType(source, R.id.swipe_to_load_layout, "field 'swipeToLoadLayout'", SwipeToLoadLayout.class);
    target.tbLayout = Utils.findRequiredViewAsType(source, R.id.tb_class, "field 'tbLayout'", TabLayout.class);
    target.content = Utils.findRequiredViewAsType(source, R.id.content, "field 'content'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MallFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnBack = null;
    target.edSearch = null;
    target.btnCart = null;
    target.btnNews = null;
    target.affirmCancel = null;
    target.topsearch = null;
    target.swipeRefreshHeader = null;
    target.swipeTarget = null;
    target.swipeLoadMoreFooter = null;
    target.swipeToLoadLayout = null;
    target.tbLayout = null;
    target.content = null;

    view2131296375.setOnClickListener(null);
    view2131296375 = null;
  }
}
