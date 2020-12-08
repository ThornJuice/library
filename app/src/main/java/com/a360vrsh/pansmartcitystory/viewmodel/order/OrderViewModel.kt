package com.a360vrsh.pansmartcitystory.viewmodel.order

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.OrderListBean
import com.google.gson.Gson

class OrderViewModel(application: Application) : BaseViewModel(application) {
    var orderListLiveData = MutableLiveData<OrderListBean>()

    /**
     * 订单列表
     * @param status_audit 审核状态:0=编辑中,1=提交审核(审核中),2=审核通过,3=审核拒绝 4审核中
     * @param status_shelf 上架状态:1=上架,2=下架
     * */
    fun getOrderList(
        context: Context,
        status: String?,
        page: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()
        paramMap["order_type"] = "all"
        paramMap["status"] = status
        paramMap["pageSize"] = "10"
        paramMap["page"] = page

        HttpUtil.get(
            context, UrlConstant.ORDER_LIST, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: OrderListBean =
                        Gson().fromJson(response, OrderListBean::class.java)
                    orderListLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

}