package com.a360vrsh.pansmartcitystory.viewmodel.store

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.PanoListBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.StoreTemplateBean
import com.google.gson.Gson


/**
 * 店铺模板ViewModel
 * */
class StoreTemplateViewModel(application: Application) : BaseViewModel(application) {
    var currentTemplateBeanLiveData = MutableLiveData<StoreTemplateBean>()
    var successLiveData = MutableLiveData<PublicSuccessBean>()


    /**
     * 当前店铺模板
     * */
    fun getCurrentStoreTemplate(
        context: Context,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        HttpUtil.get(
            context, UrlConstant.STORE_TEMPLATE, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: StoreTemplateBean =
                        Gson().fromJson(response, StoreTemplateBean::class.java)
                    currentTemplateBeanLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 选择店铺模板
     * */
    fun chooseStoreTemplate(
        context: Context,
        template: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["template"] = template
        HttpUtil.post(
            context, UrlConstant.CHOOSE_STORE_TEMPLATE, paramMap,
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