package com.a360vrsh.pansmartcitystory.viewmodel.user

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.LoginSuccessBean
import com.google.gson.Gson

/**
 * 登录ViewModel
 * */
class LoginViewModel(application: Application) : BaseViewModel(application) {
    var loginBean = MutableLiveData<LoginSuccessBean>()

    /**
     * 登录
     * */
    fun login(context: Context, phone: String?, pwd: String?, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String?>()
        paramMap["uname"] = phone
        paramMap["pwd"] = pwd
        paramMap["type"] = "account"
        HttpUtil.post(context, UrlConstant.LOGIN_BY_PWD, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: LoginSuccessBean =
                    Gson().fromJson(response, LoginSuccessBean::class.java)
                loginBean.value = bean
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
            }

        }, isShowLoading)
    }


}