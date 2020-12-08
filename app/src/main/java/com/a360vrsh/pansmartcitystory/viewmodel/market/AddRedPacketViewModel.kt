package com.a360vrsh.pansmartcitystory.viewmodel.market

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.RedPacketListBean
import com.google.gson.Gson

/**
 *发红包ViewModel
 * */
class AddRedPacketViewModel(application: Application) : BaseViewModel(application) {
    var successLiveData = MutableLiveData<PublicSuccessBean>()


    /**
     * 发红包
     * */
    fun submit(
        context: Context,
        money: String,
        type: String,
        number: String,
        slogan: String,
        scene: String,
        cover_img: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()
        paramMap["money"] = money
        paramMap["type"] = type
        paramMap["number"] = number
        paramMap["slogan"] = slogan
        paramMap["scene"] = scene
        paramMap["cover_img"] = cover_img
        HttpUtil.post(
            context, UrlConstant.RED_PACKET_ADD, paramMap,
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