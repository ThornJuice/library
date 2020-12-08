package com.a360vrsh.pansmartcitystory.viewmodel.user

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.bean.BaseResponse
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.LoginSuccessBean
import com.google.gson.Gson

/**
 * 验证码登录ViewModel
 * */
class LoginByCodeViewModel(application: Application) : BaseViewModel(application) {
    var loginResponse = MutableLiveData<LoginSuccessBean>()
    var getCodeResponse = MutableLiveData<BaseResponse>()

    /**
     * 登录
     * */
    fun loginByCode(context: Context, phone: String, code: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["phone"] = phone
        paramMap["sms_code"] = code
        HttpUtil.post(context, UrlConstant.LOGIN_BY_CODE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: LoginSuccessBean =
                    Gson().fromJson(response, LoginSuccessBean::class.java)
                loginResponse.value = bean
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
            }

        }, isShowLoading)
    }

    /**
     * 获取验证码
     * */
    fun getCode(context: Context, phone: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["phone"] = phone
        paramMap["type"] = "login"
        HttpUtil.post(context, UrlConstant.GET_CODE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: BaseResponse =
                    Gson().fromJson(response, BaseResponse::class.java)
                getCodeResponse.value = bean
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
            }

        }, isShowLoading)
    }

}