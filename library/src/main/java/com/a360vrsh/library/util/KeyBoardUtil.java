package com.a360vrsh.library.util;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @author: wxj
 * @date: 2020/10/13
 * @description:
 */
public class KeyBoardUtil {
    //此方法只是关闭软键盘
    public static void hintKbTwo(Activity context) {

        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && context.getCurrentFocus() != null) {
            if (context.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    /**
     * 显示键盘
     *
     * @param et 输入焦点
     */
    public static void showInput(Activity context, final EditText et) {
        et.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(et, InputMethodManager.SHOW_IMPLICIT);
    }

}
