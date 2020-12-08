package com.a360vrsh.pansmartcitystory.viewmodel.market

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.RedPacketDetailBean
import com.a360vrsh.pansmartcitystory.bean.RedPacketReceiveListBean
import com.google.gson.Gson

/**
 *红包详情ViewModel
 * */
class RedPacketDetailViewModel(application: Application) : BaseViewModel(application) {
    var redPacketDetailLiveData = MutableLiveData<RedPacketDetailBean>()
    var receiveListLiveData = MutableLiveData<RedPacketReceiveListBean>()
    var deleteSuccessLiveData = MutableLiveData<PublicSuccessBean>()

    /**
     * 红包详情
     * */
    fun getDetail(
        context: Context,
        id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()

        HttpUtil.get(
            context, UrlConstant.RED_PACKET_DETAIL + id, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: RedPacketDetailBean =
                        Gson().fromJson(response, RedPacketDetailBean::class.java)
                    redPacketDetailLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 红包领取记录
     * */
    fun getReceiveList(
        context: Context,
        id: String,
        page: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()
        paramMap["pageSize"] = "10"
        paramMap["page"] = page

        HttpUtil.get(
            context, UrlConstant.RED_PACKET_RECEIVE + id + "/receive", paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: RedPacketReceiveListBean =
                        Gson().fromJson(response, RedPacketReceiveListBean::class.java)
                    receiveListLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 删除红包
     * */
    fun deleteRedPacket(
        context: Context,
        id: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()
        paramMap["type"] = "delete"
        HttpUtil.post(
            context, UrlConstant.RED_PACKET_DELETE + id + "/operation", paramMap,
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