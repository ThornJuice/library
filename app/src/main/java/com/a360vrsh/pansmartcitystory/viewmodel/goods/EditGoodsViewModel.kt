package com.a360vrsh.pansmartcitystory.viewmodel.goods

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.GoodsClassBean
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.UpLoadImageSuccessBean
import com.google.gson.Gson
import java.io.File


/**
 * 添加/编辑商品ViewModel
 * */
class EditGoodsViewModel(application: Application) : BaseViewModel(application) {
    var goodsDetailLiveData = MutableLiveData<GoodsDetailBean>()
    var goodsClassLiveData = MutableLiveData<GoodsClassBean>()
    var upLoadSuccessLiveData = MutableLiveData<UpLoadImageSuccessBean>()
    var editSuccessLiveData = MutableLiveData<PublicSuccessBean>()

    /**
     * 商品详情
     * */
    fun getGoodsDetail(
        context: Context,
        goods_id: String,
        store_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = store_id
        HttpUtil.get(
            context, UrlConstant.GOODS_DETAIL + goods_id, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: GoodsDetailBean =
                        Gson().fromJson(response, GoodsDetailBean::class.java)
                    goodsDetailLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 商品分类
     * */
    fun getGoodsClass(
        context: Context,
        store_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = store_id
        HttpUtil.get(
            context, UrlConstant.GOODS_CLASS, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: GoodsClassBean =
                        Gson().fromJson(response, GoodsClassBean::class.java)
                    goodsClassLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 添加商品
     * */
    fun addGoods(
        context: Context,
        paramMap: HashMap<String, String?>,
        isShowLoading: Boolean
    ) {
        HttpUtil.post(
            context, UrlConstant.GOODS_ADD, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    editSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 编辑商品
     * */
    fun editGoods(
        context: Context,
        goods_id: String,
        paramMap: HashMap<String, String?>,
        isShowLoading: Boolean
    ) {

        HttpUtil.put(
            context, UrlConstant.EDIT_GOODS + goods_id, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    editSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 图片上传
     * */
    fun upLoadImage(
        context: Context,
        file: File,
        isShowLoading: Boolean
    ) {

        HttpUtil.upLoad(
            context, "store_avatar", file,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: UpLoadImageSuccessBean =
                        Gson().fromJson(response, UpLoadImageSuccessBean::class.java)
                    upLoadSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

}