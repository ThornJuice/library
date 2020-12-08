package com.a360vrsh.library.util;

import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.a360vrsh.baselibrary.R;
import com.a360vrsh.library.base.BaseApplication;


/**
 * 可在任意线程执行本类方法
 */
public class ToastUtil {

    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static Toast mToast;

    public static void show(int msgResId) {
        show(msgResId, false);
    }

    public static void show(int msgResId, boolean timeLong) {
        show(BaseApplication.getInstance().getString(msgResId), timeLong);
    }

    public static void show(CharSequence msg) {
        show(msg, false);
    }

    public static void show(final CharSequence msg, final boolean timeLong) {
        runOnUiThread(() -> {
            if (mToast != null) {
                mToast.cancel();
            }
            int duration = timeLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
            mToast = Toast.makeText(BaseApplication.getInstance(), null, duration);
            View toastView = LayoutInflater.from(BaseApplication.getInstance()).inflate(R.layout.library_layout_toast, null);
            TextView textView = toastView.findViewById(R.id.tv_toast_message);
            textView.setText(msg);
            mToast.setView(toastView);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.show();
        });
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            mHandler.post(runnable);
        }
    }
}
