package com.a360vrsh.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatEditText;

/**
 * 光标永远在末尾，不可在其他位置输入
 */
public class EndSelectionEditText extends AppCompatEditText {

    private long lastTime = 0;

    public EndSelectionEditText(Context context) {
        super(context);
    }

    public EndSelectionEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EndSelectionEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        this.setSelection(this.getText().length());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastTime < 500) {
                    lastTime = currentTime;
                    return true;
                } else {
                    lastTime = currentTime;
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
