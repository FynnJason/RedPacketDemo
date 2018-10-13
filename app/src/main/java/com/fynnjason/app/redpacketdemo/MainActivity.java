package com.fynnjason.app.redpacketdemo;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private RedPacketDialog mDialog;
    private ImageView mIv;
    private ObjectAnimator mRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv = findViewById(R.id.iv_red_packet);
        //动画
        mRotation = ObjectAnimator.ofFloat(mIv, "rotation", 0f, -15f, 15f,-7.5f,7.5f,0f);
        mIv.setPivotX(50);
        mIv.setPivotY(100);
        mRotation.setDuration(1000);
        mHandler.sendEmptyMessage(i);

        mDialog = new RedPacketDialog(MainActivity.this, new RedPacketDialog.CloseListener() {
            @Override
            public void cancel() {
                mDialog.cancel();
                mIv.setVisibility(View.VISIBLE);
                i = 1;
                mHandler.sendEmptyMessage(i);
            }
        });

        mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIv.setVisibility(View.GONE);
                i = 2;
                mDialog.show();
            }
        });
    }

    private int i = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mRotation.start();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sendEmptyMessage(i);
                        }
                    }, 3000);
                    break;
                case 2:
                    break;
            }
        }
    };
}
