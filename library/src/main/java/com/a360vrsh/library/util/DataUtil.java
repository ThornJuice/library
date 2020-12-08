package com.a360vrsh.library.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/3
 * @description:
 */
public class DataUtil {
    /**
     * 模拟数据
     *
     * @param size
     */
    public static ArrayList<String> getArrayList(int size) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + "");
        }
        return list;

    }

    /**
     * 模拟数据
     *
     * @param size
     */
    public static ArrayList<String> getArrayList(int size, String content) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + content);
        }
        return list;

    }

    /**
     * 等分list
     *
     * @param num        分的份数
     * @param targetList 需要分的集合
     */
    public static List<List<String>> splitList(List<String> targetList, Integer num) {

        int allCount = targetList.size();
        List<List<String>> resultList = new ArrayList<>();
        List<String> equalList = new ArrayList<>();
        for (int i = 0; i < allCount; i++) {
            equalList.add(targetList.get(i));
            if (((i + 1) % num == 0) || (i + 1 == allCount)) {
                resultList.add(equalList);
                equalList = new ArrayList<>();
            }
        }
        return resultList;
    }
}
