package com.a360vrsh.library.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;


public class ScreenUtil {

    /**
     * 获取屏幕内容高度
     *
     * @param activity
     * @return
     */
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int result = 0;
        int resourceId = activity.getResources()
                .getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        int screenHeight = dm.heightPixels - result;
        return screenHeight;
    }

    /**
     * dp转px
     *
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * dp转px
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 判断是否是全面屏
     */

    private volatile static boolean mIsAllScreenDevice = false;

    public static boolean isAllScreenDevice(Context context) {

        // 低于 API 21的，都不会是全面屏。。。
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return false;
        }
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        int height = outMetrics.heightPixels;
        int width = outMetrics.widthPixels;

        if (height / width >= 1.86f) {
            mIsAllScreenDevice = true;
        }

        return mIsAllScreenDevice;
    }

    public static int getScreenRealHeight(Activity activity) {
        int height;
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(outMetrics);
        height = outMetrics.heightPixels;
        return height;
    }
    public static int getScreenWidth(Activity activity) {
        int width;
        DisplayMetrics outMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(outMetrics);
        width = outMetrics.widthPixels;
        return width;
    }
}
