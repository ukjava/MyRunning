// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.weather;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ukjava.myrunning.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WeatherActivity_ViewBinding implements Unbinder {
  private WeatherActivity target;

  @UiThread
  public WeatherActivity_ViewBinding(WeatherActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WeatherActivity_ViewBinding(WeatherActivity target, View source) {
    this.target = target;

    target.tvTemp = Utils.findRequiredViewAsType(source, R.id.tv_temp, "field 'tvTemp'", TextView.class);
    target.tvTodayCity = Utils.findRequiredViewAsType(source, R.id.tv_today_city, "field 'tvTodayCity'", TextView.class);
    target.tvTodayWeek = Utils.findRequiredViewAsType(source, R.id.tv_today_week, "field 'tvTodayWeek'", TextView.class);
    target.tvTodayWeather = Utils.findRequiredViewAsType(source, R.id.tv_today_weather, "field 'tvTodayWeather'", TextView.class);
    target.rlWeatherBg = Utils.findRequiredViewAsType(source, R.id.rl_weather_bg, "field 'rlWeatherBg'", RelativeLayout.class);
    target.ivImgBg = Utils.findRequiredViewAsType(source, R.id.iv_img_bg, "field 'ivImgBg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WeatherActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTemp = null;
    target.tvTodayCity = null;
    target.tvTodayWeek = null;
    target.tvTodayWeather = null;
    target.rlWeatherBg = null;
    target.ivImgBg = null;
  }
}
