package com.a360vrsh.library.widget;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.a360vrsh.baselibrary.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * @author: wxj
 * @date: 2020/11/5
 * @description:
 */
public class SnackbarHelper {
    public static void showSnackbarForShort(Activity activity, int resource) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), activity.getString(resource), Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        snackbar.show();
    }
    public static int getContentViewId() {
        return Build.VERSION.SDK_INT>=Build.VERSION_CODES.ICE_CREAM_SANDWICH ? android.R.id.content : R.id.action_bar_activity_content;
    }

    public static void showSnackbarForShort(Activity activity, String resource) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(getContentViewId()), resource, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.library_white));
        setSnackbarColor(snackbar,ContextCompat.getColor(activity, R.color.library_black),ContextCompat.getColor(activity, R.color.library_white));
        /*Snackbar.SnackbarLayout sv = (Snackbar.SnackbarLayout) snackbar.getView();
        ViewGroup.LayoutParams vl = snackbar.getView().getLayoutParams();
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(vl.width, vl.height);
        ll.gravity = Gravity.TOP;
        ll.topMargin = 100;
        sv.setLayoutParams(ll);*/
        snackbar.show();
    }
    public static void setSnackbarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();//获取Snackbar的view
        if(view!=null){
            view.setBackgroundColor(backgroundColor);//修改view的背景色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);//获取Snackbar的message控件，修改字体颜色
        }
    }



    public static void showSnackbarForLong(Activity activity, int resource) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), activity.getString(resource), Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        snackbar.show();
    }

    public static void showSnackbarForLong(Activity activity, String resource) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), resource, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary));
        snackbar.show();
    }

}
