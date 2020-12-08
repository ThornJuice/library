package com.a360vrsh.pansmartcitystory.viewmodel.order

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.FoodOrderDetailBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.google.gson.Gson


/**
 * 美食订单详情ViewModel
 * */
class FoodOrderDetailViewModel(application: Application) : BaseViewModel(application) {
    var orderDetailLiveData = MutableLiveData<FoodOrderDetailBean>()
    var operationSuccessLiveData = MutableLiveData<PublicSuccessBean>()

    /**
     * 订单详情
     * */
    fun getOrderDetail(
        context: Context,
        orderId: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        HttpUtil.get(
            context, UrlConstant.ORDER_DETAIL + orderId, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {
                    val bean: FoodOrderDetailBean =
                        Gson().fromJson(response, FoodOrderDetailBean::class.java)
                    orderDetailLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     *状态:cancel=取消订单,receipt=收货,refuse=拒绝接单,accept=接单,ship=发货,check=核销
     * */
    fun orderUpdate(
        context: Context,
        orderId: String,
        status: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["id"] = orderId
        paramMap["status"] = status
        HttpUtil.put(
            context, UrlConstant.ORDER_UPDATE + orderId + "/update", paramMap,
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
}