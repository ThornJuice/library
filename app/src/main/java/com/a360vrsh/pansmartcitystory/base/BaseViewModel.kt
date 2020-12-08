package com.a360vrsh.pansmartcitystory.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.*
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.bean.CheckTicketBean
import com.a360vrsh.pansmartcitystory.bean.StoreInfoBean
import com.google.gson.Gson
import com.rxjava.rxlife.ScopeViewModel
import io.reactivex.rxjava3.functions.Consumer
import rxhttp.RxHttp
import java.util.*

/**
 * @author: wxj
 * @date: 2020/9/12
 * @description:
 */
open class BaseViewModel(application: Application) : ScopeViewModel(application) {
    var checkTicketLiveData = MutableLiveData<CheckTicketBean>()//checkTicket
    var storeInfoLiveData = MutableLiveData<StoreInfoBean>()//店铺信息
    var onErrorLiveData = MutableLiveData<Error<String>>()//错误信息

    open operator fun get(
        context: Context?,
        url: String,
        paramMap: HashMap<String, String>,
        callBack: HttpCallBack
    ) {
        RxHttp.get(url)
            .addAll(paramMap)
            .asString()
            .doFinally {

            }
            .subscribe(
                Consumer { s: String ->
                    LogUtil.e("RxHttpResponse", "response" + s)
                    callBack.onSucceed(s)
                },
                OnError { errorInfo: ErrorInfo ->
                    LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo.errorMsg)
                    callBack.onFailed(errorInfo.errorMsg)
                }
            )
    }

    /**
     * checkTicket
     * */


    fun checkTicket(context: Context, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["ticket"] = MMKVUtil.getString("ticket","")
        HttpUtil.post(context, UrlConstant.CHECK_TICKET, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {

                val bean: CheckTicketBean =
                    Gson().fromJson(response, CheckTicketBean::class.java)
                checkTicketLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
                onErrorLiveData.value = Error(errorInfo, 0)
            }

        }, isShowLoading)
    }

    /**
     * 获取店铺信息
     * */
    fun getStoreInfo(context: Context, storeId: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        HttpUtil.get(
            context, UrlConstant.STORE_INFO + storeId, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: StoreInfoBean =
                        Gson().fromJson(response, StoreInfoBean::class.java)
                    storeInfoLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            }, isShowLoading
        )
    }

    data class Error<out T>(
        val msg: T?,
        val what: Int?
    )
}