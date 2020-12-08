package com.a360vrsh.pansmartcitystory.viewmodel.order

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.EvaluateListBean
import com.google.gson.Gson

class EvaluateViewModel(application: Application) : BaseViewModel(application) {
    var evaluateListLiveData = MutableLiveData<EvaluateListBean>()

    /**
     * 评价列表
     * @param key = "全部"
     * */
    fun getEvaluateList(
        context: Context,
        storeId: String,
        page: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String?>()
        paramMap["key"] = "全部"
        paramMap["store_id"] = storeId
        paramMap["pageSize"] = "10"
        paramMap["page"] = page

        HttpUtil.get(
            context, UrlConstant.EVALUATE_LIST, paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: EvaluateListBean =
                        Gson().fromJson(response, EvaluateListBean::class.java)
                    evaluateListLiveData.value = bean

                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }

}