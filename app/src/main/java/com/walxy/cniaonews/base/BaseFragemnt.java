package com.walxy.cniaonews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：王兵洋 on 2017/11/6 11:28
 * 类的作用：
 */
public abstract class BaseFragemnt extends Fragment {
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), getLayOutId(), null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    public abstract int getLayOutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
