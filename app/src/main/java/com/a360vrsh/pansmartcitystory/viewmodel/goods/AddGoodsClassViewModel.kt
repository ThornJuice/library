package com.a360vrsh.pansmartcitystory.viewmodel.goods

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.GoodsClassBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.google.gson.Gson


/**
 * 添加/编辑商品分类ViewModel
 * */
class AddGoodsClassViewModel(application: Application) : BaseViewModel(application) {
    var goodsClassLiveData = MutableLiveData<GoodsClassBean>()
    var addSuccessLiveData = MutableLiveData<PublicSuccessBean>()

    /**
     * 添加商品分类
     * */
    fun addGoodsClass(
        context: Context,

        store_id: String,
        name: String,
        weight: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = store_id
        paramMap["name"] = name
        paramMap["weight"] = weight
        HttpUtil.post(
            context, UrlConstant.ADD_GOODS_CLASS, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    addSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 删除商品分类
     * */
    fun deleteGoodsClass(
        context: Context,
        classId: String,
        store_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = store_id
        HttpUtil.delete(
            context, UrlConstant.OPERATION_GOODS_CLASS + classId, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    addSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 编辑商品分类
     * */
    fun editGoodsClass(
        context: Context,
        classId: String,
        store_id: String,
        name: String,
        weight: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = store_id
        paramMap["name"] = name
        paramMap["weight"] = weight
        HttpUtil.put(
            context, UrlConstant.OPERATION_GOODS_CLASS + classId, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    addSuccessLiveData.value = bean
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
}