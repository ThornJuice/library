package com.a360vrsh.library.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.noober.background.BackgroundFactory;

/**
 * @author: wxj
 * @date: 2020/11/10
 * @description:
 */
public class ShapeTextView extends AppCompatTextView {
    public ShapeTextView(Context context) {
        super(context);
    }

    public ShapeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShapeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        BackgroundFactory.setViewBackground(context, attrs, this);
    }
}

