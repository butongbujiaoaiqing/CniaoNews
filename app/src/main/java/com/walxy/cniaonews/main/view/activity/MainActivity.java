package com.walxy.cniaonews.main.view.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.walxy.cniaonews.R;
import com.walxy.cniaonews.base.BaseActivity;
import com.walxy.cniaonews.main.view.fragment.Fragment_ALL;
import com.walxy.cniaonews.main.view.fragment.Fragment_FUN;
import com.walxy.cniaonews.main.view.fragment.Fragment_New;
import com.walxy.cniaonews.main.view.fragment.Fragment_O2O;
import com.walxy.cniaonews.main.view.fragment.Fragment_keTV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.top_bar_icon)
    ImageView mTopBarIcon;
    @BindView(R.id.top_bar_title)
    TextView mTopBarTitle;
    @BindView(R.id.top_bar_search_btn)
    Button mTopBarSearchBtn;
    @BindView(R.id.bar_layout)
    RelativeLayout mBarLayout;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.vp_view)
    ViewPager mVpView;

    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = {"全部", "氪TV", "O2O", "新硬件", "FUN!!"};
    private SlidingMenu mMenu;


    @Override
    public int getLayoudId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        //页面，数据源
        list = new ArrayList<>();
        list.add(new Fragment_ALL());
        list.add(new Fragment_keTV());
        list.add(new Fragment_O2O());
        list.add(new Fragment_New());
        list.add(new Fragment_FUN());
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        mVpView.setAdapter(adapter);
        //绑定
        mTabs.setupWithViewPager(mVpView);
    }

    @Override
    public void initData() {
        // configure the SlidingMenu
        mMenu = new SlidingMenu(this);
        mMenu.setMode(SlidingMenu.LEFT);
// 设置触摸屏幕的模式
        mMenu.setTouchModeAbove(SlidingMenu.LEFT);
// 设置滑动菜单视图的宽度
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;
        mMenu.setBehindOffset(width / 3);
// 设置渐入渐出效果的值
        mMenu.setFadeDegree(0.35f);
        mMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//为侧滑菜单设置布局
        mMenu.setMenu(R.layout.two_main);
    }

    @OnClick({R.id.top_bar_icon, R.id.top_bar_search_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_bar_icon:
                mMenu.showMenu();
                break;
            case R.id.top_bar_search_btn:
                break;
        }
    }

    //适配器
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}