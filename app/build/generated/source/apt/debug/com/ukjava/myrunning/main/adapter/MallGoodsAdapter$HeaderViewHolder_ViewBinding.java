// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.main.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.jzvd.JZVideoPlayerStandard;
import com.ukjava.myrunning.R;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MallGoodsAdapter$HeaderViewHolder_ViewBinding implements Unbinder {
  private MallGoodsAdapter.HeaderViewHolder target;

  @UiThread
  public MallGoodsAdapter$HeaderViewHolder_ViewBinding(MallGoodsAdapter.HeaderViewHolder target,
      View source) {
    this.target = target;

    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
    target.vvpMainVideo1 = Utils.findRequiredViewAsType(source, R.id.vvp_main_video1, "field 'vvpMainVideo1'", JZVideoPlayerStandard.class);
    target.flBanner = Utils.findRequiredViewAsType(source, R.id.fl_banner, "field 'flBanner'", FrameLayout.class);
    target.newProducts = Utils.findRequiredViewAsType(source, R.id.new_products, "field 'newProducts'", LinearLayout.class);
    target.sellingGoods = Utils.findRequiredViewAsType(source, R.id.selling_goods, "field 'sellingGoods'", LinearLayout.class);
    target.jimeiHeadlines = Utils.findRequiredViewAsType(source, R.id.jimei_headlines, "field 'jimeiHeadlines'", LinearLayout.class);
    target.skTemp = Utils.findRequiredViewAsType(source, R.id.sk_temp, "field 'skTemp'", TextView.class);
    target.todayWeek = Utils.findRequiredViewAsType(source, R.id.today_week, "field 'todayWeek'", TextView.class);
    target.todayCity = Utils.findRequiredViewAsType(source, R.id.today_city, "field 'todayCity'", TextView.class);
    target.todayWeather = Utils.findRequiredViewAsType(source, R.id.today_weather, "field 'todayWeather'", TextView.class);
    target.todayData = Utils.findRequiredViewAsType(source, R.id.today_data, "field 'todayData'", TextView.class);
    target.today_exercise = Utils.findRequiredViewAsType(source, R.id.today_exercise, "field 'today_exercise'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MallGoodsAdapter.HeaderViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.banner = null;
    target.vvpMainVideo1 = null;
    target.flBanner = null;
    target.newProducts = null;
    target.sellingGoods = null;
    target.jimeiHeadlines = null;
    target.skTemp = null;
    target.todayWeek = null;
    target.todayCity = null;
    target.todayWeather = null;
    target.todayData = null;
    target.today_exercise = null;
  }
}
