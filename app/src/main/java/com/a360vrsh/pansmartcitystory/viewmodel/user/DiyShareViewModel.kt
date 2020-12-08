package com.a360vrsh.pansmartcitystory.viewmodel.user

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.a360vrsh.library.http.HttpListener
import com.a360vrsh.library.http.HttpUtil
import com.a360vrsh.library.util.UrlConstant
import com.a360vrsh.pansmartcitystory.base.BaseViewModel
import com.a360vrsh.pansmartcitystory.bean.DiyShareBean
import com.a360vrsh.pansmartcitystory.bean.PublicSuccessBean
import com.a360vrsh.pansmartcitystory.bean.UpLoadImageSuccessBean
import com.google.gson.Gson
import java.io.File

/**
 *自定义分享ViewModel
 * */
class DiyShareViewModel(application: Application) : BaseViewModel(application) {
    var diyShareLiveData = MutableLiveData<DiyShareBean>()
    var upLoadSuccessLiveData = MutableLiveData<UpLoadImageSuccessBean>()
    var saveSuccessLiveData = MutableLiveData<PublicSuccessBean>()
    /**
     * 自定义分享数据
     * */
    fun getData(context: Context, storeId: String, isShowLoading: Boolean) {
        val paramMap = HashMap<String, String>()

        HttpUtil.get(
            context,
            UrlConstant.DIY_SHARE + storeId + "/share",
            paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {
                    val bean: DiyShareBean =
                        Gson().fromJson(response, DiyShareBean::class.java)
                    diyShareLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                }

            }, isShowLoading
        )
    }

    /**
     * 图片上传
     * */
    fun upLoadImage(
        context: Context,
        file: File,
        isShowLoading: Boolean
    ) {

        HttpUtil.upLoad(
            context, "store_share", file,
            object : HttpListener {
                override fun onSucceed(response: String) {

                    val bean: UpLoadImageSuccessBean =
                        Gson().fromJson(response, UpLoadImageSuccessBean::class.java)
                    upLoadSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                    onErrorLiveData.value = Error(errorInfo, 0)
                }

            },
            isShowLoading
        )
    }
    /**
     * 提交
     * */
    fun submit(
        context: Context,
        storeId: String,
        title: String,
        content: String,
        image: String,
        isShowLoading: Boolean
    ) {
        val paramMap = HashMap<String, String>()
        paramMap["title"] = title
        paramMap["content"] = content
        paramMap["image"] = image
        HttpUtil.put(
            context,
            UrlConstant.DIY_SHARE + storeId + "/share",
            paramMap,
            object : HttpListener {
                override fun onSucceed(response: String) {
                    val bean: PublicSuccessBean =
                        Gson().fromJson(response, PublicSuccessBean::class.java)
                    saveSuccessLiveData.value = bean
                }

                override fun onFailed(errorInfo: String) {
                }

            }, isShowLoading
        )
    }


}