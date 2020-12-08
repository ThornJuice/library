package com.a360vrsh.pansmartcitystory.viewmodel.store

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.StoreInfoBean
import com.google.gson.Gson


/**
 * 店铺设置ViewModel - 美食 旅游 其他
 * */
class StoreSettingViewModel(application: Application) : BaseViewModel(application) {
    var saveSuccessLiveData = MutableLiveData<PublicSuccessBean>()


    /**
     * 保存行业信息
     * */
    fun saveIndustry(context: Context, id: String, paramMap:HashMap<String, String?>,isShowLoading: Boolean) {

        HttpUtil.put(
            context, UrlConstant.SAVE_INDUSTRY + id + "/industry", paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    saveSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

    /**
     * 提交审核
     * type : is_open=开门营业,is_rest=关门休息,apply_audit=申请审核,apply_verify=申请认证
     * */
    fun applyAudit(context: Context, storeId: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()
        paramMap["id"] = storeId
        paramMap["type"] = "apply_audit"
        HttpUtil.put(
            context, UrlConstant.STORE_OPERATION + storeId + "/operation", paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    saveSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }
}