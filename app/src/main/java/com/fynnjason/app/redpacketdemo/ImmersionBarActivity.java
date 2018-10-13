package com.fynnjason.app.redpacketdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.gyf.barlibrary.ImmersionBar;

public class ImmersionBarActivity extends AppCompatActivity {

    private ImmersionBar mImmersionBar;
    private HomeFragment mHomeFragment;
    private MineFragment mMineFragment;
    private FragmentManager mFragmentManager;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersion_bar);
        mFrameLayout = findViewById(R.id.fl_container);
        //初始化
        mImmersionBar = ImmersionBar.with(this);
        //设置沉浸式为白色背景黑色字体
        mImmersionBar.statusBarColor(R.color.white).statusBarDarkFont(true).fitsSystemWindows(true).init();
        mHomeFragment = new HomeFragment();
        mMineFragment = new MineFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(R.id.fl_container, mHomeFragment).commit();
        findViewById(R.id.tv_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMineFragment.isAdded()) {
                    //设置沉浸式为白色背景黑色字体
                    mImmersionBar.statusBarColor(R.color.white).statusBarDarkFont(true).fitsSystemWindows(true).init();
                    mFragmentManager.beginTransaction().show(mHomeFragment).hide(mMineFragment).commit();
                }
            }
        });
        findViewById(R.id.tv_mine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMineFragment.isAdded()) {
                    mFragmentManager.beginTransaction().show(mMineFragment).hide(mHomeFragment).commit();
                } else {
                    mFragmentManager.beginTransaction().add(R.id.fl_container, mMineFragment).hide(mHomeFragment).commit();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }
}
