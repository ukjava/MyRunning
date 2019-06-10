// Generated code from Butter Knife. Do not modify!
package com.ukjava.myrunning.module.news.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ukjava.myrunning.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsAdapter$MyHolder_ViewBinding implements Unbinder {
  private NewsAdapter.MyHolder target;

  @UiThread
  public NewsAdapter$MyHolder_ViewBinding(NewsAdapter.MyHolder target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvThumbnailPicS = Utils.findRequiredViewAsType(source, R.id.tv_thumbnail_pic_s, "field 'tvThumbnailPicS'", ImageView.class);
    target.ivThumbnailPicS02 = Utils.findRequiredViewAsType(source, R.id.iv_thumbnail_pic_s02, "field 'ivThumbnailPicS02'", ImageView.class);
    target.ivThumbnailPicS03 = Utils.findRequiredViewAsType(source, R.id.iv_thumbnail_pic_s03, "field 'ivThumbnailPicS03'", ImageView.class);
    target.llMags = Utils.findRequiredViewAsType(source, R.id.ll_mags, "field 'llMags'", LinearLayout.class);
    target.tvAuthorName = Utils.findRequiredViewAsType(source, R.id.tv_author_name, "field 'tvAuthorName'", TextView.class);
    target.rlNews = Utils.findRequiredViewAsType(source, R.id.rl_news, "field 'rlNews'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsAdapter.MyHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.tvThumbnailPicS = null;
    target.ivThumbnailPicS02 = null;
    target.ivThumbnailPicS03 = null;
    target.llMags = null;
    target.tvAuthorName = null;
    target.rlNews = null;
  }
}
