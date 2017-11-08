package com.walxy.cniaonews.main.view.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ryane.banner_lib.AdPageInfo;
import com.ryane.banner_lib.AdPlayBanner;
import com.ryane.banner_lib.transformer.RotateDownTransformer;
import com.walxy.cniaonews.R;
import com.walxy.cniaonews.base.BaseFragemnt;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.ryane.banner_lib.AdPlayBanner.IndicatorType.POINT_INDICATOR;

/**
 * 作者：王兵洋 on 2017/11/6 11:27
 * 类的作用：
 */
public class Fragment_ALL extends BaseFragemnt {

    @BindView(R.id.game_banner)
    AdPlayBanner mGameBanner;
    @BindView(R.id.rcy)
    RecyclerView mRcy;
    private List<AdPageInfo> list = new ArrayList<>();

    @Override
    public int getLayOutId() {
        return R.layout.fragment_all;
    }

    @Override
    protected void initView() {

        AdPageInfo info1 = new AdPageInfo("", "http://ads-cdn.chuchujie.com/fdd57d5d6a16d9958bc0a48247ce25dd.jpg?&", "", 1);
        AdPageInfo info2 = new AdPageInfo("", "http://ads-cdn.chuchujie.com/b4c88d8c57fe98872180745488467165.jpg?&", "", 2);
        AdPageInfo info3 = new AdPageInfo("", "http://ads-cdn.chuchujie.com/08287bc153aeea39d77e1b5f366bd707.png?&", "", 3);
        AdPageInfo info4 = new AdPageInfo("", "http://ads-cdn.chuchujie.com/aabc330a199831dadb720974d092d554.png?&", "", 4);
        AdPageInfo info5 = new AdPageInfo("", "http://ads-cdn.chuchujie.com/845260da449cc8f19a315d011d6e5745.png?&", "", 5);

        list.add(info1);
        list.add(info2);
        list.add(info3);
        list.add(info4);
        list.add(info5);

        mGameBanner.setInterval(1500)
                .setBannerBackground(Color.WHITE)
                .setPageTransfromer(new RotateDownTransformer())
                .setInfoList((ArrayList<AdPageInfo>) list)
                .setIndicatorType(POINT_INDICATOR)
                .setUp();
    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRcy.setLayoutManager(manager);
    }
}