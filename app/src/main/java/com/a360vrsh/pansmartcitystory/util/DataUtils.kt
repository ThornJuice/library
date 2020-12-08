package com.a360vrsh.pansmartcitystory.util

import android.content.Context
import com.a360vrsh.library.arouter.ARouterConstant
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.bean.FunctionBean
import com.a360vrsh.pansmartcitystory.bean.TemplateBean

/**
 * @author: wxj
 * @date: 2020/11/12
 * @description: 本地数据工具类
 */
object DataUtils {
    /**
     * 获取首页常用功能数据
     * */
    fun getHomeFunctionData(context: Context): ArrayList<FunctionBean>? {

        val icons = intArrayOf(
            R.mipmap.ic_qrcode,
            R.mipmap.ic_my_pano,
            R.mipmap.ic_store_template,
            R.mipmap.ic_my_goods
        )
        val router = arrayOf(
            ARouterConstant.ACTIVITY_QR_CODE,
            ARouterConstant.ACTIVITY_MY_PANO,
            ARouterConstant.ACTIVITY_STORE_TEMPLATE,
            ARouterConstant.ACTIVITY_GOODS
        )
        val names = context.resources.getStringArray(R.array.home_function)
        val list = ArrayList<FunctionBean>()
        for (i in icons.indices) {
            val functionBean = FunctionBean()
            functionBean.icon = icons[i]
            functionBean.name = names[i]
            functionBean.url = router[i]
            list.add(functionBean)
        }
        return list
    }

    /**
     * 店铺模板数据
     * */
    fun getStoreTemplateData(context: Context): MutableList<TemplateBean>? {
        val images = arrayOf(
            "http://360vrsh.oss-cn-qingdao.aliyuncs.com/store/template/temp1.jpg",
            "http://360vrsh.oss-cn-qingdao.aliyuncs.com/store/template/temp2.png",
            "http://360vrsh.oss-cn-qingdao.aliyuncs.com/store/template/temp3.jpg",
            "http://360vrsh.oss-cn-qingdao.aliyuncs.com/store/template/temp4.jpg"
        )
        val template = arrayOf("0", "1", "3", "4")
        val names = context.resources.getStringArray(R.array.store_template_name)
        val explain = context.resources.getStringArray(R.array.store_template_explain)
        val list = ArrayList<TemplateBean>()
        for (i in images.indices) {
            val bean = TemplateBean()
            bean.image = images[i]
            bean.name = names[i]
            bean.explain = explain[i]
            bean.template = template[i]
            list.add(bean)

        }
        return list
    }

    /**
     * 我的店铺-店铺信息数据设置
     * */
    fun getStoreFunction(context: Context): ArrayList<FunctionBean>? {
        val names = context.resources.getStringArray(R.array.store_function)
        val icons = intArrayOf(
            R.mipmap.ic_qrcode,
            R.mipmap.ic_my_pano,
            R.mipmap.ic_store_template,
            R.mipmap.ic_my_goods,
            R.mipmap.ic_my_pano,
            R.mipmap.ic_store_template,
            R.mipmap.ic_my_goods
        )
        //路由url配置
        val urls = arrayOf(
            ARouterConstant.ACTIVITY_STORE_SETTING,//店铺设置
            ARouterConstant.ACTIVITY_ADD_BASE_STORE_INFO,//基本信息
            ARouterConstant.ACTIVITY_STORE_TEMPLATE,//店铺模板
            ARouterConstant.ACTIVITY_USER_ACCOUNT_SAFE,//账户安全
            ARouterConstant.ACTIVITY_USER_DIY_SHARE,//自定义分享
            ARouterConstant.ACTIVITY_MY_PANO,//我的全景
            ARouterConstant.ACTIVITY_GOODS//我的商品
        )

        val list = ArrayList<FunctionBean>()
        for (i in names.indices) {
            val functionBean = FunctionBean()
            functionBean.icon = icons[i]
            functionBean.name = names[i]
            functionBean.url = urls[i]
            list.add(functionBean)
        }
        return list
    }

    /**
     * 我的店铺-其他功能数据设置
     * */
    fun getStoreOtherFunction(context: Context): ArrayList<FunctionBean>? {
        val names = context.resources.getStringArray(R.array.other_function)
        val icons = intArrayOf(
            R.mipmap.ic_qrcode,
            R.mipmap.ic_my_pano,
            R.mipmap.ic_store_template
        )

        val list = ArrayList<FunctionBean>()
        for (i in names.indices) {
            val functionBean = FunctionBean()
            functionBean.icon = icons[i]
            functionBean.name = names[i]
            functionBean.url = ""
            list.add(functionBean)
        }
        return list
    }

    fun getBaiduImages(): List<String> {
        return arrayListOf(
            "https://ores.360vrsh.com/store/jingpin.jpg",
            "https://ores.360vrsh.com/store/putong.jpg"
        )
    }

    fun getBaiduRules(): String {
        return "1使用PTGui拼接图片；\n" +
                "2保证图片清晰,曝光正常；\n" +
                "3全景图片拼接流畅,衔接紧凑；\n" +
                "4布局合理,补全天空,修补地面；\n" +
                "5人脸、车牌等隐私信息需模糊处理；\n" +
                "6每张图片需正确填写场景名称；\n" +
                "7不得涉及黄赌毒,国家军事等非法内容；\n" +
                "8图片中不得存在重影,鬼影(人物一半)；\n" +
                "9不得存在其他logo和水印；\n" +
                "10图片须补地处理，不得有地标logo；\n" +
                "11成图要求: 2:1比例,不得低于8200x4100像素；\n" +
                "12每个商家全景图片数量限制3-100张；\n" +
                "13场景命名规则：不允许出现特殊符号,括号请用英文括号。"

    }
}