package com.a360vrsh.pansmartcitystory.viewmodel.market

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.RedPacketListBean
import com.google.gson.Gson

/**
 *红包管理ViewModel
 * */
class RedPacketListViewModel(application: Application) : BaseViewModel(application) {
    var redPacketListLiveData = MutableLiveData<RedPacketListBean>()


    /**
     * 红包列表
     * */
    fun getDataList(
        context: Context,
        page: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()
        paramMap["pageSize"] = "10"
        paramMap["page"] = page

        HttpUtil.get(
            context, UrlConstant.RED_PACKET_LIST, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: RedPacketListBean =
                        Gson().fromJson(response, RedPacketListBean::class.java)
                    redPacketListLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }
}