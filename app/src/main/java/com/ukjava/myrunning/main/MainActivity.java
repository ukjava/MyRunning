package com.ukjava.myrunning.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ukjava.myrunning.R;
import com.ukjava.myrunning.main.fragment.MallFragment;
import com.ukjava.myrunning.main.fragment.MineFragment;
import com.ukjava.myrunning.main.fragment.PersonFragment;
import com.ukjava.myrunning.main.fragment.SaleFragment;

public class MainActivity extends BaseActivity {
    private TabLayout tablayout;
    private ViewPager vp_contain;

    private int[] index_drawables = new int[]{R.drawable.tab_mall_selector, R.drawable.tab_sale_selector, R.drawable.tab_mine_selector};
    //private int[] indexs = new int[]{R.string.mall_index,R.string.sale_index,R.string.book_index,R.string.mine_index};
    private int[] indexs = new int[]{R.string.mall_index, R.string.sale_index, R.string.mine_index};

    private Fragment[] FRAGMENTS;
    private MallFragment mallFragment;
    private SaleFragment saleFragment;
    private MineFragment mineFragment;
    private PersonFragment personFragment;

    private IntentFilter intentFilter;//广播过滤器
    private SwitchHomePage homePage;//切换到首页的广播

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        Log.e("TAG", "屏幕尺寸2：宽度 = " + w_screen + "高度 = " + h_screen + "密度 = " + dm.densityDpi);

        tablayout = findViewById(R.id.tablayout);
        initTabs();
        vp_contain = findViewById(R.id.vp_contain);
        mallFragment = new MallFragment();
        saleFragment = new SaleFragment();
        mineFragment = new MineFragment();
        personFragment = new PersonFragment();
        FRAGMENTS = new Fragment[]{mallFragment,saleFragment,personFragment};

        vp_contain.setAdapter(new MyAdapter(getSupportFragmentManager()));
        vp_contain.setOffscreenPageLimit(3);
        vp_contain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp_contain.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initTabs() {
        for (int i=0;i<indexs.length;i++){
            TabLayout.Tab tab = tablayout.newTab();
            View view = LayoutInflater.from(this).inflate(R.layout.index_tab_custom, null);
            ImageView imageView = view.findViewById(R.id.img_index);
            imageView.setImageResource(index_drawables[i]);
            TextView textView = view.findViewById(R.id.tv_index);
            textView.setText(indexs[i]);
            tab.setCustomView(view);
            tablayout.addTab(tab);
        }
    }

    //回到首页的广播
    class SwitchHomePage extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            tablayout.getTabAt(0).select();
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FRAGMENTS[position];
        }

        @Override
        public int getCount() {
            return indexs.length;
        }
    }
}
