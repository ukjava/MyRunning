// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.weather;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ukjava.myrunning.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OtherWterActivity_ViewBinding implements Unbinder {
  private OtherWterActivity target;

  @UiThread
  public OtherWterActivity_ViewBinding(OtherWterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OtherWterActivity_ViewBinding(OtherWterActivity target, View source) {
    this.target = target;

    target.tvWtertemp = Utils.findRequiredViewAsType(source, R.id.tv_wtertemp, "field 'tvWtertemp'", TextView.class);
    target.skWtertemp = Utils.findRequiredViewAsType(source, R.id.sk_wtertemp, "field 'skWtertemp'", TextView.class);
    target.wtertodayWeek = Utils.findRequiredViewAsType(source, R.id.wtertoday_week, "field 'wtertodayWeek'", TextView.class);
    target.wtertodayCity = Utils.findRequiredViewAsType(source, R.id.wtertoday_city, "field 'wtertodayCity'", TextView.class);
    target.wtertodayWeather = Utils.findRequiredViewAsType(source, R.id.wtertoday_weather, "field 'wtertodayWeather'", TextView.class);
    target.wtertodayData = Utils.findRequiredViewAsType(source, R.id.wtertoday_data, "field 'wtertodayData'", TextView.class);
    target.wterexerciseIndex = Utils.findRequiredViewAsType(source, R.id.wterexercise_index, "field 'wterexerciseIndex'", TextView.class);
    target.wtertodayExercise = Utils.findRequiredViewAsType(source, R.id.wtertoday_exercise, "field 'wtertodayExercise'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OtherWterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvWtertemp = null;
    target.skWtertemp = null;
    target.wtertodayWeek = null;
    target.wtertodayCity = null;
    target.wtertodayWeather = null;
    target.wtertodayData = null;
    target.wterexerciseIndex = null;
    target.wtertodayExercise = null;
  }
}
