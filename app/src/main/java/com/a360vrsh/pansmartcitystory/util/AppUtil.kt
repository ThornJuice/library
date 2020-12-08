package com.a360vrsh.pansmartcitystory.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.a360vrsh.library.util.ToastUtil
import com.a360vrsh.pansmartcitystory.R
import com.blankj.utilcode.util.ConvertUtils
import com.dou361.dialogui.DialogUIUtils
import com.dou361.dialogui.bean.TieBean
import com.dou361.dialogui.listener.DialogUIItemListener
import com.dou361.dialogui.listener.DialogUIListener
import com.noober.background.drawable.DrawableCreator
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import com.umeng.socialize.shareboard.ShareBoardConfig
import java.io.File
import java.net.URISyntaxException
import java.util.*

/**
 * @author: wxj
 * @date: 2020/9/11
 * @description:
 */
object AppUtil {
    private var shareMediaList: Array<SHARE_MEDIA> =
        arrayOf(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE)//分享平台
    private var shareDesc: String? = null//分享内容
    fun share(
        context: Context?,
        title: String?,
        img: String?,
        desc: String?,
        url: String?
    ) {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(img) || TextUtils.isEmpty(
                url
            )
        ) {
            ToastUtil.show("分享数据有误")
            return
        }
        if (TextUtils.isEmpty(desc)) {
            shareDesc = "加入全景智慧城市 步入真VR时代"
        } else {
            shareDesc = desc
        }

        ShareAction(context as Activity?).setDisplayList(*shareMediaList)
            .setShareboardclickCallback { snsPlatform, share_media ->
                if (snsPlatform.mShowWord == "umeng_sharebutton_custom") {
                    Toast.makeText(context, "自定义按钮", Toast.LENGTH_LONG).show()
                } else {
                    val web = UMWeb(url)
                    web.title = title //标题
                    web.setThumb(UMImage(context, img)) //缩略图
                    web.description = shareDesc //描述
                    ShareAction(context)
                        .withMedia(web)
                        .setPlatform(share_media)
                        .setCallback(umShareListener)
                        .share()
                }
            }.open(
                ShareBoardConfig().setTitleVisibility(false)
                    .setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_CIRCULAR)
            )
    }

    private val umShareListener: UMShareListener = object : UMShareListener {
        override fun onStart(platform: SHARE_MEDIA) {
            //分享开始的回调
        }

        override fun onResult(platform: SHARE_MEDIA) {
//            EventBus.getDefault().post(EventBean(11))//分享成功回调
        }

        override fun onError(platform: SHARE_MEDIA, t: Throwable) {}
        override fun onCancel(platform: SHARE_MEDIA) {}
    }

    /**
     * 设置可点击
     * */
    fun setSubmitEnable(context: Context, textView: TextView) {
        textView.isEnabled = true
        textView.setTextColor(ContextCompat.getColor(context, R.color.library_white))
        textView.background =
            DrawableCreator.Builder().setCornersRadius(ConvertUtils.dp2px(22.5f).toFloat())
                .setPressedSolidColor(
                    ContextCompat.getColor(context, R.color.mainColorDark),
                    ContextCompat.getColor(context, R.color.mainColor)
                )
                .build()
    }

    /**
     * 置灰-不可点击
     * */
    fun setSubmitUnable(context: Context, textView: TextView) {
        textView.isEnabled = false
        textView.setTextColor(ContextCompat.getColor(context, R.color.library_text_999))
        textView.background =
            DrawableCreator.Builder().setCornersRadius(ConvertUtils.dp2px(22.5f).toFloat())
                .setSolidColor(ContextCompat.getColor(context, R.color.unable_gray))
                .build()
    }

    fun isInstallByread(packageName: String): Boolean {
        return File("/data/data/$packageName").exists()
    }

    fun gpThreeMap(activity: Activity, w: Double, j: Double) {
        val strings: MutableList<TieBean> = ArrayList<TieBean>()
        if (isInstallByread("com.autonavi.minimap")) {
            strings.add(TieBean("高德地图"))
        }
        if (isInstallByread("com.baidu.BaiduMap")) {
            strings.add(TieBean("百度地图"))
        }
        if (strings.size == 0) {
            DialogUIUtils.showAlert(
                activity,
                "温馨提示",
                "您没有安装第三方的地图",
                "",
                "",
                "确定",
                "",
                true,
                true,
                true,
                object : DialogUIListener() {
                    override fun onPositive() {}
                    override fun onNegative() {}
                }).show()
            return
        }
        DialogUIUtils.showSheet(
            activity,
            strings,
            "取消",
            Gravity.BOTTOM,
            true,
            true,
            object : DialogUIItemListener() {
                override fun onItemClick(text: CharSequence?, position: Int) {
                    if (strings[position].getTitle().equals("百度地图")) {
                        var intent: Intent? = null
                        try {
                            intent = Intent.getIntent(
                                "intent://map/direction?" +
                                        "destination=latlng:" + w + "," + j + "|name:" + "目的地" +
                                        "&mode=driving&" +
                                        "&src=全景#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end"
                            )
                        } catch (e: URISyntaxException) {
                            e.printStackTrace()
                        }
                        activity.startActivity(intent) //启动调用
                    } else {
                        val dlist: DoubleArray = map_bd2hx(w, j)
                        var intent: Intent? = null
                        try {
                            intent = Intent.getIntent(
                                "androidamap://route?sourceApplication=softname&sname=我的位置&dlat=" + dlist[0] +
                                        "&dlon=" + dlist[1] +
                                        "&dname=" + "目的地" + "&dev=0&m=0&t=2"
                            )
                        } catch (e: URISyntaxException) {
                            e.printStackTrace()
                        }
                        activity.startActivity(intent)
                    }
                }

                override fun onBottomBtnClick() {}
            }).show()
    }

    fun map_bd2hx(lat: Double, lon: Double): DoubleArray {
        val tx_lat: Double
        val tx_lon: Double
        val x_pi = 3.14159265358979324
        val x = lon - 0.0065
        val y = lat - 0.006
        val z =
            Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi)
        val theta =
            Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi)
        tx_lon = z * Math.cos(theta)
        tx_lat = z * Math.sin(theta)
        return doubleArrayOf(tx_lat, tx_lon)
    }
}