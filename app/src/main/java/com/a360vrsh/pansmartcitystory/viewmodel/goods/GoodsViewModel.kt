package com.a360vrsh.pansmartcitystory.viewmodel.goods

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.GoodsListBean
import com.a360vrsh.pansmartcitystory.bean.GoodsClassBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.google.gson.Gson


/**
 * 商品ViewModel
 * */
class GoodsViewModel(application: Application) : BaseViewModel(application) {
    var goodsClassLiveData = MutableLiveData<GoodsClassBean>()
    var goodsListLiveData = MutableLiveData<GoodsListBean>()
    var successLiveData = MutableLiveData<PublicSuccessBean>()
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
     * 商品列表
     * @param status_audit 审核状态:0=编辑中,1=提交审核(审核中),2=审核通过,3=审核拒绝 4审核中
     * @param status_shelf 上架状态:1=上架,2=下架
     * */
    fun getGoodsList(
        context: Context,
        store_id: String,
        class_id: String?,
        status_audit: String?,
        status_shelf: String?,
        page: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = store_id
        paramMap["pageSize"] = "10"
        paramMap["page"] = page
        if (!class_id.isNullOrEmpty()) {
            paramMap["class_id"] = class_id
        }

        if (!status_audit.isNullOrEmpty()) {
            paramMap["status_audit"] = status_audit
        }
        if (!status_shelf.isNullOrEmpty()) {
            paramMap["status_shelf"] = status_shelf
        }
        HttpUtil.get(
            context, UrlConstant.GOODS_LIST, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: GoodsListBean =
                        Gson().fromJson(response, GoodsListBean::class.java)
                    goodsListLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }


    /**
     * 商品上架
     * */
    fun goodsStart(
        context: Context,
        goods_id: String,
        store_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["goods_id"] = goods_id
        paramMap["store_id"] = store_id
        HttpUtil.put(
            context, UrlConstant.GOODS_START, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    successLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 商品下架
     * */
    fun goodsStop(
        context: Context,
        goods_id: String,
        store_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["goods_id"] = goods_id
        paramMap["store_id"] = store_id
        HttpUtil.put(
            context, UrlConstant.GOODS_STOP, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    successLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }
}