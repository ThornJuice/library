package com.a360vrsh.pansmartcitystory.viewmodel.order

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.RefundListBean
import com.google.gson.Gson

class RefundViewModel(application: Application) : BaseViewModel(application) {
    var refundListLiveData = MutableLiveData<RefundListBean>()

    /**
     * 售后列表
     * @param status_audit 订单状态:all=全部,under_review=审核中,review_success=同意退款,review_fail=拒绝退款
     * */
    fun getRefundList(
        context: Context,
        status: String?,
        page: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()
        paramMap["status"] = status
        paramMap["pageSize"] = "10"
        paramMap["page"] = page

        HttpUtil.get(
            context, UrlConstant.REFUND_LIST, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: RefundListBean =
                        Gson().fromJson(response, RefundListBean::class.java)
                    refundListLiveData.value = bean

                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

}