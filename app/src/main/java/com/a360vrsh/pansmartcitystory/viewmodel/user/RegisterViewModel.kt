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
import com.google.gson.Gson

/**
 * 注册ViewModel
 * */
class RegisterViewModel(application: Application) : BaseViewModel(application) {
    var codeResponse = MutableLiveData<BaseResponse>()
    var registerResponse = MutableLiveData<BaseResponse>()

    /**
     * 获取验证码
     * */
    fun getCode(context: Context, phone: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["phone"] = phone
        paramMap["type"] = "register"
        HttpUtil.post(context, UrlConstant.REGISTER_GET_CODE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: BaseResponse =
                    Gson().fromJson(response, BaseResponse::class.java)
                codeResponse.value = bean
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
            }

        }, isShowLoading)
    }

    fun register(
        context: Context,
        phone: String,
        sms_code: String,
        password: String,
        confirm: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["phone"] = phone
        paramMap["sms_code"] = sms_code
        paramMap["password"] = password
        paramMap["password_confirmation"] = confirm
        HttpUtil.post(context, UrlConstant.REGISTER, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: BaseResponse =
                    Gson().fromJson(response, BaseResponse::class.java)
                registerResponse.value = bean
            }

            override fun onFailed(errorInfo: String) {
                LogUtil.e("RxHttpResponse", "errorInfo:" + errorInfo)
            }

        }, isShowLoading)
    }

}