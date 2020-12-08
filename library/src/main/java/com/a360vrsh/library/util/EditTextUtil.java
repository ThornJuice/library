package com.a360vrsh.library.util;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * @author: wxj
 * @date: 2020/11/4
 * @description:
 */
public class EditTextUtil {
    /**
     * 最多输入小数点后两位
     */
    public static InputFilter[] inputTwoDecimal() {
        return new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(".") && dest.toString().length() == 0) {
                    return "0.";
                }
                if (dest.toString().contains(".")) {
                    int index = dest.toString().indexOf(".");
                    int length = dest.toString().substring(index).length();
                    if (length == 3) {
                        return "";
                    }
                }
                return null;
            }
        }};
    }
}
