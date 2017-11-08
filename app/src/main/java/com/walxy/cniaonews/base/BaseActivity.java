package com.walxy.cniaonews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：王兵洋 on 2017/11/6 10:57
 * 类的作用：
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoudId());
        //设置沉浸式
//        ImmersionBar.with(this).init();
//        ImmersionBar.with(this).transparentStatusBar().fullScreen(true).destroy();
        mUnbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    public abstract int getLayoudId(); //加载视图

    public abstract void initView();  //初始化数据

    public abstract void initData();  //网络请求

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();//解绑ButterKnife
    }
}
