package com.fynnjason.app.redpacketdemo;

import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by FynnJason.
 * Function：
 */
public class MineFragment extends BaseMvcFragment {
    private ImmersionBar mImmersionBar;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true).init();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && mImmersionBar != null) {
            mImmersionBar.statusBarDarkFont(true).init();
        }
    }

}
