package com.a360vrsh.library.base;

/**
 * @author: wxj
 * @date: 2020/10/31
 * @description: 正式环境与测试环境切换 false为正式环境
 */
public class BaseConfig {
    private static final boolean TEST = true;// true 测试 false正式

    public static boolean isTEST() {
        return TEST;
    }

}
