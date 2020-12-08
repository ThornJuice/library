package com.a360vrsh.pansmartcitystory.viewmodel.user

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.google.gson.Gson

/**
 * 修改手机号ViewModel
 * */
class UpdatePhoneViewModel(application: Application) : BaseViewModel(application) {

    var updateSuccessLiveData = MutableLiveData<PublicSuccessBean>()

    var codeLiveData = MutableLiveData<PublicSuccessBean>()
    var newCodeLiveData = MutableLiveData<PublicSuccessBean>()

    /**
     * 提交
     * */
    fun submit(
        context: Context,
        newPhone: String,
        code: String,
        newCode: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["phone"] = newPhone
        paramMap["sms_code_old"] = code
        paramMap["sms_code_new"] = newCode

        HttpUtil.post(context, UrlConstant.UPDATE_PHONE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: PublicSuccessBean =
                    Gson().fromJson(response, PublicSuccessBean::class.java)
                updateSuccessLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
            }

        }, isShowLoading)
    }

    /**
     * 获取验证码
     * */
    fun getCode(context: Context, phone: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["phone"] = phone
        paramMap["type"] = "change"
        HttpUtil.post(context, UrlConstant.REGISTER_GET_CODE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: PublicSuccessBean =
                    Gson().fromJson(response, PublicSuccessBean::class.java)
                codeLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
            }

        }, isShowLoading)
    }

    /**
     * 新手机号获取验证码
     * */
    fun getNewCode(context: Context, phone: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["phone"] = phone
        paramMap["type"] = "change"
        HttpUtil.post(context, UrlConstant.REGISTER_GET_CODE, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: PublicSuccessBean =
                    Gson().fromJson(response, PublicSuccessBean::class.java)
                newCodeLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {
            }

        }, isShowLoading)
    }
}