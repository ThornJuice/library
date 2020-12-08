package com.a360vrsh.library.util;

import android.app.Activity;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whc
 * Activity 管理类
 */
public class ActivityCollector {

    public static List<Activity> activitys = new ArrayList<Activity>();
    public static List<Activity> temActivitys = new ArrayList<Activity>();


    public static void addActivity(Activity activity) {
        activitys.add(activity);

    }

    public static void removeActivity(Activity activity) {
        activitys.remove(activity);
    }


    public static void finishAll() {
        for (Activity activity : activitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }


    //	临时定义,用于解决返回冲突
    public static void addActivityTemporary(Activity activity) {

        temActivitys.add(activity);

    }

    public static void finishTemporary() {

        for (Activity activity : temActivitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }

    }

    public static void finishActivityByName(String name) {
        for (Activity activity : activitys) {
            if (TextUtils.equals(activity.getComponentName().getClassName(), name) && !activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
