package com.a360vrsh.library.util;

import com.tencent.mmkv.MMKV;

/**
 * @author: wxj
 * @date: 2020/9/21
 * @description:
 */
public class MMKVUtil {
    public static final String TICKET = "ticket";
    public static final String STORE_ID = "store_id";
    public static final String STORE_TYPE = "store_type";
    public static final String STORE_STATUS = "store_status";
    public static final String PHONE = "phone";
    public static final String PWD = "pwd";
    public static final String REMEMBER_PWD = "remember_pwd";

    public static void putString(String key, String value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static String getString(String key) {
        return MMKV.defaultMMKV().decodeString(key, "");
    }

    public static String getString(String key, String defaultValue) {
        return MMKV.defaultMMKV().decodeString(key, defaultValue);
    }

    public static void putInt(String key, int value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static int getInt(String key) {
        return MMKV.defaultMMKV().decodeInt(key, 0);
    }

    public static int getInt(String key, int defaultValue) {
        return MMKV.defaultMMKV().decodeInt(key, defaultValue);
    }

    public static void putBool(String key, Boolean value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static boolean getBool(String key) {
        return MMKV.defaultMMKV().decodeBool(key, false);
    }

    public static boolean getBool(String key, Boolean defaultValue) {
        return MMKV.defaultMMKV().decodeBool(key, defaultValue);
    }

    public static void clearLoginInfo() {
        MMKV.defaultMMKV().remove(MMKVUtil.TICKET);
        MMKV.defaultMMKV().remove(MMKVUtil.STORE_STATUS);
        MMKV.defaultMMKV().remove(MMKVUtil.STORE_ID);
        MMKV.defaultMMKV().remove(MMKVUtil.STORE_TYPE);
    }

    public static void saveLoginInfo(String store_id, String status, String store_type) {
        putString(MMKVUtil.STORE_ID, store_id);
        putString(MMKVUtil.STORE_STATUS, status);
        putString(MMKVUtil.STORE_TYPE, store_type);
    }

    public static String getStoreId() {
        return getString(STORE_ID, "");
    }

    public static String getStoreType() {
        return getString(STORE_TYPE, "");
    }

    public static String getTicket() {
        return getString(TICKET, "");
    }

    public static String getPhone() {
        return getString(PHONE, "");
    }
}
