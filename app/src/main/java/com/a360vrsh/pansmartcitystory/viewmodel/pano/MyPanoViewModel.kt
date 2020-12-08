package com.a360vrsh.pansmartcitystory.viewmodel.pano

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.PanoListBean
import com.google.gson.Gson


/**
 * 我的全景ViewModel
 * */
class MyPanoViewModel(application: Application) : BaseViewModel(application) {
    var panoBeanLiveData = MutableLiveData<PanoListBean>()


    /**
     * 我的全景
     * */
    fun getPano(
        context: Context,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        HttpUtil.get(
            context, UrlConstant.MY_PANO, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PanoListBean =
                        Gson().fromJson(response, PanoListBean::class.java)
                    panoBeanLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

}