package com.a360vrsh.pansmartcitystory.viewmodel.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.CurrentUserBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.StorePanoBean
import com.google.gson.Gson

class StoreViewModel(application: Application) : BaseViewModel(application) {
    var loginOutLiveData = MutableLiveData<PublicSuccessBean>()
    var currentUserLiveData = MutableLiveData<CurrentUserBean>()
    var storePanoLiveData = MutableLiveData<StorePanoBean>()
    /**
     * 个人信息
     * */
    fun getCurrentUser(context: Context, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()

        HttpUtil.get(context, UrlConstant.CURRENT_USER, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: CurrentUserBean =
                    Gson().fromJson(response, CurrentUserBean::class.java)
                currentUserLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
                onErrorLiveData.value = Error(errorInfo, 0)
            }

        }, isShowLoading)
    }

    /**
     * 店铺全景信息
     * */
    fun getStorePano(context: Context, storeId: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        HttpUtil.get(context, UrlConstant.STORE_PANO + storeId, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: StorePanoBean =
                    Gson().fromJson(response, StorePanoBean::class.java)
                storePanoLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
                onErrorLiveData.value = Error(errorInfo, 0)
            }

        }, isShowLoading)
    }

    /**
     * 退出登录
     * */
    fun loginOut(context: Context, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["ticket"] = MMKVUtil.getString("ticket", "")
        HttpUtil.get(context, UrlConstant.LOGIN_OUT, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: PublicSuccessBean =
                    Gson().fromJson(response, PublicSuccessBean::class.java)
                loginOutLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
            }

        }, isShowLoading)
    }
}