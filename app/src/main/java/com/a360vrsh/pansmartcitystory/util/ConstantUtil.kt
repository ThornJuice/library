package com.a360vrsh.pansmartcitystory.util

/**
 * @author: wxj
 * @date: 2020/9/12
 * @description: 常量
 */
object ConstantUtil {
    /**
     * 在Kotlin中，可以使用两种方法来停止自动生成get和set方法。
     * 1.使用const关键字
     * 2.使用@JvmField注解
     */
    const val RC_LOCATION_CONTACTS_PERM = 1000
    const val INTENT_IS_COLLECT = "isCollect"

    const val ACCEPT = "accept"
    const val REFUSE = "refuse"
    const val SHIP = "ship"
    const val CHECK = "check"

    //第二种方式
    @JvmStatic
    val APP_NAME = "APP_NAME"


}