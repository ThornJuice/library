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
 * 修改密码ViewModel
 * */
class UpdatePwdViewModel(application: Application) : BaseViewModel(application) {
    var updateSuccessLiveData = MutableLiveData<PublicSuccessBean>()

    /**
     * 提交
     * */
    fun submit(
        context: Context,
        pwd: String,
        newPwd: String,
        newPwdConfirm: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["password_old"] = pwd
        paramMap["password"] = newPwd
        paramMap["password_confirmation"] = newPwdConfirm
        HttpUtil.post(context, UrlConstant.UPDATE_PWD, paramMap, object : HttpListener {
            override fun onSucceed(response: String) {
                val bean: PublicSuccessBean =
                    Gson().fromJson(response, PublicSuccessBean::class.java)
                updateSuccessLiveData.value = bean
            }

            override fun onFailed(errorInfo: String) {

            }

        }, isShowLoading)
    }
}