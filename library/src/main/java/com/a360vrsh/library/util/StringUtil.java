package com.a360vrsh.library.util;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtil {
    /**
     * 字符串转arraylist 如“1，2，3” -> {1,2,3}
     *
     * @param string string
     * @param split  分隔符
     * @return ArrayList<String> arrayList
     */
    public static ArrayList<String> stringsToArrayBySplit(String string, String split) {
        if (TextUtils.isEmpty(string)) return new ArrayList<String>();
        String[] array = string.split(split);
        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    /**
     * arraylist转字符串 如{1,2,3} -> “1，2，3”
     *
     * @param list  list
     * @param split 分隔符
     * @return string
     */
    public static String arrayToStringBySplit(List<String> list, String split) {
        if (list == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(split);
        }
        if (stringBuilder.length() > 1) {
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        } else {
            return stringBuilder.toString();
        }
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s
     * @return string
     */
    public static String removeZero(String s) {
        if (null != s && s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
