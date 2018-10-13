package com.fynnjason.app.redpacketdemo.weight;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by FynnJason.
 * Function：自带下划线的TextView
 */
public class UnderLineTextView extends AppCompatTextView {

    public UnderLineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //设置中划线，加抗锯齿
        this.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
    }
}
