package com.a360vrsh.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;

import com.noober.background.BackgroundFactory;

/**
 * @author: wxj
 * @date: 2020/11/10
 * @description:
 */
public class ShapeLinearLayout extends LinearLayout {
    public ShapeLinearLayout(Context context) {
        super(context);
    }

    public ShapeLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShapeLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        BackgroundFactory.setViewBackground(context, attrs, this);
    }
}

