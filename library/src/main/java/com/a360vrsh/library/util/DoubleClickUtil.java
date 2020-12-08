package com.a360vrsh.library.util;

/**
 * @author: wxj
 * @date: 2020/9/29
 * @description: 防止重复点击
 */
public class DoubleClickUtil {

    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
