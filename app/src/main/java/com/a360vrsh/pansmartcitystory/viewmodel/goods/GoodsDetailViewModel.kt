package com.a360vrsh.pansmartcitystory.viewmodel.goods

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.TicketInfoBean
import com.a360vrsh.pansmartcitystory.bean.TicketListBean
import com.google.gson.Gson


/**
 * 商品详情ViewModel
 * */
class GoodsDetailViewModel(application: Application) : BaseViewModel(application) {
    var goodsDetailLiveData = MutableLiveData<GoodsDetailBean>()
    var ticketListBeanLiveData = MutableLiveData<TicketListBean>()
    var ticketInfoBeanLiveData = MutableLiveData<TicketInfoBean>()
    var operationSuccessLiveData = MutableLiveData<PublicSuccessBean>()
    var deleteSuccessLiveData = MutableLiveData<PublicSuccessBean>()
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
     * 门票列表
     * */
    fun getTicketList(
        context: Context,
        goods_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        HttpUtil.get(
            context, UrlConstant.TICKET_LIST + goods_id + "/list", paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: TicketListBean =
                        Gson().fromJson(response, TicketListBean::class.java)
                    ticketListBeanLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 门票详情
     * */
    fun getTicketInfo(
        context: Context,
        ticket_id: String,
        goods_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["ticket_id"] = ticket_id
        paramMap["goods_id"] = goods_id
        HttpUtil.get(
            context, UrlConstant.TICKET_INFO, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: TicketInfoBean =
                        Gson().fromJson(response, TicketInfoBean::class.java)
                    ticketInfoBeanLiveData.value = bean
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
                    operationSuccessLiveData.value = bean
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
                    operationSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 删除商品
     * */
    fun goodsDelete(
        context: Context,
        goods_id: String,
        store_id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["store_id"] = store_id
        HttpUtil.delete(
            context, UrlConstant.GOODS_DELETE + goods_id, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    deleteSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }
}