package com.fynnjason.app.redpacketdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


/**
 * Created by FynnJason.
 * Function：红包
 */
public class RedPacketDialog extends Dialog implements View.OnClickListener {

    public RedPacketDialog(@NonNull Context context,CloseListener closeListener) {
        super(context, R.style.RedPacketDialogTheme);
        mCloseListener = closeListener;
    }

    public RedPacketDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RedPacketDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private ImageView ivRedPacket, ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_red_packet);
        Window window = this.getWindow();
        if (window != null) {
            window.setGravity(Gravity.CENTER);  //设置dialog显示的位置
            window.setWindowAnimations(R.style.red_packet_dialog_anim_style); //添加动画
        }
        initView();
        initListener();
    }

    private void initListener() {
        ivRedPacket.setOnClickListener(this);
        ivClose.setOnClickListener(this);
    }

    private void initView() {
        ivRedPacket = findViewById(R.id.iv_red_packet);
        ivClose = findViewById(R.id.iv_close);
        Glide.with(getContext()).load(R.drawable.red_packet).into(ivRedPacket);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_red_packet:
                Toast.makeText(getContext(), "点击了红包", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_close:
                mCloseListener.cancel();
                break;
        }
    }

    private CloseListener mCloseListener;

    interface CloseListener {
        void cancel();
    }
}
