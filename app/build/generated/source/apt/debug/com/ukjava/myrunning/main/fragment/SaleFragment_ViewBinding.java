// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.main.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ukjava.myrunning.R;
import com.ukjava.myrunning.widget.RefreshFooterView;
import com.ukjava.myrunning.widget.RefreshHeaderView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SaleFragment_ViewBinding implements Unbinder {
  private SaleFragment target;

  @UiThread
  public SaleFragment_ViewBinding(SaleFragment target, View source) {
    this.target = target;

    target.swipeRefreshHeader = Utils.findRequiredViewAsType(source, R.id.swipe_refresh_header, "field 'swipeRefreshHeader'", RefreshHeaderView.class);
    target.swipeLoadMoreFooter = Utils.findRequiredViewAsType(source, R.id.swipe_load_more_footer, "field 'swipeLoadMoreFooter'", RefreshFooterView.class);
    target.swipeToLoadLayout = Utils.findRequiredViewAsType(source, R.id.swipe_to_load_layout, "field 'swipeToLoadLayout'", SwipeToLoadLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SaleFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.swipeRefreshHeader = null;
    target.swipeLoadMoreFooter = null;
    target.swipeToLoadLayout = null;
  }
}
