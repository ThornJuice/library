package com.a360vrsh.pansmartcitystory

import android.R
import cn.jpush.android.api.JPushInterface
import com.a360vrsh.library.base.BaseApplication
import com.a360vrsh.library.util.LogUtil
import com.baidu.mapapi.SDKInitializer
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.tencent.mmkv.MMKV
import com.umeng.socialize.PlatformConfig
import com.umeng.socialize.UMShareAPI


/**
 * @author: wxj
 * @date: 2020/9/11
 * @description:
 */
class MyApplication : BaseApplication() {
    init{
        //设置全局的Header构建器
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater { context, layout ->
            layout.setPrimaryColorsId(R.color.white, R.color.black) //全局设置主题颜色
            MaterialHeader(context)
        }
        //设置全局的Footer构建器
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater { context, layout ->
            ClassicsFooter(
                context
            ).setSpinnerStyle(SpinnerStyle.Translate)
        }
    }
    companion object {
        lateinit var instance: MyApplication
    }

    var isSound = false

    override fun onCreate() {
        super.onCreate()
        LogUtil.setLogEnable(BuildConfig.DEBUG)
        initialize()

    }

    private fun initialize() {
        //百度地图
        SDKInitializer.initialize(this)

        //分享
        PlatformConfig.setWeixin("wxff9fc58247514c56", "3144aac9a9af980336839cc150a013d6")
        PlatformConfig.setQQZone("101413515", "70870c1cd50c7eb66cde4d6979d5b345")
        UMShareAPI.get(this)
        //推送
        JPushInterface.init(this)
        val rootDir = MMKV.initialize(this)
//        LogUtil.e("mmkv root", rootDir)
    }

}