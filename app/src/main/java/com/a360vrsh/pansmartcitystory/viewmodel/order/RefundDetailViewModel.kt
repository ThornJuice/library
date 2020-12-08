package com.a360vrsh.pansmartcitystory.viewmodel.order

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.RefundDetailBean
import com.google.gson.Gson


/**
 * 售后详情ViewModel
 * */
class RefundDetailViewModel(application: Application) : BaseViewModel(application) {
    var refundDetailLiveData = MutableLiveData<RefundDetailBean>()
    var operationSuccessLiveData = MutableLiveData<PublicSuccessBean>()
    var deleteSuccessLiveData = MutableLiveData<PublicSuccessBean>()

    /**
     * 售后详情
     * */
    fun getRefundDetail(
        context: Context,
        orderId: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        HttpUtil.get(
            context, UrlConstant.REFUND_DETAIL + orderId, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {
                    val bean: RefundDetailBean =
                        Gson().fromJson(response, RefundDetailBean::class.java)
                    refundDetailLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

}