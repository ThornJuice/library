package com.a360vrsh.library.util;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogUtil {
    private static final String TAG = "MyLogUtil";
    private static boolean LOG_ENABLE = true;

    public static boolean isLogEnable() {
        return LOG_ENABLE;
    }

    public static void setLogEnable(boolean logEnable) {
        LOG_ENABLE = logEnable;
    }

    //false关闭打印


    public static void i(String tag, String msg) {
        if (isLogEnable()) {
            Log.i(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (isLogEnable()) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isLogEnable()) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isLogEnable()) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isLogEnable()) {
            Log.e(tag, msg);
        }
    }




    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }
}

