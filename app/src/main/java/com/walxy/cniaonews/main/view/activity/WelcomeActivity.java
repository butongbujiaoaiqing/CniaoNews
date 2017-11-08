package com.walxy.cniaonews.main.view.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.gyf.barlibrary.ImmersionBar;
import com.walxy.cniaonews.R;
import com.walxy.cniaonews.base.BaseActivity;
import com.walxy.cniaonews.utils.CustomVideoView;

public class WelcomeActivity extends BaseActivity implements View.OnClickListener {

    private CustomVideoView videoview;
    private Button btn_start;

    @Override
    public int getLayoudId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);

        videoview = (CustomVideoView) findViewById(R.id.videoview);
        //设置播放加载路径
        videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.guide_1));
        //播放
        videoview.start();
        //循环播放
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
    }

    @Override
    public void initData() {
        ImmersionBar.with(this).init();
        ImmersionBar.with(this).transparentStatusBar().fullScreen(true).destroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                //进入主界面
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
                break;
        }
    }
}
